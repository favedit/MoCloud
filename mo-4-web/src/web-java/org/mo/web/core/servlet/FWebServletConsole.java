package org.mo.web.core.servlet;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FMap;
import org.mo.com.lang.IRelease;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.FClass;
import org.mo.com.lang.reflect.FMethod;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.message.FFatalMessage;
import org.mo.core.aop.RAop;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.bind.IBindConsole;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.container.IWebContainerConsole;
import org.mo.web.core.container.common.FWebContainerItem;
import org.mo.web.core.servlet.common.FServletDescriptor;
import org.mo.web.core.servlet.common.FServletMethodDescriptor;
import org.mo.web.core.servlet.common.FWebServlet;
import org.mo.web.core.servlet.common.FWebServletMap;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.core.servlet.common.XAopServlet;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>网络处理控制台。</T>
// <P>根据访问的地址，对页面处理执行分发处理。</P>
//============================================================
public class FWebServletConsole
      implements
         IWebServletConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FWebServletConsole.class);

   // 绑定控制台
   @ALink
   protected IBindConsole _bindConsole;

   // 数据控制台
   @ALink
   protected IDatabaseConsole _databaseConsole;

   // 表单控制台
   @ALink
   protected IWebContainerConsole _formConsole;

   // 传送数据时使用编码方式
   @AProperty
   protected String _encoding;

   // 描述器集合
   @SuppressWarnings("rawtypes")
   protected FMap<Class, FServletDescriptor> _descriptors = new FMap<Class, FServletDescriptor>(Class.class, FServletDescriptor.class);

   // 处理集合
   protected FWebServletMap _servlets = new FWebServletMap();

   //============================================================
   // <T>获得编码。</T>
   //
   // @return 编码
   //============================================================
   public String encoding(){
      return _encoding;
   }

   //============================================================
   // <T>根据名称查找函数。</T>
   //
   // @param clazz 类名称
   // @param name 函数名称
   // @return 函数
   //============================================================
   public FServletMethodDescriptor findMethod(FClass<?> clazz,
                                              String name){
      FServletDescriptor descriptor = _descriptors.get(clazz.nativeObject(), null);
      if(descriptor == null){
         descriptor = new FServletDescriptor();
         _descriptors.set(clazz.nativeObject(), descriptor);
      }
      // Find Method Descriptor 
      name = (name != null) ? name.toLowerCase() : "process";
      FServletMethodDescriptor methodDsp = null;
      if(descriptor.contains(name)){
         methodDsp = descriptor.find(name);
      }else{
         for(FMethod method : clazz.methods(false)){
            if(name.equalsIgnoreCase(method.name())){
               methodDsp = new FServletMethodDescriptor(method.nativeObject());
               break;
            }
         }
         descriptor.push(name, methodDsp);
      }
      return methodDsp;
   }

   //============================================================
   // <T>根据名称查找处理。</T>
   //
   // @param name 名称
   // @return 处理
   //============================================================
   public FWebServlet findServlet(String name){
      name = RString.nvl(name).toLowerCase();
      FWebServlet servlet = _servlets.get(name, null);
      if(servlet == null){
         XAopServlet xservlet = RAop.configConsole().findNode(XAopServlet.NAME, name);
         if(xservlet != null){
            servlet = new FWebServlet();
            servlet.construct(xservlet);
            _servlets.set(name, servlet);
         }
      }
      return servlet;
   }

   //============================================================
   // <T>根据名称查找实例。</T>
   //
   // @param name 名称
   // @return 实例
   //============================================================
   @Override
   public Object findInstance(String name){
      Object instance = null;
      FWebServlet servlet = findServlet(name);
      if(null != servlet){
         String face = servlet.face();
         if(!RString.isBlank(face)){
            instance = RAop.find(face);
            if(instance == null){
               _logger.debug(this, "execute", "Can't find servlet [face:{1}]", face);
            }
         }
      }
      if(_logger.debugAble()){
         _logger.debug(this, "execute", "Find servlet [{1}]->{2}]", name, instance);
      }
      return instance;
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param name 名称
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void execute(String name,
                       IWebContext context,
                       IWebServletRequest request,
                       IWebServletResponse response){
      Throwable throwable = null;
      FWebServlet servlet = findServlet(name);
      if(servlet == null){
         _logger.warn(this, "execute", "Can't find servlet config [{1} -> {2}]", name, servlet);
         return;
      }
      Object instance = findInstance(name);
      if(instance == null){
         _logger.warn(this, "execute", "Can't find servlet instance [{1} -> {2}]", name, instance);
         return;
      }
      // find invoke method
      String action = RString.nvl(context.parameter("do"), "process");
      FServletMethodDescriptor methodDsp = findMethod(servlet.faceClass(), action);
      if(methodDsp == null){
         _logger.warn(this, "execute", "Can't find method in servlet. [{1}.{2}]", instance, action);
         return;
      }
      _logger.debug(this, "execute", "Process servlet. {1}:{2}->{3}", name, instance, action);
      // Invoke method
      Class<?>[] types = methodDsp.types();
      AContainer[] aforms = methodDsp.forms();
      int count = types.length;
      FWebContainerItem[] forms = new FWebContainerItem[count];
      Object[] params = new Object[count];
      FLogicContext logicContext = new FLogicContext(_databaseConsole);
      try{
         for(int n = 0; n < count; n++){
            Class<?> type = types[n];
            Object value = null;
            if(type == IWebContext.class){
               value = context;
            }else if(type == ISqlContext.class){
               value = logicContext;
            }else if(type == ILogicContext.class){
               value = logicContext;
            }else if(type == IWebServletRequest.class){
               value = request;
            }else if(type == IWebServletResponse.class){
               value = response;
            }else if(type.isInterface()){
               value = RAop.find(type);
            }else if(aforms[n] != null){
               forms[n] = _formConsole.findContainer(context, aforms[n], type);
               value = forms[n].container();
               context.define(aforms[n].name(), value);
            }else{
               throw new FFatalError("Build param error. {1}", type);
            }
            params[n] = value;
         }
         methodDsp.invoke(instance, params);
      }catch(Exception t){
         throwable = t;
         context.messages().push(new FFatalMessage(t));
      }finally{
         // 释放参数
         if(null != params){
            for(Object param : params){
               if((param != logicContext) && (param instanceof IRelease)){
                  try{
                     ((IRelease)param).release();
                  }catch(Exception e){
                     throwable = e;
                  }
               }
            }
         }
         // 释放数据库链接
         if(logicContext != null){
            if(throwable == null){
               logicContext.release();
            }else{
               logicContext.rollback();
            }
            try{
               logicContext.close();
            }catch(Exception e){
               throw new FFatalError(e);
            }
            logicContext = null;
         }
      }
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param uri 地址
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void executeUri(String uri,
                          IWebContext context,
                          IWebServletRequest request,
                          IWebServletResponse response){
      // 分解地址
      int index = uri.indexOf('/', 1);
      if(index == -1){
         return;
      }
      String name = uri.substring(0, index);
      String parameter = uri.substring(index);
      context.parameters().set(IWebServletConstant.PARAMETER_URI, parameter);
      // 执行处理
      execute(name, context, request, response);
   }
}

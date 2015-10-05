package org.mo.web.core.action;

import java.lang.reflect.Method;
import java.net.URL;
import java.sql.SQLException;
import org.mo.com.data.ASqlConnect;
import org.mo.com.data.RSql;
import org.mo.com.io.RFile;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FError;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.IRelease;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.message.FErrorMessage;
import org.mo.com.message.FFatalMessage;
import org.mo.com.message.FMessages;
import org.mo.com.message.FWarnMessage;
import org.mo.com.xml.FXmlDocument;
import org.mo.core.aop.RAop;
import org.mo.core.aop.container.FAopComponent;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.bind.IBindConsole;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.core.action.common.FActionDescriptor;
import org.mo.web.core.action.common.FActionDescriptorClassMap;
import org.mo.web.core.action.common.FActionMethodDescriptor;
import org.mo.web.core.action.common.FPageConfigClassMap;
import org.mo.web.core.action.common.FWebAction;
import org.mo.web.core.action.common.FWebActions;
import org.mo.web.core.action.common.RAction;
import org.mo.web.core.action.common.TAction;
import org.mo.web.core.action.common.XAopAction;
import org.mo.web.core.action.common.XAopActions;
import org.mo.web.core.action.common.XAopActionsCollection;
import org.mo.web.core.action.servlet.IActionConstant;
import org.mo.web.core.common.IWebAccessRule;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.container.IWebContainerConsole;
import org.mo.web.core.container.common.FWebContainerItem;
import org.mo.web.core.face.AWebAuthority;
import org.mo.web.core.face.AWebRole;
import org.mo.web.core.message.IWebMessageConsole;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.FPageConfig;
import org.mo.web.protocol.context.FWebContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>页面命令处理控制台。</T>
// <P>根据访问的地址，对地址执行分发处理。</P>
//============================================================
public class FActionConsole
      implements
         IActionConsole
{
   // 日志接口
   private static ILogger _logger = RLogger.find(FActionConsole.class);

   // 数据环境类名称
   @AProperty(name = "logic_context")
   protected String _logicContextClassName;

   // 逻辑环境类对象
   protected Class<FLogicContext> _logicContextClass;

   // 访问规则类名称
   @AProperty(name = "access_rule")
   protected String _accessRuleClassName;

   // 访问规则
   protected IWebAccessRule _accessRule;

   // 参数绑定控制台
   @ALink
   protected IBindConsole _bindConsole;

   // 数据库链接控制台
   @ALink
   protected IDatabaseConsole _databaseConsole;

   // 表单存储对象控制台
   @ALink
   protected IWebContainerConsole _formConsole;

   // 结果消息控制台
   @ALink
   protected IWebMessageConsole _messageConsole;

   // 类描述器集合
   protected FActionDescriptorClassMap _descriptors = new FActionDescriptorClassMap();

   // 命令设置集合
   protected FWebActions _actionConfigs = new FWebActions();

   // 略过地址集合
   protected FAttributes _noMap = new FAttributes();

   // 页面设置集合
   protected FPageConfigClassMap _pageConfigs = new FPageConfigClassMap();

   // 标签环境
   protected FAttributes _tagContexts = new FAttributes();

   //============================================================
   // <T>增加环境设置信息。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void addContext(String name,
                          String value){
      _tagContexts.set(name, value);
   }

   //============================================================
   // <T>查找指定类中的起调函数信息。</T>
   //
   // @param clazz 类对象
   // @param name 名称
   // @return 函数信息对象
   //============================================================
   protected FActionMethodDescriptor findMethod(Class<?> clazz,
                                                String name){
      // 获得类描述器
      FActionDescriptor descriptor = _descriptors.find(clazz);
      if(null == descriptor){
         descriptor = new FActionDescriptor(clazz);
         _descriptors.set(clazz, descriptor);
      }
      // 查找函数描述对象 
      FActionMethodDescriptor methodDescriptor = null;
      try{
         if(name == null){
            name = "construct";
         }
         if(descriptor.contains(name)){
            methodDescriptor = descriptor.find(name);
         }else{
            for(Method method : clazz.getMethods()){
               if(name.equals(method.getName())){
                  methodDescriptor = new FActionMethodDescriptor();
                  methodDescriptor.setActionDescriptor(descriptor);
                  methodDescriptor.build(method);
                  break;
               }
            }
            descriptor.push(name, methodDescriptor);
         }
      }catch(Exception e){
         throw new FFatalError(e, "Find method failure. (class={1}, method={2})", clazz, name);
      }
      return methodDescriptor;
   }

   //============================================================
   // <T>查找指定类的设置信息。</T>
   //
   // @param clazz 类对象
   // @return 页面设置信息
   //============================================================
   protected FPageConfig findPageConfig(Class<?> clazz){
      FPageConfig config = null;
      if(_pageConfigs.contains(clazz)){
         return _pageConfigs.get(clazz);
      }
      String name = RClass.shortName(clazz);
      name = RString.mid(name, "I", "Action").toLowerCase() + ".xml";
      URL url = clazz.getResource(name);
      if(url != null){
         String fullname = clazz.getResource(name).getFile();
         if(RFile.exists(fullname)){
            FXmlDocument doc = new FXmlDocument(fullname);
            config = new FPageConfig(doc.root());
         }
      }
      _pageConfigs.set(clazz, config);
      return config;
   }

   //============================================================
   // <T>根据地址查找设置。</T>
   //
   // @param uri 地址
   // @return 设置
   //============================================================
   @Override
   public FWebAction findConfig(String uri){
      // 检查是否属于排除集合
      if(_noMap.contains(uri)){
         return null;
      }
      // 获得设置
      FWebAction config = _actionConfigs.find(uri);
      if(config == null){
         XAopAction xaction = findCommand(uri);
         if(null != xaction){
            String face = xaction.face();
            if(RClass.exists(face)){
               FAopComponent cmp = RAop.findComponent(face);
               config = new FWebAction();
               if(cmp != null){
                  config.setUri(uri);
                  config.setFace(face);
                  config.setFaceClass(cmp.faceClass().nativeObject());
               }else{
                  config.setUri(xaction.uri());
                  config.setFace(xaction.face());
                  config.setFaceClass(RClass.findClass(face));
               }
               _actionConfigs.set(uri, config);
            }
         }
      }
      if(null == config){
         _noMap.set(uri, null);
      }
      return config;
   }

   //============================================================
   // <T>根据地址查找命令。</T>
   //
   // @param uri 地址
   // @return 命令
   //============================================================
   @Override
   public XAopAction findCommand(String uri){
      XAopAction xaction = RAop.configConsole().findNode(XAopAction.NAME, uri);
      if(xaction == null){
         XAopActionsCollection xactionsCollection = (XAopActionsCollection)RAop.configConsole().findNodes(XAopActions.NAME);
         if(xactionsCollection != null){
            int count = xactionsCollection.count();
            for(int n = 0; n < count; n++){
               XAopActions xactions = xactionsCollection.get(n);
               if(xactions.match(uri)){
                  xaction = new XAopAction();
                  xaction.assign(xactions);
                  xaction.setUri(uri);
                  xaction.setFace(xactions.buildFace(uri));
                  break;
               }
            }
         }
      }
      return xaction;
   }

   //============================================================
   // <T>根据转向信息转向新的页面。</T>
   // <P>
   //    如果转向页面中为.wa结尾，则执行新的处理过程。
   //    否则算出地址，转向到显示JSP页面。
   // </P>
   //
   // @param context 页面环境
   // @param redirect 转向对象
   // @return 返回地址
   //============================================================
   protected String redirect(IWebContext context,
                             Object redirect){
      // 如果为空，则不处理
      if(null == redirect){
         return null;
      }
      // 处理为字符串的情况
      if(redirect instanceof String){
         String uri = (String)redirect;
         // 处理含有参数的情况
         String[] splits = RString.splitTwo(uri, '?');
         FAttributes params = new FAttributes();
         if(null != splits){
            uri = splits[0];
            params.split(splits[1], '=', '&', false);
            context.parameters().append(params);
         }
         // 处理转向
         if(uri.endsWith(IActionConstant.WEB_ACTION)){
            // 处理操做命令
            TAction action = RAction.parse(uri);
            if(params.contains("do")){
               action.setAction(params.get("do"));
            }
            if(uri.contains("@")){
               uri = uri.substring(uri.indexOf("@") + 1);
            }
            context.setRequestUri(uri);
            String result = execute(context, context.contextTag(action.uri()), action.action());
            if(null == result){
               result = context.contextTag(action.page());
            }
            return result;
         }else if(uri.startsWith("#")){
            // 处理特殊命令
            uri = context.contextTag() + uri.substring(1);
            if(!uri.endsWith(IActionConstant.JSP_PAGE)){
               uri += IActionConstant.JSP_PAGE;
            }
            return uri;
         }else if(!(uri.startsWith("/") || uri.startsWith("#"))){
            // 处理一般转向
            String ruri = context.requestUri();
            ruri = ruri.substring(0, ruri.lastIndexOf("/"));
            return ruri + "/" + uri + IActionConstant.JSP_PAGE;
         }
         return uri;
      }else{
         throw new FFatalError("Redirect type is unknown.");
      }
   }

   //============================================================
   // <T>执行一个地址处理。</T>
   //
   // @param context 页面环境
   // @param uri 地址描述
   // @return 处理地址
   //============================================================
   @Override
   public String execute(IWebContext context,
                         String uri){
      return execute(context, uri, null);
   }

   //============================================================
   // <T>执行一个地址处理。</T>
   //
   // @param context 页面环境
   // @param uri 地址描述
   // @param method 函数名称
   // @return 处理地址
   //============================================================
   @Override
   @SuppressWarnings({"unchecked", "rawtypes"})
   public String execute(IWebContext context,
                         String uri,
                         String method){
      Throwable throwable = null;
      ILogicContext logicContext = null;
      Object[] params = null;
      Object redirect = null;
      boolean hasError = context.messages().hasError();
      try{
         // 设置环境路径
         int count = _tagContexts.count();
         for(int n = 0; n < count; n++){
            if(uri.startsWith(_tagContexts.name(n))){
               ((FWebContext)context).setContextTag(_tagContexts.value(n));
               break;
            }
         }
         // 修正访问地址
         if(uri.lastIndexOf('?') != -1){
            String[] subs = RString.splitLastTwo(uri, '?');
            uri = subs[0];
            context.parameters().split(subs[1], "=", "&", true);
         }
         if(uri.endsWith(IActionConstant.WEB_ACTION)){
            uri = uri.substring(0, uri.length() - 3);
         }
         //............................................................
         // 查找地址对应的页面命令设置
         FWebAction config = findConfig(uri);
         if(null == config){
            _logger.warn(this, "execute", "Can't find action config. (uri={1})", uri);
            return null;
         }
         // 查找页面命令的实例对象
         Object action = RAop.tryFind(config.face());
         if(null == action){
            _logger.warn(this, "execute", "Can't find action. (uri={1})", uri);
            return null;
         }
         // 找到当前地址对应的函数描述器
         String doAction = RString.nvl(method, context.parameter("do"), IActionConstant.DEFAULT_METHOD);
         FActionMethodDescriptor methodDescriptor = findMethod(config.faceClass(), doAction);
         if(methodDescriptor == null){
            _logger.warn(this, "execute", "Can't find method in action. (action={1}, method={2})", action, doAction);
            return null;
         }
         // 加载当前页面的配置信息
         FPageConfig pageConfig = findPageConfig(config.faceClass());
         if(null != pageConfig){
            ((FWebContext)context).setPageConfig(pageConfig);
         }
         context.pageStatus().setStatus(doAction);
         _logger.debug(this, "execute", "Process action. (url={1}, action={2}, method={3})", uri, action, doAction);
         //............................................................
         // 建立数据环境
         if(_logicContextClass != null){
            try{
               FLogicContext newLogicContext = _logicContextClass.newInstance();
               newLogicContext.linkDatabaseConsole(_databaseConsole);
               logicContext = newLogicContext;
            }catch(Exception e){
               throw new FFatalError(e);
            }
         }else{
            logicContext = new FLogicContext(_databaseConsole);
         }
         // 检查当前处理是否需要会话
         if(methodDescriptor.sessionRequire()){
            if(_accessRule != null){
               EResult resultCd = _accessRule.checkSession(context, logicContext);
               if(resultCd != EResult.Success){
                  return redirect(context, _messageConsole.loginWithout());
               }
            }
         }
         // 检查当前处理是否需要登录
         if(methodDescriptor.loginRequire()){
            if(_accessRule != null){
               EResult resultCd = _accessRule.checkLogin(context, logicContext);
               if(resultCd != EResult.Success){
                  return redirect(context, _messageConsole.loginWithout());
               }
            }
         }
         // 检查当前处理是否需要登录
         AWebRole role = methodDescriptor.role();
         AWebAuthority authority = methodDescriptor.authority();
         if((role != null) || (authority != null)){
            if(_accessRule != null){
               EResult resultCd = _accessRule.checkAuthority(context, logicContext, role, authority);
               if(resultCd != EResult.Success){
                  return redirect(context, _messageConsole.loginAuthority());
               }
            }
         }
         //............................................................
         // Invoke method
         Class[] types = methodDescriptor.types();
         AContainer[] acontainers = methodDescriptor.forms();
         ASqlConnect[] aconnects = methodDescriptor.sqlConnects();
         int paramCount = types.length;
         FWebContainerItem[] containers = new FWebContainerItem[paramCount];
         params = new Object[paramCount];
         // 创建调用的参数列表
         for(int n = 0; n < paramCount; n++){
            Class type = types[n];
            AContainer acontainer = acontainers[n];
            Object value = null;
            if(type == IWebContext.class){
               // 参数为网络环境对象时
               value = context;
            }else if(type == IWebSession.class){
               // 参数为网络线程对象时
               value = context.session();
            }else if((type == ISqlContext.class) || (type == ILogicContext.class)){
               // 参数对象为数据环境对象
               value = logicContext;
               ASqlConnect aconnect = aconnects[n];
               if(aconnect != null){
                  logicContext.setDefaultName(aconnect.name());
               }
            }else if(acontainer != null){
               // 参数为表单对象时
               containers[n] = _formConsole.findContainer(context, acontainer, type);
               value = containers[n].container();
               context.define(acontainers[n].name(), value);
            }else{
               // 未知参数时
               Object bindObject = _bindConsole.find(type);
               if(bindObject != null){
                  value = bindObject;
               }else if(type.isInterface()){
                  value = RAop.find(type);
               }else{
                  throw new FFatalError("Unknown param type. (type={1})", type);
               }
            }
            params[n] = value;
         }
         // 动态函数调用
         redirect = methodDescriptor.invoke(action, params);
      }catch(Throwable t){
         // 产生例外时，处理例外内容
         boolean isSqlException = false;
         if(t instanceof FError){
            Throwable root = ((FError)t).rootThrowable();
            if(root instanceof SQLException){
               isSqlException = true;
               RSql.parseSqlException(context.messages(), root);
            }
         }
         if(!isSqlException){
            context.messages().push(new FFatalMessage(t));
         }
         throwable = t;
      }finally{
         // 释放所有调用参数
         if(params != null){
            for(Object param : params){
               if(param != logicContext){
                  if(param instanceof IRelease){
                     try{
                        ((IRelease)param).release();
                     }catch(Exception e){
                        throwable = e;
                     }
                  }
               }
            }
         }
         // 释放数据库链接
         if(logicContext != null){
            if(throwable == null){
               logicContext.commit();
            }else{
               logicContext.rollback();
            }
            try{
               logicContext.release();
            }catch(Exception e){
               throw new FFatalError(e);
            }
            logicContext = null;
         }
      }
      // 如果上次处理有错误，本次处理依旧产生错误，则只输出日志，不做页面错误转向处理
      if(hasError && (throwable != null)){
         _logger.error(this, "execute", throwable);
         return null;
      }
      // 错误处理
      if(context.hasMessages()){
         FMessages messages = context.messages();
         if(messages.hasMessage(FFatalMessage.class)){
            return redirect(context, _messageConsole.fatalMessage());
         }else if(messages.hasMessage(FErrorMessage.class)){
            return redirect(context, _messageConsole.errorMessage());
         }else if(messages.hasMessage(FWarnMessage.class)){
            return redirect(context, _messageConsole.warnMessage());
         }else{
            return redirect(context, _messageConsole.infoMessage());
         }
      }
      return redirect(context, redirect);
   }

   //============================================================
   // <T>初始化配置信息。</T>
   //============================================================
   public void initializeConfig(){
      // 设置逻辑环境类对象
      if(!RString.isEmpty(_logicContextClassName)){
         _logicContextClass = RClass.findClass(_logicContextClassName);
      }
      // 设置访问权限类对象
      if(!RString.isEmpty(_accessRuleClassName)){
         try{
            Class<?> accessRuleClass = RClass.findClass(_accessRuleClassName);
            _accessRule = (IWebAccessRule)accessRuleClass.newInstance();
         }catch(Exception exception){
            throw new FFatalError(exception);
         }
      }
   }
}

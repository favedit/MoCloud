package org.mo.core.aop;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDump;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.system.RThread;
import org.mo.core.aop.config.FAopConfigConsole;
import org.mo.core.aop.container.FAopComponent;
import org.mo.core.aop.container.FAopComponentConsole;
import org.mo.core.aop.descriptor.FAopDescriptorConsole;
import org.mo.core.aop.dispatcher.FAopDispatcherConsole;
import org.mo.core.aop.session.FAopSessionConsole;

//============================================================
// <T>AOP组件管理类。</T>
//============================================================
public class RAop
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(RAop.class);

   // 组件配置控制台
   private static FAopConfigConsole _configConsole = new FAopConfigConsole();

   // 组件描述控制台
   private static FAopDescriptorConsole _descriptorConsole = new FAopDescriptorConsole();

   // 组件控制台
   private static FAopComponentConsole _componentConsole = new FAopComponentConsole();

   // 组件处理控制台
   private static FAopDispatcherConsole _dispatcherConsole;

   // 组件会话控制台
   private static FAopSessionConsole _sessionConsole;

   //============================================================
   // <T>静态初始化。</T>
   //============================================================
   static{
      _configConsole.loadDefaultConfig();
   }

   //============================================================
   // <T>获得组件配置控制台。</T>
   //
   // @return 组件配置控制台
   //============================================================
   public static FAopConfigConsole configConsole(){
      return _configConsole;
   }

   //============================================================
   // <T>获得组件描述控制台。</T>
   //
   // @return 组件描述控制台
   //============================================================
   public static FAopDescriptorConsole descriptorConsole(){
      return _descriptorConsole;
   }

   //============================================================
   // <T>获得组件控制台。</T>
   //
   // @return 组件控制台
   //============================================================
   public static FAopComponentConsole componentConsole(){
      return _componentConsole;
   }

   //============================================================
   // <T>获得组件处理控制台。</T>
   //
   // @return 组件处理控制台
   //============================================================
   public static FAopDispatcherConsole dispatcherConsole(){
      return _dispatcherConsole;
   }

   //============================================================
   // <T>获得组件会话控制台。</T>
   //
   // @return 组件会话控制台
   //============================================================
   public static FAopSessionConsole sessionConsole(){
      return _sessionConsole;
   }

   //============================================================
   // <T>根据接口名称获得组件。</T>
   //
   // @param face 接口名称
   // @return 组件
   //============================================================
   public static FAopComponent findComponent(String face){
      FAopComponentConsole componentConsole = componentConsole();
      FAopComponent component = componentConsole.findComponent(face);
      return component;
   }

   //============================================================
   // <T>根据类获得组件。</T>
   //
   // @param clazz 类
   // @return 组件
   //============================================================
   public static FAopComponent findComponent(Class<?> clazz){
      FAopComponentConsole componentConsole = componentConsole();
      FAopComponent component = componentConsole.findComponent(clazz);
      return component;
   }

   //============================================================
   // <T>根据接口类名称，查找一个组件对象。</T>
   // <P>如果组件不存在，则产生例外。</P>
   //
   // @type V 组件类型
   // @param clazz 接口类对象
   // @return 组件对象
   //============================================================
   public static <V> V find(String face){
      try{
         FAopComponentConsole componentConsole = componentConsole();
         V result = componentConsole.find(face);
         return result;
      }catch(Exception e){
         throw new FFatalError(e, "Find component failed. (class={1})", face);
      }
   }

   //============================================================
   // <T>根据接口类对象，查找一个组件对象。</T>
   // <P>如果组件不存在，则产生例外。</P>
   //
   // @type V 组件类型
   // @param clazz 接口类对象
   // @return 组件对象
   //============================================================
   public static <V> V find(Class<V> clazz){
      try{
         FAopComponentConsole componentConsole = componentConsole();
         V result = componentConsole.find(clazz);
         return result;
      }catch(Exception e){
         throw new FFatalError(e, "Find component failed. (class={1})", clazz.getName());
      }
   }

   //============================================================
   // <T>根据接口类名称，查找一个会话组件对象。</T>
   // <P>如果组件不存在，则产生例外。</P>
   //
   // @type V 组件类型
   // @param session 会话名称
   // @param clazz 接口类对象
   // @return 组件对象
   //============================================================
   @SuppressWarnings("unchecked")
   public static <V> V find(String session,
                            String face){
      V result = null;
      try{
         result = (V)componentConsole().find(session, face);
      }catch(Exception e){
         _logger.error(null, "find", e, "find class {1}", face);
      }
      return result;
   }

   //============================================================
   // <T>根据接口类对象，查找一个会话组件对象。</T>
   // <P>如果组件不存在，则产生例外。</P>
   //
   // @type V 组件类型
   // @param session 会话名称
   // @param clazz 接口类对象
   // @return 组件对象
   //============================================================
   public static <V> V find(String session,
                            Class<V> clazz){
      V result = null;
      try{
         result = componentConsole().find(session, clazz);
      }catch(Exception e){
         _logger.error(null, "find", e, "find class {1}", clazz);
      }
      return result;
   }

   //============================================================
   // <T>根据接口类名称，查找一个组件对象。</T>
   // <P>如果组件不存在，则返回空。</P>
   //
   // @type V 组件类型
   // @param clazz 接口类对象
   // @return 组件对象
   //============================================================
   public static <V> V tryFind(String face){
      return componentConsole().tryFind(face);
   }

   //============================================================
   // <T>根据接口类对象，查找一个组件对象。</T>
   // <P>如果组件不存在，则返回空。</P>
   //
   // @type V 组件类型
   // @param clazz 接口类对象
   // @return 组件对象
   //============================================================
   public static <V> V tryFind(Class<V> clazz){
      return componentConsole().tryFind(clazz);
   }

   //============================================================
   // <T>初始化环境内容。</T>
   //
   // @param fileName 设置文件名
   //============================================================
   public static void initialize(String fileName){
      // 启动处理
      if(_logger.debugAble()){
         _logger.debug(null, "initialize", RDump.lineString(" Start "));
         _logger.debug(null, "initialize", "Context Initialized. [{1}]", fileName);
      }
      // 加载配置
      try{
         // 创建配置控制台
         _configConsole.loadFile(fileName);
         // 创建对象配置
         _dispatcherConsole = find(FAopDispatcherConsole.class);
         _sessionConsole = find(FAopSessionConsole.class);
         // 创建组件控制台
         _componentConsole.initialize();
      }catch(Throwable throwable){
         _logger.error(null, "initialize", throwable);
      }
   }

   //============================================================
   // <T>释放环境内容。</T>
   //============================================================
   public static void release(){
      // 停止组件
      try{
         if(_componentConsole != null){
            _componentConsole.release();
         }
      }catch(Throwable throwable){
         _logger.error(null, "release", throwable);
      }
      // 停止线程
      RThread.stopAll();
      // 日志处理
      if(_logger.debugAble()){
         _logger.debug(null, "destroyed", "Context destroyed");
         _logger.debug(null, "destroyed", RDump.lineString(" Stop "));
      }
   }
}

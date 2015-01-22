package org.mo.core.bind;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>绑定控制台。</T>
//============================================================
public class FBindConsole
      implements
         IBindConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FBindConsole.class);

   // 绑定信息集合
   private final FBindInfos _infos = new FBindInfos();

   //============================================================
   // <T>构造绑定控制台。</T>
   //============================================================
   public FBindConsole(){
   }

   //============================================================
   // <T>获得当前代码。</T>
   //
   // @return 代码
   //============================================================
   protected long currentCode(){
      return Thread.currentThread().getId();
   }

   //============================================================
   // <T>是否存在关联的绑定信息。</T>
   //
   // @return 是否存在
   //============================================================
   @Override
   public boolean exists(){
      long code = currentCode();
      return _infos.containsByCode(code);
   }

   //============================================================
   // <T>是否含有指定类关联的信息。</T>
   //
   // @param clazz 类对象
   // @return 是否含有
   //============================================================
   @Override
   public boolean contains(Class<?> clazz){
      long code = currentCode();
      FBindInfo info = _infos.findByCode(code);
      if(info != null){
         String className = clazz.getName();
         return info.contains(className);
      }
      return false;
   }

   //============================================================
   // <T>查找类对应的内容对象。</T>
   //
   // @param clazz 类对象
   // @return 内容对象
   //============================================================
   @Override
   @SuppressWarnings("unchecked")
   public <V> V find(Class<V> clazz){
      V value = null;
      long code = currentCode();
      String className = clazz.getName();
      FBindInfo info = _infos.findByCode(code);
      if(info != null){
         value = (V)info.find(className);
      }
      //      if(_logger.debugAble()){
      //         _logger.debug(this, "find", "Find bind value (code={1}, class={2}, value={3})", code, className, value);
      //      }
      return value;
   }

   //============================================================
   // <T>获得类对应的内容对象。</T>
   //
   // @param clazz 类对象
   // @return 内容对象
   //============================================================
   @Override
   public <V> V get(Class<V> clazz){
      V instance = find(clazz);
      if(instance == null){
         throw new FFatalError("Can't get bind object (class={1})", clazz);
      }
      return instance;
   }

   //============================================================
   // <T>绑定类对应的内容对象。</T>
   //
   // @param clazz 类对象
   // @return 对象
   //============================================================
   @Override
   @SuppressWarnings("unchecked")
   public <T> T bind(Class<T> clazz){
      // 检查参数
      if(clazz == null){
         throw new FFatalError("Unknown class. (class={1})", clazz);
      }
      // 获得绑定信息
      long code = currentCode();
      FBindInfo info = _infos.syncByCode(code);
      // 设置内容
      String className = clazz.getName();
      T result = (T)info.find(className);
      if(result != null){
         result = RClass.newInstance(clazz);
         info.set(className, result);
      }
      return result;
   }

   //============================================================
   // <T>绑定类对应的内容对象。</T>
   //
   // @param clazz 类对象
   // @param item 内容对象
   //============================================================
   @Override
   public void bind(Class<?> clazz,
                    Object object){
      long code = currentCode();
      FBindInfo info = _infos.syncByCode(code);
      String className = clazz.getName();
      info.set(className, object);
      //      if(_logger.debugAble()){
      //         _logger.debug(this, "bind", "Bind value (code={1}, class={2}, value={3})", code, className, object);
      //      }
   }

   //============================================================
   // <T>解除绑定类对应的内容对象。</T>
   //
   // @param clazz 类对象
   // @return 内容对象
   //============================================================
   @Override
   public <V> void unbind(Class<V> clazz){
      //      if(_logger.debugAble()){
      //         _logger.debug(this, "bind", "Unbind value. ({1})", clazz);
      //      }
      long code = currentCode();
      FBindInfo info = _infos.findByCode(code);
      if(info != null){
         String className = clazz.getName();
         info.remove(className);
      }
   }

   //============================================================
   // <T>清空所有内容对象。</T>
   //============================================================
   @Override
   public void clear(){
      long code = currentCode();
      FBindInfo info = _infos.findByCode(code);
      if(info != null){
         info.clear();
         _logger.debug(this, "clear", "Clear bind info (code={1})", code);
      }
   }

   //============================================================
   // <T>移除关联的所有内容对象。</T>
   //============================================================
   @Override
   public void remove(){
      long code = currentCode();
      FBindInfo info = _infos.findByCode(code);
      if(info != null){
         info.clear();
         _infos.remove(info);
         _logger.debug(this, "remove", "Remove bind info (code={1})", code);
      }
   }
}

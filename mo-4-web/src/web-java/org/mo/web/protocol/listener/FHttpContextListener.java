package org.mo.web.protocol.listener;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mo.com.io.RFile;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.system.RSystem;
import org.mo.core.aop.RAop;

//============================================================
// <T>环境内容变化监听类。</T>
// <P>环境内容变化时触发开始、结束事件</P>
//============================================================
public class FHttpContextListener
      implements
         ServletContextListener
{
   // 类目录
   private static String PATH_ROOT = "/WEB-INF/classes";

   //============================================================
   // <T>初始化环境内容。</T>
   //
   // @param event 事件对象
   //============================================================
   @Override
   public void contextInitialized(ServletContextEvent event){
      // 获得应用目录
      String application = RSystem.property("user.mobj.application");
      File applicationFile = new File(application);
      String applicationDirectory = null;
      if(applicationFile.isDirectory()){
         try{
            applicationDirectory = applicationFile.getCanonicalPath();
         }catch(IOException e){
            throw new FFatalError("Application directory is invalid. (application={1})", application);
         }
      }else{
         throw new FFatalError("Application directory is invalid. (application={1})", application);
      }
      // 获得启动设置文件名称
      String mode = RSystem.property("user.mobj.config");
      ServletContext context = event.getServletContext();
      String path = context.getRealPath(PATH_ROOT);
      String configFileName = RFile.makeFilename(path, mode + ".xml");
      // 设置类加载器
      ClassLoader loader = getClass().getClassLoader();
      RClass.setupClassLoader(loader);
      // 设置属性集合
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", applicationDirectory);
      // 加载启动信息
      RAop.initialize(configFileName);
   }

   //============================================================
   // <T>释放环境内容。</T>
   //
   // @param event 事件对象
   //============================================================
   @Override
   public void contextDestroyed(ServletContextEvent event){
      RAop.release();
   }
}

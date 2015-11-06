package util;

import domain.FileProperties;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * 
 * @author 胡国青
 * 监听一个目录,只要有文件新建,就修改全局变量的文件名
 *
 */

public class WatcherServiceUtil
{
   private WatchService watcher;

   public WatcherServiceUtil(Path path) throws IOException{
      watcher = FileSystems.getDefault().newWatchService();
      path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);
   }

   @SuppressWarnings("unchecked")
   public void handleEvents() throws InterruptedException{
      int num = 0;
      while(true){
         //Thread.sleep(300);
         WatchKey key = watcher.take();
         for(WatchEvent<?> event : key.pollEvents()){
            @SuppressWarnings("rawtypes") WatchEvent.Kind kind = event.kind();

            if(kind == StandardWatchEventKinds.OVERFLOW){//事件可能lost or discarded  
               continue;
            }

            WatchEvent<Path> e = (WatchEvent<Path>)event;
            Path fileName = e.context();

            //FileProperties.getFileProperties().setFileName(fileName.toString());
            if("ENTRY_MODIFY".equals(kind.name()) && num == 0){
               FileProperties.getFileProperties().setFileName(fileName.toString());
               FileProperties.getFileProperties().setModify(true);
            }
            if("ENTRY_CREATE".equals(kind.name())){
               FileProperties.getFileProperties().setFileName(fileName.toString());
               FileProperties.getFileProperties().setModify(true);
            }
            num++;

         }
         if(!key.reset()){
            break;
         }
      }
   }
}

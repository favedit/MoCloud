package org.mo.cloud.content.design.dataset;

import org.mo.cloud.content.design.configuration.FContentObject;
import org.mo.cloud.content.design.configuration.IConfigurationConsole;
import org.mo.cloud.content.design.configuration.XContentObject;
import org.mo.cloud.content.design.persistence.EPersistenceMode;
import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.system.IListener;
import org.mo.core.aop.face.ALink;

public class FDatasetConsole
      extends FConsole
      implements
         IDatasetConsole
{
   // 内容配置控制台接口
   @ALink
   protected IConfigurationConsole _configurationConsole;

   // 内容字典
   protected FDictionary<XContentObject> _contents = new FDictionary<XContentObject>(XContentObject.class);

   //============================================================
   // <T>更新配置对象。</T>
   //
   // @param storgeName 存储名称
   // @param contentObject 配置对象
   //============================================================
   public void initialize(){
      _configurationConsole.registerFileChanged(new IListener(){
         @Override
         public boolean process(Object sender,
                                int command,
                                Object params){
            _contents.clear();
            return true;
         }
      });
   }

   @Override
   public FContentObject findDefine(String storgeName,
                                    String containerName,
                                    EPersistenceMode modeCd){
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void insert(String storgeName,
                      FContentObject contentObject){
      // TODO Auto-generated method stub

   }

   @Override
   public void update(String storgeName,
                      FContentObject contentObject){
      // TODO Auto-generated method stub

   }

   @Override
   public void delete(String storgeName,
                      FContentObject contentObject){
      // TODO Auto-generated method stub

   }

}

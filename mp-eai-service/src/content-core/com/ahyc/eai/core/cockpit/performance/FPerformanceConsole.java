package com.ahyc.eai.core.cockpit.performance;

import org.mo.com.console.FConsole;
import org.mo.com.lang.FDictionary;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>金融控制台。</T>
//============================================================
public class FPerformanceConsole
      extends FConsole
      implements
         IPerformanceConsole
{
   // 资源访问接口
   private static IResource _resource = RResource.find(FPerformanceConsole.class);

   // 资源访问接口
   protected FDictionary<FPerformanceModel> _models = new FDictionary<FPerformanceModel>(FPerformanceModel.class);

   //============================================================
   // <T>加载内容。</T>
   //============================================================
   public void initialize(){
      FXmlNode xconfig = _resource.findConfig("ezubao.investment.model");
      for(FXmlNode xnode : xconfig.nodes()){
         if(xnode.isName("Model")){
            FPerformanceModel model = new FPerformanceModel();
            model.loadConfig(xnode);
            _models.set(model.code(), model);
         }
      }
   }

   //============================================================
   // <T>查找模式。</T>
   //
   // @param code 模式代码
   // @return 模式
   //============================================================
   @Override
   public FPerformanceModel findTenderModel(String code){
      return _models.find(code);
   }
}

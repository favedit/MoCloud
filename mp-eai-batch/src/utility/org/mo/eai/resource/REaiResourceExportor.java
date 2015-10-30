package org.mo.eai.resource;

import org.mo.com.lang.FAttributes;
import org.mo.com.logging.ELoggerLevel;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.eai.resource.city.FEaiCityTemplate;
import org.mo.eai.resource.province.FEaiProvinceTemplate;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>资源导出器。</T>
//============================================================
public class REaiResourceExportor
{
   // 省份模板
   protected static FEaiProvinceTemplate _provinceTemplate;

   // 城市模板
   protected static FEaiCityTemplate _cityTemplate;

   // 城市模板
   public static FLogicContext logicContext;

   //============================================================
   // <T>获得城市模板。</T>
   //
   // @return 城市模板
   //============================================================
   public static FEaiProvinceTemplate provinceTemplate(){
      if(_provinceTemplate == null){
         _provinceTemplate = new FEaiProvinceTemplate();
         _provinceTemplate.parser();
      }
      return _provinceTemplate;
   }

   //============================================================
   // <T>获得城市模板。</T>
   //
   // @return 城市模板
   //============================================================
   public static FEaiCityTemplate cityTemplate(){
      if(_cityTemplate == null){
         _cityTemplate = new FEaiCityTemplate();
         _cityTemplate.parser();
      }
      return _cityTemplate;
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args){
      // 设置属性
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", "D:/Microbject/MoCloud");
      // 加载配置
      RAop.initialize("D:/Microbject/MoCloud/mp-eai-batch/src/config/application-work.xml");
      // 设置日志
      RLogger.setFlags(ELoggerLevel.NO_DEBUG.value());
      // 设置数据库
      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      logicContext = new FLogicContext(databaseConsole);
      // 输出应用资源
      String resourceFileName = "D:/Microbject/MoScript/source/ars/eai/resource.dat";
      FEaiResourceExporter resourceExporter = new FEaiResourceExporter();
      resourceExporter.serializeFile(resourceFileName, "resource");
      // 结束处理
      RAop.release();
   }
}

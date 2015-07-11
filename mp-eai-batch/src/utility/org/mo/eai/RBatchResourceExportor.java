package org.mo.eai;

import org.mo.eai.template.city.FCityTemplate;
import org.mo.eai.template.province.FProvinceTemplate;

//============================================================
// <T>资源导出器。</T>
//============================================================
public class RBatchResourceExportor
{
   // 省份模板
   protected static FProvinceTemplate _provinceTemplate;

   // 城市模板
   protected static FCityTemplate _cityTemplate;

   //============================================================
   // <T>获得城市模板。</T>
   //
   // @return 城市模板
   //============================================================
   public static FProvinceTemplate provinceTemplate(){
      if(_provinceTemplate == null){
         _provinceTemplate = new FProvinceTemplate();
         _provinceTemplate.parser();
      }
      return _provinceTemplate;
   }

   //============================================================
   // <T>获得城市模板。</T>
   //
   // @return 城市模板
   //============================================================
   public static FCityTemplate cityTemplate(){
      if(_cityTemplate == null){
         _cityTemplate = new FCityTemplate();
         _cityTemplate.parser();
      }
      return _cityTemplate;
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args){
      // 输出应用资源
      //String resourceFileName = "D:/Microbject/MoScript/source/ars/eai/chart-live.dat";
      String resourceFileName = "D:/Microbject/MoScript/source/ars/eai/resource.dat";
      FApplicationResourceExporter resourceExporter = new FApplicationResourceExporter();
      resourceExporter.serializeFile(resourceFileName, "resource");
      // 输出应用资源
      //resourceFileName = "D:/Microbject/MoScript/source/ars/eai/chart-history.dat";
      //FHistoryResourceExporter historyExporter = new FHistoryResourceExporter();
      //historyExporter.serializeFile(resourceFileName, "chart-history");
   }
}

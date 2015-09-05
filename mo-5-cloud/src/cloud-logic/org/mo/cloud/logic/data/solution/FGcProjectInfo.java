package org.mo.cloud.logic.data.solution;

import com.cyou.gccloud.data.data.FDataSolutionProjectUnit;

//============================================================
// <T>项目信息。</T>
//============================================================
public class FGcProjectInfo
      extends FDataSolutionProjectUnit
{
   // 设备类型
   protected int _deviceCd;

   // 质量类型
   protected int _qualityCd;

   //============================================================
   // <T>获得设备类型。</T>
   //
   // @return 设备类型
   //============================================================
   public int deviceCd(){
      return _deviceCd;
   }

   //============================================================
   // <T>获得质量类型。</T>
   //
   // @return 质量类型
   //============================================================
   public int qualityCd(){
      return _qualityCd;
   }
}

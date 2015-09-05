package org.mo.cloud.logic.data.system;

import com.cyou.gccloud.data.cache.FCacheSystemSessionUnit;

//============================================================
// <T>用户信息。</T>
//============================================================
public class FGcSessionInfo
      extends FCacheSystemSessionUnit
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

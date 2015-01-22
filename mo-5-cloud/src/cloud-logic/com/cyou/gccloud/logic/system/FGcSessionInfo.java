package com.cyou.gccloud.logic.system;

import com.cyou.gccloud.data.cache.FCacheSystemSessionUnit;
import com.cyou.gccloud.define.enums.common.EGcStorageDevice;
import com.cyou.gccloud.define.enums.common.EGcStorageQuality;
import org.mo.com.collections.FRow;
import org.mo.com.lang.RString;

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

   //============================================================
   // <T>设置设备品质的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   @Override
   public void setDeviceQuality(String value){
      super.setDeviceQuality(value);
      // 设置变量
      String[] items = RString.split(value, '.');
      if(items.length == 2){
         // 设置设备代码
         String deviceCode = items[0];
         if("ios".equals(deviceCode)){
            _deviceCd = EGcStorageDevice.Ios;
         }else if("android".equals(deviceCode)){
            _deviceCd = EGcStorageDevice.Android;
         }
         // 设置质量代码
         String qualityCode = items[1];
         if("lower".equals(qualityCode)){
            _qualityCd = EGcStorageQuality.Lower;
         }else if("middle".equals(qualityCode)){
            _qualityCd = EGcStorageQuality.Middle;
         }else if("high".equals(qualityCode)){
            _qualityCd = EGcStorageQuality.High;
         }
      }
   }

   //============================================================
   // <T>加载行记录。</T>
   //
   // @param row 行记录
   //============================================================
   @Override
   public void load(FRow row){
      super.load(row);
      // 设置质量
      setDeviceQuality(_deviceQuality);
   }
}

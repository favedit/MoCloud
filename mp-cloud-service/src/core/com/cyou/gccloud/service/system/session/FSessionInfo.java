package com.cyou.gccloud.service.system.session;

import com.cyou.gccloud.service.data.cache.FCacheSystemSessionUnit;
import org.mo.com.lang.FObject;

//============================================================
// <T>会话信息。</T>
//============================================================
public class FSessionInfo
      extends FObject
{
   // 数据单元
   protected FCacheSystemSessionUnit _uint;

   //============================================================
   // <T>构造会话信息。</T>
   //============================================================
   public FSessionInfo(FCacheSystemSessionUnit unit){
      _uint = unit;
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      return _uint.code();
   }

   //============================================================
   // <T>获得用户编号。</T>
   //
   // @return 用户编号
   //============================================================
   public long userId(){
      return _uint.userId();
   }
}

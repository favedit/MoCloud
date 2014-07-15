package com.cyou.gccloud.service.system.session;

import com.cyou.gccloud.service.data.cache.FCacheSystemSessionUnit;
import org.mo.com.lang.FObject;

public class FSessionInfo
      extends FObject
{
   protected FCacheSystemSessionUnit _uint;

   public FSessionInfo(FCacheSystemSessionUnit unit){
      _uint = unit;
   }

   public String code(){
      return _uint.code();
   }

   public long userId(){
      return _uint.userId();
   }
}

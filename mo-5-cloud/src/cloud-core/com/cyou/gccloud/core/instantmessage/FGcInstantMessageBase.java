package com.cyou.gccloud.core.instantmessage;

import com.cyou.gccloud.logic.person.FGcUserInfo;
import org.mo.core.aop.face.AProperty;

public class FGcInstantMessageBase
{

   // 是否开启
   @AProperty(name = "enable")
   protected boolean _enable;

   //============================================================
   // <T>生成账号名称。</T>
   //
   // @param sqlContext 数据环境
   // @param userId 用户编号
   // @return 处理结果
   //============================================================
   protected String makePassort(FGcUserInfo userInfo){

      return "gc_" + userInfo.guid();
   }

   //============================================================
   // <T>生成目标名称。</T>
   //
   // @param sqlContext 数据环境
   // @param code 代码
   // @param domain 主域
   // @return 处理结果
   //============================================================
   protected String makePassort(String code,
                                String domain){
      return code + "@" + domain;
   }

}

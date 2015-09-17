package org.mo.content.logic.mobile;

import org.mo.com.lang.FAttributes;

//============================================================
// <T>手机服务接口。</T>
//============================================================
public interface IMobileLogic
{
   //============================================================
   // <T>根据手机号获取相关信息。</T>
   //
   // @param mobile 手机号码
   //============================================================
   FAttributes getMobileInfo(String mobile);
}

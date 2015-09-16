package org.mo.content.logic.mobile;

import net.sf.json.JSONObject;

//============================================================
// <T>手机服务接口。</T>
//============================================================
public interface IMobileLogic
{
   //============================================================
   // <T>根据手机号获取相关信息。</T>
   //
   // @param mobile 网络环境
   //============================================================
   JSONObject getMobileInfo(String mobile);
}

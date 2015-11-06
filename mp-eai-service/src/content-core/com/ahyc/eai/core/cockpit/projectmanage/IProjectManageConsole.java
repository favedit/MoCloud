package com.ahyc.eai.core.cockpit.projectmanage;

import java.util.List;

//============================================================
// <T>金融控制台接口。</T>
//============================================================
public interface IProjectManageConsole
{
   //============================================================
   // <T>查找模式。</T>
   //
   // @param code 模式代码
   // @return 模式
   //============================================================
   public List<FProjectManageModel> fetch();
}

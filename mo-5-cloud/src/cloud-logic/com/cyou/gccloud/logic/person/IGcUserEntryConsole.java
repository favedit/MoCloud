package com.cyou.gccloud.logic.person;

import com.cyou.gccloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>用户入口控制台接口。</T>
//============================================================
public interface IGcUserEntryConsole
      extends
         IAbstractLogicUnitConsole<FGcUserEntryInfo>
{
   //============================================================
   // <T>根据来源类型和账号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param fromCd 来源类型
   // @param passport 账号
   // @return 处理结果
   //============================================================
   FGcUserEntryInfo find(ILogicContext logicContext,
                         int fromCd,
                         String passport);
}

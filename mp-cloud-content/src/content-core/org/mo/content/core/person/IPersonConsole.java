package org.mo.content.core.person;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台接口。</T>
//============================================================
public interface IPersonConsole
{
   EResult register(ILogicContext logicContext,
                    FDataPersonUserUnit userUnit);
}

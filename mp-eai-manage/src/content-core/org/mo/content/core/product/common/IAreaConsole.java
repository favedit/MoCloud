package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>区域信息操作接口</P>
//
//@class IAreaConsole
//@author Sunhr
//@Date 2015.09.13
//@version 1.0.0
//============================================================

public interface IAreaConsole
      extends
         IAbstractLogicUnitConsole<FDataCommonAreaUnit>
{
   FLogicDataset<FDataAreaInfo> select(ILogicContext logicContext,
                                       FDataCommonAreaUnit unit,
                                       int pageNum,
                                       int pageSize);

}

package org.mo.content.core.manage.product.system.version;

import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>版本控制台接口</P>
//@interface IProductConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public interface IVersionConsole extends IAbstractLogicUnitConsole<FDataSystemVersionUnit> {
   public FLogicDataset<FDataVersionInfo> select(ILogicContext logicContext, FDataSystemVersionUnit unit, int pageNum, int pageSize);

   public FDataSystemVersionUnit findByLable(ILogicContext logicContext, String label);

   public boolean isExsitsAppIdandNumber(ILogicContext logicContext, Long applicationId, Float number);

   public FLogicDataset<FDataVersionInfo> selectExamine(ILogicContext logicContext, FDataSystemVersionUnit unit, int pageNum, int pageSize);

   public boolean isExsitsAppIdandNumberandOuid(ILogicContext logicContext, Long applicationId, Long ouid, Float number);
}

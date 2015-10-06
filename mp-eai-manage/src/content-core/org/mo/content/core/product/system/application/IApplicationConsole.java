package org.mo.content.core.product.system.application;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
//============================================================
//<P>应用控制台接口</P>
//@interface IProductConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public interface IApplicationConsole 
                 extends 
                 IAbstractLogicUnitConsole<FDataSystemApplicationUnit> {

   public FLogicDataset<FDataSystemApplicationUnit> select(ILogicContext logicContext,
                                                            FDataSystemApplicationUnit unit,
                                                            int pageNum,
                                                            int pageSize);
   public FDataSystemApplicationUnit findByLable(ILogicContext logicContext,
                                                   String label);
}

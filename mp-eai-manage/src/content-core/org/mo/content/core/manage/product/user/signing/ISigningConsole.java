package org.mo.content.core.manage.product.user.signing;

import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>签到控制台接口</P>
//@class ISigningConsole
//@version 1.0.0
//============================================================
public interface ISigningConsole 
      extends 
         IAbstractLogicUnitConsole<FDataPersonUserSigningUnit> 
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataSigningInfo> select(ILogicContext logicContext, 
                                          FDataSigningInfo unit, 
                                          int pageNum, 
                                          int pageSize);

   // ============================================================
   // <T>根据搜索条件时间段查询分页数据</T>
   // @param logicContext 链接对象
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataSigningInfo> selectByDate(ILogicContext logicContext, 
                                                String beginDateStr, 
                                                String endDateStr, 
                                                int pageNum, 
                                                int pageSize);
}

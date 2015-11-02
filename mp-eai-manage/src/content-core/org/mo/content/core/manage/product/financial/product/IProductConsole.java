package org.mo.content.core.manage.product.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>国家信息控制台接口</P>
//@interface IProductConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public interface IProductConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialProductUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataFinancialProductUnit> select(ILogicContext logicContext,
                                                   FDataFinancialProductUnit unit,
                                                   int pageNum,
                                                   int pageSize);

   // ============================================================
   // <T>重写，获得分页数据列表</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @param pageSize 页面显示的行数
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataProductInfo> select(ILogicContext logicContext,
                                          FDataProductInfo unit,
                                          int pageNum,
                                          int pageSize);
   
   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataFinancialProductUnit findByCode(ILogicContext logicContext,
                                        String code);
   // ============================================================
   // <T>根据ouid查询产品信息</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataProductInfo findInfo(ILogicContext logicContext,
                             Long ouid);
}

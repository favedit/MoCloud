package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>国家信息控制台接口</P>
//@interface ICountryConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public interface ICountryConsole extends IAbstractLogicUnitConsole<FDataCommonCountryUnit> {

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataCommonCountryUnit> select(ILogicContext logicContext, FDataCommonCountryUnit unit, int pageNum, int pageSize);

   // ============================================================
   // <T>根据代码获取对象</T>
   // @param logicContext 链接对象
   // @param code 代码
   // @return 数据对象
   // ============================================================
   FDataCommonCountryUnit findByCode(ILogicContext logicContext, String code);

   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   public FDataCommonCountryUnit findByName(ILogicContext logicContext, String name);
}

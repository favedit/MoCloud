package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P城市信息控制台接口</P>
//@interface ICityConsole
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public interface ICityConsole 
      extends 
         IAbstractLogicUnitConsole<FDataCommonCityUnit> 
{
   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataCommonCityUnit findByCitycode(ILogicContext context, 
                                      String code);

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 每页显示的行数
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataCityInfo> select(ILogicContext logicContext, 
                                       FDataCommonCityUnit unit, 
                                       int pageNum, 
                                       int pageSize);

   // ============================================================
   // <T>根据标签，国家id，区域id,省份id判断数据重复</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @param countryId 国家id
   // @param areaId 区域id
   // @param provinceId 省份id
   // @return 数据集合
   // ============================================================
   boolean isExsitsByLabelandByCIdandAIdandPId(ILogicContext logicContext, 
                                                               String label, 
                                                               Long countryId, 
                                                               Long areaId, 
                                                               Long provinceId);
   
   // ============================================================
   // <T>根据label,countryId,areaId,provinceId,ouid判断数据存在重复</T>
   // @param logicContext 链接对象
   // @param label 市区标签
   // @param countryId 国家id
   // @param areaId 区域id
   // @param provinceId 身份id
   // @return 数据集合
   // ============================================================
   boolean isExsitsByLabelandByCIdandAIdandPIdandOuid(ILogicContext logicContext, 
                                                                      String label, 
                                                                      Long countryId, 
                                                                      Long areaId, 
                                                                      Long provinceId,
                                                                      Long ouid);
   
   // ============================================================
   // <T>根据省份id获取对象列表</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataCommonCityUnit> selectAll(ILogicContext logicContext, 
                                                Long provinceId);
}

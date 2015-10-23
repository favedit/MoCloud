package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>区域信息控制台接口</P>
//@interface IAreaConsole
//@version 1.0.0
//============================================================
public interface IAreaConsole 
      extends 
         IAbstractLogicUnitConsole<FDataCommonAreaUnit>
{
   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   //
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 每页显示的行数
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataAreaInfo> select(ILogicContext logicContext, 
                                       FDataCommonAreaUnit unit, 
                                       int pageNum, 
                                       int pageSize);

   // ============================================================
   // <T>根据标签获取区域</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据
   // ============================================================
   FDataCommonAreaUnit findByLable(ILogicContext logicContext, 
                                          String label);

   // ============================================================
   // <T>根据标签，国家id判断数据重复</T>
   // @param logicContext 链接对象
   // @param areaLabel 标签
   // @param countryId 国家id
   // @return 数据
   // ============================================================
   boolean isExistByAreaLabelandCountryId(ILogicContext logicContext, 
                                                 String areaLabel, 
                                                 Long countryId);
   
   // ============================================================
   // <T>根据区域标签和国家id，ouid判断是否重复</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   boolean isExistByAreaLabelandCountryIdandOuid(ILogicContext logicContext, 
                                                 String areaLabel, 
                                                 Long countryId,
                                                 Long ouid);

   // ============================================================
   // <T>根据国家id获取区域</T>
   // @param logicContext 链接对象
   // @param countryId 国家id
   // @return 数据
   // ============================================================
   FLogicDataset<FDataCommonAreaUnit> selectAll(ILogicContext logicContext, 
                                                       Long countryId);
}

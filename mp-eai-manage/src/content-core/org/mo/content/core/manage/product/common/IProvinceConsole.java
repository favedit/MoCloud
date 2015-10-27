package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
//============================================================
//<P>省份信息操作接口</P>
//
//@class IProvinceConsole
//@author Sunhr
//@Date 2015.09.13
//@version 1.0.0
//============================================================
import org.mo.data.logic.ILogicContext;
//============================================================
//<P省会信息控制台接口</P>
//@interface IProvinceConsole
//@version 1.0.0
//============================================================
public interface IProvinceConsole 
      extends 
         IAbstractLogicUnitConsole<FDataCommonProvinceUnit> 
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param sqlContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataProvinceInfo> select(ILogicContext logicContext, 
                                           FDataCommonProvinceUnit unit, 
                                           int pageNum, 
                                           int pageSize);

   // ============================================================
   // <T>根据区号获取对象</T>
   // @param logicContext 链接对象
   // @param code 区号
   // @return 数据对象
   // ============================================================
   FDataCommonProvinceUnit findByCode(ILogicContext logicContext, 
                                      String code);

   // ============================================================
   // <T>根据区标签获取对象</T>
   // @param logicContext 链接对象
   // @param provinceLabel 省份标签
   // @return 数据对象
   // ============================================================
   FDataCommonProvinceUnit findByLabel(FLogicContext logicContext, 
                                       String provinceLabel);

   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   FDataCommonProvinceUnit findByProvinceLabel(ILogicContext logicContext, 
                                               String label);

   // ============================================================
   // <T>判断是否存在</T>
   // @param logicContext 链接对象
   // @param proviceLabel 省份标签
   // @param areaId 区域id
   // @param countryId 国家id
   // @return 数据对象
   // ============================================================
   boolean isExistsByLabelandAIdandCId(ILogicContext logicContext, 
                                       String proviceLabel, 
                                       Long areaId, 
                                       Long countryId);
   
   // ============================================================
   // <T>根据标签,区域id,国家id,ouid判读数据库中是否已重复</T>
   // @param logicContext 链接对象
   // @param proviceLabel 省份标签
   // @param areaId 区域id
   // @param countryId 国家id
   // @param ouid ouid
   // @return boolean
   // ============================================================
   boolean isExistsByLabelandAIdandCIdandOuid(ILogicContext logicContext, 
                                              String proviceLabel, 
                                              Long areaId, 
                                              Long countryId,
                                              Long ouid);
   
   // ============================================================
   // <T>更具区域id查询所有省份</T>
   // @param logicContext 链接对象
   // @param areaId 区域id
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataCommonProvinceUnit> selectAll(ILogicContext logicContext, 
                                                    Long areaId);
   // ============================================================
   // <T>根据区域id获取对象列表</T>
   // @param logicContext 链接对象
   // @param areaId 区域id
   // @return 数据对象
   // ============================================================
   FLogicDataset<FDataCommonProvinceUnit> selectAllByAreaId(ILogicContext logicContext, 
                                                            Long areaId);
}

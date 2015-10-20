package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>区域信息控制台接口</P>
//@interface ICitycardConsole
//@version 1.0.0
//============================================================
public interface ICitycardConsole
      extends
         IAbstractLogicUnitConsole<FDataCommonCityCardUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 每页显示的行数
   // @return 数据集合
   // ============================================================
   public FLogicDataset<FDataCitycardInfo> select(ILogicContext logicContext, 
                                              FDataCommonCityCardUnit unit, 
                                              int pageNum, 
                                              int pageSize);
   
   // ============================================================
   // <T>根据身份证号和城市id，判断是否存在</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   public boolean isExsitsByCardcodeandByCityId(ILogicContext logicContext, 
                                                Long cityId, 
                                                int cardCode);
   
   // ============================================================
   // <T>根据标签获取对象列表</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   public FLogicDataset<FDataCommonAreaUnit> selectAll(ILogicContext logicContext, 
                                                       Long countryId);
}

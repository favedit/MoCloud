package org.mo.content.core.manage.product.examine.business.news;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
//============================================================
//<P>新闻控制台接口</P>
//@class INewsConsole
//@version 1.0.0
//============================================================
public interface INewsConsole 
      extends 
         IAbstractLogicUnitConsole<FDataLogicNewsUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataNewsInfo> select(ILogicContext logicContext, 
                                            FDataLogicNewsUnit unit, 
                                            int pageNum,
                                            int pageSize);

}
   
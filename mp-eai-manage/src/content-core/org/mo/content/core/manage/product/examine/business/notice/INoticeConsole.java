package org.mo.content.core.manage.product.examine.business.notice;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
//============================================================
//<P>公告控制台接口</P>
//@class INoticeConsole
//@version 1.0.0
//============================================================
public interface INoticeConsole 
      extends 
         IAbstractLogicUnitConsole<FDataLogicNoticeUnit>
{

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param sqlContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataNoticeInfo> select(ILogicContext logicContext, 
                                         FDataLogicNoticeUnit unit, 
                                         int pageNum,
                                         int pageSize);

}
   
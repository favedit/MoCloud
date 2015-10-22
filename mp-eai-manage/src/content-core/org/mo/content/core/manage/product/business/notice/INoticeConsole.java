package org.mo.content.core.manage.product.business.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>公告信息操作接口</P>
//
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

   // ============================================================
   // <T>根据状态，是否显示，标题查询数据</T>
   // @param logicContext 链接对象
   // @param pageNum 页码
   // @param pageSize 页大小
   // @param statusCd 状态
   // @param displayCd 是否显示
   // @param label 标题
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataNoticeInfo> selectByMessage(ILogicContext logicContext, 
                                                Integer statusCd,
                                                Integer displayCd,
                                                String label, 
                                                int pageNum,
                                                int pageSize);
}

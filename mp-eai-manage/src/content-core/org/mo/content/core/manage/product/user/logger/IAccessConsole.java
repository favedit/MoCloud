package org.mo.content.core.manage.product.user.logger;

import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台接口。</T>
//============================================================
public interface IAccessConsole 
      extends 
         IAbstractLogicUnitConsole<FLoggerPersonUserAccessUnit> 
{

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FLoggerPersonUserAccessUnit> select(ILogicContext logicContext, int pageNum, int pageSize);

   // ============================================================
   // <T>根据时间段和操作信息查询数据</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @param beginDateStr 开始时间
   // @param endDateStr 结束时间
   // @param logicMessage 操作信息
   // @return 数据集合
   // ============================================================
   FLogicDataset<FLoggerPersonUserAccessUnit> selectByDateandMessage(ILogicContext logicContext, String beginDateStr, String endDateStr, String logicMessage, int pageNum, int pageSize);
}

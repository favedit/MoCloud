package org.mo.content.core.manage.product.user.whitelists;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台接口。</T>
//============================================================
public interface IAccessConsole 
      extends 
         IAbstractLogicUnitConsole<FDataPersonAccessAuthorityUnit> 
{

   FLogicDataset<FDataPersonAccessAuthorityUnit> select(ILogicContext logicContext, int pageNum);

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataPersonAccessAuthorityUnit> select(ILogicContext logicContext, FDataPersonAccessAuthorityUnit unit, int pageNum, int pageSize);

   EResult hostExists(ILogicContext logicContext, String host);

   EResult passportExists(ILogicContext logicContext, String passport);
}

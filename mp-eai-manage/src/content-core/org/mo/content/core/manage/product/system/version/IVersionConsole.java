package org.mo.content.core.manage.product.system.version;

import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>版本控制台接口</P>
//@interface IProductConsole
//@version 1.0.0
//============================================================
public interface IVersionConsole 
      extends IAbstractLogicUnitConsole<FDataSystemVersionUnit> 
{
   // ============================================================
   // <T>获得分页数据列表</T>
   //
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   FLogicDataset<FDataVersionInfo> select(ILogicContext logicContext, FDataSystemVersionUnit unit, int pageNum, int pageSize);

   // ============================================================
   // <T>根据标签获取对象</T>
   // @param logicContext 链接对象
   // @param label 标签
   // @return 数据对象
   // ============================================================
   FDataSystemVersionUnit findByLable(ILogicContext logicContext, String label);

   // ============================================================
   // <T>根应用id和版本号和ouid 对象</T>
   // @param logicContext 链接对象
   // @return 是否重复
   // ============================================================
   boolean isExsitsAppIdandNumber(ILogicContext logicContext, Long applicationId, Float number);

   // ============================================================
   // <T>根据应用id和版本号和ouid判断是否有重复数据</T>
   // @param logicContext 链接对象
   // @return 是否重复
   // ============================================================
   FLogicDataset<FDataVersionInfo> selectExamine(ILogicContext logicContext, FDataSystemVersionUnit unit, int pageNum, int pageSize);

   public boolean isExsitsAppIdandNumberandOuid(ILogicContext logicContext, Long applicationId, Long ouid, Float number);
}

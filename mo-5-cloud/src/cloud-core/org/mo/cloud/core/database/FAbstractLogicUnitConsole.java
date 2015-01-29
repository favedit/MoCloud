package org.mo.cloud.core.database;

import org.mo.com.console.FConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicTable;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>逻辑单元控制台。</T>
//============================================================
public abstract class FAbstractLogicUnitConsole<T extends FLogicTable, U extends FLogicUnit>
      extends FConsole
      implements
         IAbstractLogicUnitConsole<U>
{
   // 逻辑类
   protected Class<T> _classLogic;

   // 单元类
   protected Class<U> _classUnit;

   //============================================================
   // <T>构造逻辑单元控制台。</T>
   //
   // @param classLogic 逻辑类
   // @param classUnit 单元类
   //============================================================
   public FAbstractLogicUnitConsole(Class<T> classLogic,
                                    Class<U> classUnit){
      _classLogic = classLogic;
      _classUnit = classUnit;
   }

   //============================================================
   // <T>获得逻辑单元</T>
   //
   // @param logicContext 逻辑环境
   // @return 逻辑单元
   //============================================================
   protected FLogicTable findLogic(ILogicContext logicContext){
      return logicContext.findLogic(_classLogic);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   @Override
   public U find(ILogicContext logicContext,
                 long objectId){
      return find(logicContext, objectId, null);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @param clazz 类对象
   // @return 处理结果
   //============================================================
   @Override
   public U find(ILogicContext logicContext,
                 long objectId,
                 Class<U> clazz){
      FLogicTable logicTable = findLogic(logicContext);
      Class<U> classUnit = (clazz != null) ? clazz : _classUnit;
      U unit = logicTable.find(classUnit, objectId);
      return unit;
   }

   //============================================================
   // <T>根据唯一码获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param uniqueCode 唯一码
   // @return 处理结果
   //============================================================
   @Override
   public U findByGuid(ILogicContext logicContext,
                       String uniqueCode){
      return findByGuid(logicContext, uniqueCode, null);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param uniqueCode 唯一码
   // @param clazz 类对象
   // @return 处理结果
   //============================================================
   @Override
   public U findByGuid(ILogicContext logicContext,
                       String uniqueCode,
                       Class<U> clazz){
      // 生成参数
      Class<U> classUnit = (clazz != null) ? clazz : _classUnit;
      String whereSql = "GUID='" + uniqueCode + "'";
      // 查询内容
      FLogicTable logicTable = findLogic(logicContext);
      U unit = logicTable.search(classUnit, whereSql);
      return unit;
   }

   //============================================================
   // <T>新建记录</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doInsert(ILogicContext logicContext,
                           U unit){
      FLogicTable logicTable = findLogic(logicContext);
      EResult resultCd = logicTable.doInsert(unit);
      return resultCd;
   }

   //============================================================
   // <T>修改记录</T>o
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doUpdate(ILogicContext logicContext,
                           U unit,
                           long objectId){
      FLogicTable logicTable = findLogic(logicContext);
      EResult resultCd = logicTable.doUpdate(unit, objectId);
      return resultCd;
   }

   //============================================================
   // <T>删除记录</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDelete(ILogicContext logicContext,
                           long objectId){
      FLogicTable logicTable = findLogic(logicContext);
      EResult resultCd = logicTable.doDelete(objectId);
      return resultCd;
   }
}

package org.mo.cloud.core.database;

import org.mo.com.console.FConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicTable;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>逻辑单元控制台。</T>
//============================================================
public abstract class FAbstractLogicUnitConsole<T extends FLogicUnit>
      extends FConsole
      implements
         IAbstractLogicUnitConsole<T>
{
   // 逻辑类
   protected Class<T> _classLogic;

   // 单元类
   protected Class<T> _classUnit;

   //============================================================
   // <T>构造逻辑单元控制台。</T>
   //============================================================
   public FAbstractLogicUnitConsole(){
   }

   //============================================================
   // <T>构造逻辑单元控制台。</T>
   //
   // @param classUnit 单元类
   //============================================================
   public FAbstractLogicUnitConsole(Class<T> classUnit){
      _classUnit = classUnit;
   }

   //============================================================
   // <T>构造逻辑单元控制台。</T>
   //
   // @param classLogic 逻辑类
   // @param classUnit 单元类
   //============================================================
   public FAbstractLogicUnitConsole(Class<T> classLogic,
                                    Class<T> classUnit){
      _classLogic = classLogic;
      _classUnit = classUnit;
   }

   //============================================================
   // <T>创建逻辑单元</T>
   //
   // @param logicContext 逻辑环境
   // @return 逻辑单元
   //============================================================
   protected abstract FLogicTable createLogic(ILogicContext logicContext);

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   @Override
   public T find(ILogicContext logicContext,
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
   public T find(ILogicContext logicContext,
                 long objectId,
                 Class<T> clazz){
      FLogicTable logicTable = createLogic(logicContext);
      Class<T> classUnit = (clazz != null) ? clazz : _classUnit;
      T unit = logicTable.find(classUnit, objectId);
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
   public T findUnique(ILogicContext logicContext,
                       String uniqueCode){
      return findUnique(logicContext, uniqueCode, null);
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
   public T findUnique(ILogicContext logicContext,
                       String uniqueCode,
                       Class<T> clazz){
      // 生成参数
      Class<T> classUnit = (clazz != null) ? clazz : _classUnit;
      String whereSql = "OGID='" + uniqueCode + "'";
      // 查询内容
      FLogicTable logicTable = createLogic(logicContext);
      T unit = logicTable.search(classUnit, whereSql);
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
   public EResult insert(ILogicContext logicContext,
                         T unit){
      FLogicTable logicTable = createLogic(logicContext);
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
   public EResult update(ILogicContext logicContext,
                         T unit,
                         long objectId){
      FLogicTable logicTable = createLogic(logicContext);
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
   public EResult delete(ILogicContext logicContext,
                         long objectId){
      FLogicTable logicTable = createLogic(logicContext);
      EResult resultCd = logicTable.doDelete(objectId);
      return resultCd;
   }
}

package org.mo.cloud.core.database;

import org.mo.com.console.FConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RLong;
import org.mo.com.lang.reflect.RClass;
import org.mo.data.logic.FLogicDataset;
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
   protected T findLogic(ILogicContext logicContext){
      return logicContext.findLogic(_classLogic);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @return 数据单元
   //============================================================
   @Override
   public U find(ILogicContext logicContext,
                 long objectId){
      return find(logicContext, _classUnit, objectId);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param clazz 类对象
   // @param objectId 对象编号
   // @return 数据单元
   //============================================================
   @Override
   public U find(ILogicContext logicContext,
                 Class<U> clazz,
                 long objectId){
      FLogicTable logic = findLogic(logicContext);
      Class<U> classUnit = (clazz != null) ? clazz : _classUnit;
      U unit = logic.find(classUnit, objectId);
      return unit;
   }

   //============================================================
   // <T>根据唯一码获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param uniqueCode 唯一码
   // @return 数据单元
   //============================================================
   @Override
   public U findByGuid(ILogicContext logicContext,
                       String uniqueCode){
      return findByGuid(logicContext, _classUnit, uniqueCode);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param clazz 类对象
   // @param uniqueCode 唯一码
   // @return 数据单元
   //============================================================
   @Override
   public U findByGuid(ILogicContext logicContext,
                       Class<U> clazz,
                       String uniqueCode){
      // 生成参数
      Class<U> classUnit = (clazz != null) ? clazz : _classUnit;
      String whereSql = "GUID='" + RSql.formatValue(uniqueCode) + "'";
      // 查询内容
      FLogicTable logic = findLogic(logicContext);
      U unit = logic.search(classUnit, whereSql);
      return unit;
   }

   //============================================================
   // <T>根据条件查找一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   @Override
   public U search(ILogicContext logicContext,
                   String whereSql){
      return search(logicContext, _classUnit, whereSql);
   }

   //============================================================
   // <T>根据条件查找一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param clazz 类对象
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   @Override
   public U search(ILogicContext logicContext,
                   Class<U> clazz,
                   String whereSql){
      // 生成参数
      Class<U> classUnit = (clazz != null) ? clazz : _classUnit;
      // 查询内容
      FLogicTable logic = findLogic(logicContext);
      U unit = logic.search(classUnit, whereSql);
      return unit;
   }

   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param whereSql 搜索内容
   // @param orderSql 查询内容
   // @param pageSize 页面大小
   // @param page 页面编号
   // @return 数据集合
   //============================================================
   @Override
   public FLogicDataset<U> fetch(ILogicContext logicContext,
                                 String whereSql,
                                 String orderSql,
                                 int pageSize,
                                 int page){
      T logic = findLogic(logicContext);
      return logic.fetchClass(_classUnit, null, whereSql, null, orderSql, pageSize, pageSize * page);
   }

   //============================================================
   // <T>准备记录理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onPrepare(ILogicContext logicContext,
                               U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>准备记录</T>
   //
   // @param logicContext 逻辑环境
   // @return 数据单元
   //============================================================
   @Override
   public U doPrepare(ILogicContext logicContext){
      FLogicTable logic = findLogic(logicContext);
      U unit = RClass.newInstance(_classUnit);
      logic.doPrepare(unit);
      onPrepare(logicContext, unit);
      return unit;
   }

   //============================================================
   // <T>准备记录</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doPrepare(ILogicContext logicContext,
                            U unit){
      return onPrepare(logicContext, unit);
   }

   //============================================================
   // <T>新建记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @param oldUnit 原始数据单元
   // @return 处理结果
   //============================================================
   protected EResult onInsertBefore(ILogicContext logicContext,
                                    U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>新建记录后处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onInsertAfter(ILogicContext logicContext,
                                   U unit){
      return EResult.Success;
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

      FLogicTable logic = findLogic(logicContext);
      // 新建记录处理
      EResult resultCd = onInsertBefore(logicContext, unit);
      if(resultCd == EResult.Success){
         logic.doInsert(unit);
         resultCd = onInsertAfter(logicContext, unit);
      }
      return resultCd;
   }

   //============================================================
   // <T>更新记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @param oldUnit 原始数据单元
   // @return 处理结果
   //============================================================
   protected EResult onUpdateBefore(ILogicContext logicContext,
                                    U unit,
                                    U oldUnit){
      return EResult.Success;
   }

   //============================================================
   // <T>更新记录后处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onUpdateAfter(ILogicContext logicContext,
                                   U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>修改记录</T>o
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doUpdate(ILogicContext logicContext,
                           U unit){
      long ouid = RLong.parse(unit.get("ouid"));
      return doUpdate(logicContext, unit, ouid);
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
      FLogicTable logic = findLogic(logicContext);
      // 检查存在性
      U oldUnit = logic.find(_classUnit, objectId);
      if(oldUnit == null){
         throw new FFatalError("Update unit is not exists. (object_id={1})", objectId);
      }
      // 更新记录处理
      EResult resultCd = onUpdateBefore(logicContext, unit, oldUnit);
      if(resultCd == EResult.Success){
         logic.doUpdate(unit);
         resultCd = onUpdateAfter(logicContext, unit);
      }
      return resultCd;
   }

   //============================================================
   // <T>删除记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onDeleteBefore(ILogicContext logicContext,
                                    U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>删除记录后处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onDeleteAfter(ILogicContext logicContext,
                                   U unit){
      return EResult.Success;
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
      FLogicTable logic = findLogic(logicContext);
      // 检查存在性
      U unit = logic.find(_classUnit, objectId);
      if(unit == null){
         throw new FFatalError("Delete unit is not exists. (object_id={1})", objectId);
      }
      // 删除记录处理
      EResult resultCd = onDeleteBefore(logicContext, unit);
      if(resultCd == EResult.Success){
         logic.doDelete(unit);
         resultCd = onDeleteAfter(logicContext, unit);
      }
      return resultCd;
   }

   //============================================================
   // <T>删除记录</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDelete(ILogicContext logicContext,
                           U unit){
      FLogicTable logic = findLogic(logicContext);
      // 删除记录处理
      EResult resultCd = onDeleteBefore(logicContext, unit);
      if(resultCd == EResult.Success){
         logic.doDelete(unit);
         resultCd = onDeleteAfter(logicContext, unit);
      }
      return resultCd;
   }
}

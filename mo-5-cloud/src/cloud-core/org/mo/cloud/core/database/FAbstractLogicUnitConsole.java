package org.mo.cloud.core.database;

import org.mo.com.console.FConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RLong;
import org.mo.com.lang.reflect.RClass;
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
   // @param context 逻辑环境
   // @return 逻辑单元
   //============================================================
   protected T findLogic(ILogicContext context){
      return context.findLogic(_classLogic);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param context 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   @Override
   public U find(ILogicContext context,
                 long objectId){
      return find(context, objectId, null);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param context 逻辑环境
   // @param objectId 对象编号
   // @param clazz 类对象
   // @return 处理结果
   //============================================================
   @Override
   public U find(ILogicContext context,
                 long objectId,
                 Class<U> clazz){
      FLogicTable logic = findLogic(context);
      Class<U> classUnit = (clazz != null) ? clazz : _classUnit;
      U unit = logic.find(classUnit, objectId);
      return unit;
   }

   //============================================================
   // <T>根据唯一码获得一个数据单元。</T>
   //
   // @param context 逻辑环境
   // @param uniqueCode 唯一码
   // @return 处理结果
   //============================================================
   @Override
   public U findByGuid(ILogicContext context,
                       String uniqueCode){
      return findByGuid(context, uniqueCode, null);
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param context 逻辑环境
   // @param uniqueCode 唯一码
   // @param clazz 类对象
   // @return 处理结果
   //============================================================
   @Override
   public U findByGuid(ILogicContext context,
                       String uniqueCode,
                       Class<U> clazz){
      // 生成参数
      Class<U> classUnit = (clazz != null) ? clazz : _classUnit;
      String whereSql = "GUID='" + uniqueCode + "'";
      // 查询内容
      FLogicTable logic = findLogic(context);
      U unit = logic.search(classUnit, whereSql);
      return unit;
   }

   //============================================================
   // <T>准备记录理</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onPrepare(ILogicContext context,
                               U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>准备记录</T>
   //
   // @param context 逻辑环境
   // @return 数据单元
   //============================================================
   @Override
   public U doPrepare(ILogicContext context){
      FLogicTable logic = findLogic(context);
      U unit = RClass.newInstance(_classUnit);
      logic.doPrepare(unit);
      onPrepare(context, unit);
      return unit;
   }

   //============================================================
   // <T>准备记录</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doPrepare(ILogicContext context,
                            U unit){
      return onPrepare(context, unit);
   }

   //============================================================
   // <T>新建记录前处理</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @param oldUnit 原始数据单元
   // @return 处理结果
   //============================================================
   protected EResult onInsertBefore(ILogicContext context,
                                    U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>新建记录后处理</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onInsertAfter(ILogicContext context,
                                   U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>新建记录</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doInsert(ILogicContext context,
                           U unit){

      FLogicTable logic = findLogic(context);
      // 新建记录处理
      EResult resultCd = onInsertBefore(context, unit);
      if(resultCd == EResult.Success){
         logic.doInsert(unit);
         resultCd = onInsertAfter(context, unit);
      }
      return resultCd;
   }

   //============================================================
   // <T>更新记录前处理</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @param oldUnit 原始数据单元
   // @return 处理结果
   //============================================================
   protected EResult onUpdateBefore(ILogicContext context,
                                    U unit,
                                    U oldUnit){
      return EResult.Success;
   }

   //============================================================
   // <T>更新记录后处理</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onUpdateAfter(ILogicContext context,
                                   U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>修改记录</T>o
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doUpdate(ILogicContext context,
                           U unit){
      long ouid = RLong.parse(unit.get("ouid"));
      return doUpdate(context, unit, ouid);
   }

   //============================================================
   // <T>修改记录</T>o
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doUpdate(ILogicContext context,
                           U unit,
                           long objectId){
      FLogicTable logic = findLogic(context);
      // 检查存在性
      U oldUnit = logic.find(_classUnit, objectId);
      if(oldUnit == null){
         throw new FFatalError("Update unit is not exists. (object_id={1})", objectId);
      }
      // 更新记录处理
      EResult resultCd = onUpdateBefore(context, unit, oldUnit);
      if(resultCd == EResult.Success){
         logic.doUpdate(unit);
         resultCd = onUpdateAfter(context, unit);
      }
      return resultCd;
   }

   //============================================================
   // <T>删除记录前处理</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onDeleteBefore(ILogicContext context,
                                    U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>删除记录后处理</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   protected EResult onDeleteAfter(ILogicContext context,
                                   U unit){
      return EResult.Success;
   }

   //============================================================
   // <T>删除记录</T>
   //
   // @param context 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDelete(ILogicContext context,
                           long objectId){
      FLogicTable logic = findLogic(context);
      // 检查存在性
      U unit = logic.find(_classUnit, objectId);
      if(unit == null){
         throw new FFatalError("Delete unit is not exists. (object_id={1})", objectId);
      }
      // 删除记录处理
      EResult resultCd = onDeleteBefore(context, unit);
      if(resultCd == EResult.Success){
         logic.doDelete(unit);
         resultCd = onDeleteAfter(context, unit);
      }
      return resultCd;
   }

   //============================================================
   // <T>删除记录</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDelete(ILogicContext context,
                           U unit){
      FLogicTable logic = findLogic(context);
      // 删除记录处理
      EResult resultCd = onDeleteBefore(context, unit);
      if(resultCd == EResult.Success){
         logic.doDelete(unit);
         resultCd = onDeleteAfter(context, unit);
      }
      return resultCd;
   }
}

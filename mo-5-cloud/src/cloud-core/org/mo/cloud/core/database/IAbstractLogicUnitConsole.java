package org.mo.cloud.core.database;

import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>逻辑单元控制台基类。</T>
//============================================================
public interface IAbstractLogicUnitConsole<U extends FLogicUnit>
{
   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param context 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   U find(ILogicContext context,
          long objectId);

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param context 逻辑环境
   // @param objectId 对象编号
   // @param clazz 类对象
   // @return 处理结果
   //============================================================
   U find(ILogicContext context,
          long objectId,
          Class<U> clazz);

   //============================================================
   // <T>根据唯一码获得一个数据单元。</T>
   //
   // @param context 逻辑环境
   // @param uniqueCode 唯一码
   // @return 处理结果
   //============================================================
   U findByGuid(ILogicContext context,
                String uniqueCode);

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param context 逻辑环境
   // @param uniqueCode 唯一码
   // @param clazz 类对象
   // @return 处理结果
   //============================================================
   U findByGuid(ILogicContext context,
                String uniqueCode,
                Class<U> clazz);

   //============================================================
   // <T>准备记录</T>
   //
   // @param context 逻辑环境
   // @return 数据单元
   //============================================================
   U doPrepare(ILogicContext context);

   //============================================================
   // <T>准备记录</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   EResult doPrepare(ILogicContext context,
                     U unit);

   //============================================================
   // <T>新建记录</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   EResult doInsert(ILogicContext context,
                    U unit);

   //============================================================
   // <T>修改记录</T>o
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   EResult doUpdate(ILogicContext context,
                    U unit);

   //============================================================
   // <T>修改记录</T>o
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   EResult doUpdate(ILogicContext context,
                    U unit,
                    long objectId);

   //============================================================
   // <T>删除记录</T>
   //
   // @param context 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   EResult doDelete(ILogicContext context,
                    long objectId);

   //============================================================
   // <T>删除记录</T>
   //
   // @param context 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   EResult doDelete(ILogicContext context,
                    U unit);
}

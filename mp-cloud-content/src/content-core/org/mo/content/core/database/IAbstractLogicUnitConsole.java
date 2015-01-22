package org.mo.content.core.database;

import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>逻辑单元控制台基类。</T>
//============================================================
public interface IAbstractLogicUnitConsole<T extends FLogicUnit>
{
   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   T find(ILogicContext logicContext,
          long objectId);

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @param clazz 类对象
   // @return 处理结果
   //============================================================
   T find(ILogicContext logicContext,
          long objectId,
          Class<T> clazz);

   //============================================================
   // <T>根据唯一码获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param uniqueCode 唯一码
   // @return 处理结果
   //============================================================
   T findUnique(ILogicContext logicContext,
                String uniqueCode);

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param uniqueCode 唯一码
   // @param clazz 类对象
   // @return 处理结果
   //============================================================
   T findUnique(ILogicContext logicContext,
                String uniqueCode,
                Class<T> clazz);

   //============================================================
   // <T>新建记录</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   EResult insert(ILogicContext logicContext,
                  T unit);

   //============================================================
   // <T>修改记录</T>o
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   EResult update(ILogicContext logicContext,
                  T unit,
                  long objectId);

   //============================================================
   // <T>删除记录</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   EResult delete(ILogicContext logicContext,
                  long objectId);
}

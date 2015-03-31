package org.mo.cloud.core.database;

import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>逻辑单元控制台基类。</T>
//============================================================
public interface IAbstractLogicUnitConsole<U extends FLogicUnit>
{
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
   FLogicDataset<U> fetch(ILogicContext logicContext,
                          String whereSql,
                          String orderSql,
                          int pageSize,
                          int page);

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @return 数据单元
   //============================================================
   U find(ILogicContext logicContext,
          long objectId);

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param clazz 类对象
   // @param objectId 对象编号
   // @return 数据单元
   //============================================================
   U find(ILogicContext logicContext,
          Class<U> clazz,
          long objectId);

   //============================================================
   // <T>根据唯一码获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param uniqueCode 唯一码
   // @return 数据单元
   //============================================================
   U findByGuid(ILogicContext logicContext,
                String uniqueCode);

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param clazz 类对象
   // @param uniqueCode 唯一码
   // @return 数据单元
   //============================================================
   U findByGuid(ILogicContext logicContext,
                Class<U> clazz,
                String uniqueCode);

   //============================================================
   // <T>根据条件查找一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   U search(ILogicContext logicContext,
            String whereSql);

   //============================================================
   // <T>根据条件查找一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param clazz 类对象
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   U search(ILogicContext logicContext,
            Class<U> clazz,
            String whereSql);

   //============================================================
   // <T>准备记录</T>
   //
   // @param logicContext 逻辑环境
   // @return 数据单元
   //============================================================
   U doPrepare(ILogicContext logicContext);

   //============================================================
   // <T>准备记录</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   EResult doPrepare(ILogicContext logicContext,
                     U unit);

   //============================================================
   // <T>新建记录</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   EResult doInsert(ILogicContext logicContext,
                    U unit);

   //============================================================
   // <T>修改记录</T>o
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   EResult doUpdate(ILogicContext logicContext,
                    U unit);

   //============================================================
   // <T>修改记录</T>o
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   EResult doUpdate(ILogicContext logicContext,
                    U unit,
                    long objectId);

   //============================================================
   // <T>删除记录</T>
   //
   // @param logicContext 逻辑环境
   // @param objectId 对象编号
   // @return 处理结果
   //============================================================
   EResult doDelete(ILogicContext logicContext,
                    long objectId);

   //============================================================
   // <T>删除记录</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   EResult doDelete(ILogicContext logicContext,
                    U unit);
}

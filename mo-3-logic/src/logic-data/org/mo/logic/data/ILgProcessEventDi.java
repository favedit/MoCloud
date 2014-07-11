/*
 * @(#)ILgProcessEventDi.java
 *
 * Copyright 2008 microbject, All Rights Reserved.
 *
 */
package org.mo.logic.data;

import org.mo.com.data.FSqlFunction;
import org.mo.com.data.FSqlProcedure;
import org.mo.data.logicunit.common.ILogicUnit;

/**
 * <T>数据库逻辑包(LG_PROCESS_EVENT_DI)的代理对象接口</T>
 *
 * @author MAOCY
 * @version 1.0.1
 */
public interface ILgProcessEventDi
      extends
         ILogicUnit
{
   /**
    * <T>查询当前数据集中是否含有指定的编号</T>
    *
    * @param objectId 对象的编号
    * @return 是否含有指定编号
    */
   FSqlFunction contains(Object objectId);

   /**
    * <T>根据记录编号查找一条记录后将记录的所有字段数据打包成一个字符串</T>
    *
    * @param objectId 对象编号
    * @return 打包字符串
    */
   FSqlFunction pack(Object objectId);

   /**
    * <T>获得当前数据集对应的序列的编号</T>
    *
    * @return 序列的编号
    */
   FSqlFunction currentId();

   /**
    * <T>获得当前数据集对应的序列的下一个编号</T>
    *
    * @return 序列的编号
    */
   FSqlFunction nextId();

   /**
    * <T>获得对象的信息。</T>
    *
    * @param objectId 对象的编号
    * @return 对象信息
    */
   FSqlFunction getOinf(Object objectId);

   /**
    * <T>查询当前数据集中是否含有指定的编号。</T>
    *
    * @param ogid 对象全局标识
    * @return 是否含有指定编号
   @return 对象标识
    */
   FSqlFunction containsIdByOgid(Object ogid);

   /**
    * <T>查询当前数据集中是否含有指定的编号。</T>
    *
    * @param conditionId 条件标识
    * @param name 英文名称
    * @return 是否含有指定编号
   @return 对象标识
    */
   FSqlFunction containsIdByLink(Object conditionId,
                                 Object name);

   /**
    * <T>根据对象全局标识(<C>OGID</C>)获得当前记录的编号</T>
    * <UL>
    * <L>若存在则返回被查询的记录对象的唯一标识。</L>
    * <L>如果记录不存在，则产生记录不存在的例外。</L>
    * </UL>
    *
    * @param ogid 对象全局标识
    * @return 对象标识
    */
   FSqlFunction getIdByOgid(Object ogid);

   /**
    * <T>根据(<C>LINK</C>)获得当前记录的编号</T>
    * <UL>
    * <L>若存在则返回被查询的记录对象的唯一标识。</L>
    * <L>如果记录不存在，则产生记录不存在的例外。</L>
    * </UL>
    *
    * @param conditionId 条件标识
    * @param name 英文名称
    * @return 对象标识
    */
   FSqlFunction getIdByLink(Object conditionId,
                            Object name);

   /**
    * <T>根据对象全局标识(<C>OGID</C>)查找当前记录的编号</T>
    *
    * @param ogid 对象全局标识
    * @param exists 存在标志
    * @return 对象标识
    */
   FSqlFunction findIdByOgid(Object ogid,
                             Object exists);

   /**
    * <T>根据(<C>LINK</C>)查找当前记录的编号</T>
    *
    * @param conditionId 条件标识
    * @param name 英文名称
    * @param exists 存在标志
    * @return 对象标识
    */
   FSqlFunction findIdByLink(Object conditionId,
                             Object name,
                             Object exists);

   /**
    * <T>根据记录的编号查找对象全局标识(<C>OGID</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 对象全局标识
    */
   FSqlFunction getOgid(Object objectId);

   /**
    * <T>根据记录的编号查找对象版本(<C>OVER</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 对象版本
    */
   FSqlFunction getOver(Object objectId);

   /**
    * <T>根据记录的编号查找数据有效性(<C>OVLD</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 数据有效性
    */
   FSqlFunction getOvld(Object objectId);

   /**
    * <T>根据记录的编号查找流程标志(<C>PROCESS_TYPE_ID</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 流程标志
    */
   FSqlFunction getProcessTypeId(Object objectId);

   /**
    * <T>根据记录的编号查找条件标识(<C>CONDITION_ID</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 条件标识
    */
   FSqlFunction getConditionId(Object objectId);

   /**
    * <T>根据记录的编号查找英文名称(<C>NAME</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 英文名称
    */
   FSqlFunction getName(Object objectId);

   /**
    * <T>根据记录的编号查找中文名称(<C>LABEL</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 中文名称
    */
   FSqlFunction getLabel(Object objectId);

   /**
    * <T>根据记录的编号查找执行类型(<C>EVENT_EXECUTE</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 执行类型
    */
   FSqlFunction getEventExecute(Object objectId);

   /**
    * <T>根据记录的编号查找执行类型(<C>EVENT_EXECUTE</C>)的显示内容</T>
    *
    * @param objectId 记录的编号
    * @return 执行类型
    */
   FSqlFunction getEventExecuteLabel(Object objectId);

   /**
    * <T>根据记录的编号查找事件分组标识(<C>EVENT_GROUP_ID</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 事件分组标识
    */
   FSqlFunction getEventGroupId(Object objectId);

   /**
    * <T>根据记录的编号查找事件类型标识(<C>EVENT_TYPE_ID</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 事件类型标识
    */
   FSqlFunction getEventTypeId(Object objectId);

   /**
    * <T>根据记录的编号查找优先级(<C>EVENT_PRIORITY_CD</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 优先级
    */
   FSqlFunction getEventPriorityCd(Object objectId);

   /**
    * <T>根据记录的编号查找优先级(<C>EVENT_PRIORITY_CD</C>)的显示内容</T>
    *
    * @param objectId 记录的编号
    * @return 优先级
    */
   FSqlFunction getEventPriorityLabel(Object objectId);

   /**
    * <T>根据记录的编号查找处理结果(<C>PROCESS_RESULT</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 处理结果
    */
   FSqlFunction getProcessResult(Object objectId);

   /**
    * <T>根据记录的编号查找处理顺序(<C>PROCESS_ORDER</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 处理顺序
    */
   FSqlFunction getProcessOrder(Object objectId);

   /**
    * <T>根据记录的编号查找创建日期(<C>CREATE_DATE</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 创建日期
    */
   FSqlFunction getCreateDate(Object objectId);

   /**
    * <T>根据记录的编号查找描述信息(<C>NOTE</C>)的数据内容</T>
    *
    * @param objectId 记录的编号
    * @return 描述信息
    */
   FSqlFunction getNote(Object objectId);

   /**
    * <T>将打包字符串的内容解包后按照名称和一个指定的记录对象进行合并操作实现和前台同步的作用</T>
    * <P>打包字符串的格式：
    * 流程事件表字段=字段内容
    * 流程类型名称=名称内容
    * 流程条件名称=名称内容
    * </P>
    *
    * @param logic 业务逻辑
    * @param params 打包字符串
    */
   FSqlProcedure doSyncProcessEvent(Object logic,
                                    Object params);

   /**
    * <T>根据对象编号锁定一条记录</T>
    * <UL>
    * <L>如果记录不存在，则产生记录不存在的例外</L>
    * <L>如果其他用户已经锁定该记录，则产生锁定失败的例外。</L>
    * </UL>
    *
    * @param objectId 对象编号
    */
   FSqlProcedure lockRecord(Object objectId);

   /**
    * <T>锁定当前数据集防止任何对数据的非法操作</T>
    * <UL>
    * <L><C9>ROW SHARE</C9>: 行记录共享模式</L>
    * <L><C9>ROW EXCLUSIVE</C9>: 行记录排他模式</L>
    * <L><C9>SHARE UPDATE</C9>: 行更新模式</L>
    * <L><C9>SHARE</C9>: 共享模式</L>
    * <L><C9>SHARE ROW EXCLUSIVE</C9>: 共享行排他模式</L>
    * <L><C9>EXCLUSIVE</C9>: 排他模式</L>
    * <L>默认为排他模式</L>
    * </UL>
    *
    * @param mode 锁定的类型
    */
   FSqlProcedure lockTable(Object mode);

   /**
    * <T>新建一条记录的时对数据对象进行初始化</T>
    *
    * @param logic 业务逻辑
    * @param params 打包字符串
    */
   FSqlProcedure prepare(Object logic,
                         Object params);

   /**
    * <T>在数据集内新建一条记录</T>
    *
    * @param logic 业务逻辑
    * @param params 打包字符串
    * @param check 检查标志
    */
   FSqlProcedure doInsert(Object logic,
                          Object params,
                          Object check);

   /**
    * <T>根据记录的编号修改一条记录</T>
    *
    * @param logic 业务逻辑
    * @param params 打包字符串
    * @param objectId 记录的编号
    * @param check 检查标志
    */
   FSqlProcedure doUpdate(Object logic,
                          Object params,
                          Object objectId,
                          Object check);

   /**
    * <T>根据记录的编号和数据集同步一条记录</T>
    * <UL>
    * <L>如果指定的记录不存在，进行新建处理。</L>
    * <L>如果指定的记录存在，进行更新处理。</L>
    * </UL>
    *
    * @param logic 业务逻辑
    * @param params 打包字符串
    * @param objectId 记录的编号
    * @param check 检查标志
    */
   FSqlProcedure doSync(Object logic,
                        Object params,
                        Object objectId,
                        Object check);

   /**
    * <T>根据记录的编号删除一条记录</T>
    *
    * @param logic 业务逻辑
    * @param params 打包字符串
    * @param objectId 记录的编号
    * @param check 检查标志
    */
   FSqlProcedure doDelete(Object logic,
                          Object params,
                          Object objectId,
                          Object check);

   /**
    * <T>清空当前数据集的全部记录</T>
    *
    */
   FSqlProcedure doClear();

   /**
    * <T>在数据集内新建一条记录</T>
    *
    * @param logic_ 业务逻辑
    * @param params_ 打包字符串
    */
   FSqlProcedure doInsert(Object logic,
                          Object params);

   /**
    * <T>根据记录的编号修改一条记录</T>
    *
    * @param logic_ 业务逻辑
    * @param params_ 打包字符串
    */
   FSqlProcedure doUpdate(Object logic,
                          Object params);

   /**
    * <T>根据记录的编号和数据集同步一条记录</T>
    * <UL>
    * <L>如果指定的记录不存在，进行新建处理。</L>
    * <L>如果指定的记录存在，进行更新处理。</L>
    * </UL>
    *
    * @param logic_ 业务逻辑
    * @param params_ 打包字符串
    */
   FSqlProcedure doSync(Object logic,
                        Object params);

   /**
    * <T>根据记录的编号删除一条记录</T>
    *
    * @param logic_ 业务逻辑
    * @param params_ 打包字符串
    */
   FSqlProcedure doDelete(Object logic,
                          Object params);
}

package com.cyou.gccloud.data.statistics;

import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FString;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.FLogicTable;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;
import org.mo.data.logic.SLogicConnectionInfo;
import org.mo.data.logic.SLogicFieldInfo;
import org.mo.data.logic.SLogicTableInfo;

//============================================================
// <T>业务活动统计表逻辑。</T>
//============================================================
@ASourceMachine
public class FStatisticsLoggerActivityLogic
      extends FLogicTable
{
   // 业务活动统计表的定义。
   public final static SLogicConnectionInfo CONNECTION = new SLogicConnectionInfo("statistics");

   // 业务活动统计表的定义。
   public final static SLogicTableInfo TABLE = new SLogicTableInfo("statistics.logger.activity", "ST_LGC_ACTIVITY");

   // 字段对象标识的定义。
   public final static SLogicFieldInfo OUID = new SLogicFieldInfo("OUID");

   // 字段有效性的定义。
   public final static SLogicFieldInfo OVLD = new SLogicFieldInfo("OVLD");

   // 字段对象唯一标识的定义。
   public final static SLogicFieldInfo GUID = new SLogicFieldInfo("GUID");

   // 字段记录年的定义。
   public final static SLogicFieldInfo RECORD_YEAR = new SLogicFieldInfo("RECORD_YEAR");

   // 字段记录月的定义。
   public final static SLogicFieldInfo RECORD_MONTH = new SLogicFieldInfo("RECORD_MONTH");

   // 字段记录周的定义。
   public final static SLogicFieldInfo RECORD_WEEK = new SLogicFieldInfo("RECORD_WEEK");

   // 字段记录日的定义。
   public final static SLogicFieldInfo RECORD_DAY = new SLogicFieldInfo("RECORD_DAY");

   // 字段记录小时的定义。
   public final static SLogicFieldInfo RECORD_HOUR = new SLogicFieldInfo("RECORD_HOUR");

   // 字段记录日期的定义。
   public final static SLogicFieldInfo RECORD_DATE = new SLogicFieldInfo("RECORD_DATE");

   // 字段活动编号的定义。
   public final static SLogicFieldInfo ACTIVITY_ID = new SLogicFieldInfo("ACTIVITY_ID");

   // 字段参加总数的定义。
   public final static SLogicFieldInfo JOIN_TOTAL = new SLogicFieldInfo("JOIN_TOTAL");

   // 字段参加人数的定义。
   public final static SLogicFieldInfo JOIN_COUNT = new SLogicFieldInfo("JOIN_COUNT");

   // 字段提交作品总数的定义。
   public final static SLogicFieldInfo SUBMIT_TOTAL = new SLogicFieldInfo("SUBMIT_TOTAL");

   // 字段提交作品个数的定义。
   public final static SLogicFieldInfo SUBMIT_COUNT = new SLogicFieldInfo("SUBMIT_COUNT");

   // 字段创建用户标识的定义。
   public final static SLogicFieldInfo CREATE_USER_ID = new SLogicFieldInfo("CREATE_USER_ID");

   // 字段创建日期的定义。
   public final static SLogicFieldInfo CREATE_DATE = new SLogicFieldInfo("CREATE_DATE");

   // 字段更新者标识的定义。
   public final static SLogicFieldInfo UPDATE_USER_ID = new SLogicFieldInfo("UPDATE_USER_ID");

   // 字段更新时间的定义。
   public final static SLogicFieldInfo UPDATE_DATE = new SLogicFieldInfo("UPDATE_DATE");

   // 字段集合的定义。
   public final static String FIELDS = "OUID,OVLD,GUID,RECORD_YEAR,RECORD_MONTH,RECORD_WEEK,RECORD_DAY,RECORD_HOUR,RECORD_DATE,ACTIVITY_ID,JOIN_TOTAL,JOIN_COUNT,SUBMIT_TOTAL,SUBMIT_COUNT,CREATE_USER_ID,CREATE_DATE,UPDATE_USER_ID,UPDATE_DATE";

   //============================================================
   // <T>构造业务活动统计表逻辑单元。</T>
   //============================================================
   public FStatisticsLoggerActivityLogic(){
      _name = TABLE.name();
      _classUnit = FStatisticsLoggerActivityUnit.class;
   }

   //============================================================
   // <T>构造业务活动统计表逻辑单元。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FStatisticsLoggerActivityLogic(ILogicContext context){
      super(context);
      _name = TABLE.name();
      _classUnit = FStatisticsLoggerActivityUnit.class;
   }

   //============================================================
   // <T>获得数据链接信息。</T>
   //
   // @return 数据链接
   //============================================================
   @Override
   public SLogicConnectionInfo connectionInfo(){
      return CONNECTION;
   }

   //============================================================
   // <T>获得数据集合信息。</T>
   //
   // @return 数据集合链接
   //============================================================
   @Override
   public SLogicTableInfo tableInfo(){
      return TABLE;
   }

   //============================================================
   // <T>根据编号生成查询字符串。</T>
   //
   // @param fields 选取字段
   // @param id 编号
   // @return 查询字符串
   //============================================================
   public String makeFindSql(CharSequence fields,
                             long id){
      FString sql = new FString("SELECT ");
      if(RString.isEmpty(fields)){
         sql.append(FIELDS);
      }else{
         sql.append(fields);
      }
      sql.append(" FROM ");
      sql.append(_name);
      sql.append(" WHERE OUID=");
      sql.append(id);
      return sql.toString();
   }

   //============================================================
   // <T>根据信息生成查询字符串。</T>
   //
   // @param fields 选取字段
   // @param whereSql 条件命令
   // @param groupSql 分组命令
   // @param orderSql 排序命令
   // @param position 位置
   // @param count 总数
   // @return 查询字符串
   //============================================================
   public String makeFetchSql(CharSequence fields,
                              CharSequence whereSql,
                              CharSequence groupSql,
                              CharSequence orderSql,
                              int position,
                              int count){
      // 生成选取
      FString sql = new FString("SELECT ");
      if(RString.isEmpty(fields)){
         sql.append(FIELDS);
      }else{
         sql.append(fields);
      }
      sql.append(" FROM ");
      sql.append(_name);
      // 生成条件
      if(!RString.isEmpty(whereSql)){
         sql.append(" WHERE ");
         sql.append(whereSql);
      }
      // 生成分组
      if(!RString.isEmpty(groupSql)){
         sql.append(" GROUP BY ");
         sql.append(groupSql);
      }
      // 生成排序
      if(!RString.isEmpty(orderSql)){
         sql.append(" ORDER BY ");
         sql.append(orderSql);
      }
      // 生成结果限制
      if(position > 0 || count > 0){
         sql.append(" LIMIT ");
         if(position > 0){
            sql.append(position);
            sql.append(',');
            sql.append(count);
         }else{
            sql.append(count);
         }
      }
      return sql.toString();
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param clazz 类对象
   // @param recordId 记录编号
   // @return 是否获得
   //============================================================
   @Override
   @SuppressWarnings("unchecked")
   public <T extends FLogicUnit> T find(T unit,
                                        Class<T> clazz,
                                        long recordId){
      // 检查编号
      if(recordId <= 0){
         return null;
      }
      // 生成命令
      FSql cmd = new FSql("SELECT ");
      cmd.append(FIELDS);
      cmd.append(" FROM ");
      cmd.append(_name);
      cmd.append(" WHERE OUID=");
      cmd.append(recordId);
      String sql = cmd.toString();
      // 获得行记录
      FRow row = innerFindRow(recordId, sql);
      // 检查结果
      if(row == null){
         return null;
      }
      // 获得数据
      if(unit == null){
         if(clazz == null){
            unit = (T)(new FStatisticsLoggerActivityUnit());
         }else{
            unit = RClass.newInstance(clazz);
         }
      }
      unit.linkLogicContext(_logicContext);
      unit.load(row);
      return unit;
   }

   //============================================================
   // <T>根据条件获得一个数据单元。</T>
   //
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   public FStatisticsLoggerActivityUnit search(CharSequence whereSql){
      return search(null, FStatisticsLoggerActivityUnit.class, whereSql);
   }

   //============================================================
   // <T>根据条件获得一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param clazz 类对象
   // @param whereSql 条件
   // @return 是否获得
   //============================================================
   @Override
   public <T extends FLogicUnit> T search(T unit,
                                          Class<T> clazz,
                                          CharSequence whereSql){
      // 检查条件
      if(RString.isEmpty(whereSql)){
         return null;
      }
      // 生成命令
      FSql cmd = new FSql("SELECT ");
      cmd.append(FIELDS);
      cmd.append(" FROM ");
      cmd.append(_name);
      cmd.append(" WHERE ");
      cmd.append(whereSql);
      String sql = cmd.toString();
      // 获得数据
      return searchSql(unit, clazz, whereSql, sql);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsLoggerActivityUnit> fetch(int pageSize,
                                                             int page){
      return fetchClass(null, null, null, null, null, pageSize, page);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsLoggerActivityUnit> fetch(CharSequence whereSql,
                                                             int pageSize,
                                                             int page){
      return fetchClass(null, null, whereSql, null, null, pageSize, page);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsLoggerActivityUnit> fetch(CharSequence whereSql,
                                                             CharSequence orderSql,
                                                             int pageSize,
                                                             int page){
      return fetchClass(null, null, whereSql, null, orderSql, pageSize, page);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param fields 选取字段
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsLoggerActivityUnit> fetch(CharSequence fields,
                                                             CharSequence whereSql,
                                                             CharSequence orderSql,
                                                             int pageSize,
                                                             int page){
      return fetchClass(null, fields, whereSql, null, orderSql, pageSize, page);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param fields 选取字段
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsLoggerActivityUnit> fetch(CharSequence fields,
                                                             CharSequence whereSql,
                                                             CharSequence groupSql,
                                                             CharSequence orderSql,
                                                             int pageSize,
                                                             int page){
      return fetchClass(null, fields, whereSql, groupSql, orderSql, pageSize, page);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param clazz 单元类型
   // @param whereSql 条件命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz,
                                                             CharSequence whereSql,
                                                             int pageSize,
                                                             int page){
      // 生成命令
      String code = innerMemcacheKey(null, whereSql, null, null);
      String sql = makeFetchSql(null, whereSql, null, null, 0, 0);
      // 获得数据
      return fetchSql(clazz, code, sql, pageSize, page);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param clazz 单元类型
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz,
                                                             CharSequence whereSql,
                                                             CharSequence orderSql,
                                                             int pageSize,
                                                             int page){
      // 生成命令
      String code = innerMemcacheKey(null, whereSql, null, orderSql);
      String sql = makeFetchSql(null, whereSql, null, orderSql, 0, 0);
      // 获得数据
      return fetchSql(clazz, code, sql, pageSize, page);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param clazz 单元类型
   // @param fields 选取字段
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz,
                                                             CharSequence fields,
                                                             CharSequence whereSql,
                                                             CharSequence orderSql,
                                                             int pageSize,
                                                             int page){
      // 生成命令
      String code = innerMemcacheKey(fields, whereSql, null, orderSql);
      String sql = makeFetchSql(fields, whereSql, null, orderSql, 0, 0);
      // 获得数据
      return fetchSql(clazz, code, sql, pageSize, page);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param clazz 单元类型
   // @param fields 选取字段
   // @param whereSql 条件命令
   // @param groupSql 分组命令
   // @param orderSql 排序命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz,
                                                             CharSequence fields,
                                                             CharSequence whereSql,
                                                             CharSequence groupSql,
                                                             CharSequence orderSql,
                                                             int pageSize,
                                                             int page){
      // 生成命令
      String code = innerMemcacheKey(fields, whereSql, groupSql, orderSql);
      String sql = makeFetchSql(fields, whereSql, groupSql, orderSql, 0, 0);
      // 获得数据
      return fetchSql(clazz, code, sql, pageSize, page);
   }

   //============================================================
   // <T>根据查询命令获得数据单元集合。</T>
   //
   // @param code 代码
   // @param sql 查询命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsLoggerActivityUnit> fetchSql(CharSequence code,
                                                                CharSequence sql,
                                                                int pageSize,
                                                                int page){
      return fetchSql(null, code, sql, pageSize, page);
   }

   //============================================================
   // <T>根据查询命令获得数据单元集合。</T>
   //
   // @param clazz 单元类型
   // @param code 代码
   // @param sql 查询命令
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   @SuppressWarnings("unchecked")
   public <T extends FLogicUnit> FLogicDataset<T> fetchSql(Class<T> clazz,
                                                           CharSequence code,
                                                           CharSequence sql,
                                                           int pageSize,
                                                           int page){
      // 获得数据
      FDataset dataset = innerFindDataset(code, sql, pageSize, page);
      // 返回结果
      FLogicDataset<T> result = null;
      if(clazz == null){
         result = (FLogicDataset<T>)(new FLogicDataset<FStatisticsLoggerActivityUnit>(FStatisticsLoggerActivityUnit.class, _logicContext));
      }else{
         result = new FLogicDataset<T>(clazz, _logicContext);
      }
      result.loadDataset(dataset);
      return result;
   }

   //============================================================
   // <T>获得全部数据单元集合。</T>
   //
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsLoggerActivityUnit> fetchAll(){
      // 生成命令
      String code = "null|null|null";
      String sql = makeFetchSql(null, null, null, null, 0, 0);
      // 获得数据
      return fetchSql(null, code, sql, 0, 0);
   }

   //============================================================
   // <T>准备一个数据单元。</T>
   //
   // @return 数据单元
   //============================================================
   public FStatisticsLoggerActivityUnit doPrepare(){
      FStatisticsLoggerActivityUnit unit = new FStatisticsLoggerActivityUnit();
      unit.linkLogicContext(_logicContext);
      doPrepare(unit);
      return unit;
   }

   //============================================================
   // <T>准备一个数据单元。</T>
   //
   // @param clazz 类型
   // @return 数据单元
   //============================================================
   public <T extends FLogicUnit> T doPrepare(Class<T> clazz){
      T unit = RClass.newInstance(clazz);
      unit.linkLogicContext(_logicContext);
      doPrepare(unit);
      return unit;
   }

   //============================================================
   // <T>准备一个数据单元。</T>
   //
   // @param logicUnit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doPrepare(FLogicUnit logicUnit){
      FStatisticsLoggerActivityUnit unit = (FStatisticsLoggerActivityUnit)logicUnit;
      unit.setOvld(true);
      unit.setGuid(RUuid.makeUniqueId());
      return EResult.Success;
   }

   //============================================================
   // <T>插入一个数据单元。</T>
   //
   // @param logicUnit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doInsert(FLogicUnit logicUnit){
      FStatisticsLoggerActivityUnit unit = (FStatisticsLoggerActivityUnit)logicUnit;
      // 设置操作用户
      if((unit.createUserId() == 0) || (unit.updateUserId() == 0)){
         long operatorId = currentOperatorId();
         if(unit.createUserId() == 0){
            unit.setCreateUserId(operatorId);
         }
         if(unit.updateUserId() == 0){
            unit.setUpdateUserId(operatorId);
         }
      }
      // 生成命令
      FSql cmd = new FSql("INSERT INTO ");
      cmd.append(_name);
      cmd.append("(");
      cmd.append("`OVLD`");
      cmd.append(",`GUID`");
      cmd.append(",`RECORD_YEAR`");
      cmd.append(",`RECORD_MONTH`");
      cmd.append(",`RECORD_WEEK`");
      cmd.append(",`RECORD_DAY`");
      cmd.append(",`RECORD_HOUR`");
      cmd.append(",`RECORD_DATE`");
      cmd.append(",`ACTIVITY_ID`");
      cmd.append(",`JOIN_TOTAL`");
      cmd.append(",`JOIN_COUNT`");
      cmd.append(",`SUBMIT_TOTAL`");
      cmd.append(",`SUBMIT_COUNT`");
      cmd.append(",`CREATE_USER_ID`");
      cmd.append(",`CREATE_DATE`");
      cmd.append(",`UPDATE_USER_ID`");
      cmd.append(",`UPDATE_DATE`");
      cmd.append(") VALUES(");
      cmd.append(unit.ovld());
      cmd.append(',');
      String guid = unit.guid();
      if(RString.isEmpty(guid)){
         guid = RUuid.makeUniqueId();
      }
      cmd.append('\'');
      cmd.append(guid);
      cmd.append('\'');
      cmd.append(',');
      TDateTime recordYear = unit.recordYear();
      if(recordYear == null){
         cmd.append("NULL");
      }else if(recordYear.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(recordYear.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime recordMonth = unit.recordMonth();
      if(recordMonth == null){
         cmd.append("NULL");
      }else if(recordMonth.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(recordMonth.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime recordWeek = unit.recordWeek();
      if(recordWeek == null){
         cmd.append("NULL");
      }else if(recordWeek.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(recordWeek.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime recordDay = unit.recordDay();
      if(recordDay == null){
         cmd.append("NULL");
      }else if(recordDay.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(recordDay.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime recordHour = unit.recordHour();
      if(recordHour == null){
         cmd.append("NULL");
      }else if(recordHour.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(recordHour.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime recordDate = unit.recordDate();
      if(recordDate == null){
         cmd.append("NULL");
      }else if(recordDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(recordDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      long activityId = unit.activityId();
      if(activityId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(activityId);
      }
      cmd.append(',');
      cmd.append(unit.joinTotal());
      cmd.append(',');
      cmd.append(unit.joinCount());
      cmd.append(',');
      cmd.append(unit.submitTotal());
      cmd.append(',');
      cmd.append(unit.submitCount());
      // 设置更新信息
      cmd.append("," + unit.createUserId());
      if(unit.createDate().isEmpty()){
         cmd.append(",NOW()");
      }else{
         cmd.append(",STR_TO_DATE('");
         cmd.append(unit.createDate().format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append("," + unit.updateUserId());
      if(unit.updateDate().isEmpty()){
         cmd.append(",NOW()");
      }else{
         cmd.append(",STR_TO_DATE('");
         cmd.append(unit.updateDate().format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(')');
      // 执行命令
      String sql = cmd.toString();
      long recordId = _connection.executeInsertSql(sql);
      unit.setOuid(recordId);
      // 删除缓冲
      innerDeleteRow(recordId);
      return EResult.Success;
   }

   //============================================================
   // <T>更新一个数据单元。</T>
   //
   // @param logicUnit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doUpdate(FLogicUnit logicUnit){
      FStatisticsLoggerActivityUnit unit = (FStatisticsLoggerActivityUnit)logicUnit;
      // 检查参数
      if(unit == null){
         throw new FFatalError("Logic unit is null.");
      }
      // 更新处理
      return doUpdate(unit, unit.ouid());
   }

   //============================================================
   // <T>更新一个数据单元。</T>
   //
   // @param logicUnit 数据单元
   // @param recordId 记录编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doUpdate(FLogicUnit logicUnit,
                           long recordId){
      FStatisticsLoggerActivityUnit unit = (FStatisticsLoggerActivityUnit)logicUnit;
      // 检查参数
      if(unit == null){
         throw new FFatalError("Logic unit is null.");
      }
      if(recordId <= 0){
         throw new FFatalError("Record id is empty. (record_id={1})", recordId);
      }
      // 删除缓冲
      innerDeleteRow(recordId);
      // 设置操作用户
      if(unit.updateUserId() == 0){
         long operatorId = currentOperatorId();
         unit.setUpdateUserId(operatorId);
      }
      // 生成命令
      FSql cmd = new FSql("UPDATE ");
      cmd.append(_name);
      cmd.append(" SET OVLD=");
      cmd.append(unit.ovld());
      if(unit.isRecordYearChanged()){
         cmd.append(",`RECORD_YEAR`=");
         TDateTime recordYear = unit.recordYear();
         if(recordYear == null){
            cmd.append("NULL");
         }else if(recordYear.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(recordYear.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isRecordMonthChanged()){
         cmd.append(",`RECORD_MONTH`=");
         TDateTime recordMonth = unit.recordMonth();
         if(recordMonth == null){
            cmd.append("NULL");
         }else if(recordMonth.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(recordMonth.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isRecordWeekChanged()){
         cmd.append(",`RECORD_WEEK`=");
         TDateTime recordWeek = unit.recordWeek();
         if(recordWeek == null){
            cmd.append("NULL");
         }else if(recordWeek.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(recordWeek.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isRecordDayChanged()){
         cmd.append(",`RECORD_DAY`=");
         TDateTime recordDay = unit.recordDay();
         if(recordDay == null){
            cmd.append("NULL");
         }else if(recordDay.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(recordDay.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isRecordHourChanged()){
         cmd.append(",`RECORD_HOUR`=");
         TDateTime recordHour = unit.recordHour();
         if(recordHour == null){
            cmd.append("NULL");
         }else if(recordHour.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(recordHour.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isRecordDateChanged()){
         cmd.append(",`RECORD_DATE`=");
         TDateTime recordDate = unit.recordDate();
         if(recordDate == null){
            cmd.append("NULL");
         }else if(recordDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(recordDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isActivityIdChanged()){
         cmd.append(",`ACTIVITY_ID`=");
         long activityId = unit.activityId();
         if(activityId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(activityId);
         }
      }
      if(unit.isJoinTotalChanged()){
         cmd.append(",`JOIN_TOTAL`=");
         cmd.append(unit.joinTotal());
      }
      if(unit.isJoinCountChanged()){
         cmd.append(",`JOIN_COUNT`=");
         cmd.append(unit.joinCount());
      }
      if(unit.isSubmitTotalChanged()){
         cmd.append(",`SUBMIT_TOTAL`=");
         cmd.append(unit.submitTotal());
      }
      if(unit.isSubmitCountChanged()){
         cmd.append(",`SUBMIT_COUNT`=");
         cmd.append(unit.submitCount());
      }
      cmd.append(",UPDATE_USER_ID=" + unit.updateUserId() + ",UPDATE_DATE=NOW()");
      cmd.append(" WHERE OUID=");
      cmd.append(recordId);
      // 执行命令
      String sql = cmd.toString();
      boolean result = _connection.executeSql(sql);
      if(result){
         return EResult.Success;
      }
      return EResult.Failure;
   }

   //============================================================
   // <T>删除一个数据单元。</T>
   //
   // @param logicUnit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDelete(FLogicUnit logicUnit){
      FStatisticsLoggerActivityUnit unit = (FStatisticsLoggerActivityUnit)logicUnit;
      // 检查参数
      if(unit == null){
         throw new FFatalError("Logic unit is null.");
      }
      // 更新处理
      return doDelete(unit, unit.ouid());
   }

   //============================================================
   // <T>删除一个数据单元。</T>
   //
   // @param logicUnit 数据单元
   // @param recordId 记录编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDelete(FLogicUnit logicUnit,
                           long recordId){
      // 检查记录编号
      if(recordId <= 0){
         throw new FFatalError("Record id is empty. (record_id={1})", recordId);
      }
      // 删除缓冲
      innerDeleteRow(recordId);
      // 生成命令
      FSql cmd = new FSql("DELETE FROM ");
      cmd.append(_name);
      cmd.append(" WHERE OUID=");
      cmd.append(recordId);
      // 执行命令
      String sql = cmd.toString();
      boolean result = _connection.executeSql(sql);
      if(result){
         return EResult.Success;
      }
      return EResult.Failure;
   }

   //============================================================
   // <T>清除所有数据单元。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public EResult doClear(){
      String sql = "DELETE FROM " + _name;
      return executeSql(sql);
   }
}

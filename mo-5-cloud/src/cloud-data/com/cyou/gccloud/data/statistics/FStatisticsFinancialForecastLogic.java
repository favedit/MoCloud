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
// <T>数据预测表逻辑。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialForecastLogic
      extends FLogicTable
{
   // 数据预测表的定义。
   public final static SLogicConnectionInfo CONNECTION = new SLogicConnectionInfo("statistics");

   // 数据预测表的定义。
   public final static SLogicTableInfo TABLE = new SLogicTableInfo("statistics.financial.forecast", "ST_FIN_FORECAST");

   // 字段对象标识的定义。
   public final static SLogicFieldInfo OUID = new SLogicFieldInfo("OUID");

   // 字段有效性的定义。
   public final static SLogicFieldInfo OVLD = new SLogicFieldInfo("OVLD");

   // 字段对象唯一标识的定义。
   public final static SLogicFieldInfo GUID = new SLogicFieldInfo("GUID");

   // 字段命令时间的定义。
   public final static SLogicFieldInfo ACTION_DATE = new SLogicFieldInfo("ACTION_DATE");

   // 字段投资的定义。
   public final static SLogicFieldInfo INVESTMENT = new SLogicFieldInfo("INVESTMENT");

   // 字段投资总计的定义。
   public final static SLogicFieldInfo INVESTMENT_TOTAL = new SLogicFieldInfo("INVESTMENT_TOTAL");

   // 字段赎回的定义。
   public final static SLogicFieldInfo REDEMPTION = new SLogicFieldInfo("REDEMPTION");

   // 字段赎回总计的定义。
   public final static SLogicFieldInfo REDEMPTION_TOTAL = new SLogicFieldInfo("REDEMPTION_TOTAL");

   // 字段净投的定义。
   public final static SLogicFieldInfo NETINVESTMENT = new SLogicFieldInfo("NETINVESTMENT");

   // 字段净投总计的定义。
   public final static SLogicFieldInfo NETINVESTMENT_TOTAL = new SLogicFieldInfo("NETINVESTMENT_TOTAL");

   // 字段利息的定义。
   public final static SLogicFieldInfo INTEREST = new SLogicFieldInfo("INTEREST");

   // 字段利息总计的定义。
   public final static SLogicFieldInfo INTEREST_TOTAL = new SLogicFieldInfo("INTEREST_TOTAL");

   // 字段绩效的定义。
   public final static SLogicFieldInfo PERFORMANCE = new SLogicFieldInfo("PERFORMANCE");

   // 字段绩效总计的定义。
   public final static SLogicFieldInfo PERFORMANCE_TOTAL = new SLogicFieldInfo("PERFORMANCE_TOTAL");

   // 字段客户数量的定义。
   public final static SLogicFieldInfo CUSTOMER_COUNT = new SLogicFieldInfo("CUSTOMER_COUNT");

   // 字段客户总数的定义。
   public final static SLogicFieldInfo CUSTOMER_TOTAL = new SLogicFieldInfo("CUSTOMER_TOTAL");

   // 字段创建用户标识的定义。
   public final static SLogicFieldInfo CREATE_USER_ID = new SLogicFieldInfo("CREATE_USER_ID");

   // 字段创建日期的定义。
   public final static SLogicFieldInfo CREATE_DATE = new SLogicFieldInfo("CREATE_DATE");

   // 字段更新者标识的定义。
   public final static SLogicFieldInfo UPDATE_USER_ID = new SLogicFieldInfo("UPDATE_USER_ID");

   // 字段更新时间的定义。
   public final static SLogicFieldInfo UPDATE_DATE = new SLogicFieldInfo("UPDATE_DATE");

   // 字段集合的定义。
   public final static String FIELDS = "`OUID`,`OVLD`,`GUID`,`ACTION_DATE`,`INVESTMENT`,`INVESTMENT_TOTAL`,`REDEMPTION`,`REDEMPTION_TOTAL`,`NETINVESTMENT`,`NETINVESTMENT_TOTAL`,`INTEREST`,`INTEREST_TOTAL`,`PERFORMANCE`,`PERFORMANCE_TOTAL`,`CUSTOMER_COUNT`,`CUSTOMER_TOTAL`,`CREATE_USER_ID`,`CREATE_DATE`,`UPDATE_USER_ID`,`UPDATE_DATE`";

   //============================================================
   // <T>构造数据预测表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialForecastLogic(){
      _name = TABLE.name();
      _classUnit = FStatisticsFinancialForecastUnit.class;
   }

   //============================================================
   // <T>构造数据预测表逻辑单元。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FStatisticsFinancialForecastLogic(ILogicContext context){
      super(context);
      _name = TABLE.name();
      _classUnit = FStatisticsFinancialForecastUnit.class;
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
            unit = (T)(new FStatisticsFinancialForecastUnit());
         }else{
            unit = RClass.newInstance(clazz);
         }
      }
      unit.linkLogicContext(_logicContext);
      unit.load(row);
      return unit;
   }

   //============================================================
   // <T>根据唯一编号获得一个数据单元。</T>
   //
   // @param guid 唯一编号
   // @return 数据单元
   //============================================================
   public FStatisticsFinancialForecastUnit findByGuid(CharSequence guid){
      return findByGuid(null, FStatisticsFinancialForecastUnit.class, guid);
   }

   //============================================================
   // <T>根据唯一编号获得一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param clazz 类对象
   // @param guid 唯一编号
   // @return 是否获得
   //============================================================
   @Override
   public <T extends FLogicUnit> T findByGuid(T unit,
                                              Class<T> clazz,
                                              CharSequence guid){
      // 检查条件
      if(RString.isEmpty(guid)){
         return null;
      }
      // 生成命令
      FSql cmd = new FSql("SELECT ");
      cmd.append(FIELDS);
      cmd.append(" FROM ");
      cmd.append(_name);
      cmd.append(" WHERE GUID='");
      cmd.append(guid);
      cmd.append("'");
      String sql = cmd.toString();
      // 获得数据
      return searchSql(unit, clazz, guid, sql);
   }

   //============================================================
   // <T>根据条件获得一个数据单元。</T>
   //
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   public FStatisticsFinancialForecastUnit search(CharSequence whereSql){
      return search(null, FStatisticsFinancialForecastUnit.class, whereSql);
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
   // @param whereSql 条件
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsFinancialForecastUnit> fetch(CharSequence whereSql){
      return fetchClass(null, null, whereSql, null, null, -1, 0);
   }

   //============================================================
   // <T>获得数据单元集合。</T>
   //
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsFinancialForecastUnit> fetch(int pageSize,
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
   public FLogicDataset<FStatisticsFinancialForecastUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FStatisticsFinancialForecastUnit> fetch(CharSequence whereSql,
                                                                CharSequence orderSql){
      return fetchClass(null, null, whereSql, null, orderSql, -1, 0);
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
   public FLogicDataset<FStatisticsFinancialForecastUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FStatisticsFinancialForecastUnit> fetch(CharSequence fields,
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
   public FLogicDataset<FStatisticsFinancialForecastUnit> fetch(CharSequence fields,
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
   // @return 数据单元集合
   //============================================================
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz,
                                                             CharSequence whereSql){
      // 生成命令
      String code = innerMemcacheKey(null, whereSql, null, null);
      String sql = makeFetchSql(null, whereSql, null, null, 0, 0);
      // 获得数据
      return fetchSql(clazz, code, sql, 0, 0);
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
                                                             CharSequence orderSql){
      // 生成命令
      String code = innerMemcacheKey(null, whereSql, null, orderSql);
      String sql = makeFetchSql(null, whereSql, null, orderSql, 0, 0);
      // 获得数据
      return fetchSql(clazz, code, sql, 0, 0);
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
   public FLogicDataset<FStatisticsFinancialForecastUnit> fetchSql(CharSequence code,
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
         result = (FLogicDataset<T>)(new FLogicDataset<FStatisticsFinancialForecastUnit>(FStatisticsFinancialForecastUnit.class, _logicContext));
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
   public FLogicDataset<FStatisticsFinancialForecastUnit> fetchAll(){
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
   public FStatisticsFinancialForecastUnit doPrepare(){
      FStatisticsFinancialForecastUnit unit = new FStatisticsFinancialForecastUnit();
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
      FStatisticsFinancialForecastUnit unit = (FStatisticsFinancialForecastUnit)logicUnit;
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
      FStatisticsFinancialForecastUnit unit = (FStatisticsFinancialForecastUnit)logicUnit;
      long ouid = unit.ouid();
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
      if(ouid > 0){
         cmd.append("`OUID`,");
      }
      cmd.append("`OVLD`");
      cmd.append(",`GUID`");
      cmd.append(",`ACTION_DATE`");
      cmd.append(",`INVESTMENT`");
      cmd.append(",`INVESTMENT_TOTAL`");
      cmd.append(",`REDEMPTION`");
      cmd.append(",`REDEMPTION_TOTAL`");
      cmd.append(",`NETINVESTMENT`");
      cmd.append(",`NETINVESTMENT_TOTAL`");
      cmd.append(",`INTEREST`");
      cmd.append(",`INTEREST_TOTAL`");
      cmd.append(",`PERFORMANCE`");
      cmd.append(",`PERFORMANCE_TOTAL`");
      cmd.append(",`CUSTOMER_COUNT`");
      cmd.append(",`CUSTOMER_TOTAL`");
      cmd.append(",`CREATE_USER_ID`");
      cmd.append(",`CREATE_DATE`");
      cmd.append(",`UPDATE_USER_ID`");
      cmd.append(",`UPDATE_DATE`");
      cmd.append(") VALUES(");
      if(ouid > 0){
         cmd.appendLong(ouid);
         cmd.append(',');
      }
      cmd.append(unit.ovld());
      String guid = unit.guid();
      if(RString.isEmpty(guid)){
         guid = RUuid.makeUniqueId();
      }
      cmd.append(',');
      cmd.append('\'');
      cmd.append(guid);
      cmd.append('\'');
      cmd.append(',');
      TDateTime actionDate = unit.actionDate();
      if(actionDate == null){
         cmd.append("NULL");
      }else if(actionDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(actionDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      cmd.append(unit.investment());
      cmd.append(',');
      cmd.append(unit.investmentTotal());
      cmd.append(',');
      cmd.append(unit.redemption());
      cmd.append(',');
      cmd.append(unit.redemptionTotal());
      cmd.append(',');
      cmd.append(unit.netinvestment());
      cmd.append(',');
      cmd.append(unit.netinvestmentTotal());
      cmd.append(',');
      cmd.append(unit.interest());
      cmd.append(',');
      cmd.append(unit.interestTotal());
      cmd.append(',');
      cmd.append(unit.performance());
      cmd.append(',');
      cmd.append(unit.performanceTotal());
      cmd.append(',');
      cmd.append(unit.customerCount());
      cmd.append(',');
      cmd.append(unit.customerTotal());
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
      FStatisticsFinancialForecastUnit unit = (FStatisticsFinancialForecastUnit)logicUnit;
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
      FStatisticsFinancialForecastUnit unit = (FStatisticsFinancialForecastUnit)logicUnit;
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
      if(unit.isActionDateChanged()){
         cmd.append(",`ACTION_DATE`=");
         TDateTime actionDate = unit.actionDate();
         if(actionDate == null){
            cmd.append("NULL");
         }else if(actionDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(actionDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isInvestmentChanged()){
         cmd.append(",`INVESTMENT`=");
         cmd.append(unit.investment());
      }
      if(unit.isInvestmentTotalChanged()){
         cmd.append(",`INVESTMENT_TOTAL`=");
         cmd.append(unit.investmentTotal());
      }
      if(unit.isRedemptionChanged()){
         cmd.append(",`REDEMPTION`=");
         cmd.append(unit.redemption());
      }
      if(unit.isRedemptionTotalChanged()){
         cmd.append(",`REDEMPTION_TOTAL`=");
         cmd.append(unit.redemptionTotal());
      }
      if(unit.isNetinvestmentChanged()){
         cmd.append(",`NETINVESTMENT`=");
         cmd.append(unit.netinvestment());
      }
      if(unit.isNetinvestmentTotalChanged()){
         cmd.append(",`NETINVESTMENT_TOTAL`=");
         cmd.append(unit.netinvestmentTotal());
      }
      if(unit.isInterestChanged()){
         cmd.append(",`INTEREST`=");
         cmd.append(unit.interest());
      }
      if(unit.isInterestTotalChanged()){
         cmd.append(",`INTEREST_TOTAL`=");
         cmd.append(unit.interestTotal());
      }
      if(unit.isPerformanceChanged()){
         cmd.append(",`PERFORMANCE`=");
         cmd.append(unit.performance());
      }
      if(unit.isPerformanceTotalChanged()){
         cmd.append(",`PERFORMANCE_TOTAL`=");
         cmd.append(unit.performanceTotal());
      }
      if(unit.isCustomerCountChanged()){
         cmd.append(",`CUSTOMER_COUNT`=");
         cmd.append(unit.customerCount());
      }
      if(unit.isCustomerTotalChanged()){
         cmd.append(",`CUSTOMER_TOTAL`=");
         cmd.append(unit.customerTotal());
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
      FStatisticsFinancialForecastUnit unit = (FStatisticsFinancialForecastUnit)logicUnit;
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

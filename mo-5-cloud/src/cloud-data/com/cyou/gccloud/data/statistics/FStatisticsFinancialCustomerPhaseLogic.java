package com.cyou.gccloud.data.statistics;

import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.RSql;
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
// <T>客户阶段统计表逻辑。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialCustomerPhaseLogic
      extends FLogicTable
{
   // 客户阶段统计表的定义。
   public final static SLogicConnectionInfo CONNECTION = new SLogicConnectionInfo("statistics");

   // 客户阶段统计表的定义。
   public final static SLogicTableInfo TABLE = new SLogicTableInfo("statistics.financial.customer.phase", "ST_FIN_CUSTOMER_PHASE");

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

   // 字段部门编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_ID = new SLogicFieldInfo("DEPARTMENT_ID");

   // 字段部门关联编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LINK_ID = new SLogicFieldInfo("DEPARTMENT_LINK_ID");

   // 字段部门名称的定义。
   public final static SLogicFieldInfo DEPARTMENT_LABEL = new SLogicFieldInfo("DEPARTMENT_LABEL");

   // 字段部门级别1编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL1_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL1_ID");

   // 字段部门级别1关联编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL1_LINK_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL1_LINK_ID");

   // 字段部门级别1标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL1_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL1_LABEL");

   // 字段部门级别2编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL2_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL2_ID");

   // 字段部门级别2关联编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL2_LINK_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL2_LINK_ID");

   // 字段部门级别2标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL2_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL2_LABEL");

   // 字段部门级别3编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL3_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL3_ID");

   // 字段部门级别3关联编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL3_LINK_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL3_LINK_ID");

   // 字段部门级别3标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL3_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL3_LABEL");

   // 字段部门级别4编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL4_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL4_ID");

   // 字段部门级别4关联编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL4_LINK_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL4_LINK_ID");

   // 字段部门级别4标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL4_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL4_LABEL");

   // 字段部门级别5编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL5_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL5_ID");

   // 字段部门级别5关联编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL5_LINK_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL5_LINK_ID");

   // 字段部门级别5标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL5_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL5_LABEL");

   // 字段部门级别6编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL6_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL6_ID");

   // 字段部门级别6关联编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL6_LINK_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL6_LINK_ID");

   // 字段部门级别6标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL6_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL6_LABEL");

   // 字段部门级别7编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL7_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL7_ID");

   // 字段部门级别7关联编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL7_LINK_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL7_LINK_ID");

   // 字段部门级别7标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL7_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL7_LABEL");

   // 字段理财师编号的定义。
   public final static SLogicFieldInfo MARKETER_ID = new SLogicFieldInfo("MARKETER_ID");

   // 字段理财师关联编号的定义。
   public final static SLogicFieldInfo MARKETER_LINK_ID = new SLogicFieldInfo("MARKETER_LINK_ID");

   // 字段理财师名称的定义。
   public final static SLogicFieldInfo MARKETER_LABEL = new SLogicFieldInfo("MARKETER_LABEL");

   // 字段用户编号的定义。
   public final static SLogicFieldInfo CUSTOMER_ID = new SLogicFieldInfo("CUSTOMER_ID");

   // 字段客户关联编号的定义。
   public final static SLogicFieldInfo CUSTOMER_LINK_ID = new SLogicFieldInfo("CUSTOMER_LINK_ID");

   // 字段客户名称的定义。
   public final static SLogicFieldInfo CUSTOMER_LABEL = new SLogicFieldInfo("CUSTOMER_LABEL");

   // 字段客户身份证的定义。
   public final static SLogicFieldInfo CUSTOMER_CARD = new SLogicFieldInfo("CUSTOMER_CARD");

   // 字段客户地区的定义。
   public final static SLogicFieldInfo CUSTOMER_AREA = new SLogicFieldInfo("CUSTOMER_AREA");

   // 字段客户生日的定义。
   public final static SLogicFieldInfo CUSTOMER_BIRTH = new SLogicFieldInfo("CUSTOMER_BIRTH");

   // 字段客户性别的定义。
   public final static SLogicFieldInfo CUSTOMER_GENDER = new SLogicFieldInfo("CUSTOMER_GENDER");

   // 字段客户电话号码的定义。
   public final static SLogicFieldInfo CUSTOMER_PHONE = new SLogicFieldInfo("CUSTOMER_PHONE");

   // 字段客户命令时间的定义。
   public final static SLogicFieldInfo CUSTOMER_ACTION_DATE = new SLogicFieldInfo("CUSTOMER_ACTION_DATE");

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

   // 字段投标改变的定义。
   public final static SLogicFieldInfo TENDER_CHANGED = new SLogicFieldInfo("TENDER_CHANGED");

   // 字段前投标编号的定义。
   public final static SLogicFieldInfo TENDER_PRIOR_ID = new SLogicFieldInfo("TENDER_PRIOR_ID");

   // 字段前投标模式的定义。
   public final static SLogicFieldInfo TENDER_PRIOR_MODEL = new SLogicFieldInfo("TENDER_PRIOR_MODEL");

   // 字段投标编号的定义。
   public final static SLogicFieldInfo TENDER_ID = new SLogicFieldInfo("TENDER_ID");

   // 字段投标模式的定义。
   public final static SLogicFieldInfo TENDER_MODEL = new SLogicFieldInfo("TENDER_MODEL");

   // 字段创建用户标识的定义。
   public final static SLogicFieldInfo CREATE_USER_ID = new SLogicFieldInfo("CREATE_USER_ID");

   // 字段创建日期的定义。
   public final static SLogicFieldInfo CREATE_DATE = new SLogicFieldInfo("CREATE_DATE");

   // 字段更新者标识的定义。
   public final static SLogicFieldInfo UPDATE_USER_ID = new SLogicFieldInfo("UPDATE_USER_ID");

   // 字段更新时间的定义。
   public final static SLogicFieldInfo UPDATE_DATE = new SLogicFieldInfo("UPDATE_DATE");

   // 字段集合的定义。
   public final static String FIELDS = "`OUID`,`OVLD`,`GUID`,`RECORD_YEAR`,`RECORD_MONTH`,`RECORD_WEEK`,`RECORD_DAY`,`RECORD_HOUR`,`RECORD_DATE`,`DEPARTMENT_ID`,`DEPARTMENT_LINK_ID`,`DEPARTMENT_LABEL`,`DEPARTMENT_LEVEL1_ID`,`DEPARTMENT_LEVEL1_LINK_ID`,`DEPARTMENT_LEVEL1_LABEL`,`DEPARTMENT_LEVEL2_ID`,`DEPARTMENT_LEVEL2_LINK_ID`,`DEPARTMENT_LEVEL2_LABEL`,`DEPARTMENT_LEVEL3_ID`,`DEPARTMENT_LEVEL3_LINK_ID`,`DEPARTMENT_LEVEL3_LABEL`,`DEPARTMENT_LEVEL4_ID`,`DEPARTMENT_LEVEL4_LINK_ID`,`DEPARTMENT_LEVEL4_LABEL`,`DEPARTMENT_LEVEL5_ID`,`DEPARTMENT_LEVEL5_LINK_ID`,`DEPARTMENT_LEVEL5_LABEL`,`DEPARTMENT_LEVEL6_ID`,`DEPARTMENT_LEVEL6_LINK_ID`,`DEPARTMENT_LEVEL6_LABEL`,`DEPARTMENT_LEVEL7_ID`,`DEPARTMENT_LEVEL7_LINK_ID`,`DEPARTMENT_LEVEL7_LABEL`,`MARKETER_ID`,`MARKETER_LINK_ID`,`MARKETER_LABEL`,`CUSTOMER_ID`,`CUSTOMER_LINK_ID`,`CUSTOMER_LABEL`,`CUSTOMER_CARD`,`CUSTOMER_AREA`,`CUSTOMER_BIRTH`,`CUSTOMER_GENDER`,`CUSTOMER_PHONE`,`CUSTOMER_ACTION_DATE`,`INVESTMENT`,`INVESTMENT_TOTAL`,`REDEMPTION`,`REDEMPTION_TOTAL`,`NETINVESTMENT`,`NETINVESTMENT_TOTAL`,`INTEREST`,`INTEREST_TOTAL`,`PERFORMANCE`,`PERFORMANCE_TOTAL`,`TENDER_CHANGED`,`TENDER_PRIOR_ID`,`TENDER_PRIOR_MODEL`,`TENDER_ID`,`TENDER_MODEL`,`CREATE_USER_ID`,`CREATE_DATE`,`UPDATE_USER_ID`,`UPDATE_DATE`";

   //============================================================
   // <T>构造客户阶段统计表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialCustomerPhaseLogic(){
      _name = TABLE.name();
      _classUnit = FStatisticsFinancialCustomerPhaseUnit.class;
   }

   //============================================================
   // <T>构造客户阶段统计表逻辑单元。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FStatisticsFinancialCustomerPhaseLogic(ILogicContext context){
      super(context);
      _name = TABLE.name();
      _classUnit = FStatisticsFinancialCustomerPhaseUnit.class;
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
            unit = (T)(new FStatisticsFinancialCustomerPhaseUnit());
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
   public FStatisticsFinancialCustomerPhaseUnit findByGuid(CharSequence guid){
      return findByGuid(null, FStatisticsFinancialCustomerPhaseUnit.class, guid);
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
   public FStatisticsFinancialCustomerPhaseUnit search(CharSequence whereSql){
      return search(null, FStatisticsFinancialCustomerPhaseUnit.class, whereSql);
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
   public FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> fetch(CharSequence whereSql){
      return fetchClass(null, null, whereSql, null, null, -1, 0);
   }

   //============================================================
   // <T>获得数据单元集合。</T>
   //
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> fetch(int pageSize,
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
   public FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> fetch(CharSequence fields,
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
   public FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> fetch(CharSequence fields,
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
   public FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> fetchSql(CharSequence code,
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
         result = (FLogicDataset<T>)(new FLogicDataset<FStatisticsFinancialCustomerPhaseUnit>(FStatisticsFinancialCustomerPhaseUnit.class, _logicContext));
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
   public FLogicDataset<FStatisticsFinancialCustomerPhaseUnit> fetchAll(){
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
   public FStatisticsFinancialCustomerPhaseUnit doPrepare(){
      FStatisticsFinancialCustomerPhaseUnit unit = new FStatisticsFinancialCustomerPhaseUnit();
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
      FStatisticsFinancialCustomerPhaseUnit unit = (FStatisticsFinancialCustomerPhaseUnit)logicUnit;
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
      FStatisticsFinancialCustomerPhaseUnit unit = (FStatisticsFinancialCustomerPhaseUnit)logicUnit;
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
      cmd.append(",`RECORD_YEAR`");
      cmd.append(",`RECORD_MONTH`");
      cmd.append(",`RECORD_WEEK`");
      cmd.append(",`RECORD_DAY`");
      cmd.append(",`RECORD_HOUR`");
      cmd.append(",`RECORD_DATE`");
      cmd.append(",`DEPARTMENT_ID`");
      cmd.append(",`DEPARTMENT_LINK_ID`");
      cmd.append(",`DEPARTMENT_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL1_ID`");
      cmd.append(",`DEPARTMENT_LEVEL1_LINK_ID`");
      cmd.append(",`DEPARTMENT_LEVEL1_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL2_ID`");
      cmd.append(",`DEPARTMENT_LEVEL2_LINK_ID`");
      cmd.append(",`DEPARTMENT_LEVEL2_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL3_ID`");
      cmd.append(",`DEPARTMENT_LEVEL3_LINK_ID`");
      cmd.append(",`DEPARTMENT_LEVEL3_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL4_ID`");
      cmd.append(",`DEPARTMENT_LEVEL4_LINK_ID`");
      cmd.append(",`DEPARTMENT_LEVEL4_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL5_ID`");
      cmd.append(",`DEPARTMENT_LEVEL5_LINK_ID`");
      cmd.append(",`DEPARTMENT_LEVEL5_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL6_ID`");
      cmd.append(",`DEPARTMENT_LEVEL6_LINK_ID`");
      cmd.append(",`DEPARTMENT_LEVEL6_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL7_ID`");
      cmd.append(",`DEPARTMENT_LEVEL7_LINK_ID`");
      cmd.append(",`DEPARTMENT_LEVEL7_LABEL`");
      cmd.append(",`MARKETER_ID`");
      cmd.append(",`MARKETER_LINK_ID`");
      cmd.append(",`MARKETER_LABEL`");
      cmd.append(",`CUSTOMER_ID`");
      cmd.append(",`CUSTOMER_LINK_ID`");
      cmd.append(",`CUSTOMER_LABEL`");
      cmd.append(",`CUSTOMER_CARD`");
      cmd.append(",`CUSTOMER_AREA`");
      cmd.append(",`CUSTOMER_BIRTH`");
      cmd.append(",`CUSTOMER_GENDER`");
      cmd.append(",`CUSTOMER_PHONE`");
      cmd.append(",`CUSTOMER_ACTION_DATE`");
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
      cmd.append(",`TENDER_CHANGED`");
      cmd.append(",`TENDER_PRIOR_ID`");
      cmd.append(",`TENDER_PRIOR_MODEL`");
      cmd.append(",`TENDER_ID`");
      cmd.append(",`TENDER_MODEL`");
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
      long departmentId = unit.departmentId();
      if(departmentId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentId);
      }
      cmd.append(',');
      long departmentLinkId = unit.departmentLinkId();
      if(departmentLinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLinkId);
      }
      cmd.append(',');
      String departmentLabel = unit.departmentLabel();
      if(RString.isEmpty(departmentLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      long departmentLevel1Id = unit.departmentLevel1Id();
      if(departmentLevel1Id == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel1Id);
      }
      cmd.append(',');
      long departmentLevel1LinkId = unit.departmentLevel1LinkId();
      if(departmentLevel1LinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel1LinkId);
      }
      cmd.append(',');
      String departmentLevel1Label = unit.departmentLevel1Label();
      if(RString.isEmpty(departmentLevel1Label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLevel1Label));
         cmd.append('\'');
      }
      cmd.append(',');
      long departmentLevel2Id = unit.departmentLevel2Id();
      if(departmentLevel2Id == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel2Id);
      }
      cmd.append(',');
      long departmentLevel2LinkId = unit.departmentLevel2LinkId();
      if(departmentLevel2LinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel2LinkId);
      }
      cmd.append(',');
      String departmentLevel2Label = unit.departmentLevel2Label();
      if(RString.isEmpty(departmentLevel2Label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLevel2Label));
         cmd.append('\'');
      }
      cmd.append(',');
      long departmentLevel3Id = unit.departmentLevel3Id();
      if(departmentLevel3Id == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel3Id);
      }
      cmd.append(',');
      long departmentLevel3LinkId = unit.departmentLevel3LinkId();
      if(departmentLevel3LinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel3LinkId);
      }
      cmd.append(',');
      String departmentLevel3Label = unit.departmentLevel3Label();
      if(RString.isEmpty(departmentLevel3Label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLevel3Label));
         cmd.append('\'');
      }
      cmd.append(',');
      long departmentLevel4Id = unit.departmentLevel4Id();
      if(departmentLevel4Id == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel4Id);
      }
      cmd.append(',');
      long departmentLevel4LinkId = unit.departmentLevel4LinkId();
      if(departmentLevel4LinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel4LinkId);
      }
      cmd.append(',');
      String departmentLevel4Label = unit.departmentLevel4Label();
      if(RString.isEmpty(departmentLevel4Label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLevel4Label));
         cmd.append('\'');
      }
      cmd.append(',');
      long departmentLevel5Id = unit.departmentLevel5Id();
      if(departmentLevel5Id == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel5Id);
      }
      cmd.append(',');
      long departmentLevel5LinkId = unit.departmentLevel5LinkId();
      if(departmentLevel5LinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel5LinkId);
      }
      cmd.append(',');
      String departmentLevel5Label = unit.departmentLevel5Label();
      if(RString.isEmpty(departmentLevel5Label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLevel5Label));
         cmd.append('\'');
      }
      cmd.append(',');
      long departmentLevel6Id = unit.departmentLevel6Id();
      if(departmentLevel6Id == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel6Id);
      }
      cmd.append(',');
      long departmentLevel6LinkId = unit.departmentLevel6LinkId();
      if(departmentLevel6LinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel6LinkId);
      }
      cmd.append(',');
      String departmentLevel6Label = unit.departmentLevel6Label();
      if(RString.isEmpty(departmentLevel6Label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLevel6Label));
         cmd.append('\'');
      }
      cmd.append(',');
      long departmentLevel7Id = unit.departmentLevel7Id();
      if(departmentLevel7Id == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel7Id);
      }
      cmd.append(',');
      long departmentLevel7LinkId = unit.departmentLevel7LinkId();
      if(departmentLevel7LinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel7LinkId);
      }
      cmd.append(',');
      String departmentLevel7Label = unit.departmentLevel7Label();
      if(RString.isEmpty(departmentLevel7Label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLevel7Label));
         cmd.append('\'');
      }
      cmd.append(',');
      long marketerId = unit.marketerId();
      if(marketerId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(marketerId);
      }
      cmd.append(',');
      long marketerLinkId = unit.marketerLinkId();
      if(marketerLinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(marketerLinkId);
      }
      cmd.append(',');
      String marketerLabel = unit.marketerLabel();
      if(RString.isEmpty(marketerLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(marketerLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      long customerId = unit.customerId();
      if(customerId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(customerId);
      }
      cmd.append(',');
      long customerLinkId = unit.customerLinkId();
      if(customerLinkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(customerLinkId);
      }
      cmd.append(',');
      String customerLabel = unit.customerLabel();
      if(RString.isEmpty(customerLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(customerLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      String customerCard = unit.customerCard();
      if(RString.isEmpty(customerCard)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(customerCard));
         cmd.append('\'');
      }
      cmd.append(',');
      String customerArea = unit.customerArea();
      if(RString.isEmpty(customerArea)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(customerArea));
         cmd.append('\'');
      }
      cmd.append(',');
      String customerBirth = unit.customerBirth();
      if(RString.isEmpty(customerBirth)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(customerBirth));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.customerGender());
      cmd.append(',');
      String customerPhone = unit.customerPhone();
      if(RString.isEmpty(customerPhone)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(customerPhone));
         cmd.append('\'');
      }
      cmd.append(',');
      TDateTime customerActionDate = unit.customerActionDate();
      if(customerActionDate == null){
         cmd.append("NULL");
      }else if(customerActionDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(customerActionDate.format());
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
      cmd.append(unit.tenderChanged());
      cmd.append(',');
      long tenderPriorId = unit.tenderPriorId();
      if(tenderPriorId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(tenderPriorId);
      }
      cmd.append(',');
      String tenderPriorModel = unit.tenderPriorModel();
      if(RString.isEmpty(tenderPriorModel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(tenderPriorModel));
         cmd.append('\'');
      }
      cmd.append(',');
      long tenderId = unit.tenderId();
      if(tenderId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(tenderId);
      }
      cmd.append(',');
      String tenderModel = unit.tenderModel();
      if(RString.isEmpty(tenderModel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(tenderModel));
         cmd.append('\'');
      }
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
      FStatisticsFinancialCustomerPhaseUnit unit = (FStatisticsFinancialCustomerPhaseUnit)logicUnit;
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
      FStatisticsFinancialCustomerPhaseUnit unit = (FStatisticsFinancialCustomerPhaseUnit)logicUnit;
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
      if(unit.isDepartmentIdChanged()){
         cmd.append(",`DEPARTMENT_ID`=");
         long departmentId = unit.departmentId();
         if(departmentId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentId);
         }
      }
      if(unit.isDepartmentLinkIdChanged()){
         cmd.append(",`DEPARTMENT_LINK_ID`=");
         long departmentLinkId = unit.departmentLinkId();
         if(departmentLinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLinkId);
         }
      }
      if(unit.isDepartmentLabelChanged()){
         cmd.append(",`DEPARTMENT_LABEL`=");
         String departmentLabel = unit.departmentLabel();
         if(RString.isEmpty(departmentLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentLabel));
            cmd.append('\'');
         }
      }
      if(unit.isDepartmentLevel1IdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL1_ID`=");
         long departmentLevel1Id = unit.departmentLevel1Id();
         if(departmentLevel1Id == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel1Id);
         }
      }
      if(unit.isDepartmentLevel1LinkIdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL1_LINK_ID`=");
         long departmentLevel1LinkId = unit.departmentLevel1LinkId();
         if(departmentLevel1LinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel1LinkId);
         }
      }
      if(unit.isDepartmentLevel1LabelChanged()){
         cmd.append(",`DEPARTMENT_LEVEL1_LABEL`=");
         String departmentLevel1Label = unit.departmentLevel1Label();
         if(RString.isEmpty(departmentLevel1Label)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentLevel1Label));
            cmd.append('\'');
         }
      }
      if(unit.isDepartmentLevel2IdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL2_ID`=");
         long departmentLevel2Id = unit.departmentLevel2Id();
         if(departmentLevel2Id == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel2Id);
         }
      }
      if(unit.isDepartmentLevel2LinkIdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL2_LINK_ID`=");
         long departmentLevel2LinkId = unit.departmentLevel2LinkId();
         if(departmentLevel2LinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel2LinkId);
         }
      }
      if(unit.isDepartmentLevel2LabelChanged()){
         cmd.append(",`DEPARTMENT_LEVEL2_LABEL`=");
         String departmentLevel2Label = unit.departmentLevel2Label();
         if(RString.isEmpty(departmentLevel2Label)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentLevel2Label));
            cmd.append('\'');
         }
      }
      if(unit.isDepartmentLevel3IdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL3_ID`=");
         long departmentLevel3Id = unit.departmentLevel3Id();
         if(departmentLevel3Id == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel3Id);
         }
      }
      if(unit.isDepartmentLevel3LinkIdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL3_LINK_ID`=");
         long departmentLevel3LinkId = unit.departmentLevel3LinkId();
         if(departmentLevel3LinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel3LinkId);
         }
      }
      if(unit.isDepartmentLevel3LabelChanged()){
         cmd.append(",`DEPARTMENT_LEVEL3_LABEL`=");
         String departmentLevel3Label = unit.departmentLevel3Label();
         if(RString.isEmpty(departmentLevel3Label)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentLevel3Label));
            cmd.append('\'');
         }
      }
      if(unit.isDepartmentLevel4IdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL4_ID`=");
         long departmentLevel4Id = unit.departmentLevel4Id();
         if(departmentLevel4Id == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel4Id);
         }
      }
      if(unit.isDepartmentLevel4LinkIdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL4_LINK_ID`=");
         long departmentLevel4LinkId = unit.departmentLevel4LinkId();
         if(departmentLevel4LinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel4LinkId);
         }
      }
      if(unit.isDepartmentLevel4LabelChanged()){
         cmd.append(",`DEPARTMENT_LEVEL4_LABEL`=");
         String departmentLevel4Label = unit.departmentLevel4Label();
         if(RString.isEmpty(departmentLevel4Label)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentLevel4Label));
            cmd.append('\'');
         }
      }
      if(unit.isDepartmentLevel5IdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL5_ID`=");
         long departmentLevel5Id = unit.departmentLevel5Id();
         if(departmentLevel5Id == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel5Id);
         }
      }
      if(unit.isDepartmentLevel5LinkIdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL5_LINK_ID`=");
         long departmentLevel5LinkId = unit.departmentLevel5LinkId();
         if(departmentLevel5LinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel5LinkId);
         }
      }
      if(unit.isDepartmentLevel5LabelChanged()){
         cmd.append(",`DEPARTMENT_LEVEL5_LABEL`=");
         String departmentLevel5Label = unit.departmentLevel5Label();
         if(RString.isEmpty(departmentLevel5Label)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentLevel5Label));
            cmd.append('\'');
         }
      }
      if(unit.isDepartmentLevel6IdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL6_ID`=");
         long departmentLevel6Id = unit.departmentLevel6Id();
         if(departmentLevel6Id == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel6Id);
         }
      }
      if(unit.isDepartmentLevel6LinkIdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL6_LINK_ID`=");
         long departmentLevel6LinkId = unit.departmentLevel6LinkId();
         if(departmentLevel6LinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel6LinkId);
         }
      }
      if(unit.isDepartmentLevel6LabelChanged()){
         cmd.append(",`DEPARTMENT_LEVEL6_LABEL`=");
         String departmentLevel6Label = unit.departmentLevel6Label();
         if(RString.isEmpty(departmentLevel6Label)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentLevel6Label));
            cmd.append('\'');
         }
      }
      if(unit.isDepartmentLevel7IdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL7_ID`=");
         long departmentLevel7Id = unit.departmentLevel7Id();
         if(departmentLevel7Id == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel7Id);
         }
      }
      if(unit.isDepartmentLevel7LinkIdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL7_LINK_ID`=");
         long departmentLevel7LinkId = unit.departmentLevel7LinkId();
         if(departmentLevel7LinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel7LinkId);
         }
      }
      if(unit.isDepartmentLevel7LabelChanged()){
         cmd.append(",`DEPARTMENT_LEVEL7_LABEL`=");
         String departmentLevel7Label = unit.departmentLevel7Label();
         if(RString.isEmpty(departmentLevel7Label)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentLevel7Label));
            cmd.append('\'');
         }
      }
      if(unit.isMarketerIdChanged()){
         cmd.append(",`MARKETER_ID`=");
         long marketerId = unit.marketerId();
         if(marketerId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(marketerId);
         }
      }
      if(unit.isMarketerLinkIdChanged()){
         cmd.append(",`MARKETER_LINK_ID`=");
         long marketerLinkId = unit.marketerLinkId();
         if(marketerLinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(marketerLinkId);
         }
      }
      if(unit.isMarketerLabelChanged()){
         cmd.append(",`MARKETER_LABEL`=");
         String marketerLabel = unit.marketerLabel();
         if(RString.isEmpty(marketerLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(marketerLabel));
            cmd.append('\'');
         }
      }
      if(unit.isCustomerIdChanged()){
         cmd.append(",`CUSTOMER_ID`=");
         long customerId = unit.customerId();
         if(customerId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(customerId);
         }
      }
      if(unit.isCustomerLinkIdChanged()){
         cmd.append(",`CUSTOMER_LINK_ID`=");
         long customerLinkId = unit.customerLinkId();
         if(customerLinkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(customerLinkId);
         }
      }
      if(unit.isCustomerLabelChanged()){
         cmd.append(",`CUSTOMER_LABEL`=");
         String customerLabel = unit.customerLabel();
         if(RString.isEmpty(customerLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(customerLabel));
            cmd.append('\'');
         }
      }
      if(unit.isCustomerCardChanged()){
         cmd.append(",`CUSTOMER_CARD`=");
         String customerCard = unit.customerCard();
         if(RString.isEmpty(customerCard)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(customerCard));
            cmd.append('\'');
         }
      }
      if(unit.isCustomerAreaChanged()){
         cmd.append(",`CUSTOMER_AREA`=");
         String customerArea = unit.customerArea();
         if(RString.isEmpty(customerArea)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(customerArea));
            cmd.append('\'');
         }
      }
      if(unit.isCustomerBirthChanged()){
         cmd.append(",`CUSTOMER_BIRTH`=");
         String customerBirth = unit.customerBirth();
         if(RString.isEmpty(customerBirth)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(customerBirth));
            cmd.append('\'');
         }
      }
      if(unit.isCustomerGenderChanged()){
         cmd.append(",`CUSTOMER_GENDER`=");
         cmd.append(unit.customerGender());
      }
      if(unit.isCustomerPhoneChanged()){
         cmd.append(",`CUSTOMER_PHONE`=");
         String customerPhone = unit.customerPhone();
         if(RString.isEmpty(customerPhone)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(customerPhone));
            cmd.append('\'');
         }
      }
      if(unit.isCustomerActionDateChanged()){
         cmd.append(",`CUSTOMER_ACTION_DATE`=");
         TDateTime customerActionDate = unit.customerActionDate();
         if(customerActionDate == null){
            cmd.append("NULL");
         }else if(customerActionDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(customerActionDate.format());
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
      if(unit.isTenderChangedChanged()){
         cmd.append(",`TENDER_CHANGED`=");
         cmd.append(unit.tenderChanged());
      }
      if(unit.isTenderPriorIdChanged()){
         cmd.append(",`TENDER_PRIOR_ID`=");
         long tenderPriorId = unit.tenderPriorId();
         if(tenderPriorId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(tenderPriorId);
         }
      }
      if(unit.isTenderPriorModelChanged()){
         cmd.append(",`TENDER_PRIOR_MODEL`=");
         String tenderPriorModel = unit.tenderPriorModel();
         if(RString.isEmpty(tenderPriorModel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(tenderPriorModel));
            cmd.append('\'');
         }
      }
      if(unit.isTenderIdChanged()){
         cmd.append(",`TENDER_ID`=");
         long tenderId = unit.tenderId();
         if(tenderId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(tenderId);
         }
      }
      if(unit.isTenderModelChanged()){
         cmd.append(",`TENDER_MODEL`=");
         String tenderModel = unit.tenderModel();
         if(RString.isEmpty(tenderModel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(tenderModel));
            cmd.append('\'');
         }
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
      FStatisticsFinancialCustomerPhaseUnit unit = (FStatisticsFinancialCustomerPhaseUnit)logicUnit;
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

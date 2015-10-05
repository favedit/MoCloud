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
// <T>用户统计表逻辑。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialMemberLogic
      extends FLogicTable
{
   // 用户统计表的定义。
   public final static SLogicConnectionInfo CONNECTION = new SLogicConnectionInfo("statistics");

   // 用户统计表的定义。
   public final static SLogicTableInfo TABLE = new SLogicTableInfo("statistics.financial.member", "ST_FIN_MEMBER");

   // 字段对象标识的定义。
   public final static SLogicFieldInfo OUID = new SLogicFieldInfo("OUID");

   // 字段有效性的定义。
   public final static SLogicFieldInfo OVLD = new SLogicFieldInfo("OVLD");

   // 字段对象唯一标识的定义。
   public final static SLogicFieldInfo GUID = new SLogicFieldInfo("GUID");

   // 字段关联编号的定义。
   public final static SLogicFieldInfo LINK_ID = new SLogicFieldInfo("LINK_ID");

   // 字段关联时间的定义。
   public final static SLogicFieldInfo LINK_DATE = new SLogicFieldInfo("LINK_DATE");

   // 字段关联类型的定义。
   public final static SLogicFieldInfo LINK_CD = new SLogicFieldInfo("LINK_CD");

   // 字段数据编号的定义。
   public final static SLogicFieldInfo DATA_ID = new SLogicFieldInfo("DATA_ID");

   // 字段客户编号的定义。
   public final static SLogicFieldInfo CUSTOMER_ID = new SLogicFieldInfo("CUSTOMER_ID");

   // 字段客户级别的定义。
   public final static SLogicFieldInfo CUSTOMER_LEVEL_CD = new SLogicFieldInfo("CUSTOMER_LEVEL_CD");

   // 字段理财师编号的定义。
   public final static SLogicFieldInfo MARKETER_ID = new SLogicFieldInfo("MARKETER_ID");

   // 字段部门编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_ID = new SLogicFieldInfo("DEPARTMENT_ID");

   // 字段账号的定义。
   public final static SLogicFieldInfo PASSPORT = new SLogicFieldInfo("PASSPORT");

   // 字段标签的定义。
   public final static SLogicFieldInfo LABEL = new SLogicFieldInfo("LABEL");

   // 字段身份证的定义。
   public final static SLogicFieldInfo CARD = new SLogicFieldInfo("CARD");

   // 字段电话的定义。
   public final static SLogicFieldInfo PHONE = new SLogicFieldInfo("PHONE");

   // 字段电话城市编号的定义。
   public final static SLogicFieldInfo PHONE_CITY_ID = new SLogicFieldInfo("PHONE_CITY_ID");

   // 字段电话城市代码的定义。
   public final static SLogicFieldInfo PHONE_CITY_CODE = new SLogicFieldInfo("PHONE_CITY_CODE");

   // 字段电子邮箱的定义。
   public final static SLogicFieldInfo EMAIL = new SLogicFieldInfo("EMAIL");

   // 字段性别类型的定义。
   public final static SLogicFieldInfo GENDER_CD = new SLogicFieldInfo("GENDER_CD");

   // 字段性别代码的定义。
   public final static SLogicFieldInfo GENDER_CODE = new SLogicFieldInfo("GENDER_CODE");

   // 字段已婚类型的定义。
   public final static SLogicFieldInfo MARRY_CD = new SLogicFieldInfo("MARRY_CD");

   // 字段已婚代码的定义。
   public final static SLogicFieldInfo MARRY_CODE = new SLogicFieldInfo("MARRY_CODE");

   // 字段学历类型的定义。
   public final static SLogicFieldInfo EDUCATION_CD = new SLogicFieldInfo("EDUCATION_CD");

   // 字段学历代码的定义。
   public final static SLogicFieldInfo EDUCATION_CODE = new SLogicFieldInfo("EDUCATION_CODE");

   // 字段行业类型的定义。
   public final static SLogicFieldInfo BUSINESS_CD = new SLogicFieldInfo("BUSINESS_CD");

   // 字段行业代码的定义。
   public final static SLogicFieldInfo BUSINESS_CODE = new SLogicFieldInfo("BUSINESS_CODE");

   // 字段收入类型的定义。
   public final static SLogicFieldInfo INCOME_CD = new SLogicFieldInfo("INCOME_CD");

   // 字段收入代码的定义。
   public final static SLogicFieldInfo INCOME_CODE = new SLogicFieldInfo("INCOME_CODE");

   // 字段省份区域编号的定义。
   public final static SLogicFieldInfo PROVINCE_AREA_ID = new SLogicFieldInfo("PROVINCE_AREA_ID");

   // 字段省份编号的定义。
   public final static SLogicFieldInfo PROVINCE_ID = new SLogicFieldInfo("PROVINCE_ID");

   // 字段省份代码的定义。
   public final static SLogicFieldInfo PROVINCE_CODE = new SLogicFieldInfo("PROVINCE_CODE");

   // 字段城市编号的定义。
   public final static SLogicFieldInfo CITY_ID = new SLogicFieldInfo("CITY_ID");

   // 字段城市代码的定义。
   public final static SLogicFieldInfo CITY_CODE = new SLogicFieldInfo("CITY_CODE");

   // 字段地区编号的定义。
   public final static SLogicFieldInfo AREA_ID = new SLogicFieldInfo("AREA_ID");

   // 字段地区代码的定义。
   public final static SLogicFieldInfo AREA_CODE = new SLogicFieldInfo("AREA_CODE");

   // 字段地址的定义。
   public final static SLogicFieldInfo ADDRESS = new SLogicFieldInfo("ADDRESS");

   // 字段信息的定义。
   public final static SLogicFieldInfo INFO = new SLogicFieldInfo("INFO");

   // 字段注册时间的定义。
   public final static SLogicFieldInfo REGISTER_DATE = new SLogicFieldInfo("REGISTER_DATE");

   // 字段投资时间的定义。
   public final static SLogicFieldInfo INVESTMENT_DATE = new SLogicFieldInfo("INVESTMENT_DATE");

   // 字段赎回时间的定义。
   public final static SLogicFieldInfo REDEMPTION_DATE = new SLogicFieldInfo("REDEMPTION_DATE");

   // 字段登录时间的定义。
   public final static SLogicFieldInfo LAST_LOGIN_DATE = new SLogicFieldInfo("LAST_LOGIN_DATE");

   // 字段创建用户标识的定义。
   public final static SLogicFieldInfo CREATE_USER_ID = new SLogicFieldInfo("CREATE_USER_ID");

   // 字段创建日期的定义。
   public final static SLogicFieldInfo CREATE_DATE = new SLogicFieldInfo("CREATE_DATE");

   // 字段更新者标识的定义。
   public final static SLogicFieldInfo UPDATE_USER_ID = new SLogicFieldInfo("UPDATE_USER_ID");

   // 字段更新时间的定义。
   public final static SLogicFieldInfo UPDATE_DATE = new SLogicFieldInfo("UPDATE_DATE");

   // 字段集合的定义。
   public final static String FIELDS = "`OUID`,`OVLD`,`GUID`,`LINK_ID`,`LINK_DATE`,`LINK_CD`,`DATA_ID`,`CUSTOMER_ID`,`CUSTOMER_LEVEL_CD`,`MARKETER_ID`,`DEPARTMENT_ID`,`PASSPORT`,`LABEL`,`CARD`,`PHONE`,`PHONE_CITY_ID`,`PHONE_CITY_CODE`,`EMAIL`,`GENDER_CD`,`GENDER_CODE`,`MARRY_CD`,`MARRY_CODE`,`EDUCATION_CD`,`EDUCATION_CODE`,`BUSINESS_CD`,`BUSINESS_CODE`,`INCOME_CD`,`INCOME_CODE`,`PROVINCE_AREA_ID`,`PROVINCE_ID`,`PROVINCE_CODE`,`CITY_ID`,`CITY_CODE`,`AREA_ID`,`AREA_CODE`,`ADDRESS`,`INFO`,`REGISTER_DATE`,`INVESTMENT_DATE`,`REDEMPTION_DATE`,`LAST_LOGIN_DATE`,`CREATE_USER_ID`,`CREATE_DATE`,`UPDATE_USER_ID`,`UPDATE_DATE`";

   //============================================================
   // <T>构造用户统计表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialMemberLogic(){
      _name = TABLE.name();
      _classUnit = FStatisticsFinancialMemberUnit.class;
   }

   //============================================================
   // <T>构造用户统计表逻辑单元。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FStatisticsFinancialMemberLogic(ILogicContext context){
      super(context);
      _name = TABLE.name();
      _classUnit = FStatisticsFinancialMemberUnit.class;
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
            unit = (T)(new FStatisticsFinancialMemberUnit());
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
   public FStatisticsFinancialMemberUnit findByGuid(CharSequence guid){
      return findByGuid(null, FStatisticsFinancialMemberUnit.class, guid);
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
   public FStatisticsFinancialMemberUnit search(CharSequence whereSql){
      return search(null, FStatisticsFinancialMemberUnit.class, whereSql);
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
   public FLogicDataset<FStatisticsFinancialMemberUnit> fetch(CharSequence whereSql){
      return fetchClass(null, null, whereSql, null, null, -1, 0);
   }

   //============================================================
   // <T>获得数据单元集合。</T>
   //
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsFinancialMemberUnit> fetch(int pageSize,
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
   public FLogicDataset<FStatisticsFinancialMemberUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FStatisticsFinancialMemberUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FStatisticsFinancialMemberUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FStatisticsFinancialMemberUnit> fetch(CharSequence fields,
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
   public FLogicDataset<FStatisticsFinancialMemberUnit> fetch(CharSequence fields,
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
   public FLogicDataset<FStatisticsFinancialMemberUnit> fetchSql(CharSequence code,
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
         result = (FLogicDataset<T>)(new FLogicDataset<FStatisticsFinancialMemberUnit>(FStatisticsFinancialMemberUnit.class, _logicContext));
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
   public FLogicDataset<FStatisticsFinancialMemberUnit> fetchAll(){
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
   public FStatisticsFinancialMemberUnit doPrepare(){
      FStatisticsFinancialMemberUnit unit = new FStatisticsFinancialMemberUnit();
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
      FStatisticsFinancialMemberUnit unit = (FStatisticsFinancialMemberUnit)logicUnit;
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
      FStatisticsFinancialMemberUnit unit = (FStatisticsFinancialMemberUnit)logicUnit;
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
      cmd.append(",`LINK_ID`");
      cmd.append(",`LINK_DATE`");
      cmd.append(",`LINK_CD`");
      cmd.append(",`DATA_ID`");
      cmd.append(",`CUSTOMER_ID`");
      cmd.append(",`CUSTOMER_LEVEL_CD`");
      cmd.append(",`MARKETER_ID`");
      cmd.append(",`DEPARTMENT_ID`");
      cmd.append(",`PASSPORT`");
      cmd.append(",`LABEL`");
      cmd.append(",`CARD`");
      cmd.append(",`PHONE`");
      cmd.append(",`PHONE_CITY_ID`");
      cmd.append(",`PHONE_CITY_CODE`");
      cmd.append(",`EMAIL`");
      cmd.append(",`GENDER_CD`");
      cmd.append(",`GENDER_CODE`");
      cmd.append(",`MARRY_CD`");
      cmd.append(",`MARRY_CODE`");
      cmd.append(",`EDUCATION_CD`");
      cmd.append(",`EDUCATION_CODE`");
      cmd.append(",`BUSINESS_CD`");
      cmd.append(",`BUSINESS_CODE`");
      cmd.append(",`INCOME_CD`");
      cmd.append(",`INCOME_CODE`");
      cmd.append(",`PROVINCE_AREA_ID`");
      cmd.append(",`PROVINCE_ID`");
      cmd.append(",`PROVINCE_CODE`");
      cmd.append(",`CITY_ID`");
      cmd.append(",`CITY_CODE`");
      cmd.append(",`AREA_ID`");
      cmd.append(",`AREA_CODE`");
      cmd.append(",`ADDRESS`");
      cmd.append(",`INFO`");
      cmd.append(",`REGISTER_DATE`");
      cmd.append(",`INVESTMENT_DATE`");
      cmd.append(",`REDEMPTION_DATE`");
      cmd.append(",`LAST_LOGIN_DATE`");
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
      long linkId = unit.linkId();
      if(linkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(linkId);
      }
      cmd.append(',');
      TDateTime linkDate = unit.linkDate();
      if(linkDate == null){
         cmd.append("NULL");
      }else if(linkDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(linkDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      cmd.append(unit.linkCd());
      cmd.append(',');
      long dataId = unit.dataId();
      if(dataId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(dataId);
      }
      cmd.append(',');
      long customerId = unit.customerId();
      if(customerId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(customerId);
      }
      cmd.append(',');
      cmd.append(unit.customerLevelCd());
      cmd.append(',');
      long marketerId = unit.marketerId();
      if(marketerId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(marketerId);
      }
      cmd.append(',');
      long departmentId = unit.departmentId();
      if(departmentId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentId);
      }
      cmd.append(',');
      String passport = unit.passport();
      if(RString.isEmpty(passport)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(passport));
         cmd.append('\'');
      }
      cmd.append(',');
      String label = unit.label();
      if(RString.isEmpty(label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(label));
         cmd.append('\'');
      }
      cmd.append(',');
      String card = unit.card();
      if(RString.isEmpty(card)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(card));
         cmd.append('\'');
      }
      cmd.append(',');
      String phone = unit.phone();
      if(RString.isEmpty(phone)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(phone));
         cmd.append('\'');
      }
      cmd.append(',');
      long phoneCityId = unit.phoneCityId();
      if(phoneCityId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(phoneCityId);
      }
      cmd.append(',');
      String phoneCityCode = unit.phoneCityCode();
      if(RString.isEmpty(phoneCityCode)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(phoneCityCode));
         cmd.append('\'');
      }
      cmd.append(',');
      String email = unit.email();
      if(RString.isEmpty(email)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(email));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.genderCd());
      cmd.append(',');
      String genderCode = unit.genderCode();
      if(RString.isEmpty(genderCode)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(genderCode));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.marryCd());
      cmd.append(',');
      String marryCode = unit.marryCode();
      if(RString.isEmpty(marryCode)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(marryCode));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.educationCd());
      cmd.append(',');
      String educationCode = unit.educationCode();
      if(RString.isEmpty(educationCode)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(educationCode));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.businessCd());
      cmd.append(',');
      String businessCode = unit.businessCode();
      if(RString.isEmpty(businessCode)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(businessCode));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.incomeCd());
      cmd.append(',');
      String incomeCode = unit.incomeCode();
      if(RString.isEmpty(incomeCode)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(incomeCode));
         cmd.append('\'');
      }
      cmd.append(',');
      long provinceAreaId = unit.provinceAreaId();
      if(provinceAreaId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(provinceAreaId);
      }
      cmd.append(',');
      long provinceId = unit.provinceId();
      if(provinceId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(provinceId);
      }
      cmd.append(',');
      cmd.append(unit.provinceCode());
      cmd.append(',');
      long cityId = unit.cityId();
      if(cityId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(cityId);
      }
      cmd.append(',');
      cmd.append(unit.cityCode());
      cmd.append(',');
      long areaId = unit.areaId();
      if(areaId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(areaId);
      }
      cmd.append(',');
      cmd.append(unit.areaCode());
      cmd.append(',');
      String address = unit.address();
      if(RString.isEmpty(address)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(address));
         cmd.append('\'');
      }
      cmd.append(',');
      String info = unit.info();
      if(RString.isEmpty(info)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(info));
         cmd.append('\'');
      }
      cmd.append(',');
      TDateTime registerDate = unit.registerDate();
      if(registerDate == null){
         cmd.append("NULL");
      }else if(registerDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(registerDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime investmentDate = unit.investmentDate();
      if(investmentDate == null){
         cmd.append("NULL");
      }else if(investmentDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(investmentDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime redemptionDate = unit.redemptionDate();
      if(redemptionDate == null){
         cmd.append("NULL");
      }else if(redemptionDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(redemptionDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime lastLoginDate = unit.lastLoginDate();
      if(lastLoginDate == null){
         cmd.append("NULL");
      }else if(lastLoginDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(lastLoginDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
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
      FStatisticsFinancialMemberUnit unit = (FStatisticsFinancialMemberUnit)logicUnit;
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
      FStatisticsFinancialMemberUnit unit = (FStatisticsFinancialMemberUnit)logicUnit;
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
      if(unit.isLinkIdChanged()){
         cmd.append(",`LINK_ID`=");
         long linkId = unit.linkId();
         if(linkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(linkId);
         }
      }
      if(unit.isLinkDateChanged()){
         cmd.append(",`LINK_DATE`=");
         TDateTime linkDate = unit.linkDate();
         if(linkDate == null){
            cmd.append("NULL");
         }else if(linkDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(linkDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isLinkCdChanged()){
         cmd.append(",`LINK_CD`=");
         cmd.append(unit.linkCd());
      }
      if(unit.isDataIdChanged()){
         cmd.append(",`DATA_ID`=");
         long dataId = unit.dataId();
         if(dataId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(dataId);
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
      if(unit.isCustomerLevelCdChanged()){
         cmd.append(",`CUSTOMER_LEVEL_CD`=");
         cmd.append(unit.customerLevelCd());
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
      if(unit.isDepartmentIdChanged()){
         cmd.append(",`DEPARTMENT_ID`=");
         long departmentId = unit.departmentId();
         if(departmentId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentId);
         }
      }
      if(unit.isPassportChanged()){
         cmd.append(",`PASSPORT`=");
         String passport = unit.passport();
         if(RString.isEmpty(passport)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(passport));
            cmd.append('\'');
         }
      }
      if(unit.isLabelChanged()){
         cmd.append(",`LABEL`=");
         String label = unit.label();
         if(RString.isEmpty(label)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(label));
            cmd.append('\'');
         }
      }
      if(unit.isCardChanged()){
         cmd.append(",`CARD`=");
         String card = unit.card();
         if(RString.isEmpty(card)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(card));
            cmd.append('\'');
         }
      }
      if(unit.isPhoneChanged()){
         cmd.append(",`PHONE`=");
         String phone = unit.phone();
         if(RString.isEmpty(phone)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(phone));
            cmd.append('\'');
         }
      }
      if(unit.isPhoneCityIdChanged()){
         cmd.append(",`PHONE_CITY_ID`=");
         long phoneCityId = unit.phoneCityId();
         if(phoneCityId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(phoneCityId);
         }
      }
      if(unit.isPhoneCityCodeChanged()){
         cmd.append(",`PHONE_CITY_CODE`=");
         String phoneCityCode = unit.phoneCityCode();
         if(RString.isEmpty(phoneCityCode)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(phoneCityCode));
            cmd.append('\'');
         }
      }
      if(unit.isEmailChanged()){
         cmd.append(",`EMAIL`=");
         String email = unit.email();
         if(RString.isEmpty(email)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(email));
            cmd.append('\'');
         }
      }
      if(unit.isGenderCdChanged()){
         cmd.append(",`GENDER_CD`=");
         cmd.append(unit.genderCd());
      }
      if(unit.isGenderCodeChanged()){
         cmd.append(",`GENDER_CODE`=");
         String genderCode = unit.genderCode();
         if(RString.isEmpty(genderCode)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(genderCode));
            cmd.append('\'');
         }
      }
      if(unit.isMarryCdChanged()){
         cmd.append(",`MARRY_CD`=");
         cmd.append(unit.marryCd());
      }
      if(unit.isMarryCodeChanged()){
         cmd.append(",`MARRY_CODE`=");
         String marryCode = unit.marryCode();
         if(RString.isEmpty(marryCode)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(marryCode));
            cmd.append('\'');
         }
      }
      if(unit.isEducationCdChanged()){
         cmd.append(",`EDUCATION_CD`=");
         cmd.append(unit.educationCd());
      }
      if(unit.isEducationCodeChanged()){
         cmd.append(",`EDUCATION_CODE`=");
         String educationCode = unit.educationCode();
         if(RString.isEmpty(educationCode)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(educationCode));
            cmd.append('\'');
         }
      }
      if(unit.isBusinessCdChanged()){
         cmd.append(",`BUSINESS_CD`=");
         cmd.append(unit.businessCd());
      }
      if(unit.isBusinessCodeChanged()){
         cmd.append(",`BUSINESS_CODE`=");
         String businessCode = unit.businessCode();
         if(RString.isEmpty(businessCode)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(businessCode));
            cmd.append('\'');
         }
      }
      if(unit.isIncomeCdChanged()){
         cmd.append(",`INCOME_CD`=");
         cmd.append(unit.incomeCd());
      }
      if(unit.isIncomeCodeChanged()){
         cmd.append(",`INCOME_CODE`=");
         String incomeCode = unit.incomeCode();
         if(RString.isEmpty(incomeCode)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(incomeCode));
            cmd.append('\'');
         }
      }
      if(unit.isProvinceAreaIdChanged()){
         cmd.append(",`PROVINCE_AREA_ID`=");
         long provinceAreaId = unit.provinceAreaId();
         if(provinceAreaId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(provinceAreaId);
         }
      }
      if(unit.isProvinceIdChanged()){
         cmd.append(",`PROVINCE_ID`=");
         long provinceId = unit.provinceId();
         if(provinceId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(provinceId);
         }
      }
      if(unit.isProvinceCodeChanged()){
         cmd.append(",`PROVINCE_CODE`=");
         cmd.append(unit.provinceCode());
      }
      if(unit.isCityIdChanged()){
         cmd.append(",`CITY_ID`=");
         long cityId = unit.cityId();
         if(cityId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(cityId);
         }
      }
      if(unit.isCityCodeChanged()){
         cmd.append(",`CITY_CODE`=");
         cmd.append(unit.cityCode());
      }
      if(unit.isAreaIdChanged()){
         cmd.append(",`AREA_ID`=");
         long areaId = unit.areaId();
         if(areaId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(areaId);
         }
      }
      if(unit.isAreaCodeChanged()){
         cmd.append(",`AREA_CODE`=");
         cmd.append(unit.areaCode());
      }
      if(unit.isAddressChanged()){
         cmd.append(",`ADDRESS`=");
         String address = unit.address();
         if(RString.isEmpty(address)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(address));
            cmd.append('\'');
         }
      }
      if(unit.isInfoChanged()){
         cmd.append(",`INFO`=");
         String info = unit.info();
         if(RString.isEmpty(info)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(info));
            cmd.append('\'');
         }
      }
      if(unit.isRegisterDateChanged()){
         cmd.append(",`REGISTER_DATE`=");
         TDateTime registerDate = unit.registerDate();
         if(registerDate == null){
            cmd.append("NULL");
         }else if(registerDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(registerDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isInvestmentDateChanged()){
         cmd.append(",`INVESTMENT_DATE`=");
         TDateTime investmentDate = unit.investmentDate();
         if(investmentDate == null){
            cmd.append("NULL");
         }else if(investmentDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(investmentDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isRedemptionDateChanged()){
         cmd.append(",`REDEMPTION_DATE`=");
         TDateTime redemptionDate = unit.redemptionDate();
         if(redemptionDate == null){
            cmd.append("NULL");
         }else if(redemptionDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(redemptionDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isLastLoginDateChanged()){
         cmd.append(",`LAST_LOGIN_DATE`=");
         TDateTime lastLoginDate = unit.lastLoginDate();
         if(lastLoginDate == null){
            cmd.append("NULL");
         }else if(lastLoginDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(lastLoginDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
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
      FStatisticsFinancialMemberUnit unit = (FStatisticsFinancialMemberUnit)logicUnit;
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

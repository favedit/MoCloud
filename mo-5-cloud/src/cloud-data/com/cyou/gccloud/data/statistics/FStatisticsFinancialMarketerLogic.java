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
// <T>理财师统计表逻辑。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialMarketerLogic extends FLogicTable
{
   // 理财师统计表的定义。
   public final static SLogicConnectionInfo CONNECTION = new SLogicConnectionInfo("statistics");

   // 理财师统计表的定义。
   public final static SLogicTableInfo TABLE = new SLogicTableInfo("statistics.financial.marketer", "ST_FIN_MARKETER");

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

   // 字段部门关联编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LINK_ID = new SLogicFieldInfo("DEPARTMENT_LINK_ID");

   // 字段部门标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LABEL = new SLogicFieldInfo("DEPARTMENT_LABEL");

   // 字段部门级别1编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL1_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL1_ID");

   // 字段部门级别1标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL1_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL1_LABEL");

   // 字段部门级别2编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL2_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL2_ID");

   // 字段部门级别2标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL2_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL2_LABEL");

   // 字段部门级别3编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL3_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL3_ID");

   // 字段部门级别3标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL3_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL3_LABEL");

   // 字段部门级别4编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL4_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL4_ID");

   // 字段部门级别4标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL4_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL4_LABEL");

   // 字段部门级别5编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL5_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL5_ID");

   // 字段部门级别5标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL5_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL5_LABEL");

   // 字段部门级别6编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL6_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL6_ID");

   // 字段部门级别6标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL6_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL6_LABEL");

   // 字段部门级别7编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL7_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL7_ID");

   // 字段部门级别7标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL7_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL7_LABEL");

   // 字段部门级别8编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL8_ID = new SLogicFieldInfo("DEPARTMENT_LEVEL8_ID");

   // 字段部门级别8标签的定义。
   public final static SLogicFieldInfo DEPARTMENT_LEVEL8_LABEL = new SLogicFieldInfo("DEPARTMENT_LEVEL8_LABEL");

   // 字段代码的定义。
   public final static SLogicFieldInfo CODE = new SLogicFieldInfo("CODE");

   // 字段标签的定义。
   public final static SLogicFieldInfo LABEL = new SLogicFieldInfo("LABEL");

   // 字段状态类型的定义。
   public final static SLogicFieldInfo STATUS_CD = new SLogicFieldInfo("STATUS_CD");

   // 字段电话的定义。
   public final static SLogicFieldInfo PHONE = new SLogicFieldInfo("PHONE");

   // 字段卡片的定义。
   public final static SLogicFieldInfo CARD = new SLogicFieldInfo("CARD");

   // 字段级别标签的定义。
   public final static SLogicFieldInfo RANK_LABEL = new SLogicFieldInfo("RANK_LABEL");

   // 字段投资总计的定义。
   public final static SLogicFieldInfo INVESTMENT_TOTAL = new SLogicFieldInfo("INVESTMENT_TOTAL");

   // 字段赎回总计的定义。
   public final static SLogicFieldInfo REDEMPTION_TOTAL = new SLogicFieldInfo("REDEMPTION_TOTAL");

   // 字段净投总计的定义。
   public final static SLogicFieldInfo NETINVESTMENT_TOTAL = new SLogicFieldInfo("NETINVESTMENT_TOTAL");

   // 字段利息总计的定义。
   public final static SLogicFieldInfo INTEREST_TOTAL = new SLogicFieldInfo("INTEREST_TOTAL");

   // 字段绩效总计的定义。
   public final static SLogicFieldInfo PERFORMANCE_TOTAL = new SLogicFieldInfo("PERFORMANCE_TOTAL");

   // 字段入职时间的定义。
   public final static SLogicFieldInfo ENTER_DATE = new SLogicFieldInfo("ENTER_DATE");

   // 字段离职时间的定义。
   public final static SLogicFieldInfo LEAVE_DATE = new SLogicFieldInfo("LEAVE_DATE");

   // 字段创建用户标识的定义。
   public final static SLogicFieldInfo CREATE_USER_ID = new SLogicFieldInfo("CREATE_USER_ID");

   // 字段创建日期的定义。
   public final static SLogicFieldInfo CREATE_DATE = new SLogicFieldInfo("CREATE_DATE");

   // 字段更新者标识的定义。
   public final static SLogicFieldInfo UPDATE_USER_ID = new SLogicFieldInfo("UPDATE_USER_ID");

   // 字段更新时间的定义。
   public final static SLogicFieldInfo UPDATE_DATE = new SLogicFieldInfo("UPDATE_DATE");

   // 字段集合的定义。
   public final static String FIELDS = "`OUID`,`OVLD`,`GUID`,`LINK_ID`,`LINK_DATE`,`LINK_CD`,`DATA_ID`,`DEPARTMENT_LINK_ID`,`DEPARTMENT_LABEL`,`DEPARTMENT_LEVEL1_ID`,`DEPARTMENT_LEVEL1_LABEL`,`DEPARTMENT_LEVEL2_ID`,`DEPARTMENT_LEVEL2_LABEL`,`DEPARTMENT_LEVEL3_ID`,`DEPARTMENT_LEVEL3_LABEL`,`DEPARTMENT_LEVEL4_ID`,`DEPARTMENT_LEVEL4_LABEL`,`DEPARTMENT_LEVEL5_ID`,`DEPARTMENT_LEVEL5_LABEL`,`DEPARTMENT_LEVEL6_ID`,`DEPARTMENT_LEVEL6_LABEL`,`DEPARTMENT_LEVEL7_ID`,`DEPARTMENT_LEVEL7_LABEL`,`DEPARTMENT_LEVEL8_ID`,`DEPARTMENT_LEVEL8_LABEL`,`CODE`,`LABEL`,`STATUS_CD`,`PHONE`,`CARD`,`RANK_LABEL`,`INVESTMENT_TOTAL`,`REDEMPTION_TOTAL`,`NETINVESTMENT_TOTAL`,`INTEREST_TOTAL`,`PERFORMANCE_TOTAL`,`ENTER_DATE`,`LEAVE_DATE`,`CREATE_USER_ID`,`CREATE_DATE`,`UPDATE_USER_ID`,`UPDATE_DATE`";

   //============================================================
   // <T>构造理财师统计表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialMarketerLogic(){
      _name = TABLE.name();
      _classUnit = FStatisticsFinancialMarketerUnit.class;
   }

   //============================================================
   // <T>构造理财师统计表逻辑单元。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FStatisticsFinancialMarketerLogic(ILogicContext context){
      super(context);
      _name = TABLE.name();
      _classUnit = FStatisticsFinancialMarketerUnit.class;
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
   public String makeFindSql(CharSequence fields, long id){
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
   public <T extends FLogicUnit> T find(T unit, Class<T> clazz, long recordId){
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
            unit = (T)(new FStatisticsFinancialMarketerUnit());
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
   public FStatisticsFinancialMarketerUnit findByGuid(CharSequence guid){
      return findByGuid(null, FStatisticsFinancialMarketerUnit.class, guid);
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
   public <T extends FLogicUnit> T findByGuid(T unit, Class<T> clazz, CharSequence guid){
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
   public FStatisticsFinancialMarketerUnit search(CharSequence whereSql){
      return search(null, FStatisticsFinancialMarketerUnit.class, whereSql);
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
   public <T extends FLogicUnit> T search(T unit, Class<T> clazz, CharSequence whereSql){
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
   public FLogicDataset<FStatisticsFinancialMarketerUnit> fetch(CharSequence whereSql){
      return fetchClass(null, null, whereSql, null, null, -1, 0);
   }

   //============================================================
   // <T>获得数据单元集合。</T>
   //
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FStatisticsFinancialMarketerUnit> fetch(int pageSize, int page){
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
   public FLogicDataset<FStatisticsFinancialMarketerUnit> fetch(CharSequence whereSql, int pageSize, int page){
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
   public FLogicDataset<FStatisticsFinancialMarketerUnit> fetch(CharSequence whereSql, CharSequence orderSql){
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
   public FLogicDataset<FStatisticsFinancialMarketerUnit> fetch(CharSequence whereSql, CharSequence orderSql, int pageSize, int page){
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
   public FLogicDataset<FStatisticsFinancialMarketerUnit> fetch(CharSequence fields, CharSequence whereSql, CharSequence orderSql, int pageSize, int page){
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
   public FLogicDataset<FStatisticsFinancialMarketerUnit> fetch(CharSequence fields, CharSequence whereSql, CharSequence groupSql, CharSequence orderSql, int pageSize, int page){
      return fetchClass(null, fields, whereSql, groupSql, orderSql, pageSize, page);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param clazz 单元类型
   // @param whereSql 条件命令
   // @return 数据单元集合
   //============================================================
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz, CharSequence whereSql){
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
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz, CharSequence whereSql, int pageSize, int page){
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
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz, CharSequence whereSql, CharSequence orderSql){
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
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz, CharSequence whereSql, CharSequence orderSql, int pageSize, int page){
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
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz, CharSequence fields, CharSequence whereSql, CharSequence orderSql, int pageSize, int page){
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
   public <T extends FLogicUnit> FLogicDataset<T> fetchClass(Class<T> clazz, CharSequence fields, CharSequence whereSql, CharSequence groupSql, CharSequence orderSql, int pageSize, int page){
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
   public FLogicDataset<FStatisticsFinancialMarketerUnit> fetchSql(CharSequence code, CharSequence sql, int pageSize, int page){
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
   public <T extends FLogicUnit> FLogicDataset<T> fetchSql(Class<T> clazz, CharSequence code, CharSequence sql, int pageSize, int page){
      // 获得数据
      FDataset dataset = innerFindDataset(code, sql, pageSize, page);
      // 返回结果
      FLogicDataset<T> result = null;
      if(clazz == null){
         result = (FLogicDataset<T>)(new FLogicDataset<FStatisticsFinancialMarketerUnit>(FStatisticsFinancialMarketerUnit.class, _logicContext));
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
   public FLogicDataset<FStatisticsFinancialMarketerUnit> fetchAll(){
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
   public FStatisticsFinancialMarketerUnit doPrepare(){
      FStatisticsFinancialMarketerUnit unit = new FStatisticsFinancialMarketerUnit();
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
      FStatisticsFinancialMarketerUnit unit = (FStatisticsFinancialMarketerUnit)logicUnit;
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
      FStatisticsFinancialMarketerUnit unit = (FStatisticsFinancialMarketerUnit)logicUnit;
      long ouid = unit.ouid();
      // 设置操作用户
      if((unit.createUserId() == 0)|| (unit.updateUserId() == 0)){
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
      cmd.append(",`DEPARTMENT_LINK_ID`");
      cmd.append(",`DEPARTMENT_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL1_ID`");
      cmd.append(",`DEPARTMENT_LEVEL1_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL2_ID`");
      cmd.append(",`DEPARTMENT_LEVEL2_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL3_ID`");
      cmd.append(",`DEPARTMENT_LEVEL3_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL4_ID`");
      cmd.append(",`DEPARTMENT_LEVEL4_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL5_ID`");
      cmd.append(",`DEPARTMENT_LEVEL5_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL6_ID`");
      cmd.append(",`DEPARTMENT_LEVEL6_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL7_ID`");
      cmd.append(",`DEPARTMENT_LEVEL7_LABEL`");
      cmd.append(",`DEPARTMENT_LEVEL8_ID`");
      cmd.append(",`DEPARTMENT_LEVEL8_LABEL`");
      cmd.append(",`CODE`");
      cmd.append(",`LABEL`");
      cmd.append(",`STATUS_CD`");
      cmd.append(",`PHONE`");
      cmd.append(",`CARD`");
      cmd.append(",`RANK_LABEL`");
      cmd.append(",`INVESTMENT_TOTAL`");
      cmd.append(",`REDEMPTION_TOTAL`");
      cmd.append(",`NETINVESTMENT_TOTAL`");
      cmd.append(",`INTEREST_TOTAL`");
      cmd.append(",`PERFORMANCE_TOTAL`");
      cmd.append(",`ENTER_DATE`");
      cmd.append(",`LEAVE_DATE`");
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
      String departmentLevel7Label = unit.departmentLevel7Label();
      if(RString.isEmpty(departmentLevel7Label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLevel7Label));
         cmd.append('\'');
      }
      cmd.append(',');
      long departmentLevel8Id = unit.departmentLevel8Id();
      if(departmentLevel8Id == 0){
         cmd.append("NULL");
      }else{
         cmd.append(departmentLevel8Id);
      }
      cmd.append(',');
      String departmentLevel8Label = unit.departmentLevel8Label();
      if(RString.isEmpty(departmentLevel8Label)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentLevel8Label));
         cmd.append('\'');
      }
      cmd.append(',');
      String code = unit.code();
      if(RString.isEmpty(code)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(code));
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
      cmd.append(unit.statusCd());
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
      String card = unit.card();
      if(RString.isEmpty(card)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(card));
         cmd.append('\'');
      }
      cmd.append(',');
      String rankLabel = unit.rankLabel();
      if(RString.isEmpty(rankLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(rankLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.investmentTotal());
      cmd.append(',');
      cmd.append(unit.redemptionTotal());
      cmd.append(',');
      cmd.append(unit.netinvestmentTotal());
      cmd.append(',');
      cmd.append(unit.interestTotal());
      cmd.append(',');
      cmd.append(unit.performanceTotal());
      cmd.append(',');
      TDateTime enterDate = unit.enterDate();
      if(enterDate == null){
         cmd.append("NULL");
      }else if(enterDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(enterDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime leaveDate = unit.leaveDate();
      if(leaveDate == null){
         cmd.append("NULL");
      }else if(leaveDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(leaveDate.format());
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
      FStatisticsFinancialMarketerUnit unit = (FStatisticsFinancialMarketerUnit)logicUnit;
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
      FStatisticsFinancialMarketerUnit unit = (FStatisticsFinancialMarketerUnit)logicUnit;
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
      if(unit.isDepartmentLevel8IdChanged()){
         cmd.append(",`DEPARTMENT_LEVEL8_ID`=");
         long departmentLevel8Id = unit.departmentLevel8Id();
         if(departmentLevel8Id == 0){
            cmd.append("NULL");
         }else{
            cmd.append(departmentLevel8Id);
         }
      }
      if(unit.isDepartmentLevel8LabelChanged()){
         cmd.append(",`DEPARTMENT_LEVEL8_LABEL`=");
         String departmentLevel8Label = unit.departmentLevel8Label();
         if(RString.isEmpty(departmentLevel8Label)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentLevel8Label));
            cmd.append('\'');
         }
      }
      if(unit.isCodeChanged()){
         cmd.append(",`CODE`=");
         String code = unit.code();
         if(RString.isEmpty(code)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(code));
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
      if(unit.isStatusCdChanged()){
         cmd.append(",`STATUS_CD`=");
         cmd.append(unit.statusCd());
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
      if(unit.isRankLabelChanged()){
         cmd.append(",`RANK_LABEL`=");
         String rankLabel = unit.rankLabel();
         if(RString.isEmpty(rankLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(rankLabel));
            cmd.append('\'');
         }
      }
      if(unit.isInvestmentTotalChanged()){
         cmd.append(",`INVESTMENT_TOTAL`=");
         cmd.append(unit.investmentTotal());
      }
      if(unit.isRedemptionTotalChanged()){
         cmd.append(",`REDEMPTION_TOTAL`=");
         cmd.append(unit.redemptionTotal());
      }
      if(unit.isNetinvestmentTotalChanged()){
         cmd.append(",`NETINVESTMENT_TOTAL`=");
         cmd.append(unit.netinvestmentTotal());
      }
      if(unit.isInterestTotalChanged()){
         cmd.append(",`INTEREST_TOTAL`=");
         cmd.append(unit.interestTotal());
      }
      if(unit.isPerformanceTotalChanged()){
         cmd.append(",`PERFORMANCE_TOTAL`=");
         cmd.append(unit.performanceTotal());
      }
      if(unit.isEnterDateChanged()){
         cmd.append(",`ENTER_DATE`=");
         TDateTime enterDate = unit.enterDate();
         if(enterDate == null){
            cmd.append("NULL");
         }else if(enterDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(enterDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isLeaveDateChanged()){
         cmd.append(",`LEAVE_DATE`=");
         TDateTime leaveDate = unit.leaveDate();
         if(leaveDate == null){
            cmd.append("NULL");
         }else if(leaveDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(leaveDate.format());
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
      FStatisticsFinancialMarketerUnit unit = (FStatisticsFinancialMarketerUnit)logicUnit;
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

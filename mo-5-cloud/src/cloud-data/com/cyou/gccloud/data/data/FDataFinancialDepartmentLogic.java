package com.cyou.gccloud.data.data;

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
// <T>金融部门信息逻辑。</T>
//============================================================
@ASourceMachine
public class FDataFinancialDepartmentLogic extends FLogicTable
{
   // 金融部门信息的定义。
   public final static SLogicConnectionInfo CONNECTION = new SLogicConnectionInfo("data");

   // 金融部门信息的定义。
   public final static SLogicTableInfo TABLE = new SLogicTableInfo("data.financial.department", "DT_FIN_DEPARTMENT");

   // 字段对象标识的定义。
   public final static SLogicFieldInfo OUID = new SLogicFieldInfo("OUID");

   // 字段有效性的定义。
   public final static SLogicFieldInfo OVLD = new SLogicFieldInfo("OVLD");

   // 字段对象唯一标识的定义。
   public final static SLogicFieldInfo GUID = new SLogicFieldInfo("GUID");

   // 字段关联父编号的定义。
   public final static SLogicFieldInfo LINK_PARENT_ID = new SLogicFieldInfo("LINK_PARENT_ID");

   // 字段关联编号的定义。
   public final static SLogicFieldInfo LINK_ID = new SLogicFieldInfo("LINK_ID");

   // 字段代码的定义。
   public final static SLogicFieldInfo CODE = new SLogicFieldInfo("CODE");

   // 字段名称的定义。
   public final static SLogicFieldInfo NAME = new SLogicFieldInfo("NAME");

   // 字段名称的定义。
   public final static SLogicFieldInfo LABEL = new SLogicFieldInfo("LABEL");

   // 字段所属公司编号的定义。
   public final static SLogicFieldInfo DEPARTMENT_ID = new SLogicFieldInfo("DEPARTMENT_ID");

   // 字段所属公司名称的定义。
   public final static SLogicFieldInfo DEPARTMENT_LABEL = new SLogicFieldInfo("DEPARTMENT_LABEL");

   // 字段所属区域编号的定义。
   public final static SLogicFieldInfo REGION_ID = new SLogicFieldInfo("REGION_ID");

   // 字段区域名称的定义。
   public final static SLogicFieldInfo REGION_LABEL = new SLogicFieldInfo("REGION_LABEL");

   // 字段级别的定义。
   public final static SLogicFieldInfo LEVEL = new SLogicFieldInfo("LEVEL");

   // 字段负责人编号的定义。
   public final static SLogicFieldInfo LEADER_ID = new SLogicFieldInfo("LEADER_ID");

   // 字段负责人标签的定义。
   public final static SLogicFieldInfo LEADER_LABEL = new SLogicFieldInfo("LEADER_LABEL");

   // 字段负责人电话的定义。
   public final static SLogicFieldInfo LEADER_PHONE = new SLogicFieldInfo("LEADER_PHONE");

   // 字段省份标签编号的定义。
   public final static SLogicFieldInfo PROVINCE_ID = new SLogicFieldInfo("PROVINCE_ID");

   // 字段省份标签的定义。
   public final static SLogicFieldInfo PROVINCE_LABEL = new SLogicFieldInfo("PROVINCE_LABEL");

   // 字段城市编号的定义。
   public final static SLogicFieldInfo CITY_ID = new SLogicFieldInfo("CITY_ID");

   // 字段城市标签的定义。
   public final static SLogicFieldInfo CITY_LABEL = new SLogicFieldInfo("CITY_LABEL");

   // 字段详细地址的定义。
   public final static SLogicFieldInfo DETAIL_ADDRESS = new SLogicFieldInfo("DETAIL_ADDRESS");

   // 字段位置经度的定义。
   public final static SLogicFieldInfo LOCATION_LONGITUDE = new SLogicFieldInfo("LOCATION_LONGITUDE");

   // 字段位置维度的定义。
   public final static SLogicFieldInfo LOCATION_LATITUDE = new SLogicFieldInfo("LOCATION_LATITUDE");

   // 字段部门电话的定义。
   public final static SLogicFieldInfo DEPARTMENT_PHONE = new SLogicFieldInfo("DEPARTMENT_PHONE");

   // 字段建立日期的定义。
   public final static SLogicFieldInfo BUILD_DATE = new SLogicFieldInfo("BUILD_DATE");

   // 字段投资总额的定义。
   public final static SLogicFieldInfo INVESTMENT_TOTAL = new SLogicFieldInfo("INVESTMENT_TOTAL");

   // 字段投资次数的定义。
   public final static SLogicFieldInfo INVESTMENT_COUNT = new SLogicFieldInfo("INVESTMENT_COUNT");

   // 字段投资时间的定义。
   public final static SLogicFieldInfo INVESTMENT_DATE = new SLogicFieldInfo("INVESTMENT_DATE");

   // 字段赎回总额的定义。
   public final static SLogicFieldInfo REDEMPTION_TOTAL = new SLogicFieldInfo("REDEMPTION_TOTAL");

   // 字段赎回次数的定义。
   public final static SLogicFieldInfo REDEMPTION_COUNT = new SLogicFieldInfo("REDEMPTION_COUNT");

   // 字段赎回时间的定义。
   public final static SLogicFieldInfo REDEMPTION_DATE = new SLogicFieldInfo("REDEMPTION_DATE");

   // 字段净投总额的定义。
   public final static SLogicFieldInfo NETINVESTMENT_TOTAL = new SLogicFieldInfo("NETINVESTMENT_TOTAL");

   // 字段利息总额的定义。
   public final static SLogicFieldInfo INTEREST_TOTAL = new SLogicFieldInfo("INTEREST_TOTAL");

   // 字段业绩总额的定义。
   public final static SLogicFieldInfo PERFORMANCE_TOTAL = new SLogicFieldInfo("PERFORMANCE_TOTAL");

   // 字段备注信息的定义。
   public final static SLogicFieldInfo NOTE = new SLogicFieldInfo("NOTE");

   // 字段创建用户标识的定义。
   public final static SLogicFieldInfo CREATE_USER_ID = new SLogicFieldInfo("CREATE_USER_ID");

   // 字段创建日期的定义。
   public final static SLogicFieldInfo CREATE_DATE = new SLogicFieldInfo("CREATE_DATE");

   // 字段更新者标识的定义。
   public final static SLogicFieldInfo UPDATE_USER_ID = new SLogicFieldInfo("UPDATE_USER_ID");

   // 字段更新时间的定义。
   public final static SLogicFieldInfo UPDATE_DATE = new SLogicFieldInfo("UPDATE_DATE");

   // 字段集合的定义。
   public final static String FIELDS = "`OUID`,`OVLD`,`GUID`,`LINK_PARENT_ID`,`LINK_ID`,`CODE`,`NAME`,`LABEL`,`DEPARTMENT_ID`,`DEPARTMENT_LABEL`,`REGION_ID`,`REGION_LABEL`,`LEVEL`,`LEADER_ID`,`LEADER_LABEL`,`LEADER_PHONE`,`PROVINCE_ID`,`PROVINCE_LABEL`,`CITY_ID`,`CITY_LABEL`,`DETAIL_ADDRESS`,`LOCATION_LONGITUDE`,`LOCATION_LATITUDE`,`DEPARTMENT_PHONE`,`BUILD_DATE`,`INVESTMENT_TOTAL`,`INVESTMENT_COUNT`,`INVESTMENT_DATE`,`REDEMPTION_TOTAL`,`REDEMPTION_COUNT`,`REDEMPTION_DATE`,`NETINVESTMENT_TOTAL`,`INTEREST_TOTAL`,`PERFORMANCE_TOTAL`,`NOTE`,`CREATE_USER_ID`,`CREATE_DATE`,`UPDATE_USER_ID`,`UPDATE_DATE`";

   //============================================================
   // <T>构造金融部门信息逻辑单元。</T>
   //============================================================
   public FDataFinancialDepartmentLogic(){
      _name = TABLE.name();
      _classUnit = FDataFinancialDepartmentUnit.class;
   }

   //============================================================
   // <T>构造金融部门信息逻辑单元。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FDataFinancialDepartmentLogic(ILogicContext context){
      super(context);
      _name = TABLE.name();
      _classUnit = FDataFinancialDepartmentUnit.class;
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
            unit = (T)(new FDataFinancialDepartmentUnit());
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
   public FDataFinancialDepartmentUnit findByGuid(CharSequence guid){
      return findByGuid(null, FDataFinancialDepartmentUnit.class, guid);
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
   public FDataFinancialDepartmentUnit search(CharSequence whereSql){
      return search(null, FDataFinancialDepartmentUnit.class, whereSql);
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
   public FLogicDataset<FDataFinancialDepartmentUnit> fetch(CharSequence whereSql){
      return fetchClass(null, null, whereSql, null, null, -1, 0);
   }

   //============================================================
   // <T>获得数据单元集合。</T>
   //
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FDataFinancialDepartmentUnit> fetch(int pageSize, int page){
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
   public FLogicDataset<FDataFinancialDepartmentUnit> fetch(CharSequence whereSql, int pageSize, int page){
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
   public FLogicDataset<FDataFinancialDepartmentUnit> fetch(CharSequence whereSql, CharSequence orderSql){
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
   public FLogicDataset<FDataFinancialDepartmentUnit> fetch(CharSequence whereSql, CharSequence orderSql, int pageSize, int page){
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
   public FLogicDataset<FDataFinancialDepartmentUnit> fetch(CharSequence fields, CharSequence whereSql, CharSequence orderSql, int pageSize, int page){
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
   public FLogicDataset<FDataFinancialDepartmentUnit> fetch(CharSequence fields, CharSequence whereSql, CharSequence groupSql, CharSequence orderSql, int pageSize, int page){
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
   public FLogicDataset<FDataFinancialDepartmentUnit> fetchSql(CharSequence code, CharSequence sql, int pageSize, int page){
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
         result = (FLogicDataset<T>)(new FLogicDataset<FDataFinancialDepartmentUnit>(FDataFinancialDepartmentUnit.class, _logicContext));
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
   public FLogicDataset<FDataFinancialDepartmentUnit> fetchAll(){
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
   public FDataFinancialDepartmentUnit doPrepare(){
      FDataFinancialDepartmentUnit unit = new FDataFinancialDepartmentUnit();
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
      FDataFinancialDepartmentUnit unit = (FDataFinancialDepartmentUnit)logicUnit;
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
      FDataFinancialDepartmentUnit unit = (FDataFinancialDepartmentUnit)logicUnit;
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
      cmd.append(",`LINK_PARENT_ID`");
      cmd.append(",`LINK_ID`");
      cmd.append(",`CODE`");
      cmd.append(",`NAME`");
      cmd.append(",`LABEL`");
      cmd.append(",`DEPARTMENT_ID`");
      cmd.append(",`DEPARTMENT_LABEL`");
      cmd.append(",`REGION_ID`");
      cmd.append(",`REGION_LABEL`");
      cmd.append(",`LEVEL`");
      cmd.append(",`LEADER_ID`");
      cmd.append(",`LEADER_LABEL`");
      cmd.append(",`LEADER_PHONE`");
      cmd.append(",`PROVINCE_ID`");
      cmd.append(",`PROVINCE_LABEL`");
      cmd.append(",`CITY_ID`");
      cmd.append(",`CITY_LABEL`");
      cmd.append(",`DETAIL_ADDRESS`");
      cmd.append(",`LOCATION_LONGITUDE`");
      cmd.append(",`LOCATION_LATITUDE`");
      cmd.append(",`DEPARTMENT_PHONE`");
      cmd.append(",`BUILD_DATE`");
      cmd.append(",`INVESTMENT_TOTAL`");
      cmd.append(",`INVESTMENT_COUNT`");
      cmd.append(",`INVESTMENT_DATE`");
      cmd.append(",`REDEMPTION_TOTAL`");
      cmd.append(",`REDEMPTION_COUNT`");
      cmd.append(",`REDEMPTION_DATE`");
      cmd.append(",`NETINVESTMENT_TOTAL`");
      cmd.append(",`INTEREST_TOTAL`");
      cmd.append(",`PERFORMANCE_TOTAL`");
      cmd.append(",`NOTE`");
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
      long linkParentId = unit.linkParentId();
      if(linkParentId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(linkParentId);
      }
      cmd.append(',');
      long linkId = unit.linkId();
      if(linkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(linkId);
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
      String name = unit.name();
      if(RString.isEmpty(name)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(name));
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
      cmd.append(unit.departmentId());
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
      cmd.append(unit.regionId());
      cmd.append(',');
      String regionLabel = unit.regionLabel();
      if(RString.isEmpty(regionLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(regionLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.level());
      cmd.append(',');
      long leaderId = unit.leaderId();
      if(leaderId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(leaderId);
      }
      cmd.append(',');
      String leaderLabel = unit.leaderLabel();
      if(RString.isEmpty(leaderLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(leaderLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      String leaderPhone = unit.leaderPhone();
      if(RString.isEmpty(leaderPhone)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(leaderPhone));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.provinceId());
      cmd.append(',');
      String provinceLabel = unit.provinceLabel();
      if(RString.isEmpty(provinceLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(provinceLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.cityId());
      cmd.append(',');
      String cityLabel = unit.cityLabel();
      if(RString.isEmpty(cityLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(cityLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      String detailAddress = unit.detailAddress();
      if(RString.isEmpty(detailAddress)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(detailAddress));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.locationLongitude());
      cmd.append(',');
      cmd.append(unit.locationLatitude());
      cmd.append(',');
      String departmentPhone = unit.departmentPhone();
      if(RString.isEmpty(departmentPhone)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(departmentPhone));
         cmd.append('\'');
      }
      cmd.append(',');
      TDateTime buildDate = unit.buildDate();
      if(buildDate == null){
         cmd.append("NULL");
      }else if(buildDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(buildDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      cmd.append(unit.investmentTotal());
      cmd.append(',');
      cmd.append(unit.investmentCount());
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
      cmd.append(unit.redemptionTotal());
      cmd.append(',');
      cmd.append(unit.redemptionCount());
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
      cmd.append(unit.netinvestmentTotal());
      cmd.append(',');
      cmd.append(unit.interestTotal());
      cmd.append(',');
      cmd.append(unit.performanceTotal());
      cmd.append(',');
      String note = unit.note();
      if(RString.isEmpty(note)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(note));
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
      FDataFinancialDepartmentUnit unit = (FDataFinancialDepartmentUnit)logicUnit;
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
      FDataFinancialDepartmentUnit unit = (FDataFinancialDepartmentUnit)logicUnit;
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
      if(unit.isLinkParentIdChanged()){
         cmd.append(",`LINK_PARENT_ID`=");
         long linkParentId = unit.linkParentId();
         if(linkParentId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(linkParentId);
         }
      }
      if(unit.isLinkIdChanged()){
         cmd.append(",`LINK_ID`=");
         long linkId = unit.linkId();
         if(linkId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(linkId);
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
      if(unit.isNameChanged()){
         cmd.append(",`NAME`=");
         String name = unit.name();
         if(RString.isEmpty(name)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(name));
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
      if(unit.isDepartmentIdChanged()){
         cmd.append(",`DEPARTMENT_ID`=");
         cmd.append(unit.departmentId());
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
      if(unit.isRegionIdChanged()){
         cmd.append(",`REGION_ID`=");
         cmd.append(unit.regionId());
      }
      if(unit.isRegionLabelChanged()){
         cmd.append(",`REGION_LABEL`=");
         String regionLabel = unit.regionLabel();
         if(RString.isEmpty(regionLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(regionLabel));
            cmd.append('\'');
         }
      }
      if(unit.isLevelChanged()){
         cmd.append(",`LEVEL`=");
         cmd.append(unit.level());
      }
      if(unit.isLeaderIdChanged()){
         cmd.append(",`LEADER_ID`=");
         long leaderId = unit.leaderId();
         if(leaderId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(leaderId);
         }
      }
      if(unit.isLeaderLabelChanged()){
         cmd.append(",`LEADER_LABEL`=");
         String leaderLabel = unit.leaderLabel();
         if(RString.isEmpty(leaderLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(leaderLabel));
            cmd.append('\'');
         }
      }
      if(unit.isLeaderPhoneChanged()){
         cmd.append(",`LEADER_PHONE`=");
         String leaderPhone = unit.leaderPhone();
         if(RString.isEmpty(leaderPhone)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(leaderPhone));
            cmd.append('\'');
         }
      }
      if(unit.isProvinceIdChanged()){
         cmd.append(",`PROVINCE_ID`=");
         cmd.append(unit.provinceId());
      }
      if(unit.isProvinceLabelChanged()){
         cmd.append(",`PROVINCE_LABEL`=");
         String provinceLabel = unit.provinceLabel();
         if(RString.isEmpty(provinceLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(provinceLabel));
            cmd.append('\'');
         }
      }
      if(unit.isCityIdChanged()){
         cmd.append(",`CITY_ID`=");
         cmd.append(unit.cityId());
      }
      if(unit.isCityLabelChanged()){
         cmd.append(",`CITY_LABEL`=");
         String cityLabel = unit.cityLabel();
         if(RString.isEmpty(cityLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(cityLabel));
            cmd.append('\'');
         }
      }
      if(unit.isDetailAddressChanged()){
         cmd.append(",`DETAIL_ADDRESS`=");
         String detailAddress = unit.detailAddress();
         if(RString.isEmpty(detailAddress)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(detailAddress));
            cmd.append('\'');
         }
      }
      if(unit.isLocationLongitudeChanged()){
         cmd.append(",`LOCATION_LONGITUDE`=");
         cmd.append(unit.locationLongitude());
      }
      if(unit.isLocationLatitudeChanged()){
         cmd.append(",`LOCATION_LATITUDE`=");
         cmd.append(unit.locationLatitude());
      }
      if(unit.isDepartmentPhoneChanged()){
         cmd.append(",`DEPARTMENT_PHONE`=");
         String departmentPhone = unit.departmentPhone();
         if(RString.isEmpty(departmentPhone)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(departmentPhone));
            cmd.append('\'');
         }
      }
      if(unit.isBuildDateChanged()){
         cmd.append(",`BUILD_DATE`=");
         TDateTime buildDate = unit.buildDate();
         if(buildDate == null){
            cmd.append("NULL");
         }else if(buildDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(buildDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isInvestmentTotalChanged()){
         cmd.append(",`INVESTMENT_TOTAL`=");
         cmd.append(unit.investmentTotal());
      }
      if(unit.isInvestmentCountChanged()){
         cmd.append(",`INVESTMENT_COUNT`=");
         cmd.append(unit.investmentCount());
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
      if(unit.isRedemptionTotalChanged()){
         cmd.append(",`REDEMPTION_TOTAL`=");
         cmd.append(unit.redemptionTotal());
      }
      if(unit.isRedemptionCountChanged()){
         cmd.append(",`REDEMPTION_COUNT`=");
         cmd.append(unit.redemptionCount());
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
      if(unit.isNoteChanged()){
         cmd.append(",`NOTE`=");
         String note = unit.note();
         if(RString.isEmpty(note)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(note));
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
      FDataFinancialDepartmentUnit unit = (FDataFinancialDepartmentUnit)logicUnit;
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

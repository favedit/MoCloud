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
// <T>金融成员信息逻辑。</T>
//============================================================
@ASourceMachine
public class FDataFinancialMemberLogic extends FLogicTable
{
   // 金融成员信息的定义。
   public final static SLogicConnectionInfo CONNECTION = new SLogicConnectionInfo("data");

   // 金融成员信息的定义。
   public final static SLogicTableInfo TABLE = new SLogicTableInfo("data.financial.member", "DT_FIN_MEMBER");

   // 字段对象标识的定义。
   public final static SLogicFieldInfo OUID = new SLogicFieldInfo("OUID");

   // 字段有效性的定义。
   public final static SLogicFieldInfo OVLD = new SLogicFieldInfo("OVLD");

   // 字段对象唯一标识的定义。
   public final static SLogicFieldInfo GUID = new SLogicFieldInfo("GUID");

   // 字段用户编号的定义。
   public final static SLogicFieldInfo USER_ID = new SLogicFieldInfo("USER_ID");

   // 字段关联编号的定义。
   public final static SLogicFieldInfo LINK_ID = new SLogicFieldInfo("LINK_ID");

   // 字段统计编号的定义。
   public final static SLogicFieldInfo STATISTICS_ID = new SLogicFieldInfo("STATISTICS_ID");

   // 字段账号的定义。
   public final static SLogicFieldInfo PASSPORT = new SLogicFieldInfo("PASSPORT");

   // 字段名称的定义。
   public final static SLogicFieldInfo LABEL = new SLogicFieldInfo("LABEL");

   // 字段身份证号的定义。
   public final static SLogicFieldInfo CARD = new SLogicFieldInfo("CARD");

   // 字段生日的定义。
   public final static SLogicFieldInfo BIRTHDAY = new SLogicFieldInfo("BIRTHDAY");

   // 字段电话号码的定义。
   public final static SLogicFieldInfo PHONE = new SLogicFieldInfo("PHONE");

   // 字段电子邮箱的定义。
   public final static SLogicFieldInfo EMAIL = new SLogicFieldInfo("EMAIL");

   // 字段性别的定义。
   public final static SLogicFieldInfo GENDER_CD = new SLogicFieldInfo("GENDER_CD");

   // 字段婚姻类型的定义。
   public final static SLogicFieldInfo MARRY_CD = new SLogicFieldInfo("MARRY_CD");

   // 字段教育类型的定义。
   public final static SLogicFieldInfo EDUCATION_CD = new SLogicFieldInfo("EDUCATION_CD");

   // 字段职业类型的定义。
   public final static SLogicFieldInfo BUSINESS_CD = new SLogicFieldInfo("BUSINESS_CD");

   // 字段收入类型的定义。
   public final static SLogicFieldInfo INCOME_CD = new SLogicFieldInfo("INCOME_CD");

   // 字段区域编号的定义。
   public final static SLogicFieldInfo PROVINCE_AREA_ID = new SLogicFieldInfo("PROVINCE_AREA_ID");

   // 字段省份编号的定义。
   public final static SLogicFieldInfo PROVINCE_ID = new SLogicFieldInfo("PROVINCE_ID");

   // 字段城市编号的定义。
   public final static SLogicFieldInfo CITY_ID = new SLogicFieldInfo("CITY_ID");

   // 字段区域编号的定义。
   public final static SLogicFieldInfo AREA_ID = new SLogicFieldInfo("AREA_ID");

   // 字段地址信息的定义。
   public final static SLogicFieldInfo ADDRESS = new SLogicFieldInfo("ADDRESS");

   // 字段注册时间的定义。
   public final static SLogicFieldInfo REGISTER_DATE = new SLogicFieldInfo("REGISTER_DATE");

   // 字段最后登录时间的定义。
   public final static SLogicFieldInfo LAST_LOGIN_DATE = new SLogicFieldInfo("LAST_LOGIN_DATE");

   // 字段推荐理财师编号的定义。
   public final static SLogicFieldInfo RECOMMEND_MARKETER_ID = new SLogicFieldInfo("RECOMMEND_MARKETER_ID");

   // 字段推荐理财师用户编号的定义。
   public final static SLogicFieldInfo RECOMMEND_MARKETER_USER_ID = new SLogicFieldInfo("RECOMMEND_MARKETER_USER_ID");

   // 字段推荐开始时间的定义。
   public final static SLogicFieldInfo RECOMMEND_BEGIN_DATE = new SLogicFieldInfo("RECOMMEND_BEGIN_DATE");

   // 字段推荐结束时间的定义。
   public final static SLogicFieldInfo RECOMMEND_END_DATE = new SLogicFieldInfo("RECOMMEND_END_DATE");

   // 字段推荐评分的定义。
   public final static SLogicFieldInfo RECOMMEND_SCORE = new SLogicFieldInfo("RECOMMEND_SCORE");

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
   public final static String FIELDS = "`OUID`,`OVLD`,`GUID`,`USER_ID`,`LINK_ID`,`STATISTICS_ID`,`PASSPORT`,`LABEL`,`CARD`,`BIRTHDAY`,`PHONE`,`EMAIL`,`GENDER_CD`,`MARRY_CD`,`EDUCATION_CD`,`BUSINESS_CD`,`INCOME_CD`,`PROVINCE_AREA_ID`,`PROVINCE_ID`,`CITY_ID`,`AREA_ID`,`ADDRESS`,`REGISTER_DATE`,`LAST_LOGIN_DATE`,`RECOMMEND_MARKETER_ID`,`RECOMMEND_MARKETER_USER_ID`,`RECOMMEND_BEGIN_DATE`,`RECOMMEND_END_DATE`,`RECOMMEND_SCORE`,`NOTE`,`CREATE_USER_ID`,`CREATE_DATE`,`UPDATE_USER_ID`,`UPDATE_DATE`";

   //============================================================
   // <T>构造金融成员信息逻辑单元。</T>
   //============================================================
   public FDataFinancialMemberLogic(){
      _name = TABLE.name();
      _classUnit = FDataFinancialMemberUnit.class;
   }

   //============================================================
   // <T>构造金融成员信息逻辑单元。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FDataFinancialMemberLogic(ILogicContext context){
      super(context);
      _name = TABLE.name();
      _classUnit = FDataFinancialMemberUnit.class;
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
            unit = (T)(new FDataFinancialMemberUnit());
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
   public FDataFinancialMemberUnit findByGuid(CharSequence guid){
      return findByGuid(null, FDataFinancialMemberUnit.class, guid);
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
   public FDataFinancialMemberUnit search(CharSequence whereSql){
      return search(null, FDataFinancialMemberUnit.class, whereSql);
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
   public FLogicDataset<FDataFinancialMemberUnit> fetch(CharSequence whereSql){
      return fetchClass(null, null, whereSql, null, null, -1, 0);
   }

   //============================================================
   // <T>获得数据单元集合。</T>
   //
   // @param pageSize 分页大小
   // @param page 分页号码
   // @return 数据单元集合
   //============================================================
   public FLogicDataset<FDataFinancialMemberUnit> fetch(int pageSize, int page){
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
   public FLogicDataset<FDataFinancialMemberUnit> fetch(CharSequence whereSql, int pageSize, int page){
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
   public FLogicDataset<FDataFinancialMemberUnit> fetch(CharSequence whereSql, CharSequence orderSql){
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
   public FLogicDataset<FDataFinancialMemberUnit> fetch(CharSequence whereSql, CharSequence orderSql, int pageSize, int page){
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
   public FLogicDataset<FDataFinancialMemberUnit> fetch(CharSequence fields, CharSequence whereSql, CharSequence orderSql, int pageSize, int page){
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
   public FLogicDataset<FDataFinancialMemberUnit> fetch(CharSequence fields, CharSequence whereSql, CharSequence groupSql, CharSequence orderSql, int pageSize, int page){
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
   public FLogicDataset<FDataFinancialMemberUnit> fetchSql(CharSequence code, CharSequence sql, int pageSize, int page){
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
         result = (FLogicDataset<T>)(new FLogicDataset<FDataFinancialMemberUnit>(FDataFinancialMemberUnit.class, _logicContext));
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
   public FLogicDataset<FDataFinancialMemberUnit> fetchAll(){
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
   public FDataFinancialMemberUnit doPrepare(){
      FDataFinancialMemberUnit unit = new FDataFinancialMemberUnit();
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
      FDataFinancialMemberUnit unit = (FDataFinancialMemberUnit)logicUnit;
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
      FDataFinancialMemberUnit unit = (FDataFinancialMemberUnit)logicUnit;
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
      cmd.append(",`USER_ID`");
      cmd.append(",`LINK_ID`");
      cmd.append(",`STATISTICS_ID`");
      cmd.append(",`PASSPORT`");
      cmd.append(",`LABEL`");
      cmd.append(",`CARD`");
      cmd.append(",`BIRTHDAY`");
      cmd.append(",`PHONE`");
      cmd.append(",`EMAIL`");
      cmd.append(",`GENDER_CD`");
      cmd.append(",`MARRY_CD`");
      cmd.append(",`EDUCATION_CD`");
      cmd.append(",`BUSINESS_CD`");
      cmd.append(",`INCOME_CD`");
      cmd.append(",`PROVINCE_AREA_ID`");
      cmd.append(",`PROVINCE_ID`");
      cmd.append(",`CITY_ID`");
      cmd.append(",`AREA_ID`");
      cmd.append(",`ADDRESS`");
      cmd.append(",`REGISTER_DATE`");
      cmd.append(",`LAST_LOGIN_DATE`");
      cmd.append(",`RECOMMEND_MARKETER_ID`");
      cmd.append(",`RECOMMEND_MARKETER_USER_ID`");
      cmd.append(",`RECOMMEND_BEGIN_DATE`");
      cmd.append(",`RECOMMEND_END_DATE`");
      cmd.append(",`RECOMMEND_SCORE`");
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
      long userId = unit.userId();
      if(userId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(userId);
      }
      cmd.append(',');
      long linkId = unit.linkId();
      if(linkId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(linkId);
      }
      cmd.append(',');
      long statisticsId = unit.statisticsId();
      if(statisticsId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(statisticsId);
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
      TDateTime birthday = unit.birthday();
      if(birthday == null){
         cmd.append("NULL");
      }else if(birthday.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(birthday.format());
         cmd.append("','%Y%m%d%H%i%s')");
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
      cmd.append(unit.marryCd());
      cmd.append(',');
      cmd.append(unit.educationCd());
      cmd.append(',');
      cmd.append(unit.businessCd());
      cmd.append(',');
      cmd.append(unit.incomeCd());
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
      long cityId = unit.cityId();
      if(cityId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(cityId);
      }
      cmd.append(',');
      long areaId = unit.areaId();
      if(areaId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(areaId);
      }
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
      cmd.append(',');
      long recommendMarketerId = unit.recommendMarketerId();
      if(recommendMarketerId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(recommendMarketerId);
      }
      cmd.append(',');
      long recommendMarketerUserId = unit.recommendMarketerUserId();
      if(recommendMarketerUserId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(recommendMarketerUserId);
      }
      cmd.append(',');
      TDateTime recommendBeginDate = unit.recommendBeginDate();
      if(recommendBeginDate == null){
         cmd.append("NULL");
      }else if(recommendBeginDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(recommendBeginDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      TDateTime recommendEndDate = unit.recommendEndDate();
      if(recommendEndDate == null){
         cmd.append("NULL");
      }else if(recommendEndDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(recommendEndDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      cmd.append(unit.recommendScore());
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
      FDataFinancialMemberUnit unit = (FDataFinancialMemberUnit)logicUnit;
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
      FDataFinancialMemberUnit unit = (FDataFinancialMemberUnit)logicUnit;
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
      if(unit.isUserIdChanged()){
         cmd.append(",`USER_ID`=");
         long userId = unit.userId();
         if(userId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(userId);
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
      if(unit.isStatisticsIdChanged()){
         cmd.append(",`STATISTICS_ID`=");
         long statisticsId = unit.statisticsId();
         if(statisticsId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(statisticsId);
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
      if(unit.isBirthdayChanged()){
         cmd.append(",`BIRTHDAY`=");
         TDateTime birthday = unit.birthday();
         if(birthday == null){
            cmd.append("NULL");
         }else if(birthday.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(birthday.format());
            cmd.append("','%Y%m%d%H%i%s')");
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
      if(unit.isMarryCdChanged()){
         cmd.append(",`MARRY_CD`=");
         cmd.append(unit.marryCd());
      }
      if(unit.isEducationCdChanged()){
         cmd.append(",`EDUCATION_CD`=");
         cmd.append(unit.educationCd());
      }
      if(unit.isBusinessCdChanged()){
         cmd.append(",`BUSINESS_CD`=");
         cmd.append(unit.businessCd());
      }
      if(unit.isIncomeCdChanged()){
         cmd.append(",`INCOME_CD`=");
         cmd.append(unit.incomeCd());
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
      if(unit.isCityIdChanged()){
         cmd.append(",`CITY_ID`=");
         long cityId = unit.cityId();
         if(cityId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(cityId);
         }
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
      if(unit.isRecommendMarketerIdChanged()){
         cmd.append(",`RECOMMEND_MARKETER_ID`=");
         long recommendMarketerId = unit.recommendMarketerId();
         if(recommendMarketerId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(recommendMarketerId);
         }
      }
      if(unit.isRecommendMarketerUserIdChanged()){
         cmd.append(",`RECOMMEND_MARKETER_USER_ID`=");
         long recommendMarketerUserId = unit.recommendMarketerUserId();
         if(recommendMarketerUserId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(recommendMarketerUserId);
         }
      }
      if(unit.isRecommendBeginDateChanged()){
         cmd.append(",`RECOMMEND_BEGIN_DATE`=");
         TDateTime recommendBeginDate = unit.recommendBeginDate();
         if(recommendBeginDate == null){
            cmd.append("NULL");
         }else if(recommendBeginDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(recommendBeginDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isRecommendEndDateChanged()){
         cmd.append(",`RECOMMEND_END_DATE`=");
         TDateTime recommendEndDate = unit.recommendEndDate();
         if(recommendEndDate == null){
            cmd.append("NULL");
         }else if(recommendEndDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(recommendEndDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isRecommendScoreChanged()){
         cmd.append(",`RECOMMEND_SCORE`=");
         cmd.append(unit.recommendScore());
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
      FDataFinancialMemberUnit unit = (FDataFinancialMemberUnit)logicUnit;
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

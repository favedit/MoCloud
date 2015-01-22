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
// <T>人员用户信息逻辑。</T>
//============================================================
@ASourceMachine
public class FDataPersonUserLogic
      extends FLogicTable
{
   // 人员用户信息的定义。
   public final static SLogicConnectionInfo CONNECTION = new SLogicConnectionInfo("data");

   // 人员用户信息的定义。
   public final static SLogicTableInfo TABLE = new SLogicTableInfo("data.person.user", "DT_PSN_USER");

   // 字段对象标识的定义。
   public final static SLogicFieldInfo OUID = new SLogicFieldInfo("OUID");

   // 字段有效性的定义。
   public final static SLogicFieldInfo OVLD = new SLogicFieldInfo("OVLD");

   // 字段对象唯一标识的定义。
   public final static SLogicFieldInfo GUID = new SLogicFieldInfo("GUID");

   // 字段代码的定义。
   public final static SLogicFieldInfo CODE = new SLogicFieldInfo("CODE");

   // 字段帐号的定义。
   public final static SLogicFieldInfo PASSPORT = new SLogicFieldInfo("PASSPORT");

   // 字段上次登录时间的定义。
   public final static SLogicFieldInfo PASSPORT_LOGIN_DATE = new SLogicFieldInfo("PASSPORT_LOGIN_DATE");

   // 字段密码的定义。
   public final static SLogicFieldInfo PASSWORD = new SLogicFieldInfo("PASSWORD");

   // 字段密码更新时间的定义。
   public final static SLogicFieldInfo PASSWORD_UPDATE_DATE = new SLogicFieldInfo("PASSWORD_UPDATE_DATE");

   // 字段状态类型的定义。
   public final static SLogicFieldInfo STATUS_CD = new SLogicFieldInfo("STATUS_CD");

   // 字段角色类型的定义。
   public final static SLogicFieldInfo ROLE_CD = new SLogicFieldInfo("ROLE_CD");

   // 字段业务角色编号的定义。
   public final static SLogicFieldInfo ROLE_ID = new SLogicFieldInfo("ROLE_ID");

   // 字段开发类型的定义。
   public final static SLogicFieldInfo DEVELOP_CD = new SLogicFieldInfo("DEVELOP_CD");

   // 字段教师类型的定义。
   public final static SLogicFieldInfo TEACHER_CD = new SLogicFieldInfo("TEACHER_CD");

   // 字段导师编号的定义。
   public final static SLogicFieldInfo TEACHER_ID = new SLogicFieldInfo("TEACHER_ID");

   // 字段显示名称的定义。
   public final static SLogicFieldInfo ALIAS = new SLogicFieldInfo("ALIAS");

   // 字段真实名称的定义。
   public final static SLogicFieldInfo LABEL = new SLogicFieldInfo("LABEL");

   // 字段真实名称权限类型的定义。
   public final static SLogicFieldInfo LABEL_SECURITY_CD = new SLogicFieldInfo("LABEL_SECURITY_CD");

   // 字段性别代码的定义。
   public final static SLogicFieldInfo GENDER_CD = new SLogicFieldInfo("GENDER_CD");

   // 字段性别权限类型的定义。
   public final static SLogicFieldInfo GENDER_SECURITY_CD = new SLogicFieldInfo("GENDER_SECURITY_CD");

   // 字段生日的定义。
   public final static SLogicFieldInfo BIRTHDAY = new SLogicFieldInfo("BIRTHDAY");

   // 字段生日权限类型的定义。
   public final static SLogicFieldInfo BIRTHDAY_SECURITY_CD = new SLogicFieldInfo("BIRTHDAY_SECURITY_CD");

   // 字段图标地址的定义。
   public final static SLogicFieldInfo ICON_URL = new SLogicFieldInfo("ICON_URL");

   // 字段联系电话号码的定义。
   public final static SLogicFieldInfo CONTACT_PHONE = new SLogicFieldInfo("CONTACT_PHONE");

   // 字段联系电话权号码限类型的定义。
   public final static SLogicFieldInfo CONTACT_PHONE_SECURITY_CD = new SLogicFieldInfo("CONTACT_PHONE_SECURITY_CD");

   // 字段联系电话号码验证类型的定义。
   public final static SLogicFieldInfo CONTACT_PHONE_VERIFY_CD = new SLogicFieldInfo("CONTACT_PHONE_VERIFY_CD");

   // 字段联系邮箱地址的定义。
   public final static SLogicFieldInfo CONTACT_EMAIL = new SLogicFieldInfo("CONTACT_EMAIL");

   // 字段联系邮箱地址验证类型的定义。
   public final static SLogicFieldInfo CONTACT_EMAIL_SECURITY_CD = new SLogicFieldInfo("CONTACT_EMAIL_SECURITY_CD");

   // 字段联系邮箱地址验证类型的定义。
   public final static SLogicFieldInfo CONTACT_EMAIL_VERIFY_CD = new SLogicFieldInfo("CONTACT_EMAIL_VERIFY_CD");

   // 字段联系QQ号码的定义。
   public final static SLogicFieldInfo CONTACT_QQ = new SLogicFieldInfo("CONTACT_QQ");

   // 字段联系QQ号码权限类型的定义。
   public final static SLogicFieldInfo CONTACT_QQ_SECURITY_CD = new SLogicFieldInfo("CONTACT_QQ_SECURITY_CD");

   // 字段联系MSN号码的定义。
   public final static SLogicFieldInfo CONTACT_MSN = new SLogicFieldInfo("CONTACT_MSN");

   // 字段联系MSN号码权限类型的定义。
   public final static SLogicFieldInfo CONTACT_MSN_SECURITY_CD = new SLogicFieldInfo("CONTACT_MSN_SECURITY_CD");

   // 字段学校类型的定义。
   public final static SLogicFieldInfo SCHOOL_CD = new SLogicFieldInfo("SCHOOL_CD");

   // 字段学校编号的定义。
   public final static SLogicFieldInfo SCHOOL_ID = new SLogicFieldInfo("SCHOOL_ID");

   // 字段学校名称的定义。
   public final static SLogicFieldInfo SCHOOL_LABEL = new SLogicFieldInfo("SCHOOL_LABEL");

   // 字段入学年份的定义。
   public final static SLogicFieldInfo SCHOOL_ENTER_YEAR = new SLogicFieldInfo("SCHOOL_ENTER_YEAR");

   // 字段院系编号的定义。
   public final static SLogicFieldInfo SCHOOL_PART_ID = new SLogicFieldInfo("SCHOOL_PART_ID");

   // 字段院系名称的定义。
   public final static SLogicFieldInfo SCHOOL_PART_LABEL = new SLogicFieldInfo("SCHOOL_PART_LABEL");

   // 字段班级编号的定义。
   public final static SLogicFieldInfo SCHOOL_CLASS_ID = new SLogicFieldInfo("SCHOOL_CLASS_ID");

   // 字段班级名称的定义。
   public final static SLogicFieldInfo SCHOOL_CLASS_LABEL = new SLogicFieldInfo("SCHOOL_CLASS_LABEL");

   // 字段公司编号的定义。
   public final static SLogicFieldInfo COMPANY_ID = new SLogicFieldInfo("COMPANY_ID");

   // 字段公司名称的定义。
   public final static SLogicFieldInfo COMPANY_LABEL = new SLogicFieldInfo("COMPANY_LABEL");

   // 字段省份编号的定义。
   public final static SLogicFieldInfo HOME_PROVINCE_ID = new SLogicFieldInfo("HOME_PROVINCE_ID");

   // 字段家庭电话的定义。
   public final static SLogicFieldInfo HOME_PHONE = new SLogicFieldInfo("HOME_PHONE");

   // 字段家庭地址的定义。
   public final static SLogicFieldInfo HOME_ADDRESS = new SLogicFieldInfo("HOME_ADDRESS");

   // 字段级别的定义。
   public final static SLogicFieldInfo SCORE_LEVEL = new SLogicFieldInfo("SCORE_LEVEL");

   // 字段点数(豆豆)的定义。
   public final static SLogicFieldInfo SCORE_BEAN = new SLogicFieldInfo("SCORE_BEAN");

   // 字段最大点数(豆豆)的定义。
   public final static SLogicFieldInfo SCORE_BEAN_EXPERIENCE = new SLogicFieldInfo("SCORE_BEAN_EXPERIENCE");

   // 字段点数(豆币)的定义。
   public final static SLogicFieldInfo SCORE_POINT = new SLogicFieldInfo("SCORE_POINT");

   // 字段最大点数(豆币)的定义。
   public final static SLogicFieldInfo SCORE_POINT_EXPERIENCE = new SLogicFieldInfo("SCORE_POINT_EXPERIENCE");

   // 字段点数(金币)的定义。
   public final static SLogicFieldInfo SCORE_GOLD = new SLogicFieldInfo("SCORE_GOLD");

   // 字段最大点数(金币)的定义。
   public final static SLogicFieldInfo SCORE_GOLD_EXPERIENCE = new SLogicFieldInfo("SCORE_GOLD_EXPERIENCE");

   // 字段描述的定义。
   public final static SLogicFieldInfo DESCRIPTION = new SLogicFieldInfo("DESCRIPTION");

   // 字段内容的定义。
   public final static SLogicFieldInfo CONTENT = new SLogicFieldInfo("CONTENT");

   // 字段备注的定义。
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
   public final static String FIELDS = "OUID,OVLD,GUID,CODE,PASSPORT,PASSPORT_LOGIN_DATE,PASSWORD,PASSWORD_UPDATE_DATE,STATUS_CD,ROLE_CD,ROLE_ID,DEVELOP_CD,TEACHER_CD,TEACHER_ID,ALIAS,LABEL,LABEL_SECURITY_CD,GENDER_CD,GENDER_SECURITY_CD,BIRTHDAY,BIRTHDAY_SECURITY_CD,ICON_URL,CONTACT_PHONE,CONTACT_PHONE_SECURITY_CD,CONTACT_PHONE_VERIFY_CD,CONTACT_EMAIL,CONTACT_EMAIL_SECURITY_CD,CONTACT_EMAIL_VERIFY_CD,CONTACT_QQ,CONTACT_QQ_SECURITY_CD,CONTACT_MSN,CONTACT_MSN_SECURITY_CD,SCHOOL_CD,SCHOOL_ID,SCHOOL_LABEL,SCHOOL_ENTER_YEAR,SCHOOL_PART_ID,SCHOOL_PART_LABEL,SCHOOL_CLASS_ID,SCHOOL_CLASS_LABEL,COMPANY_ID,COMPANY_LABEL,HOME_PROVINCE_ID,HOME_PHONE,HOME_ADDRESS,SCORE_LEVEL,SCORE_BEAN,SCORE_BEAN_EXPERIENCE,SCORE_POINT,SCORE_POINT_EXPERIENCE,SCORE_GOLD,SCORE_GOLD_EXPERIENCE,DESCRIPTION,CONTENT,NOTE,CREATE_USER_ID,CREATE_DATE,UPDATE_USER_ID,UPDATE_DATE";

   //============================================================
   // <T>构造人员用户信息逻辑单元。</T>
   //============================================================
   public FDataPersonUserLogic(){
      _name = TABLE.name();
      _classUnit = FDataPersonUserUnit.class;
   }

   //============================================================
   // <T>构造人员用户信息逻辑单元。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FDataPersonUserLogic(ILogicContext context){
      super(context);
      _name = TABLE.name();
      _classUnit = FDataPersonUserUnit.class;
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
            unit = (T)(new FDataPersonUserUnit());
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
   public FDataPersonUserUnit search(CharSequence whereSql){
      return search(null, FDataPersonUserUnit.class, whereSql);
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
   public FLogicDataset<FDataPersonUserUnit> fetch(int pageSize,
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
   public FLogicDataset<FDataPersonUserUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FDataPersonUserUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FDataPersonUserUnit> fetch(CharSequence fields,
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
   public FLogicDataset<FDataPersonUserUnit> fetch(CharSequence fields,
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
   public FLogicDataset<FDataPersonUserUnit> fetchSql(CharSequence code,
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
         result = (FLogicDataset<T>)(new FLogicDataset<FDataPersonUserUnit>(FDataPersonUserUnit.class, _logicContext));
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
   public FLogicDataset<FDataPersonUserUnit> fetchAll(){
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
   public FDataPersonUserUnit doPrepare(){
      FDataPersonUserUnit unit = new FDataPersonUserUnit();
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
      FDataPersonUserUnit unit = (FDataPersonUserUnit)logicUnit;
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
      FDataPersonUserUnit unit = (FDataPersonUserUnit)logicUnit;
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
      cmd.append(",`CODE`");
      cmd.append(",`PASSPORT`");
      cmd.append(",`PASSPORT_LOGIN_DATE`");
      cmd.append(",`PASSWORD`");
      cmd.append(",`PASSWORD_UPDATE_DATE`");
      cmd.append(",`STATUS_CD`");
      cmd.append(",`ROLE_CD`");
      cmd.append(",`ROLE_ID`");
      cmd.append(",`DEVELOP_CD`");
      cmd.append(",`TEACHER_CD`");
      cmd.append(",`TEACHER_ID`");
      cmd.append(",`ALIAS`");
      cmd.append(",`LABEL`");
      cmd.append(",`LABEL_SECURITY_CD`");
      cmd.append(",`GENDER_CD`");
      cmd.append(",`GENDER_SECURITY_CD`");
      cmd.append(",`BIRTHDAY`");
      cmd.append(",`BIRTHDAY_SECURITY_CD`");
      cmd.append(",`ICON_URL`");
      cmd.append(",`CONTACT_PHONE`");
      cmd.append(",`CONTACT_PHONE_SECURITY_CD`");
      cmd.append(",`CONTACT_PHONE_VERIFY_CD`");
      cmd.append(",`CONTACT_EMAIL`");
      cmd.append(",`CONTACT_EMAIL_SECURITY_CD`");
      cmd.append(",`CONTACT_EMAIL_VERIFY_CD`");
      cmd.append(",`CONTACT_QQ`");
      cmd.append(",`CONTACT_QQ_SECURITY_CD`");
      cmd.append(",`CONTACT_MSN`");
      cmd.append(",`CONTACT_MSN_SECURITY_CD`");
      cmd.append(",`SCHOOL_CD`");
      cmd.append(",`SCHOOL_ID`");
      cmd.append(",`SCHOOL_LABEL`");
      cmd.append(",`SCHOOL_ENTER_YEAR`");
      cmd.append(",`SCHOOL_PART_ID`");
      cmd.append(",`SCHOOL_PART_LABEL`");
      cmd.append(",`SCHOOL_CLASS_ID`");
      cmd.append(",`SCHOOL_CLASS_LABEL`");
      cmd.append(",`COMPANY_ID`");
      cmd.append(",`COMPANY_LABEL`");
      cmd.append(",`HOME_PROVINCE_ID`");
      cmd.append(",`HOME_PHONE`");
      cmd.append(",`HOME_ADDRESS`");
      cmd.append(",`SCORE_LEVEL`");
      cmd.append(",`SCORE_BEAN`");
      cmd.append(",`SCORE_BEAN_EXPERIENCE`");
      cmd.append(",`SCORE_POINT`");
      cmd.append(",`SCORE_POINT_EXPERIENCE`");
      cmd.append(",`SCORE_GOLD`");
      cmd.append(",`SCORE_GOLD_EXPERIENCE`");
      cmd.append(",`DESCRIPTION`");
      cmd.append(",`CONTENT`");
      cmd.append(",`NOTE`");
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
      String code = unit.code();
      if(RString.isEmpty(code)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(code));
         cmd.append('\'');
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
      TDateTime passportLoginDate = unit.passportLoginDate();
      if(passportLoginDate == null){
         cmd.append("NULL");
      }else if(passportLoginDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(passportLoginDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      String password = unit.password();
      if(RString.isEmpty(password)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(password));
         cmd.append('\'');
      }
      cmd.append(',');
      TDateTime passwordUpdateDate = unit.passwordUpdateDate();
      if(passwordUpdateDate == null){
         cmd.append("NULL");
      }else if(passwordUpdateDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(passwordUpdateDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      cmd.append(unit.statusCd());
      cmd.append(',');
      cmd.append(unit.roleCd());
      cmd.append(',');
      long roleId = unit.roleId();
      if(roleId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(roleId);
      }
      cmd.append(',');
      cmd.append(unit.developCd());
      cmd.append(',');
      cmd.append(unit.teacherCd());
      cmd.append(',');
      long teacherId = unit.teacherId();
      if(teacherId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(teacherId);
      }
      cmd.append(',');
      String alias = unit.alias();
      if(RString.isEmpty(alias)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(alias));
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
      cmd.append(unit.labelSecurityCd());
      cmd.append(',');
      cmd.append(unit.genderCd());
      cmd.append(',');
      cmd.append(unit.genderSecurityCd());
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
      cmd.append(unit.birthdaySecurityCd());
      cmd.append(',');
      String iconUrl = unit.iconUrl();
      if(RString.isEmpty(iconUrl)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(iconUrl));
         cmd.append('\'');
      }
      cmd.append(',');
      String contactPhone = unit.contactPhone();
      if(RString.isEmpty(contactPhone)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(contactPhone));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.contactPhoneSecurityCd());
      cmd.append(',');
      cmd.append(unit.contactPhoneVerifyCd());
      cmd.append(',');
      String contactEmail = unit.contactEmail();
      if(RString.isEmpty(contactEmail)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(contactEmail));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.contactEmailSecurityCd());
      cmd.append(',');
      cmd.append(unit.contactEmailVerifyCd());
      cmd.append(',');
      String contactQq = unit.contactQq();
      if(RString.isEmpty(contactQq)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(contactQq));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.contactQqSecurityCd());
      cmd.append(',');
      String contactMsn = unit.contactMsn();
      if(RString.isEmpty(contactMsn)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(contactMsn));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.contactMsnSecurityCd());
      cmd.append(',');
      cmd.append(unit.schoolCd());
      cmd.append(',');
      long schoolId = unit.schoolId();
      if(schoolId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(schoolId);
      }
      cmd.append(',');
      String schoolLabel = unit.schoolLabel();
      if(RString.isEmpty(schoolLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(schoolLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.schoolEnterYear());
      cmd.append(',');
      long schoolPartId = unit.schoolPartId();
      if(schoolPartId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(schoolPartId);
      }
      cmd.append(',');
      String schoolPartLabel = unit.schoolPartLabel();
      if(RString.isEmpty(schoolPartLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(schoolPartLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      long schoolClassId = unit.schoolClassId();
      if(schoolClassId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(schoolClassId);
      }
      cmd.append(',');
      String schoolClassLabel = unit.schoolClassLabel();
      if(RString.isEmpty(schoolClassLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(schoolClassLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      long companyId = unit.companyId();
      if(companyId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(companyId);
      }
      cmd.append(',');
      String companyLabel = unit.companyLabel();
      if(RString.isEmpty(companyLabel)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(companyLabel));
         cmd.append('\'');
      }
      cmd.append(',');
      long homeProvinceId = unit.homeProvinceId();
      if(homeProvinceId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(homeProvinceId);
      }
      cmd.append(',');
      String homePhone = unit.homePhone();
      if(RString.isEmpty(homePhone)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(homePhone));
         cmd.append('\'');
      }
      cmd.append(',');
      String homeAddress = unit.homeAddress();
      if(RString.isEmpty(homeAddress)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(homeAddress));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.scoreLevel());
      cmd.append(',');
      cmd.append(unit.scoreBean());
      cmd.append(',');
      cmd.append(unit.scoreBeanExperience());
      cmd.append(',');
      cmd.append(unit.scorePoint());
      cmd.append(',');
      cmd.append(unit.scorePointExperience());
      cmd.append(',');
      cmd.append(unit.scoreGold());
      cmd.append(',');
      cmd.append(unit.scoreGoldExperience());
      cmd.append(',');
      String description = unit.description();
      if(RString.isEmpty(description)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(description));
         cmd.append('\'');
      }
      cmd.append(',');
      String content = unit.content();
      if(RString.isEmpty(content)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(content));
         cmd.append('\'');
      }
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
      FDataPersonUserUnit unit = (FDataPersonUserUnit)logicUnit;
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
      FDataPersonUserUnit unit = (FDataPersonUserUnit)logicUnit;
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
      if(unit.isPassportLoginDateChanged()){
         cmd.append(",`PASSPORT_LOGIN_DATE`=");
         TDateTime passportLoginDate = unit.passportLoginDate();
         if(passportLoginDate == null){
            cmd.append("NULL");
         }else if(passportLoginDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(passportLoginDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isPasswordChanged()){
         cmd.append(",`PASSWORD`=");
         String password = unit.password();
         if(RString.isEmpty(password)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(password));
            cmd.append('\'');
         }
      }
      if(unit.isPasswordUpdateDateChanged()){
         cmd.append(",`PASSWORD_UPDATE_DATE`=");
         TDateTime passwordUpdateDate = unit.passwordUpdateDate();
         if(passwordUpdateDate == null){
            cmd.append("NULL");
         }else if(passwordUpdateDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(passwordUpdateDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isStatusCdChanged()){
         cmd.append(",`STATUS_CD`=");
         cmd.append(unit.statusCd());
      }
      if(unit.isRoleCdChanged()){
         cmd.append(",`ROLE_CD`=");
         cmd.append(unit.roleCd());
      }
      if(unit.isRoleIdChanged()){
         cmd.append(",`ROLE_ID`=");
         long roleId = unit.roleId();
         if(roleId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(roleId);
         }
      }
      if(unit.isDevelopCdChanged()){
         cmd.append(",`DEVELOP_CD`=");
         cmd.append(unit.developCd());
      }
      if(unit.isTeacherCdChanged()){
         cmd.append(",`TEACHER_CD`=");
         cmd.append(unit.teacherCd());
      }
      if(unit.isTeacherIdChanged()){
         cmd.append(",`TEACHER_ID`=");
         long teacherId = unit.teacherId();
         if(teacherId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(teacherId);
         }
      }
      if(unit.isAliasChanged()){
         cmd.append(",`ALIAS`=");
         String alias = unit.alias();
         if(RString.isEmpty(alias)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(alias));
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
      if(unit.isLabelSecurityCdChanged()){
         cmd.append(",`LABEL_SECURITY_CD`=");
         cmd.append(unit.labelSecurityCd());
      }
      if(unit.isGenderCdChanged()){
         cmd.append(",`GENDER_CD`=");
         cmd.append(unit.genderCd());
      }
      if(unit.isGenderSecurityCdChanged()){
         cmd.append(",`GENDER_SECURITY_CD`=");
         cmd.append(unit.genderSecurityCd());
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
      if(unit.isBirthdaySecurityCdChanged()){
         cmd.append(",`BIRTHDAY_SECURITY_CD`=");
         cmd.append(unit.birthdaySecurityCd());
      }
      if(unit.isIconUrlChanged()){
         cmd.append(",`ICON_URL`=");
         String iconUrl = unit.iconUrl();
         if(RString.isEmpty(iconUrl)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(iconUrl));
            cmd.append('\'');
         }
      }
      if(unit.isContactPhoneChanged()){
         cmd.append(",`CONTACT_PHONE`=");
         String contactPhone = unit.contactPhone();
         if(RString.isEmpty(contactPhone)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(contactPhone));
            cmd.append('\'');
         }
      }
      if(unit.isContactPhoneSecurityCdChanged()){
         cmd.append(",`CONTACT_PHONE_SECURITY_CD`=");
         cmd.append(unit.contactPhoneSecurityCd());
      }
      if(unit.isContactPhoneVerifyCdChanged()){
         cmd.append(",`CONTACT_PHONE_VERIFY_CD`=");
         cmd.append(unit.contactPhoneVerifyCd());
      }
      if(unit.isContactEmailChanged()){
         cmd.append(",`CONTACT_EMAIL`=");
         String contactEmail = unit.contactEmail();
         if(RString.isEmpty(contactEmail)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(contactEmail));
            cmd.append('\'');
         }
      }
      if(unit.isContactEmailSecurityCdChanged()){
         cmd.append(",`CONTACT_EMAIL_SECURITY_CD`=");
         cmd.append(unit.contactEmailSecurityCd());
      }
      if(unit.isContactEmailVerifyCdChanged()){
         cmd.append(",`CONTACT_EMAIL_VERIFY_CD`=");
         cmd.append(unit.contactEmailVerifyCd());
      }
      if(unit.isContactQqChanged()){
         cmd.append(",`CONTACT_QQ`=");
         String contactQq = unit.contactQq();
         if(RString.isEmpty(contactQq)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(contactQq));
            cmd.append('\'');
         }
      }
      if(unit.isContactQqSecurityCdChanged()){
         cmd.append(",`CONTACT_QQ_SECURITY_CD`=");
         cmd.append(unit.contactQqSecurityCd());
      }
      if(unit.isContactMsnChanged()){
         cmd.append(",`CONTACT_MSN`=");
         String contactMsn = unit.contactMsn();
         if(RString.isEmpty(contactMsn)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(contactMsn));
            cmd.append('\'');
         }
      }
      if(unit.isContactMsnSecurityCdChanged()){
         cmd.append(",`CONTACT_MSN_SECURITY_CD`=");
         cmd.append(unit.contactMsnSecurityCd());
      }
      if(unit.isSchoolCdChanged()){
         cmd.append(",`SCHOOL_CD`=");
         cmd.append(unit.schoolCd());
      }
      if(unit.isSchoolIdChanged()){
         cmd.append(",`SCHOOL_ID`=");
         long schoolId = unit.schoolId();
         if(schoolId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(schoolId);
         }
      }
      if(unit.isSchoolLabelChanged()){
         cmd.append(",`SCHOOL_LABEL`=");
         String schoolLabel = unit.schoolLabel();
         if(RString.isEmpty(schoolLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(schoolLabel));
            cmd.append('\'');
         }
      }
      if(unit.isSchoolEnterYearChanged()){
         cmd.append(",`SCHOOL_ENTER_YEAR`=");
         cmd.append(unit.schoolEnterYear());
      }
      if(unit.isSchoolPartIdChanged()){
         cmd.append(",`SCHOOL_PART_ID`=");
         long schoolPartId = unit.schoolPartId();
         if(schoolPartId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(schoolPartId);
         }
      }
      if(unit.isSchoolPartLabelChanged()){
         cmd.append(",`SCHOOL_PART_LABEL`=");
         String schoolPartLabel = unit.schoolPartLabel();
         if(RString.isEmpty(schoolPartLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(schoolPartLabel));
            cmd.append('\'');
         }
      }
      if(unit.isSchoolClassIdChanged()){
         cmd.append(",`SCHOOL_CLASS_ID`=");
         long schoolClassId = unit.schoolClassId();
         if(schoolClassId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(schoolClassId);
         }
      }
      if(unit.isSchoolClassLabelChanged()){
         cmd.append(",`SCHOOL_CLASS_LABEL`=");
         String schoolClassLabel = unit.schoolClassLabel();
         if(RString.isEmpty(schoolClassLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(schoolClassLabel));
            cmd.append('\'');
         }
      }
      if(unit.isCompanyIdChanged()){
         cmd.append(",`COMPANY_ID`=");
         long companyId = unit.companyId();
         if(companyId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(companyId);
         }
      }
      if(unit.isCompanyLabelChanged()){
         cmd.append(",`COMPANY_LABEL`=");
         String companyLabel = unit.companyLabel();
         if(RString.isEmpty(companyLabel)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(companyLabel));
            cmd.append('\'');
         }
      }
      if(unit.isHomeProvinceIdChanged()){
         cmd.append(",`HOME_PROVINCE_ID`=");
         long homeProvinceId = unit.homeProvinceId();
         if(homeProvinceId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(homeProvinceId);
         }
      }
      if(unit.isHomePhoneChanged()){
         cmd.append(",`HOME_PHONE`=");
         String homePhone = unit.homePhone();
         if(RString.isEmpty(homePhone)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(homePhone));
            cmd.append('\'');
         }
      }
      if(unit.isHomeAddressChanged()){
         cmd.append(",`HOME_ADDRESS`=");
         String homeAddress = unit.homeAddress();
         if(RString.isEmpty(homeAddress)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(homeAddress));
            cmd.append('\'');
         }
      }
      if(unit.isScoreLevelChanged()){
         cmd.append(",`SCORE_LEVEL`=");
         cmd.append(unit.scoreLevel());
      }
      if(unit.isScoreBeanChanged()){
         cmd.append(",`SCORE_BEAN`=");
         cmd.append(unit.scoreBean());
      }
      if(unit.isScoreBeanExperienceChanged()){
         cmd.append(",`SCORE_BEAN_EXPERIENCE`=");
         cmd.append(unit.scoreBeanExperience());
      }
      if(unit.isScorePointChanged()){
         cmd.append(",`SCORE_POINT`=");
         cmd.append(unit.scorePoint());
      }
      if(unit.isScorePointExperienceChanged()){
         cmd.append(",`SCORE_POINT_EXPERIENCE`=");
         cmd.append(unit.scorePointExperience());
      }
      if(unit.isScoreGoldChanged()){
         cmd.append(",`SCORE_GOLD`=");
         cmd.append(unit.scoreGold());
      }
      if(unit.isScoreGoldExperienceChanged()){
         cmd.append(",`SCORE_GOLD_EXPERIENCE`=");
         cmd.append(unit.scoreGoldExperience());
      }
      if(unit.isDescriptionChanged()){
         cmd.append(",`DESCRIPTION`=");
         String description = unit.description();
         if(RString.isEmpty(description)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(description));
            cmd.append('\'');
         }
      }
      if(unit.isContentChanged()){
         cmd.append(",`CONTENT`=");
         String content = unit.content();
         if(RString.isEmpty(content)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(content));
            cmd.append('\'');
         }
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
      FDataPersonUserUnit unit = (FDataPersonUserUnit)logicUnit;
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

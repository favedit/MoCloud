package com.cyou.gccloud.service.data.data;

import org.mo.com.lang.*;
import org.mo.com.collections.*;
import org.mo.com.data.*;
import org.mo.data.logic.*;

//============================================================
// <T>帐号信息逻辑。</T>
//============================================================
public class FDataPersonUserLogic extends FLogicDataset
{
   // 帐号信息的定义。
   public final static FLogicTable Table = new FLogicTable("DT_PSN_USER");

   // 字段对象标识的定义。
   public final static FLogicField FieldOuid = new FLogicField("OUID");

   // 字段有效性的定义。
   public final static FLogicField FieldOvld = new FLogicField("OVLD");

   // 字段帐号的定义。
   public final static FLogicField FieldPassport = new FLogicField("PASSPORT");

   // 字段密码的定义。
   public final static FLogicField FieldPassword = new FLogicField("PASSWORD");

   // 字段名称的定义。
   public final static FLogicField FieldLabel = new FLogicField("LABEL");

   // 字段生日的定义。
   public final static FLogicField FieldBirthday = new FLogicField("BIRTHDAY");

   // 字段联系电话号码的定义。
   public final static FLogicField FieldContactPhone = new FLogicField("CONTACT_PHONE");

   // 字段联系邮箱地址的定义。
   public final static FLogicField FieldContactEmail = new FLogicField("CONTACT_EMAIL");

   // 字段联系QQ号码的定义。
   public final static FLogicField FieldContactQq = new FLogicField("CONTACT_QQ");

   // 字段联系MSN号码的定义。
   public final static FLogicField FieldContactMsn = new FLogicField("CONTACT_MSN");

   // 字段创建用户标识的定义。
   public final static FLogicField FieldCreateUserId = new FLogicField("CREATE_USER_ID");

   // 字段创建日期的定义。
   public final static FLogicField FieldCreateDate = new FLogicField("CREATE_DATE");

   // 字段更新者标识的定义。
   public final static FLogicField FieldUpdateUserId = new FLogicField("UPDATE_USER_ID");

   // 字段更新时间的定义。
   public final static FLogicField FieldUpdateDate = new FLogicField("UPDATE_DATE");

   //============================================================
   // <T>构造帐号信息逻辑单元。</T>
   //============================================================
   public FDataPersonUserLogic(){
   }

   //============================================================
   // <T>构造帐号信息逻辑单元。</T>
   //
   // @param connect 数据链接
   //============================================================
   public FDataPersonUserLogic(ISqlConnect connect){
      _connection = connect.activeConnection();
   }

   //============================================================
   // <T>构造帐号信息逻辑单元。</T>
   //
   // @param connection 数据链接
   //============================================================
   public FDataPersonUserLogic(ISqlConnection connection){
      _connection = connection;
   }

   //============================================================
   // <T>根据编号获得一个数据单元。</T>
   //
   // @param recordId 记录编号
   // @return 数据单元
   //============================================================
   public FDataPersonUserUnit find(long recordId){
      // 检查记录编号
      if(0 == recordId){
         return null;
      }
      // 生成命令
      FSql sql = new FSql("SELECT * FROM ");
      sql.append(Table.name());
      sql.append(" WHERE OUID=");
      sql.append(recordId);
      // 执行命令
      FRow row = _connection.find(sql.toString());
      if(null == row){
         return null;
      }
      // 获得数据
      FDataPersonUserUnit unit = new FDataPersonUserUnit();
      unit.load(row);
      return unit;
   }

   //============================================================
   // <T>根据条件获得一个数据单元。</T>
   //
   // @param whereSql 条件
   // @return 数据单元
   //============================================================
   public FDataPersonUserUnit serach(String whereSql){
      // 生成命令
      FSql sql = new FSql("SELECT * FROM ");
      sql.append(Table.name());
      sql.append(" WHERE ");
      sql.append(whereSql);
      // 执行命令
      FRow row = _connection.find(sql.toString());
      // 获得数据
      if(null == row){
         return null;
      }
      FDataPersonUserUnit unit = new FDataPersonUserUnit();
      unit.load(row);
      return unit;
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @return 数据单元集合
   //============================================================
   public FDataPersonUserUnit[] fetch(String whereSql){
      return fetch(whereSql, null, 0);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @return 数据单元集合
   //============================================================
   public FDataPersonUserUnit[] fetch(String whereSql, String orderSql){
      return fetch(whereSql, orderSql, 0);
   }

   //============================================================
   // <T>根据条件获得数据单元集合。</T>
   //
   // @param whereSql 条件命令
   // @param orderSql 排序命令
   // @param limitCount 限制条数
   // @return 数据单元集合
   //============================================================
   public FDataPersonUserUnit[] fetch(String whereSql, String orderSql, int limitCount){
      // 生成命令
      FSql sql = new FSql("SELECT * FROM ");
      sql.append(Table.name());
      if(!RString.isEmpty(whereSql)){
         sql.append(" WHERE ");
         sql.append(whereSql);
      }
      if(!RString.isEmpty(orderSql)){
         sql.append(" ORDER BY ");
         sql.append(orderSql);
      }
      if(limitCount > 0){
         sql.append(" LIMIT ");
         sql.append(limitCount);
      }
      // 执行命令
      FDataset dataset = _connection.fetchDataset(sql.toString());
      int count = dataset.count();
      // 获得数据
      FDataPersonUserUnit[] units = new FDataPersonUserUnit[count];
      for(int n = 0; n < count; n++){
         FDataPersonUserUnit unit = new FDataPersonUserUnit();
         unit.load(dataset.get(n));
         units[n] = unit;
      }
      return units;
   }

   //============================================================
   // <T>根据条件获得全部数据单元集合。</T>
   //
   // @return 数据单元集合
   //============================================================
   public FDataPersonUserUnit[] fetchAll(){
      return fetch(null);
   }

   //============================================================
   // <T>插入一个数据单元。</T>
   //
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   public boolean doInsert(FDataPersonUserUnit unit){
      // 生成命令
      FSql sql = new FSql("INSERT INTO ");
      sql.append(Table.name());
      sql.append("(");
      sql.append("`OVLD`");
      sql.append(",`PASSPORT`");
      sql.append(",`PASSWORD`");
      sql.append(",`LABEL`");
      sql.append(",`BIRTHDAY`");
      sql.append(",`CONTACT_PHONE`");
      sql.append(",`CONTACT_EMAIL`");
      sql.append(",`CONTACT_QQ`");
      sql.append(",`CONTACT_MSN`");
      sql.append(",`CREATE_USER_ID`");
      sql.append(",`CREATE_DATE`");
      sql.append(",`UPDATE_USER_ID`");
      sql.append(",`UPDATE_DATE`");
      sql.append(") VALUES(");
      sql.append(unit.ovld());
      sql.append(',');
      if(RString.isEmpty(unit.passport())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.passport()));
         sql.append('\'');
      }
      sql.append(',');
      if(RString.isEmpty(unit.password())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.password()));
         sql.append('\'');
      }
      sql.append(',');
      if(RString.isEmpty(unit.label())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.label()));
         sql.append('\'');
      }
      sql.append(',');
      if(unit.birthday().isEmpty()){
         sql.append("NULL");
      }else{
         sql.append("STR_TO_DATE('");
         sql.append(unit.birthday().format());
         sql.append("','%Y%m%d%H%i%s')");
      }
      sql.append(',');
      if(RString.isEmpty(unit.contactPhone())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.contactPhone()));
         sql.append('\'');
      }
      sql.append(',');
      if(RString.isEmpty(unit.contactEmail())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.contactEmail()));
         sql.append('\'');
      }
      sql.append(',');
      if(RString.isEmpty(unit.contactQq())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.contactQq()));
         sql.append('\'');
      }
      sql.append(',');
      if(RString.isEmpty(unit.contactMsn())){
         sql.append("NULL");
      }else{
         sql.append('\'');
         sql.append(_connection.formatValue(unit.contactMsn()));
         sql.append('\'');
      }
      sql.append(",0,NOW(),0,NOW())");
      // 执行命令
      long recordId = _connection.executeInsertSql(sql.toString());
      unit.setOuid(recordId);
      return true;
   }

   //============================================================
   // <T>更新一个数据单元。</T>
   //
   // @param unit 数据单元
   // @param recordId 记录编号
   // @return 处理结果
   //============================================================
   public boolean doUpdate(FDataPersonUserUnit unit, long recordId){
      // 检查记录编号
      if(0 == recordId){
         throw new FFatalError("Record id is empty. (record_id={1})", recordId);
      }
      // 生成命令
      FSql sql = new FSql("UPDATE ");
      sql.append(Table.name());
      sql.append(" SET OVLD=");
      sql.append(unit.ovld());
      if(unit.isPassportChanged()){
         sql.append(",`PASSPORT`=");
         if(RString.isEmpty(unit.passport())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.passport()));
            sql.append("'");
         }
      }
      if(unit.isPasswordChanged()){
         sql.append(",`PASSWORD`=");
         if(RString.isEmpty(unit.password())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.password()));
            sql.append("'");
         }
      }
      if(unit.isLabelChanged()){
         sql.append(",`LABEL`=");
         if(RString.isEmpty(unit.label())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.label()));
            sql.append("'");
         }
      }
      if(unit.isBirthdayChanged()){
         sql.append(",`BIRTHDAY`=");
         if(unit.birthday().isEmpty()){
            sql.append("NULL");
         }else{
            sql.append("STR_TO_DATE('");
            sql.append(unit.birthday().format());
            sql.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isContactPhoneChanged()){
         sql.append(",`CONTACT_PHONE`=");
         if(RString.isEmpty(unit.contactPhone())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.contactPhone()));
            sql.append("'");
         }
      }
      if(unit.isContactEmailChanged()){
         sql.append(",`CONTACT_EMAIL`=");
         if(RString.isEmpty(unit.contactEmail())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.contactEmail()));
            sql.append("'");
         }
      }
      if(unit.isContactQqChanged()){
         sql.append(",`CONTACT_QQ`=");
         if(RString.isEmpty(unit.contactQq())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.contactQq()));
            sql.append("'");
         }
      }
      if(unit.isContactMsnChanged()){
         sql.append(",`CONTACT_MSN`=");
         if(RString.isEmpty(unit.contactMsn())){
            sql.append("NULL");
         }else{
            sql.append("'");
            sql.append(_connection.formatValue(unit.contactMsn()));
            sql.append("'");
         }
      }
      if(unit.isCreateUserIdChanged()){
         sql.append(",`CREATE_USER_ID`=");
         sql.append(unit.createUserId());
      }
      sql.append(",UPDATE_USER_ID=0,UPDATE_DATE=NOW()");
      sql.append(" WHERE OUID=");
      sql.append(recordId);
      // 执行命令
      return _connection.executeSql(sql.toString());
   }

   //============================================================
   // <T>删除一个数据单元。</T>
   //
   // @param recordId 记录编号
   // @return 处理结果
   //============================================================
   public boolean doDelete(long recordId){
      // 生成命令
      FSql sql = new FSql("DELETE FROM ");
      sql.append(Table.name());
      sql.append("WHERE OUID=");
      sql.append(recordId);
      // 执行命令
      return _connection.executeSql(sql.toString());
   }
}

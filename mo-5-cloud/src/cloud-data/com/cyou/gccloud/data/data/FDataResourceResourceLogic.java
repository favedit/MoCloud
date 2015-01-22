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
// <T>资源信息表逻辑。</T>
//============================================================
@ASourceMachine
public class FDataResourceResourceLogic
      extends FLogicTable
{
   // 资源信息表的定义。
   public final static SLogicConnectionInfo CONNECTION = new SLogicConnectionInfo("data");

   // 资源信息表的定义。
   public final static SLogicTableInfo TABLE = new SLogicTableInfo("data.resource.resource", "DT_RES_RESOURCE");

   // 字段对象标识的定义。
   public final static SLogicFieldInfo OUID = new SLogicFieldInfo("OUID");

   // 字段有效性的定义。
   public final static SLogicFieldInfo OVLD = new SLogicFieldInfo("OVLD");

   // 字段对象唯一标识的定义。
   public final static SLogicFieldInfo GUID = new SLogicFieldInfo("GUID");

   // 字段代码的定义。
   public final static SLogicFieldInfo CODE = new SLogicFieldInfo("CODE");

   // 字段名称的定义。
   public final static SLogicFieldInfo NAME = new SLogicFieldInfo("NAME");

   // 字段名称的定义。
   public final static SLogicFieldInfo LABEL = new SLogicFieldInfo("LABEL");

   // 字段模块编号的定义。
   public final static SLogicFieldInfo MODULE_ID = new SLogicFieldInfo("MODULE_ID");

   // 字段频道编号的定义。
   public final static SLogicFieldInfo CHANNEL_ID = new SLogicFieldInfo("CHANNEL_ID");

   // 字段类型编号的定义。
   public final static SLogicFieldInfo TYPE_ID = new SLogicFieldInfo("TYPE_ID");

   // 字段学校编号的定义。
   public final static SLogicFieldInfo SCHOOL_ID = new SLogicFieldInfo("SCHOOL_ID");

   // 字段提供商编号的定义。
   public final static SLogicFieldInfo VENDOR_ID = new SLogicFieldInfo("VENDOR_ID");

   // 字段老师编号的定义。
   public final static SLogicFieldInfo TEACHER_ID = new SLogicFieldInfo("TEACHER_ID");

   // 字段用户编号的定义。
   public final static SLogicFieldInfo USER_ID = new SLogicFieldInfo("USER_ID");

   // 字段活动编号的定义。
   public final static SLogicFieldInfo ACTIVITY_ID = new SLogicFieldInfo("ACTIVITY_ID");

   // 字段状态类型的定义。
   public final static SLogicFieldInfo STATUS_CD = new SLogicFieldInfo("STATUS_CD");

   // 字段资源类型的定义。
   public final static SLogicFieldInfo RESOURCE_CD = new SLogicFieldInfo("RESOURCE_CD");

   // 字段资源部署状态的定义。
   public final static SLogicFieldInfo RESOURCE_DEPLOY_CD = new SLogicFieldInfo("RESOURCE_DEPLOY_CD");

   // 字段显示类型的定义。
   public final static SLogicFieldInfo DISPLAY_CD = new SLogicFieldInfo("DISPLAY_CD");

   // 字段排序值的定义。
   public final static SLogicFieldInfo DISPLAY_ORDER = new SLogicFieldInfo("DISPLAY_ORDER");

   // 字段审核日期的定义。
   public final static SLogicFieldInfo EXAMINE_DATE = new SLogicFieldInfo("EXAMINE_DATE");

   // 字段审核结果类型的定义。
   public final static SLogicFieldInfo EXAMINE_RESULT_CD = new SLogicFieldInfo("EXAMINE_RESULT_CD");

   // 字段推荐类型的定义。
   public final static SLogicFieldInfo RECOMMEND_CD = new SLogicFieldInfo("RECOMMEND_CD");

   // 字段图标地址的定义。
   public final static SLogicFieldInfo ICON_URL = new SLogicFieldInfo("ICON_URL");

   // 字段外链地址的定义。
   public final static SLogicFieldInfo LINK_URL = new SLogicFieldInfo("LINK_URL");

   // 字段版本编号的定义。
   public final static SLogicFieldInfo VERSION_NUMBER = new SLogicFieldInfo("VERSION_NUMBER");

   // 字段版本代码的定义。
   public final static SLogicFieldInfo VERSION_CODE = new SLogicFieldInfo("VERSION_CODE");

   // 字段关键字的定义。
   public final static SLogicFieldInfo KEYWORDS = new SLogicFieldInfo("KEYWORDS");

   // 字段点数(豆豆)的定义。
   public final static SLogicFieldInfo SCORE_BEAN = new SLogicFieldInfo("SCORE_BEAN");

   // 字段点数(豆币)的定义。
   public final static SLogicFieldInfo SCORE_POINT = new SLogicFieldInfo("SCORE_POINT");

   // 字段点数(金币)的定义。
   public final static SLogicFieldInfo SCORE_GOLD = new SLogicFieldInfo("SCORE_GOLD");

   // 字段播放次数的定义。
   public final static SLogicFieldInfo PLAY_COUNT = new SLogicFieldInfo("PLAY_COUNT");

   // 字段点攒次数的定义。
   public final static SLogicFieldInfo PRAISE_COUNT = new SLogicFieldInfo("PRAISE_COUNT");

   // 字段关注(收藏)次数的定义。
   public final static SLogicFieldInfo ATTENTION_COUNT = new SLogicFieldInfo("ATTENTION_COUNT");

   // 字段分享次数的定义。
   public final static SLogicFieldInfo SHARE_COUNT = new SLogicFieldInfo("SHARE_COUNT");

   // 字段浏览次数的定义。
   public final static SLogicFieldInfo VIEW_COUNT = new SLogicFieldInfo("VIEW_COUNT");

   // 字段详细描述的定义。
   public final static SLogicFieldInfo DESCRIPTION = new SLogicFieldInfo("DESCRIPTION");

   // 字段内容的定义。
   public final static SLogicFieldInfo CONTENT = new SLogicFieldInfo("CONTENT");

   // 字段注释内容的定义。
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
   public final static String FIELDS = "OUID,OVLD,GUID,CODE,NAME,LABEL,MODULE_ID,CHANNEL_ID,TYPE_ID,SCHOOL_ID,VENDOR_ID,TEACHER_ID,USER_ID,ACTIVITY_ID,STATUS_CD,RESOURCE_CD,RESOURCE_DEPLOY_CD,DISPLAY_CD,DISPLAY_ORDER,EXAMINE_DATE,EXAMINE_RESULT_CD,RECOMMEND_CD,ICON_URL,LINK_URL,VERSION_NUMBER,VERSION_CODE,KEYWORDS,SCORE_BEAN,SCORE_POINT,SCORE_GOLD,PLAY_COUNT,PRAISE_COUNT,ATTENTION_COUNT,SHARE_COUNT,VIEW_COUNT,DESCRIPTION,CONTENT,NOTE,CREATE_USER_ID,CREATE_DATE,UPDATE_USER_ID,UPDATE_DATE";

   //============================================================
   // <T>构造资源信息表逻辑单元。</T>
   //============================================================
   public FDataResourceResourceLogic(){
      _name = TABLE.name();
      _classUnit = FDataResourceResourceUnit.class;
   }

   //============================================================
   // <T>构造资源信息表逻辑单元。</T>
   //
   // @param context 逻辑环境
   //============================================================
   public FDataResourceResourceLogic(ILogicContext context){
      super(context);
      _name = TABLE.name();
      _classUnit = FDataResourceResourceUnit.class;
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
            unit = (T)(new FDataResourceResourceUnit());
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
   public FDataResourceResourceUnit search(CharSequence whereSql){
      return search(null, FDataResourceResourceUnit.class, whereSql);
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
   public FLogicDataset<FDataResourceResourceUnit> fetch(int pageSize,
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
   public FLogicDataset<FDataResourceResourceUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FDataResourceResourceUnit> fetch(CharSequence whereSql,
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
   public FLogicDataset<FDataResourceResourceUnit> fetch(CharSequence fields,
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
   public FLogicDataset<FDataResourceResourceUnit> fetch(CharSequence fields,
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
   public FLogicDataset<FDataResourceResourceUnit> fetchSql(CharSequence code,
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
         result = (FLogicDataset<T>)(new FLogicDataset<FDataResourceResourceUnit>(FDataResourceResourceUnit.class, _logicContext));
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
   public FLogicDataset<FDataResourceResourceUnit> fetchAll(){
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
   public FDataResourceResourceUnit doPrepare(){
      FDataResourceResourceUnit unit = new FDataResourceResourceUnit();
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
      FDataResourceResourceUnit unit = (FDataResourceResourceUnit)logicUnit;
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
      FDataResourceResourceUnit unit = (FDataResourceResourceUnit)logicUnit;
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
      cmd.append(",`NAME`");
      cmd.append(",`LABEL`");
      cmd.append(",`MODULE_ID`");
      cmd.append(",`CHANNEL_ID`");
      cmd.append(",`TYPE_ID`");
      cmd.append(",`SCHOOL_ID`");
      cmd.append(",`VENDOR_ID`");
      cmd.append(",`TEACHER_ID`");
      cmd.append(",`USER_ID`");
      cmd.append(",`ACTIVITY_ID`");
      cmd.append(",`STATUS_CD`");
      cmd.append(",`RESOURCE_CD`");
      cmd.append(",`RESOURCE_DEPLOY_CD`");
      cmd.append(",`DISPLAY_CD`");
      cmd.append(",`DISPLAY_ORDER`");
      cmd.append(",`EXAMINE_DATE`");
      cmd.append(",`EXAMINE_RESULT_CD`");
      cmd.append(",`RECOMMEND_CD`");
      cmd.append(",`ICON_URL`");
      cmd.append(",`LINK_URL`");
      cmd.append(",`VERSION_NUMBER`");
      cmd.append(",`VERSION_CODE`");
      cmd.append(",`KEYWORDS`");
      cmd.append(",`SCORE_BEAN`");
      cmd.append(",`SCORE_POINT`");
      cmd.append(",`SCORE_GOLD`");
      cmd.append(",`PLAY_COUNT`");
      cmd.append(",`PRAISE_COUNT`");
      cmd.append(",`ATTENTION_COUNT`");
      cmd.append(",`SHARE_COUNT`");
      cmd.append(",`VIEW_COUNT`");
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
      long moduleId = unit.moduleId();
      if(moduleId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(moduleId);
      }
      cmd.append(',');
      long channelId = unit.channelId();
      if(channelId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(channelId);
      }
      cmd.append(',');
      long typeId = unit.typeId();
      if(typeId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(typeId);
      }
      cmd.append(',');
      long schoolId = unit.schoolId();
      if(schoolId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(schoolId);
      }
      cmd.append(',');
      long vendorId = unit.vendorId();
      if(vendorId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(vendorId);
      }
      cmd.append(',');
      long teacherId = unit.teacherId();
      if(teacherId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(teacherId);
      }
      cmd.append(',');
      long userId = unit.userId();
      if(userId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(userId);
      }
      cmd.append(',');
      long activityId = unit.activityId();
      if(activityId == 0){
         cmd.append("NULL");
      }else{
         cmd.append(activityId);
      }
      cmd.append(',');
      cmd.append(unit.statusCd());
      cmd.append(',');
      cmd.append(unit.resourceCd());
      cmd.append(',');
      cmd.append(unit.resourceDeployCd());
      cmd.append(',');
      cmd.append(unit.displayCd());
      cmd.append(',');
      cmd.append(unit.displayOrder());
      cmd.append(',');
      TDateTime examineDate = unit.examineDate();
      if(examineDate == null){
         cmd.append("NULL");
      }else if(examineDate.isEmpty()){
         cmd.append("NULL");
      }else{
         cmd.append("STR_TO_DATE('");
         cmd.append(examineDate.format());
         cmd.append("','%Y%m%d%H%i%s')");
      }
      cmd.append(',');
      cmd.append(unit.examineResultCd());
      cmd.append(',');
      cmd.append(unit.recommendCd());
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
      String linkUrl = unit.linkUrl();
      if(RString.isEmpty(linkUrl)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(linkUrl));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.versionNumber());
      cmd.append(',');
      String versionCode = unit.versionCode();
      if(RString.isEmpty(versionCode)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(versionCode));
         cmd.append('\'');
      }
      cmd.append(',');
      String keywords = unit.keywords();
      if(RString.isEmpty(keywords)){
         cmd.append("NULL");
      }else{
         cmd.append('\'');
         cmd.append(RSql.formatValue(keywords));
         cmd.append('\'');
      }
      cmd.append(',');
      cmd.append(unit.scoreBean());
      cmd.append(',');
      cmd.append(unit.scorePoint());
      cmd.append(',');
      cmd.append(unit.scoreGold());
      cmd.append(',');
      cmd.append(unit.playCount());
      cmd.append(',');
      cmd.append(unit.praiseCount());
      cmd.append(',');
      cmd.append(unit.attentionCount());
      cmd.append(',');
      cmd.append(unit.shareCount());
      cmd.append(',');
      cmd.append(unit.viewCount());
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
      FDataResourceResourceUnit unit = (FDataResourceResourceUnit)logicUnit;
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
      FDataResourceResourceUnit unit = (FDataResourceResourceUnit)logicUnit;
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
      if(unit.isModuleIdChanged()){
         cmd.append(",`MODULE_ID`=");
         long moduleId = unit.moduleId();
         if(moduleId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(moduleId);
         }
      }
      if(unit.isChannelIdChanged()){
         cmd.append(",`CHANNEL_ID`=");
         long channelId = unit.channelId();
         if(channelId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(channelId);
         }
      }
      if(unit.isTypeIdChanged()){
         cmd.append(",`TYPE_ID`=");
         long typeId = unit.typeId();
         if(typeId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(typeId);
         }
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
      if(unit.isVendorIdChanged()){
         cmd.append(",`VENDOR_ID`=");
         long vendorId = unit.vendorId();
         if(vendorId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(vendorId);
         }
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
      if(unit.isUserIdChanged()){
         cmd.append(",`USER_ID`=");
         long userId = unit.userId();
         if(userId == 0){
            cmd.append("NULL");
         }else{
            cmd.append(userId);
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
      if(unit.isStatusCdChanged()){
         cmd.append(",`STATUS_CD`=");
         cmd.append(unit.statusCd());
      }
      if(unit.isResourceCdChanged()){
         cmd.append(",`RESOURCE_CD`=");
         cmd.append(unit.resourceCd());
      }
      if(unit.isResourceDeployCdChanged()){
         cmd.append(",`RESOURCE_DEPLOY_CD`=");
         cmd.append(unit.resourceDeployCd());
      }
      if(unit.isDisplayCdChanged()){
         cmd.append(",`DISPLAY_CD`=");
         cmd.append(unit.displayCd());
      }
      if(unit.isDisplayOrderChanged()){
         cmd.append(",`DISPLAY_ORDER`=");
         cmd.append(unit.displayOrder());
      }
      if(unit.isExamineDateChanged()){
         cmd.append(",`EXAMINE_DATE`=");
         TDateTime examineDate = unit.examineDate();
         if(examineDate == null){
            cmd.append("NULL");
         }else if(examineDate.isEmpty()){
            cmd.append("NULL");
         }else{
            cmd.append("STR_TO_DATE('");
            cmd.append(examineDate.format());
            cmd.append("','%Y%m%d%H%i%s')");
         }
      }
      if(unit.isExamineResultCdChanged()){
         cmd.append(",`EXAMINE_RESULT_CD`=");
         cmd.append(unit.examineResultCd());
      }
      if(unit.isRecommendCdChanged()){
         cmd.append(",`RECOMMEND_CD`=");
         cmd.append(unit.recommendCd());
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
      if(unit.isLinkUrlChanged()){
         cmd.append(",`LINK_URL`=");
         String linkUrl = unit.linkUrl();
         if(RString.isEmpty(linkUrl)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(linkUrl));
            cmd.append('\'');
         }
      }
      if(unit.isVersionNumberChanged()){
         cmd.append(",`VERSION_NUMBER`=");
         cmd.append(unit.versionNumber());
      }
      if(unit.isVersionCodeChanged()){
         cmd.append(",`VERSION_CODE`=");
         String versionCode = unit.versionCode();
         if(RString.isEmpty(versionCode)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(versionCode));
            cmd.append('\'');
         }
      }
      if(unit.isKeywordsChanged()){
         cmd.append(",`KEYWORDS`=");
         String keywords = unit.keywords();
         if(RString.isEmpty(keywords)){
            cmd.append("NULL");
         }else{
            cmd.append('\'');
            cmd.append(RSql.formatValue(keywords));
            cmd.append('\'');
         }
      }
      if(unit.isScoreBeanChanged()){
         cmd.append(",`SCORE_BEAN`=");
         cmd.append(unit.scoreBean());
      }
      if(unit.isScorePointChanged()){
         cmd.append(",`SCORE_POINT`=");
         cmd.append(unit.scorePoint());
      }
      if(unit.isScoreGoldChanged()){
         cmd.append(",`SCORE_GOLD`=");
         cmd.append(unit.scoreGold());
      }
      if(unit.isPlayCountChanged()){
         cmd.append(",`PLAY_COUNT`=");
         cmd.append(unit.playCount());
      }
      if(unit.isPraiseCountChanged()){
         cmd.append(",`PRAISE_COUNT`=");
         cmd.append(unit.praiseCount());
      }
      if(unit.isAttentionCountChanged()){
         cmd.append(",`ATTENTION_COUNT`=");
         cmd.append(unit.attentionCount());
      }
      if(unit.isShareCountChanged()){
         cmd.append(",`SHARE_COUNT`=");
         cmd.append(unit.shareCount());
      }
      if(unit.isViewCountChanged()){
         cmd.append(",`VIEW_COUNT`=");
         cmd.append(unit.viewCount());
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
      FDataResourceResourceUnit unit = (FDataResourceResourceUnit)logicUnit;
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

package org.mo.cloud.core.storage;

//============================================================
// <T>资源信息。</T>
//============================================================
public class SGcStorage
{
   // 分类
   protected String _catalog;

   // 标识
   protected String _guid;

   // 代码
   protected String _code;

   // 日期
   protected String _date;

   // 类型
   protected String _type = "bin";

   // 数据来源（文件名称）
   protected String _dataSource;

   // 数据
   protected byte[] _data;

   //============================================================
   // <T>构造资源信息。</T>
   //============================================================
   public SGcStorage(){
   }

   //============================================================
   // <T>构造资源信息。</T>
   //
   // @param catalog 分类
   // @param guid 类型
   //============================================================
   public SGcStorage(String catalog,
                     String guid){
      _catalog = catalog;
      _guid = guid;
   }

   //============================================================
   // <T>构造资源信息。</T>
   //
   // @param catalog 分类
   // @param guid 类型
   // @param type 类型
   //============================================================
   public SGcStorage(String catalog,
                     String guid,
                     String type){
      _catalog = catalog;
      _guid = guid;
      _type = type;
   }

   //============================================================
   // <T>获得分类。</T>
   //
   // @return 分类
   //============================================================
   public String catalog(){
      return _catalog;
   }

   //============================================================
   // <T>设置分类。</T>
   //
   // @param type 分类
   //============================================================
   public void setCatalog(String catalog){
      _catalog = catalog;
   }

   //============================================================
   // <T>获得唯一标识。</T>
   //
   // @return 唯一标识
   //============================================================
   public String guid(){
      return _guid;
   }

   //============================================================
   // <T>设置唯一标识。</T>
   //
   // @param guid 唯一标识
   //============================================================
   public void setGuid(String guid){
      _guid = guid;
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置代码。</T>
   //
   // @param code 代码
   //============================================================
   public void setCode(String code){
      _code = code;
   }

   //============================================================
   // <T>获得日期。</T>
   //
   // @return 日期
   //============================================================
   public String date(){
      return _date;
   }

   //============================================================
   // <T>设置日期。</T>
   //
   // @param type 日期
   //============================================================
   public void setDate(String date){
      _date = date;
   }

   //============================================================
   // <T>获得类型。</T>
   //
   // @return 类型
   //============================================================
   public String type(){
      return _type;
   }

   //============================================================
   // <T>设置类型。</T>
   //
   // @param type 类型
   //============================================================
   public void setType(String type){
      _type = type;
   }

   //============================================================
   // <T>获得来源。</T>
   //
   // @return 来源
   //============================================================
   public String dataSource(){
      return _dataSource;
   }

   //============================================================
   // <T>设置来源。</T>
   //
   // @param source 来源
   //============================================================
   public void setDataSource(String dataSource){
      _dataSource = dataSource;
   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @return 数据
   //============================================================
   public byte[] data(){
      return _data;
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param data 数据
   //============================================================
   public void setData(byte[] data){
      _data = data;
   }
}

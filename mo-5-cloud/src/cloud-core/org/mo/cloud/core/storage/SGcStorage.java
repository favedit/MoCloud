package org.mo.cloud.core.storage;

//============================================================
// <T>存储信息。</T>
//============================================================
public class SGcStorage
{
   // 分类
   protected String _catalog;

   // 类型
   protected String _type;

   // 代码
   protected String _code;

   // 名称
   protected String _name;

   // 扩展名
   protected String _extension;

   // 来源
   protected String _source;

   // 来源大小
   protected int _sourceLength;

   // 网络地址
   protected String _uri;

   // 网络地址
   protected String _url;

   // 图片集合
   protected SGcStorageImages _images = new SGcStorageImages();

   //============================================================
   // <T>构造存储信息。</T>
   //============================================================
   public SGcStorage(){
   }

   //============================================================
   // <T>构造存储信息。</T>
   //
   // @param catalog 分类
   // @param type 类型
   // @param code 代码
   // @param source 来源
   //============================================================
   public SGcStorage(String catalog,
                     String type,
                     String code,
                     String name){
      _catalog = catalog;
      _type = type;
      _code = code;
      _name = name;
   }

   //============================================================
   // <T>构造存储信息。</T>
   //
   // @param catalog 分类
   // @param type 类型
   // @param code 代码
   // @param name 名称
   // @param source 来源
   //============================================================
   public SGcStorage(String catalog,
                     String type,
                     String code,
                     String name,
                     String source){
      _catalog = catalog;
      _type = type;
      _code = code;
      _name = name;
      _source = source;
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
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称。</T>
   //
   // @param name 名称
   //============================================================
   public void setName(String name){
      _name = name;
   }

   //============================================================
   // <T>获得扩展名。</T>
   //
   // @return 扩展名
   //============================================================
   public String extension(){
      return _extension;
   }

   //============================================================
   // <T>设置扩展名。</T>
   //
   // @param extension 扩展名
   //============================================================
   public void setExtension(String extension){
      _extension = extension;
   }

   //============================================================
   // <T>获得来源。</T>
   //
   // @return 来源
   //============================================================
   public String source(){
      return _source;
   }

   //============================================================
   // <T>设置来源。</T>
   //
   // @param source 来源
   //============================================================
   public void setSource(String source){
      _source = source;
   }

   //============================================================
   // <T>获得来源。</T>
   //
   // @return 来源
   //============================================================
   public int sourceLength(){
      return _sourceLength;
   }

   //============================================================
   // <T>设置来源。</T>
   //
   // @param source 来源
   //============================================================
   public void setSourceLength(int sourceLength){
      _sourceLength = sourceLength;
   }

   //============================================================
   // <T>获得网络地址。</T>
   //
   // @return 网络地址
   //============================================================
   public String uri(){
      return _uri;
   }

   //============================================================
   // <T>设置网络地址。</T>
   //
   // @param url 网络地址
   //============================================================
   public void setUri(String uri){
      _uri = uri;
   }

   //============================================================
   // <T>获得网络地址。</T>
   //
   // @return 网络地址
   //============================================================
   public String url(){
      return _url;
   }

   //============================================================
   // <T>设置网络地址。</T>
   //
   // @param url 网络地址
   //============================================================
   public void setUrl(String url){
      _url = url;
   }

   //============================================================
   // <T>获得图片集合。</T>
   //
   // @return 图片集合
   //============================================================
   public SGcStorageImages images(){
      return _images;
   }

   //============================================================
   // <T>增加一个图片。</T>
   //
   // @param width 宽度
   // @param height 高度
   //============================================================
   public void pushImage(int width,
                         int height){
      pushImage(width, height, 0);
   }

   //============================================================
   // <T>增加一个图片。</T>
   //
   // @param width 宽度
   // @param height 高度
   // @param round 圆角
   //============================================================
   public void pushImage(int width,
                         int height,
                         int round){
      SGcStorageImage image = new SGcStorageImage();
      image.setWidth(width);
      image.setHeight(height);
      image.setRound(round);
      _images.push(image);
   }
}

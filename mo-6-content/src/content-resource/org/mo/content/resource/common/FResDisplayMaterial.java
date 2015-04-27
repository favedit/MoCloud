package org.mo.content.resource.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源显示对象。</T>
//============================================================
public class FResDisplayMaterial
      extends FObject
{
   // 代码
   protected String _code;

   // 唯一编号
   protected String _groupGuid;

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FResDisplayMaterial(){
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
   // <T>获得唯一编号。</T>
   //
   // @return 唯一编号
   //============================================================
   public String groupGuid(){
      return _groupGuid;
   }

   //============================================================
   // <T>设置唯一编号。</T>
   //
   // @return 唯一编号
   //============================================================
   public void setGroupGuid(String groupGuid){
      _groupGuid = groupGuid;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeString(_groupGuid);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _groupGuid = xconfig.get("group_guid");
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("group_guid", _groupGuid);
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void importConfig(FXmlNode xconfig){
      // 读取属性
      _code = xconfig.get("code");
   }
}

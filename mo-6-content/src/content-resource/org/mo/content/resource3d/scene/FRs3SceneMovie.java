package org.mo.content.resource3d.scene;

import org.mo.com.geom.SFloatVector3;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Object;

//============================================================
// <T>场景动画。</T>
//============================================================
public class FRs3SceneMovie
      extends FRs3Object
{
   // 类型代码
   protected String _typeCode;

   // 间隔
   protected int _interval;

   // 旋转信息
   protected SFloatVector3 _rotation = new SFloatVector3();

   //============================================================
   // <T>构造场景动画。</T>
   //============================================================
   public FRs3SceneMovie(){
   }

   //============================================================
   // <T>获得类型代码。</T>
   //
   // @return 类型代码
   //============================================================
   public String typeCode(){
      return _typeCode;
   }

   //============================================================
   // <T>设置类型代码。</T>
   //
   // @param typeCode 类型代码
   //============================================================
   public void setTypeCode(String typeCode){
      _typeCode = typeCode;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储属性
      output.writeInt32(_interval);
      _rotation.serialize(output);
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 检查唯一编号
      if(RString.isEmpty(_guid)){
         _guid = RUuid.makeUniqueId();
      }
      // 读取属性
      _interval = xconfig.getInt("interval");
      _rotation.parse(xconfig.get("rotation"));
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 读取属性
      _interval = xconfig.getInt("interval");
      _rotation.parse(xconfig.get("rotation"));
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 存储属性
      xconfig.set("interval", _interval);
      xconfig.set("rotation", _rotation);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _interval = input.readInt32();
      _rotation.unserialize(input);
   }
}

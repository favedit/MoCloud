package org.mo.content.resource3d.common;

import org.mo.com.io.IDataInput;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源3D骨头引用。</T>
//============================================================
public class FRs3BoneRefer
      extends FObject
{
   // 索引位置
   protected int _index;

   //============================================================
   // <T>构造资源3D骨头。</T>
   //============================================================
   public FRs3BoneRefer(){
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _index = xconfig.getInt("index");
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("index", _index);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      _index = input.readInt32();
   }
}

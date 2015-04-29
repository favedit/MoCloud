package org.mo.content.resource.scene;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource.common.FResObject;

//============================================================
// <T>场景显示。</T>
//============================================================
public class FResSceneAnimation
      extends FResObject
{
   // 播放速率
   protected float _playRate;

   //============================================================
   // <T>构造场景显示。</T>
   //============================================================
   public FResSceneAnimation(){
      _typeName = "SceneAnimation";
   }

   //============================================================
   // <T>获得播放速率。</T>
   //
   // @return 播放速率
   //============================================================
   public float playRate(){
      return _playRate;
   }

   //============================================================
   // <T>设置播放速率。</T>
   //
   // @param playRate 播放速率
   //============================================================
   public void setPlayRate(float playRate){
      _playRate = playRate;
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
      output.writeFloat(_playRate);
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 读取属性
      _playRate = xconfig.getFloat("play_rate", _playRate);
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 读取节点集合
      _playRate = xconfig.getFloat("play_rate", _playRate);
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
      xconfig.set("play_rate", _playRate);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
   }
}

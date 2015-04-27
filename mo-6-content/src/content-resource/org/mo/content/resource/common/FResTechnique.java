package org.mo.content.resource.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>场景技术。</T>
//============================================================
public class FResTechnique
      extends FResObject
{
   // 场景技术过程集合
   protected FObjects<FResTechniquePass> _passes;

   //============================================================
   // <T>构造场景技术。</T>
   //============================================================
   public FResTechnique(){
      _typeName = "Technique";
   }

   //============================================================
   // <T>获得技术过程集合。</T>
   //
   // @param output 输出流
   //============================================================
   public FObjects<FResTechniquePass> passes(){
      return _passes;
   }

   //============================================================
   // <T>增加一个技术过程。</T>
   //
   // @param pass 技术过程
   //============================================================
   public void pushPass(FResTechniquePass pass){
      if(_passes == null){
         _passes = new FObjects<FResTechniquePass>(FResTechniquePass.class);
      }
      _passes.push(pass);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储技术过程集合
      if(_passes != null){
         int count = _passes.count();
         output.writeInt16((short)count);
         for(FResTechniquePass pass : _passes){
            pass.serialize(output);
         }
      }else{
         output.writeInt16((short)0);
      }
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _guid = xconfig.get("guid");
      _code = xconfig.get("code");
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("PassCollection")){
            for(FXmlNode xpass : xnode){
               FResTechniquePass pass = new FResTechniquePass();
               pass.loadConfig(xpass);
               pushPass(pass);
            }
         }else{
            throw new FFatalError("Invalid config node.");
         }
      }
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("guid", makeGuid());
      xconfig.set("code", _code);
      // 存储透明
      if(_passes != null){
         FXmlNode xpasses = xconfig.createNode("PassCollection");
         for(FResTechniquePass pass : _passes){
            pass.saveConfig(xpasses.createNode("Pass"));
         }
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      // 读取网格集合
      int passCount = input.readInt32();
      for(int n = 0; n < passCount; n++){
         FResTechniquePass pass = new FResTechniquePass();
         pass.importData(input);
         pushPass(pass);
      }
   }
}

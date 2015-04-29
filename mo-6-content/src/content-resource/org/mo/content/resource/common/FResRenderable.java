package org.mo.content.resource.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源渲染对象。</T>
//============================================================
public class FResRenderable
      extends FResDrawable
{
   // 材质集合
   protected FObjects<FResMaterialRefer> _materialRefers;

   //============================================================
   // <T>构造资源渲染对象。</T>
   //============================================================
   public FResRenderable(){
   }

   //============================================================
   // <T>判断是否含有材质引用。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasMaterialRefer(){
      return (_materialRefers != null) ? !_materialRefers.isEmpty() : false;
   }

   //============================================================
   // <T>根据唯一编号查找材质引用。</T>
   //
   // @param guid 唯一编号
   // @return 材质引用
   //============================================================
   public FResMaterialRefer findMaterialByGuid(String guid){
      if(!RString.isEmpty(guid) && (_materialRefers != null)){
         for(FResMaterialRefer materialRefer : _materialRefers){
            if(guid.equals(materialRefer.guid())){
               return materialRefer;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>获得材质引用集合。</T>
   //
   // @return 材质引用集合
   //============================================================
   public FObjects<FResMaterialRefer> materials(){
      return _materialRefers;
   }

   //============================================================
   // <T>增加一个材质引用。</T>
   //
   // @param materialRefer 材质引用
   //============================================================
   public void pushMaterialRefer(FResMaterialRefer materialRefer){
      if(_materialRefers == null){
         _materialRefers = new FObjects<FResMaterialRefer>(FResMaterialRefer.class);
      }
      _materialRefers.push(materialRefer);
   }

   //============================================================
   // <T>清空材质引用集合。</T>
   //============================================================
   public void clearMaterialRefer(){
      if(_materialRefers != null){
         _materialRefers.clear();
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 输出材质引用集合
      if(hasMaterialRefer()){
         int materialReferCount = _materialRefers.count();
         output.writeUint16(materialReferCount);
         for(int i = 0; i < materialReferCount; i++){
            FResMaterialRefer materialRefer = _materialRefers.get(i);
            materialRefer.serialize(output);
         }
      }else{
         output.writeUint16(0);
      }
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 处理所有节点
      FXmlNode xmaterialRefers = xconfig.findNode("MaterialReferCollection");
      if(xmaterialRefers != null){
         for(FXmlNode xmaterialRefer : xmaterialRefers){
            FResMaterialRefer materialRefer = new FResMaterialRefer();
            materialRefer.loadConfig(xmaterialRefer);
            pushMaterialRefer(materialRefer);
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
      super.saveConfig(xconfig);
      // 处理所有节点
      if(hasMaterialRefer()){
         FXmlNode xmaterialRefers = xconfig.createNode("MaterialReferCollection");
         for(FResMaterialRefer materialRefer : _materialRefers){
            materialRefer.saveConfig(xmaterialRefers.createNode("MaterialRefer"));
         }
      }
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 处理所有节点
      FXmlNode xmaterialRefers = xconfig.findNode("MaterialReferCollection");
      if(xmaterialRefers != null){
         clearMaterialRefer();
         for(FXmlNode xmaterialRefer : xmaterialRefers){
            FResMaterialRefer materialRefer = new FResMaterialRefer();
            materialRefer.loadConfig(xmaterialRefer);
            pushMaterialRefer(materialRefer);
         }
      }
   }
}

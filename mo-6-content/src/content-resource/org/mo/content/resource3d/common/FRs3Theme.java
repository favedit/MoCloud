package org.mo.content.resource3d.common;

import com.cyou.gccloud.data.data.FDataResource3dThemeUnit;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源模型。</T>
//============================================================
public class FRs3Theme
      extends FRs3Object
{
   // 网格集合
   protected FObjects<FRs3Material> _materials = new FObjects<FRs3Material>(FRs3Material.class);

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Theme(){
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FRs3Material> materials(){
      return _materials;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      // 输出属性
      super.serialize(output);
      // 输出网格集合
      int materialCount = _materials.count();
      output.writeInt16((short)materialCount);
      for(int i = 0; i < materialCount; i++){
         FRs3Material material = _materials.get(i);
         material.serialize(output);
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
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("MaterialCollection")){
            // 读取材质集合
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Material")){
                  FRs3Material material = new FRs3Material();
                  material.loadConfig(xchild);
                  _materials.push(material);
               }
            }
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
      xconfig.set("guid", _guid);
      xconfig.set("code", _code);
      xconfig.set("label", _label);
      // 存储材质集合
      FXmlNode xmaterials = xconfig.createNode("MaterialCollection");
      for(FRs3Material material : _materials){
         material.saveConfig(xmaterials.createNode("Material"));
      }
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dThemeUnit unit){
      // 加载属性
      _guid = unit.guid();
      _code = unit.code();
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void importConfig(FXmlNode xconfig){
      // 读取属性
      _code = xconfig.get("code");
      _label = xconfig.get("label");
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("MaterialCollection")){
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Material")){
                  FRs3Material material = new FRs3Material();
                  material.setTheme(this);
                  material.importConfig(xchild);
                  _materials.push(material);
               }
            }
         }
      }
   }
}

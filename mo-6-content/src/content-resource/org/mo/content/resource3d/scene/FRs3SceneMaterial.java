package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.content.resource3d.common.FRs3Material;

//============================================================
// <T>场景显示。</T>
//============================================================
public class FRs3SceneMaterial
      extends FRs3Material
{
   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FRs3SceneMaterial(){
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _label = input.readString();
      // 读取配置
      _effectCode = input.readString();
      _optionDouble = input.readBoolean();
      // 读取透明
      _alphaBase = input.readFloat();
      _alphaRate = input.readFloat();
      // 读取环境
      _ambientColor.unserialize(input);
      _diffuseColor.unserialize(input);
      _diffuseViewColor.unserialize(input);
      _specularColor.unserialize(input);
      _specularLevel = input.readFloat();
      _specularViewColor.unserialize(input);
      _specularViewLevel = input.readFloat();
      _reflectColor.unserialize(input);
      _reflectMerge = input.readFloat();
      _refractFrontColor.unserialize(input);
      _refractBackColor.unserialize(input);
      _emissiveColor.unserialize(input);
   }
}

package org.mo.content.resource3d.common;

import com.cyou.gccloud.data.data.FDataResourceMaterialUnit;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.geom.common.SFloatColor4;

//============================================================
// <T>资源模型。</T>
//============================================================
public class FRs3Material
      extends FRs3Object
{
   // 效果代码
   protected String _effectCode = "automatic";

   // 配置深度
   protected boolean _optionDepth = true;

   // 配置双面
   protected boolean _optionDouble = false;

   // 配置法线反向
   protected boolean _optionNormalInvert = false;

   // 配置阴影
   protected boolean _optionShadow = true;

   // 配置自阴影
   protected boolean _optionShadowSelf = true;

   // 配置颜色
   protected boolean _optionColor = true;

   // 颜色最小
   protected float _colorMin = 0.0f;

   // 颜色最大
   protected float _colorMax = 1.0f;

   // 颜色比率
   protected float _colorRate = 1.0f;

   // 颜色融合
   protected float _colorMerge = 1.0f;

   // 配置透明
   protected boolean _optionAlpha = false;

   // 透明基础
   protected float _alphaBase = 0.0f;

   // 透明比率
   protected float _alphaRate = 1.0f;

   // 配置环境
   protected boolean _optionAmbient = true;

   // 环境颜色
   protected SFloatColor4 _ambientColor = new SFloatColor4(1.0f, 1.0f, 1.0f, 1.0f);

   // 配置散射
   protected boolean _optionDiffuse = true;

   // 散射颜色
   protected SFloatColor4 _diffuseColor = new SFloatColor4(0.5f, 0.5f, 0.5f, 1.0f);

   // 配置散射视角
   protected boolean _optionDiffuseView = false;

   // 散射视角颜色
   protected SFloatColor4 _diffuseViewColor = new SFloatColor4(0.5f, 0.5f, 0.5f, 1.0f);

   // 配置高光
   protected boolean _optionSpecular = true;

   // 高光颜色
   protected SFloatColor4 _specularColor = new SFloatColor4(0.5f, 0.5f, 0.5f, 1.0f);

   // 高光基础
   protected float _specularBase = 0.0f;

   // 高光级别
   protected float _specularLevel = 1.0f;

   // 配置视角高光
   protected boolean _optionSpecularView = false;

   // 高光视角颜色
   protected SFloatColor4 _specularViewColor = new SFloatColor4(0.5f, 0.5f, 0.5f, 1.0f);

   // 高光视角基础
   protected float _specularViewBase = 0.0f;

   // 高光视角级别
   protected float _specularViewLevel = 1.0f;

   // 配置反射
   protected boolean _optionReflect = true;

   // 反射颜色
   protected SFloatColor4 _reflectColor = new SFloatColor4();

   // 反射融合
   protected float _reflectMerge = 0.5f;

   // 配置折射
   protected boolean _optionRefract = false;

   // 前折射颜色
   protected SFloatColor4 _refractFrontColor = new SFloatColor4(1.0f, 1.0f, 1.0f, 1.0f);

   // 后折射颜色
   protected SFloatColor4 _refractBackColor = new SFloatColor4(1.0f, 1.0f, 1.0f, 1.0f);

   // 配置不透明
   protected boolean _optionOpacity = false;

   // 不透明颜色
   protected SFloatColor4 _opacityColor = new SFloatColor4(1.0f, 1.0f, 1.0f, 1.0f);

   // 不透明比率
   protected float _opacityRate = 0.0f;

   // 不透明透过度
   protected float _opacityAlpha = 1.0f;

   // 不透明深度
   protected float _opacityDepth = 1.0f;

   // 不透明度
   protected float _opacityTransmittance = 1.0f;

   // 配置发光
   protected boolean _optionEmissive = false;

   // 发光颜色
   protected SFloatColor4 _emissiveColor = new SFloatColor4(1.0f, 1.0f, 1.0f, 1.0f);

   // 位图集合
   protected FObjects<FRs3MaterialBitmap> _bitmaps;

   // 资源位图打包集合
   protected FObjects<FRs3MaterialBitmapPack> _bitmapPacks;

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Material(){
      _typeName = "Material";
      makeGuid();
   }

   //============================================================
   // <T>获得全代码。</T>
   //
   // @return 全代码
   //============================================================
   @Override
   public String fullCode(){
      //return _theme.code() + "|" + _code;
      return _code;
   }

   //============================================================
   // <T>获得透明基础。</T>
   //
   // @return 透明基础
   //============================================================
   public float alphaBase(){
      return _alphaBase;
   }

   //============================================================
   // <T>设置透明基础。</T>
   //
   // @param alphaBase 透明基础
   //============================================================
   public void setAlphaBase(float alphaBase){
      _alphaBase = alphaBase;
   }

   //============================================================
   // <T>获得透明比率。</T>
   //
   // @return 透明比率
   //============================================================
   public float alphaRate(){
      return _alphaRate;
   }

   //============================================================
   // <T>设置透明比率。</T>
   //
   // @param alphaRate 透明比率
   //============================================================
   public void setAlphaRate(float alphaRate){
      _alphaRate = alphaRate;
   }

   //============================================================
   // <T>获得环境颜色。</T>
   //
   // @return 环境颜色
   //============================================================
   public SFloatColor4 ambientColor(){
      return _ambientColor;
   }

   //============================================================
   // <T>获得散射颜色。</T>
   //
   // @return 散射颜色
   //============================================================
   public SFloatColor4 diffuseColor(){
      return _diffuseColor;
   }

   //============================================================
   // <T>获得高光颜色。</T>
   //
   // @return 高光颜色
   //============================================================
   public SFloatColor4 specularColor(){
      return _specularColor;
   }

   //============================================================
   // <T>获得高光基础。</T>
   //
   // @return 高光基础
   //============================================================
   public float specularBase(){
      return _specularBase;
   }

   //============================================================
   // <T>设置高光基础。</T>
   //
   // @param specularBase 高光基础
   //============================================================
   public void setSpecularBase(float specularBase){
      _specularBase = specularBase;
   }

   //============================================================
   // <T>获得高光级别。</T>
   //
   // @return 高光级别
   //============================================================
   public float specularLevel(){
      return _specularLevel;
   }

   //============================================================
   // <T>设置高光级别。</T>
   //
   // @param specularLevel 高光级别
   //============================================================
   public void setSpecularLevel(float specularLevel){
      _specularLevel = specularLevel;
   }

   //============================================================
   // <T>获得反射颜色。</T>
   //
   // @return 反射颜色
   //============================================================
   public SFloatColor4 reflectColor(){
      return _reflectColor;
   }

   //============================================================
   // <T>获得反射合并。</T>
   //
   // @return 反射合并
   //============================================================
   public float reflectMerge(){
      return _reflectMerge;
   }

   //============================================================
   // <T>设置反射合并。</T>
   //
   // @param reflectMerge 反射合并
   //============================================================
   public void setReflectMerge(float reflectMerge){
      _reflectMerge = reflectMerge;
   }

   //============================================================
   // <T>获得折射前颜色。</T>
   //
   // @return 折射前颜色
   //============================================================
   public SFloatColor4 refractFrontColor(){
      return _refractFrontColor;
   }

   //============================================================
   // <T>获得折射后颜色。</T>
   //
   // @return 折射后颜色
   //============================================================
   public SFloatColor4 refractBackColor(){
      return _refractBackColor;
   }

   //============================================================
   // <T>获得发光颜色。</T>
   //
   // @return 发光颜色
   //============================================================
   public SFloatColor4 emissiveColor(){
      return _emissiveColor;
   }

   //============================================================
   // <T>判断是否含有位图。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasBitmap(){
      return (_bitmaps != null) ? !_bitmaps.isEmpty() : false;
   }

   //============================================================
   // <T>根据代码查找材质位图。</T>
   //
   // @param code 代码
   //============================================================
   public FRs3MaterialBitmap findBitmapByCode(String code){
      // 输出纹理位图集合
      if(_bitmaps != null){
         int bitmapCount = _bitmaps.count();
         for(int i = 0; i < bitmapCount; i++){
            FRs3MaterialBitmap bitmap = _bitmaps.get(i);
            if(code.equals(bitmap.code())){
               return bitmap;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>获得位图集合。</T>
   //
   // @return 位图集合
   //============================================================
   public FObjects<FRs3MaterialBitmap> bitmaps(){
      return _bitmaps;
   }

   //============================================================
   // <T>增加一个位图。</T>
   //
   // @param bitmap 位图
   //============================================================
   public void pushBitmap(FRs3MaterialBitmap bitmap){
      if(_bitmaps == null){
         _bitmaps = new FObjects<FRs3MaterialBitmap>(FRs3MaterialBitmap.class);
      }
      _bitmaps.push(bitmap);
   }

   //============================================================
   // <T>判断是否含有位图打包。</T>
   //
   // @return 是否含有打包
   //============================================================
   public boolean hasBitmapPack(){
      return (_bitmapPacks != null) ? !_bitmapPacks.isEmpty() : false;
   }

   //============================================================
   // <T>获得资源位图打包集合。</T>
   //
   // @return 资源位图打包集合
   //============================================================
   public FObjects<FRs3MaterialBitmapPack> bitmapPacks(){
      return _bitmapPacks;
   }

   //============================================================
   // <T>增加一个位图。</T>
   //
   // @param bitmap 位图
   //============================================================
   public void pushBitmapPack(FRs3MaterialBitmapPack bitmapPack){
      if(_bitmapPacks == null){
         _bitmapPacks = new FObjects<FRs3MaterialBitmapPack>(FRs3MaterialBitmapPack.class);
      }
      _bitmapPacks.push(bitmapPack);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 输出属性
      output.writeString(_effectCode);
      // 输出配置
      output.writeBoolean(_optionDepth);
      output.writeBoolean(_optionDouble);
      output.writeBoolean(_optionNormalInvert);
      output.writeBoolean(_optionShadow);
      output.writeBoolean(_optionShadowSelf);
      // 输出透明
      output.writeBoolean(_optionAlpha);
      output.writeFloat(_alphaBase);
      output.writeFloat(_alphaRate);
      // 输出颜色
      output.writeBoolean(_optionColor);
      output.writeFloat(_colorMin);
      output.writeFloat(_colorMax);
      output.writeFloat(_colorRate);
      output.writeFloat(_colorMerge);
      // 输出颜色
      output.writeBoolean(_optionAmbient);
      _ambientColor.serialize(output);
      // 输出颜色
      output.writeBoolean(_optionDiffuse);
      _diffuseColor.serialize(output);
      output.writeBoolean(_optionDiffuseView);
      _diffuseViewColor.serialize(output);
      // 输出颜色
      output.writeBoolean(_optionSpecular);
      _specularColor.serialize(output);
      output.writeFloat(_specularBase);
      output.writeFloat(_specularLevel);
      output.writeBoolean(_optionSpecularView);
      _specularViewColor.serialize(output);
      output.writeFloat(_specularViewBase);
      output.writeFloat(_specularViewLevel);
      // 输出颜色
      output.writeBoolean(_optionReflect);
      _reflectColor.serialize(output);
      output.writeFloat(_reflectMerge);
      // 输出颜色
      output.writeBoolean(_optionRefract);
      _refractFrontColor.serialize(output);
      _refractBackColor.serialize(output);
      // 输出不透明度
      output.writeBoolean(_optionOpacity);
      _opacityColor.serialize(output);
      output.writeFloat(_opacityRate);
      output.writeFloat(_opacityAlpha);
      output.writeFloat(_opacityDepth);
      output.writeFloat(_opacityTransmittance);
      // 输出颜色
      output.writeBoolean(_optionEmissive);
      _emissiveColor.serialize(output);
      // 输出纹理打包集合
      if(hasBitmapPack()){
         int count = _bitmapPacks.count();
         output.writeUint16(count);
         for(FRs3MaterialBitmapPack bitmapPack : _bitmapPacks){
            bitmapPack.serialize(output);
         }
      }else{
         output.writeUint16(0);
      }
      // 输出纹理集合
      if(hasBitmap()){
         int count = _bitmaps.count();
         output.writeUint16(count);
         for(FRs3MaterialBitmap bitmap : _bitmaps){
            bitmap.serialize(output);
         }
      }else{
         output.writeUint16(0);
      }
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfigInfo(FXmlNode xconfig){
      // 加载配置
      _optionDepth = xconfig.getBoolean("option_depth", _optionDepth);
      _optionAlpha = xconfig.getBoolean("option_alpha", _optionAlpha);
      _optionDouble = xconfig.getBoolean("option_double", _optionDouble);
      _optionNormalInvert = xconfig.getBoolean("option_normal_invert", _optionNormalInvert);
      _optionShadow = xconfig.getBoolean("option_shadow", _optionShadow);
      _optionShadowSelf = xconfig.getBoolean("option_shadow_self", _optionShadowSelf);
      // 加载节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Alpha")){
            _optionAlpha = xnode.getBoolean("valid", _optionAlpha);
            _alphaBase = xnode.getFloat("base", 0.1f);
            _alphaRate = xnode.getFloat("rate", 1.0f);
         }else if(xnode.isName("Color")){
            _optionColor = xnode.getBoolean("valid", _optionColor);
            _colorMin = xnode.getFloat("min", 0.0f);
            _colorMax = xnode.getFloat("max", 1.0f);
            _colorRate = xnode.getFloat("rate", 2.0f);
            _colorMerge = xnode.getFloat("merge", 0.5f);
         }else if(xnode.isName("Ambient")){
            _optionAmbient = xnode.getBoolean("valid", _optionAmbient);
            _ambientColor.loadConfig(xnode);
         }else if(xnode.isName("Diffuse")){
            _optionDiffuse = xnode.getBoolean("valid", _optionDiffuse);
            _diffuseColor.loadConfig(xnode);
         }else if(xnode.isName("DiffuseView")){
            _optionDiffuseView = xnode.getBoolean("valid", _optionDiffuseView);
            _diffuseViewColor.loadConfig(xnode);
         }else if(xnode.isName("Specular")){
            _optionSpecular = xnode.getBoolean("valid", _optionSpecular);
            _specularColor.loadConfig(xnode);
            _specularBase = xnode.getFloat("base", 0.0f);
            _specularLevel = xnode.getFloat("level", 16.0f);
         }else if(xnode.isName("SpecularView")){
            _optionSpecularView = xnode.getBoolean("valid", _optionSpecularView);
            _specularViewColor.loadConfig(xnode);
            _specularViewBase = xnode.getFloat("base", 0.0f);
            _specularViewLevel = xnode.getFloat("level", 16.0f);
         }else if(xnode.isName("Reflect")){
            _optionReflect = xnode.getBoolean("valid", _optionReflect);
            _reflectColor.loadConfig(xnode);
            _reflectMerge = xnode.getFloat("merge", _reflectMerge);
         }else if(xnode.isName("Refract")){
            _optionRefract = xnode.getBoolean("valid", _optionRefract);
            FXmlNode xfront = xnode.findNode("Front");
            if(xfront != null){
               _refractFrontColor.loadConfig(xfront);
            }
            FXmlNode xback = xnode.findNode("Back");
            if(xback != null){
               _refractBackColor.loadConfig(xback);
            }
         }else if(xnode.isName("Opacity")){
            _optionOpacity = xnode.getBoolean("valid", _optionOpacity);
            _opacityColor.loadConfig(xnode);
            _opacityRate = xnode.getFloat("rate", _opacityRate);
            _opacityAlpha = xnode.getFloat("alpha", _opacityAlpha);
            _opacityDepth = xnode.getFloat("depth", _opacityDepth);
            _opacityTransmittance = xnode.getFloat("transmittance", _opacityTransmittance);
         }else if(xnode.isName("Emissive")){
            _optionEmissive = xnode.getBoolean("valid", _optionEmissive);
            _emissiveColor.loadConfig(xnode);
         }else if(xnode.isName("BitmapCollection")){
            // 读取位图集合
            for(FXmlNode xbitmap : xnode.nodes()){
               if(xbitmap.isName("MaterialBitmap")){
                  FRs3MaterialBitmap bitmap = new FRs3MaterialBitmap();
                  bitmap.loadConfig(xbitmap);
                  pushBitmap(bitmap);
               }
            }
            // 打包处理
            pack();
         }
      }
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 读取属性
      _effectCode = xconfig.get("effect_code");
      // 处理所有节点
      loadConfigInfo(xconfig);
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
      _effectCode = xconfig.get("effect_code", "automatic");
      // 处理所有节点
      loadConfigInfo(xconfig);
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
      xconfig.set("effect_code", _effectCode);
      // 存储配置
      xconfig.set("option_depth", _optionDepth);
      xconfig.set("option_double", _optionDouble);
      xconfig.set("option_normal_invert", _optionNormalInvert);
      xconfig.set("option_shadow", _optionShadow);
      xconfig.set("option_shadow_self", _optionShadowSelf);
      // 存储透明
      FXmlNode xalpha = xconfig.createNode("Alpha");
      xalpha.set("valid", _optionAlpha);
      xalpha.set("base", _alphaBase);
      xalpha.set("rate", _alphaRate);
      // 存储颜色
      FXmlNode xcolor = xconfig.createNode("Color");
      xcolor.set("valid", _optionColor);
      xcolor.set("min", _colorMin);
      xcolor.set("max", _colorMax);
      xcolor.set("rate", _colorRate);
      xcolor.set("merge", _colorMerge);
      // 存储环境
      FXmlNode xambient = xconfig.createNode("Ambient");
      xambient.set("valid", _optionAmbient);
      _ambientColor.saveConfig(xambient);
      // 存储散射
      FXmlNode xdiffuse = xconfig.createNode("Diffuse");
      xdiffuse.set("valid", _optionDiffuse);
      _diffuseColor.saveConfig(xdiffuse);
      // 存储散射视角
      FXmlNode xdiffuseView = xconfig.createNode("DiffuseView");
      xdiffuseView.set("valid", _optionDiffuseView);
      _diffuseViewColor.saveConfig(xdiffuseView);
      // 存储高光
      FXmlNode xspecular = xconfig.createNode("Specular");
      xspecular.set("valid", _optionSpecular);
      _specularColor.saveConfig(xspecular);
      xspecular.set("base", _specularBase);
      xspecular.set("level", _specularLevel);
      // 存储高光视角
      FXmlNode xspecularView = xconfig.createNode("SpecularView");
      xspecularView.set("valid", _optionSpecularView);
      _specularViewColor.saveConfig(xspecularView);
      xspecularView.set("base", _specularViewBase);
      xspecularView.set("level", _specularViewLevel);
      // 存储反射
      FXmlNode xreflect = xconfig.createNode("Reflect");
      xreflect.set("valid", _optionReflect);
      _reflectColor.saveConfig(xreflect);
      xreflect.set("merge", _reflectMerge);
      // 存储折射
      FXmlNode xrefract = xconfig.createNode("Refract");
      xrefract.set("valid", _optionRefract);
      FXmlNode xrefractFront = xrefract.createNode("Front");
      _refractFrontColor.saveConfig(xrefractFront);
      FXmlNode xrefractBack = xrefract.createNode("Back");
      _refractBackColor.saveConfig(xrefractBack);
      // 存储不透明
      FXmlNode xopacity = xconfig.createNode("Opacity");
      xopacity.set("valid", _optionOpacity);
      _opacityColor.saveConfig(xopacity);
      xopacity.set("rate", _opacityRate);
      xopacity.set("alpha", _opacityAlpha);
      xopacity.set("depth", _opacityDepth);
      xopacity.set("transmittance", _opacityTransmittance);
      // 存储发光
      FXmlNode xemissive = xconfig.createNode("Emissive");
      xemissive.set("valid", _optionEmissive);
      _emissiveColor.saveConfig(xemissive);
      // 存储位图集合
      if(hasBitmap()){
         FXmlNode xbitmaps = xconfig.createNode("BitmapCollection");
         for(FRs3MaterialBitmap bitmap : _bitmaps){
            bitmap.saveConfig(xbitmaps.createNode("MaterialBitmap"));
         }
      }
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public String toXml(){
      FXmlNode xconfig = new FXmlNode("Material");
      saveConfig(xconfig);
      return xconfig.xml().toString();
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResourceMaterialUnit unit){
      // 加载配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(unit.content());
      loadConfig(xdocument.root());
      // 加载属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _label = unit.label();
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FDataResourceMaterialUnit unit){
      unit.setFullCode(_code);
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setContent(toXml());
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   // <P>移动平台上透明通道会预乘处理，暂时无法解决，先全部使用JPG的RGB通道。</P>
   // <P>颜色文理diffuse可以使用透明PNG通道。</P>
   //
   // @param unit 数据单元
   //============================================================
   public void pack(){
      // 清空打包
      if(_bitmapPacks != null){
         _bitmapPacks.clear();
      }
      if(!hasBitmap()){
         return;
      }
      // 合并颜色纹理和透明纹理
      FRs3MaterialBitmap diffuseBitmap = findBitmapByCode("diffuse");
      FRs3MaterialBitmap alphaBitmap = findBitmapByCode("alpha");
      if((diffuseBitmap != null) || (alphaBitmap != null)){
         FRs3MaterialBitmapPack bitmapPack = new FRs3MaterialBitmapPack();
         if((diffuseBitmap != null) && (alphaBitmap != null)){
            bitmapPack.setOptionAlpha(true);
            bitmapPack.setCode("diffuse-alpha");
            diffuseBitmap.setMaterialBitmapPack(bitmapPack);
            alphaBitmap.setMaterialBitmapPack(bitmapPack);
         }else if((diffuseBitmap != null) && (alphaBitmap == null)){
            bitmapPack.setCode("diffuse");
            diffuseBitmap.setMaterialBitmapPack(bitmapPack);
         }else if((diffuseBitmap == null) && (alphaBitmap != null)){
            bitmapPack.setOptionAlpha(true);
            bitmapPack.setCode("alpha");
            alphaBitmap.setMaterialBitmapPack(bitmapPack);
         }
         pushBitmapPack(bitmapPack);
      }
      //............................................................
      // 合并法线纹理和高光级别纹理
      //      FRs3MaterialBitmap normalBitmap = findBitmapByCode("normal");
      //      FRs3MaterialBitmap specularLevelBitmap = findBitmapByCode("specular.level");
      //      if((normalBitmap != null) || (specularLevelBitmap != null)){
      //         FRs3MaterialBitmapPack bitmapPack = new FRs3MaterialBitmapPack();
      //         if((normalBitmap != null) && (specularLevelBitmap != null)){
      //            bitmapPack.setOptionAlpha(true);
      //            bitmapPack.setCode("normal|specular.level");
      //            bitmapPack.mergeRgb(normalBitmap, 0xFF);
      //            // bitmapPack.mergeAlpha(specularLevelBitmap);
      //         }else if((normalBitmap != null) && (specularLevelBitmap == null)){
      //            bitmapPack.setCode("normal");
      //            bitmapPack.mergeRgb(normalBitmap, 0xFF);
      //         }else if((normalBitmap == null) && (specularLevelBitmap != null)){
      //            bitmapPack.setOptionAlpha(true);
      //            bitmapPack.setCode("specular.level");
      //            bitmapPack.mergeAlpha(specularLevelBitmap, 0xFFFFFF);
      //         }
      //         _bitmapPacks.push(bitmapPack);
      //      }
      //      //............................................................
      //      // 合并高光纹理和高度纹理
      //      FRs3MaterialBitmap specularBitmap = findBitmapByCode("specular");
      //      FRs3MaterialBitmap heightBitmap = findBitmapByCode("height");
      //      if((specularBitmap != null) || (heightBitmap != null)){
      //         FRs3MaterialBitmapPack bitmapPack = new FRs3MaterialBitmapPack();
      //         if((specularBitmap != null) && (heightBitmap != null)){
      //            bitmapPack.setCode("specular|height");
      //            bitmapPack.mergeRgb(specularBitmap);
      //            bitmapPack.mergeAlpha(heightBitmap);
      //         }else if((specularBitmap != null) && (heightBitmap == null)){
      //            bitmapPack.setCode("specular");
      //            bitmapPack.mergeRgb(specularBitmap, 0xFF);
      //         }else if((specularBitmap == null) && (heightBitmap != null)){
      //            bitmapPack.setCode("height");
      //            bitmapPack.mergeAlpha(heightBitmap, 0xFFFFFF);
      //         }
      //         _bitmapPacks.push(bitmapPack);
      //      }
      //............................................................
      // 合并高光强度，反射强度，高度纹理
      FRs3MaterialBitmap specularLevelBitmap = findBitmapByCode("specular.level");
      FRs3MaterialBitmap reflectBitmap = findBitmapByCode("reflect");
      FRs3MaterialBitmap heightBitmap = findBitmapByCode("height");
      if((specularLevelBitmap != null) || (reflectBitmap != null) || (heightBitmap != null)){
         FRs3MaterialBitmapPack bitmapPack = new FRs3MaterialBitmapPack();
         String code = "";
         if(specularLevelBitmap != null){
            code += "-specular.level";
            specularLevelBitmap.setMaterialBitmapPack(bitmapPack);
         }else{
            code += "-";
         }
         if(reflectBitmap != null){
            code += "-reflect";
            reflectBitmap.setMaterialBitmapPack(bitmapPack);
         }else{
            code += "-";
         }
         if(heightBitmap != null){
            code += "-height";
            heightBitmap.setMaterialBitmapPack(bitmapPack);
         }else{
            code += "-";
         }
         bitmapPack.setCode(code.substring(1));
         pushBitmapPack(bitmapPack);
      }
      //............................................................
      // 合并光照纹理
      FRs3MaterialBitmap lightBitmap = findBitmapByCode("light");
      FRs3MaterialBitmap refractBitmap = findBitmapByCode("refract");
      FRs3MaterialBitmap emissiveBitmap = findBitmapByCode("emissive");
      if((lightBitmap != null) || (refractBitmap != null) || (emissiveBitmap != null)){
         FRs3MaterialBitmapPack bitmapPack = new FRs3MaterialBitmapPack();
         String code = "";
         if(lightBitmap != null){
            code += "-light";
            lightBitmap.setMaterialBitmapPack(bitmapPack);
         }else{
            code += "-";
         }
         if(refractBitmap != null){
            code += "-refract";
            refractBitmap.setMaterialBitmapPack(bitmapPack);
         }else{
            code += "-";
         }
         if(emissiveBitmap != null){
            code += "-emissive";
            emissiveBitmap.setMaterialBitmapPack(bitmapPack);
         }else{
            code += "-";
         }
         bitmapPack.setCode(code.substring(1));
         pushBitmapPack(bitmapPack);
      }
      //............................................................
      // 合并透明纹理和透明级别纹理
      //      FRs3MaterialBitmap transmittanceColorBitmap = findBitmapByCode("transmittance.color");
      //      FRs3MaterialBitmap transmittanceLevelBitmap = findBitmapByCode("transmittance.level");
      //      if((transmittanceColorBitmap != null) || (transmittanceLevelBitmap != null)){
      //         FRs3MaterialBitmapPack bitmapPack = new FRs3MaterialBitmapPack();
      //         if((transmittanceColorBitmap != null) && (transmittanceLevelBitmap != null)){
      //            bitmapPack.setOptionAlpha(true);
      //            bitmapPack.setCode("transmittance.color|transmittance.level");
      //            bitmapPack.mergeRgb(transmittanceColorBitmap);
      //            bitmapPack.mergeAlpha(transmittanceLevelBitmap);
      //         }else if((transmittanceColorBitmap != null) && (transmittanceLevelBitmap != null)){
      //            bitmapPack.setCode("transmittance.color");
      //            bitmapPack.mergeRgb(transmittanceColorBitmap, 0xFF);
      //         }else if((transmittanceColorBitmap != null) && (transmittanceLevelBitmap != null)){
      //            bitmapPack.setOptionAlpha(true);
      //            bitmapPack.setCode("transmittance.level");
      //            bitmapPack.mergeAlpha(transmittanceLevelBitmap, 0xFFFFFF);
      //         }
      //         _bitmapPacks.push(bitmapPack);
      //      }
      //............................................................
      // 输出其余纹理集合
      int bitmapCount = _bitmaps.count();
      for(int i = 0; i < bitmapCount; i++){
         FRs3MaterialBitmap bitmap = _bitmaps.get(i);
         if(bitmap.materialBitmapPack() == null){
            FRs3MaterialBitmapPack bitmapPack = new FRs3MaterialBitmapPack();
            bitmapPack.setCode(bitmap.code());
            bitmapPack.setTextureBitmap(bitmap);
            bitmap.setMaterialBitmapPack(bitmapPack);
            _bitmapPacks.push(bitmapPack);
         }
      }
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
      _effectCode = xconfig.get("effect_code");
      _optionDouble = xconfig.getBoolean("option_double", false);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Alpha")){
            _alphaBase = xnode.getFloat("base");
            _alphaRate = xnode.getFloat("rate");
         }else if(xnode.isName("Color")){
            _colorMin = xnode.getFloat("min");
            _colorMax = xnode.getFloat("max");
            _colorRate = xnode.getFloat("rate");
            _colorMerge = xnode.getFloat("merge");
         }else if(xnode.isName("Ambient")){
            _ambientColor.importConfig(xnode);
         }else if(xnode.isName("Diffuse")){
            _diffuseColor.importConfig(xnode);
         }else if(xnode.isName("DiffuseView")){
            _diffuseViewColor.importConfig(xnode);
         }else if(xnode.isName("Specular")){
            _specularColor.importConfig(xnode);
            _specularBase = xnode.getFloat("base", 0.1f);
            _specularLevel = xnode.getFloat("level");
         }else if(xnode.isName("SpecularView")){
            _specularViewColor.importConfig(xnode);
            _specularViewBase = xnode.getFloat("base", 0.1f);
            _specularViewLevel = xnode.getFloat("level");
         }else if(xnode.isName("Reflect")){
            _reflectColor.importConfig(xnode);
            _reflectMerge = xnode.getFloat("merge");
         }else if(xnode.isName("RefractFront")){
            _refractFrontColor.importConfig(xnode);
         }else if(xnode.isName("RefractBack")){
            _refractBackColor.importConfig(xnode);
         }else if(xnode.isName("Emissive")){
            _emissiveColor.importConfig(xnode);
         }else if(xnode.isName("TextureCollection")){
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Texture")){
                  FRs3MaterialBitmap bitmap = new FRs3MaterialBitmap();
                  bitmap.setMaterial(this);
                  bitmap.importConfig(xchild);
                  pushBitmap(bitmap);
               }
            }
         }
      }
   }
}

package org.mo.content.resource.texture;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource.common.FResResource;

//============================================================
// <T>资源纹理。</T>
//============================================================
public class FResTexture
      extends FResResource
{
   // 资源位图集合
   protected FObjects<FResTextureBitmap> _bitmaps = new FObjects<FResTextureBitmap>(FResTextureBitmap.class);

   // 资源位图打包集合
   protected FObjects<FResTextureBitmapPack> _bitmapPacks = new FObjects<FResTextureBitmapPack>(FResTextureBitmapPack.class);

   //============================================================
   // <T>构造资源纹理。</T>
   //============================================================
   public FResTexture(){
   }

   //============================================================
   // <T>获得资源位图集合。</T>
   //
   // @return 资源位图集合
   //============================================================
   public FObjects<FResTextureBitmap> bitmaps(){
      return _bitmaps;
   }

   //============================================================
   // <T>获得资源位图打包集合。</T>
   //
   // @return 资源位图打包集合
   //============================================================
   public FObjects<FResTextureBitmapPack> bitmapPacks(){
      return _bitmapPacks;
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   //   public void loadUnit(FDataResource3dTextureUnit unit){
   //      // 加载属性
   //      _ouid = unit.ouid();
   //      _guid = unit.guid();
   //      _code = unit.code();
   //      _label = unit.label();
   //   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public FResTextureBitmap findBitmapByCode(String code){
      // 输出纹理位图集合
      int bitmapCount = _bitmaps.count();
      for(int i = 0; i < bitmapCount; i++){
         FResTextureBitmap bitmap = _bitmaps.get(i);
         if(code.equals(bitmap.code())){
            return bitmap;
         }
      }
      return null;
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   // <P>移动平台上透明通道会预乘处理，暂时无法解决，先全部使用JPG的RGB通道。</P>
   // <P>颜色文理diffuse可以使用透明PNG通道。</P>
   //
   // @param unit 数据单元
   //============================================================
   public void pack(){
      // 合并颜色纹理和透明纹理
      FResTextureBitmap diffuseBitmap = findBitmapByCode("diffuse");
      FResTextureBitmap alphaBitmap = findBitmapByCode("alpha");
      if((diffuseBitmap != null) || (alphaBitmap != null)){
         FResTextureBitmapPack bitmapPack = new FResTextureBitmapPack();
         if((diffuseBitmap != null) && (alphaBitmap != null)){
            bitmapPack.setOptionAlpha(true);
            bitmapPack.setCode("diffuse-alpha");
            bitmapPack.mergeRgb(diffuseBitmap);
            bitmapPack.mergeAlpha(alphaBitmap);
         }else if((diffuseBitmap != null) && (alphaBitmap == null)){
            bitmapPack.setCode("diffuse");
            bitmapPack.mergeRgb(diffuseBitmap, 0xFF);
         }else if((diffuseBitmap == null) && (alphaBitmap != null)){
            bitmapPack.setOptionAlpha(true);
            bitmapPack.setCode("alpha");
            bitmapPack.mergeAlpha(alphaBitmap, 0xFFFFFF);
         }
         _bitmapPacks.push(bitmapPack);
      }
      //............................................................
      // 合并法线纹理和高光级别纹理
      //      FRs3TextureBitmap normalBitmap = findBitmapByCode("normal");
      //      FRs3TextureBitmap specularLevelBitmap = findBitmapByCode("specular.level");
      //      if((normalBitmap != null) || (specularLevelBitmap != null)){
      //         FRs3TextureBitmapPack bitmapPack = new FRs3TextureBitmapPack();
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
      //      FRs3TextureBitmap specularBitmap = findBitmapByCode("specular");
      //      FRs3TextureBitmap heightBitmap = findBitmapByCode("height");
      //      if((specularBitmap != null) || (heightBitmap != null)){
      //         FRs3TextureBitmapPack bitmapPack = new FRs3TextureBitmapPack();
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
      FResTextureBitmap specularLevelBitmap = findBitmapByCode("specular.level");
      FResTextureBitmap reflectBitmap = findBitmapByCode("reflect");
      FResTextureBitmap heightBitmap = findBitmapByCode("height");
      if((specularLevelBitmap != null) || (reflectBitmap != null) || (heightBitmap != null)){
         FResTextureBitmapPack bitmapPack = new FResTextureBitmapPack();
         String code = "";
         if(specularLevelBitmap != null){
            code += "-specular.level";
            bitmapPack.mergeR(specularLevelBitmap);
         }else{
            code += "-";
         }
         if(reflectBitmap != null){
            code += "-reflect";
            bitmapPack.mergeG(reflectBitmap);
         }else{
            code += "-";
         }
         if(heightBitmap != null){
            code += "-height";
            bitmapPack.mergeB(heightBitmap);
         }else{
            code += "-";
         }
         bitmapPack.setCode(code.substring(1));
         _bitmapPacks.push(bitmapPack);
      }
      //............................................................
      // 合并光照纹理
      FResTextureBitmap lightBitmap = findBitmapByCode("light");
      FResTextureBitmap refractBitmap = findBitmapByCode("refract");
      FResTextureBitmap emissiveBitmap = findBitmapByCode("emissive");
      if((lightBitmap != null) || (refractBitmap != null) || (emissiveBitmap != null)){
         FResTextureBitmapPack bitmapPack = new FResTextureBitmapPack();
         String code = "";
         if(lightBitmap != null){
            code += "-light";
            bitmapPack.mergeR(lightBitmap);
         }else{
            code += "-";
         }
         if(refractBitmap != null){
            code += "-refract";
            bitmapPack.mergeG(refractBitmap);
         }else{
            code += "-";
         }
         if(emissiveBitmap != null){
            code += "-emissive";
            bitmapPack.mergeB(emissiveBitmap);
         }else{
            code += "-";
         }
         bitmapPack.setCode(code.substring(1));
         _bitmapPacks.push(bitmapPack);
      }
      //............................................................
      // 合并透明纹理和透明级别纹理
      //      FRs3TextureBitmap transmittanceColorBitmap = findBitmapByCode("transmittance.color");
      //      FRs3TextureBitmap transmittanceLevelBitmap = findBitmapByCode("transmittance.level");
      //      if((transmittanceColorBitmap != null) || (transmittanceLevelBitmap != null)){
      //         FRs3TextureBitmapPack bitmapPack = new FRs3TextureBitmapPack();
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
         FResTextureBitmap bitmap = _bitmaps.get(i);
         if(bitmap.bitmapPack() == null){
            FResTextureBitmapPack bitmapPack = new FResTextureBitmapPack();
            bitmapPack.setCode(bitmap.code());
            bitmapPack.setTextureBitmap(bitmap);
            _bitmapPacks.push(bitmapPack);
         }
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
      // 输出纹理位图集合
      int bitmapCount = _bitmaps.count();
      output.writeInt16((short)bitmapCount);
      for(int i = 0; i < bitmapCount; i++){
         FResTextureBitmap bitmap = _bitmaps.get(i);
         bitmap.serialize(output);
      }
      // 输出纹理位图打包集合
      int bitmapPackCount = _bitmapPacks.count();
      output.writeInt16((short)bitmapPackCount);
      for(int i = 0; i < bitmapPackCount; i++){
         FResTextureBitmapPack bitmapPack = _bitmapPacks.get(i);
         bitmapPack.serialize(output);
      }
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      // 设置属性
      _guid = xconfig.get("guid");
      _code = xconfig.get("code");
      _fullCode = xconfig.get("name");
      _label = xconfig.get("label");
      _keywords = xconfig.get("full_label");
      // 处理所有节点
      FXmlNode xbitmaps = xconfig.findNode("BitmapCollection");
      if(xbitmaps != null){
         for(FXmlNode xbitmap : xbitmaps){
            if(xbitmap.isName("Bitmap")){
               FResTextureBitmap bitmap = new FResTextureBitmap();
               bitmap.importConfig(xbitmap);
               _bitmaps.push(bitmap);
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
      // 设置属性
      xconfig.set("guid", _guid);
      xconfig.set("code", _code);
      xconfig.set("name", _fullCode);
      xconfig.set("label", _label);
      xconfig.set("keywords", _keywords);
      // 处理所有节点
      if(!_bitmaps.isEmpty()){
         FXmlNode xbitmaps = xconfig.createNode("BitmapCollection");
         for(FResTextureBitmap bitmap : _bitmaps){
            bitmap.saveConfig(xbitmaps.createNode("Bitmap"));
         }
      }
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   //   public void loadUnit(FDataResource3dTemplateUnit unit){
   //      // 加载属性
   //      _guid = unit.guid();
   //      _code = unit.code();
   //      // 读取配置
   //      FXmlDocument xdocument = new FXmlDocument();
   //      xdocument.loadString(unit.content());
   //      loadConfig(xdocument.root());
   //   }

   //============================================================
   // <T>从配置节点中导入数据信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void importConfig(FXmlNode xconfig){
      FXmlNode xtexture = xconfig.findNode("Texture");
      // 设置属性
      _code = xtexture.get("code");
      _fullCode = xtexture.get("name");
      _label = xtexture.get("label");
      _keywords = xtexture.get("full_label");
      // 处理所有节点
      for(FXmlNode xnode : xtexture){
         if(xnode.isName("Bitmap")){
            FResTextureBitmap bitmap = new FResTextureBitmap();
            bitmap.importConfig(xnode);
            _bitmaps.push(bitmap);
         }
      }
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public String toXml(){
      FXmlNode xconfig = new FXmlNode("Texture");
      saveConfig(xconfig);
      return xconfig.xml().toString();
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      FXmlNode xconfig = new FXmlNode("Texture");
      saveConfig(xconfig);
      return xconfig.xml().toString();
   }
}

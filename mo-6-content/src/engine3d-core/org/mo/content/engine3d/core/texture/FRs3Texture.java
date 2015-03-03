package org.mo.content.engine3d.core.texture;

import com.cyou.gccloud.data.data.FDataResource3dTextureUnit;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.content.resource3d.common.FRs3Object;

//============================================================
// <T>资源纹理。</T>
//============================================================
public class FRs3Texture
      extends FRs3Object
{
   // 资源位图集合
   protected FObjects<FRs3TextureBitmap> _bitmaps = new FObjects<FRs3TextureBitmap>(FRs3TextureBitmap.class);

   // 资源位图打包集合
   protected FObjects<FRs3TextureBitmapPack> _bitmapPacks = new FObjects<FRs3TextureBitmapPack>(FRs3TextureBitmapPack.class);

   //============================================================
   // <T>构造资源纹理。</T>
   //============================================================
   public FRs3Texture(){
   }

   //============================================================
   // <T>获得资源位图集合。</T>
   //
   // @return 资源位图集合
   //============================================================
   public FObjects<FRs3TextureBitmap> bitmaps(){
      return _bitmaps;
   }

   //============================================================
   // <T>获得资源位图打包集合。</T>
   //
   // @return 资源位图打包集合
   //============================================================
   public FObjects<FRs3TextureBitmapPack> bitmapPacks(){
      return _bitmapPacks;
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dTextureUnit unit){
      // 加载属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _label = unit.label();
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public FRs3TextureBitmap findBitmapByCode(String code){
      // 输出纹理位图集合
      int bitmapCount = _bitmaps.count();
      for(int i = 0; i < bitmapCount; i++){
         FRs3TextureBitmap bitmap = _bitmaps.get(i);
         if(code.equals(bitmap.code())){
            return bitmap;
         }
      }
      return null;
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void pack(){
      // 合并颜色纹理和透明纹理
      FRs3TextureBitmap diffuseBitmap = findBitmapByCode("diffuse");
      FRs3TextureBitmap alphaBitmap = findBitmapByCode("alpha");
      if((diffuseBitmap != null) || (alphaBitmap != null)){
         FRs3TextureBitmapPack bitmapPack = new FRs3TextureBitmapPack();
         if((diffuseBitmap != null) && (alphaBitmap != null)){
            bitmapPack.setOptionAlpha(true);
            bitmapPack.setCode("diffuse|alpha");
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
      FRs3TextureBitmap normalBitmap = findBitmapByCode("normal");
      FRs3TextureBitmap specularLevelBitmap = findBitmapByCode("specular.level");
      if((normalBitmap != null) || (specularLevelBitmap != null)){
         FRs3TextureBitmapPack bitmapPack = new FRs3TextureBitmapPack();
         if((normalBitmap != null) && (specularLevelBitmap != null)){
            bitmapPack.setOptionAlpha(true);
            bitmapPack.setCode("normal|specular.level");
            bitmapPack.mergeRgb(normalBitmap);
            bitmapPack.mergeAlpha(specularLevelBitmap);
         }else if((normalBitmap != null) && (specularLevelBitmap == null)){
            bitmapPack.setCode("normal");
            bitmapPack.mergeRgb(normalBitmap, 0xFF);
         }else if((normalBitmap == null) && (specularLevelBitmap != null)){
            bitmapPack.setOptionAlpha(true);
            bitmapPack.setCode("specular.level");
            bitmapPack.mergeAlpha(specularLevelBitmap);
         }
         _bitmapPacks.push(bitmapPack);
      }
      //............................................................
      // 合并高光纹理和高度纹理
      FRs3TextureBitmap specularBitmap = findBitmapByCode("specular");
      FRs3TextureBitmap heightBitmap = findBitmapByCode("height");
      if((specularBitmap != null) || (heightBitmap != null)){
         FRs3TextureBitmapPack bitmapPack = new FRs3TextureBitmapPack();
         if((specularBitmap != null) && (heightBitmap != null)){
            bitmapPack.setCode("specular|height");
            bitmapPack.mergeRgb(specularBitmap);
            bitmapPack.mergeAlpha(heightBitmap);
         }else if((specularBitmap != null) && (heightBitmap == null)){
            bitmapPack.setCode("specular");
            bitmapPack.mergeRgb(specularBitmap, 0xFF);
         }else if((specularBitmap == null) && (heightBitmap != null)){
            bitmapPack.setCode("height");
            bitmapPack.mergeAlpha(heightBitmap);
         }
         _bitmapPacks.push(bitmapPack);
      }
      //............................................................
      // 合并光照纹理
      FRs3TextureBitmap lightBitmap = findBitmapByCode("light");
      FRs3TextureBitmap reflectBitmap = findBitmapByCode("reflect");
      FRs3TextureBitmap refractBitmap = findBitmapByCode("refract");
      FRs3TextureBitmap emissiveBitmap = findBitmapByCode("emissive");
      if((lightBitmap != null) || (reflectBitmap != null) || (refractBitmap != null) || (emissiveBitmap != null)){
         FRs3TextureBitmapPack bitmapPack = new FRs3TextureBitmapPack();
         String code = "";
         if(lightBitmap != null){
            code += "|light";
            bitmapPack.mergeR(lightBitmap);
         }
         if(reflectBitmap != null){
            code += "|reflect";
            bitmapPack.mergeG(reflectBitmap);
         }
         if(refractBitmap != null){
            code += "|refract";
            bitmapPack.mergeB(refractBitmap);
         }
         if(emissiveBitmap != null){
            bitmapPack.setOptionAlpha(true);
            code += "|emissive";
            bitmapPack.mergeG(emissiveBitmap);
         }
         bitmapPack.setCode(code.substring(1));
         _bitmapPacks.push(bitmapPack);
      }
      //............................................................
      // 合并透明纹理和透明级别纹理
      FRs3TextureBitmap transmittanceColorBitmap = findBitmapByCode("transmittance.color");
      FRs3TextureBitmap transmittanceLevelBitmap = findBitmapByCode("transmittance.level");
      if((transmittanceColorBitmap != null) || (transmittanceLevelBitmap != null)){
         FRs3TextureBitmapPack bitmapPack = new FRs3TextureBitmapPack();
         if((transmittanceColorBitmap != null) && (transmittanceLevelBitmap != null)){
            bitmapPack.setOptionAlpha(true);
            bitmapPack.setCode("transmittance.color|transmittance.level");
            bitmapPack.mergeRgb(transmittanceColorBitmap);
            bitmapPack.mergeAlpha(transmittanceLevelBitmap);
         }else if((transmittanceColorBitmap != null) && (transmittanceLevelBitmap != null)){
            bitmapPack.setCode("transmittance.color");
            bitmapPack.mergeRgb(transmittanceColorBitmap, 0xFF);
         }else if((transmittanceColorBitmap != null) && (transmittanceLevelBitmap != null)){
            bitmapPack.setOptionAlpha(true);
            bitmapPack.setCode("transmittance.level");
            bitmapPack.mergeAlpha(transmittanceLevelBitmap);
         }
         _bitmapPacks.push(bitmapPack);
      }
      //............................................................
      // 输出其余纹理集合
      int bitmapCount = _bitmaps.count();
      for(int i = 0; i < bitmapCount; i++){
         FRs3TextureBitmap bitmap = _bitmaps.get(i);
         if(bitmap.bitmapPack() == null){
            FRs3TextureBitmapPack bitmapPack = new FRs3TextureBitmapPack();
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
         FRs3TextureBitmap bitmap = _bitmaps.get(i);
         bitmap.serialize(output);
      }
      // 输出纹理位图打包集合
      int bitmapPackCount = _bitmapPacks.count();
      output.writeInt16((short)bitmapPackCount);
      for(int i = 0; i < bitmapPackCount; i++){
         FRs3TextureBitmapPack bitmapPack = _bitmapPacks.get(i);
         bitmapPack.serialize(output);
      }
   }
}

package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源模型。</T>
//============================================================
public class FRs3Material
      extends FObject
{
   // 分组唯一代码
   protected String _groupGuid;

   // 代码
   protected String _code;

   // 唯一代码
   protected String _guid;

   // 效果代码
   protected String _effectCode;

   // 配置双面
   protected int _optionDouble;

   // 环境颜色
   protected SFloatColor3 _ambientColor = new SFloatColor3();

   // 散射颜色
   protected SFloatColor3 _diffuseColor = new SFloatColor3();

   // 高光颜色
   protected SFloatColor3 _specularColor = new SFloatColor3();

   // 高光级别
   protected float _specularLevel;

   // 网格集合
   protected FObjects<FRs3MaterialBitmap> _bitmaps = new FObjects<FRs3MaterialBitmap>(FRs3MaterialBitmap.class);

   // 网格集合
   protected FObjects<FRs3MaterialTexture> _textures = new FObjects<FRs3MaterialTexture>(FRs3MaterialTexture.class);

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Material(){
      _guid = RUuid.makeUniqueId();
   }

   //============================================================
   // <T>获得分组唯一代码。</T>
   //
   // @return 分组唯一代码
   //============================================================
   public String groupGuid(){
      return _groupGuid;
   }

   //============================================================
   // <T>设置分组唯一代码。</T>
   //
   // @param groupGuid 分组唯一代码
   //============================================================
   public void setGroupGuid(String groupGuid){
      _groupGuid = groupGuid;
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>获得环境颜色。</T>
   //
   // @return 环境颜色
   //============================================================
   public SFloatColor3 ambientColor(){
      return _ambientColor;
   }

   //============================================================
   // <T>获得散射颜色。</T>
   //
   // @return 散射颜色
   //============================================================
   public SFloatColor3 diffuseColor(){
      return _diffuseColor;
   }

   //============================================================
   // <T>获得高光颜色。</T>
   //
   // @return 高光颜色
   //============================================================
   public SFloatColor3 specularColor(){
      return _specularColor;
   }

   //============================================================
   // <T>获得高光级别。</T>
   //
   // @return 高光级别
   //============================================================
   public float _specularLevel(){
      return _specularLevel;
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FRs3MaterialBitmap> bitmaps(){
      return _bitmaps;
   }

   //============================================================
   // <T>获得纹理集合。</T>
   //
   // @return 纹理集合
   //============================================================
   public FObjects<FRs3MaterialTexture> textures(){
      return _textures;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 输出属性
      output.writeString(_guid);
      output.writeString(_groupGuid);
      output.writeString(_effectCode);
      _ambientColor.serialize(output);
      _diffuseColor.serialize(output);
      _specularColor.serialize(output);
      output.writeFloat(_specularLevel);
      // 输出纹理集合
      int textureCount = _textures.count();
      output.writeInt16((short)textureCount);
      for(int i = 0; i < textureCount; i++){
         FRs3MaterialTexture texture = _textures.get(i);
         texture.serialize(output);
      }
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _guid = xconfig.get("guid");
      _groupGuid = xconfig.get("group_guid");
      _effectCode = xconfig.get("effect_code");
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Ambient")){
            _ambientColor.loadConfig(xnode);
         }else if(xnode.isName("Diffuse")){
            _diffuseColor.loadConfig(xnode);
         }else if(xnode.isName("Specular")){
            _specularColor.loadConfig(xnode);
            _specularLevel = xnode.getFloat("level");
         }else if(xnode.isName("TextureCollection")){
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Texture")){
                  FRs3MaterialTexture texture = new FRs3MaterialTexture();
                  texture.loadConfig(xchild);
                  _textures.push(texture);
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
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("guid", _guid);
      xconfig.set("group_guid", _groupGuid);
      xconfig.set("effect_code", _effectCode);
      // 存储颜色
      _ambientColor.saveConfig(xconfig.createNode("Ambient"));
      _diffuseColor.saveConfig(xconfig.createNode("Diffuse"));
      FXmlNode xspecular = xconfig.createNode("Specular");
      _specularColor.saveConfig(xspecular);
      xspecular.set("level", _specularLevel);
      // 存储纹理集合
      FXmlNode xtextures = xconfig.createNode("TextureCollection");
      for(FRs3MaterialTexture texture : _textures){
         texture.saveConfig(xtextures.createNode("Texture"));
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
      _effectCode = xconfig.get("effect_code");
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Ambient")){
            _ambientColor.importConfig(xnode);
         }else if(xnode.isName("Diffuse")){
            _diffuseColor.importConfig(xnode);
         }else if(xnode.isName("Specular")){
            _specularColor.importConfig(xnode);
            _specularLevel = xnode.getFloat("level");
         }else if(xnode.isName("TextureCollection")){
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Texture")){
                  FRs3MaterialTexture texture = new FRs3MaterialTexture();
                  texture.importConfig(xchild);
                  _textures.push(texture);
               }
            }
         }
      }
   }
}

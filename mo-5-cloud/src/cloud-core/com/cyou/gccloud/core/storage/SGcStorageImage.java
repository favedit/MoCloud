package com.cyou.gccloud.core.storage;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>存储图片信息。</T>
//============================================================
public class SGcStorageImage
{
   // 设备
   protected int _deviceCd;

   // 质量
   protected int _qualityCd;

   // 质量代码
   protected String _qualityCode;

   // 质量参数
   protected String _qualityParameter;

   // 显示
   protected int _displayCd;

   // 命令
   protected String _action;

   // 高度
   protected int _width;

   // 高度
   protected int _height;

   // 圆角
   protected int _round;

   // 后缀
   protected String _extension;

   //============================================================
   // <T>构造存储图片信息。</T>
   //============================================================
   public SGcStorageImage(){
   }

   //============================================================
   // <T>获得设备。</T>
   //
   // @return 设备
   //============================================================
   public int deviceCd(){
      return _deviceCd;
   }

   //============================================================
   // <T>设置设备。</T>
   //
   // @param device 设备
   //============================================================
   public void setDeviceCd(int deviceCd){
      _deviceCd = deviceCd;
   }

   //============================================================
   // <T>获得质量。</T>
   //
   // @return 质量
   //============================================================
   public int qualityCd(){
      return _qualityCd;
   }

   //============================================================
   // <T>设置质量。</T>
   //
   // @param quality 质量
   //============================================================
   public void setQualityCd(int qualityCd){
      _qualityCd = qualityCd;
   }

   //============================================================
   // <T>获得质量代码。</T>
   //
   // @return 质量代码
   //============================================================
   public String qualityCode(){
      return _qualityCode;
   }

   //============================================================
   // <T>获得质量参数。</T>
   //
   // @return 质量参数
   //============================================================
   public String qualityParameter(){
      return _qualityParameter;
   }

   //============================================================
   // <T>获得显示。</T>
   //
   // @return 显示
   //============================================================
   public int displayCd(){
      return _displayCd;
   }

   //============================================================
   // <T>设置显示。</T>
   //
   // @param displayCd 显示
   //============================================================
   public void setDisplayCd(int displayCd){
      _displayCd = displayCd;
   }

   //============================================================
   // <T>获得命令。</T>
   //
   // @return 命令
   //============================================================
   public String action(){
      return _action;
   }

   //============================================================
   // <T>设置命令。</T>
   //
   // @param width 命令
   //============================================================
   public void setAction(String action){
      _action = action;
   }

   //============================================================
   // <T>获得宽度。</T>
   //
   // @return 宽度
   //============================================================
   public int width(){
      return _width;
   }

   //============================================================
   // <T>设置宽度。</T>
   //
   // @param width 宽度
   //============================================================
   public void setWidth(int width){
      _width = width;
   }

   //============================================================
   // <T>获得高度。</T>
   //
   // @return 高度
   //============================================================
   public int height(){
      return _height;
   }

   //============================================================
   // <T>设置高度。</T>
   //
   // @param height 高度
   //============================================================
   public void setHeight(int height){
      _height = height;
   }

   //============================================================
   // <T>获得圆角。</T>
   //
   // @return 圆角
   //============================================================
   public int round(){
      return _round;
   }

   //============================================================
   // <T>设置圆角。</T>
   //
   // @param round 圆角
   //============================================================
   public void setRound(int round){
      _round = round;
   }

   //============================================================
   // <T>获得后缀。</T>
   //
   // @return 后缀
   //============================================================
   public String extension(){
      return _extension;
   }

   //============================================================
   // <T>从配置节点中加载信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      //      _deviceCd = EGcStorageDevice.parse(xconfig.get("device"));
      //      _qualityCd = EGcStorageQuality.parse(xconfig.get("quality"));
      //      _displayCd = EGcStorageDisplay.parse(xconfig.get("display"));
      _action = xconfig.get("action");
      _width = xconfig.getInt("width");
      _height = xconfig.getInt("height");
      _round = xconfig.getInt("round");
      _extension = "_" + _width + "x" + _height + "_" + _round + ".png";
      _qualityCode = _action + "_" + _width + "_" + _height + "_" + _round;
      _qualityParameter = "&s=" + _action + "_" + _width + "_" + _height + "_" + _round;
   }

   //============================================================
   // <T>生成打包字符串。</T>
   //
   // @return 打包字符串
   //============================================================
   public String pack(){
      return _action + "|" + _width + "|" + _height + "|" + _round;
   }

   //============================================================
   // <T>解包打包字符串。</T>
   //
   // @param pack 打包字符串
   //============================================================
   public void unpack(String pack){
      if(!RString.isEmpty(pack)){
         String[] items = RString.split(pack, '|');
         if(items.length == 4){
            _action = items[0];
            _width = RInteger.parse(items[1]);
            _height = RInteger.parse(items[2]);
            _round = RInteger.parse(items[3]);
            return;
         }
      }
      throw new FFatalError("Unpack data failure. (pack={1})", pack);
   }

   //============================================================
   // <T>获得运行信息。</T>
   //
   // @return 运行信息
   //============================================================
   public String dump(){
      return _action + ":" + _width + "x" + _height + "-" + _round;
   }
}

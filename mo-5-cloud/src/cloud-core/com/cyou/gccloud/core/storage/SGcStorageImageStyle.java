package com.cyou.gccloud.core.storage;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.net.EMime;

//============================================================
// <T>存储图片样式。</T>
//============================================================
public class SGcStorageImageStyle
{
   // 命令
   protected String _action;

   // 高度
   protected int _width;

   // 高度
   protected int _height;

   // 圆角
   protected int _round;

   //============================================================
   // <T>构造存储图片样式。</T>
   //============================================================
   public SGcStorageImageStyle(){
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
   // <T>获得支持透明。</T>
   //
   // @return 支持透明
   //============================================================
   public boolean supportAlpha(){
      if(_round != 0){
         return true;
      }
      return false;
   }

   //============================================================
   // <T>获得格式。</T>
   //
   // @return 格式
   //============================================================
   public EMime mimeCd(){
      if(_round != 0){
         return EMime.Png;
      }
      return EMime.Jpg;
   }

   //============================================================
   // <T>生成打包字符串。</T>
   //
   // @return 打包字符串
   //============================================================
   public String pack(){
      return _action + "_" + _width + "_" + _height + "_" + _round;
   }

   //============================================================
   // <T>解包打包字符串。</T>
   //
   // @param pack 打包字符串
   //============================================================
   public void unpack(String pack){
      if(!RString.isEmpty(pack)){
         String[] items = RString.split(pack, '_');
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
}

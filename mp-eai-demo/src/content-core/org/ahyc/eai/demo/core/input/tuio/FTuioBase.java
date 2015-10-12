package org.ahyc.eai.demo.core.input.tuio;

import org.mo.com.geom.SFloatPoint2;
import org.mo.com.lang.FObject;

//============================================================
// <T>TUIO基础类。</T>
//============================================================
public class FTuioBase
      extends FObject
{
   // 会话编号
   protected long _sessionId;

   // 编号
   protected int _id;

   // 位置
   protected SFloatPoint2 _position = new SFloatPoint2();

   //============================================================
   // <T>构造TUIO游标。</T>
   //============================================================
   public FTuioBase(){
   }

   //============================================================
   // <T>检查是否有效。</T>
   //
   // @return 是否有效
   //============================================================
   public boolean isValid(){
      if(_position.x == Float.NaN){
         return false;
      }
      if(_position.y == Float.NaN){
         return false;
      }
      return true;
   }

   //============================================================
   // <T>获得会话编号。</T>
   //
   // @return 会话编号
   //============================================================
   public long sessionId(){
      return _sessionId;
   }

   //============================================================
   // <T>获得编号。</T>
   //
   // @return 编号
   //============================================================
   public int id(){
      return _id;
   }

   //============================================================
   // <T>获得位置。</T>
   //
   // @return 位置
   //============================================================
   public SFloatPoint2 position(){
      return _position;
   }
}

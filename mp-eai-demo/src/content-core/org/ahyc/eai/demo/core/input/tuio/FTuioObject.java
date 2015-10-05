package org.ahyc.eai.demo.core.input.tuio;

import TUIO.TuioObject;

//============================================================
// <T>TUIO对象。</T>
//============================================================
public class FTuioObject
      extends FTuioBase
{
   //============================================================
   // <T>构造TUIO对象。</T>
   //============================================================
   public FTuioObject(){
   }

   //============================================================
   // <T>构造TUIO游标。</T>
   //
   // @param value 内容
   //============================================================
   public FTuioObject(TuioObject value){
      set(value);
   }

   //============================================================
   // <T>设置内容。</T>
   //
   // @param value 内容
   //============================================================
   public void set(TuioObject value){
      _sessionId = value.getSessionID();
      _id = value.getSymbolID();
      _position.set(value.getX(), value.getY());
   }
}

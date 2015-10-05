package org.ahyc.eai.demo.core.input.tuio;

import TUIO.TuioBlob;

//============================================================
// <T>TUIO数据。</T>
//============================================================
public class FTuioBlob
      extends FTuioBase
{
   //============================================================
   // <T>构造TUIO游标。</T>
   //============================================================
   public FTuioBlob(){
   }

   //============================================================
   // <T>构造TUIO游标。</T>
   //
   // @param value 内容
   //============================================================
   public FTuioBlob(TuioBlob value){
      set(value);
   }

   //============================================================
   // <T>设置内容。</T>
   //
   // @param value 内容
   //============================================================
   public void set(TuioBlob value){
      _sessionId = value.getSessionID();
      _id = value.getBlobID();
      _position.set(value.getX(), value.getY());
   }
}

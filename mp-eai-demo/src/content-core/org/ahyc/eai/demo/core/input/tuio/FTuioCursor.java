package org.ahyc.eai.demo.core.input.tuio;

import TUIO.TuioCursor;

//============================================================
// <T>TUIO游标。</T>
//============================================================
public class FTuioCursor
      extends FTuioBase
{
   //============================================================
   // <T>构造TUIO游标。</T>
   //============================================================
   public FTuioCursor(){
   }

   //============================================================
   // <T>构造TUIO游标。</T>
   //
   // @param value 内容
   //============================================================
   public FTuioCursor(TuioCursor value){
      set(value);
   }

   //============================================================
   // <T>设置内容。</T>
   //
   // @param value 内容
   //============================================================
   public void set(TuioCursor value){
      _sessionId = value.getSessionID();
      _id = value.getCursorID();
      _position.set(value.getX(), value.getY());
   }
}

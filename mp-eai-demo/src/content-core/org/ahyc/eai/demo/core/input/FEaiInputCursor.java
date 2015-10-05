package org.ahyc.eai.demo.core.input;

import TUIO.TuioCursor;
import org.ahyc.eai.demo.core.input.tuio.FTuioCursor;

//============================================================
// <T>输入游标。</T>
//============================================================
public class FEaiInputCursor
      extends FTuioCursor
{
   //============================================================
   // <T>构造输入游标。</T>
   //============================================================
   public FEaiInputCursor(){
   }

   //============================================================
   // <T>构造输入游标。</T>
   //
   // @param value 内容
   //============================================================
   public FEaiInputCursor(TuioCursor value){
      set(value);
   }
}

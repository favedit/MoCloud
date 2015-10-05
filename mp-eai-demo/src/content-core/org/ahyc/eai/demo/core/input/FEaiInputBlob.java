package org.ahyc.eai.demo.core.input;

import TUIO.TuioBlob;
import org.ahyc.eai.demo.core.input.tuio.FTuioBlob;

//============================================================
// <T>输入数据。</T>
//============================================================
public class FEaiInputBlob
      extends FTuioBlob
{
   //============================================================
   // <T>构造输入数据。</T>
   //============================================================
   public FEaiInputBlob(){
   }

   //============================================================
   // <T>构造输入数据。</T>
   //
   // @param value 内容
   //============================================================
   public FEaiInputBlob(TuioBlob value){
      set(value);
   }
}

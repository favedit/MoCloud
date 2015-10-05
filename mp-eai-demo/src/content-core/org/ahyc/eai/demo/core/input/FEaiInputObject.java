package org.ahyc.eai.demo.core.input;

import TUIO.TuioObject;
import org.ahyc.eai.demo.core.input.tuio.FTuioObject;

//============================================================
// <T>输入对象。</T>
//============================================================
public class FEaiInputObject
      extends FTuioObject
{
   //============================================================
   // <T>构造输入对象。</T>
   //============================================================
   public FEaiInputObject(){
   }

   //============================================================
   // <T>构造输入对象。</T>
   //
   // @param value 内容
   //============================================================
   public FEaiInputObject(TuioObject value){
      set(value);
   }
}

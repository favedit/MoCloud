package org.mo.eng.parser.common;

public class FSourceFile
{
   private FSourceBlocks _blocks;

   public FSourceBlocks blocks(){
      if(null == _blocks){
         _blocks = new FSourceBlocks();
      }
      return _blocks;
   }
}

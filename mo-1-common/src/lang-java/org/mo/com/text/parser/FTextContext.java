package org.mo.com.text.parser;

import org.mo.com.lang.FObject;

//============================================================
// <T>文本环境。</T>
//============================================================
public class FTextContext
      extends FObject
      implements
         ITextContext
{
   // 行分隔符
   protected String LineSplitters = "\r\n";

   // 分隔符
   protected String Splitters = "\r\n";

   // 文本行集合
   protected FTextLines _lines = new FTextLines();

   //============================================================
   // <T>文本环境。</T>
   //============================================================
   public FTextContext(){
   }

   //============================================================
   // <T>判断是否行分隔。</T>
   //
   // @param value 字符
   // @return 是否行分隔
   //============================================================
   @Override
   public boolean isLineSplitter(char value){
      return (-1 != LineSplitters.indexOf(value));
   }

   //============================================================
   // <T>判断是否行注释。</T>
   //
   // @param line 文本行
   // @return 是否行注释
   //============================================================
   @Override
   public boolean isLineComment(String line){
      return line.startsWith("//");
   }

   //============================================================
   // <T>判断是否块开始。</T>
   //
   // @param value 字符
   // @return 是否块开始
   //============================================================
   @Override
   public boolean isTokenBegin(char value){
      return ('{' == value);
   }

   //============================================================
   // <T>判断是否块结束。</T>
   //
   // @param value 字符
   // @return 是否块结束
   //============================================================
   @Override
   public boolean isTokenEnd(char value){
      return ('}' == value);
   }

   //============================================================
   // <T>判断是否分隔符。</T>
   //
   // @param value 字符
   // @return 是否分隔符
   //============================================================
   @Override
   public boolean isSplitter(char value){
      return (-1 != Splitters.indexOf(value));
   }

   //============================================================
   // <T>获得所有文本行。</T>
   //
   // @return 文本行
   //============================================================
   @Override
   public FTextLines lines(){
      return _lines;
   }
}

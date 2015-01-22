package org.mo.com.text.parser;

import org.mo.com.lang.FObject;
import org.mo.com.lang.FStrings;

//============================================================
// <T>文本注释。</T>
//============================================================
public class FTextComment
      extends FObject
{
   // 代码
   protected FStrings _sourceLines = new FStrings();

   //============================================================
   // <T>文本注释。</T>
   //============================================================
   public FTextComment(){
   }

   //============================================================
   // <T>判断是否含有行。</T>
   //
   // @return 是否含有行
   //============================================================
   public boolean hasSource(){
      if(_sourceLines == null){
         return false;
      }
      return !_sourceLines.isEmpty();
   }

   //============================================================
   // <T>获得来源行集合。</T>
   //
   // @return 行集合
   //============================================================
   public FStrings sourceLines(){
      return _sourceLines;
   }

   //============================================================
   // <T>增加注释字符串。</T>
   //============================================================
   public void assign(FTextComment comment){
      _sourceLines.assign(comment.sourceLines());
   }

   //============================================================
   // <T>增加注释字符串。</T>
   //============================================================
   public void push(String line){
      _sourceLines.push(line);
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return _sourceLines.join('\n');
   }
}

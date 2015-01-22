package org.mo.com.text.parser;

import org.mo.com.lang.FObject;
import org.mo.com.lang.FString;

//============================================================
// <T>文本解析器。</T>
//============================================================
public class FTextParser
      extends FObject
{
   // 文本环境
   protected FTextContext _context = new FTextContext();

   // 文本节点
   protected FTextToken _token = new FTextToken();

   //============================================================
   // <T>构造文本解析器。</T>
   //============================================================
   public FTextParser(){
   }

   //============================================================
   // <T>获得文本环境。</T>
   //
   // @return 文本环境
   //============================================================
   public FTextContext context(){
      return _context;
   }

   //============================================================
   // <T>设置文本环境。</T>
   //
   // @param context 文本环境
   //============================================================
   public void setContext(FTextContext context){
      _context = context;
   }

   //============================================================
   // <T>获得文本节点。</T>
   //
   // @return 文本节点
   //============================================================
   public FTextToken token(){
      return _token;
   }

   //============================================================
   // <T>解析文本内容。</T>
   //
   // @param source 文本内容
   //============================================================
   public void parse(String source){
      // 格式化代码，分隔成行
      int n = -1;
      int end = source.length();
      FString code = new FString();
      FTextLines lines = _context.lines();
      while(++n < end){
         char value = source.charAt(n);
         if(_context.isLineSplitter(value)){
            if(!code.isEmpty()){
               FTextLine line = new FTextLine();
               line.load(lines.count(), code.toString());
               lines.push(line);
               code.clear();
            }
         }else{
            code.append(value);
         }
      }
      if(!code.isEmpty()){
         FTextLine line = new FTextLine();
         line.load(lines.count(), code.toString());
         lines.push(line);
         code.clear();
      }
      // 格式化代码，分隔成树
      _token.setContext(_context);
      _token.parse(source);
   }
}

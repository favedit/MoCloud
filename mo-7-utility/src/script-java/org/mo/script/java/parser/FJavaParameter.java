package org.mo.script.java.parser;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.TDumpInfo;
import org.mo.com.text.parser.FTextComment;
import org.mo.com.text.parser.FTextSource;
import org.mo.com.xml.FXmlNode;
import org.mo.script.java.converter.FJavaConvertContent;

//============================================================
// <T>参数对象。</T>
//============================================================
public class FJavaParameter
      extends FJavaObject
{
   // 函数
   protected FJavaFunction _function;

   // 类型名称
   protected String _typeName;

   // 类型名称
   protected String _typeFullName;

   // 默认内容
   protected String _defaultValue;

   //============================================================
   // <T>构造参数对象。</T>
   //============================================================
   public FJavaParameter(){
   }

   //============================================================
   // <T>获得函数。</T>
   //
   // @return 函数
   //============================================================
   public FJavaFunction function(){
      return _function;
   }

   //============================================================
   // <T>设置函数。</T>
   //
   // @param function 函数
   //============================================================
   public void setFunction(FJavaFunction function){
      _function = function;
   }

   //============================================================
   // <T>获得类型名称。</T>
   //
   // @return 类型名称
   //============================================================
   public String typeName(){
      return _typeName;
   }

   //============================================================
   // <T>获得默认内容。</T>
   //
   // @return 默认内容
   //============================================================
   public String defaultValue(){
      return _defaultValue;
   }

   //============================================================
   // <T>构造参数对象。</T>
   //============================================================
   public void parse(FJavaParserContent content,
                     String line){
      // 分解内容
      String[] items = RString.split(line, ' ');
      if(items.length != 2){
         throw new FFatalError("Unknown parse line.");
      }
      _typeName = RString.trim(items[0]);
      _name = RString.trim(items[1]);
      // 查找类
      FJavaClass clazz = _function.clazz();
      _typeFullName = clazz.makeTypeName(content, _typeName);
      if(RString.isEmpty(_typeFullName)){
         throw new FFatalError("Full type name is empty.");
      }
   }

   //============================================================
   // <T>构造参数对象。</T>
   //============================================================
   public void parseComment(FJavaParserContent content,
                            FTextComment comment){
      for(String line : comment.sourceLines()){
         String find = "@param " + _name;
         int index = line.indexOf(find);
         if(index != -1){
            _label = line.substring(index + find.length()).trim();
            break;
         }
      }
   }

   //============================================================
   // <T>转换代码内容。</T>
   //
   // @param content 转换环境
   // @param source 代码内容
   //============================================================
   public void convert(FJavaConvertContent content,
                       FTextSource source){
      source.append(_typeFullName);
      source.append(" ");
      source.append(_name);
   }

   //============================================================
   // <T>保存设置信息。</T>
   //
   // @param xconfig 设置节点
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 保存属性
      xconfig.set("type_name", _typeName);
   }

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      info.appendIndent();
      info.append("Parameter [ ");
      info.append(_typeName);
      info.append(' ');
      info.append(_name);
      if(!RString.isEmpty(_label)){
         info.append(" ");
         info.append(_label);
      }
      info.append(" ]");
      return info;
   }
}

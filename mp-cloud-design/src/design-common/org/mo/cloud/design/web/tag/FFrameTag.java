package org.mo.cloud.design.web.tag;

import org.mo.cloud.content.design.frame.IFrameConsole;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.RAop;
import org.mo.web.tag.control.FBaseFormTag;

//============================================================
// <T>表单标签。</T>
//============================================================
public class FFrameTag
      extends FBaseFormTag
{
   //============================================================
   // <T>开始处理。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public int onStart(){
      // 获得来源
      String name = _context.parseString(_name);
      String frameName = _context.parseString(_source);
      if(RString.isEmpty(frameName)){
         throw new FFatalError("Parse source empty. (source={1})", _source);
      }
      // 获得定义
      IFrameConsole console = RAop.find(IFrameConsole.class);
      FXmlNode xframe = console.buildConfig("system", frameName);
      if(xframe == null){
         throw new FFatalError("Form is not exists. (source={1}, form_name={2})", _source, frameName);
      }
      // 输出内容
      _writer.appendLine("<SCRIPT id='", name, "' type='application/xml'>");
      _writer.appendLine(xframe.xml());
      _writer.append("</SCRIPT>");
      _writer.flush();
      return SKIP_BODY;
   }

   //============================================================
   // <T>结束处理。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public int onEnd(){
      return EVAL_PAGE;
   }
}

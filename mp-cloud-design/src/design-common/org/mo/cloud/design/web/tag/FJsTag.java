package org.mo.cloud.design.web.tag;

import org.mo.web.tag.base.FBaseJsTag;

//============================================================
// <T>JS脚本标签。</T>
//
// @history MAOCY 150318 创建
//============================================================
public class FJsTag
      extends FBaseJsTag
{
   //============================================================
   // <T>标签开始逻辑。</T>
   //
   // @return 逻辑执行后的状态
   //============================================================
   @Override
   public int onStart(){
      String language = _context.session().culture().country().language();
      // 输出脚本
      _writer.append("<SCRIPT language='javascript' src='");
      _writer.append(_context.contextPath("/ajs/mo.js"));
      _writer.appendLine("'></SCRIPT>");
      // 输出脚本
      _writer.append("<SCRIPT language='javascript' src='");
      _writer.append(_context.contextPath("/ajs/context_" + language.toLowerCase() + ".js"));
      _writer.appendLine("'></SCRIPT>");
      // 刷新数据
      _writer.flush();
      return SKIP_BODY;
   }

   //============================================================
   // <T>标签结束逻辑。</T>
   //
   // @return 逻辑执行后的状态
   //============================================================
   @Override
   public int onEnd(){
      return EVAL_PAGE;
   }
}

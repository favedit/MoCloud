package org.mo.cloud.design.web.tag;

import org.mo.web.tag.base.FBaseCssTag;

//============================================================
// <T>样式表标签。</T>
//
// @history MAOCY 150318 创建
//============================================================
public class FCssTag
      extends FBaseCssTag
{
   //============================================================
   // <T>标签开始逻辑。</T>
   //
   // @return 逻辑执行后的状态
   //============================================================
   @Override
   public int onStart(){
      // 输出样式
      _writer.append("<LINK rel='stylesheet' href='");
      _writer.append(_context.contextPath("/acs/control.css"));
      _writer.appendLine("' type='text/css'>");
      // 输出样式
      _writer.append("<LINK rel='stylesheet' href='");
      _writer.append(_context.contextPath("#/acs/control.css"));
      _writer.appendLine("' type='text/css'>");
      // 输出样式
      _writer.append("<LINK rel='stylesheet' href='");
      String language = _context.session().culture().country().language();
      String src = "#/acs/lang_" + language.toLowerCase() + ".css";
      _writer.append(_context.contextPath(src));
      _writer.appendLine("' type='text/css'>");
      // 输出样式
      _writer.append("<LINK rel='stylesheet' href='");
      src = "#/acs/site_" + language.toLowerCase() + ".css";
      _writer.append(_context.contextPath(src));
      _writer.append("' type='text/css'>");
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

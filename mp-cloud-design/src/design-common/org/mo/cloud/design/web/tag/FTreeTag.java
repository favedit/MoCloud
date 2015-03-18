package org.mo.cloud.design.web.tag;

import org.mo.cloud.content.design.tree.ITreeConsole;
import org.mo.com.lang.FFatalError;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.RAop;
import org.mo.web.tag.control.FBaseTreeTag;

//============================================================
// <T>树目录标签。</T>
//============================================================
public class FTreeTag
      extends FBaseTreeTag
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
      String treeName = _context.parseString(_source);
      // 获得定义
      ITreeConsole console = RAop.find(ITreeConsole.class);
      FXmlNode xtree = console.buildConfig("system", treeName);
      if(xtree == null){
         throw new FFatalError("Tree is not exists. (source={1}, tree_name={2})", _source, treeName);
      }
      // 输出内容
      _writer.append("<SCRIPT id='", name, "' type='application/xml'>\n");
      _writer.append(xtree.xml());
      _writer.append("\n</SCRIPT>");
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

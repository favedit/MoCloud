package org.mo.content.core.solution.project;

import com.cyou.gccloud.data.data.FDataSolutionProjectUnit;
import org.mo.com.lang.EResult;
import org.mo.com.xml.FXmlNode;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>方案项目控制台接口。</T>
//============================================================
public interface IC3dProjectConsole
{
   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 逻辑环境
   // @param xoutput 输出内容
   // @param serach 搜索内容
   // @param pageSize 页面大小
   // @param page 页面编号
   // @return 处理结果
   //============================================================
   EResult fetch(ILogicContext context,
                 FXmlNode xoutput,
                 String serach,
                 int pageSize,
                 int page);

   //============================================================
   // <T>查询数据处理。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 处理结果
   //============================================================
   FDataSolutionProjectUnit query(ILogicContext context,
                                  String guid);
}

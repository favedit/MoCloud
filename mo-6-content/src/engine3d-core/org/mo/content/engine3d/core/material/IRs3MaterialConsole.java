package org.mo.content.engine3d.core.material;

import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.com.io.IDataInput;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台接口。</T>
//============================================================
public interface IRs3MaterialConsole
{
   //============================================================
   // <T>根据代码查找模型单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   FDataResource3dModelUnit findByCode(ILogicContext logicContext,
                                       String code);

   //============================================================
   // <T>导入模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param input 输入流
   // @return 处理结果
   //============================================================
   EResult importModel(ILogicContext logicContext,
                       IDataInput input);
}

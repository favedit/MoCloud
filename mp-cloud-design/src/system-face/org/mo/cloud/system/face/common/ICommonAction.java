package org.mo.cloud.system.face.common;

//============================================================
// <T>公共页面定义。</T>
//============================================================
public interface ICommonAction
{
   // 表单显示
   public final String FORM_SHOW = "/apl/form/Show.jsp";

   public final String DIALOG_PROCESS_SUCCESS = "construct@#/apl/page/process/DlgEndProcess.wa";

   public final String PROCESS_END_DELETE = "delete@#/apl/page/process/EndProcess.wa";

   public final String PROCESS_END_INSERT = "insert@#/apl/page/process/EndProcess.wa";

   public final String PROCESS_END_UPDATE = "update@#/apl/page/process/EndProcess.wa";

   public final String PROCESS_SUCCESS = "construct@#/apl/page/process/EndProcess.wa";

   public final String XDESIGN = "#/apl/page/frame/Design.jsp";

   public final String XFRAME = "#/apl/page/frame/Form.jsp";

   public final String XHELP = "#/apl/page/frame/Help.jsp";

   public final String XSORT = "#/apl/page/frame/Sort.jsp";

}

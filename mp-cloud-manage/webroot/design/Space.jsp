<%@ include file='/apl/public.inc' %>
<jh:define source='&page.user' alias='user'/>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<TITLE>CoolLight Designer</TITLE>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<LINK rel="stylesheet" href='/acs/design.css' type="text/css" media="all"/>
<LINK rel="stylesheet" href='/script/acs/control.css' type="text/css" media="all"/>
<LINK rel="stylesheet" href='/script/acs/design.css' type="text/css" media="all"/>
<LINK rel="stylesheet" href='/script/acs/lang_cn.css' type="text/css" media="all"/>
<SCRIPT language='javascript' src='/script/ajs/mp.js'></SCRIPT>
<SCRIPT>
function _load(){
   // 设置环境
   MO.Runtime.setProcessCd(MO.EProcess.Debug);
   MO.initialize();
   MO.Window.Browser.setContentPath('/script');
   // 设置环境
   MO.Console.find(MO.FE3sVendorConsole).setup('net');
   MO.Console.find(MO.FEnvironmentConsole).registerValue(MO.EEaiConstant.ServiceHost, '115.28.82.149');
   MO.Console.find(MO.FEnvironmentConsole).registerValue(MO.EEaiConstant.Resource, '/script/ars/eai');
   // 加载工作区
   var application = MO.Desktop.initialize(MO.FDuiWorkspaceApplication);
   var workspace = application.selectWorkspace(MO.FDsSystemWorkspace);
   workspace.buildDefine(id_workspace);
   workspace.setPanel(id_workspace);
   workspace.psResize();
   workspace.load();
}
</SCRIPT>
</HEAD>
<BODY scroll='no' style='background-color:#444444;overflow:hidden;' onload='_load()'>
<TABLE width='100%' height='100%' border='0px'>
   <TR height='24px'>
      <TD>
         <TABLE width='100%' cellspacing='0' cellpadding='0'>
            <TR height='20px' style='color:#FFFFFF'>
               <TD width='400'><IMG src='/script/ars/picture/logo.png' style='width:140px;height:18px;padding-top:3px;'></TD>
               <TD align='center' class='Workspace_Title'>系 统 设 计</TD>
               <TD width='400' align='right' style='padding-right:8px;'>
                  <A href='/solution/User.wa' style='color:#FFFFFF'>我的信息 (<jh:write source='&user.label'/>)</A>
                  |
                  <A href='/design/Space.wa' style='color:#FFADA0'>平台设计</A>
                  |
                  <A href='/Index.wa' style='color:#FFFFFF'>返回首页</A>
               </TD>
            </TR>
         </TABLE>
      </TD>
   </TR>
   <TR>
      <TD id='id_workspace'></TD>
   </TR>
</TABLE>
</BODY>
</HTML>

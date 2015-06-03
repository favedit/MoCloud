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
<SCRIPT language='javascript' src='/script/ajs/lzma-d.js'></SCRIPT>
<SCRIPT language='javascript' src='/script/ajs/lzma.js'></SCRIPT>
<SCRIPT language='javascript' src='/script/ajs/mo.js'></SCRIPT>
<SCRIPT language='javascript' src='/script/ajs/context_cn.js'></SCRIPT>
<SCRIPT>
function _load(){
   with(MO){
      // 设置环境
      MO.Runtime.setProcessCd(EProcess.Debug);
      RApplication.initialize();
      RBrowser.setContentPath('/script');
      // 加载工作区
      var workspace = RApplication.findWorkspace(FDsPrivateWorkspace);
      workspace.buildDefine(id_workspace);
      workspace.setPanel(id_workspace);
      workspace.psResize();
      workspace.load();
      // 激活工作区
      RConsole.find(FUiWorkspaceConsole).active(workspace);
   }
}
</SCRIPT>
</HEAD>
<BODY scroll='no' style='background-color:#444444;overflow:hidden;' onload='_load()'>
<TABLE width='100%' height='100%' border='0px'>
   <TR height='24px'>
      <TD>
         <TABLE width='100%' cellspacing='0' cellpadding='0'>
            <TR height='20px' style='color:#FFFFFF'>
               <TD width='300'><IMG src='/script/ars/picture/logo.png' style='width:140px;height:18px;padding-top:3px;'></TD>
               <TD align='center' class='Workspace_Title'>我 的 空 间</TD>
               <TD width='300' align='right' style='padding-right:8px;'>
                  <A href='/solution/person/User.wa' style='color:#FFFFFF'>我的信息 (<jh:write source='&user.label'/>)</A>
                  |
                  <A href='/solution/person/Space.wa' style='color:#FFADA0'>我的空间</A>
                  |
                  <A href='/solution/share/Space.wa' style='color:#FFFFFF'>共享空间</A>
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

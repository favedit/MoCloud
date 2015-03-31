<%@ include file='/apl/public.inc' %>
<jh:define source='&page.user' alias='user'/>
<jh:define source='&page.project' alias='project'/>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<TITLE>CoolLight Designer</TITLE>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<LINK rel="stylesheet" href='../script/acs/control.css' type="text/css" media="all"/>
<LINK rel="stylesheet" href='../script/acs/design.css' type="text/css" media="all"/>
<LINK rel="stylesheet" href='../script/acs/lang_cn.css' type="text/css" media="all"/>

<SCRIPT language='javascript' src='../script/ajs/lzma.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/ajs/mo.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/ajs/context_cn.js'></SCRIPT>

<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectCatalogToolBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectCatalogContent.js'></SCRIPT>

<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectSearchToolBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectSearchItem.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectSearchContent.js'></SCRIPT>

<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectPreviewToolBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectPreviewContent.js'></SCRIPT>

<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectMenuBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectTabBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.2-design-project/FDsProjectWorkspace.js'></SCRIPT>

<SCRIPT>
function _load(){
   RRuntime.setProcessCd(EProcess.Debug);
   RApplication.initialize();
   RBrowser.setContentPath('../script');
   // 加载工作区
   var workspace = RApplication.findWorkspace(FDsProjectWorkspace);
   workspace.buildDefine(id_workspace);
   workspace.setPanel(id_workspace);
   workspace.psResize();
   workspace.load();
   RConsole.find(FUiWorkspaceConsole).active(workspace);
}
</SCRIPT>
</HEAD>
<BODY scroll='no' style='background-color:#444444;overflow:hidden;' onload='_load()'>
<TABLE width='100%' height='100%' border='0px'>
   <TR height='20px'>
      <TD>
         <TABLE width='100%' height='100%'>
            <TR height='20px' style='color:#FFFFFF'>
               <TD width='300'><IMG src='../script/ars/picture/logo.png' style='width:140px;height:18px;padding-top:4px;'></TD>
               <TD align='center'>
                  项目 - <jh:write source='&project.label'/> (<jh:write source='&project.code'/>)
               </TD>
               <TD width='300' align='right'>
                  用户空间 (<jh:write source='&user.label'/>)
                  |
                  <A href='Project.wa' style='color:#FFFFFF'>项目管理</A>
                  |
                  <A href='Resource.wa' style='color:#FFFFFF'>资源管理</A>
                  |
                  发布管理
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

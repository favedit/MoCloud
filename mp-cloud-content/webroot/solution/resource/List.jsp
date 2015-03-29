<%@ include file='/apl/public.inc' %>
<jh:define source='&page.user' alias='user'/>
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

<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourceCatalogToolBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourceCatalog.js'></SCRIPT>

<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourceSearchToolBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourceSearchItem.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourceSearchContent.js'></SCRIPT>

<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourcePreviewToolBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourcePreviewContent.js'></SCRIPT>

<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourceMenuBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourceTabBar.js'></SCRIPT>
<SCRIPT language='javascript' src='../script/6.2.3-design-resource/FDsResourceWorkspace.js'></SCRIPT>

<SCRIPT>
function _load(){
   RRuntime.setProcessCd(EProcess.Debug);
   RApplication.initialize();
   RBrowser.setContentPath('../script');
   // 加载工作区
   var w = RApplication.findWorkspace(FDsResourceWorkspace);
   w.buildDefine(id_workspace);
   w.setPanel(id_workspace);
   w.psResize();
   w.load();
   RConsole.find(FUiWorkspaceConsole).active(w);
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
                  资源管理 - <jh:write source='&user.label'/> (<jh:write source='&user.guid'/>)
               </TD>
               <TD width='300' align='right'>
                  用户空间
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

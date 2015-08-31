<%@ include file='/apl/public.inc' %>
<jh:define source='&page.user' alias='user'/>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<TITLE>CoolLight Designer</TITLE>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<LINK rel="stylesheet" href='/acs/design.css' type="text/css" media="all"/>
<LINK rel="stylesheet" href='/script/acs/control.css' type="text/css" media="all"/>
<LINK rel="stylesheet" href='/script/acs/manage.css' type="text/css" media="all"/>
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
   var workspace = application.selectWorkspace(MO.FManageWorkspace);
   workspace.buildDefine(window.document);
   workspace.setPanel(window.document.body);
   workspace.psResize();
   workspace.load();
}
</SCRIPT>
</HEAD>
<BODY scroll='no' style='background-color:#444444;overflow:hidden;' onload='_load()'>
</BODY>
</HTML>

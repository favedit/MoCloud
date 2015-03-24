<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/system.inc' %>

<HTML>
<HEAD>
<TITLE>Welcome</TITLE>
<js:css/>
<js:js type='runtime.client'/>
</HEAD>
<!-- Script -------------------------------------------------->
<SCRIPT language='javascript'>
var tree = null;
var toolbar = null;
//----------------------------------------------------------
function refreshNode(){
	tree.reloadNode();
}
//----------------------------------------------------------
function onNodeClick(sender, node){
   var type = node.type();
   var storage = type.storage();
	fmMain.target = 'frmMain';
	fmMain.frame_code.value = type.get('frame_code');
	fmMain.storage_code.value = storage;
	if(storage == 'collection'){
		fmMain.collection_code.value = node.code();
		fmMain.component_code.value = '';
	}else if(storage == 'component'){
		fmMain.collection_code.value = node.topNode().code();
		fmMain.component_code.value = node.guid();
	}else{
		throw new TError(o, 'Unknown storage type. (storage={1})', storage);
	}
	fmMain.action = '<jh:context/>/design/frame/Frame.wa?do=update';
	fmMain.submit();
}
//----------------------------------------------------------
function onSearchKeyDown(){
   if(13 == event.keyCode){
      onSearch();
      event.returnValue = false;
   }
}
function onSearch(){
   var s = fmMain.search_value.value;
   if(s){
      if(s.lenth < 3){
         return alert('搜索长度必须大于2个字符');
      }
      tree.service = 'search@design.webform';
      tree.attributes.set('search', s);
      tree.clear();
      tree.connect();
   }
}
//----------------------------------------------------------
function onPageLoad(){
   // 环境设置
   RRuntime.setProcessCd(EProcess.Release);
   RApplication.initialize();
   RBrowser.setContentPath('/system');
   // 创建工具栏
   toolbar = RClass.create(FUiDataToolBar);
   RControl.build(toolbar, RXml.makeNode(xToolBar), null, _id_toolbar);
   toolbar.setPanel(_id_toolbar);
   //toolbar = RControl.fromXml(xToolBar, _id_toolbar);
   // 创建目录
   tree = RClass.create(FUiDataTreeView);
   RControl.build(tree, RXml.makeNode(xTree), null, _id_tree);
   tree.lsnsClick.register(null, onNodeClick);
   tree.load();
   tree.setPanel(_id_tree);
}
</SCRIPT>
<!-- Environment --------------------------------------------->
<SCRIPT id='xEnvironment' type='application/xml'><jh:write source='&page.environment' format='text'/></SCRIPT>
<!-- Toolbar config ------------------------------------------>
<SCRIPT id='xToolBar' type='application/xml'>
<ToolBar width='100%' height='100%' align='right'>
	<ToolButtonText name='btnForm' label='表单定义' icon='tools.design' target='frmMain' page='#/design/webform/WebForm.wa?do=list&amp;form_name=design.webform.WebFormList'/>
	<ToolButton name='btnRefresh' icon='tools.refresh' action='refreshNode()'/>
</ToolBar>
</SCRIPT>
<!-- TreeView config ----------------------------------------->
<jc:tree name='xTree' source='system.design.frame'/>
<!-- Body begin ---------------------------------------------->
<jh:body style='bodyCatalog' scroll='no' onload='onPageLoad()'>
<jh:form name='fmMain' method='post'>
<!-- Hidden -------------------------------------------------->
<jh:hidden name='storage_code'/>
<jh:hidden name='collection_code'/>
<jh:hidden name='component_code'/>
<jh:hidden name='frame_code'/>
<!-- Catalog ------------------------------------------------->
<TABLE border='0' cellpadding='0' cellspacing='0' style='width:100%; height:100%;'>
<TR>
<TD height='24'>
<!-- Toolbar begin ------------------------------------------->
<DIV id='_id_toolbar' style='width:100%; height:100%; overflow:auto'><DIV>
<!-- Toolbar end --------------------------------------------->
</TD></TR>
<TR>
   <TD height='24' style='padding:2;' bgcolor='#F0F0FC'>
      <TABLE width='100%' border='0' cellpadding='0' cellspacing='0'>
         <TR>
            <TD><INPUT name='search_value' style='width:100%; height:18;' onkeydown='onSearchKeyDown()'></TD>
            <TD width='4'></TD>
            <TD width='80'><INPUT type='button' style='width:80; height:18;' style='cursor:hand' onclick='onSearch()' value='搜索'></TD>
         </TR>
      </TABLE>
   </TD>
</TR>
<TR><TD>
<!-- Tree begin ---------------------------------------------->
<DIV id='_id_tree' style='width:100%; height:100%; overflow:auto'><DIV>
<!-- Tree end ------------------------------------------------>
</TD></TR>
</TABLE>
</jh:form>
</jh:body>
<!-- Body end ------------------------------------------------>
</HTML>

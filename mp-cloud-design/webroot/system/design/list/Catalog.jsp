<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/system.inc' %>

<HTML>
<HEAD>
<TITLE>Welcome</TITLE>
<js:css/>
<js:js/>
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
	fmMain.frame_code.value = type.get('form_name');
	fmMain.storage_code.value = storage;
	if(storage == 'collection'){
		fmMain.collection_code.value = node.label();
		fmMain.component_code.value = '';
	}else if(storage == 'component'){
		fmMain.collection_code.value = node.topNode().label();
		fmMain.component_code.value = node.uuid;
	}else{
		throw new TError(o, 'Unknown storage type. (storage={1})', storage);
	}
	fmMain.action = '<jh:context/>/design/list/List.wa?do=update';
	fmMain.submit();
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
<!-- Toolbar config ------------------------------------------>
<SCRIPT id='xToolBar' type='application/xml'>
<ToolBar width='100%' height='100%' align='right'>
	<ToolButtonText name='btnForm' label='列表定义' icon='tools.design' target='frmMain' page='#/design/list/List.wa?do=list&amp;form_name=design.list.ListList'/>
	<ToolButton name='btnRefresh' icon='tools.refresh' action='refreshNode()'/>
</ToolBar>
</SCRIPT>
<!-- TreeView config ----------------------------------------->
<jc:tree name='xTree' source='design.list'/>
<!-- Body begin ---------------------------------------------->
<jh:body style='Frame_Catalog' scroll='no' onload='onPageLoad()'>
<jh:form name='fmMain' method='post'>
<!-- Hidden -------------------------------------------------->
<jh:hidden name='frame_code'/>
<jh:hidden name='storage_code'/>
<jh:hidden name='collection_code'/>
<jh:hidden name='component_code'/>
<!-- Catalog ------------------------------------------------->
<jc:include uri='#/apl/template/CatalogBody.tpl'/>
</jh:form>
</jh:body>
<!-- Body end ------------------------------------------------>
</HTML>

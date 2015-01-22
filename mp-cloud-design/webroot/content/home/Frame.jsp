<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/public.inc' %>

<HTML>
<HEAD>
<TITLE>Welcome</TITLE>
<js:css/>
<js:js type='runtime'/>
</HEAD>
<!------------------------------------------------------------>
<SCRIPT language='javascript'>
// font-weight:bold; 
function chLang(sel){
	fmMain.action = '?do=changeLanguage';
	fmMain.target = 'frmTitle';
	fmMain.submit();
}
//----------------------------------------------------------
function selPage(o){
	var index = 0;
	for(var n=0; n<_id_page.length; n++){
		var p = _id_page[n];
		if(n == 0){
			p.style.borderLeft = '1 solid #999999';
		}
		if(p == o){
			index = n;
			if(o.className != 'titleCellSel'){
				o.className = 'titleCellSel';
			}
		}else{
			if(p.className == 'titleCellSel'){
				p.className = 'titleCellNor';
			}
		}
	}
	for(var n=0; n<_id_tools.length; n++){
		var t = _id_tools[n];
		if(index == n && t.style.display == 'none'){
			t.style.display = 'block';
		}
		if(index != n && t.style.display == 'block'){
			t.style.display = 'none';
		}
	}
}
//----------------------------------------------------------
function title_onmenter(){
	if(this.className == 'titleCellNor'){
		this.className = 'titleCellHover';
	}
}
function title_onmleave(){
	if(this.className == 'titleCellHover'){
		this.className = 'titleCellNor';
	}
}
function title_onmdown(){
	selPage(this);
}
//----------------------------------------------------------
function tbn_onmenter(){
	if(this.className == 'tbarBtnNor' && this.className != 'tbarBtnSel'){
		this.className = 'tbarBtnHover';
	}
}
function btn_onmleave(){
	if(this.className == 'tbarBtnHover' && this.className != 'tbarBtnSel'){
		this.className = 'tbarBtnNor';
	}
}
function btn_onmdownk(self, page){
	for(var n=0; n<_id_button.length; n++){
		var btn = _id_button[n];
		if(btn == this){
			alert(this);
		}
		btn.className = 'tbarBtnNor';
	}
	self.className = 'tbarBtnSel';
	fmMain.action = '<jh:context/>' + page;
	fmMain.target = 'frmCatalog';
	fmMain.submit();
	fmMain.action = 'Empty.wa';
	fmMain.target = 'frmMain';
	fmMain.submit();
}
//----------------------------------------------------------
function _onloadAll(){
   MoJS.initialize();
	// split
	var cs = RClass.create(FLgSpliter);
	cs.link($('#id_split'), $('#id_left'));
	// build menu
	for(var n=0; n<_id_page.length; n++){
		var page = _id_page[n];
		page.className = 'titleCellNor';
		page.onmouseenter = title_onmenter;
		page.onmouseleave = title_onmleave;
		page.onmousedown = title_onmdown;
	}
	for(var n=0; n<_id_button.length; n++){
		var btn = _id_button[n];
		btn.className = 'tbarBtnNor';
		btn.onmouseenter = tbn_onmenter;
		btn.onmouseleave = btn_onmleave;
	}
	selPage(_id_page[0]);
   RWindow.setEnable(true);
}
//----------------------------------------------------------
function _onload(){
   RWindow.connect(window);
   RWindow.setEnable(false, true);
   RLoader.loadJs('mobj', 'logic');
   RLoader.wait(new TInvoke(null, _onloadAll), 'pg:catalog', 'pg:main', 'js:mobj', 'js:logic');
}
</SCRIPT>
<!------------------------------------------------------------>
<BODY style='margin:0; padding:0' scroll='no' onload='_onload()'>
<jh:form name='fmMain'>
<jh:hidden name='page_index'/>
<!-- 框架部分-->
<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' height='100%'>
<TR><TD height='36' background='ground.jpg'>

<!-- 标题部分(中) - 主菜单 - start -->
<TABLE width='100%' height='38' border='0' cellpadding="0" cellspacing='0'>
<TR>
	<TD width='84' align='right'><IMG src='title.png'></TD>
	<TD align='right' valign='bottom'>
	<DIV style='width:1; height:30; border-top:1 solid #8E909C; border-left:1 solid #76758c;'>
		<TABLE border='0' cellpadding="0" cellspacing='0' height='30'>
		<TR>
         <TD width='180' align='center' bgcolor='#9b9ab4'><IMG src='sysmgr.gif'></TD>
   		<TD width='1' align='right' valign='bottom' style='filter:progid:DXImageTransform.Microsoft.Gradient(startColorStr=#9b9ab4, endColorStr=#FFFFFF, gradientType=1);'>
   			<TABLE border='0' cellpadding="0" cellspacing='0'>
   			<TR>
   				<TD><js:icon width='12'/></TD>
   				<TD id='_id_page'><js:icon source='tools.logic'/> 内容管理</TD>
   				<TD id='_id_page'><js:icon source='tools.design'/> 设计管理</TD>
   				<TD id='_id_page'><js:icon source='tools.database'/> 数据管理</TD>
   				<TD><js:icon width='12'/></TD>
   			</TR>
   			</TABLE>
   		</TD>
      </TR>
		</TABLE>
	</DIV>
	</TD>
</TR>
</TABLE>
<!-- 标题部分(中) - 主菜单 - end -->

</TD></TR>
<TR><TD bgcolor='#9e9eba' height='2' colspan='2'></TD></TR>
<TR><TD bgcolor='#FFFFFF' colspan='2' valign='middle' background='toolbar.gif' height='21'>

<!-- 标题部分(下) - 子菜单 - start -->
<TABLE border='0' cellpadding="0" cellspacing='0' width='100%' height='21'>
<TR>
	<TD width='14'>&nbsp;</TD>
	<TD>
		<TABLE border='0' cellpadding="0" cellspacing='1' height='21'>
		<TR id='_id_tools' style='display:none'>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/persistence/ContentPersistence.wa?do=catalog")'>持久化对象</TD>
			<TD>&nbsp;</TD>
			<!-- <TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/alias/Alias.wa?do=catalog")'>别称</TD> -->
			<!-- <TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/property/Property.wa?do=catalog")'>属性</TD> -->
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/list/ContentList.wa?do=catalog")'>列表</TD>
			<TD>&nbsp;</TD>
			<!-- <TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/translate/Translate.wa?do=catalog")'>翻译</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/webtheme/WebTheme.wa?do=catalog")'>主题</TD>
			<TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/webtools/WebTools.wa?do=catalog")'>工具栏</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/webtree/WebTree.wa?do=catalog")'>树目录</TD>
			<TD>&nbsp;</TD> -->
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/frame/ContentFrame.wa?do=catalog&node_type=Style&node_filter=")'>样式</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/frame/ContentFrame.wa?do=catalog&node_type=Template&node_filter=")'>模板</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/frame/ContentFrame.wa?do=catalog&node_type=Picker&node_filter=")'>选取</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/frame/ContentFrame.wa?do=catalog&node_type=Form&node_filter=")'>表单</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/frame/ContentFrame.wa?do=catalog&node_type=List&node_filter=")'>表格</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/frame/ContentFrame.wa?do=catalog&node_type=&node_filter=")'>全部</TD>
         <!-- <TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/chart/Chart.wa?do=catalog&node_type=&node_filter=")'>图表</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/design/report/Report.wa?do=catalog&node_type=&node_filter=")'>报表</TD> -->
		</TR>
		<TR id='_id_tools' style='display:none'>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/codelist/CodeList.wa?do=catalog")'>定义列表</TD>
			<TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/dataset/Dataset.wa?do=catalog&node_type=DataTemplate&node_filter=")'>模板</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/dataset/Dataset.wa?do=catalog&node_type=DataProperty&node_filter=")'>属性表</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/dataset/Dataset.wa?do=catalog&node_type=DataWork&node_filter=")'>工作表</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/dataset/Dataset.wa?do=catalog&node_type=DataStore&node_filter=")'>存储表</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/dataset/Dataset.wa?do=catalog&node_type=&node_filter=")'>全部</TD>
			<TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/table/Table.wa?do=catalog")'>数据表</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/view/View.wa?do=catalog")'>数据视图</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/procedure/Procedure.wa?do=catalog")'>数据包</TD>
			<TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='btn_onmdownk(this, "/database/logicunit/LogicUnit.wa?do=catalog")'>逻辑单元</TD>
		</TR>
		</TABLE>
	</TD>
</TR>
</TABLE>
<!-- 标题部分(下) - 子菜单 - end -->

</TD></TR>
<TR><TD bgcolor='#9e9eba' height='3' colspan='2'></TD></TR>
<TR>
	<TD>

<!-- 分页部分 - start -->
<TABLE width='100%' height='100%' border='0' cellpadding='0' cellspacing='0' bgcolor='#a5eaea'>
<TR>
	<TD id='id_left' width='400'>
		<IFRAME name='frmCatalog' width='100%' height='100%' frameborder='0' src='<jh:context path='/content/home/Catalog.wp'/>'></IFRAME>
	</TD>
	<TD width='3' id='id_split' bgcolor='#9e9eba'></TD>
	<TD>
		<IFRAME name='frmMain' width='100%' height='100%' frameborder='0' src='<jh:context path='/content/home/Body.wa'/>'></IFRAME>
	</TD>
</TR>
</TABLE>
<!-- 分页部分 - end -->

	</TD>
</TR>
</TABLE>

</jh:form>
</BODY>

</HTML>


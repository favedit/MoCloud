<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/system.inc' %>

<HTML>
<HEAD>
<TITLE>Welcome</TITLE>
<js:css/>
<js:js/>
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
function selectTitlePage(o){
	var index = 0;
	for(var n=0; n<_id_page.length; n++){
		var p = _id_page[n];
		if(n == 0){
			p.style.borderLeft = '1 solid #999999';
		}
		if(p == o){
			index = n;
			if(o.className != 'Title_MenuSelect'){
				o.className = 'Title_MenuSelect';
			}
		}else{
			if(p.className == 'Title_MenuSelect'){
				p.className = 'Title_MenuNormal';
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
function onTitleEnter(){
	if(this.className == 'Title_MenuNormal'){
		this.className = 'Title_MenuHover';
	}
}
function onTitleLeave(){
	if(this.className == 'Title_MenuHover'){
		this.className = 'Title_MenuNormal';
	}
}
function onTitleClick(){
	selectTitlePage(this);
}
//----------------------------------------------------------
function onButtonEnter(){
	if(this.className == 'Title_ButtonNormal' && this.className != 'Title_ButtonSelect'){
		this.className = 'Title_ButtonHover';
	}
}
function onButtonLeave(){
	if(this.className == 'Title_ButtonHover' && this.className != 'Title_ButtonSelect'){
		this.className = 'Title_ButtonNormal';
	}
}
function onButtonClick(self, page){
	for(var n=0; n<_id_button.length; n++){
		var btn = _id_button[n];
		if(btn == this){
			alert(this);
		}
		btn.className = 'Title_ButtonNormal';
	}
   if(self){
   	self.className = 'Title_ButtonSelect';
   }
	fmMain.action = '<jh:context/>' + page;
	fmMain.target = 'frmCatalog';
	fmMain.submit();
	fmMain.action = 'Empty.wa';
	fmMain.target = 'frmMain';
	fmMain.submit();
}
//----------------------------------------------------------
function onPageLoad(){
   // 环境设置
   RRuntime.setProcessCd(EProcess.Release);
   RApplication.initialize();
   RBrowser.setContentPath('/system');
	// split
	//var cs = RClass.create(FLgSpliter);
	//cs.link($('#id_split'), $('#id_left'));
	// build menu
	for(var n=0; n<_id_page.length; n++){
		var page = _id_page[n];
		page.className = 'Title_MenuNormal';
		page.onmouseenter = onTitleEnter;
		page.onmouseleave = onTitleLeave;
		page.onmousedown = onTitleClick;
	}
	for(var n=0; n<_id_button.length; n++){
		var btn = _id_button[n];
		btn.className = 'Title_ButtonNormal';
		btn.onmouseenter = onButtonEnter;
		btn.onmouseleave = onButtonLeave;
	}
	selectTitlePage(_id_page[0]);
   //onButtonClick(null, "/design/list/List.wa?do=catalog");
   onButtonClick(this, "/design/frame/Frame.wa?do=catalog&node_type=&node_filter=")
   RWindow.setEnable(true);
   //RWindow.connect(window);
   //RWindow.setEnable(false, true);
   //RLoader.loadJs('mobj', 'logic');
   //RLoader.wait(new TInvoke(null, _onloadAll), 'pg:catalog', 'pg:main', 'js:mobj', 'js:logic');
}
</SCRIPT>
<!------------------------------------------------------------>
<BODY style='overflow:hidden' onload='onPageLoad()'>
<jh:form name='fmMain'>
<jh:hidden name='page_index'/>
<!-- 框架部分-->
<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' height='100%'>
<TR><TD height='24' background='ground.jpg'>

<!-- 标题部分(上) - start -->
<TABLE border='0' cellpadding="2" cellspacing='0' width='100%'>
<TR>
	<TD width='10'></TD>
	<TD><B>Welcome</B> | <B>Sign In</B></TD>
	<TD align='right' valign='bottom'>
		Home | Help | Language:
		<jh:select source='&home.language' onchange='chLang(this)' style='font-size:9pt;' enum='system.culture.Language'/>
	</TD>
	<TD width='10'></TD>
</TR>
</TABLE>
<!-- 标题部分(上) - end -->

<!-- 标题部分(中) - 主菜单 - start -->
<TABLE width='100%' border='0' cellpadding="0" cellspacing='0'>
<TR>
	<TD width='80px' align='right'><IMG src='title.gif' style='width:60;height:30'></TD>
	<TD align='right'>
		<TABLE border='0' cellpadding="0" cellspacing='0' height='20' style='border-top:1px solid #76758C; border-left:1px solid #76758C;'>
   		<TR><TD width='160px' align='center' bgcolor='#9b9ab4' style='padding-top:3'><IMG src='sysmgr.gif' style='width:140;height:30'></TD>
   		<TD align='right' valign='bottom' class='Title_MenuBar'>
   			<TABLE border='0' cellpadding="0" cellspacing='0'>
   			<TR>
   				<TD><js:icon width='12'/></TD>
   				<TD id='_id_page' class='Title_MenuNormal'>设计</TD>
   				<TD id='_id_page' class='Title_MenuNormal'>数据库</TD>
   				<TD><js:icon width='12'/></TD>
   			</TR>
   			</TABLE>
   		</TD></TR>
		</TABLE>
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
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/persistence/Persistence.wa?do=catalog")'>持久化对象</TD>
			<TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/list/List.wa?do=catalog")'>列表</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/toolbar/WebTools.wa?do=catalog")'>工具栏</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/tree/WebTree.wa?do=catalog")'>树目录</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/theme/WebTheme.wa?do=catalog")'>主题</TD>
			<TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/frame/Frame.wa?do=catalog&node_type=Style&node_filter=")'>样式</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/frame/Frame.wa?do=catalog&node_type=Template&node_filter=")'>模板</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/frame/Frame.wa?do=catalog&node_type=Picker&node_filter=")'>选取</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/frame/Frame.wa?do=catalog&node_type=Form&node_filter=")'>表单</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/frame/Frame.wa?do=catalog&node_type=List&node_filter=")'>表格</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/frame/Frame.wa?do=catalog&node_type=&node_filter=")'>全部</TD>
         <TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/chart/Chart.wa?do=catalog&node_type=&node_filter=")'>图表</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/design/report/Report.wa?do=catalog&node_type=&node_filter=")'>报表</TD>
		</TR>
		<TR id='_id_tools' style='display:none'>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/codelist/CodeList.wa?do=catalog")'>定义列表</TD>
			<TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/dataset/Dataset.wa?do=catalog&node_type=DataTemplate&node_filter=")'>模板</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/dataset/Dataset.wa?do=catalog&node_type=DataProperty&node_filter=")'>属性表</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/dataset/Dataset.wa?do=catalog&node_type=DataWork&node_filter=")'>工作表</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/dataset/Dataset.wa?do=catalog&node_type=DataStore&node_filter=")'>存储表</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/dataset/Dataset.wa?do=catalog&node_type=&node_filter=")'>全部</TD>
			<TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/table/Table.wa?do=catalog")'>数据表</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/view/View.wa?do=catalog")'>数据视图</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/procedure/Procedure.wa?do=catalog")'>数据包</TD>
			<TD>&nbsp;</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/database/logicunit/LogicUnit.wa?do=catalog")'>逻辑单元</TD>
		</TR>
		<TR id='_id_tools' style='display:none'>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/support/framework/Framework.wa")'>Framework</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/support/enging/Framework.wa")'>JS Enging</TD>
			<TD id='_id_button' onmousedown='onButtonClick(this, "/support/help/Help.wa")'>Help</TD>
			<TD></TD>
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
<TABLE width='100%' height='100%' border='0' cellpadding='0' cellspacing='0'>
<TR>
	<TD id='id_left' width='300'>
		<IFRAME name='frmCatalog' width='100%' height='100%' frameborder='0' src='<jh:context path='/system/home/Catalog.wa'/>'></IFRAME>
	</TD>
	<TD width='3' id='id_split' bgcolor='#9E9EBA'></TD>
	<TD>
		<IFRAME name='frmMain' width='100%' height='100%' frameborder='0' src='<jh:context path='/system/home/Body.wa'/>'></IFRAME>
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


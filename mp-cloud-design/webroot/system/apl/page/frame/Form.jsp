<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/system.inc' %>
<HTML>
<HEAD>
<SCRIPT>var pageStart = new Date().getTime();</SCRIPT>
<js:css/>
<js:js type='runtime.client'/>
</HEAD>
<!-- Script -------------------------------------------------->
<SCRIPT>
var modeCd = '<jh:write source="&page.pageAction"/>';
var toolbar = null;
var frame = null;
//----------------------------------------------------------
function doRefresh(){
   fmMain.action = '';
   fmMain.submit();
}
//----------------------------------------------------------
function doInsert(){
   frame.doAction('insertAction');
}
//----------------------------------------------------------
function doSave(){
   // 检查窗口是否禁止
   if(!RWindow.isEnable()){
      return;
   }
   // 执行命令
   var emode = REnum.encode(EUiDataMode, modeCd)
   if(emode == EUiDataMode.Insert){
      frame.doAction('insertAction');
   }else if(emode == EUiDataMode.Update){
      frame.doAction('updateAction');
   }else{
      throw new TError(o, 'Unknown action [' + mode + ']');
   }
}
//----------------------------------------------------------
function doDelete(){
   frame.doAction('deleteAction');
}
//----------------------------------------------------------
function onPageLoad(){
   var start = new Date().getTime();
   // 环境设置
   RRuntime.setProcessCd(EProcess.Release);
   RApplication.initialize();
   RBrowser.setContentPath('/system');
   // 加载环境
   var xframe = RXml.makeNode(xFrame);
   var xvalue = RXml.makeNode(xValue);
   RConsole.find(FEnvironmentConsole).load(xEnvironment);
   // 创建工具栏
   toolbar = RClass.create(FUiDataToolBar);
   RUiToolBar.fromNode(toolbar, xframe, _id_toolbar, true);
   toolbar.psMode(emode);  
   //if(!toolbar){
   //   toolbar = RControl.fromXml(xToolBar, _id_toolbar);
   //}
   //toolbar.psMode(emode);  
   toolbar.setPanel(_id_toolbar);
   // 创建表单
   var emode = REnum.encode(EUiDataMode, modeCd)
   frame = RClass.create(FUiDataFrame);
   frame.psMode(emode);
   RControl.build(frame, xframe, null, _id_frame);
   if(emode == EUiDataMode.Insert){
      frame.doPrepare(xvalue.attributes());
   }else{
      if(RClass.isClass(frame, FUiFrame)){
         frame.dsLoadValue(xvalue, EUiDataStore.DataNvl);
      }else if(RClass.isClass(form, FUiTable)){
         frame.dsLoadDatasets(xvalue)
      }
   }
   frame.setPanel(_id_frame);
   //frame.psRefresh();
   //frame.focus();
   // 加载内容
   // show
   var end = new Date().getTime();
   RWindow.setCaption(frame.label() + ' (Show page in ' + (end - pageStart) + 'ms. Build form: ' + (end - start) + 'ms)');
}
</SCRIPT>
<!-- Xml Config ---------------------------------------------->
<jc:frame name='xFrame' source='&page.frameCode'/>
<SCRIPT id='xValue' type='application/xml'><jh:write source='&page.frameValue' format='text'/></SCRIPT>
<SCRIPT id='xEnvironment' type='application/xml'><jh:write source='&page.environmentXml' format='text'/></SCRIPT>
<!-- Body begin ---------------------------------------------->
<jh:body style='bodyMain' scroll='no' onload='onPageLoad()'>
<jh:form>
<jh:hidden name='storage_code' source='&page.storageCode'/>
<jh:hidden name='collection_code' source='&page.collectionCode'/>
<jh:hidden name='component_code' source='&page.componentCode'/>
<jh:hidden name='frame_code' source='&page.frameCode'/>
<jh:hidden name='frame_service' source='&page.frameService'/>
<!-- Data begin ---------------------------------------------->
<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' height='100%'>
<!-- Toolbar begin ---------------------------------------------->
<TR><TD height='24px'><DIV id='_id_toolbar' class='Body_ToolBar'></DIV></TD></TR>
<!-- Form end ------------------------------------------------>
<!-- Form begin ---------------------------------------------->
<TR><TD style='padding:8px'><DIV id='_id_frame' style='width:100%;height:100%;overflow:auto;'></DIV></TD></TR>
<!-- Form end ------------------------------------------------>
</TABLE>
<!-- Data end ------------------------------------------------>
</jh:form>
</jh:body>
<!-- Body end ------------------------------------------------>
</HTML>

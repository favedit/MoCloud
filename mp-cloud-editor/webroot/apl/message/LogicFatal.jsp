<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/public.inc' %>
<HTML>
<!-- Html Header <S> -------------------------------------->
<HEAD>
<jh:title caption='C3D-错误页面'/>
<LINK rel="stylesheet" href="/acs/default.css?v=2">
</HEAD>
<!-- Html Header <E> -------------------------------------->
<SCRIPT language='javascript'>
function doBack(){
   history.back();
}
//----------------------------------------------------------
function doShow(){
   id_message.style.display = 'block';
}
</SCRIPT>
<!-- Toolbar Initialize ----------------------------------->
<XML ID="xToolBar">
<ToolBar width='100%' >
   <ToolButton name='backButton' type='back' label='返回' disp_access='' icon='commu' action='_onBack()'/>
</ToolBar>
</XML>

<!-- Body Initialize -------------------------------------->
<jh:body scroll='no' style='background-color:#FFFFFF'>
<jh:form name='frmConsole'>

<TABLE width='100%' height='100%' border='0' cellspacing='0' cellpadding='0'>
<TR height='1'>
   <TD>
<!-- Toolbar <S> ------------------------------------------>
      <DIV id='_id_toolbar' style='width:100%; height:100%'></DIV>
<!-- Toolbar <E> ------------------------------------------>
   </TD>
<TR>
<TR height='1'>
   <TD>
<!-- Title <S> -------------------------------------------->
      <TABLE width='100%'>
      <TR>
         <TD align='center' valign='middle' >
            <jh:img src='/ars/icon/tools/message/logicError.jpg' align='absmiddle'/>
            <jh:img src='/ars/icon/tools/message/logicError_Caption.jpg'/>
            <BR><BR><BR>
            <FONT color='#333333'>
               由于以下原因使本次操作产生了错误，<BR>
               如果您对该错误存在疑问，请联系系统管理员。
            </FONT>
            <BR><BR>
            <FONT color='red'>
               请点击这里返回上一页：
               <INPUT type='button' style='width:80px' value='返回' onclick='doBack()'/>
            </FONT>
         </TD>
      </TR>
      </TABLE>
<!-- Title <E> -------------------------------------------->
   </TD>
<TR>
<TR height='1'>
   <TD style='padding:0 16'>
<!-- Description <S> -------------------------------------->
      <TABLE width='100%' height='100%' bgcolor='#94B6FF' border='0' cellspacing='1' cellpadding='0' style='table-layout:fixed'>
      <TR bgcolor='#FFFFFF'>
         <TD style='padding:4 4'>
            <TABLE width='100%' height='100%' border='0' cellspacing='0' cellpadding='0'>
            <TR>
               <TD width='30' align='center'><jh:img src='/ars/icon/tools/message/error.gif' align='absmiddle'/></TD>
               <TD onclick='doShow()'><FONT color='red'><jh:write source='&message.message'/></FONT></TD>
            </TR>
            </TABLE>
         </TD>
      </TR>
      </TABLE>
<!-- Description <E> -------------------------------------->
   </TD>
</TR>
<TR><TD>&nbsp;</TD></TR>
</TABLE>
<!-- Error message <S> ------------------------------------>
<DIV id='id_message' style='display:none'>
<jh:write source='&message.description' format='text'/>
</DIV>
<!-- Error message <E> ------------------------------------>
</jh:form>
</jh:body>
</HTML>

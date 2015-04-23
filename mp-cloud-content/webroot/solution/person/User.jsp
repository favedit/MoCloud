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
<SCRIPT language='javascript' src='/script/ajs/mo-core.js'></SCRIPT>
<SCRIPT>
function checkInfo(){
   var label = RString.trim(document.getElementById("label").value);
	if(label == ''){
		alert("标‘*’是必输项！");
		return false;
	}
   if(label.length < 2){
		alert("[昵称]不能小于2个字符。");
		return false;
   }
   return true;
}
function _load(){
}
</SCRIPT>
</HEAD>
<BODY scroll='no' style='background-color:#444444;overflow:hidden;' onload='_load()'>
<TABLE width='100%' height='100%' border='0px'>
   <TR height='24px'>
      <TD>
         <TABLE width='100%' cellspacing='0' cellpadding='0'>
            <TR style='color:#FFFFFF'>
               <TD width='300'><IMG src='/script/ars/picture/logo.png' style='width:140px;height:18px;padding-top:3px;'></TD>
               <TD align='center' class='Workspace_Title'>我 的 信 息</TD>
               <TD width='300' align='right' style='padding-right:8px;'>
                  <A href='/solution/person/User.wa' style='color:#FFADA0'>我的信息 (<jh:write source='&user.label'/>)</A>
                  |
                  <A href='/solution/person/Space.wa' style='color:#FFFFFF'>我的空间</A>
                  |
                  <A href='/solution/share/Space.wa' style='color:#FFFFFF'>共享空间</A>
                  |
                  <A href='/Index.wa' style='color:#FFFFFF'>返回首页</A>
               </TD>
            </TR>
         </TABLE>
      </TD>
   </TR>
   <TR bgcolor='#FDFDFD'>
      <TD align='center'>
         <FORM id='id_form' method='post' action='/solution/person/User.wa?do=update' onsubmit='return checkInfo();'>
            <TABLE border='0' cellpadding='2'>
               <TR>
                  <TD colspan='2' class='Register_Title'>用户信息</TD>
               </TR>
               <TR>
                  <TD class='Register_Label'>昵称：</td>
                  <TD align='left'><input id='label' name='label' style='width:160px;' value="<jh:write source='&user.label'/>"/> <font color='#999999'>（*显示名称）</font></TD>
               </TR>
               <TR>
                  <TD></TD>
                  <TD style='padding-top:16px;'><INPUT type='submit' style='width:80px;' value='提交'/></TD>
               </TR>
            </TABLE>
         </FORM>
      </TD>
   </TR>
</TABLE>
</BODY>
</HTML>

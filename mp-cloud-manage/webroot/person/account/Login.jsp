<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HEAD>
  <META charset="utf-8">
  <META name="author" content="maochunyang">
  <TITLE>C3D-用户登录</TITLE>
  <LINK rel="stylesheet" href="/acs/default.css?v=2">
</HEAD>
<STYLE>
.Register_Title{
   color: #EEEEEE;
   font-size:18px; 
   font-weight:bold; 
   text-align: center;
   padding-bottom: 16px;
}
.Register_Label{
   width: 100px;
   color: #CCCCCC;
   padding-right: 8px;
   text-align: right;
}
</STYLE>
<SCRIPT language='javascript'>
function trim(value){
   return value.replace(/(^\s*)|(\s*$)/g, ""); 
}
function checkInfo(){
	var passport = trim(document.getElementById("passport").value);
	var password = trim(document.getElementById("password").value);
	if((passport == '') || (password == '')){
		alert("标‘*’是必输项！");
		return false;
	}
   if(passport.length < 4){
		alert("[登录账号]长度不能小于4个字符。");
		return false;
   }
   if(password.length < 6){
		alert("[登录密码]长度不能小于6个字符。");
		return false;
   }
   return true;
}
</SCRIPT>
<BODY>
   <TABLE width='100%' height='100%' class='head_background'>
      <TR>
         <TD height='60px'>
            <TABLE width='100%' height='60px' class='head_background'>
               <TR>
                  <TD width='300px'></TD>
                  <TD><IMG src='/ars/logo.png' style='width:240px;height:34px;'>v0.1.0</TD>
                  <TD width='300px' align='right' style='padding-right:20px'>
                     <A href='/Index.wa' style='color:#999999'>返回首页</A>
                  </TD>
               </TR>
            </TABLE>
         </TD>
      </TR>
      <TR>
         <TD style='color:#999999' align='center'>
            <FORM id='id_form' method='post' action='/person/Account.wa?do=login' onsubmit='return checkInfo();'>
               <TABLE border='0' cellpadding='2'>
                  <TR>
                     <TD colspan='2' class='Register_Title'>用户登录</TD>
                  </TR>
                  <TR>
                     <TD class='Register_Label'>登录账号：</TD>
                     <TD align='left'><INPUT id='passport' name='passport' style='width:160px;'/> <FONT color='#999999'>（*注册时输入的帐号）</FONT></TD>
                  </TR>
                  <TR>
                     <TD class='Register_Label'>登录密码：</td>
                     <TD align='left'><INPUT type='password' id='password' name='password' style='width:160px;'/> <font color='#999999'>（*注册时输入的密码）</font></TD>
                  </TR>
                  <TR>
                     <TD></TD>
                     <TD style='padding-top:16px;'><INPUT type='submit' style='width:80px;' value='提交'/></TD>
                  </TR>
               </TABLE>
            </FORM>
         </TD>
      </TR>
      <TR>
         <TD height='20'>
            <TABLE width='100%' height='60px' class='head_background'>
               <TR>
                  <TD style='color:#999999'>
                     浏览器FireFox/Chrome支持，IE浏览器需要IE11以上支持。移动设备上，支持WEBGL的大部分浏览器都可以运行。<BR>
                     复杂的场景，低配置的浏览器可能无法运行。<BR>
                     邮箱： <A href='mailto:favedit@hotmail.com' style='color:#AAAAAA'>favedit@hotmail.com</A> <A href='"http://www.miitbeian.gov.cn/' style='color:#AAAAAA'>京ICP备15014486号</A>
                  </TD>
               </TR>
            </TABLE>
         </TD>
      </TR>
   </TABLE>
</BODY>
</HTML>

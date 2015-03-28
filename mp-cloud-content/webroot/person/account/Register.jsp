<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册</title>
</head>
<script>
function checkPwd(){
	var passport = document.getElementById("passport").value;
	var password = document.getElementById("password").value;
    var passwordConfirm = document.getElementById("password_confirm").value;
	if(trim(passport) == '' || trim(password) == '' || trim(passwordConfirm) == ''){
		alert("标‘*’是必输项！");
		return false;
	}
	if(password != passwordConfirm){
		alert("两次密码不一致，请重新输入。");
		return false;
	}
}
function trim(str){
return str.replace(/(^\s*)|(\s*$)/g, ""); 
}
</script>
<body>
<a href="/Index.wa">返回</a>
<form id="form" method="post" action="/person/Account.wa?do=register" onsubmit="return checkPwd();">
  <center>
      <table border="0">
      	<th>
        	<td style="font-size:24px; font-weight:bold;">注册</td>
        </th>
        <tr>
          <td align="right" style="width:100px">用户名</td>
          <td align="left"><input id="passport" name="passport" style="width:100px;" /><font color="#FF0000">*</font></td>
        </tr>
        <tr>
          <td align="right" style="width:100px">姓名</td>
          <td align="left"><input id="label" name="label" style="width:100px;" /><font color="#FF0000">*</font>
           </td>
        </tr>
        <tr>
          <td align="right">密码</td>
          <td align="left"><input id="password" name="password" /><font color="#FF0000">*</font>
          </td>
        </tr>
        <tr>
          <td align="right">确认密码</td>
          <td align="left"><input id="password_confirm" name="passwordConfirm"/><font color="#FF0000">*</font>
          </td>
        </tr>
         <tr>
          <td colspan="2" align="center"><input type="submit" value="提交"/></td>          
        </tr>
      </table>
     </center>
</form>
</body>
</HTML>
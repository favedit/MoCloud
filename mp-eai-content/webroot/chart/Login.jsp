<%@ include file='/apl/public.inc' %>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<TITLE>e租宝-全球实时投资数据展示中心(中国)</TITLE>
<META http-equiv='Content-Type' content='text/html;charset=UTF-8'>
<META name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<LINK rel="stylesheet" href='/acs/mobile.css' type="text/css" media="all"/>
<SCRIPT>
function onLogin(){
   frmMain.submit();
}
</SCRIPT>
</HEAD>
<BODY scroll='no' style='overflow:hidden;background-color:#000000;background:url("/ars/eai/background.jpg");background-size:100% 100%;'>
<FORM name='frmMain' method='post' action='Live.wa?do=login'>
<TABLE style='width:100%;height:100%;'>
   <TR>
      <TD align='center'>
   		<H1 style="color:#333333;padding-top:20px;text-align:center;font-size:18px;">钰诚-e租宝-全球实时投资数据展示中心<BR>中国区</H1>
   		<P style="color:#CC3333;text-align:center;font-weight:bold;font-size:14px;">为保证全球实时投资数据展示中心展示的安全性，<BR>我们需要您输入用户名和密码，谢谢。</P>
      <TD>
   <TR>
   <TR>
      <TD align='center'>
			<INPUT type="text" id="username" placeholder="用户名" style='width:200px;margin-top:8px'/><BR>
			<INPUT type="password" id="password" style='width:200px;margin-top:8px'/><BR>
			<INPUT type="button" id="btn" value="登录" onclick='onLogin()' style='width:200px;margin-top:8px'/><BR>
      <TD>
   <TR>
   <TR>
      <TD align='center'>
   		<p style="color:#666666;text-align:center">如果需要使用，请联系 钰诚智慧企业推进中心</p>
   		<p style="color:#666666;text-align:center">联系电话：010-65499299</p>
      <TD>
   <TR>
</TABLE>
</FORM>
</BODY>
</HTML>

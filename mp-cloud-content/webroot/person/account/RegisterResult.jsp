<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HEAD>
  <META charset="utf-8">
  <META name="author" content="maochunyang">
  <TITLE>C3D-用户注册</TITLE>
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
                     |
                     <A href='bbs' style='color:#999999'>论坛</A>
                  </TD>
               </TR>
            </TABLE>
         </TD>
      </TR>
      <TR>
         <TD style='color:#999999' align='center'>
            <FORM id='id_form' action='/Index.wa'>
               <TABLE border='0' cellpadding='2'>
                  <TR>
                     <TD class='Register_Title'>用户注册成功!</TD>
                  <TR>
                  </TR>
                     <TD>
                        <FONT color='#FF9999'>
                           请点击这里返回上一页：<INPUT type='submit' style='width:80px' value='返回'/>
                        </FONT>
                     </TD>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
   <%@ include file='/apl/public.inc' %>
      <html xmlns="http://www.w3.org/1999/xhtml">

      <head>
         <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
         <title>后台管理系统</title>
         <link rel="stylesheet" href="/manage/acs/style.css" type="text/css" media="screen" />
         <link rel="stylesheet" href="/manage/acs/login.css" type="text/css" media="screen" />
         <script type="text/javascript" src="/manage/ajs/jquery/jquery-1.8.0.min.js"></script>
         <script type="text/javascript" src="/manage/ajs/jquery/myselfJs.js"></script>
      </head>
      <body>
         <center>
            <div id="login">
               <div id="input">
                  <dl class="inp_1">
                     <dt>
                	用户名：
                </dt>
                     <dd>
                        密&nbsp;&nbsp;&nbsp;&nbsp;码：
                     </dd>
                  </dl>
                  <dl class="inp_2">
                     <dt>
                	<input id="passport" class="inp_txt_01" type="text">
                </dt>
                     <dd>
                        <input id="password" class="inp_txt_02" type="password">
                     </dd>
                  </dl>
                  <div class="loginbtn">
                     <input onclick="submitForm();" type="image" src="../images/loginbtn.png">
                  </div>
               </div>
            </div>
         </center>
         <script type="text/javascript" language="javascript">            
            function submitForm() {
               if ($("#passport").val().length == 0) {
                  alert("请输入用户名");
                  return;
               }
               if ($("#password").val().length == 0) {
                  alert("请输入密码");
                  return;
               }
               var data = {
                  "passport": $("#passport").val(),
                  "password": $("#password").val()
               };
               $.ajax({
                  type: "POST",
                  url: "/manage/home/Frame.wa?do=loginUser&date=" + new Date().valueOf(),
                  data: data,
                  success: function(msg) {
                     var result = toJsonObject(msg);
                     if (result.status == '0') {
                        $("#passport").val("");
                        $("#password").val("");
                        alertx("用户名或密码错误", "warning");
                     } else if (result.status == '1') {
                        location.href = result.url;
                     } else {
                        alertx("系统异常", "'error'");
                     }
                  }
               });
            }
            document.onkeydown = keyEnter;
            function keyEnter() {
               if (event.keyCode == 13) {
                  submitForm();
               }
            }
         </script>
      </body>

      </html>
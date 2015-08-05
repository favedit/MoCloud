<%@ include file='/apl/public.inc' %>
<HTML>
<HEAD>
   <script>
      function _onload() {
         alert("链接超时，单击确定重新登录。");
         parent.parent.location.href="/manage/home/Frame.wp"; 
      }
   </script>
</HEAD>
<body onload="_onload()">
</body>

</HTML>
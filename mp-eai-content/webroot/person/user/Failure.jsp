<%@ include file='/apl/public.inc' %>
<HTML>
<HEAD>
   <script>
      var result = "<jh:write source='&page.result' />";
      function _onload() {
         alert(result);
         history.back(-1);
      }
   </script>
</HEAD>

<body onload="_onload()">
</body>

</HTML>
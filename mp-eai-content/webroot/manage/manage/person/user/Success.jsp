<%@ include file='/apl/public.inc' %>
<HTML>
<HEAD>
   <script>
      var result = "<jh:write source='&page.result' />";
      function _onload() {
         window.location = result;
      }
   </script>
</HEAD>

<body onload="_onload()">
</body>

</HTML>
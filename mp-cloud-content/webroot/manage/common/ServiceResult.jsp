<%@ include file='/cloud/apl/public.inc'%>
<HTML>
<HEAD>
</HEAD>
<body style="margin:5px;">
  <input onClick="javascript :history.back(-1)" type="button" value="返回上一页"/><br/>
  <div style="width:100%;border:solid 2px #1BABDD;padding:1px; background-color:">  
      <jh:write source='&servicePage.serviceResult' format="text"/>      
  </div>
</body>
</HTML>
<%@ include file='/apl/public.inc'%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>customerList</h1>
<table border="0" cellpadding="2" cellspacing="0">
<tr class="title">
</tr>
<jh:loop alias="product" source="&page.productList">
<tr class="trs">
<td><a href="/pc/marketer/product/customer/CustomerTender.wa?productId=<jh:write source="&product.ouid" />">
<jh:write source="&product.label" />
</a></td>
<td><a
 href="/pc/marketer/product/customer/CustomerTender.wa?productId=<jh:write source="&product.ouid" />"> <jh:write source="&product.icon_url" /></a></td>
</tr>
</jh:loop>
</table>
<p>业绩：<jh:write source="&page.Investment_total" />投资人数：<jh:write source="&page.customer_total" />净投：<jh:write source="&page.netInvestment_total" /></p>
<table border="0" cellpadding="2" cellspacing="0">
<tr class="title">
</tr>
<jh:loop alias="customer" source="&page.customerTenderList">
<tr class="trs">
<td><jh:write source="&customer.customerid" /></td>
<td><a
 href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customer.customerId" />">
<jh:write source="&customer.memberLabel" />
</a></td><td><jh:write source="&customer.genderLabel" /></td>
<td><jh:write source="&customer.memberPhone" /></td>
<td><jh:write source="&customer.investment" /></td>
<td><jh:write source="&customer.redemption" /></td>
<td><jh:write source="&customer.netinvestment" /></td>
<td><jh:write source="&customer.cityLabel" /></td>
<td><jh:write source="&customer.memberLastLoginDate" /></td>
</tr>
</jh:loop>
</table>
     <ul class="pages">
                     <li><a href="javascript:void(0);" onclick="pading(-1)">上一页</a></li>
               <li><jh:write source="&page.pageCurrent" />/<jh:write source="&page.pageTotal" /></li>
               <li><a href="javascript:void(0);" onclick="pading(+1)">下一页</a></li>
                  </ul>
                  <script type="text/javascript">
                  function pading(num){
                  var pageCurrent=<jh:write source="&page.pageCurrent" />;
                  location.href="/pc/marketer/product/customer/CustomerTender.wa?productId=<jh:write source="&page.productId" />&page="+eval(pageCurrent+num);
                  
                  }
                  
                  </script>
</body>
</html>

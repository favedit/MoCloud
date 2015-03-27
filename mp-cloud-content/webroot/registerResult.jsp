<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file='./apl/public.inc'%>
<jh:define source="&personPage" alias="person"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册结果</title>
</head>

<body>
<a href="/register.jsp">返回</a>
<h1 align="center" style="color:#F00"><jh:write source='&person.result'/></h1>
</body>
</html>
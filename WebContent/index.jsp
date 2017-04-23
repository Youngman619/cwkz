<%@page import="java.util.List"%>
<%@page import="wx.sunl.model.Room"%>
<%@page import="wx.sunl.model.EmployeeAccount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>微信学习</title>
<link rel="stylesheet" href="weui-1.0.0/dist/style/weui.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<%
	EmployeeAccount empAccount = (EmployeeAccount)session.getAttribute("empAccount");
%>
	<p class="weui-msg__desc">工号：${empAccount.account}</p>
	<p class="weui-msg__desc">欢迎您登录从吾客栈移动终端</p>
	<hr>
	<div class="weui-grids">
		<c:forEach items="${roomList}" var="room">
			<a href="javascript:;" class="weui-grid">
		       <div class="weui-grid__icon">
		           <img src="weui-1.0.0/src/example/images/icon_tabbar.png" alt="">
		       </div>
		       <p class="weui-grid__label">
		           ${room.roomNo}
		       </p>
    		</a>
		</c:forEach>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</html>
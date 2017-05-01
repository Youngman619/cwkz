<%@page import="wx.sunl.bean.Employee"%>
<%@page import="java.util.List"%>
<%@page import="wx.sunl.bean.Room"%>
<%@page import="wx.sunl.bean.EmployeeAccount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1, minimum-scale=1,user-scalable=0">
<title>微信学习</title>
<link rel="stylesheet" href="weui-1.0.0/dist/style/weui.min.css">
<link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/0.4.0/weui.min.css">
<script src="weui/dist/lib/jquery-2.1.4.js"></script>
</head>
<body ontouchstart>
	<div class="page badge js_show">
		<div class="page__hd">
	        <h1 class="page__title">客栈房间管理</h1>
	    </div>
	</div>
	<div class="weui-grids">
		<c:forEach items="${roomList}" var="room" varStatus="status">
			<a class="weui-grid" id="room${status.index}">
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

</script>
</html>
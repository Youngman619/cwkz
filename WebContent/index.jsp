<%@page import="java.util.List"%>
<%@page import="wx.sunl.bean.Room"%>
<%@page import="wx.sunl.bean.EmployeeAccount"%>
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
	String activeOderNums = (String)request.getAttribute("activeOderNums");
%>
	<p class="weui-msg__desc">工号：${empAccount.account}</p>
	<p class="weui-msg__desc">欢迎您登录从吾客栈移动终端</p>
	<hr>
	<div class="weui-cell weui-cell_access">
		::before
		<div class="weui-cell_bd">
			<span style="vertical-align: middle">订单列表</span>
			<span class="weui-badge" style="margin-left: 5px;"><%=activeOderNums %></span>
		</div>
		<div class="weui-cell__ft">
			"详细信息"
			::after
		</div>
	</div>
	
	<hr>
	<div class="weui-grids">
		<c:forEach items="${roomList}" var="room" varStatus="status">
			<a href="javascript:;" class="weui-grid" id="room${status.index}" onclick="openDialog(${status.index})">
		       <div class="weui-grid__icon">
		           <img src="weui-1.0.0/src/example/images/icon_tabbar.png" alt="">
		       </div>
		       <p class="weui-grid__label">
		           ${room.roomNo}
		       </p>
    		</a>
    		<div id="dialog${status.index}" style="display: none;">
			    <div class="weui-mask"></div>
			    <div class="weui-dialog">
			        <div class="weui-dialog__hd"><strong class="weui-dialog__title">弹窗标题</strong></div>
			        <div class="weui-dialog__bd">${room.roomNo}</div>
			        <div class="weui-dialog__ft">
			            <a class="weui-dialog__btn weui-dialog__btn_primary" onclick="close(${status.index})">确定</a>
			        </div>
			    </div>
			</div>
		</c:forEach>
	</div>
</body>
<script type="text/javascript">
	function openDialog(id){
		var dialogId = 'dialog'+id;
		$("#"+dialogId).removeAttr("style");
	}
	function close(id){
		$("#"+dialogId).remove();
	}
</script>
</html>
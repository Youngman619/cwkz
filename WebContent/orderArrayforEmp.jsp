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
<link rel="stylesheet" href="weui-1.1.0/css/weui.css">
<link rel="stylesheet" href="weui-1.1.0/css/jquery-weui.css">
<link rel="stylesheet" href="weui-1.1.0/css/demos.css">
<script src="weui-1.1.0/js/jquery-2.1.4.js"></script>
</head>
<body ontouchstart>
	<div class="page__bd">
	        <div class="weui-cells">
	        <c:forEach items="${orderList}" var="order" varStatus="status">
	            <div class="weui-cell weui-cell_access">
	                <div class="weui-cell__bd">
	                    <span style="vertical-align: middle">订单编号&nbsp;${order.orderNo}</span>
	                </div>
	                <c:if test="${order.orderStatus=='0'}">
	                	<div class="weui-cell__ft" style="color: red;" id="order${status.index}" onclick="openDialog('${order.orderId}')">New</div>
	                </c:if>
	                <c:if test="${order.orderStatus=='1'}">
	                	<div class="weui-cell__ft" style="color: green;" id="order${status.index}" onclick="openDialog('${order.orderId}')">Ing</div>
	                </c:if>
	                <c:if test="${order.orderStatus=='2'}">
	                	<div class="weui-cell__ft" id="order${status.index}" onclick="openDialog('${order.orderId}')">Done</div>
	                </c:if>
	            </div>
	        </c:forEach>
	        </div>
	    </div>
</body>
<script type="text/javascript">
function openDialog(orderId){
	window.location.href = "<%=request.getContextPath()%>/OrderServlet?method=queryOne&orderId="+orderId;
}
</script>
</html>
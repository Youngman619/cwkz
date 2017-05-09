<%@page import="wx.sunl.bean.Employee"%>
<%@page import="java.util.List"%>
<%@page import="wx.sunl.bean.*"%>
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
<body>
<% 
	Orders orders = (Orders)request.getAttribute("orders"); 
	String orderId = orders.getOrderId();
%>
	<div class="weui-form-preview">
	  <div class="weui-form-preview__hd">
	    <label class="weui-form-preview__label">订单编号</label>
	    <em class="weui-form-preview__value">${orders.orderNo}</em>
	  </div>
	  <div class="weui-form-preview__bd">
	    <div class="weui-form-preview__item">
	      <label class="weui-form-preview__label">房型</label>
	      <span class="weui-form-preview__value">
	      <c:if test="${orders.orderNo=='PD'}">普通大床</c:if>
	      <c:if test="${orders.orderNo=='PB'}">普通标间</c:if>
	      <c:if test="${orders.orderNo=='HD'}">豪华大床</c:if>
	      <c:if test="${orders.orderNo=='HB'}">豪华标间</c:if>
	      </span>
	    </div>
	    <div class="weui-form-preview__item">
	      <label class="weui-form-preview__label">入住日期</label>
	      <span class="weui-form-preview__value">${orders.checkInTime}</span>
	    </div>
	    <div class="weui-form-preview__item">
	      <label class="weui-form-preview__label">订单日期</label>
	      <span class="weui-form-preview__value">${orders.createTime}</span>
	    </div>
	  </div>
	  <div class="weui-form-preview__ft">
	    <a class="weui-form-preview__btn weui-form-preview__btn_primary" href="javascript:">
	      <c:if test="${orders.orderStatus=='0'}">待处理</c:if>
	      <c:if test="${orders.orderStatus=='1'}">已处理</c:if>
	      <c:if test="${orders.orderStatus=='2'}">已过期</c:if>
	    </a>
	  </div>
	  <c:if test="${orders.orderStatus=='0'}">
		  <div class="weui-btn-area">
	            <a href="javascript:;" class="weui-btn weui-btn_primary" id="submitButton">审核订单</a>
	      </div>
	      <div class="weui-btn-area">
	          <a href="javascript:;" class="weui-btn weui-btn_warn" id="cancleButton">退回订单</a>
	      </div>
      </c:if>
	</div>
</body>
<script type="text/javascript">
$('#submitButton').click(function(){
	window.location.href = "<%=request.getContextPath()%>/OrderServlet?method=update&orderStatus=1&orderId=<%=orderId%>";
});

$('#cancleButton').click(function(){
	window.location.href = "<%=request.getContextPath()%>/OrderServlet?method=update&orderStatus=2&orderId=<%=orderId%>";
});
</script>
</html>
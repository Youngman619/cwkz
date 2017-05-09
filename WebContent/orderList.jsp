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
	<header class="demos-header">
      	<header class='demos-header'>
      		<h1 class="demos-title">我的订单</h1>
     	</header>
    </header>
	<c:forEach items="${orderList}" var="order" varStatus="status">
		<div class="weui-form-preview" id="order${status.index}">
		  <div class="weui-form-preview__hd">
		    <label class="weui-form-preview__label">订单编号</label>
		    <em class="weui-form-preview__value">${order.orderNo}</em>
		  </div>
		  <div class="weui-form-preview__bd">
		    <div class="weui-form-preview__item">
		      <label class="weui-form-preview__label">房型</label>
		      <span class="weui-form-preview__value">
		      <c:if test="${order.orderNo=='PD'}">普通大床</c:if>
		      <c:if test="${order.orderNo=='PB'}">普通标间</c:if>
		      <c:if test="${order.orderNo=='HD'}">豪华大床</c:if>
		      <c:if test="${order.orderNo=='HB'}">豪华标间</c:if>
		      </span>
		    </div>
		    <div class="weui-form-preview__item">
		      <label class="weui-form-preview__label">入住日期</label>
		      <span class="weui-form-preview__value">${order.checkInTime}</span>
		    </div>
		    <div class="weui-form-preview__item">
		      <label class="weui-form-preview__label">订单日期</label>
		      <span class="weui-form-preview__value">${order.createTime}</span>
		    </div>
		  </div>
		  <div class="weui-form-preview__ft">
		    <a class="weui-form-preview__btn weui-form-preview__btn_primary" href="javascript:">
		      <c:if test="${order.orderStatus=='0'}">待处理</c:if>
		      <c:if test="${order.orderStatus=='1'}">已处理</c:if>
		      <c:if test="${order.orderStatus=='2'}">已过期</c:if>
		    </a>
		  </div>
		</div>
	</c:forEach>
</body>
<script type="text/javascript">

</script>
</html>
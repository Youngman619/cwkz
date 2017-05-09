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
      		<h1 class="demos-title">客户意见反馈</h1>
     	</header>
    </header>
	<c:forEach items="${adviceList}" var="advice" varStatus="status">
		<div class="weui-cells__title">创建人&nbsp;${advice.userName}</div>
		<div class="weui-cells__title">创建时间&nbsp;${advice.createTime}</div>
		<div class="weui-cells weui-cells_form">
		  <div class="weui-cell">
		    <div class="weui-cell__bd">
		      <textarea class="weui-textarea" rows="3" name="adviceContent">${advice.adviceContent}</textarea>
		      <div class="weui-textarea-counter"><span>0</span>/100</div>
		    </div>
		  </div>
	  	</div>
	</c:forEach>
	  
</body>
</html>
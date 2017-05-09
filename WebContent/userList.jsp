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
	<div class="weui-panel weui-panel_access">
	  <div class="weui-panel__hd">图文组合列表</div>
	  <div class="weui-panel__bd">
	  <c:forEach items="${userList}" var="user" varStatus="status">
	    <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg" onclick="openDialog('${user.userId}')">
	      <div class="weui-media-box__hd">
	        <img class="weui-media-box__thumb" src="weui-1.1.0/images/pic_160.png">
	      </div>
	      <div class="weui-media-box__bd">
	        <h4 class="weui-media-box__title">${user.userName}</h4>
	        <p class="weui-media-box__desc">联系方式&nbsp;${user.userPhoneNumber1}</p>
	      </div>
	    </a>
	   </c:forEach>
	  </div>
	</div>
</body>
<script type="text/javascript">
function openDialog(userId){
	window.location.href = "<%=request.getContextPath()%>/UserServlet?method=queryOne&userId="+userId;
}
</script>
</html>
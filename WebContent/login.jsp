<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="wx.sunl.model.SNSUserInfo,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信学习</title>
<link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/0.4.0/weui.min.css">
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
%>
	<form name="EpmLoginForm" method="post" action="/voastudy/EmpLoginServlet">
		<h1 class="page__title">从吾客栈移动终端</h1>
		<p class="page__desc">员工登录</p>
		<div class="weui-cell__hd"><label class="weui-label">员工编号</label></div>
		<div class="weui-cell__bd">
            <input id="account" name="account" class="weui-input" type="number" pattern="[0-17]*" placeholder="请输入员工号">
        </div>
        
        <div class="weui-cell__hd"><label class="weui-label">密码</label></div>
		<div class="weui-cell__bd">
            <input id="passwd" name="passwd" class="weui-input" type="password" pattern="[0-6]*" placeholder="请输入密码">
        </div>
        
        <div class="weui-btn-area">
            <input type="submit" value="确定">
        </div>
	</form>
	<p class="page__desc" id="errMsg"><%=msg %></p>
</body>
</html>
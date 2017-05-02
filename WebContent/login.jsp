<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="wx.sunl.model.SNSUserInfo,java.lang.*"%>
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
	<h1 style="text-align: center;color: green;">从吾客栈终端系统</h1>
	<p class="weui-msg__desc" style="text-align: center;">——企业端</p>
	<form name="EpmLoginForm" method="post" action="/voastudy/EmpLoginServlet" id="EpmLoginForm" class="weui-cells weui-cells_form">
		<div class="weui-cell">
			<div class="weui-cell__hd"><label class="weui-label">员工编号</label></div>
			<div class="weui-cell__bd">
	            <input id="account" name="account" class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入员工号">
	        </div>
        </div>
        <div class="weui-cell">
	        <div class="weui-cell__hd"><label class="weui-label">密码</label></div>
			<div class="weui-cell__bd">
	            <input id="passwd" name="passwd" class="weui-input" type="password" pattern="[0-9]*" placeholder="请输入密码">
	        </div>
        </div>
        
        <div class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" id="submitButton">确定</a>
        </div>
	</form>
</body>
<script type="text/javascript">	
	$('#submitButton').click(function(){
		$('#EpmLoginForm').submit();
	});
</script>
</html>
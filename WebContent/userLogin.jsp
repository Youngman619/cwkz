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
	<h1 style="text-align: center;font-family: "KaiTi","楷体">西安从<span style="color: red;">吾</span>客栈</h1>
	<p class="weui-msg__desc" style="text-align: center;">一流的服务，舒适的客房，最低的房价</p>
	<form name="UserLoginForm" method="post" action="/voastudy/UserLoginServlet" id="UserLoginForm" class="weui-cells weui-cells_form">
		<div class="weui-cell">
			<div class="weui-cell__hd"><label class="weui-label">预留手机号</label></div>
			<div class="weui-cell__bd">
	            <input id="phone" name="phone" class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入手机号">
	            <input id="sex" name="sex" class="weui-input" type="hidden" value="${snsUserInfo.sex}">
	            <input id="country" name="country" class="text" type="hidden" value="${snsUserInfo.country}">
	            <input id="province" name="province" class="text" type="hidden" value="${snsUserInfo.province}">
	            <input id="city" name="city" class="text" type="hidden" value="${snsUserInfo.city}">
	        </div>
        </div>
        <div class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" id="submitButton">确定</a>
        </div>
	</form>
</body>
<script type="text/javascript">	
	$('#submitButton').click(function(){
		$('#UserLoginForm').submit();
	});
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="wx.sunl.model.SNSUserInfo,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>微信学习</title>
<link rel="stylesheet" href="weui-1.1.0/css/weui.css">
<link rel="stylesheet" href="weui-1.1.0/css/jquery-weui.css">
<link rel="stylesheet" href="weui-1.1.0/css/demos.css">
<script src="weui-1.1.0/js/jquery-2.1.4.js"></script>
</head>
<body ontouchstart>
	 <header class='demos-header'>
      <h1 class="demos-title">个人信息</h1>
     </header>
     <form name="UserInfoForm" method="post" action="/voastudy/UserServlet?method=updateForUsers" id="UserInfoForm" class="weui-cells weui-cells_form">
    	<input class="weui-input" id="userId" name="userId" type="hidden" value="${user.userId}">
    	<input class="weui-input" id="userAddr" name="userAddr" type="hidden" value="${user.userAddr}">
    	<div class="weui-cell">
	        <div class="weui-cell__hd"><label class="weui-label">姓名</label></div>
	        <div class="weui-cell__bd">
	          <input class="weui-input" id="userName" name="userName" type="text" placeholder="您的姓名" value="${user.userName}">
	        </div>
	    </div>
	    <div class="weui-cell weui-cell_select weui-cell_select-after">
	        <div class="weui-cell__hd">
	          <label for="" class="weui-label">性别</label>
	        </div>
	        <div class="weui-cell__bd">
	          <select class="weui-select" id="userSex" name="userSex">
	            <option value="0">女性</option>
	            <option value="1" selected="selected">男性</option>
	          </select>
	        </div>
	    </div>
	    <div class="weui-cell">
	        <div class="weui-cell__hd"><label class="weui-label">身份证号码</label></div>
	        <div class="weui-cell__bd">
	          <input class="weui-input" id="userIDCard" name="userIDCard" type="number" pattern="[0-9]*" placeholder="您的身份证号码" value="${user.userIDCard}">
	        </div>
	    </div>
	    <div class="weui-cells__title">手机号码</div>
	    <div class="weui-cells">
	      	<div class="weui-cell weui-cell_select weui-cell_select-before">
		        <div class="weui-cell__hd">
		          	<select class="weui-select">
			            <option value="1">+86</option>
			            <option value="2">+80</option>
			            <option value="3">+84</option>
			            <option value="4">+87</option>
		          	</select>
		        </div>
		        <div class="weui-cell__bd">
		          <input class="weui-input" id="userPhoneNumber1" name="userPhoneNumber1" type="number" pattern="[0-9]*" placeholder="请输入号码" value="${user.userPhoneNumber1}">
		        </div>
	      	</div>
	    </div>
	    <div class="weui-btn-area">
            <a href="javascript:;" class="weui-btn weui-btn_primary" id="submitButton">保存</a>
        </div>
    </form>
</body>
<script type="text/javascript">
	$('#submitButton').click(function(){
		$('#UserInfoForm').submit();
	});
</script>
</html>
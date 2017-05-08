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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
%>
	<div class="weui-msg">
    <div class="weui-msg__icon-area"><i class="weui-icon-success weui-icon_msg"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">操作成功</h2>
        <p class="weui-msg__desc" id="errMsg"><%=msg %></p>
    </div>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a href="javascript:history.back();" class="weui-btn weui-btn_primary">确定</a>
            <a href="javascript:history.back();" class="weui-btn weui-btn_default">取消</a>
        </p>
    </div>
    <div class="weui-msg__extra-area">
        <div class="weui-footer">
            <p class="weui-footer__links">
                <a href="javascript:void(0);" class="weui-footer__link">从无客栈终端系统</a>
            </p>
            <p class="weui-footer__text">Copyright &copy; 2008-2016 youngman</p>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
	var msg = "${msg}";
	if(msg == "" || msg == null){
		$('#errMsg').hide();
	}
</script>
</html>
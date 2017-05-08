<%@page import="wx.sunl.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<title>微信学习</title>
<link rel="stylesheet" href="weui-1.1.0/css/weui.css">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap-select.css">
<script src="weui-1.1.0/js/jquery-2.1.4.js"></script>
<script src="weui-1.1.0/js/fastclick.js"></script>
<script src="weui-1.1.0/js/jquery-weui.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap-select.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/i18n/defaults-*.min.js"></script>
</head>
<body ontouchstart>
	<div class="page">
	    <div class="page__bd" style="height: 100%;">
			<p class="weui-msg__desc">尊敬的用户：<span style="color: #00AA00;">${user.userPhoneNumber1}</span>,欢迎您预订西安-从吾客栈</p>
			<!-- 滚动图片  -->
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
			  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img src="imanges/cwkz01.jpg" alt="...">
			      <div class="carousel-caption">
			       	 洁白如画的中堂，让您静心怡神。
			      </div>
			    </div>
			    <div class="item">
			      <img src="imanges/cwkz02.jpg" alt="...">
			      <div class="carousel-caption">
			       	 低调奢华的现代化房间，一应俱全。
			      </div>
			    </div>
			    <div class="item">
			      <img src="imanges/cwkz03.jpg" alt="...">
			      <div class="carousel-caption">
			                          古香古色的后院，坐谈禅茶之道。
			      </div>
			    </div>
			  </div>
			</div>

		    <div class="weui-dialog" style="margin-top: 20%;">
		        <div class="weui-dialog__hd"><strong class="weui-dialog__title">预订信息</strong></div>
		        <div class="weui-dialog__bd">在预定前请确认您的个人信息已完善</div>
		        <form name="bookingInfo" id="bookingInfo" method="post" action="/voastudy/OrderServlet?method=save" class="weui-cells weui-cells_form">
		        	<div class="weui-cell">
				        <div class="weui-cell__hd">
				        	<label for="date" class="weui-label">房型选择</label>
				        </div>
				        <div class="weui-cell__bd">
				          <select class= "form-control selectpicker" title='请选择' id="roomType" name="roomType">
							  <option value="PD">普通大床</option>
							  <option value="PB">普通标间</option>
							  <option value="HD">豪华大床</option>
							  <option value="HB">豪华标间</option>
							</select>
				        </div>
			      	</div>
		        	<div class="weui-cell">
		                <div class="weui-cell__hd">
		                	<label for="" class="weui-label">入住日期</label>
		                </div>
		                <div class="weui-cell__bd">
		                    <input class="weui-input" type="datetime-local" value="" name="checkInTime" id="checkInTime"/>
		                </div>
		            </div>
		            <div class="weui-cell">
		                <div class="weui-cell__hd">
		                	<label for="" class="weui-label">退住日期</label>
		                </div>
		                <div class="weui-cell__bd">
		                    <input class="weui-input" type="datetime-local" value="" name="checkOutTime" id="checkOutTime"/>
		                </div>
		            </div>
		            <div class="weui-cell">
		                <div class="weui-cell__hd">
		                	<label for="" class="weui-label">备注要求</label>
		                </div>
		                <div class="weui-cell__bd">
		                    <input class="weui-input" type="text" value="" name="remark" id="remark"/>
		                </div>
		            </div>
		        </form>
		        <div class="weui-dialog__ft">
		        	<a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary" id="submitButton">确定</a>
		        </div>
		    </div>
		    
			<div class="weui-tab" style="position: static;bottom: 0;">
			    <div class="weui-tab__panel">
					
			    </div>
			    <div class="weui-tabbar">
			        <a href="userInfo.jsp" class="weui-tabbar__item">
			            <img src="weui-1.1.0/images/icon_nav_cell.png" alt="" class="weui-tabbar__icon">
			            <p class="weui-tabbar__label">个人资料</p>
			        </a>
			        <a href="<%=request.getContextPath()%>/OrderServlet?method=queryAll&userId=${user.userId}" class="weui-tabbar__item">
			            <img src="weui-1.1.0/images/icon_nav_article.png" alt="" class="weui-tabbar__icon">
			            <p class="weui-tabbar__label">我的订单</p>
			        </a>
			        <a href="javascript:;" class="weui-tabbar__item">
			            <img src="weui-1.1.0/images/icon_nav_panel.png" alt="" class="weui-tabbar__icon">
			            <p class="weui-tabbar__label">投诉建议</p>
			        </a>
			    </div>
			</div>
		</div>
	</div>
</body>
<script>
$('#submitButton').click(function(){
	$('#bookingInfo').submit();
});
</script>
</html>
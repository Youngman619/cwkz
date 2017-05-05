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
<script src="weui-1.1.0/js/jquery-2.1.4.js"></script>
</head>
<body ontouchstart>
<%
	Employee employee = (Employee)session.getAttribute("employee");
	EmployeeAccount empAccount = (EmployeeAccount)session.getAttribute("empAccount");
	String activeOderNums = (String)request.getAttribute("activeOderNums");
	List<Room> roomList = (List<Room>)request.getAttribute("roomList");
%>
	<p class="weui-msg__desc">工号：${empAccount.account}</p>
	<p class="weui-msg__desc">欢迎您登录从吾客栈移动终端</p>
	<hr>
	<div class="page badge js_show">
	    <div class="page__hd">
	        <h1 class="page__title">${employee.empName}</h1>
	        <p class="page__desc">所属部门编号:${employee.empDepNo}</p>
	        <p class="page__desc">所在职位编号:${employee.empJobNo}</p>
	    </div>
	    <div class="page__bd">
	        <div class="weui-cells">
	            <div class="weui-cell weui-cell_access">
	                <div class="weui-cell__bd">订单列表</div>
	                <div class="weui-cell__ft" style="font-size: 0">
	                    <span style="vertical-align:middle; font-size: 17px;" id="ordersArray">详细信息</span>
	                </div>
	            </div>
	            <div class="weui-cell weui-cell_access">
	                <div class="weui-cell__bd">
	                    <span style="vertical-align: middle">房间列表</span>
	                    <span class="weui-badge" style="margin-left: 5px;color: green;"><%=roomList.size() %></span>
	                </div>
	                <div class="weui-cell__ft" id="roomArray"></div>
	            </div>
	            <div class="weui-cell weui-cell_access">
	                <div class="weui-cell__bd">
	                    <span style="vertical-align: middle">公告列表</span>
	                    <span class="weui-badge" style="margin-left: 5px;">8</span>
	                </div>
	                <div class="weui-cell__ft" id="infoArray">详细信息</div>
	            </div>
	            <div class="weui-cell weui-cell_access">
	                <div class="weui-cell__bd">
	                    <span style="vertical-align: middle">客户列表</span>
	                </div>
	                <div class="weui-cell__ft" id="userArray"></div>
	            </div>
	        </div>
	    </div>
	</div>
	<hr>
	<div class="weui-grids">
		<c:forEach items="${roomList}" var="room" varStatus="status">
			<a class="weui-grid" id="room${status.index}" onclick="openDialog('${room.roomType}','${room.isLock}')">
		       <div class="weui-grid__icon">
		           <img src="weui-1.0.0/images/icon_tabbar.png" alt="">
		       </div>
		       <p class="weui-grid__label">
		           ${room.roomNo}
		       </p>
    		</a>
		</c:forEach>
	</div>
</body>
<script type="text/javascript">
	function openDialog(roomType,isLock){
		if(roomType == "PB"){
			roomType = "商务标间";
		}
		if(roomType == "PD"){
			roomType = "商务大床";	
		}
		if(roomType == "HB"){
			roomType = "豪华标间";
		}
		if(roomType == "HD"){
			roomType = "豪华大床";
		}
		if(isLock == "0"){
			isLock = "未预定";	
		}
		if(isLock == "1"){
			isLock = "已预定";
		}
		if(isLock == "2"){
			isLock = "已入住";
		}
		alert("房型:   "+roomType+"\n当前状态:   "+isLock);
	}
	
	$('#roomArray').click(function(){
		window.location.href = "<%=request.getContextPath()%>/RoomServlet?method=queryAll";
	});
</script>
</html>
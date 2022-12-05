<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 离职管理 -->
	<head>
		<meta charset="UTF-8">
		<title>离职员工查询</title>
	</head>
	<script language=JavaScript src="${pageContext.request.contextPath }/js/script.js"></script>
	<style>
		body {
			width:90%;
			background-color: #abd5e1;
		}
		.wz{
			width:100%;
			height: 80%;
			font-size: 26px;
			display: flex;
			align-items: center;
			justify-content: center;
		}
		
		a{
		text-decoration: none;}
	</style>
	<body>
			<span color="black"><strong>&nbsp;当前位置:</strong></span>离职管理
			<br>
			<div class="wz">
				<div align="center">
				<a href="${pageContext.request.contextPath }/DomissionServlet.action?action=findAllDom" target="myiframe">
						<span>离职员工信息查询</span>
					</a>
					<br><br>
					<a href="${pageContext.request.contextPath }/DomissionServlet.action?action=findAllEmp">
						<span>员工信息查询</span>
					</a>
			    </div>
			</div>
	</body>

</html>
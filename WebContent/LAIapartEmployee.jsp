<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 按岗位的查寻这个岗位的所有员工信息 -->
	<head>
		<meta charset="UTF-8">
		<title>岗位调动管理</title>
	</head>
	<script language=JavaScript src="${pageContext.request.contextPath }/js/script.js"></script>
	<style>
		body {
			background-color: #c8eef1;
		}
		table{
			border:1px solid black;
		}
		th{
		color:#FFF;
		background-color: #12788e;
		
		}
		a{
		text-decoration: none;}
		
	</style>
	<body>
		<div>
			当前位置:<a href="${pageContext.request.contextPath }/job/JobServlet.action?action=list">岗位基本信息</a>&gt;岗位员工查询<br />
			<table align="center" width="100%">
				<tr>
					<th align="left">员工号</th>
					<th align="center">姓名</th>
					<th align="center">电话</th>
				</tr>
				<C:forEach items="${emp }" var="emp">
					<tr>
						<td align="left">${emp.em_number }</td>
						<td align="center">${emp.em_name }</td>
						<td align="center">${emp.em_phone }</td>
					</tr>
				</C:forEach>
				
					
			</table>
		</div>
	</body>
</html>
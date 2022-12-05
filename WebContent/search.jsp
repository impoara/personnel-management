<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 按部门查询员工信息 -->
	<head>
		<meta charset="UTF-8">
		<title>search.html</title>
	</head>
	<script language=JavaScript src="${pageContext.request.contextPath }/js/script.js"></script>
	<style>
		body {
			background-color: #c8eef1ss;
		}
		
		.bk {
			width: 100%;
			border: 1px solid black;
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
			<p>当前位置:
				<a href="${pageContext.request.contextPath }/dept/DeptServlet.action?action=list1">部门基本信息</a>&gt;&gt;部门员工查询</p>

			<table class="bk" width="100%" align="center">
				<tr>
					<th align="center">员工号</th>
					<th align="center">姓名</th>
					<th align="center">电话</th>
				</tr>
				<C:forEach items="${employee }" var="employee" >
					<tr>
						<td>
							<div align="center" >${employee.em_number }</div>
						</td>
						<td>
							<div align="center">
								${employee.em_name }
							</div>
						</td>
						<td>
							<div align="center">${employee.em_phone }</div>
						</td>
					</tr>
				</C:forEach>
				</table>
		</div>
	</body>

</html>
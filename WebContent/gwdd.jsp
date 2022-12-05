<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 岗位调动管理  -->
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body {
				background-color: #c8eef1;
			}
			.main {
				width: 100%;
				border: solid 1px black;
				margin: auto;
			}
			td {
				width: 400px;
			}
			.right {
				text-align: right;
			}
			.bk {
				text-align: left;
				border: 1px solid black;
				height:14%;
				width: 18%;
			}
			th{
			color:#FFF;
			background-color: #12788e;
			
			}
			a{
			text-decoration: none;}
			
			#ys{
			font-size:18px;
			margin-left:45%;
			margin-top:2%;
			}
			
			#ys1{
			font-size:16px;
			margin-left:45%;
			margin-top:10px;
			}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/script.js"></script>
	</head>
	<body>
		<p>当前位置:岗位调动管理>>员工信息查询</p>
		<p class="right"><a href="${pageContext.request.contextPath }/Job_changeServlet.action?action=findallcjob">已调动岗位员工信息</a></p>
			<table align="center">
				<tr>
					<td align="center">
						<div id="xianshi1">
							<span>员工信息查询</span>
							<span id="show"></span>
						</div>
					</td>
				</tr>
			</table>
		<form action="${pageContext.request.contextPath }/Job_changeServlet.action">
			<input type="hidden" name="action" value="list">
				<div id="chaxun" class="bk">
						&nbsp;<span>员工号：<input type="text" name="em_number"/></span>
						<br/>
						&nbsp;<span>姓&nbsp;&nbsp;&nbsp;名：<input type="text" name="em_name"/></span>
						<br />
							&nbsp;员工所在岗位:
							<select name="job_number">
								 	<option value="0">请选择</option>
								 	<c:forEach items="${joblist }" var="joblist">
										<option value="${joblist.job_number }">${joblist.job_name }</option>
									</c:forEach>
							</select>
						<br /><br/>
						<input type="submit" value="查询" />
				</div>
		    </form>

		<br />
			<div class="main">
				
				<table class="border">
		<tr>
			<th align="center">员工号</th>
			<th align="center">姓名</th>
			<th align="center">员工岗位</th>
			<th align="center">&nbsp;岗位调动</th>
		</tr>
		<c:forEach items="${empList }" var="empList">
			<tr>
				<td align="center">${empList.em_number }</td>
				<td align="center">${empList.em_name}</td>
				<td align="center">${empList.job.job_name}</td>
				<td align="center">
				<a href="${pageContext.request.contextPath }/Job_changeServlet.action?action=changezhubei&&id=${empList.id}">岗位调动</a></td>
			</tr>
		</c:forEach>
		
	</table>
			</div>
			${message }
			<div id="ys">
			&lt;&lt;
			 <c:forEach begin="1" end="${pagecount }" var="p">
				<a href="${pageContext.request.contextPath }/Job_changeServlet.action?action=findAllEmp&&p=${p}">${p}</a>&nbsp;
			</c:forEach>
			&gt;&gt;
			</div>
			<div id="ys1">
			当前为第&nbsp;${pa }&nbsp;页
			</div>
			
	</body>
</html>
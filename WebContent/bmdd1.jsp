<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!--显示所有调动人员  -->
<!-- 部门调动条件查询 -->
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body {
				background-color: #c8eef1;
			}
			.main {
				width: 87%;
				height: 130px;
			}
			.top {
				font-size: 20px;
			}
		    .mid {
				font-size: 20px;
			}
			.bot {
				font-size: 20px;
			}
			.tab {
				width:50%;
				border: solid 1px black;
				margin: auto;
			}
			td {
				width: 30%;
				list-style: none;
				text-align: left;
				font-size: 15px;
			}
			.bk {
				width: 25%;
				border: 1px solid black;
				
			}
			.right {
				text-align: right;
			}
			.jz {
				margin: auto;
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
		<div class="maindiv">
			<p>当前位置:部门调动管理>>员工信息查询</p>
			<p class="right">
				<a href="${pageContext.request.contextPath }/Dep_changeServlet.action?action=findAllDep_change">已调动部门员工信息</a>
			</p>
				<table align="center">
					<tr>
						<td align="center">
							<div id="xianshi1" align="center">
								<span>员工信息查询</span>
								<span id="show"></span>
							</div>
						</td>
					</tr>
				</table>
				<form action="${pageContext.request.contextPath }/Dep_changeServlet.action" method="get">
				<input type="hidden" name="action" value="list" >
			   <div id="chaxun" class="bk">
					<span>&nbsp;&nbsp;&nbsp;员&nbsp;&nbsp;工&nbsp;&nbsp;号：&nbsp;&nbsp;<input type="text" name="em_number"/></span>
					<br />
					<span>&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="em_name"/></span>
					<br />
					员工所在部门:
						<select name="dept_number">
					        <option value="0">请选择</option>
							<c:forEach items="${deptlist }" var="deptlist">
								<option value="${deptlist.dept_number }" >${deptlist.dept_name }</option>
							</c:forEach>
					    </select>
					<br />
					<br />
					&nbsp;<input type="submit" value="查询" /> &nbsp;&nbsp;&nbsp;
					<input type="reset" value="重新填写" />
				</div>
				</form>
				<br />
				<div class="tab" align="center">
				<table class="jz" width="100%" align="center">
					<tr class="a">
						<th>员工号</th>
						<th>姓名</th>
						<th>员工部门</th>
						<th>部门调动</th>
					</tr>
					<c:forEach items="${domList }" var="domList">
					<tr class="b">
						<td>${domList.em_number }</td>
						<td>${domList.em_name }</td>
						<td>${domList.dept.dept_name }</td>
						<td><a href="${pageContext.request.contextPath }/Dep_changeServlet.action?action=changezhubei&&id=${domList.id }">部门调动</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>

			<div id="ys">
			&lt;&lt;
			 <c:forEach begin="1" end="${pagecount }" var="p">
				<a href="${pageContext.request.contextPath }/Dep_changeServlet.action?action=findAllEmp&&p=${p}">${p}</a>&nbsp;
			</c:forEach>
			&gt;&gt;
			</div>
			<div id="ys1">
			当前为第&nbsp;${pa }&nbsp;页
			</div>
			
	</body>
</html>

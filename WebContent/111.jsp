<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 显示所有已调动人员 -->
<!-- 已调动部门条件查询 -->
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<style>
		body {
			background-color: #c8eef1;
		}
		
		.div1 {
			border: 1px solid #000000;
			margin: auto;
		}
		.jz {
			margin: auto;
		}
		.bk{
		
			border:1px solid black;
		}
		th{
		color:#FFF;
		background-color: #12788e;
		
		}
		.bh{
		width:13%;
		}
		a{
		text-decoration: none;}
	</style>
	<script type="text/javascript" src="js/script.js"></script>
	<body>
		当前位置:部门调动管理&gt;&gt;已调动部门员工信息查询<br>
		<div align="right">
			<a href="${pageContext.request.contextPath }/Dep_changeServlet.action?action=findallzhunbei">员工信息</a>
		</div>
		<div>
			<table align="center">
				<tr>
					<td align="center" id="xianshi1">
						部门信息查询<span id="show"></span>
					</td>
				</tr>
			</table>
		</div>
		<form action="${pageContext.request.contextPath }/Dep_changeServlet.action" method="get">
		<input type="hidden" name="action" value="list1" >
		<div id="chaxun" class="bk" align="center">
		        <span>开始日期：<input type="text" name="em_indate"></span>
		        <br/>
		        <span>结束日期：<input type="text" name="lz_date"></span>
		        <br/>
				<span>员工编号：<input type="text" name="em_number"/></span>
				<br/>
				<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;&nbsp;<input type="text" name="em_name"/></span>
				<br />
				<br />
				<input type="submit" value="查询" />
		</div>
		</form>
        <br />
		<div class="div1 " align="center">
			<table class="jz " width="100%">
				<tr class="jz ">
					<th class="bh">员工号</th>
					<th class="bh">姓名</th>
					<th class="bh">原岗位名称</th>
					<th class="bh">新岗位名称</th>
					<th class="bh">调动类型</th>
					<th class="bh">调动方式</th>
					<th class="bh">调动日期</th>
					<th colspan="3 " class="bh">备注</th>
				</tr>
				<c:forEach items="${changeList }" var="changeList">
				<tr class="jz ">
					<td>${changeList.emp.em_number }</td>
					<td>${changeList.emp.em_name }</td>
					<td>${changeList.dept_before.dept_name }</td>
					<td>${changeList.dept_after.dept_name }</td>
					<td>${changeList.code1.code_value }</td>
					<td>${changeList.code2.code_value  }</td>
					<td>${changeList.dept_chdate }</td>
					<td>${changeList.dept_extra }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>

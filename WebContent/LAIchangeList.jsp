<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!--已调动信息查询  -->
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<style>
		body {
			background-color: #c8eef1;
		}
		td {
			width: 160px;
		}
		.div1 {
			border: 1px solid #000000;
			margin: auto;
		}
		.jz {
			margin: auto;
		}
		.bk{
			width:20%;
			border:1px solid black;
		}
		th{
		color:#FFF;
		background-color: #12788e;
		
		}
		a{
		text-decoration: none;}
	</style>

	<script type="text/javascript" src="js/script.js"></script>
	<body>
		当前位置:部门调动管理&gt;&gt;已调动部门员工信息查询<br>
		<div align="right">
			<a href="${pageContext.request.contextPath }/Job_changeServlet.action?action=findallzhunbei">员工信息</a>
		</div>
		<div>
			<table align="center">
				<tr>
					<td align="center" id="xianshi1">
						岗位信息查询<span id="show"></span>
					</td>
				</tr>
			</table>
		</div>
		<form method="get" action="${pageContext.request.contextPath }/Job_changeServlet.action">
	    <input type="hidden" name="action" value="findOnech">
		<div id="chaxun" class="bk">
		        <span>开始日期：<input type="date" name="em_indate"></span>
		        <br/>
		        <span>结束日期：<input type="date" name="lz_date"></span> <br/>
				<span>员工编号：<input type="text" name="em_number"/></span> <br/>
				<span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="em_name"/></span> <br/>
				<span>调动方式：
						<select name="job_chreason">
							    <option  value="">不限</option>
								<c:forEach items="${job_chtypeCode }" var="job_chtypeCode">
									<option value="${job_chtypeCode.id }">${job_chtypeCode.code_value }</option>
								</c:forEach>
						</select>
				</span>
				<br />
				<br />
				<input type="submit" value="查询" />&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重新填写" class="button">
		</div>
		</form>

	<table width="100%" class="border">
		<tr>
			<th width="6%" align="center">员工号</th>
			<th width="10%" align="center">姓名</th>
			<th width="13%" align="center">原岗位名称</th>
			<th width="13%" align="center">新岗位名称</th>
			<th width="13%" align="center">调动类型</th>
			<th width="13%" align="center">调动方式</th>
			<th width="9%" align="center">调动日期</th>
			<th width="9%" align="center">备注</th>
		</tr>
		<c:forEach items="${cJobList }" var="cJobList">
		<tr>
			<td align="center">${cJobList.emp.em_number }</td>
			<td align="center">${cJobList.emp.em_name }</td>
			<td align="center">${cJobList.job_oldname }</td>
			<td align="center">${cJobList.job_chname }</td>
			<td align="center">${cJobList.code1.code_value }</td>
			<td align="center">${cJobList.code2.code_value }</td>
			<td align="center">${cJobList.job_chdate }</td>
			<td align="center">${cJobList.job_chextra }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	</body>
</html>
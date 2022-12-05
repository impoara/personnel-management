<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 在职人员查询 -->
	<head>

		<meta charset="UTF-8">
		<title>无标题文档</title>
	</head>
	<script language=JavaScript src="${pageContext.request.contextPath }/js/script.js"></script>
	<style>
		.bk {
			width: 100%;
			border: 1px solid black;
		}
		
		#chaxun {
			width: 45%;
			border: 1px solid black;
		}
		
		body {
			background-color: #c8eef1;
		}
		th{
		color:#FFF;
		background-color: #12788e;
		
		}
		a{
		text-decoration: none;}
	</style>

	<body>
		<div id="container">
			<div id="content">
				<div id="content1">
					当前位置:在职人员查询

					<div align="right">
						<a href="${pageContext.request.contextPath }/DomissionServlet.action?action=findAllDom" target="myiframe">查询离职员工信息</a>
					</div>
						<table align="center">
							<tr>
								<td align="center">
									<div id="xianshi1">
										<span style="cursor:hand">员工信息查询</span>
										<span id="show"></span>
									</div>
								</td>
							</tr>
						</table>
					<form action="${pageContext.request.contextPath }/DomissionServlet.action" method="get">
					<input type="hidden" name="action" value="zaizhifind" >
						<table align="center" style="display:none" id="chaxun">
							<tr>
								<td colspan="4">员工信息查询</td>
							</tr>
							<tr align="right">
								<td>&nbsp;&nbsp;部门编号：</td>
								<td><input type="text" name="dep_number"></td>
								<td>&nbsp;&nbsp;部门名称：</td>
								<td><input name="dept_name" type="text"></td>
							</tr>
							<tr align="right">
								<td>&nbsp;&nbsp;员工类型：</td>
								<td>
									<%-- <select >
                      						<C:forEach items="${domi_TypeList }" var="domi_TypeList">
                      							<option value="${domi_TypeList.id }">${domi_TypeList.code_value }</option>
                      						</C:forEach>
		             				</select> --%>
								</td>
								<td>&nbsp;员工编号：</td>
								<td><input type="text" name="em_number"></td>
							</tr>

							<tr>
								<td colspan="4" align="center"><input type="submit" value="查询"></td>
							</tr>
						</table>
				</form>
				</div>

			</div>
		</div>
		<table class="bk" width="100%" align="center" class="border">
			<tr>
				<th>
					<div align="left">&nbsp;&nbsp;员工编号</div>
				</th>
				<th>
					<div align="center">员工姓名</div>
				</th>
				<th>
					<div align="center">部门名称</div>
				</th>
				<th>
					<div align="center">岗位名称</div>
				</th>
				<th>
					<div align="center">性别</div>
				</th>
				<th>
					<div align="center">离职</div>
				</th>
			</tr>
			<C:forEach items="${domList }" var="domList">
			<tr>
				<td>
					<div align="left" >${domList.em_number }</div>
				</td>
				<td>
					<div align="center">${domList.em_name }</div>
				</td>
				<td>
					<div align="center" >${domList.dept.dept_name }</div>
				</td>
				<td>
					<div align="center" >${domList.job.job_name }</div>
				</td>
				<td>
					<div align="center" >${domList.sex ==1 ? "男" : "女" }</div>
				</td>
				<td>
					<div align="center">
						<a href="${pageContext.request.contextPath }/DomissionServlet.action?action=findnumber&&id=${domList.id}">离职</a>
					</div>
				</td>
			</tr>
		    </C:forEach>

		</table>
	</body>

</html>

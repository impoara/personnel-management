<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 离职员工信息查询 -->
	<head>
		<meta charset="UTF-8">
		<title>无标题文档</title>
	</head>
	<style>
		body {
			background-color: #c8eef1;
		}
		
		.bk {
			border: 1px solid black;
			width: 700px;
		}
		
		.jz {
			text-align: center;
		}
		
		.bk1 {
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
	<script language=JavaScript src="${pageContext.request.contextPath }/js/script.js"></script>

	<body>
				<div>
					当前位置:已离职人员查询
					<div align="right">
						<a href="${pageContext.request.contextPath }/DomissionServlet.action?action=findAllEmp">点击此处：查询在职人员信息</a>
					</div>
					<table width="100%" align="center">
						<tr>
							<td align="center">
								<div id="xianshi1" class="jz">
									<span>离职员工查询</span>
									<span id="show"></span>
								</div>
							</td>
						</tr>
					</table>
					<br />
					<form action="${pageContext.request.contextPath }/DomissionServlet.action" method="get">
						<input type="hidden" name="action" value="lizhifind" >
					<table  id="chaxun" class="bk">
						<tr align="right">
							<td>&nbsp;&nbsp;员工编号：</td>
							<td><input type="text" name="em_number"></td>
							<td>&nbsp;&nbsp;员工姓名：</td>
							<td><input type="text" name="em_name"></td>
						</tr>

						<tr align="right">
							<td>&nbsp;&nbsp;岗位名称：</td>
							<td><input type="text" name="job_name"></td>
							<td>&nbsp;部门名称：</td>
							<td><input type="text" name="dept_name"></td>
						</tr>
						<tr align="right">
							<td>&nbsp;&nbsp;开始日期：</td>
							<td><input type="date" name="em_indate"></td>
							<td>&nbsp;&nbsp;结束日期：</td>
							<td><input name="date" type="text" name="lz_date"></td>
						</tr>
						<tr align="right">
							<td>&nbsp;&nbsp;离职类型：</td>
							<td>
								<select name="lz_type">
										<option value="">请选择</option>
                      				<C:forEach items="${domi_TypeList }" var="domi_TypeList">
                      						<option value="${domi_TypeList.id }">${domi_TypeList.code_value }</option>
                      				</C:forEach>
		                        </select>
							</td>
							<td></td>
							<td></td>
						</tr>

						<tr>
							<td colspan="4" align="center"><input type="submit" value="查询"></td>
						</tr>
					</table>
			</form>
					<table class="bk1" width="100%" align="center">
						<tr>

							<th>
								<div align="center">&nbsp;&nbsp;员工编号</div>
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
								<div align="center">离职原因</div>
							</th>

						</tr>
						
							<C:forEach items="${domissionList }" var="domissionList">
							<tr>
								<td>
									<div align="center">${domissionList.emp.em_number }</div>
								</td>
								<td>
									<div align="center" >${domissionList.emp.em_name }</div>
								</td>
								<td>
									<div align="center" >${domissionList.emp.dept.dept_name }</div>
								</td>
								<td>
									<div align="center" >${domissionList.emp.job.job_name }</div>
								</td>
								<td>
									<div align="center" >${domissionList.emp.sex ==1 ? "男" : "女" }</div>
								</td>
							
								<td>
									<div align="center" >${domissionList.code.code_value }</div>
								</td>
							</tr>
								</C:forEach>
						
					</table>
				</div>
	</body>

</html>

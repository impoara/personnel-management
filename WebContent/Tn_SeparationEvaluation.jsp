<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 离职信息 -->
	<head>

		<meta charset="UTF-8">
		<title>离职人事评价</title>
	</head>
	<style>
		body {
			background-color: #c8eef1;
		}
		
		.bk {
			width: 650px;
			border: 1px solid black;
		}
		
		a{
		text-decoration: none;}
	</style>
<script language=JavaScript src="${pageContext.request.contextPath }/js/Tn_SeparationEvaluation.js"></script>
	<body>
		当前位置:
		<a href="Tn_SeparationQuery.jsp">离职管理</a>
		&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/DomissionServlet.action?action=findAllEmp">在职人员查询</a>离职信息<br>
		<form action="${pageContext.request.contextPath }/DomissionServlet.action" method="get">
		<input type="hidden" name="action" value="domupdate" >
		<input type="hidden" name="em_id" value="${domList1.id}" > 
		<input type="hidden" name="dept_number" value="${domList1.dept.dept_number}" > 
		<input type="hidden" name="dept_name" value="${domList1.dept.dept_name}" > 
		<input type="hidden" name="em_number" value="${domList1.em_number}" > 
		<input type="hidden" name="em_name" value="${domList1.em_name }" > 
		
			<table class="bk" align="center">
				<tr>
					<td>部门编号：</td>
					<td><input type="text"  name="dept_number" value="${domList1.dept.dept_number}" disabled="disabled"/> </td>
					<td>部门名称：</td>
					<td><input type="text" name="dept_name" value="${domList1.dept.dept_name}" disabled="disabled"/></td>
				</tr>
	
				<tr>
					<td>员工编号：</td>
					<td><input type="text"  name="em_number" value="${domList1.em_number}" disabled="disabled"/></td>
					<td>员工姓名：</td>
					<td><input type="text" name="em_name"  value="${domList1.em_name }" disabled="disabled"/></td>
				</tr>
	
				<tr>
					<td>离职日期：</td>
					<td><input type="date"  name="lz_date" />${dommessage } </td>
					<td>离职类型：</td>
					<td>
					<select name="lz_type">
                      		<C:forEach items="${domi_TypeList }" var="domi_TypeList">
                      			<option value="${domi_TypeList.id }">${domi_TypeList.code_value }</option>
                      		</C:forEach>
		             </select>
					</td>
				</tr>
	
				<tr>
					<td>离职去向：</td>
					<td><input type="text" name="lz_go" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button"  type="submit" value="确定" />&nbsp;&nbsp;
						<input class="button"  type="reset" />&nbsp;&nbsp;
						<input class="button" type="button" value="返回" id="return0"></td>
				</tr>
			</table>
		</form>
	</body>





</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!--部门的增加  -->
	<head>
		<meta charset="UTF-8">
		<title>add.html</title>
	</head>
	<style>
		body {
			background-color: #c8eef1;
		}
		.bk {
			width: 50%;
			border: 1px solid black;
		}
		
		a{
		text-decoration: none;}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/add1.js"></script> 
	<body>
	<form action="${pageContext.request.contextPath }/dept/DeptServlet.action" method="get">
			<input type="hidden" name="action" value="insertdept">
		<div>
			<p>当前位置:<a href="${pageContext.request.contextPath }/dept/DeptServlet.action?action=list1">部门基本信息</a>&gt;&gt;新建部门</p>
			<p>注：标有*为必填</p>			
				<table align="center" class="bk">
					<tr>
						<td colspan="5" align="center">新建部门</td>
					</tr>
					<tr>
						<td align="right" >*部门编号:</td>
						<td align="left"><input type="text" name="dept_number" id="dept_number">${dmessage }</td>
						<td></td>
						<td align="right">*部门名称:</td>
						<td align="left"><input type="text" name="dept_name" id="dept_name">${d1message }</td>
					</tr>
					<tr>
						<td align="right">*部门类型:</td>
						<td align="left">
						<select name="dept_type" id="dept_type">
										<option value="0">1.不限</option>
										<C:forEach items="${codelist1 }" var="codelist1">
											<option value="${codelist1.id }">${codelist1.code_value }</option>
										</C:forEach>
						</select>
						</td>
						<td></td>
						<td align="right">*电话:</td>
						<td align="left"><input type="text" name="dept_tel" id="dept_tel">${d3message }</td>
					</tr>
					<tr>
						<td align="right">传真:</td>
						<td align="left"><input type="text" name="dept_fax">${d4message }</td>
						<td></td>
						<td align="right">描述:</td>
						<td align="left"><input type="text" name="dept_desc"></td>
					</tr>
					<tr>
						<td align="right">上级部门:</td>
						<td align="left">

							<select name="dept_super">
										<option value="">无</option>
									<C:forEach items="${deptlist }" var="deptlist">																			
											<option value="${deptlist.getId() }">${deptlist.getDept_name() }</option>									
									</C:forEach>
							</select>
						</td>
						<td></td>
						<td align="right">*成立日期:</td>
						<td align="left"><input type="date" name="dept_setdate" id="dept_setdate">${d2message }</td>
					</tr>
					<tr>
						<td align="right" colspan="2">
							<input type="submit" value="保存" >&nbsp;&nbsp;
						    <input type="reset" value="重新填写" class="button">&nbsp;&nbsp;
						    <input type="button" value="返回" id="return1">
						</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
		</div>
		</form>
	</body>
</html>
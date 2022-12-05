<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 部门修改 -->
	<head>

		<meta charset="UTF-8">
		<title>update.html</title>
	</head>
	<style>
		body {
			background-color: #c8eef1;
		}
		
		.bk {
			width: 45%;
			height: 130px;
			border: 1px solid black;
		}
		
		a{
		text-decoration: none;}
	</style>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/update.js"></script>

	<body>
	<form action="/Personnel/dept/DeptServlet.action">
		<input type="hidden" name="action" value="update11">
		<input type="hidden" name="id" value="${emplist.get(0).getId() }">
		<input type="hidden" name="dept_number" value="${emplist.get(0).getDept_number() }">
		<div>
			<p>当前位置:
				<a href="${pageContext.request.contextPath }/dept/DeptServlet.action?action=list1">部门基本信息</a>&gt;&gt;修改部门</p>
			<p>注：标有*为必填</p>
			<table class="bk" align="center">
				<tr>
					<td align="right">*部门编号:</td>
					<td align="left"><input type="text" name="dept_number" value="${emplist.get(0).getDept_number() }" disabled="disabled"></td>
					<td></td>
					<td align="right">*部门名称:</td>
					<td align="left"><input type="text" name="dept_name" value="${emplist.get(0).getDept_name() }">${d1message }</td>
				</tr>
				<tr>
					<td align="right">*部门类型:</td>
					<td align="left">
						<select name="dept_type">
				
							<option value="39" ${emplist.get(0).getDept_type() =="39" ? "selected" : "" }>1.公司</option>
							<option value="40" ${emplist.get(0).getDept_type() =="40" ? "selected" : "" }>2.部门</option>
						</select>
					</td>
					<td></td>
					<td align="right">*电话:</td>
					<td align="left"><input type="text" name="dept_tel" value="${emplist.get(0).getDept_tel() }">${d3message }</td>

				</tr>

				<tr>
					<td align="right">传真:</td>
					<td align="left"><input type="text" name="dept_fax" value="${emplist.get(0).getDept_fax() }">${d4message }</td>
					<td></td>
					<td align="right">描述:</td>
					<td align="left"><input type="text" name="dept_desc" value="${emplist.get(0).getDept_desc() }"></td>
				</tr>
				<tr>
					<td align="right">上级部门:</td>
					<td align="left">
						<select name="dept_super">
									<option value="-1">无上级部门</option>
									<C:forEach items="${deptlist }" var="deptlist">																			
											<option value="${deptlist.getId() }" ${deptlist.getId() == emplist.get(0).getDept_super().getId() ? "selected" :"" }> ${deptlist.getDept_name() }</option>									
									</C:forEach>
						</select>
					</td>
					<td></td>
					<td align="right">*成立日期:</td>
					<td align="left"><input type="date" name="dept_setdate" value="${emplist.get(0).getDept_setdate() }">${d2message }</td>
				</tr>
				<tr>
					<td align="right"><input type="submit" value="保存">
						<td><input type="reset" value="重新填写" class="button">
							<input type="button" value="返回"  id="return1"></td>
						<td>&nbsp;</td>
				</tr>
			</table>
		</div>
		</form>
	</body>

</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 部门查询所有 -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>message</title>
	<style>
		.bk {
			width: 100%;
			border: 1px solid black;
		}
		#chaxun {
			width: 30%;
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
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/add.js"></script>
	</head>
	<body>
		<p>当前位置:部门基本信息</p>
				<form action="${pageContext.request.contextPath }/dept/DeptServlet.action" method="get">
				    <input type="hidden" name="action" value="selectif">
			<table align="center">
				<tr>
					<td align="center">
						<div id="xianshi1">
							<span>部门信息查询</span>
							<span id="show"></span>
						</div>
					</td>
				</tr>
			</table>
		<div id="chaxun">
				<span>部门编号:<input type="text" name="dept_number"/></span>
				<br />
				<span>部门名称:<input type="text" name="dept_name"/></span>
				<br />
				<span>
					部门类型:
					<select name="dept_type">
						<option value="0">1.不限</option>
						<C:forEach items="${deptTypeList }" var="deptTypeList">
							<option value="${deptTypeList.id }">${deptTypeList.code_value }</option>
						</C:forEach>
					</select>
				</span>
				<br />
				<input type="submit" value="查询" /> &nbsp;&nbsp;
				<input type="reset" value="重新填写" />
		</div>
		</form>

		
		<br />
			<table class="bk">
			<tr>
					<th>
						<div align="center">部门编号</div>
					</th>
					<th>
						<div align="center">部门名称</div>
					</th>
					<th>
						<div align="center">部门类型</div>
					</th>
					<th>
						<div align="center">电话</div>
					</th>
					<th>
						<div align="center">传真</div>
					</th>
					<th>
						<div align="center">描述</div>
					</th>
					<th>
						<div align="center">上级部门</div>
					</th>
					<th>
						<div align="center">成立日期</div>
					</th>
					<th>
						<div align="center">员工</div>
					</th>
					<th>
						<div align="center">删除</div>
					</th>
				</tr>
			<C:forEach items="${deptlist0 }" var="deptlist0">
				<tr>
					<td>
						<div align="center">${deptlist0.getDept_number() }</div>
					</td>
					<td>
						<div align="center">
							<a href="/Personnel/dept/DeptServlet.action?action=update&&id=${deptlist0.id}">${deptlist0.getDept_name() }</a>
						</div>
					</td>
					<td>
						<div align="center">${deptlist0.getCode_type().getCode_value()}</div>
					</td>
					<td>
						<div align="center">${deptlist0.getDept_tel() }</div>
					</td>
					<td>
				
						<div align="center">${deptlist0.dept_fax }</div>
					</td>
					<td>
						<div align="center">${deptlist0.getDept_desc() }</div>
					</td>
					<td>
						<div align="center">${deptlist0.getDept_super().getDept_name() }</div>
					</td>
					<td>
						<div align="center">${deptlist0.getDept_setdate() }</div>
					</td>
					<td>
						<div align="center">
							<a href="/Personnel/dept/DeptServlet.action?action=deptif&&number=${deptlist0.getDept_number() }">员工</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="/Personnel/dept/DeptServlet.action?action=delete&&id=${deptlist0.id}" onclick="return confirm('你确定要删除吗 ' ) ">删除</a>
						</div>
					</td>
				</tr>
				</C:forEach>
				
				<C:forEach items="${selif }" var="selif">
				<tr>
					<td>
						<div align="center">${selif.getDept_number() }</div>
					</td>
					<td>
						<div align="center">
							<a href="/Personnel/dept/DeptServlet.action?action=update&&id=${selif.id}">${selif.getDept_name() }</a>
						</div>
					</td>
					<td>
						<div align="center">${selif.getCode_type().getCode_value()}</div>
					</td>
					<td>
						<div align="center">${selif.getDept_tel() }</div>
					</td>
					<td>
						<div align="center">${selif.dept_fax }</div>
					</td>
					<td>
						<div align="center">${selif.getDept_desc() }</div>
					</td>
					<td>
						<div align="center">${selif.getDept_super().getDept_name() }</div>
					</td>
					<td>
						<div align="center">${selif.getDept_setdate() }</div>
					</td>
					<td>
						<div align="center">
							<a href="/Personnel/dept/DeptServlet.action?action=deptif&&number=${selif.getDept_number() }">员工</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="/Personnel/dept/DeptServlet.action?action=delete&&id=${selif.id}" onclick="return confirm('你确定要删除吗 ' ) ">删除</a>
						</div>
					</td>
				</tr>
				</C:forEach>
			</table>
			
			<br>
			<input type="button" value="增加" id="button">
		<% String message=(String)session.getAttribute("message");%>
		<% 
		   if(message!=null){
			out.print(message);
			session.removeAttribute("message");
		   } 
		 %>
			
	</body>
</html>
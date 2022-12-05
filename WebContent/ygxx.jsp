<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 显示员工信息 -->
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body {
				background-color: #c8eef1;
			}
			
			.ygxxmdiv {
				width: 100%;
				height: 100%;
			}
			
			.ygxxdiv {
				width: 100%;
				border: solid 1px black;
			}
			
			#chaxun {
				width: 300px;
				height: 150px;
				border: solid 1px black;
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
		<div class="ygxxmdiv">
			当前位置:员工信息中心
			<br>
			<table width="100%" align="center">
				<tr>
					<td>
					<form action="${pageContext.request.contextPath }/Employee.action" method="get">
					<input type="hidden" name="action" value="selectif">
						<table width="100%" align="center">
							<tr>
								<td align="center">
									<span id="xianshi1">员工信息查询</span>
									<span id="show"></span>
								</td>
							</tr>            
							<table align="left" id="chaxun">
								<tr>
									<td align="right"> 员工编号：</td>
									<td>
										<input type="text" name="em_number"/>
									</td>
								</tr>
								<tr>
									<td align="right">姓 名：</td>
									<td>
										<input type="text" name="em_name"/>
									</td>
								</tr>
								<tr>
									<td align="right">部门名称：</td>
									<td>
										<select name="dept_number">
									        <option value="0">请选择</option>
											<c:forEach items="${deptlist }" var="deptlist">
												<option value="${deptlist.dept_number }">${deptlist.dept_name }</option>
											</c:forEach>
									    </select>
									</td>
								</tr>
								<tr>
									<td align="right">岗位名称：</td>
									<td>
										<select name="job_number">
											<option value="0">请选择</option>
											<c:forEach items="${joblist }" var="joblist">
												<option value="${joblist.job_number }">${joblist.job_name }</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td><br/>
										&nbsp;<input type="submit" value="查询" />&nbsp;&nbsp;&nbsp;
										<input type="reset" value="重置" />
									</td>
								</tr>

							</table>

						</table>
						</form>

					<div class="ygxxdiv">
			
						<table width="100%" align="center">
							<tr>
								<th>员工编号</th>
								<th>姓名</th>
								<th>部门名称</th>
								<th>岗位名称</th>
								<th>联系电话</th>
								<th>电子邮件</th>
								<th>&nbsp;</th>
							</tr>
							<c:forEach items="${empList }" var="empList">
								<tr>
									<td>${empList.em_number }</td>
									<td>${empList.em_name }</td>
									<td>${empList.dept.dept_name }</td>
									<td>${empList.job.job_name }</td>
									<td>${empList.em_phone }</td>
									<td>${empList.em_mail }</td>
									<td>
										<a href="${pageContext.request.contextPath }/Employee.action?action=updateqian&&id=${empList.id}">修改</a>
									</td>
								</tr>
							</c:forEach>
					     </table>
				    </div>
		        </td>
		     </tr>
		     <tr>
		     <td></td>
		     <td></td>
		     <td></td>
		     <td>
		   <div id="ys">
		   &lt;&lt;
		   <c:forEach begin="1" end="${pagecount }" var="p">
				<a href="${pageContext.request.contextPath }/Employee.action?action=findall&&p=${p}">${p}</a>&nbsp;
			</c:forEach>
			&gt;&gt;
			</div>
			<div id="ys1">
			当前为第&nbsp;${pa }&nbsp;页
			</div>
			</td>
			<td></td>
			<td></td>
			<td></td>
		   </tr>
		   </table>
		   ${message }
		   
		</div>
	</body>
</html>
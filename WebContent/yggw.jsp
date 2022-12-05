<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 岗位修改 -->
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body {
				background-color: #c8eef1;
			}
			
			.jz {
				display: flex;
				justify-content: center;
				width: 100%;
			}
			
			table {
				border: 1px solid black;
				width: 45%;
			}
			
			a{
			text-decoration: none;}
		</style>
		<script type="text/javascript" src="js/yggw.js"></script>
	</head>

	<body>
		<span>当前位置:岗位调动管理>></span>
		<a href="${pageContext.request.contextPath }/Job_changeServlet.action?action=findallzhunbei">员工信息查询</a>>确认员工岗位<br /><br />
		<form action="${pageContext.request.contextPath }/Job_changeServlet.action" method="get">
		    <input type="hidden" name="action" value="change">
		     <input type="hidden" name="em_number" value="${emp.em_number}">
		      <input type="hidden" name="em_name" value="${emp.em_name}">
		       <input type="hidden" name="emid" value="${emid}">
		<div class="jz">
		
			<table>
				<tr>
					<th colspan="2">员工岗位信息</th>
				</tr>
				<tr>
					<td>员工号：<input type="text" name="em_number" value="${emp.em_number}" disabled="disabled"/></td>
					<td>员工姓名：<input type="text" name="em_name" value="${emp.em_name}" disabled="disabled"/></td>
				</tr>
				<tr>
					<td>
						调动后的岗位：
						<select name="job_chnumber">
							<C:forEach items="${joblist }" var="joblist">
							<C:choose>
							<C:when test="${joblist.job_number != emp.getJob().getJob_number()}">
								<option value="${joblist.job_number}">${joblist.job_name }</option>
							</C:when>
							</C:choose>
							</C:forEach>
						</select> 
					</td>
					<td>
						调转原因：
						<select name="job_chreason">
							<C:forEach items="${job_chtypeCode }" var="job_chtypeCode">
								<option value="${job_chtypeCode.id}">${job_chtypeCode.code_value }</option>
							</C:forEach>
						</select> 
					</td>
				</tr>
				<tr>
					<td>
						调转类型：
						<select name="job_chtype">
							<C:forEach items="${dept_chtypeCode }" var="dept_chtypeCode">
								<option value="${dept_chtypeCode.id}">${dept_chtypeCode.code_value }</option>
							</C:forEach>
						</select> 
					</td>
					<td>
						调转日期：<input type="date" name="job_chdate" />${jcmessage }
					</td>
				</tr>
				<tr>
					<td colspan="2">备注：
						<textarea rows="3" name="job_chextra" ></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="保存"  id="add3"/>&nbsp;&nbsp;
						<input type="reset" value="重新填写" />&nbsp;&nbsp;
						<input type="button" value="返回" id="return3"/>

					</td>
				</tr>
			</table>
		</div>
		</form>
	</body>

</html>
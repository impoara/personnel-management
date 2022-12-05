<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 岗位的添加 -->
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body {
				background-color: #c8eef1s;
			}
			table{
				border:1px solid black;
			}
		</style>
		<script type="text/javascript"  src="${pageContext.request.contextPath }/js/LAIaddWork.js" ></script>
	</head>
	<body>
			当前位置:
			<a href="JobServlet.action?action=list">岗位基本信息</a> &gt;&gt; 新增岗位
			<br>
			<p>注:标有 * 的项必填</p>
			<form action="${pageContext.request.contextPath }/job/JobServlet.action" method="get">
			<input type="hidden" name="action" value="updateJob">
			<input type="hidden" name="job_number" value="${coun }">
			<table align="center">
				<tr>
					<td align="center" colspan="5">
						<div align="center">新增岗位</div>
					</td>
				</tr>
				<tr>
					<td align="right">*岗位编号：</td>
					<td>
						<input type="text" name="job_number" value="${coun }" disabled="disabled"> ${jmessage }
					</td>
					<td></td>
					<td align="right">岗位名称：</td>
					<td>
						<input type="text" name="job_name"> ${jmessage1 }
					</td>
				</tr>
				<tr>
					<td align="right">*岗位类型：</td>
					<td>
						<select name="job_type" id="gelx">
							<C:forEach items="${codelist }" var="code">
								<option value="${code.id }" ${code.id ==job_type ? "selected" : "" }>${code.code_value }</option>
							</C:forEach>
						</select>
					</td>
					<td></td>
					<td align="right">*岗位编制人数：</td>
					<td><input type="text" name="job_max"> ${jmessage2 }</td>
				</tr>
				<tr>
					<td align="right" colspan="2">
						<input type="submit" value="保存 " >&nbsp;&nbsp;
						<input type="reset" value=" 重新填写 ">&nbsp;&nbsp;
						<input type="button" value="返回 " id="r1"> 
					</td>
				</tr>
			</table>
			</form>
			
	</body>
</html>
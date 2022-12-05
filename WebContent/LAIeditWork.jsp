<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!--岗位修改  -->
	<head>
		<title></title>
		<meta charset="UTF-8">
		<style>
			body {
				background-color: #c8eef1;
			}
			.bk {
			
				border: 1px solid black;
			}
			
		a{
		text-decoration: none;}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/LAIeditWork.js"></script> 
		<body>
		<form action="${pageContext.request.contextPath }/job/JobServlet.action" method="get">
		<input type="hidden" name="action" value="xiugai2">
		<input type="hidden" name="id"  id="id" value="${joblist11.get(0).getId() }">
		<input type="hidden" name="job_number" value="${joblist11.get(0).getJob_number() }">
			<div>
				当前位置:
				<a href="${pageContext.request.contextPath }/job/JobServlet.action?action=list" >岗位基本信息</a> &gt; 修改岗位
				<br> 注:标有 * 的项必填
				<table class="bk" align="center">
					<tr>
						<td colspan="4" align="center">新增岗位</td>
					</tr>
					<tr>
						<td align="right">*岗位编号：</td>
						<td align="left"><input type="text" value="${joblist11.get(0).getJob_number() }" name="job_number" id="job_number" disabled="disabled">${jmessage }</td>
						<td align="right">岗位名称：</td>
						<td align="left"><input type="text" value="${joblist11.get(0).getJob_name() }" name="job_name">${jmessage1 }</td>
					</tr>
					<tr>
						<td align="right">*岗位类型：</td>
						<td align="left">
						
							<select name="job_type" id="job_type">
								<option value="48" ${joblist11.get(0).getJob_type_name() == "技术" ? "selected" : "" }>1.技术</option>
								<option value="49" ${joblist11.get(0).getJob_type_name() == "管理" ? "selected" : "" }>2.管理</option>
								<option value="50" ${joblist11.get(0).getJob_type_name() == "销售" ? "selected" : "" }>3.销售</option>

							</select>
						</td>
						<td align="right">*岗位编制人数：</td>
						<td align="left" ><input type="text" value="${joblist11.get(0).getJob_max() }" name="job_max">${jmessage2 }</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="保存 " >&nbsp;&nbsp;
							<input type="reset" value=" 重新填写 ">&nbsp;&nbsp;
							<input type="button"  value="返回 "  id="returnwork">
						</td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
			</form>
			
		</body>
</html>
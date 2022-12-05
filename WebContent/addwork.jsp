<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!--  -->
	<head>
		<title></title>
		<meta charset="UTF-8">
		<style>
			body {
				background-color: #c8eef1F;
			}
			.bk {
				width: 45%;
				border: 1px solid black;
			}
			th{
			color:#FFF;
			background-color: #12788e;
			
			}
			a{
			text-decoration: none;}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/addwork.js"></script>
	</head>
	<body>
		<div>
				当前位置:
				<a href="LAIworkList.html">岗位基本信息</a> &gt; 修改岗位
				<br/>注:标有 * 的项必填
				<table class="bk" align="center">
					<tr>
						<td align="right">*岗位编号：</td>
						<td align="left">
							<input type="text" value="C10201">
						</td>
						<td></td>
						<td align="right">岗位名称：</td>
						<td align="left">
							<input type="text" value="软件设计师">
						</td>
					</tr>
					<tr>
						<td align="right">*岗位类型：</td>
						<td align="left">
							<select>
								<option>1.技术</option>
								<option>2.营销</option>
								<option>3.市场</option>
							</select>
						</td>
						<td></td>
						<td align="right">*岗位编制人数：</td>
						<td align="left"><input type="text" value="100"></td>
					</tr>
					<tr>
						<td align="right" colspan="2">
							<input type="button" value="保存 ">&nbsp;&nbsp;
							<input type="reset" value=" 重新填写 ">&nbsp;&nbsp;
							<input type="button" value=" 返回 "> </td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
		</div>
		 ${jmessage }
	</body>
</html>
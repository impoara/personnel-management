<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!--岗位的显示全部，及条件查询  -->
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body {
				background-color: #c8eef1;
			}
			.jz {
				text-align: center;
			}
			.bk {
				width: 100%;
				border: 1px solid black;
			}
			#chaxun {
				width: 30%;
				height: 110px;
				border: 1px solid black;
			}
			th{
			color:#FFF;
			background-color: #12788e;
			
			}
			a{
			text-decoration: none;}
		</style>
		<title>岗位基本信息</title>
	</head>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/js/LAIworkList.js" ></script>
	<body>
	
		<div>
				<p>当前位置:岗位基本信息</p>
				<form action="${pageContext.request.contextPath }/job/JobServlet.action" method="get">
				<input type="hidden" name="action" value="tiaojian">
					<table width="100%" align="center" >
						<tr>
							<td>
        						<div id="xianshi1" class="jz">
									<span>岗位信息查询</span>
									<span id="show"></span>
								</div>
								<div id="chaxun">
										<span>岗位编号:<input type="text" name="job_number"/></span>
										<br />
										<span>岗位名称:<input type="text" name="job_name" /></span>
										<br />
										<span>
											<select name="job_type">
													<option value="0">1.不限</option>
													<C:forEach items="${codeList }" var="codeList">
														<option value="${codeList.id }">${codeList.code_value }</option>
													</C:forEach>
											</select>

										</span>
										<br />
										<input type="submit" value="查询" /> &nbsp;&nbsp;
										<input type="reset" value="重新填写" />
								</div>
							</td>
						</tr>
					</table>
					</form>
					<br />
				<table class="bk" width="100%">
					<tr>
						<th>
							<div align="center">岗位编号</div>
						</th>
						<th>
							<div align="center">岗位名称</div>
						</th>
						<th>
							<div align="center">类型</div>
						</th>
						<th>
							<div align="center">岗位编制</div>
						</th>
						<th>
							<div align="center">在岗人数</div>
						</th>
						<th>
							<div align="center">员工</div>
						</th>
						<th>
							<div align="center">删除</div>
						</th>
					</tr>
					<C:forEach items="${joblist}" var="joblist" >
					<tr>
						<td>
							<div align="center" >${joblist.job_number }</div>
						</td>
						<td>
							<div align="center">
								<a href="/Personnel/job/JobServlet.action?action=xiugai&&id=${joblist.id}">${joblist.job_name }</a>
							</div>
						</td>
						<td>
							<div align="center">${joblist.job_type_name }</div>
						</td>
						<td>
							<div align="center">${joblist.job_max }</div>
						</td>
						<td>
							<div align="center">${joblist.job_man }</div>
						</td>
						<td>
							<div align="center">
								<a href="/Personnel/job/JobServlet.action?action=employee&&job_number=${joblist.job_number }">员工</a>
							</div>
						</td>
						<td>
							<div align="center">
								<a href="/Personnel/job/JobServlet.action?action=dele&&deid=${joblist.id}&&jobman=${joblist.job_man}" onclick="return confirm('你确定要删除吗？')">删除</a>
							</div>
						</td>
					</tr>
					</C:forEach>
		
				</table>
				<table>
					<tr>
						<td>
							<input type="button" id="button1" value="增加" >
					    </td>
				    </tr>
			    </table>
${message }
	 <%
		session.removeAttribute("message"); 
	
	%>
	 	 </div>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 信息修改 -->
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body {
				background-color: #c8eef1;
			}
			
			.bk {
				width: 100%;
				border: 1px solid black;
			}
			
			a{
			text-decoration: none;}
		</style>
	</head>

	<body>
		<p>当前位置:信息修改</p>
		<form action="${pageContext.request.contextPath }/Employee.action"  method="get">
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="id" value="${emplist.get(0).getId() }">
		<input type="hidden" name="enumber" value="${emplist.get(0).getEm_number() }">
		<input type="hidden" name="em_number" value="${emplist.get(0).getEm_number() }">
		<input type="hidden" name="dept_number" value="${emplist.get(0).getDept().getDept_number()}">
		<input type="hidden" name="job_number" value="${emplist.get(0).getJob().getJob_number()}">
		
			<table class="bk" class="border" width="100%">
				<tr>
					<td align="right"> 员工编号</td>
					<td>
						<input type="text" name="em_number" value="${emplist.get(0).getEm_number() }" disabled="disabled">
					</td>
					<td align="right">姓名 </td>
					<td>
						<input type="text" name="em_name" value="${emplist.get(0).getEm_name() }">${e1message }
					</td>
					<td align="right">性别</td>
					<td>
						 <select name="sex">
							<C:forEach items="${em_SexList }" var="em_SexList">
								<option value="${em_SexList.id }" ${em_SexList.id == emplist.get(0).sex ? "selected" : "" }>${em_SexList.code_value }</option>
							</C:forEach>
						</select> 
					</td>
				</tr>
	
				<tr>
					<td align="right"> 出生日期 </td>
					<td>
						<input type="date" name="em_birth" value="${emplist.get(0).getEm_birth() }">${e2message }
					</td>
					<td align="right">身份证号 </td>
					<td>
						<input type="text" name="em_id" value="${emplist.get(0).getEm_id() }">${e4message }
					</td>
					<td align="right"></td>
					<td></td>
				</tr>
	
				<tr>
					<td align="right">入职日期 </td>
					<td>
						<input type="date" name="em_indate" value="${emplist.get(0).getEm_indate() }">${e3message }
					</td>
					<td align="right">参加工作时间</td>
					<td>
						<input type="date" name="em_worktime" value="${emplist.get(0).getEm_worktime() }">${e5message }
					</td>
					<td align="right">用工形式</td>
					<td>
						<select name="em_format" >
							<C:forEach items="${em_FormatList }" var="em_FormatList">
								<option value="${em_FormatList.id }" ${em_FormatList.id == emplist.get(0).em_format ? "selected" : "" }>${em_FormatList.code_value }</option>
							</C:forEach>
						</select> 
					</td>
				</tr>
	
				<tr>
					<td align="right">人员来源</td>
					<td>
						<select name="em_source">
							
							<C:forEach items="${em_SourceList }" var="em_SourceList">
								<option value="${em_SourceList.id }" ${em_SourceList.id == emplist.get(0).em_source ? "selected" : "" }>${em_SourceList.code_value }</option>
							</C:forEach>
						</select>
					</td>
					<td align="right">政治面貌</td>
					<td>
						<select name="em_polity">
					
							<C:forEach items="${em_PolityList }" var="em_PolityList">
								<option value="${em_PolityList.id }" ${em_PolityList.id == emplist.get(0).em_polity ? "selected" : "" }>${em_PolityList.code_value }</option>
							</C:forEach>
						</select>
					</td>
					<td align="right">民族</td>
					<td>
						<select name="em_folk">
						
							<C:forEach items="${em_FolkList }" var="em_FolkList">
								<option value="${em_FolkList.id }" ${em_FolkList.id == emplist.get(0).em_folk ? "selected" : "" }>${em_FolkList.code_value }</option>
							</C:forEach>
						</select>
					</td>
				</tr>
	
				<tr>
					<td align="right">籍贯 </td>
					<td>
						<input type="text" name="em_birthplace" value="${emplist.get(0).getEm_birthplace() }">
					</td>
					<td align="right">联系电话 </td>
					<td>
						<input type="text" name="em_phone" value="${emplist.get(0).getEm_phone() }">${e7message }
					</td>
					<td align="right">电子邮件 </td>
					<td>
						<input type="email" name="em_mail" value="${emplist.get(0).getEm_mail() }">
					</td>
				</tr>
	
				<tr>
					<td align="right">身高 </td>
					<td>
						<input type="text" name="em_stature" value="${emplist.get(0).getEm_stature() }">${e8message }
					</td>
					<td align="right"> 血型</td>
					<td>
						<select name="em_blood">

							<C:forEach items="${em_BloodList }" var="em_BloodList">
								<option value="${em_BloodList.id }" ${em_BloodList.id == emplist.get(0).em_blood ? "selected" : "" }>${em_BloodList.code_value }</option>
							</C:forEach>
						</select>
					</td>
					<td align="right">婚姻状况</td>
					<td>
						<select name="em_wedlock">
							
							<C:forEach items="${em_WedlockList }" var="em_WedlockList">
								<option value="${em_WedlockList.id }" ${em_WedlockList.id == emplist.get(0).em_wedlock ? "selected" : "" }>${em_WedlockList.code_value }</option>
							</C:forEach>
						</select>
					</td>
				</tr>
	
				<tr>
					<td align="right">部门 </td>
					<td>
					<select name="dept_number">
							<C:forEach items="${deptlist }" var="deptlist" >																			
									<option value="${deptlist.getDept_number() }" ${deptlist.getDept_number() == emplist.get(0).getDept().getDept_number() ? "selected" : "" } disabled="disabled">${deptlist.getDept_name() }</option>									
							</C:forEach>
					</select>
					</td>
					<td align="right">岗位</td>
					<td>
					<select name="job_number">
							<C:forEach items="${joblist }" var="joblist">
								<option value="${joblist.getJob_number() }" ${joblist.getJob_number() == emplist.get(0).getJob().getJob_number() ? "selected" : "" } disabled="disabled">${joblist.getJob_name() }</option>
							</C:forEach>
						</select>
					</td>
					<td align="right">用户所在地</td>
					<td>
						<input type="text" name="em_seat" value="${emplist.get(0).getEm_seat() }">
					</td>
				</tr>
	
				<tr>
					<td align="right"> 最高学历</td>
					<td>
						<select name="em_learn">
							
							<C:forEach items="${em_LearnList }" var="em_LearnList">
								<option value="${em_LearnList.id }" ${em_LearnList.id == emplist.get(0).em_learn ? "selected" : "" }>${em_LearnList.code_value }</option>
							</C:forEach>
						</select>
					</td>
					<td align="right">最高学位</td>
					<td>
						<select name="em_degree">
							
							<C:forEach items="${em_DegreeList }" var="em_DegreeList">
								<option value="${em_DegreeList.id }" ${em_DegreeList.id == emplist.get(0).em_degree ? "selected" : "" }>${em_DegreeList.code_value }</option>
							</C:forEach>
						</select>
					</td>
					<td align="right">毕业院校 </td>
					<td>
						<input type="text" name="em_graduate" value="${emplist.get(0).getEm_graduate() }">
					</td>
				</tr>
	
				<tr>
					<td align="right">所学专业 </td>
					<td>
						<input type="text" name="em_specialty" value="${emplist.get(0).getEm_specialty() }">
					</td>
					<td align="right">毕业日期</td>
					<td>
						<input type="date" name="em_gradate" value="${emplist.get(0).getEm_gradate() }">${e6message }
					</td>
					<td align="right">出生地</td>
					<td>
						<input type="text" name="em_homeplace" value="${emplist.get(0).getEm_homeplace() }">
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" value="保存更改">
					</td>
				</tr>
				<tr></tr>
			</table>
		</form>
	</body>

</html>
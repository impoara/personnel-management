<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
<!-- 用户的注册 -->
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			body{
				background-color:#c8eef1 ;
			}
			.rzgl{
				width: 100%;
				
			}
			#rzgl1{
				border: 1px solid black;
			}
			#rzgl2{
				border: 1px solid black;
				display: none;
			}
			
			a{
			text-decoration: none;}
		</style>
		<script type="text/javascript" >
			 window.onload=function(){
			         document.getElementById("yc").onclick = function(){
			            document.getElementById("rzgl2").style.display ="none";
                       }
			         document.getElementById("xs").onclick = function(){
			         	document.getElementById("rzgl2").style.display = "block"
			         }
                    }
			 
		</script>
	</head>
	<body >
	<form action="${pageContext.request.contextPath }/Employee.action" method="post">
	<input type="hidden" name="action" value="insert">
	<input type="hidden" name="em_number" value="${is }">
		<div class="rzgl">
                             <p>当前位置：员工信息</p>
                             <p>注：* 为必须填写,日期格式：1986-10-1</p>
                   <div id="rzgl1">
                  
                        <table class="border"   width="100%">
                             <tr>
                             	<td align="right" >*   员工编号</td>
                             	<td> <input type="text" name="em_number" value="${is }" disabled="disabled"></td>
                             	<td align="right">*   姓名 </td>
                             	<td>
                             		<input type="text" name="em_name">${e1message }</td>
                             		<td align="right">*   性别</td>
                             		<td>
	                             		<select name="sex">
	                             		<c:forEach items="${em_SexList }" var="em_SexList">
	                             			<option value="${em_SexList.id }">${em_SexList.code_value }</option>
	                             		</c:forEach>
	                             		</select>
                             		</td>
                             </tr>

                              <tr>
                              	<td align="right">*   出生日期 </td>
                              	<td><input type="date" name="em_birth">${e2message }</td>
                              	<td align="right">*   身份证号 </td>
                              	<td><input type="text" name="em_id">${e4message }</td>
                              	<td align="right"></td>
                              	<td></td>
                              </tr>

                               <tr>
                               	<td align="right">*   入职日期 </td>
                               	<td><input type="date" name="em_indate">${e3message }</td>
                               	<td align="right">*   参加工作时间</td>
                               	<td><input type="date" name="em_worktime">${e5message }</td>
                               	<td align="right">*   用工形式</td>
                               	<td>
                               	<select name="em_format">
	                             		<c:forEach items="${em_FormatList }" var="em_FormatList">
	                             			<option value="${em_FormatList.id }">${em_FormatList.code_value }</option>
	                             		</c:forEach>
	                             		</select>
                               	</td>
                               </tr>
                
	                        	 <tr>
	                               	<td align="right">*   人员来源</td>
	                               	<td>
	                               		<select name="em_source">
		                             		<c:forEach items="${em_SourceList }" var="em_SourceList">
		                             			<option value="${em_SourceList.id }">${em_SourceList.code_value }</option>
		                             		</c:forEach>
		                             	</select>
	                               	</td>
	                               	<td align="right">*   政治面貌</td>
	                               	<td>
	                               		<select name="em_polity">
		                             		<c:forEach items="${em_PolityList }" var="em_PolityList">
		                             			<option value="${em_PolityList.id }">${em_PolityList.code_value }</option>
		                             		</c:forEach>
		                             	</select>
	                               	</td>
	                               	<td align="right">*  民族</td>
	                               	<td>
	                               		<select name="em_folk">
		                             		<c:forEach items="${em_FolkList }" var="em_FolkList">
		                             			<option value="${em_FolkList.id }">${em_FolkList.code_value }</option>
		                             		</c:forEach>
		                             	</select>
	                               	</td>
	                               </tr>
	                               <tr>
	                               	<td align="right">是否为试用期</td>
	                               	<td>
	                               		<input type="radio" name="yg">是
	                               			<input type="radio" name="yg">否
	                               	</td>
	                               </tr>
	                               <tr>
		                               	<td></td>
		                               	<td align="right">
		                               		<input type="button" id="xs"  value="显示更多信息" >
		                               	</td>
		                               	<td><input type="button" value="隐藏更多信息" id="yc" >
		                               	</td> <td align="right">
		                               		<input type="submit" value="确认提交 ">
		                               	</td>
		                               	<td>
		                               		<input type="reset" value="重新填写 ">
		                               	</td>
	                               </tr>
							</table>										
					</div>
					<br />
					<br />
					<br />
                       
					
					<div id="rzgl2">
						<table width="100%">
					<tr>
						<td align="right">籍贯 </td>
						<td><input type="text" name="em_birthplace"></td>
						<td align="right">联系电话 </td>
						<td><input type="text" name="em_phone"></td>
						<td align="right">电子邮件 </td>
						<td>
							<input type="text" name="em_mail">
						</td>
					</tr>
					
					<tr>
						<td align="right">身高
						</td>
						<td><input type="text" name="em_stature">
						</td> 
						<td align="right"> 血型</td>
						<td>
							<select name="em_blood">
								<c:forEach items="${em_BloodList }" var="em_BloodList">
								<option value="${em_BloodList.id }">${em_BloodList.code_value }</option>
								</c:forEach>
							</select>
						</td> 
						<td align="right">婚姻状况</td>
						<td>
							<select name="em_wedlock">
								<c:forEach items="${em_WedlockList }" var="em_WedlockList">
								<option value="${em_WedlockList.id }">${em_WedlockList.code_value }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					
					<tr>
						<td align="right">部门 </td>
						<td>
						<select name="dept_number">
									<option value="0">请选择</option>
									<c:forEach items="${deptlist }" var="deptlist">																			
											<option value="${deptlist.getDept_number() }">${deptlist.getDept_name() }</option>									
									</c:forEach>
						</select>
						</td>
						<td align="right">出生地 </td>
						<td><input type="text" name="em_homeplace"></td>
						<td align="right">用户所在地</td>
						<td><input type="text" name="em_seat"></td>	
					</tr>					
					<tr>
						<td align="right"> 最高学历</td>
						<td>
							<select name="em_learn">
								<c:forEach items="${em_LearnList }" var="em_LearnList">
								<option value="${em_LearnList.id }">${em_LearnList.code_value }</option>
								</c:forEach>
							</select>
						</td> 
						<td align="right">最高学位</td>
						<td>
							<select name="em_degree">
								<c:forEach items="${em_DegreeList }" var="em_DegreeList">
									<option value="${em_DegreeList.id }">${em_DegreeList.code_value }</option>
								</c:forEach>
							</select>
						</td> 
						<td align="right">毕业院校 </td>
						<td><input type="text" name="em_graduate">
						</td>
					</tr>
					
					<tr>
						<td align="right">所学专业 </td>
						<td><input type="text" name="em_specialty"></td>
						<td align="right">毕业日期</td>
						<td><input type="date" name="em_gradate">${e6message }</td>
						<td align="right">岗位</td>
						<td>
						<select name="job_number">
							<option value="0">请选择</option>
							<c:forEach items="${joblist }" var="joblist">
								<option value="${joblist.getJob_number() }">${joblist.getJob_number() }${joblist.getJob_name() }</option>
							</c:forEach>
						</select>
						
						</td>
					</tr>
					
					</table>
                   </div>
                     	
        </div>
        </form>
   </body>
</html>

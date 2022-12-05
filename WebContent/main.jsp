<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<!-- 主网页  -->
	<head>
		<meta charset="UTF-8">
		<title>实训网页</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/main.js"></script>
		<style>
			body {
				padding: 0px;
				margin: 0px;
				height: 100%;
				box-sizing: border-box;
				background-color: #f0f8ff;
			}
			#topdiv {
				background-image: url(img/bj1.jpg);
				background-size: 100% 100%;
				background-repeat: repeat-x;
				width: 100%;
				height: 15%;
				box-sizing: border-box;
				padding: 0px;
				margin: 0px;
			}
			#maindiv {
				width: 100%;
				height: 87%;
				box-sizing: border-box;
				padding: 0px;
				margin: 0px;
			}
			#bottomdiv {
				width: 100%;
				height: 100%;
				display: flex;
				box-sizing: border-box;
			}	
			#left {
				width: 13%;
				height: 100%;
/* 				 background-image: url("img/bjt222.jpg");  
 */			background-color: #629DAE; 
				margin-top: 0px;
				box-sizing: border-box;
			}	
			#right {
				width: 87%;
				height: 100%;
				  background-image: url("img/bj.jpg"); 
				  background-size: 100% 100%;
			 	/*background-color:  #abd5e1;*/ 
			}
			.STYLE5 {
				font-family: "方正舒体";
				font-size: x-large;
				color: #395A7B;
			}
			a {
				color: #000;
				text-decoration: none;
			}
			.zuokuang {
				display: flex;
				text-align: center;
				align-items: center;
				justify-content: center;
				color: black;
				height: 45px;
				box-sizing: border-box;
				font-size: 20px;
/* 				background-color: #e5eaf0;
 */				border: 1px solid #CEDDF0;
				background-color: #198498;
			}
			.zuokuang1 {
				display: flex;
				text-align: center;
				justify-content: center;
				align-items: center;
				font-size: 18px;
				height: 40px;
				color: #BFC4CA;
				padding-top: 8px;
				box-sizing: border-box;
				border-bottom: 1px solid #D1D7DC;
				background-color: #629DAE;
			}
			.zuokuang1:hover {
			text-align: center;
				color: #629DAE;
			}
			iframe {
				border: 0;
			}
		</style>
	</head>
	
	<body>
		<div id="maindiv">
			<div id="topdiv">
			<br/><br/><br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="STYLE5">人事管理系统 </span>
			</div>
			<div id="bottomdiv">
				<div id="left">
					<div class="zuzhi">
						<div class="zuokuang" id="zzgl">
							<a href="javascript:void(0)">组织结构管理</a>
						</div>
						<div class="zuokuang1" id="bmgl">
							<a href="${pageContext.request.contextPath }/dept/DeptServlet.action?action=list1" target="myiframe">部门管理</a>
						</div>
						
						<div class="zuokuang1" id="gwgl">
							<a href="${pageContext.request.contextPath }/job/JobServlet.action?action=list" target="myiframe">岗位管理</a>
						</div>
					</div>
					<div class="zhiyuan">
						<div class="zuokuang" id="zygl">
							<a href="javascript:void(0)">职员管理</a>
						</div>
						<div class="zuokuang1" id="rzgl">
							<a href="${pageContext.request.contextPath }/Employee.action?action=list" target="myiframe">入职管理</a>
						</div>
						
						<div class="zuokuang1" id="ygzy">
							<a href="Tn_SeparationQuery.jsp" target="myiframe">员工离职管理</a>
						</div>
					</div>
					<div class="diaodong">
						<div class="zuokuang" id="ddgl">
							<a href="javascript:void(0)" >调动管理</a>
						</div>
						<div class="zuokuang1" id="bmdd">
							<a href="${pageContext.request.contextPath }/Dep_changeServlet.action?action=findallzhunbei" target="myiframe">部门调动管理</a>
						</div>
						<div class="zuokuang1" id="gwdd">
							<a href="${pageContext.request.contextPath }/Job_changeServlet.action?action=findallzhunbei" target="myiframe">岗位调动管理</a>
						</div>
					</div>
					<div class="zhiyuan">
						<div class="zuokuang" id="zyxx">
							<a href="javascript:void(0)">职员信息管理</a>
						</div>
						<div class="zuokuang1" id="ygxx">
							<a href="${pageContext.request.contextPath }/Employee.action?action=findallzhunbei" target="myiframe">员工信息中心</a>
						</div>
					</div>
					<div class="tuichu">
						<div class="zuokuang" id="tc">
							<a href="mrwz.jsp" target="myiframe">安全退出</a>
						</div>
					</div>
				</div>
				<div id="right">
					<iframe name="myiframe" src="mrwz.jsp" style="width:100%;height: 100%;"></iframe>
				</div>
			</div>
			</div>
	</body>
	
</html>
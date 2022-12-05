window.onload = function(){

var ret=document.getElementById("returnwork");
var job_number=document.getElementById("job_number");
var job_type=document.getElementById("job_type");
var id=document.getElementById("id");

	ret.onclick=function(){
		window.location="/Personnel/job/JobServlet.action?action=list";
	}

	job_type.onchange=function(){
		
		window.location="/Personnel/job/JobServlet.action?action=xiuganbh&&job_type="+job_type.value+"&&id="+id.value+"";
	}
}
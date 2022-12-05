window.onload = function() {

	var gelx = document.getElementById("gelx");
	var r1 = document.getElementById("r1");
	gelx.onchange = function() {
		var type=gelx.value;
		window.location = "JobServlet.action?action=zengjia&&job_type="+type+"";
	}
	r1.onclick = function() {
		window.location = "JobServlet.action?action=list";
	}

}
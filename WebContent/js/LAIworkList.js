window.onload = function() {
	var chaxun = document.getElementById("chaxun");
	var xianshi1 = document.getElementById("xianshi1");
	var show = document.getElementById("show");
	var but = document.getElementById("button1");
//	var job_number=document.getElementById("job_number");
	var i = 2;
	chaxun.style.display = "none";
	show.innerHTML = "[已隐藏]";
	xianshi1.onclick = function() {
		if(i % 2 == 0) {
			chaxun.style.display = "block";
			show.innerHTML = "[已显示]";

			i++;
		} else {
			chaxun.style.display = "none";
			show.innerHTML = "[已隐藏]";
			i++;
		}
	}
	but.onclick = function() {
		window.location = "/Personnel/job/JobServlet.action?action=editui";
	}


}
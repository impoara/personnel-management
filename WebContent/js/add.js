window.onload = function(){
	var chaxun = document.getElementById("chaxun");
	var xianshi1 = document.getElementById("xianshi1");
	var show = document.getElementById("show");
	var i=2;
            chaxun.style.display = "none";
			show.innerHTML="[已隐藏]";
	xianshi1.onclick=function(){
		if(i%2==0){
			chaxun.style.display= "block";
			show.innerHTML="[已显示]";
			
			i++;
		}else{
			chaxun.style.display = "none";
			show.innerHTML="[已隐藏]";
			
			i++;
		}
	}
    var but=document.getElementById("button");
	but.onclick=function(){
		window.location="/Personnel/dept/DeptServlet.action?action=editui";
	}
	var save=document.getElementById("save");
	save.onclick=function(){
		window.location="add.jsp";
	}



}
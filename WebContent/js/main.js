window.onload=function(){
	var zzgl=document.getElementById("zzgl");
	var bmgl=document.getElementById("bmgl");
	var gwgl=document.getElementById("gwgl");
	
	var zygl=document.getElementById("zygl");
	var rzgl=document.getElementById("rzgl");
	var ygzy=document.getElementById("ygzy");
	
	var ddgl=document.getElementById("ddgl");
	var bmdd=document.getElementById("bmdd");
	var gwdd=document.getElementById("gwdd");
	
	var zyxx=document.getElementById("zyxx");
	var ygxx=document.getElementById("ygxx");
	
	var tc=document.getElementById("tc");
	
	
			bmgl.style.display="none";
			gwgl.style.display="none";
			rzgl.style.display="none";
			ygzy.style.display="none";
			bmdd.style.display="none";
			gwdd.style.display="none";
			ygxx.style.display="none";
	
	var n=2;
	zzgl.onclick=function(){
		if(n%2==0){
			
			bmgl.style.display="block";
			gwgl.style.display="block";
			
			rzgl.style.display="none";
			ygzy.style.display="none";
			bmdd.style.display="none";
			gwdd.style.display="none";
			ygxx.style.display="none";
			n=1;
			m=2;
			k=2;
			a=2;
		}else{
			bmgl.style.display="none";
			gwgl.style.display="none";
			n=2;
		}
		
	}	
	var m=2;
	zygl.onclick=function(){
		if(m%2==0){
			rzgl.style.display="block";
			ygzy.style.display="block";
			
			bmgl.style.display="none";
			gwgl.style.display="none";
			bmdd.style.display="none";
			gwdd.style.display="none";
			ygxx.style.display="none";
			n=2;
			k=2;
			a=2;
			m=1;
		}else{
			
			rzgl.style.display="none";
			ygzy.style.display="none";
			m=2;
		}
		
		}
	var k=2;
	ddgl.onclick=function(){
		if(k%2==0){
			bmdd.style.display="block";
			gwdd.style.display="block";
			
			bmgl.style.display="none";
			gwgl.style.display="none";
			rzgl.style.display="none";
			ygzy.style.display="none";
			ygxx.style.display="none";
			
		
			n=2;
			m=2;
			a=2;
			k=1;
		}else{
			bmdd.style.display="none";
			gwdd.style.display="none";
		
			k=2;
		}
		
	}	
	var a=2;
	zyxx.onclick=function(){
		if(a%2==0){
			ygxx.style.display="block";
			
			bmgl.style.display="none";
			gwgl.style.display="none";
			rzgl.style.display="none";
			ygzy.style.display="none";
			bmdd.style.display="none";
			gwdd.style.display="none";

			n=2;
			m=2;
			k=2;
			a=1;
		}else{
			ygxx.style.display="none";
			a=2;
		}
		}
    tc.onclick=function(){
		  
		   

			bmgl.style.display="none";
			gwgl.style.display="none";
			rzgl.style.display="none";
			ygzy.style.display="none";
			bmdd.style.display="none";
			gwdd.style.display="none";
			ygxx.style.display="none";
		   
			 confirm("是否退出系统");
		}
	
	
}

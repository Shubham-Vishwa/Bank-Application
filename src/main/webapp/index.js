/**
 * 
 */
 
 function adLogin(){
	var x = document.querySelector("#adlogin");
	document.querySelector("#ulogin").style.display="none";
	document.querySelector("#ureg").style.display="none";
	document.querySelector("#forget").style.display="none";
	document.querySelector("#showtrans").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function uLogin(){
	var x = document.querySelector("#ulogin");
	document.querySelector("#adlogin").style.display="none";
	document.querySelector("#ureg").style.display="none";
	document.querySelector("#forget").style.display="none";
	document.querySelector("#showtrans").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function uReg(){
	var x = document.querySelector("#ureg");
	document.querySelector("#ulogin").style.display="none";
	document.querySelector("#adlogin").style.display="none";
	document.querySelector("#forget").style.display="none";
	document.querySelector("#showtrans").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function forget(){
	var x = document.querySelector("#forget");
	document.querySelector("#ulogin").style.display="none";
	document.querySelector("#adlogin").style.display="none";
	document.querySelector("#ureg").style.display="none";
	document.querySelector("#showtrans").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

function showTrans(){
	var x = document.querySelector("#showtrans");
	document.querySelector("#ulogin").style.display="none";
	document.querySelector("#adlogin").style.display="none";
	document.querySelector("#ureg").style.display="none";
	document.querySelector("#forget").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}
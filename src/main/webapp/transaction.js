/**
 * 
 */
 function deposit(){
	var x = document.querySelector("#deposit")
	document.querySelector("#frm").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function showTransForm(){
	var x = document.querySelector("#frm")
	document.querySelector("#deposit").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
		var cp = document.querySelector(".cap1");
		getCaptcha(cp);
	}else{
		x.style.display="none";
	}
}
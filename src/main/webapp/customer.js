/**
 * 
 */
 function appForm(){
	var x = document.querySelector("#appform");
	document.querySelector("#appatm").style.display="none";
	document.querySelector("#details").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function appAtm(){
	var x = document.querySelector("#appatm");
	document.querySelector("#appform").style.display="none";
	document.querySelector("#details").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function details(){
	var x = document.querySelector("#details");
	document.querySelector("#appatm").style.display="none";
	document.querySelector("#appform").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}
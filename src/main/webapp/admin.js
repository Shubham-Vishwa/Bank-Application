/**
 * 
 */
 function checkForm(){
	var x = document.querySelector("#checkform");
	document.querySelector("#edit").style.display="none";
	document.querySelector("#del").style.display="none";
	document.querySelector("#showone").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function edit(){
	var x = document.querySelector("#edit");
	document.querySelector("#checkform").style.display="none";
	document.querySelector("#del").style.display="none";
	document.querySelector("#showone").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function del(){
	var x = document.querySelector("#del");
	document.querySelector("#edit").style.display="none";
	document.querySelector("#checkform").style.display="none";
	document.querySelector("#showone").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function showOne(){
	var x = document.querySelector("#showone");
	document.querySelector("#edit").style.display="none";
	document.querySelector("#del").style.display="none";
	document.querySelector("#checkform").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}
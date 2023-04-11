/**
 * 
 */
 function edit(){
	var x = document.querySelector("#edit");
	document.querySelector("#actinact").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}

 function actInact(){
	var x = document.querySelector("#actinact");
	document.querySelector("#edit").style.display="none";
	if(x.style.display==="none"){
		x.style.display="block";
	}else{
		x.style.display="none";
	}
}
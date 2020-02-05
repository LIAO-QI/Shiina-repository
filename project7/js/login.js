/* function pw_change(){
	
	let login2 = document.getElementById('input-2');
	let login3 = document.getElementById('login-password');
	
	if(login2.onfocus){
		login3.className = 'flex_horizontal login-before';
	}
	
	if(login2.onblur){
		login3.className = 'flex_horizontal';
	}
	
} */

/* function user_change(){
	
	let login1 = document.getElementById('input-1');
	let login4 = document.getElementById('login-user');
	
	if(login1.onfocus){
		login4.className = 'flex_horizontal login-before';
	}
	
	if(login1.onblur){
		login4.className = 'flex_horizontal';
	}
	
} */

function user_focus(){
	
	let login1 = document.getElementById('input-1');
	let login4 = document.getElementById('login-user');
	
	if(login1.onfocus){
		login4.className = 'flex_horizontal login-before';
	}
	
}

function pw_focus(){
	
	let login2 = document.getElementById('input-2');
	let login3 = document.getElementById('login-password');
	
	if(login2.onfocus){
		login3.className = 'flex_horizontal login-before';
	}
	
}

function pw_blur(){
	
	let login2 = document.getElementById('input-2');
	let login3 = document.getElementById('login-password');
	
	if(login2.onblur){
		login3.className = 'flex_horizontal';
	}
	
}

function user_blur(){
	
	let login1 = document.getElementById('input-1');
	let login4 = document.getElementById('login-user');
	
	if(login1.onblur){
		login4.className = 'flex_horizontal';
	}
	
}

function rem_change(e){
	if(!e.className){
		e.className = 'rem-box-change';
	}else{
		e.className = '';
	}
}

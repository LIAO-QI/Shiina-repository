// 封装选择器, 采用ES6箭头函数写法
const getSelector = ele => {
    return typeof ele === "string" ? document.querySelector(ele) : "";
}

// 登录、注册、忘记密码页切换
((window,document) => {
	
	let toRegister = getSelector("#register"),
		toFindPW = getSelector("#forgetPW"),
		toLogin = getSelector("#login-1"),
		toLogin2 = getSelector("#login-2"),
		loginPage = getSelector(".login-box"),
		registerTitle = getSelector("#register-title"),
		registerPage = getSelector(".register-box"),
		findPW = getSelector("#findPW-box"),
		findPWTitle = getSelector("#findPW-title"),
		findPWPage = getSelector(".findPW-box");
		
	toRegister.onclick = () => {
		loginPage.style.display = "none";
		loginPage.style.animation = "fadeOut 2s ease";
		registerTitle.style.display = "block";
		// registerPage.style.animation = "fadeOut 2s ease";
		// findPWPage.style.animation = "fadeOut 2s ease";
	}
	
	toLogin.onclick = () => {
		registerTitle.style.display = "none";
		loginPage.style.display = "";
	}
	
	toFindPW.onclick = () => {
		loginPage.style.display = "none";
		registerPage.style.display = "none";
		findPWTitle.style.display = "block";
	}
	
	toLogin2.onclick = () => {
		findPWTitle.style.display = "none";
		registerPage.style.display = "";
		loginPage.style.display = ""; 
	}	
	
})(window,document);
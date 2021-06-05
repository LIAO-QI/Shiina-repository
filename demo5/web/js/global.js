/* * * * * * * * * * * * * * * *
*
*   封装选择器, 采用ES6箭头函数写法
*
* * * * * * * * * * * * * * * */
const getSelector = ele => {
    return typeof ele === "string" ? document.querySelector(ele) : "";
}

/* * * * * * * * * * * * * * * *
*
*         全 局 变 量
*
* * * * * * * * * * * * * * * */
const login =  getSelector("#login-btn"),
    register = getSelector("#register-btn"),
    toRegister = getSelector("#to-register-btn"),
    toLogin = getSelector("#to-login-btn"),
    modify = getSelector(".modify-btn"),
    quit = getSelector(".quit-btn"),
    msgBoard = getSelector(".msgBoard-btn"),
    shop = getSelector(".shop-btn"),
    confirmModify =  getSelector(".confirm-modify-btn"),
    toMain = getSelector(".to-main-btn");

export {
    getSelector,
    login,
    register,
    toRegister,
    toLogin,
    modify,
    quit,
    msgBoard,
    shop,
    confirmModify,
    toMain
}
import * as login from "./global.js";



/* * * * * * * * * * * * * * * *
*
*     登录页切换注册页逻辑
*
* * * * * * * * * * * * * * * */
((window,document) => {

    // Cannot set property 'onclick' of null
    /*toRegister.onclick = () => {
        window.location = "register.jsp";
    }*/

    /*先执行js文件，再载入DOM，事件没有绑定DOM元素上。
    解决：将事件委托给父元素（一般是document）处理，
    window 一般绑定相关api变量，document绑定 dom事件。
    但是这里不能委托给document，只能委托给各自的直接父元素，
    因为这里并不是所有DOM都后于js文件载入，只是各个按钮，如果
    绑定在document，则点击页面任何一处都会触发点击事件。*/

    $("#register").on("click",login.toRegister,() => {
        window.location = "register.jsp";
    });

})(window,document);



/* * * * * * * * * * * * * * * *
*
*      ajax请求服务器（登录逻辑）
*
* * * * * * * * * * * * * * * */

const loginFunc = () => {

    // 获取文本输入框的值
    let username = $("#userName").val(),
        password = $("#password").val();

    console.log(username);
    console.log(password);

    // 发送ajax请求
    $.get("loginServlet",

    {
        username : username,
        password : password
    },

    (data) => {
        if (data.userFlag === false && data.loginFlag === false) {
            alert("帐户不存在！");
        } else if (data.userFlag === true && data.loginFlag === false) {
            alert("密码错误！");
        } else if (data.userFlag === true && data.loginFlag === true) {
            // window.location = "main.jsp?username=" + data.user.username;
            window.location = "loginToMainServlet?username=" + data.user.username;
        }

    });
};

((window,document) =>{

    $("#login").on("click",login.login, () => {
        loginFunc();
    });

})(window,document);

/*
function keyFunc(e) {
    if (e.keyCode === 13)
        loginFunc();
}

$("#userName").onkeypress = () => {
    keyFunc();
};

$("#password").onkeypress = () => {
    keyFunc();
};
*/

import * as register from "./global.js";



/* * * * * * * * * * * * * * * *
*
*     注册页切换登录页逻辑
*
* * * * * * * * * * * * * * * */
((window,document) => {

    // Cannot set property 'onclick' of null
    /*toLogin.onclick = () => {
        window.location = "index.jsp";
    }*/

    $("#login-1").on("click",register.toLogin,() => {
        window.location = "index.jsp";
    });

})(window,document);




/* * * * * * * * * * * * * * * *
*
*      ajax请求服务器（注册逻辑）
*
* * * * * * * * * * * * * * * */

const registerFunc = () => {

    // 获取文本输入框的值
    let username1 = $("#userName-1").val(),
        password1 = $("#password-1").val();

    console.log(username1);
    console.log(password1);

    // 发送ajax请求
    $.get("registerServlet",

    {
        username1 : username1,
        password1 : password1
    },

    (data) => {
        if (data.registerFlag === false && data.dbFlag === false) {
            alert("用户名已存在！");
        } else if (data.registerFlag === true && data.dbFlag === false) {
            alert("服务器错误！");
        } else if (data.registerFlag === true && data.dbFlag === true) {
            // window.location = "index.jsp?username=" + data.user.username + "&password=" + data.user.password;
            window.location = "registerToLoginServlet?username=" + data.user.username + "&password=" + data.user.password;
        }

    });
};

((window,document) => {

    $("#register-1").on("click",register.register, () => {
        registerFunc();
    });

})(window,document);
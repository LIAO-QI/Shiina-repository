import * as modify from "./global.js";



/* * * * * * * * * * * * * * * *
*
*     修改信息页切换主页逻辑
*
* * * * * * * * * * * * * * * */
((window,document) => {
    $(".m2").on("click",modify.toMain,() => {
        window.location = "main.jsp";
    });
})(window,document);



/* * * * * * * * * * * * * * * *
*
*     修改信息页切换执行修改页逻辑
*
* * * * * * * * * * * * * * * */
function getModifyData() {
    let pw = $("#password").val(),
        s = $("#sex").val(),
        n = $("#name").val(),
        a = $("#age").val(),
        u = $("#username").val();

    console.log("a-------------"+a);
    return "pw="+pw+"&s="+s+"&n="+n+"&a="+a+"&u="+u;
}

((window,document) => {
    $(".m1").on("click",modify.confirmModify,() => {
        window.location = "modifyToDoServlet?"+getModifyData();
    });
})(window,document);
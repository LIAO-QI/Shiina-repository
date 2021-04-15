import * as main from "./global.js";



/* * * * * * * * * * * * * * * *
*
*     退出登录逻辑
*
* * * * * * * * * * * * * * * */
((window,document) => {
    main.quit.onclick = () => {
        window.location = "login.jsp?lan=cn";
    };
})(window,document);



/* * * * * * * * * * * * * * * *
*
*     主页切换修改信息页逻辑
*
* * * * * * * * * * * * * * * */
((window,document) => {
    main.modify.onclick = () => {
        window.location = "modify.jsp";
    };
})(window,document);



/* * * * * * * * * * * * * * * *
*
*     主页切换留言板逻辑
*
* * * * * * * * * * * * * * * */
((window,document) => {
    main.msgBoard.onclick = () => {
        window.location = "messageBoard.jsp";
    };
})(window,document);



/* * * * * * * * * * * * * * * *
*
*     主页切换购物页逻辑
*
* * * * * * * * * * * * * * * */
((window,document) => {
    main.shop.onclick = () => {
        window.location = "shop.jsp";
    };
})(window,document);
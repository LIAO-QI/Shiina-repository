import * as main from "./global.js";



/* * * * * * * * * * * * * * * *
*
*     退出登录逻辑
*
* * * * * * * * * * * * * * * */
((window,document) => {
    main.quit.onclick = () => {
        window.location = "index.jsp";
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

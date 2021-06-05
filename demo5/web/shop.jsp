<%--
  Created by IntelliJ IDEA.
  User: 包子
  Date: 2020/6/1
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="q" uri="http://shiina.com" %>
<html>
<head>
    <title>Shop</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: rgba(192,259,251,.3);
            font-family: 楷体;
        }

        .board-title {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
            text-shadow: 0 0 20px rgb(127,255,212);
        }

        .inputMsgBox  {
            width: 40vw;
        }

        .inputMsgBtn {
            margin-top: 20px;
        }

        .inputMsgBtn input[type=button] {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div>
    <h1 class="board-title">购物中心</h1>

    <table class="table">
        <tr bgcolor="#7fffd4">
            <th style="text-align: center">商品编号</th>
            <th style="text-align: center">商品名称</th>
            <th style="text-align: center">商品价格</th>
            <th style="text-align: center">商品图片</th>
            <th style="text-align: center">选择购买</th>
        </tr>
        <tbody id="table-container"></tbody>
    </table>

    <div style="margin-top: 10px;">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <%-- 上一页--%>
                <li class="page-item" id="left">
                    <button class="page-link last-btn" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </button>
                </li>

                <%-- 页码--%>
                <span id="page-btn" style="display: flex;flex-direction: row;"></span>

                <%-- 下一页--%>
                <li class="page-item" id="right">
                    <button class="page-link next-btn" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </button>
                </li>

                <span style="font-size: 25px;margin-left: 5px;">
                    共<span id="totalCount"></span>件商品，共<span id="totalPage"></span>页
                </span>
            </ul>
        </nav>
    </div>

    <div class="inputMsgBox">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">用户名</span>
            </div>
            <input type="text" class="form-control" name="shop-username" id="shop-username" value="${map.username}" readonly="readonly" />
        </div>

        <div class="inputMsgBtn">
            <input type="button" value="购买" onclick="pay()" />
            <input type="button" value="查看订单" onclick="window.location='orders.jsp'" />
            <input type="button" value="返回主页" onclick="window.location='main.jsp'">
            <span style="color: #fb5f21">您是第${count}位访问本购物页面的用户</span>
        </div>
    </div>
</div>
<q:shiina-copyright/>
<script src="./js/jquery-3.2.1.min.js"></script>
<script>
    var currentPage = 1,
        totalPage = 0;

    // ajax异步请求服务器
    function getGoodsData(){
        $.get("user/goodsServlet"
        ,{
            currentPage:currentPage,
            rows:3
        }
        ,function (data) {
            //console.log(data);
            totalPage = data.pb.totalPage;
            currentPage = data.pb.currentPage;

            // 判断上下页是否可点击
            if (currentPage == 1){
                $("#left").addClass("disabled");
            }else {
                $("#left").removeClass("disabled");
            }

            if (currentPage == totalPage){
                $("#right").addClass("disabled");
            }else {
                $("#right").removeClass("disabled");
            }

            let result = "";
            for(let i = 0;i<data.pb.list.length;i++){
                result+="<tr>";
                result+="<td style=\"text-align: center\">"+data.pb.list[i].id+"</td>";
                result+="<td style=\"text-align: center\">"+data.pb.list[i].goodsName+"</td>";
                result+="<td style=\"text-align: center\">"+data.pb.list[i].goodsPrice+"</td>";
                result+="<td style=\"text-align: center\">"+data.pb.list[i].goodsImage+"</td>";
                result+="<td style=\"text-align: center\"><input type='checkbox' name='goods' id='G"+data.pb.list[i].id+"' />"+"</td>";
                result+="</tr>";
            }

            let result2 = "";
            for (let i = 0;i<totalPage;i++){
                if (currentPage == (i+1)){
                    result2+="<li class='page-item active' aria-current='page'>";
                    result2+="<button class='page-link btn' value='"+(i+1)+"'>"+(i+1)+"</button>";
                    result2+="</li>";
                }else{
                    result2+="<li class='page-item' aria-current='page'>";
                    result2+="<button class='page-link btn' value='"+(i+1)+"'>"+(i+1)+"</button>";
                    result2+="</li>";
                }
            }
            $("#page-btn").html(result2);
            $("#table-container").html(result);
            $("#totalCount").html(data.pb.totalCount);
            $("#totalPage").html(totalPage);
        });
    }

    // 在页面加载完成后
    $(function () {

        /*用ajax载入DOM，先执行js文件，再载入DOM。事件没有绑定DOM元素上。
        但是，将事件委托给父元素（最好是document）处理，就不受ajax载入的DOM影响了。*/
        /*window 一般绑定相关api变量，document绑定 dom事件*/

        /*$(document).on("click",".page-link",function () {
            let goods = document.getElementsByName("goods");
            for (let i =0;i< goods.length;i++){
                if (goods[i].checked){
                    goods[i].checked = true;
                }
                else{
                    goods[i].checked = false;
                }
            }
        });*/

        $(document).on("click",".btn",function () {
            // 拿到当前页
            currentPage = $(this).val();

            // ajax异步请求局部刷新数据
            getGoodsData();
        });

        // 上一页
        $(".last-btn").click(function(){
            currentPage = currentPage - 1;
            if(currentPage >= 1){
                getGoodsData();
            }
        });

        // 下一页
        $(".next-btn").click(function(){
            currentPage = currentPage + 1;
            if(currentPage <= totalPage){
                getGoodsData();
            }
        });

    });

    // 初始化页面
    $(document).ready(function () {
        // 初始化页面（当前页为第一页）
        currentPage = 1;

        // ajax异步请求局部刷新数据
        getGoodsData();
    });

    // 支付
    function pay() {
        let user = $("#shop-username").val();
        let goods = document.getElementsByName("goods");
        let goodsArray = new Array();
        for (let i =0;i< goods.length;i++){
            if (goods[i].checked){
                let goodID = goods[i].id.charAt(1);
                // console.log(goodID);
                // 若复选框被选中，则把对应的商品id推入数组中
                goodsArray.push(goodID);
            }
        }
        // 带着参数提交至user/shopServlet，以供其通过request.getParameter()方法获取选中的商品id数组、购买者
        window.location = "user/saveOrdersServlet?goodsArray="+goodsArray+"&user="+user;
    }
</script>
</body>
</html>

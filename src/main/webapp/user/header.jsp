<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- //for-mobile-apps -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- js -->
    <script src="js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <!-- 登录弹出 -->
    <script src="js/menu_jquery.js"></script>
    <!-- 登录弹出 -->
    <!-- 动画效果 -->
    <link href="css/animate.min.css" rel="stylesheet">
    <script src="js/wow.min.js"></script>
    <!-- 动画效果 -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
          rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="header-top">
    <div class="container">
        <div class="header-top-left animated wow slideInLeft" data-wow-delay=".5s">
        </div>
        <div class="header-top-left1 animated wow slideInLeft" data-wow-delay=".7s">
            <h1>${sessionScope.user.userName}<span class="glyphicon glyphicon-user" aria-hidden="true"></span></h1>
        </div>
        <c:if test="${sessionScope.user != null}">
            <div class="header-top-right">
                <div id="logoutContainer login">
                    <button class="btn btn-danger" id="logout_btn">退出</button>
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.user == null}">
            <div class="header-top-right">
                <div id="loginContainer login">
                    <button class="btn btn-primary" id="login_btn" onclick="window.open('login.jsp','_self')">登录
                    </button>
                </div>
            </div>
        </c:if>
        <div class="clearfix"></div>
    </div>
</div>
<div class="header-nav">
    <div class="container">
        <nav class="navbar navbar-default">
            <!-- 品牌和切换分组为更好的移动显示 -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="logo animated wow slideInLeft" data-wow-delay=".5s">
                    <a class="navbar-brand" href="#">Meeting Room <span>Administration</span></a>
                </div>
            </div>

            <!-- 收集的导航链接，和其他形式的内容，锁定 -->
            <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                <c:if test="${sessionScope.user != null}">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="main_user.jsp">主页</a></li>
                        <li><a href="book_room.jsp">预定会议室</a></li>
                        <li><a href="meet.jsp">会议室查看</a></li>
                        <li><a href="order.jsp">我的订单</a></li>
                        <li><a href="pwd.jsp">修改密码</a></li>
                    </ul>
                </c:if>
            </div><!-- /.navbar-collapse -->

        </nav>
    </div>
</div>
<script type="text/javascript">
    $("#logout_btn").click(function () {
        $.ajax({
            url: "/userLoginOut",
            type: "GET",
            success: function (result) {
                if (result > 0){
                    alert("成功退出");
                    window.location.href="/user/login.jsp";
                }

            }
        })
    });
</script>
</body>
</html>
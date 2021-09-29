<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co"/>
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>


    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/style1.css">


    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>
<body class="style-2">

<div class="container">

    <div class="row">
        <div class="col-md-4">

            <!-- Start Sign In Form -->
            <form class="fh5co-form animate-box" data-animate-effect="fadeInLeft" id="loginform">
                <h2>用户登录</h2>
                <div class="form-group">
                    <!--<label for="user_name" class="sr-only">Username</label>-->
                    <input type="text" name="userName" class="form-control" id="user_name" placeholder="请输入用户名"
                           autocomplete="off">
                </div>
                <div class="form-group">
                    <!--<label for="pass_word" class="sr-only">Password</label>-->
                    <input type="password" name="passWord" class="form-control" id="pass_word" placeholder="请输入密码"
                           autocomplete="off">
                </div>
                <div class="form-group">
                    <p>管理员登录? <a href="../index.jsp">返回</a></p>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary" id="login_btn">登录</button>
                </div>
            </form>

        </div>
    </div>
</div>

<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Placeholder -->
<script src="js/jquery.placeholder.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="js/main.js"></script>
<%----%>
<script type="text/javascript">
    $("#login_btn").click(function () {
       var userName = $("#user_name").val().trim();
       var passWord = $("#pass_word").val().trim();
        if (userName === '') {
           alert('用户名不能为空');
        } else if (passWord === '') {
            alert('密码不能为空');
        }else {
            $.ajax({
                url:"/userLogin",
                data:{userName:userName,passWord:passWord},
                type:"POST",
                success:function (result) {
                    if (result > 0){
                        alert("登录成功");
                        window.location.href="/user/main_user.jsp";
                    }else {
                        alert("用户名或密码不正确");
                    }
                }
            });
        }

    });
</script>
</body>
</html>


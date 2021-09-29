<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="zh-CN">

<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会议室管理系统</title>
<%--    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>--%>
<%--    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="css/style.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="css/login.css">--%>
<%--    <link rel="apple-touch-icon-precomposed" href="images/icon/icon.png">--%>
    <link rel="shortcut icon" href="images/icon/favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index2.css">



    <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <!--[if gte IE 9]>
    <script src="js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/respond.min.js" type="text/javascript"></script>
    <script src="js/selectivizr-min.js" type="text/javascript"></script>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href = 'upgrade-browser.html';</script>
    <![endif]-->
</head>

<body class="user-select">
<div class="container">
    <div class="siteIcon"><img src="images/sdjtu.png" height="180" width="1230" alt="" data-toggle="tooltip" data-placement="top"
                               title="欢迎使用会议室管理系统" draggable="false"/></div>

<%--    <div class="footer">--%>
<%--        <p><a href="user/login.jsp" data-toggle="tooltip" data-placement="left" title="预定会议室?">用户登录 →</a></p>--%>
<%--    </div>--%>
</div>


<div class="row">
    <div class="col text-center">
        <h4 class="text-muted font-weight-light mt-1">Sign in to ADMIN</h4>
    </div>
</div>
<div class="row row-custom">
    <div class="col">
        <div class="bg-white p-4 mt-3 border rounded">


            <form>
                <div class="form-group">
                    <label for="user_name" class="text-dark">Name</label>
                    <input type="text" name="userName" class="form-control form-control-sm" id="user_name" placeholder="请输入用户名">
                </div>
                <div class="form-group">
                    <label for="user_Pwd" class="text-dark d-block">Password
                        <%--                            <a class="text-primary float-right">Forgot password?</a>--%>
                    </label>
                    <input type="password" class="form-control form-control-sm" id="user_Pwd"  name="passWord"  placeholder="请输入密码">
                </div>
                <button type="button" id="signSubmit" class="btn rounded-sm btn-primary-custom btn-block btn-sm text-white mt-4">Sign in</button>
            </form>
        </div>
    </div>
</div>
<script src="js/bootstrap.min.js"></script>
<script>
    $('[data-toggle="tooltip"]').tooltip();
    window.oncontextmenu = function () {
        //return false;
    };
    $('.siteIcon img').click(function () {
        window.location.reload();
    });
    $('#signSubmit').click(function () {
        var userName = $("#user_name").val().trim();
        var passWord = $("#user_Pwd").val().trim();
        if (userName === '') {
            $(this).text('用户名不能为空');
        } else if (passWord === '') {
            $(this).text('密码不能为空');
        }else {
            $.ajax({
                url:"/adminLogin",
                data:{userName:userName,passWord:passWord},
                type:"POST",
                success:function (result) {
                    if (result > 0){
                        alert("登录成功");
                        window.location.href="/home.jsp";
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


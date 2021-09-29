
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会议室管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="images/icon/icon.png">
    <link rel="shortcut icon" href="images/icon/favicon.ico">
    <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
    <!--[if gte IE 9]>
    <script src="js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/respond.min.js" type="text/javascript"></script>
    <script src="js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href = 'upgrade-browser.html';</script>
    <![endif]-->
</head>

<body class="user-select">
<section class="container-fluid">
    <jsp:include flush="false" page="head.jsp"/>
    <div class="row">
        <aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
            <c:if test="${sessionScope.admin != null}">
                <ul class="nav nav-sidebar">
                    <li class="active"><a href="home.jsp">首页</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="article.jsp">订单管理</a></li>
                    <li><a href="room.jsp">会议室管理</a></li>
                    <li><a href="room_equip.jsp">会议室设备管理</a></li>
                    <li><a href="dept.jsp">部门管理</a></li>
                    <li><a href="user.jsp">用户管理</a></li>
                    <li><a href="role.jsp">权限管理</a></li>
                </ul>
            </c:if>
            </ul>

            <ul class="nav nav-sidebar">
                <li><a class="dropdown-toggle" id="settingMenu" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">退出</a>
                    <ul class="dropdown-menu" aria-labelledby="settingMenu">
                        <li><a href="index.jsp" id="admin_out">退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </aside>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
<%--            <h1 class="page-header">会议室使用率</h1>--%>
<%--            <div class="row placeholders">--%>
<%--                <div class="progress">--%>
<%--                    <div class="progress-bar progress-bar-success" role="progressbar"--%>
<%--                         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" id="zero">--%>
<%--                        大会议室<span class="sr-only"></span>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="progress">--%>
<%--                    <div class="progress-bar progress-bar-info" role="progressbar"--%>
<%--                         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" id="one">--%>
<%--                        中型会议室<span class="sr-only"></span>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="progress">--%>
<%--                    <div class="progress-bar progress-bar-warning" role="progressbar"--%>
<%--                         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" id="two">--%>
<%--                        小会议室<span class="sr-only"></span>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="progress">--%>
<%--                    <div class="progress-bar progress-bar-danger" role="progressbar"--%>
<%--                         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" id="three">--%>
<%--                        其他<span class="sr-only"></span>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <h1 class="page-header">状态</h1>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <tbody>
                    <tr>
                        <td>管理员: <span>${sessionScope.admin.userName}</span>，欢迎使用！</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr></tr>
                    </thead>
                    <tbody>
                    <img src="images/asd.jpg" style="width: 100%;height: 500px;">
                    </tbody>
                    <tfoot>
                    <tr></tr>
                    </tfoot>
                </table>
            </div>
            <footer>
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <tbody>
                        <tr>
                            <td><span style="display:inline-block; width:8em">版权所有</span> POWERED BY CUI WEN QUAN ALL RIGHTS
                                RESERVED
                            </td>
                        </tr>
                        <tr>
                            <td><span style="display:inline-block;width:8em">关于我们</span> The program is developed using open source technology
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </footer>
        </div>
    </div>
</section>
<script src="js/bootstrap.min.js"></script>
<script src="js/admin-scripts.js"></script>
<script type="text/javascript">
    $(function () {
        getApplyCount();
    });

    /**
     * 获取记录数
     */
    function getApplyCount() {
        $.ajax({
            url: "/getApplyCount",
            type: "GET",
            success: function (result) {
                var zero = Math.round(result.zero/result.all*10000)/100.00+"%";
                var one = Math.round(result.one/result.all*10000)/100.00+"%";
                var two = Math.round(result.two/result.all*10000)/100.00+"%";
                var three = Math.round(result.three/result.all*10000)/100.00+"%";
                console.log(zero);
                console.log(one);
                console.log(two);
                console.log(three);
                $("#zero").css("width",zero);
                $("#one").css("width",one);
                $("#two").css("width",two);
                $("#three").css("width",three);
            }
        });
    }
    $("#admin_out").click(function () {
        $.ajax({
            url:"/adminLoginOut",
            type:"GET",
            success:function () {
                if (!confirm("是否退出？"))
                    return false;
            }
        }) ;
    });
</script>
</body>
</html>


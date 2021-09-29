<%--
  Created by IntelliJ IDEA.
  User: CaoKai
  Date: 2018-05-13
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
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
<!-- header -->
<jsp:include flush="false" page="header.jsp"/>
<!-- //header -->
<!-- banner -->
<div class="banner">
    <div class="banner-pos banner1">
        <div class="container">
            <div class="banner-info animated wow slideInUp" data-wow-delay=".5s">
                <h2>
                    Welcome to use the program
                </h2>
                <p>It's my pleasure to use this program !</p>
            </div>
        </div>
        <div class="banner-posit animated wow zoomIn" data-wow-delay=".5s">
            <h2>个人信息</h2>
            <div class="reservation">
                <form id="empManger_form">
                    <h5>员工ID：${sessionScope.user.empId}</h5>
                    <h5>用户名：${sessionScope.user.userName}</h5>
                    <h5>员工姓名：${sessionScope.user.empName}</h5>
                    <h5>部门编号：${sessionScope.user.deptId}</h5>
                    <h5 id="deptName_static"></h5>
                    <h5 id="roleName_static"></h5>
                    <h5 id="deptId_static" style="display: none">${sessionScope.user.deptId}</h5>
                    <h5 id="roleId_static" style="display:none;">${sessionScope.user.roleId}</h5>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- footer -->
<div class="footer-copy">
    <div class="container">

        <div class="clearfix"></div>
    </div>
</div>
<!-- //footer -->
<!-- for bootstrap working -->
<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<%----%>
<script type="text/javascript">
    //直接发送请求
    $(function () {
        var deptId = $("#deptId_static").text().trim();
        var roleId = $("#roleId_static").text().trim();
        getDeptById(deptId);
        getRoleById(roleId);
    });
    function getDeptById(id) {
        $.ajax({
            url:"/getDept/"+id,
            type:"GET",
            success:function (result) {
                $("#deptName_static").text("部门名称："+result.deptName);
            }
        });
    }
    function getRoleById(id) {
        $.ajax({
            url:"/getRole/"+id,
            type:"GET",
            success:function (result) {
                $("#roleName_static").text("权限名称："+result.roleName);
            }
        });
    }
</script>
</body>
</html>

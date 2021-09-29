<%--
  Created by IntelliJ IDEA.
  User: CaoKai
  Date: 2018-04-18
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
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
    <%--header--%>
    <jsp:include flush="false" page="head.jsp"/>
    <%--/header--%>
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

            <h1 class="page-header">操作</h1>
            <ol class="breadcrumb">
                <div class="row">
                    <div>
                        <button class="btn btn-danger" id="apply_delete_all_btn">删除</button>
                    </div>
                </div>
            </ol>
            <h1 class="page-header">订单管理</h1>
            <div class="table-responsive">
                <table class="table table-striped table-hover" id="apply_tbl">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="check_all"/></th>
                        <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">订单号</span></th>
                        <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">申请者</span></th>
                        <th class="hidden-sm"><span class="glyphicon glyphicon-tag"></span> <span class="visible-lg">会议室名称</span>
                        </th>
                        <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">与会人数</span></th>
                        <th class="hidden-sm"><span class="glyphicon glyphicon-comment"></span> <span
                                class="visible-lg">申请用途</span></th>
                        <th><span class="glyphicon glyphicon-time"></span> <span class="visible-lg">申请日期</span></th>
                        <th><span class="glyphicon glyphicon-time"></span> <span class="visible-lg">开始时间</span></th>
                        <th><span class="glyphicon glyphicon-time"></span> <span class="visible-lg">结束时间</span></th>
                        <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">状态</span></th>
                        <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                    </tr>
                    </tbody>
                </table>
            </div>
            <footer class="message_footer">
                <nav>

                    <div>
                        <!--分页文字信息  -->
                        <div class="col-md-6" id="page_apply_area"></div>
                        <!-- 分页条信息 -->
                        <div class="col-md-6" id="page_apply_nav">

                        </div>

                    </div>

                </nav>
            </footer>
        </div>
    </div>
</section>
<script src="js/bootstrap.min.js"></script>
<script src="js/admin-scripts.js"></script>
<script>
    var totalRecord, currentPage;
    //去首页
    $(function () {
        to_page(1)
    });

    function to_page(pn) {
        $.ajax({
            url: "/getApplication",
            data: "pn=" + pn,
            type: "GET",
            success: function (result) {
                console.log(result);
                //显示申请表数据
                bulid_apply_table(result);
                //显示分页信息
                build_page_info(result);
                //解析显示分页数据
                build_page_nav(result);
            }
        });
    }

    //构建申请表信息
    function bulid_apply_table(result) {
        $("#apply_tbl tbody").empty();
        var applys = result.list;
        console.log(applys);
        $.each(applys, function (index, item) {
            var checkBoxTd = $("<td><input type='checkbox' class='check_item' name=\"checkbox[]\"/></td>");
            var apyId = $("<td></td>").append(item.applyId);
            var empName = $("<td></td>").append(item.empName);
            var roomName = $("<td></td>").append(item.roomName);
            var meetNum = $("<td></td>").append(item.meetNum);
            var content = $("<td></td>").append(item.content);
            var applyDate = $("<td></td>").append(item.applyDate);
            var isState = item.state;
            var str;
            if (isState == 0) {
                str = "预定";
            } else if (isState == 1) {
                str = "取消";
            }
            var state = $("<td></td>").append(str);
            var startTime = $("<td></td>").append(item.startTime);
            var endTime = $("<td></td>").append(item.endTime);

            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            delBtn.attr("del-id", item.applyId);
            var btnTd = $("<td></td>").append(delBtn);
            $("<tr></tr>").append(checkBoxTd)
                .append(apyId)
                .append(empName)
                .append(roomName)
                .append(meetNum)
                .append(content)
                .append(applyDate)
                .append(startTime)
                .append(endTime)
                .append(state)
                .append(btnTd)
                .appendTo("#apply_tbl tbody");
        })
    }

    //解析显示分页信息
    function build_page_info(result) {
        totalRecord = result.total;
        currentPage = result.pageNum;
        console.log(totalRecord);
        var ele = "#page_apply_area";
        $(ele).empty();
        $(ele).append("当前" + result.pageNum + "页,总" +
            result.pages + "页,总" +
            result.total + "条记录");
        totalRecord = result.total;
        currentPage = result.pageNum;
    }

    //解析显示分页条，点击分页跳转下一页
    function build_page_nav(result) {
        $("#page_apply_nav").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页的事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.pageNum - 1);
            });
        }

        //完成全选/全不选功能
        $("#check_all").click(function () {
            //attr获取checked是undefined;
            //我们这些dom原生的属性；attr获取自定义属性的值；
            //prop修改和读取dom原生属性的值
            $(".check_item").prop("checked", $(this).prop("checked"));
        });

        //check_item
        $(document).on("click", ".check_item", function () {
            //判断当前选择中的元素是否5个
            var flag = $(".check_item:checked").length == $(".check_item").length;
            $("#check_all").prop("checked", flag);
        });

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
        if (result.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            nextPageLi.click(function () {
                to_page(result.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.pages);
            });
        }

        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.navigatepageNums, function (index, item) {

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_apply_nav");
    }

    //单个删除
    $(document).on("click", ".delete_btn", function () {
        //1、弹出是否确认删除对话框
        var applyId = $(this).attr("del-id");
        //alert($(this).parents("tr").find("td:eq(1)").text());
        if (confirm("确认删除【" + applyId + "】吗？")) {
            //确认，发送ajax请求删除即可
            $.ajax({
                url: "/deleteApply/" + applyId,
                type: "POST",
                success: function (result) {
                    //回到本页
                    to_page(currentPage);
                    if (result > 0) {
                        alert("操作成功")
                    }
                }
            });
        }
    });
    //点击全部删除，就批量删除
    $("#apply_delete_all_btn").click(function () {
        //
        var del_idstr = "";
        $.each($(".check_item:checked"), function () {
            //组装id字符串
            del_idstr += $(this).parents("tr").find("td:eq(1)").text() + "-";
        });
        //去除删除的id多余的-
        del_idstr = del_idstr.substring(0, del_idstr.length - 1);
        if (confirm("确认删除【" + del_idstr + "】吗？")) {
            //发送ajax请求删除
            $.ajax({
                url: "/deleteApply/" + del_idstr,
                type: "POST",
                success: function (result) {
                    to_page(currentPage);
                    if (result > 0) {
                        alert("操作成功")
                    }
                }
            });
        }
    });

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


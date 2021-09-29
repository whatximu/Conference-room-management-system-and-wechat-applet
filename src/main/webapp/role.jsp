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
<!-- 权限修改的模态框 -->
<div class="modal fade" id="roleUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">权限修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">权限ID</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="roleId_update_static"></p>
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">权限名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="roleName" class="form-control" id="roleName_update_input" placeholder="roleName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="role_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>



<!-- 添加的模态框 -->
<div class="modal fade" id="roleAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">权限添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">权限名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="roleName" class="form-control" id="roleName_add_input" placeholder="roleName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="role_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<section class="container-fluid">
     <%--header--%>
    <jsp:include flush="false" page="head.jsp" />
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
                <li><a class="dropdown-toggle" id="settingMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">退出</a>
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
                            <button class="btn btn-primary" id="role_add_modal_btn">新增</button>
                            <button class="btn btn-danger" id="role_delete_all_btn">删除</button>
                        </div>
                    </div>
                </ol>
                <h1 class="page-header">权限管理</h1>
                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="apply_tbl">
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="check_all"/></th>
                            <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">权限编号</span></th>
                            <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">权限名称</span></th>
                            <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                        </tr>
                        </thead>
                        <tbody id="role_tbl">

                        </tbody>
                    </table>
                </div>
                <footer class="message_footer">
                    <nav>

                        <div>
                            <!--分页文字信息  -->
                            <div class="col-md-6" id="page_info_area"></div>
                            <!-- 分页条信息 -->
                            <div class="col-md-6" id="page_nav_area">

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
    var totalRecord,currentPage;
    //去首页
    $(function () {
        to_page(1)
    });

    function to_page(pn) {
        $.ajax({
            url:"/getRole",
            data:"pn="+pn,
            type:"GET",
            success:function (result) {
                console.log(result);
                //显示权限表数据
                bulid_apply_table(result);
                //显示分页信息
                build_page_info(result);
                //解析显示分页数据
                $("#page_nav_area").empty();
                var ul = $("<ul></ul>").addClass("pagination");

                //构建元素
                var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
                var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
                if(result.hasPreviousPage == false){
                    firstPageLi.addClass("disabled");
                    prePageLi.addClass("disabled");
                }else{
                    //为元素添加点击翻页的事件
                    firstPageLi.click(function(){
                        to_page(1);
                    });
                    prePageLi.click(function(){
                        to_page(result.pageNum -1);
                    });
                }

                var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
                var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
                if(result.hasNextPage == false){
                    nextPageLi.addClass("disabled");
                    lastPageLi.addClass("disabled");
                }else{
                    nextPageLi.click(function(){
                        to_page(result.pageNum +1);
                    });
                    lastPageLi.click(function(){
                        to_page(result.pages);
                    });
                }

                //添加首页和前一页 的提示
                ul.append(firstPageLi).append(prePageLi);
                //1,2，3遍历给ul中添加页码提示
                $.each(result.navigatepageNums,function(index,item){

                    var numLi = $("<li></li>").append($("<a></a>").append(item));
                    if(result.pageNum == item){
                        numLi.addClass("active");
                    }
                    numLi.click(function(){
                        to_page(item);
                    });
                    ul.append(numLi);
                });
                //添加下一页和末页 的提示
                ul.append(nextPageLi).append(lastPageLi);

                //把ul加入到nav
                var navEle = $("<nav></nav>").append(ul);
                navEle.appendTo("#page_nav_area");
            }
        });
    }
    //构建权限表信息
    function bulid_apply_table(result) {
        $("#role_tbl").empty();
        var applys = result.list;
        console.log(applys);
        $.each(applys,function (index,item) {
            var checkBoxTd = $("<td><input type='checkbox' class='check_item' name=\"checkbox[]\"/></td>");
            var roleId=$("<td></td>").append(item.id);
            var roleName=$("<td></td>").append(item.roleName);


            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");

            editBtn.attr("edit-id",item.id);
            var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            delBtn.attr("del-id",item.id);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            $("<tr></tr>").append(checkBoxTd)
                .append(roleId)
                .append(roleName)
                .append(btnTd)
                .appendTo("#role_tbl");
        })
    }
    //解析显示分页信息
    function build_page_info(result) {
        totalRecord = result.total;
        currentPage = result.pageNum;
        console.log(totalRecord);
        var ele = $("#page_info_area");
        ele.empty();
        ele.append("当前"+result.pageNum+"页,总"+
            result.pages+"页,总"+
            result.total+"条记录");
        totalRecord = result.total;
        currentPage = result.pageNum;
    }
    //完成全选/全不选功能
    $("#check_all").click(function(){
        //attr获取checked是undefined;
        //我们这些dom原生的属性；attr获取自定义属性的值；
        //prop修改和读取dom原生属性的值
        $(".check_item").prop("checked",$(this).prop("checked"));
    });

    //check_item
    $(document).on("click",".check_item",function(){
        //判断当前选择中的元素是否5个
        var flag = $(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);
    });

    //清空表单样式及内容
    function reset_form(ele){
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //点击新增按钮弹出模态框。
    $("#role_add_modal_btn").click(function(){
        reset_form("#roleAddModal form");
        //弹出模态框
        $("#roleAddModal").modal({
            backdrop:"static"
        });
    });

    //点击保存。
    $("#role_save_btn").click(function(){
        //1、模态框中填写的表单数据提交给服务器进行保存

        //2、发送ajax请求保存
        $.ajax({
            url:"/addRole",
            type:"POST",
            data:$("#roleAddModal form").serialize(),
            success:function(result){

                if (result > 0){
                    alert("操作成功");
                    $("#roleAddModal").modal('hide');
                    to_page(totalRecord);
                }else {
                    alert("请填写信息");
                }

            }
        });
    });
    //1、我们是按钮创建之前就绑定了click，所以绑定不上。
    //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
    //jquery新版没有live，使用on进行替代
    $(document).on("click",".edit_btn",function () {
        //查出权限信息
        getRoleById($(this).attr("edit-id"));
        //把id传给更新按钮
        $("#role_update_btn").attr("edit-id",$(this).attr("edit-id"));
        //弹出模态框
        $("#roleUpdateModal").modal({
            backdrop:"static"
        });
    });
    function getRoleById(id) {
        $.ajax({
            url:"/getRole/"+id,
            type:"GET",
            success:function (result) {
                $("#roleId_update_static").text(result.id);
                $("#roleName_update_input").val(result.roleName);
            }
        });
    }
    //点击更新，更新员工信息
    $("#role_update_btn").click(function () {
        $.ajax({
            url:"/updateRole/"+$(this).attr("edit-id"),
            type:"POST",
            data:$("#roleUpdateModal form").serialize(),
            success:function (result) {
                if (result>0){
                    alert("操作成功");
                    $("#roleUpdateModal").modal('hide');
                    to_page(currentPage);
                }else {
                    alert("请填写信息");
                }
            }
        });
    });

    //单个删除
    $(document).on("click",".delete_btn",function(){
        //1、弹出是否确认删除对话框
        var roleName = $(this).parents("tr").find("td:eq(2)").text();
        var roleId = $(this).attr("del-id");
        //alert($(this).parents("tr").find("td:eq(1)").text());
        if(confirm("确认删除【"+roleName+"】吗？")){
            //确认，发送ajax请求删除即可
            $.ajax({
                url:"/deleteRole/"+roleId,
                type:"POST",
                success:function(result){
                    //回到本页
                    to_page(currentPage);
                    if (result>0){
                        alert("操作成功")
                    }
                }
            });
        }
    });
    //点击全部删除，就批量删除
    $("#role_delete_all_btn").click(function(){
        //
        var roleNames = "";
        var del_idstr = "";
        $.each($(".check_item:checked"),function(){
            //this
            roleNames += $(this).parents("tr").find("td:eq(2)").text()+",";
            //组装id字符串
            del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
        });
        //去除roleNames多余的逗号
        roleNames = roleNames.substring(0, roleNames.length-1);
        //去除删除的id多余的-
        del_idstr = del_idstr.substring(0, del_idstr.length-1);
        if(confirm("确认删除【"+roleNames+"】吗？")){
            //发送ajax请求删除
            $.ajax({
                url:"/deleteRole/"+del_idstr,
                type:"POST",
                success:function(result){
                    to_page(currentPage);
                    if (result>0){
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

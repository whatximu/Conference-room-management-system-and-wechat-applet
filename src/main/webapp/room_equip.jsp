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
<!-- 会议室修改的模态框 -->
<div class="modal fade" id="roomUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">会议室修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="roomUpdateForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">会议室名称</label>
                        <div class="col-sm-10">
                            <p class="form-control-static"  name="id" id="roomId_update_static"></p>
                            <span class="help-block"></span>
                        </div>
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label class="col-sm-2 control-label">会议室名称</label>--%>
<%--                        <div class="col-sm-10">--%>
<%--                            <input type="text" name="id" class="form-control" id="roomName_update_input" placeholder="名称">--%>
<%--                            <span class="help-block"></span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label class="col-sm-2 control-label"></label>--%>
<%--                        <div class="col-sm-10">--%>
<%--                            <input type="text" name="location" class="form-control" id="location_update_input" placeholder="位置">--%>
<%--                            <span class="help-block"></span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label class="col-sm-2 control-label">容纳人数</label>--%>
<%--                        <div class="col-sm-10">--%>
<%--                            <input type="text" name="population" class="form-control" id="population_update_input" placeholder="人数">--%>
<%--                            <span class="help-block"></span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label class="col-sm-2 control-label">设备</label>--%>
<%--                        <div class="col-sm-10">--%>
<%--                            <input type="text" name="device" class="form-control" id="device_update_input" placeholder="设备">--%>
<%--                            <span class="help-block"></span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">使用状态</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="info" id="info0_add_input" value="0"> 可用
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="info" id="info1_add_input" value="1"> 有故障
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="info" id="info2_add_input" value="2"> 不能使用
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">维修状态</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="state" id="state0_add_input" value="0"> 可用
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="state" id="state1_add_input" value="1"> 已报修
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="state" id="state2_add_input" value="2"> 正在维修
                            </label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="room_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>



<!-- 会议室添加的模态框 -->
<div class="modal fade" id="roomAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">会议室添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">会议室名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="roomName" class="form-control" id="roomName_add_input" placeholder="名称">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">位置</label>
                        <div class="col-sm-10">
                            <input type="text" name="location" class="form-control" id="location_add_input" placeholder="位置">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">容纳人数</label>
                        <div class="col-sm-10">
                            <input type="text" name="population" class="form-control" id="population_add_input" placeholder="人数">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">设备</label>
                        <div class="col-sm-10">
                            <input type="text" name="device" class="form-control" id="device_add_input" placeholder="设备">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="room_save_btn">保存</button>
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
<%--                <h1 class="page-header">操作</h1>--%>
<%--                <ol class="breadcrumb">--%>
<%--                    <div class="row">--%>
<%--                        <div>--%>
<%--                            <button class="btn btn-primary" id="room_add_modal_btn">新增</button>--%>
<%--                            <button class="btn btn-danger" id="room_delete_all_btn">删除</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </ol>--%>
                <h1 class="page-header">会议室设备管理</h1>
                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="apply_tbl">
                        <thead>
                        <tr>
                            <th><input type="checkbox" id="check_all"/></th>
<%--                            <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">编号</span></th>--%>
                            <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">会议室名称</span></th>
                            <th class="hidden-sm"><span class="glyphicon glyphicon-tag"></span> <span class="visible-lg">会议室设备状态</span></th>
                            <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">会议室设备维修状态</span></th>
<%--                            <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">设备</span></th>--%>
<%--                            <th><span class="glyphicon glyphicon-list"></span> <span class="visible-lg">状态</span></th>--%>
                            <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">操作</span></th>
                        </tr>
                        </thead>
                        <tbody id="room_tbl">

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
            url:"/getAllRoomEquip",
            // data:"pn="+pn,
            type:"GET",
            success:function (result) {
                console.log(result);
                //显示申请表数据
                bulid_room_table(result);
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
    //构建表信息
    function bulid_room_table(result) {
        $("#room_tbl").empty();
        var applys = result.list;
        console.log(applys);
        $.each(applys,function (index,item) {
            var checkBoxTd = $("<td><input type='checkbox' class='check_item' name=\"checkbox[]\"/></td>");

            var id=$("<td></td>").append(item.id);
            //位置
            // var info=$("<td></td>").append(item.info);
            var isStatee=item.info;
            var stre;
            if(isStatee==0){
                stre="正常";
            }else if (isStatee==1){
                stre="部分故障";
            }else if(isStatee==2){
                stre="损坏";
            }

            var info=$("<td></td>").append(stre);


            // var device=$("<td></td>").append(item.device);
            //会议室状态
            var isState=item.state;
            var str;
            if(isState==0){
                str="正常";
            }else if (isState==1){
                str="已报修";
            }else if(isState==2){
                str="正在维修";
            }

            var state=$("<td></td>").append(str);

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            editBtn.attr("edit-id",item.id);


            var btnTd = $("<td></td>").append(editBtn).append(" ");
            $("<tr></tr>").append(checkBoxTd)
                .append(id)
                .append(info)
                .append(state)
                .append(btnTd)
                .appendTo("#room_tbl");
        });
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

    //点击新增按钮弹出模态框。
    $("#room_add_modal_btn").click(function(){
        //弹出模态框
        $("#roomAddModal").modal({
            backdrop:"static"
        });
    });
    // $("#room_save_btn").click(function () {
    //     $.ajax({
    //         url:"/addRoom",
    //         type:"GET",
    //         data:$("#roomAddModal form").serialize(),
    //         success:function (result) {
    //             if (result > 0){
    //                 alert("操作成功");
    //                 $("#roomAddModal").modal('hide');
    //                 to_page(totalRecord);
    //             }else {
    //                 alert("请填写输入框");
    //             }
    //
    //         }
    //     })
    // });
    $(document).on("click",".edit_btn",function () {
        //查询会议室信息
        getRoomById($(this).attr("edit-id"));
        //把id传给更新按钮
        $("#room_update_btn").attr("edit-id",$(this).attr("edit-id"));
        //弹出模态框
       $("#roomUpdateModal").modal({
           backdrop:"static"
       });
    });
    function getRoomById(id) {
        $.ajax({
            url:"/getRoom_equipinfo/"+id,
            type:"GET",
            success:function (result) {
                $("#roomId_update_static").text(result.id);
                $("#roomUpdateForm input[name=info]").val([result.info]).attr("checked",true);
                $("#roomUpdateForm input[name=state]").val([result.state]).attr("checked",true);
            }
        })
    }
    //更新会议室
    $("#room_update_btn").click(function () {
        var a=$("#roomUpdateModal form").serialize()
        var  info= $("input[name='info']:checked").val();
        var state=$("input[name='state']:checked").val();
        // alert(a)
         var usr={"id":$(this).attr("edit-id"),"info":info,"state":state}
         usr2=JSON.stringify(usr)
            // +$(this).attr("edit-id")
        $.ajax({
            url:"/updateRoom_equipinfo",
            type:"POST",
            data:usr2,
            dataType:"json",
            contentType: "application/json; charset=utf-8",
            success:function (result) {
                if (result>0){
                    alert("操作成功");
                    $("#roomUpdateModal").modal('hide');
                    to_page(currentPage);
                }else {
                    alert("请填写信息");
                }
            }
        });
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


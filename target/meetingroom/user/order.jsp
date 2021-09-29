<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的订单</title>
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
    <!-- login-pop-up -->
    <script src="js/menu_jquery.js"></script>
    <!-- //login-pop-up -->
    <!-- animation-effect -->
    <link href="css/animate.min.css" rel="stylesheet">
    <script src="js/wow.min.js"></script>
    <!-- //animation-effect -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
          rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
</head>

<body>
<!-- 订单修改的模态框 -->
<div class="modal fade" id="orderUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">订单修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">订单号</label>
                        <div class="col-sm-6">
                            <input type="text" name="orderId" class="form-control" id="orderid_update_input" placeholder="" readonly
                                   unselectable="on">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">申请日期</label>
                        <div class="col-sm-6">
                            <input type="date" name="applyDate" class="form-control" id="applyDate"
                                   placeholder="">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">开始时间</label>
                        <div class="col-sm-6">
                            <input type="time" name="startTime" class="form-control" id="startTime"
                                   placeholder="">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">结束时间</label>
                        <div class="col-sm-6">
                            <input type="time" name="endTime" class="form-control" id="endTime"
                                   placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">员工ID</label>
                        <div class="col-sm-6">
                            <input type="text" name="empId" class="form-control" id="empId" placeholder="" readonly
                                   unselectable="on">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">参会人数</label>
                        <div class="col-sm-6">
                            <input type="text" name="meetNum" class="form-control" id="meetNum" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">申请用途</label>
                        <div class="col-sm-6">
                            <input type="text" name="content" class="form-control" id="content" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">会议室</label>
                        <div class="col-sm-4">
                            <!-- 部门提交id即可 -->
                            <select class="form-control" name="roomId" id="roomId_select">
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="order_update_btn">修改</button>
            </div>
        </div>
    </div>
</div>
<!--header-->
<jsp:include flush="false" page="header.jsp"/>
<!-- //header -->
<!-- banner -->
<div class="banner2 animated wow slideInUp" data-wow-delay=".5s">
</div>
<!-- //banner -->
<!--typography-page -->
<div class="typo">
    <div class="container">


        <div class="page-header animated wow slideInUp" data-wow-delay=".5s">
            <h3 class="bars">我的订单</h3>
        </div>

        <hr class="bs-docs-separator">
        <div class="bs-docs-example animated wow slideInUp" data-wow-delay=".5s">
            <table class="table table-striped" id="order_tbl">
                <thead>
                <tr>
                    <th>订单号</th>
                    <th>员工姓名</th>
                    <th>会议室</th>
                    <th>参会人数</th>
                    <th>申请用途</th>
                    <th>申请日期</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <div class="grid_3 grid_5 animated wow slideInUp" data-wow-delay=".5s">
            <div class="col-md-4" id="page_info_area"></div>
            <div class="col-md-4" id="page_nav_area">
            </div>
        </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- //typography-page -->
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
    var totalRecord, currentPage;
    //去首页
    $(function () {
        to_page(1);
        getRoomAble();
    });

    function to_page(pn) {
        $.ajax({
            url: "/getAppByEmpId",
            data: {pn:pn,empid:${user.empId}},
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
        $("#order_tbl tbody").empty();
        var applys = result.list;
        console.log(applys);
        $.each(applys, function (index, item) {
            var apyId = $("<td></td>").append(item.applyId);
            var empName = $("<td></td>").append(item.empName);
            var roomName = $("<td></td>").append(item.roomName);
            var meetNum = $("<td></td>").append(item.meetNum);
            var content = $("<td></td>").append(item.content);
            var isState = item.state;
            var str;
            if (isState == 0) {
                str = "预定";
            } else if (isState == 1) {
                str = "取消";
            }
            var state = $("<td></td>").append(str);
            var applyDate = $("<td></td>").append(item.applyDate);
            var startTime = $("<td></td>").append(item.startTime);
            var endTime = $("<td></td>").append(item.endTime);

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("修改");
            //为按钮添加一个自定义的属性，来表示当前订单id
            editBtn.attr("edit-id",item.applyId);
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("退订");
            delBtn.attr("del-id", item.applyId);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            $("<tr></tr>").append(apyId)
                .append(empName)
                .append(roomName)
                .append(meetNum)
                .append(content)
                .append(applyDate)
                .append(startTime)
                .append(endTime)
                .append(state)
                .append(btnTd)
                .appendTo("#order_tbl tbody");
        })
    }

    //解析显示分页信息
    function build_page_info(result) {
        totalRecord = result.total;
        currentPage = result.pageNum;
        console.log(totalRecord);
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.pageNum + "页,总" +
            result.pages + "页,总" +
            result.total + "条记录");
        totalRecord = result.total;
        currentPage = result.pageNum;
    }

    //解析显示分页条，点击分页跳转下一页
    function build_page_nav(result) {
        $("#page_nav_area").empty();
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
        navEle.appendTo("#page_nav_area");
    }
    //获取订单信息
    function getAppById(id) {
        $("#empId_add_select").empty();
        $.ajax({
            url:"/getApply/"+id,
            type:"GET",
            success:function(result){
                console.log(result);
                $("#orderid_update_input").val(result.applyId);
                $("#startTime").val(result.startTime);
                $("#applyDate").val(result.applyDate);
                $("#endTime").val(result.endTime);
                $("#empId").val(result.empId);
                $("#meetNum").val(result.meetNum);
                $("#content").val(result.content);
            }
        });
    }
    //获取可用会议室
    function getRoomAble() {
        $("#roomId_select").empty();
        $.ajax({
            url: "/getRoomState",
            type: "GET",
            success: function (result) {
                console.log(result);
                $.each(result, function () {
                    var optionEle = $("<option></option>").append(this.roomName).attr("value", this.id);
                    $("#roomId_select").append(optionEle);
                })
            }
        });
    }
    //1、我们是按钮创建之前就绑定了click，所以绑定不上。
    //1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
    //jquery新版没有live，使用on进行替代
    $(document).on("click",".edit_btn",function(){
        //alert("edit");
        //查出申请表信息
        getAppById($(this).attr("edit-id"));

        //3、把订单的id传递给模态框的更新按钮
        $("#order_update_btn").attr("edit-id",$(this).attr("edit-id"));
        //弹出更新模态框
        $("#orderUpdateModal").modal({
            backdrop:"static"
        });
    });
    //提交修改
    $("#order_update_btn").click(function () {
        $.ajax({
            url:"/updateApplyById",
            type:"GET",
            data:{str:$("#orderUpdateModal form").serialize()},
            success:function (result) {
                to_page(currentPage);
                if (result>0){
                    alert("操作成功");
                    $("#orderUpdateModal").modal('hide');
                }else if (result == -1){
                    alert("该日期已过时")
                }else if (result == -2){
                    alert("本用户没有预定该会议室的权限");
                }else if (result == -3){
                    alert("该订单已无效");
                }else {
                    alert("输入框不能为空");
                }
            }
        });
    });


    //单个删除
    $(document).on("click",".delete_btn",function(){
        //1、弹出是否确认删除对话框
        var applyId = $(this).attr("del-id");
        //alert($(this).parents("tr").find("td:eq(1)").text());
        if(confirm("确认删除【"+applyId+"】吗？")){
            //确认，发送ajax请求删除即可
            $.ajax({
                url:"/returnApply/"+applyId,
                type:"POST",
                success:function(result){
                    //回到本页
                    to_page(currentPage);
                    if (result>0){
                        alert("操作成功")
                    }else if (result == -1){
                        alert("该订单已经无效");
                    }else if (result == -2){
                        alert("该订单无法退订");
                    }
                }
            });
        }
    });
</script>
</body>
</html>
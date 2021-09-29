<%--
  Created by IntelliJ IDEA.
  User: CaoKai
  Date: 2018-05-18
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>预定会议室</title>
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
    <link href="css/style-gantt.css" rel="stylesheet" type="text/css" media="all">
    <link href="css/prettify.min.css" rel="stylesheet"/>
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
            <h3 class="bars">预定会议室</h3>
        </div>
        <div class="grid_3 grid_5 animated wow slideInUp" data-wow-delay=".5s">
            <div class="gantt"></div>
        </div>
        <div class="grid_3 grid_5 animated wow slideInUp" data-wow-delay=".5s">
            <form id="book_form" class="form-inline">

                <input type="date" name="applyDate" class="form-control" id="applyDate"
                       placeholder="申请日期">

                开始时间<input type="time" name="startTime" class="form-control" id="startTime"
                           placeholder="开始时间">

                结束时间<input type="time" name="endTime" class="form-control" id="endTime" placeholder="结束时间">

                <input type="text" name="empId" class="form-control" id="empId" style="display:none" readonly
                       unselectable="on">

                <input type="text" name="meetNum" class="form-control" id="meetNum" placeholder="参会人数">

                <!----------start section_room----------->

                <select class="form-control" name="roomId" id="roomId_select">

                </select>

                <input type="text" name="content" class="form-control" id="content" placeholder="申请用途">
                <button type="button" id="book_btn" class="btn btn-primary">预定</button>

            </form>
            <div>
                <div>

                </div>
            </div>
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
<script src="js/jquery.fn.gantt.js"></script>
<script src="js/prettify.min.js"></script>
<!-- //for bootstrap working -->
<%----%>
<script type="text/javascript">
    //去首页
    $(function () {
        getRooms();
        $("#empId").val(${user.empId});
        //初始化gantt

    });

    //获取可用会议室
    function getRooms() {
        $("#roomId_select").empty();
        $.ajax({
            url: "/getRoomState",
            type: "GET",
            success: function (result) {
                console.log(result);
                $.each(result, function () {
                    var optionEle = $("<option></option>").append(this.roomName).attr("value", this.id);
                    $("#roomId_select").append(optionEle);
                });
                getOrderByDate(result);
            }
        });
    }

    //预定会议室
    $("#book_btn").click(function () {
        $.ajax({
            url: "/addApplyFrom",
            type: "GET",
            data: {str: $("#book_form").serialize()},
            success: function (result) {
                if (result > 0) {
                    alert("成功预定");
                    window.location.href = "/user/book_room.jsp";
                } else if (result == -1) {
                    alert("没有该员工");
                } else if (result == -2) {
                    alert("该日期已过时!");
                } else if (result == -3) {
                    alert("本用户没有权限预定该会议室");
                } else if (result == -4){
                    alert("预定时间不能重复");
                }else {
                    alert("输入框不能为空！");
                }
            }
        });
    });

    /**
     * 甘特图
     */
    function getOrderByDate(str) {
        $.ajax({
            url: "/getOrderByDate",
            type: "GET",
            success: function (result) {
                console.log(result);
                var data = JSON.parse(result);
                var sourceArray = new Array();
                var sourceObj = new Object();

                $.each(data, function (index, item) {
                    var descData = item.roomName;
                    var dataValue = item.array;
                    console.log(dataValue);
                    var dateArray = new Array();
                    var dataObj = new Object();
                    $.each(dataValue, function () {
                        var fromDate = "/Date(" + this.startTime + ")/";
                        var toDate = "/Date(" + this.endTime + ")/";
                        dataObj = {from: fromDate, to: toDate, label: "", customClass: "ganttRed"};
                        dateArray.push(dataObj);
                    });
                    sourceObj = {desc: descData, values: dateArray};
                    sourceArray.push(sourceObj);
                });
                $(".gantt").gantt({
                    source: sourceArray,
                    months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"], //月份显示的语言
                    dow: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"], //星期显示的语言
                    navigate: "scroll",
                    scale: "hours",
                    maxScale: "months",
                    minScale: "hours",

                });

            }
        });
    }
</script>
</body>
</html>

<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>会议室</title>
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
            <h3 class="bars">会议室查看</h3>
        </div>

        <hr class="bs-docs-separator">
        <div class="bs-docs-example animated wow slideInUp" data-wow-delay=".5s">
            <table class="table table-striped" id="meetroom_tbl">
                <thead>
                <tr>
                    <th>会议室编号</th>
                    <th>会议室名称</th>
                    <th>位置</th>
                    <th>容纳人数</th>
                    <th>设备</th>
                    <th>状态</th>
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
    //去首页
    $(function () {
        to_page(1)
    });

    function to_page(pn) {
        $.ajax({
            url:"/getAllRoom",
            data:"pn="+pn,
            type:"GET",
            success:function (result) {
                console.log(result);
                //显示申请表数据
                bulid_room_table(result);
                //显示分页信息
                build_page_info(result);
                //解析显示分页数据
                build_page_nav(result);
            }
        });
    }
    //构建表信息
    function bulid_room_table(result) {
        $("#meetroom_tbl tbody").empty();
        var applys = result.list;
        console.log(applys);
        $.each(applys,function (index,item) {
            //id
            var roomId=$("<td></td>").append(item.id);
            //会议室名称
            var roomName=$("<td></td>").append(item.roomName);
            //位置
            var location=$("<td></td>").append(item.location);
            //与会人数
            var meetNum=$("<td></td>").append(item.population);
            //设备
            var device=$("<td></td>").append(item.device);
            //会议室状态
            var isState=item.state;
            var str;
            if(isState==0){
                str="可使用";
            }else if (isState==1){
                str="维护";
            }
            var state=$("<td></td>").append(str);

            $("<tr></tr>").append(roomId)
                .append(roomName)
                .append(location)
                .append(meetNum)
                .append(device)
                .append(state)
                .appendTo("#meetroom_tbl tbody");
        });
    }
    //解析显示分页信息
    function build_page_info(result) {
        totalRecord = result.total;
        currentPage = result.pageNum;
        console.log(totalRecord);
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.pageNum+"页,总"+
            result.pages+"页,总"+
            result.total+"条记录");
    }
    //解析显示分页条，点击分页跳转下一页
    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
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
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
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

</script>
</body>
</html>
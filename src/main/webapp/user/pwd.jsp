<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>修改密码</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
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
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
</head>
	
<body>
<!-- header -->
	<jsp:include flush="false" page="header.jsp" />
<!-- //header -->
<!-- banner -->
	<div class="banner2 animated wow slideInUp" data-wow-delay=".5s">
	</div>
<!-- //banner -->
<!-- contact -->
	<div class="contact">
		<div class="container">
			<h2>修改密码</h2>
			<div class="contact_top">
				<div class="col-md-8 contact_left animated wow slideInLeft" data-wow-delay=".4s">
					<form id="pwd_form">
						 <div class="user_name">
							 <input type="text" name="userName" class="form-control" id="userName" placeholder="" style="display:none" readonly
									unselectable="on" value="${sessionScope.user.userName}">
						 </div>
						 <h5>旧密码</h5>
						 <div class="old_pwd">
							 <input type="text" name="oldPwd" class="form-control"placeholder="" id="oldPwd">
						 </div>
						 <h5>新密码</h5>
						 <div class="new_pwd">
							<input type="text" name="newPwd" class="form-control" id="newPwd" placeholder="4-16位数字字母组合">
						 </div>
					</form>
				</div>
				<div class="col-md-8 contact_left animated wow slideInLeft" data-wow-delay=".5s">
					<button type="button" class="btn btn-primary" id="pwd_update_btn">修改</button>
				</div>
			</div>
		</div>
	</div>
<!-- //contact -->
<!-- footer -->
	<div class="footer-copy">
		<div class="container">	
			
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //footer -->
<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<%----%>
<script type="text/javascript">
	$("#pwd_update_btn").click(function () {
        var regPwd = new RegExp(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,16}$/);
        var pwd = $("#newPwd").val().trim();
        if (!regPwd.test(pwd)){
            alert("新密码不合法");
		}else {
            $.ajax({
                url:"/updatePwd",
                type:"GET",
                data:{str:$("#pwd_form").serialize()},
                success:function (result) {
                    if (result > 0){
                        alert("操作成功");
                        window.location.href="/user/login.jsp"
                    }else if (result == -1){
                        alert("用户名或原密码不正确");
                    }else {
                        alert("输入框不能为空");
                    }
                }
            });
		}
    });
</script>
</body>
</html>
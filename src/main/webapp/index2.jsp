<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- login.html -->
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index2.css">
    <title>Github登录</title>
</head>

<body class="bg-light">
<div class="container-fluid">
    <div class="row">
        <div class="col text-center py-4 mt-2">
           <img src="images/sdjtu2.png" alt="" data-toggle="tooltip" data-placement="top"
                                       title="欢迎使用会议室管理系统" draggable="false"/>
<%--            <img class="img-fluid" src="" alt="SDJTU">--%>
        </div>
    </div>
    <div class="row">
        <div class="col text-center">
            <h4 class="text-muted font-weight-light mt-1">Sign in to Github</h4>
        </div>
    </div>
    <div class="row row-custom">
        <div class="col">
            <div class="bg-white p-4 mt-3 border rounded">








                <form>
                    <div class="form-group">
                        <label for="user_name" class="text-dark">USERNAME</label>
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

</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>
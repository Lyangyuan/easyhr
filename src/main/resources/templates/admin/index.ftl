<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>EasyHR</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <style>
        #div1{
            position:fixed;
            top:0;
            left:0;
            bottom:0;
            right:0;
            z-index:-1;
        }
        #div1 img {
            height:100%;
            width:100%;
            border:0;
        }
    </style>
</head>
<body>
<div id="div1"><img src="/static/img/bg.jpg" /></div>
<section class="container">
    <div class="login">
        <h1>欢迎使用 EasyHR 系统</h1>
        <form id="loginForm" method="post" action="/admin/login">
            <p><input type="text" id="account" name="account" value="" placeholder="账号"></p>
            <p><input type="password" id="password" name="password" value="" placeholder="密码"></p>
            <p class="remember_me">
                <label>
                    <input type="checkbox" name="remember" id="remember">
                    记住我
                </label>
            </p>
            <p class="submit"><input type="submit" name="commit" value="登陆"></p>
            <p id="errorMsg" style="color: red;text-align: center">${errorMsg}</p>
        </form>
    </div>
</section>
</body>
<script src="/static/js/jquery-2.1.1.min.js"></script>
<script>


    $("#loginForm").submit(function (e) {
        if(!$("#account").val()){
            $("#account").focus();
            $("#errorMsg").text("账号不能为空");
            e.preventDefault();
        } else  if(!$("#password").val()){
            $("#password").focus();
            $("#errorMsg").text("密码不能为空");
            e.preventDefault();
        }
    });

    $("#account").focus(function(){
        $("#errorMsg").text("");
    });
    $("#password").focus(function(){
        $("#errorMsg").text("");
    });
</script>
</html>
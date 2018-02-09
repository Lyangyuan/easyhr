<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Easy Hr</title>
    <link rel="shortcut icon" href="/static/ico/favicon.ico" type="image/x-icon" />
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="/static/css/style.min.css" rel="stylesheet">
    <style>
        footer {
            display: none;
        }
        #errorMsg{
            color: red;
        }
    </style>
</head>
</head>
<body>
<div class="container-fluid content">
    <div class="row">
        <div id="content" class="col-sm-12 full">
            <div class="row">
                <div class="login-box">
                    <div class="header">
                        欢迎登陆EasyHr
                    </div>
                    <div class="text-center">
                        <p id="errorMsg">${errorMsg}</p>
                    </div>
                    <form class="form-horizontal login" action="/admin/login" method="post">
                        <fieldset class="col-sm-12">
                            <div class="form-group">
                                <div class="controls row">
                                    <div class="input-group col-sm-12">
                                        <input type="text" class="form-control" id="account" name="account" placeholder="请输入账号"/>
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="controls row">
                                    <div class="input-group col-sm-12">
                                        <input type="password" class="form-control" id="password" name="password"/>
                                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class="confirm">
                                <input type="checkbox" id="remember" name="remember"/>
                                <label for="remember">记住我</label>
                            </div>
                            <div class="row">
                                <button type="submit" class="btn btn-lg btn-primary col-xs-12">登陆</button>
                            </div>
                        </fieldset>
                    </form>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/static/js/jquery-2.1.1.min.js"/>
<script src="/static/js/jsencrypt.min.js"/>
<script>
    function login() {
        
    }
</script>
</html>
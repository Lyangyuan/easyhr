<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EasyHR - 账号信息</title>

    <link rel="shortcut icon" href="/static/ico/favicon.ico" type="image/x-icon" />

    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/jquery.mmenu.css" rel="stylesheet">
    <link href="/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="/static/css/climacons-font.css" rel="stylesheet">
    <link href="/static/plugins/xcharts/css/xcharts.min.css" rel=" stylesheet">
    <link href="/static/plugins/fullcalendar/css/fullcalendar.css" rel="stylesheet">
    <link href="/static/plugins/morris/css/morris.css" rel="stylesheet">
    <link href="/static/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    <link href="/static/plugins/jvectormap/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <link href="/static/css/style.min.css" rel="stylesheet">
    <link href="/static/css/add-ons.min.css" rel="stylesheet">
</head>

<body>
<!-- start: Header -->
<#include "/include/header.ftl"/>
<!-- end: Header -->
<div class="container-fluid content">
    <div class="row">
        <!-- start: Main Menu -->
        <#include "/include/menu.ftl"/>

        <!-- start: Content -->
        <div class="main">
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"><i class="fa fa-laptop"></i> 账号信息</h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="/dashboard/index">首页</a></li>
                        <li><i class="fa fa-laptop"></i>账号信息</li>
                    </ol>
                </div>
            </div>

            <div class="row profile">

                <div class="col-md-5">

                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="text-center">
                                <img class="img-profile" src="${userInfo.avatar}">
                            </div>

                            <h3 class="text-center"><strong>${userInfo.nickname}</strong></h3>
                            <h4 class="text-center"><small><i class="fa fa-map-marker"></i> ${userInfo.account}</small></h4>

                            <hr>

                            <h4><strong>联系信息</strong></h4>
                            <ul class="profile-details">
                                <li>
                                    <div><i class="fa fa-phone"></i> 电话</div>
                                    ${userInfo.phone}
                                </li>
                                <li>
                                    <div><i class="fa fa-envelope"></i> 邮箱</div>
                                ${userInfo.email}
                                </li>
                                <li>
                                    <div><i class="fa fa-map-marker"></i> 地址</div>
                                ${userInfo.address}
                                </li>
                            </ul>

                        </div>

                    </div>

                </div><!--/.col-->

                <div class="col-md-7">

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2><i class="fa fa-heart-o red"></i><strong>编辑信息</strong></h2>
                        </div>
                        <div class="panel-body">
                            <form class="form-vertical hover-stripped" role="form" action="#" method="post">
                                <input type="text" value="${userInfo.id}" name = "id" id="id" hidden/>
                                <div class="form-group">
                                    <label class="control-label">账号</label>
                                    <input type="text" class="form-control" value="${userInfo.account}" name="account" disabled>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">昵称</label>
                                    <input type="text" class="form-control" value="${userInfo.nickname}" name = "nickname" id="nickname">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">电话</label>
                                    <input type="text" class="form-control" value="${userInfo.phone}" name="phone" id="phone">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">邮箱</label>
                                    <input type="email" class="form-control" value="${userInfo.email}" name="email" id="email">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">地址</label>
                                    <input type="text" class="form-control" value="${userInfo.address}" name="address" id="address">
                                </div>

                                <div class="form-group">
                                    <label class="control-label">旧密码</label>
                                    <input type="password" class="form-control" name="oldPass" id="oldPass">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">新密码</label>
                                    <input type="password" class="form-control" name="newPass" id="newPass">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">再次输入新密码</label>
                                    <input type="password" class="form-control" name="newPassAgain" id="newPassAgain">
                                </div>

                                <div class="form-group pull-right">
                                    <button class="btn btn-primary" type="submit">更新</button>
                                </div>
                            </form>
                        </div>
                    </div>

                </div><!--/.col-->

            </div>

        </div>
    </div><!--/container-->
    <div class="clearfix"></div>

    <script src="/static/js/jquery-2.1.1.min.js"></script>
    <script src="/static/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <!-- page scripts -->
    <script src="/static/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
    <script src="/static/plugins/touchpunch/jquery.ui.touch-punch.min.js"></script>
    <script src="/static/plugins/moment/moment.min.js"></script>
    <script src="/static/plugins/fullcalendar/js/fullcalendar.min.js"></script>
    <script src="/static/plugins/flot/jquery.flot.min.js"></script>
    <script src="/static/plugins/flot/jquery.flot.pie.min.js"></script>
    <script src="/static/plugins/flot/jquery.flot.stack.min.js"></script>
    <script src="/static/plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="/static/plugins/flot/jquery.flot.time.min.js"></script>
    <script src="/static/plugins/flot/jquery.flot.spline.min.js"></script>
    <script src="/static/plugins/xcharts/js/xcharts.min.js"></script>
    <script src="/static/plugins/autosize/jquery.autosize.min.js"></script>
    <script src="/static/plugins/placeholder/jquery.placeholder.min.js"></script>
    <script src="/static/plugins/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/static/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
    <script src="/static/plugins/raphael/raphael.min.js"></script>
    <script src="/static/plugins/morris/js/morris.min.js"></script>
    <script src="/static/plugins/jvectormap/js/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="/static/plugins/jvectormap/js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="/static/plugins/jvectormap/js/gdp-data.js"></script>
    <script src="/static/plugins/gauge/gauge.min.js"></script>
    <script src="/static/js/SmoothScroll.js"></script>
    <script src="/static/js/jquery.mmenu.min.js"></script>
    <script src="/static/js/core.min.js"></script>
    <script src="/static/plugins/d3/d3.min.js"></script>
    <script src="/static/js/pages/index.js"></script>
</body>
</html>
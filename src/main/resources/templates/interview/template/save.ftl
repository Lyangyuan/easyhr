<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EasyHR - 编辑模板</title>

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


    <script type="text/javascript" charset="utf-8" src="/static/plugins/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/static/plugins/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="/static/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>

    <script type="text/javascript">
        var ue = UE.getEditor('editor', {
            autoHeightEnabled: true,
            autoFloatEnabled: true
        });

        UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
        UE.Editor.prototype.getActionUrl = function(action) {
            if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadfile') {
                return '/resource/upload';
            } else if (action == 'uploadvideo') {
                return '/resource/upload';
            } else {
                return this._bkGetActionUrl.call(this, action);
            }
        }
    </script>
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
                    <h3 class="page-header"><i class="fa fa-laptop"></i> 编辑模板</h3>
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="/dashboard/index">首页</a></li>
                        <li><i class="fa fa-laptop"></i>编辑模板</li>
                    </ol>
                </div>
            </div>

            <#--其他内容-->
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-body">

                        <div>
                            <script id="editor" type="text/plain" style="width:100%;height:500px;"/>
                        </div>
                    </div>
                </div>
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
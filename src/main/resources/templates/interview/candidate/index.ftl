<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EasyHR - 候选人</title>

    <link rel="shortcut icon" href="/static/ico/favicon.ico" type="image/x-icon"/>

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

    <style>
        .easy_user{
            width: 40px;
            height: 40px;
            border-radius: 20px;
        }
    </style>
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
                    <ol class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href="/dashboard/index">首页</a></li>
                        <li><i class="fa fa-laptop"></i>候选人</li>
                    </ol>
                </div>
            </div>

        <#--其他内容-->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2><i class="fa fa-table red"></i><span class="break"></span><strong>候选人列表</strong></h2>
                        </div>
                        <div class="panel-body">
                            <div class="row" style="padding-left: 3px;padding-right: 3px">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <div class="input-group">
				                            <span class="input-group-btn">
				                            <button type="button" class="btn btn-primary"><i class="fa fa-search"></i> 搜索</button>
				                            </span>
                                            <input type="text" id="searchText" name="searchText"
                                                   class="form-control" placeholder="姓名或职位">
                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <a href="/candidate/add" class="btn btn-primary">
                                            <i class="fa fa-plus-square"></i> 添加
                                        </a>
                                        <a href="#" class="btn btn-primary">
                                            <i class="fa fa-cloud-download"></i> 下载
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                <thead>
                                <tr>
                                    <th>邀约人</th>
                                    <th>
                                        最后更新时间
                                        <a href="#" class="btn-minimize"><i class="fa fa-unsorted"></i></a>
                                    </th>
                                    <th>姓名</th>
                                    <th>职位</th>
                                    <th>电话</th>
                                    <th>地区</th>
                                    <th>简历来源</th>
                                    <th>简历</th>
                                    <th>备注</th>
                                    <th>进度</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pageResult.data as c>

                                </#list>
                                <tr>
                                    <td>
                                        <img class="easy_user" alt="Lucas" src="/static/upload/avatar/avatar.jpg">
                                        承乙
                                    </td>
                                    <td>17-12-11</td>
                                    <td>杨媛(女)</td>
                                    <td>hr</td>
                                    <td>157.。。。</td>
                                    <td>杭州</td>
                                    <td>猎聘</td>
                                    <td>
                                        <a href="#">下载</a>
                                    </td>
                                    <td>是个傻逼</td>
                                    <td>
                                        <div class="btn-group dropup">
                                            <button type="button" class="btn btn-primary">待面</button>
                                            <button type="button" class="btn btn-primary dropdown-toggle"
                                                    data-toggle="dropdown">
                                                <span class="caret"></span>
                                                <span class="sr-only"></span>
                                            </button>
                                            <ul class="dropdown-menu pull-right" role="menu">
                                                <#list statusList as status>
                                                    <li><a href="#">${status}</a></li>
                                                </#list>
                                            </ul>
                                        </div>
                                    </td>
                                    <td>
                                        <a class="btn btn-success" href="#">
                                            详情
                                        </a>
                                        <a class="btn btn-info" href="#">
                                            面试记录
                                        </a>
                                        <a class="btn btn-info" htrf="#">
                                            入职
                                        </a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <ul class="pagination pull-right">
                                <li><a href="/candidate/index?pageIndex=${pageResult.prePage}">上一页</a></li>
                                <#list pageResult.pages as page>
                                    <#if page == pageResult.currentPage>
                                        <li class="active"><a href="/candidate/index?pageIndex=${page}">${page}</a></li>
                                    <#else >
                                        <li><a href="/candidate/index?pageIndex=${page}">${page}</a></li>
                                    </#if>
                                </#list>
                                <li><a href="/candidate/index?pageIndex=${pageResult.nextPage}">下一页</a></li>
                            </ul>
                        </div>
                    </div>
                </div><!--/col-->

            </div><!--/row-->

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
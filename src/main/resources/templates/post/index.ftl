<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EasyHR - 岗位</title>

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
                        <li><i class="fa fa-home"></i><a href="/admin/index">首页</a></li>
                        <li><i class="fa fa-laptop"></i>岗位</li>
                    </ol>
                </div>
            </div>

        <#--其他内容-->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2><i class="fa fa-table red"></i><span class="break"></span><strong>岗位列表</strong></h2>
                        </div>
                        <div class="panel-body">
                            <div class="row" style="padding-left: 3px;padding-right: 3px">
                                <div class="form-group">
                                    <div class="col-md-8">
                                        <a class="btn btn-primary" data-toggle="modal" data-target="#addPostModal">
                                            <i class="fa fa-plus-square"></i> 添加
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>名称</th>
                                    <th>描述</th>
                                    <th>添加人</th>
                                    <th>添加时间</th>
                                    <th>最后修改人</th>
                                    <th>最后修改时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#list posts as post>
                                    <tr>
                                        <td>${post.id}</td>
                                        <td>${post.postName}</td>
                                        <td>${post.postIntroduction}</td>
                                        <td>${post.createdUser.nickname}</td>
                                        <td>${post.gmtCreated}</td>
                                        <td>${post.modifiedUser.nickname}</td>
                                        <td>${post.gmtModified}</td>
                                        <td>
                                            <a class="btn btn-success" onclick="edit(${post.id})">
                                                编辑
                                            </a>
                                            <a class="btn btn-info" href="/post/delete?id=${post.id}">
                                                删除
                                            </a>
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div><!--/col-->

            </div><!--/row-->

        </div>
    </div><!--/container-->
    <div class="clearfix"></div>


    <!-- 模态框（Modal） -->
    <div class="modal fade" id="addPostModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">添加岗位</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form" method="post" action="/post/save" id="postForm">
                        <input type="text" id="id" name="id" value="0" hidden>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="text-input">岗位名称</label>
                            <div class="col-md-10">
                                <input type="text" id="postName" name="postName" class="form-control" placeholder="名称"">
                                <span class="help-block">请填写岗位名称</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="phone">岗位说明</label>
                            <div class="col-md-10">
                                <input type="text" id="postIntroduction" name="postIntroduction" class="form-control"
                                       placeholder="岗位说明">
                                <span class="help-block">请填写岗位说明</span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button id="addPost" type="button" class="btn btn-primary" onclick="savePost()">添加</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <script>
        function savePost() {
            var name = checkInput("postForm");
            if(name !== "OK"){
                $("#"+name).focus();
                $("#"+name).next("span").css("color","red");
                return;
            }
            var form = $("#postForm");
            form.submit();
            $('#addPostModal').modal('hide')
        }

        function edit(id) {
            var url = "/post/get?id="+id;
            $.get(url,function(data){
                $("#id").val(data.id);
                $("#postName").val(data.postName);
                $("#postIntroduction").val(data.postIntroduction);
                $("#addPost").text("保存");
                $('#addPostModal').modal('show')
            });
        }
    </script>

    <script src="/static/js/jquery-2.1.1.min.js"></script>
    <script src="/static/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/app.js"></script>
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
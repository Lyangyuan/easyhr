<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EasyHR - 添加候选人</title>

    <link rel="shortcut icon" href="/static/ico/favicon.ico" type="image/x-icon"/>
    <!-- Css files -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/jquery.mmenu.css" rel="stylesheet">
    <link href="/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="/static/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    <link href="/static/css/style.min.css" rel="stylesheet">
    <link href="/static/css/add-ons.min.css" rel="stylesheet">

    <style>
        .easy_user {
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
                        <li><i class="fa fa-file-text"></i><a href="/candidate/index">面试管理</a></li>
                        <li><i class="fa fa-plus-square"></i>添加候选人</li>
                    </ol>
                </div>
            </div>

        <#--其他内容-->
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2><i class="fa fa-tags red"></i><strong>候选人信息</strong></h2>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form" action="/candidate/save" method="post">
                                <#if candidate ??>
                                    <input type="text" id="id" name="id" value="${candidate.id}"/>
                                </#if>
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="text-input">姓名</label>
                                    <div class="col-md-10">
                                        <#if candidate ??>
                                            <input type="text" id="name" name="name" class="form-control" placeholder="姓名" value="${candidate.name}">
                                        <#else >
                                            <input type="text" id="name" name="name" class="form-control" placeholder="姓名">
                                        </#if>
                                        <span class="help-block">请填写候选人姓名</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="phone">电话</label>
                                    <div class="col-md-10">
                                        <#if candidate ??>
                                            <input type="text" id="phone" name="phone" class="form-control"
                                                   placeholder="电话" value="${candidate.phone}">
                                        <#else >
                                            <input type="text" id="phone" name="phone" class="form-control"
                                                   placeholder="电话">
                                        </#if>
                                        <span class="help-block">请填写候选人电话</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="phone">简历来源</label>
                                    <div class="col-md-10">
                                        <#if candidate ??>
                                            <input type="text" id="resumeSource" name="resumeSource" class="form-control"
                                                   placeholder="简历来源" value="${candidate.resumeSource}">
                                        <#else >
                                            <input type="text" id="resumeSource" name="resumeSource" class="form-control"
                                                       placeholder="简历来源">
                                        </#if>
                                        <span class="help-block">请填写简历来源</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="address">地址</label>
                                    <div class="col-md-10">
                                        <#if candidate ??>
                                            <input type="text" id="address" name="address" class="form-control"
                                                   placeholder="候选人地址" value="${candidate.address}"/>
                                        <#else >
                                            <input type="text" id="address" name="address" class="form-control"
                                                   placeholder="候选人地址"/>
                                        </#if>
                                        <span class="help-block">请填写候选人地址</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="pre_company_name">上家单位</label>
                                    <div class="col-md-10">
                                        <#if candidate ??>
                                            <input type="text" id="preCompanyName" name="preCompanyName"
                                                   class="form-control" placeholder="候选人上家单位" value="${candidate.preCompanyName}"/>
                                        <#else >
                                            <input type="text" id="preCompanyName" name="preCompanyName"
                                                   class="form-control" placeholder="候选人上家单位"/>
                                        </#if>
                                        <span class="help-block">2312321</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="post">岗位1</label>
                                    <div  class="col-md-10">
                                        <select id="postId" name="postId" class="form-control">
                                            <#list posts as post>
                                                <option value="${post.id}" selected>${post.postName}</option>
                                            </#list>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="post">岗位2</label>
                                    <div  class="col-md-10">
                                        <select id="post2Id" name="post2Id" class="form-control">
                                        <#list posts as post>
                                            <option value="${post.id}" selected>${post.postName}</option>
                                        </#list>
                                        </select>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="salary">当前薪资</label>
                                    <div class="col-md-10">
                                        <#if candidate ??>
                                            <input type="number" id="salary" name="salary"
                                                   class="form-control" placeholder="当前薪资" value="${candidate.salary}"/>
                                        <#else >
                                            <input type="number" id="salary" name="salary"
                                                   class="form-control" placeholder="当前薪资"/>
                                        </#if>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label" for="overtime">加班费</label>
                                    <div class="col-md-10">
                                        <#if candidate ??>
                                            <input type="text" id="overtime" name="overtime"
                                                   class="form-control" placeholder="加班费" value="${candidate.overtime}"/>
                                        <#else >
                                            <input type="text" id="overtime" name="overtime"
                                                   class="form-control" placeholder="加班费"/>
                                        </#if>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">缴纳五险</label>
                                    <div class="col-md-10">
                                        <label class="radio-inline" for="isPayFiveInsurance1">
                                            <input type="radio" id="isPayFiveInsurance1" name="isPayFiveInsurance" value="0"> 是
                                        </label>
                                        <label class="radio-inline" for="isPayFiveInsurance2">
                                            <input type="radio" id="isPayFiveInsurance2" name="isPayFiveInsurance" value="1"> 否
                                        </label>
                                        <label class="radio-inline" for="isPayFiveInsurance3">
                                            <input type="radio" id="isPayFiveInsurance3" name="isPayFiveInsurance" value="2"> 未知
                                        </label>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">缴纳一金</label>
                                    <div class="col-md-10">
                                        <label class="radio-inline" for="isPayFund1">
                                            <input type="radio" id="isPayFund1" name="isPayFund" value="0"> 是
                                        </label>
                                        <label class="radio-inline" for="isPayFund2">
                                            <input type="radio" id="isPayFund2" name="isPayFund" value="1"> 否
                                        </label>
                                        <label class="radio-inline" for="isPayFund3">
                                            <input type="radio" id="isPayFund3" name="isPayFund" value="2"> 未知
                                        </label>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">是否包吃</label>
                                    <div class="col-md-10">
                                        <label class="radio-inline" for="isProvideFood1">
                                            <input type="radio" id="isProvideFood1" name="isProvideFood" value="0"> 是
                                        </label>
                                        <label class="radio-inline" for="isProvideFood2">
                                            <input type="radio" id="isProvideFood2" name="isProvideFood" value="1"> 否
                                        </label>
                                        <label class="radio-inline" for="isProvideFood3">
                                            <input type="radio" id="isProvideFood3" name="isProvideFood" value="2"> 未知
                                        </label>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">是否包住</label>
                                    <div class="col-md-10">
                                        <label class="radio-inline" for="isProvideHouse1">
                                            <input type="radio" id="isProvideHouse1" name="isProvideHouse" value="0"> 是
                                        </label>
                                        <label class="radio-inline" for="isProvideHouse2">
                                            <input type="radio" id="isProvideHouse2" name="isProvideHouse" value="1"> 否
                                        </label>
                                        <label class="radio-inline" for="isProvideHouse3">
                                            <input type="radio" id="isProvideHouse3" name="isProvideHouse" value="2"> 未知
                                        </label>
                                        <span class="help-block"></span>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="panel-footer">
                            <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-user"></i> 提交</button>
                            <button type="reset" class="btn btn-sm btn-danger"><i class="fa fa-ban"></i> 重置</button>
                        </div>
                    </div>
                </div><!--/col-->
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2><i class="fa fa-tags red"></i><strong>备注</strong></h2>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="mark">备注</label>
                                    <textarea id="mark" name="mark" class="form-control" style="height: 200px;">
                                    </textarea>
                                </div>
                            </form>
                        </div>

                    </div>
                </div><!--/col-->
            </div><!--/row-->

        </div>
    </div><!--/container-->
    <div class="clearfix"></div>

    <script src='/static/js/jquery-2.1.1.min.js'></script>
    <script src="/static/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
    <script src="/static/plugins/chosen/js/chosen.jquery.min.js"></script>
    <script src="/static/plugins/autosize/jquery.autosize.min.js"></script>
    <script src="/static/plugins/placeholder/jquery.placeholder.min.js"></script>
    <script src="/static/plugins/wizard/jquery.bootstrap.wizard.min.js"></script>
    <script src="/static/plugins/maskedinput/jquery.maskedinput.min.js"></script>
    <script src="/static/js/SmoothScroll.js"></script>
    <script src="/static/js/jquery.mmenu.min.js"></script>
    <script src="/static/js/core.min.js"></script>
    <script src="/static/js/pages/form-wizard.js"></script>
</body>
</html>
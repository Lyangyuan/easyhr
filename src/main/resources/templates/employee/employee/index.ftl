<!DOCTYPE html>
<html>

<#-- head -->
<#include "/include/head.ftl"/>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

<#-- header -->
<#include "/include/header.ftl"/>

<#-- menu -->
<#include "/include/menu.ftl"/>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <span class="layui-breadcrumb">
              <a href="/"><i class="layui-icon">&#xe68e;</i>&nbsp;首页</a>
              <a><cite>员工管理</cite></a>
            </span>


            <div class="layui-tab layui-tab-card">
                <ul class="layui-tab-title">
                    <li class="layui-this">在职员工</li>
                    <li>离职员工</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <table class="layui-table">
                            <colgroup>
                                <col width="150">
                                <col width="200">
                                <col>
                            </colgroup>
                            <thead>
                            <tr>
                                <th>昵称</th>
                                <th>加入时间</th>
                                <th>签名</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>贤心</td>
                                <td>2016-11-29</td>
                                <td>人生就像是一场修行</td>
                            </tr>
                            <tr>
                                <td>贤心</td>
                                <td>2016-11-29</td>
                                <td>人生就像是一场修行</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="layui-tab-item">
                        <table class="layui-table">
                            <colgroup>
                                <col width="150">
                                <col width="200">
                                <col>
                            </colgroup>
                            <thead>
                            <tr>
                                <th>昵称</th>
                                <th>加入时间</th>
                                <th>签名</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>贤心</td>
                                <td>2016-11-29</td>
                                <td>人生就像是一场修行</td>
                            </tr>
                            <tr>
                                <td>贤心</td>
                                <td>2016-11-29</td>
                                <td>人生就像是一场修行</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
<script src="/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
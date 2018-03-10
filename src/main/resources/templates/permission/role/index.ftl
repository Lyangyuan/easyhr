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
              <a><cite>角色管理</cite></a>
            </span>

            <div class="layui-row" style="margin-top: 10px">
                <div class="layui-col-md12">
                    <a href="/permission/role/save" class="layui-btn layui-btn-normal">
                        <i class="layui-icon">&#xe654;</i>
                        添加角色
                    </a>
                </div>
            </div>

            <table class="layui-table">
                <thead>
                <tr>
                    <th>角色名称</th>
                    <th>添加时间</th>
                    <th>创建人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list roles as role>
                        <tr>
                            <td>${role.roleName}</td>
                            <td>${role.gmtCreated}</td>
                            <td>${role.createdUser.nickname}</td>
                            <td>
                                <a href="/permission/role/save?id=${role.id}" class="layui-btn layui-btn-sm layui-btn-danger">
                                    <i class="layui-icon">&#xe640;</i>
                                    编辑权限
                                </a>
                            </td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    //JavaScript代码区域
    layui.use(['element','layer','form'], function () {
        var element = layui.element;
        var $ = layui.jquery;
        var layer = layui.layer;

    });
</script>
</body>
</html>
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
              <a><cite>编辑权限</cite></a>
            </span>
        </div>
    </div>
</div>

<script>
    //JavaScript代码区域
    layui.use(['element','form'], function () {
        var element = layui.element;
        var $ = layui.jquery;

    });
</script>
</body>
</html>
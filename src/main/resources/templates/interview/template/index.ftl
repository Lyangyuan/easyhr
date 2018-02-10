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
              <a><cite>模板管理</cite></a>
            </span>

            <div class="layui-row" style="margin-top: 10px">
                <div class="layui-col-md12">
                    <a href="/interview/template/add" class="layui-btn layui-btn-normal">
                        <i class="layui-icon">&#xe654;</i>
                        添加模板
                    </a>
                </div>
            </div>

            <table class="layui-table">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>说明</th>
                    <th>添加时间</th>
                    <th>最近修改时间</th>
                    <th>创建人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list templates as temp>
                <tr>
                    <td>${temp.name}</td>
                    <td>${temp.comment}</td>
                    <td>${temp.gmtCreated}</td>
                    <td>${temp.gmtModified}</td>
                    <td>${temp.createdUser.nickname}</td>
                    <td>
                        <a href="/interview/template/edit?id=${temp.id}" class=" layui-btn layui-btn-sm layui-btn-normal">
                            <i class="layui-icon">&#xe642;</i>
                            编辑
                        </a>
                        <button id="deleteTemp" data="${temp.id}" class=" layui-btn layui-btn-sm layui-btn-danger">
                            <i class="layui-icon">&#xe640;</i>
                            删除
                        </button>
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
    layui.use(['element','layer'], function () {
        var element = layui.element;
        var $ = layui.jquery;

        $("#deleteTemp").on("click",function () {
            var id = $(this).attr("data");
            layer.msg('您确定要删除此模板吗?', {
                time:false,
                shadeClose:true,
                shade:0.3,
                btn: ['确认', '取消'],
                yes: function(index, layero){
                    window.location.href = "/interview/template/delete?id="+id;
                }
                ,btn2: function(index, layero){
                    layer.closeAll();
                }
            });
        });
    });
</script>
</body>
</html>
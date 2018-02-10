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
              <a><cite>岗位管理</cite></a>
            </span>

            <div class="layui-row" style="margin-top: 10px">
                <div class="layui-col-md12">
                    <button id="addPost" class="layui-btn layui-btn-normal">
                        <i class="layui-icon">&#xe654;</i>
                        添加岗位
                    </button>
                </div>
            </div>

            <table class="layui-table">
                <thead>
                <tr>
                    <th>岗位</th>
                    <th>说明</th>
                    <th>添加时间</th>
                    <th>创建人</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr id="addTr" hidden>
                    <td colspan="5">
                        <form class="layui-form" action="/employee/post/save" method="post">
                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label class="layui-form-label">名称</label>
                                    <div class="layui-input-inline">
                                        <input name="postName" lay-verify="required" autocomplete="off" class="layui-input" type="tel">
                                    </div>
                                </div>
                                <div class="layui-inline">
                                    <label class="layui-form-label">说明</label>
                                    <div class="layui-input-inline">
                                        <input name="postIntroduction" lay-verify="required" autocomplete="off" class="layui-input" type="text">
                                    </div>
                                </div>
                                <div class="layui-inline">
                                    <div class="layui-input-block">
                                        <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="demo1">立即提交</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </td>
                </tr>
                <#list posts as post>
                    <tr>
                        <td>${post.postName}</td>
                        <td>${post.postIntroduction}</td>
                        <td>${post.gmtCreated}</td>
                        <td>${post.createdUser.nickname}</td>
                        <td>
                            <button id="deletePost" data="${post.id}" class=" layui-btn layui-btn-sm layui-btn-danger">
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
        var layer = layui.layer;

        $("#addPost").on("click",function () {
            $("#addTr").show();
        });

        $("#deletePost").on("click",function () {
            var id = $(this).attr("data");
            layer.msg('您确定要删除此岗位吗?', {
                time:false,
                shadeClose:true,
                shade:0.3,
                btn: ['确认', '取消'],
                yes: function(index, layero){
                    window.location.href = "/employee/post/delete?id="+id;
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
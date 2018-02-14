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
                <#list posts as post>
                    <tr>
                        <td>${post.postName}</td>
                        <td>${post.postIntroduction}</td>
                        <td>${post.gmtCreated}</td>
                        <td>${post.createdUser.nickname}</td>
                        <td>
                            <button data="${post.id}" class="layui-btn layui-btn-sm layui-btn-danger deletePost">
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

<div id="addPostDiv" style="padding:10px;" hidden="hidden">
    <form id="addForm" class="layui-form" action="/employee/post/save" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-inline">
                <input type="text" name="postName"  lay-verify="required" placeholder="请输入岗位名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-inline">
                <input type="text" name="postIntroduction"  lay-verify="required" placeholder="请输入岗位说明" autocomplete="off" class="layui-input">
            </div>
        </div>
    </form>
</div>

<script>
    //JavaScript代码区域
    layui.use(['element','layer','form'], function () {
        var element = layui.element;
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;

        $("#addPost").on("click",function () {
            $("#addPostDiv").show();
            layer.open({
              type: 1,
              content: $('#addPostDiv'),
              btnAlign: 'c',
              area: '380px',
              btn: ['确认', '取消'],
              yes: function(index, layero){
                   $("#addForm").submit();
              },
              btn2: function(index, layero){
                $("#addFormDiv").hide();
                layer.close(index);
              }
        });
        });

        $(".deletePost").on("click",function () {
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
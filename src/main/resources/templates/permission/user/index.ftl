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
                <a><cite>用户管理</cite></a>
            </span>

            <div class="layui-row" style="margin-top: 10px">
                <div class="layui-col-md12">
                    <button id="addUser" class="layui-btn layui-btn-normal">
                        <i class="layui-icon">&#xe654;</i>
                        添加用户
                    </button>
                </div>
            </div>

            <table class="layui-table">
                <thead>
                <tr>
                    <th>头像</th>
                    <th>昵称</th>
                    <th>账号</th>
                    <th>电话</th>
                    <th>邮箱</th>
                    <th>地址</th>
                    <th>创建时间</th>
                    <th>角色</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list roleUsers as roleUser>
                    <tr>
                        <td>
                            <#if roleUser.user.avatar ??>
                                <img src="${roleUser.user.avatar}" class="layui-nav-img"/>
                            <#else>
                                <span class="layui-badge layui-bg-black">无</span>
                            </#if>
                        </td>
                        <td>${roleUser.user.nickname}</td>
                        <td>${roleUser.user.account}</td>
                        <td>
                            <#if roleUser.user.phone ??>
                                ${roleUser.user.phone}
                            <#else>
                                <span class="layui-badge layui-bg-black">无</span>
                            </#if>
                        </td>
                        <td>
                            <#if roleUser.user.email ??>
                            ${roleUser.user.email}
                            <#else>
                            <span class="layui-badge layui-bg-black">无</span>
                        </#if>
                        </td>
                        <td>
                            <#if roleUser.user.address ??>
                            ${roleUser.user.address}
                            <#else>
                            <span class="layui-badge layui-bg-black">无</span>
                        </#if>
                        </td>
                        <td>${roleUser.user.gmtCreated}</td>
                        <td>${roleUser.role.roleName}</td>
                        <td>
                            <#if roleUser.user.isFreeze == 0>
                                <span class="layui-badge layui-bg-blue">正常</span>
                            <#else>
                                <span class="layui-badge">冻结</span>
                            </#if>
                        </td>
                        <td>
                            <#if roleUser.user.isSuperAdmin == 0>
                                <#if roleUser.user.isFreeze == 0>
                                    <a href="/permission/user/freeze?id=${roleUser.user.id}" class=" layui-btn layui-btn-sm layui-btn-danger">
                                        <i class="layui-icon">&#x1007;</i>
                                        冻结
                                    </a>
                                <#else>
                                    <a href="/permission/user/freeze?id=${roleUser.user.id}" class=" layui-btn layui-btn-sm layui-btn-normal">
                                        <i class="layui-icon">&#xe616;</i>
                                        恢复
                                    </a>
                                </#if>
                                <button data="${roleUser.user.id}" class="layui-btn layui-btn-sm layui-btn-danger deleteUser">
                                    <i class="layui-icon">&#xe640;</i>
                                    删除
                                </button>
                            <#else>
                            <button class=" layui-btn layui-btn-sm layui-btn-disabled">
                                <i class="layui-icon">&#x1007;</i>
                                不可操作
                            </button>
                            </#if>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
            <p style="color:red">新增用户默认密码为：123456789,请通知新增用户尽快修改密码</p>
        </div>
    </div>

</div>

<div id="addFormDiv" style="padding:10px;" hidden="hidden">
    <form id="addForm" class="layui-form" action="/permission/user/add" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">化名</label>
            <div class="layui-input-inline">
                <input type="text" name="nickname"  lay-verify="required" placeholder="请输入化名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline">
                <input type="text" name="account"  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-block">
                <input type="radio" name="role" value="2" title="管理员">
                <input type="radio" name="role" value="3" title="普通用户" checked>
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

        $("#addUser").on("click",function(){
            $("#addFormDiv").show();
            layer.open({
              type: 1,
              content: $('#addFormDiv'),
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

        $(".deleteUser").on("click",function () {
            var id = $(this).attr("data");
            layer.msg('您确定要删除此用户吗?', {
                time:false,
                shadeClose:true,
                shade:0.3,
                btn: ['确认', '取消'],
                yes: function(index, layero){
                    window.location.href = "/permission/user/delete?id="+id;
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
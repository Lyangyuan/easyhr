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

            <fieldset class="layui-elem-field" style="margin-top: 15px;">
                <legend>编辑权限</legend>
                <div class="layui-field-box">
                    <form class="layui-form" action="/permission/role/save" method="post">
                        <#if currentRole ??>
                            <input name="roleId" type="text" value="${currentRole.id}" hidden/>
                        </#if>

                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">角色</label>
                                <div class="layui-input-inline">
                                    <#if currentRole ??>
                                        <input name="roleName" class="layui-input" type="text" value="${currentRole.roleName}" lay-verify="required">
                                    <#else>
                                        <input name="roleName" class="layui-input" type="text" lay-verify="required">
                                    </#if>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">权限点</label>
                            <div class="layui-input-block">
                                <table class="layui-table" style="width:250px;">
                                    <thead>
                                    <tr>
                                        <th>权限点</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list permissionVOS as vos>
                                        <tr>
                                            <td >
                                                <#if vos.checked>
                                                    <input id="${vos.id}" data-level="1" data-parent="-1" name="permission" lay-skin="primary" title="${vos.name}" checked="" type="checkbox" value="${vos.id}">
                                                <#else>
                                                    <input id="${vos.id}" data-level="1" data-parent="-1" name="permission" lay-skin="primary" title="${vos.name}" type="checkbox" value="${vos.id}">
                                                </#if>
                                            </td>
                                        </tr>
                                        <#list vos.children as c1>
                                            <tr>
                                                <td >
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <#if c1.checked>
                                                        <input id="${c1.id}" data-level="2" data-parent="${vos.id}" name="permission" lay-skin="primary" title="${c1.name}" checked="" type="checkbox" value="${c1.id}">
                                                    <#else>
                                                        <input id="${c1.id}" data-level="2" data-parent="${vos.id}" name="permission" lay-skin="primary" title="${c1.name}" checked="" type="checkbox" value="${c1.id}">
                                                    </#if>
                                                </td>
                                            </tr>
                                            <#list c1.children as c2>
                                            <tr>
                                                <td >
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <#if c2.checked>
                                                        <input id="${c2.id}" data-level="3" data-parent="${c1.id}" name="permission" lay-skin="primary" checked="" title="${c2.name}" type="checkbox" value="${c2.id}">
                                                    <#else>
                                                        <input id="${c2.id}" data-level="3" data-parent="${c1.id}" name="permission" lay-skin="primary" title="${c2.name}" type="checkbox" value="${c2.id}">
                                                    </#if>
                                                </td>
                                            </tr>
                                            </#list>
                                        </#list>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="saveTemp">保存</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </fieldset>
        </div>
    </div>
</div>

<script>
    //JavaScript代码区域
    layui.use(['element','form'], function () {
        var element = layui.element;
        var $ = layui.jquery;
        var form = layui.form;

        form.on("checkbox",function(data){
            var id = data.elem.id;
            var level = $("#" + id).attr("data-level");
            var parent = $("#" + id).attr("data-parent");

            // 选中
            if(data.elem.checked){
                layer.msg('选中');
                if(level = 1){
                    $("input[data-level=2][data-parent=" + id + "]").each(function(){
                        $(this).attr("checked","");
                        console.log($(this));
                    })
                } else if(level = 2){

                } else if(level = 3){

                }
            } else {  // 取消
                layer.msg('取消');
            }
        });

    });

</script>
</body>
</html>
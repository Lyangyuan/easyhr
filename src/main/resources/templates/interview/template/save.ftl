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

            <fieldset class="layui-elem-field" style="margin-top: 15px;">
                <#if temp ??>
                    <legend>编辑模板</legend>
                <#else >
                    <legend>添加模板</legend>
                </#if>
                <div class="layui-field-box">
                    <form class="layui-form" action="/interview/template/save" method="post">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">名称</label>
                                <div class="layui-input-inline">
                                    <#if temp ??>
                                        <input value="${temp.id}" name="id" hidden/>
                                        <input value="${temp.name}" name="name" lay-verify="required" autocomplete="off" class="layui-input" type="text">
                                    <#else >
                                        <input name="name" lay-verify="required" autocomplete="off" class="layui-input" type="text">
                                    </#if>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">说明</label>
                            <div class="layui-input-inline">
                                <#if temp ??>
                                    <textarea id="content" placeholder="请输入内容" lay-verify="required" name="comment" class="layui-textarea">${temp.comment}</textarea>
                                <#else >
                                    <textarea id="content" placeholder="请输入内容" lay-verify="required" name="comment" class="layui-textarea"></textarea>
                                </#if>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">内容</label>
                            <div class="layui-input-block">
                            <#if temp ??>
                                <textarea id="myedit" name="content" style="display: none;">${temp.content}</textarea>
                            <#else >
                                <textarea id="myedit" name="content" style="display: none;"></textarea>
                            </#if>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit="" lay-filter="saveTemp">完成</button>
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
    layui.use(['element','layedit','form'], function(){
        var element = layui.element;
        var layedit = layui.layedit;
        var form = layui.form;
        var $ = layui.jquery;

        layedit.set({
            uploadImage: {
                url: '' //接口url
                ,type: '' //默认post
            }
        });

        var editIndex = layedit.build('myedit');

        form.on('switch(switchTest)', function(data){
            layer.tips('温馨提示：关闭此开关后只会保存文本内容，文本格式会丢弃!!!', data.othis)
        });
    });
</script>
</body>
</html>
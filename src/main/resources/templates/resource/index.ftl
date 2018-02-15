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
              <a><cite>资源管理</cite></a>
            </span>

            <div style="width:100%;margin-top:10px;border:solid 1px;">
                <div style="width:100%;height:30px;line-height:30px;padding-left:10px;">
                    <a href="#"><i class="layui-icon">&#xe603;</i></a>
                    <a href="#"><i class="layui-icon">&#xe602;</i></a>
                    <input name="title" type="text" style="width:200px;">
                    <button class="layui-btn layui-btn-normal layui-btn-xs">搜索</button>

                    <button class="layui-btn layui-btn-normal layui-btn-xs">
                        <i class="layui-icon">&#xe681;</i>
                        上传文件
                    </button>
                    <button class="layui-btn layui-btn-normal layui-btn-xs">
                        <i class="layui-icon">&#xe654;</i>
                        新建文件夹
                    </button>
                    <button class="layui-btn layui-btn-normal layui-btn-xs">
                        <i class="layui-icon">&#xe640;</i>
                        删除当前文件
                    </button>
                </div>
                <div style="border-top:solid 1px;width:100%;height:auto;min-height:400px;">
                    <div class="layui-row">
                        <div class="layui-col-xs2" style="border-right:solid 1px;min-height:400px;">
                            <ul id="demo"></ul>
                        </div>
                        <div class="layui-col-xs10">
                            <div class="layui-row">
                                <div class="layui-col-xs2">
                                    <div style="padding:5px;border:solid 1px;text-align:center;">
                                        <img src="/static/img/filetype/ai.gif" style=""/>
                                        <p>head.png</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
<script>
    //JavaScript代码区域
    layui.use(['element','tree'], function () {
        var element = layui.element;

        layui.tree({
          elem: '#demo'
          ,nodes: [ //节点
  {
    name: '常用文件夹'
    ,id: 1
    ,alias: 'changyong'
    ,children: [
      {
        name: '所有未读'
        ,id: 11
        ,href: '#'
        ,alias: 'weidu'
      }, {
        name: '置顶邮件'
        ,id: 12
      }, {
        name: '标签邮件'
        ,id: 13
      }
    ]
  }, {
    name: '我的邮箱'
    ,id: 2
    ,spread: true
    ,children: [
      {
        name: 'QQ邮箱'
        ,id: 21
        ,spread: true
        ,children: [
          {
            name: '收件箱'
            ,id: 211
            ,children: [
              {
                name: '所有未读'
                ,id: 2111
              }, {
                name: '置顶邮件'
                ,id: 2112
              }, {
                name: '标签邮件'
                ,id: 2113
              }
            ]
          }, {
            name: '已发出的邮件'
            ,id: 212
          }, {
            name: '垃圾邮件'
            ,id: 213
          }
        ]
      }, {
        name: '阿里云邮'
        ,id: 22
        ,children: [
          {
            name: '收件箱'
            ,id: 221
          }, {
            name: '已发出的邮件'
            ,id: 222
          }, {
            name: '垃圾邮件'
            ,id: 223
          }
        ]
      }
    ]
  }
]
          ,click: function(node){
            console.log(node) //node即为当前点击的节点数据
          }
        });
    });
</script>
</body>
</html>
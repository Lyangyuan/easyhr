<div class="layui-header">
    <div class="layui-logo">EasyHR 系统</div>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="#">
                <img src="${Request.user.avatar}" class="layui-nav-img">
                ${Request.user.nickname}-${Session.role}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="#">我的信息</a></dd>
                <dd><a href="#">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="/admin/logout">退出</a></li>
    </ul>
</div>
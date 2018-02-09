<div class="navbar" role="navigation">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-actions navbar-left">
            <li class="visible-md visible-lg"><a href="index.html#" id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
            <li class="visible-xs visible-sm"><a href="index.html#" id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>
        </ul>
        <#--搜索框-->
        <form class="navbar-form navbar-left">
            <button type="submit" class="fa fa-search"></button>
            <input type="text" class="form-control" placeholder="暂时不可用"></a>
        </form>
        <#--新消息图标-->
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown visible-md visible-lg">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope-o"></i><span class="badge">5</span></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-menu-header">
                        <strong>消息</strong>
                        <div class="progress thin">
                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                                <span class="sr-only">30% 已读</span>
                            </div>
                        </div>
                    </li>
                    <li class="avatar">
                        <a href="#">
                            <img class="avatar" src="/static/upload/avatar/avatar1.jpg">
                            <div>开会</div>
                            <small>2分钟之前</small>
                            <span class="label label-info">新</span>
                        </a>
                    </li>
                    <li class="avatar">
                        <a href="#">
                            <img class="avatar" src="/static/upload/avatar/avatar4.jpg">
                            <div>已读消息</div>
                            <small>30 分钟之前</small>
                        </a>
                    </li>
                    <li class="dropdown-menu-footer text-center">
                        <a href="#">查看全部消息</a>
                    </li>
                </ul>
            </li>
            <#--提醒图标-->
            <li class="dropdown visible-md visible-lg">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell-o"></i><span class="badge">3</span></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-menu-header">
                        <strong>提醒</strong>
                        <div class="progress thin">
                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                                <span class="sr-only">30% 已处理</span>
                            </div>
                        </div>
                    </li>
                    <li class="clearfix">
                        <i class="fa fa-comment"></i>
                        <span class="notification-action"> 提醒内容 </span>
                        <button type="button" class="btn btn-primary btn-xs">延期</button>
                        <button type="button" class="btn btn-primary btn-xs">关闭</button>
                    </li>
                    <li class="clearfix">
                        <i class="fa fa-comment"></i>
                        <span class="notification-action"> 提醒内容 </span>
                        <button type="button" class="btn btn-primary btn-xs">延期</button>
                        <button type="button" class="btn btn-primary btn-xs">关闭</button>
                    </li>
                    <li class="dropdown-menu-footer text-center">
                        <a href="#">查看全部</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown visible-md visible-lg">
                <a class="dropdown-toggle" href="/account/index"><img class="user-avatar" src="${Session.user_avatar}">${Session.easy_account}-${Session.role}</a>
            </li>
            <li><a href="/admin/logout"><i class="fa fa-power-off"></i></a></li>
        </ul>
    </div>
</div>
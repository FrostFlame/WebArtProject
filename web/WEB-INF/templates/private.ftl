<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script type="application/javascript" src="../../js/jquery-3.1.1.js"></script>
    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="../../css/bootstrap-theme-spacelab.min.css">
    <script type="application/javascript" src="../../js/bootstrap.js"></script>
</head>

<body>
<!-- header -->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <a href="/" class="navbar-brand">Site</a>

        <form class="navbar-form navbar-left" method="get" action="/search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
        </form>
    </div>
</nav>
<!-- /header -->
<div class="content clearfix container-fluid">

    <div class="row">

        <div class="content panel panel-default col-md-9">
            <!-- content -->
            <div class="row info panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">About</h3>
                </div>
                <div class="panel-body">
                    <div class="col-sm-3 col-xs-4 img">
                        <img src=<#--${img}-->alt="" class="img-responsive img-rounded">
                        <a href="/friends?id=1">Friends (<#--${count_friends}-->)</a>
                        <a href="" class="btn btn-default btn-block">Subscribe</a>
                        <a href="" class="btn btn-default btn-block">Send message</a>
                        <a href="" class="btn btn-default btn-block">New challenge</a>
                    </div>
                    <div class="col-xs-8 col-sm-9">
                        <h2><#--${firstname} ${lastname}-->
                            <small><#--${login}--></small>
                        </h2>

                        <dl class="dl-horizontal">
                            <dt>From</dt>
                            <dd><#--${city}, ${country}--></dd>

                            <dt>Date of birth</dt>
                            <dd>Jan 1st, 1970</dd>

                            <dt>Email</dt>
                            <dd><#--${mail}--></dd>

                            <dt>Education</dt>
                            <dd><#--${education}--></dd>

                            <dt>Favorite genres</dt>
                            <dd>
                            <#--<#list genres as g>
                                    ${g}
                                </#list>-->
                            </dd>
                        </dl>
                    </div>
                </div>

            </div>

            <div class="row wall">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Wall
                            <small>(<#--${count_posts}-->)</small>
                        </h3>
                    </div>

                    <div class="panel-body">

                        <#list posts as p>
                            <div class="col-sm-6 col-xs-12 post">
                                <div class="thumbnail">
                                    <img src=${p.src} alt="">

                                    <div class="caption">
                                        <h3><a href="/post?id=34">${p.title}</a></h3>

                                        <p>
                                            <a href="" class="like"><span class="glyphicon glyphicon-heart"></span></a> ${p.likes}
                                            <span class="pull-right">${p.date}</span>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </#list>


                    </div>
                </div>


            </div>
            <!-- /content -->

        </div>
    </div>

    <!-- footer -->
    <div class="clearfix row">
        <p class="text-muted">Copyright (c) 2016</p>
    </div>
    <!-- /footer -->

</div>
</body>

</html>
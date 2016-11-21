<#macro page_head>
<meta charset="utf-8">
<script type="application/javascript" src="../../js/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="../../css/bootstrap.css">
<link rel="stylesheet" href="../../css/bootstrap-theme-spacelab.min.css">
<script type="application/javascript" src="../../js/bootstrap.js"></script>
</#macro>

<#macro content>
<div class="page-heading">
    <h1>Hello world!
        <small>Small subheader</small>
    </h1>
</div>
<p>Lorem ipsum</p>
</#macro>

<#macro body_header>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <a href="/private" class="navbar-brand">WebArtProject</a>


        <#if user??>
            <form class="navbar-form navbar-left" method="get" action="/search">
                <div class="form-group">
                    <input name="search" type="text" class="form-control" placeholder="Search">
                </div>
            </form>


            <!--  For logged in -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/settings"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
                <li><a href="/logout">Logout</a></li>
            </ul>
        </#if>
        <!--  / For logged in -->
    </div>
</nav>
</#macro>

<#macro footer>
<div class="clearfix row">
    <p class="text-muted">Copyright (c) 2016</p>
</div>
</div>
</#macro>

<#macro menu>
    <#if user??>
    <div class="sidebar list-group col-md-3">
        <a class="list-group-item" href="/private">Me</a>
        <a class="list-group-item" href="/feed">Feed</a>
    <#--<a class="list-group-item" href="/notifications">Notifications<span class="badge">-->
    <#--<#if notifications != 0>-->
    <#--${notifications}-->
    <#--</#if>-->
    <#--</span></a>-->
    <#--<a href="/im" class="list-group-item">Messages<span class="badge">-->
    <#--<#if messages != 0>-->
    <#--${messages}-->
    <#--</#if>-->
    <#--</span></a>-->
        <a href="/friends" class="list-group-item">Friends
            <#--<span class="badge">-->
            <#--<#if friends != 0>-->
                <#--${friends}-->
            <#--</#if>-->
        <#--</span>-->
        </a>
    <#--<a href="/battles" class="list-group-item">Challenges<span class="badge">-->
    <#--<#if battles != 0>-->
    <#--${battles}-->
    <#--</#if>-->
    <#--</span></a>-->
    </div>
    </#if>
</#macro>


<#macro display_page>
<!doctype html>
<html>
<head>
    <@page_head/>
</head>
<body>
    <@body_header/>
<div class="content clearfix container">

    <div class="row">
        <@menu/>
        <div class="content panel panel-default col-md-9">
            <@content/>
        </div>
    </div>
    <@footer/>
</div>
</body>
</html>
</#macro>
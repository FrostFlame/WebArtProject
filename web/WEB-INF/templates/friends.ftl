<#include "base.ftl">

<#macro content>
<!-- content -->
<div class="col-md-12">
    <a href="/private" class="btn btn-primary"><span class="glyphicon glyphicon-arrow-left"></span> Back to profile</a>
</div>

<#--<ul class="nav nav-tabs">-->
    <#--<li role="presentation" class="active"><a href="#friends" data-toggle="tab">Friends</a></li>-->
    <#--<li role="presentation"><a href="#subscribers" data-toggle="tab">Subscribers</a></li>-->
    <#--<!-- if owner &ndash;&gt;-->
    <#--<li role="presentation"><a href="#requests" data-toggle="tab">Requests</a></li>-->
    <#--<!-- /if &ndash;&gt;-->
<#--</ul>-->

<#--<div class="tab-content">-->
    <div class="tab-pane active" role="tabpanel" id="friends">
        <h2>Friends</h2>
        <#list friends as f>
            <div class="media friend">
                <div class="media-left">
                    <a href="/private?id=${f.id}">
                    <img src="${f.image.link}" alt="" class="img-rounded" width="128" height="128"></a>
                </div>
                <div class="media-body">
                    <h4>
                        <a href="${f.id}"><span>${f.firstname} ${f.lastname}</span></a>
                    </h4>
                    <!-- if owner -->
                    <form method="post" action="/friends">
                        <input type="hidden" value="${f.id}" name="friend_id">
                        <input type="submit" value="Remove" class="btn btn-danger">
                    </form>
                    <!-- /if -->
                </div>
            </div>
        </#list>

    </div>

    <#--<div class="tab-pane" role="tabpanel" id="subscribers">-->
        <#--<ul class="media-list">-->
            <#--<li class="media subscriber">-->
                <#--<div class="media-left"><a href="#profile4">-->
                    <#--<img src="http://lorempixel.com/64/64/?4" alt="" class="media-object" width="64" height="64"></a>-->
                <#--</div>-->
                <#--<div class="media-body">-->
                    <#--<h4>-->
                        <#--<a href="#profile1"><span>Alice Pen</span></a>-->
                    <#--</h4>-->
                    <#--<!-- if owner &ndash;&gt;-->
                    <#--<form method="post" action="#">-->
                        <#--<input type="submit" value="Remove" class="btn btn-danger">-->
                    <#--</form>-->
                    <#--<!-- /if &ndash;&gt;-->
                <#--</div>-->
            <#--</li>-->
<#---->
            <#--<li class="media subscriber">-->
                <#--<div class="media-left"><a href="#profile5">-->
                    <#--<img src="http://lorempixel.com/64/64/?5" alt="" class="media-object" width="64" height="64"></a>-->
                <#--</div>-->
                <#--<div class="media-body">-->
                    <#--<h4>-->
                        <#--<a href="#profile2"><span>Bob Menace</span></a>-->
                    <#--</h4>-->
                    <#--<!-- if owner &ndash;&gt;-->
                    <#--<form method="post" action="#">-->
                        <#--<input type="submit" value="Remove" class="btn btn-danger">-->
                    <#--</form>-->
                    <#--<!-- /if &ndash;&gt;-->
                <#--</div>-->
            <#--</li>-->
<#---->
            <#--<li class="media subscriber">-->
                <#--<div class="media-left"><a href="#profile6">-->
                    <#--<img src="http://lorempixel.com/64/64/?6" alt="" class="media-object" width="64" height="64"></a>-->
                <#--</div>-->
                <#--<div class="media-body">-->
                    <#--<h4>-->
                        <#--<a href="#profile3"><span>Mikhail Boyarsky</span></a>-->
                    <#--</h4>-->
                    <#--<!-- if owner &ndash;&gt;-->
                    <#--<form method="post" action="#">-->
                        <#--<input type="submit" value="Remove" class="btn btn-danger">-->
                    <#--</form>-->
                    <#--<!-- /if &ndash;&gt;-->
                <#--</div>-->
            <#--</li>-->
<#---->
        <#--</ul>-->
    <#--</div>-->
<#---->
    <#--<!-- if owner &ndash;&gt;-->
    <#--<div class="tab-pane" role="tabpanel" id="requests">-->
        <#--<div class="media request">-->
            <#--<div class="media-left"><a href="#profile7">-->
                <#--<img src="http://lorempixel.com/64/64/?7" alt="" class="media-object" width="64" height="64"></a>-->
            <#--</div>-->
            <#--<div class="media-body">-->
                <#--<div class="col-md-9">-->
                    <#--<h4>-->
                        <#--<a href="#profile1"><span>Mickey Mouse</span></a>-->
                    <#--</h4>-->
<#---->
                    <#--<p>Donec et nunc id risus ultricies aliquet.</p>-->
                <#--</div>-->
                <#--<div class="col-md-3">-->
                    <#--<button class="btn btn-success btn-block to-friends">To friends</button>-->
                    <#--<button class="btn btn-default btn-block to-subscribers">To subscribers</button>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
<#---->
        <#--<div class="media request">-->
            <#--<div class="media-left"><a href="#profile8">-->
                <#--<img src="http://lorempixel.com/64/64/?8" alt="" class="media-object" width="64" height="64"></a>-->
            <#--</div>-->
            <#--<div class="media-body">-->
                <#--<div class="col-md-9">-->
                    <#--<h4>-->
                        <#--<a href="#profile1"><span>Sam Marbles</span></a>-->
                    <#--</h4>-->
<#---->
                    <#--<p>Proin auctor orci sit amet urna euismod, tincidunt mattis justo fringilla.</p>-->
                <#--</div>-->
                <#--<div class="col-md-3">-->
                    <#--<button class="btn btn-success btn-block to-friends">To friends</button>-->
                    <#--<button class="btn btn-default btn-block to-subscribers">To subscribers</button>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
<#---->
        <#--<div class="media request">-->
            <#--<div class="media-left"><a href="#profile9">-->
                <#--<img src="http://lorempixel.com/64/64/?9" alt="" class="media-object" width="64" height="64"></a>-->
            <#--</div>-->
            <#--<div class="media-body">-->
                <#--<div class="col-md-9">-->
                    <#--<h4>-->
                        <#--<a href="#profile1"><span>Andy Warholl</span></a>-->
                    <#--</h4>-->
<#---->
                    <#--<p>Suspendisse sed libero feugiat risus convallis fringilla nec sed urna.</p>-->
                <#--</div>-->
                <#--<div class="col-md-3">-->
                    <#--<button class="btn btn-success btn-block to-friends">To friends</button>-->
                    <#--<button class="btn btn-default btn-block to-subscribers">To subscribers</button>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
<#---->
    <#--</div>-->
    <!-- /if -->

<#--</div>-->
<!-- /content -->
</#macro>

<@display_page/>
<#include "base.ftl">

<#macro content>
<!-- content -->
<div class="row">
    <div class="col-md-12">
        <form action="/feed" method="get" class="form-inline">
            <div class="form-group">
                <label for="feed-oreder">Order</label>
                <select class="form-control" name="order" id="feed-order">
                    <option value="recent">Creating time</option>
                    <option value="titles">Titles</option>
                </select>
            </div>
            <#--<div class="form-group">-->
                <#--<label>-->
                    <#--<input type="checkbox" name="friends_only">-->
                    <#--Friends only-->
                <#--</label>-->
            <#--</div>-->
            <input type="submit" class="btn btn-default" value="Show">
        </form>
    </div>
</div>
<div class="row" id="posts">
    <hr>
    <#list news?keys as l>
        <div class="col-md-12 panel post">
            <div class="row post-heading">
                <a href="/private?id=${l.user.id}">
                    <img src="${l.user.image.link}" class="col-xs-2 col-md-1">
                    <span class="lead">${l.user.firstname} ${l.user.lastname}</span>
                </a> posted <a href="/feed?id=${l.id}" class="lead">${l.title}</a>

                <p class="text-muted">${l.date}</p>
            </div>
            <br>
            <a href="/feed?id=${l.id}">
                <img src="${l.image.link}" alt="" class="img-responsive img-rounded post-img">
            </a>

            <p class="description">
            ${l.text}
            </p>
            <#if tags??>
            <p>Tags: </p>
                <#list tags as t>
                    ${t}
                </#list>
            </#if>
        </div>
    </#list>

</div>
<!-- /content -->
</#macro>

<@display_page/>
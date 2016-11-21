<#include "base.ftl">

<#macro content>
<!-- content -->
<div class="row info panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">About</h3>
    </div>
    <div class="panel-body">
        <div class="col-sm-3 col-xs-4 img">
            <#if image??>
                <img src="${image.link}" alt="" class="img-responsive img-rounded">
            </#if>
            <#if !id??>
                <a href="/friends">Friends (${count_friends})</a>
            </#if>
            <#if id??>
                <#if !fr??>
                    <form method="post" action="/addfriend">
                        <input onclick="f()" type="hidden" name="fr_id" value="${id}">
                        <button id="subscribe" class="btn btn-default btn-block">Subscribe</button>
                    </form>
                </#if>
                <a href="" class="btn btn-default btn-block">Send message</a>
                <a href="" class="btn btn-default btn-block">New challenge</a>
                <script>
                    var f = function () {
                        document.getElementById("subscribe").innerHTML = "";
                    }
                </script>
            </#if>
        </div>
        <div class="col-xs-8 col-sm-9">
            <h2>
            ${user.firstname} ${user.lastname}
            </h2>

            <h2>
                <small>Login: ${user.login}</small>
            </h2>

            <dl class="dl-horizontal">
                <#if (user.city)?has_content>
                    <dt>From</dt>
                    <dd>${user.city}, ${user.country}</dd>
                </#if>

                <dt>Date of birth</dt>
                <dd>${user.birthdate}</dd>

                <#if (user.mail)?has_content>
                    <dt>Email</dt>
                    <dd>${user.mail}</dd>
                </#if>

                <#if (user.skype)?has_content>
                    <dt>Skype</dt>
                    <dd>${user.skype}</dd>
                </#if>

                <#if (user.education)?has_content>
                    <dt>Education</dt>
                    <dd>${user.education}</dd>
                </#if>

                <#if genres?has_content>
                    <dt>Favorite genres</dt>
                    <dd>
                    ${genres}
                    </dd>
                </#if>
            </dl>
        </div>
    </div>

</div>

<div class="row wall">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Wall
                <small>(${count_posts})</small>
            </h3>
            <#if !id??>
                <a type="button" href="/post_creation">Create post</a>
            </#if>
        </div>

        <div class="panel-body">
            <#if news?has_content>
                <#list news?keys as key>
                    <div class="col-sm-6 col-xs-12 post">
                        <div class="thumbnail">
                            <a href="/feed?id=${key.getId()}">
                                <img src="${key.image.link}" alt="">
                            </a>

                            <div class="caption">
                                <p><a href="/feed?id=${key.getId()}">${key.title}</a></p>

                                <p>${key.text}</p>

                                <p>
                                    <span class="pull-right">${key.getDate()}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                </#list>
            <#else>
                <p>You have no posts.</p>
            </#if>
        </div>
    </div>
</div>
<!-- /content -->
</#macro>

<@display_page/>
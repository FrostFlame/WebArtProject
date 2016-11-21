<#include "base.ftl">

<#macro content>
<!-- content -->
<div class="row info panel panel-default">
    <div class="panel-body">
        <div class="col-sm-3 col-xs-4 img">
            <a href="/private?id=${news.user.id}"><img src="${news.user.image.link}" alt="" class="img-responsive img-rounded"></a>
        </div>
        <div class="col-xs-8 col-sm-9">
            <h2>
                <a href="/private?id=${news.user.id}">${news.user.firstname} ${news.user.lastname}</a>
            </h2>

        </div>
    </div>
</div>
<div class="row info panel panel-default">
    <div class="panel-body">
        <h2>
        ${news.title}
        </h2>

        <#--<div class="row">-->
        <img src="${news.image.link}" class="img-rounded img-responsive">

        <#--</div>-->
        <h2>
        ${news.text}
        </h2>

        <dl class="dl-horizontal">
            <#if genres?has_content>
                <dt>Favorite genres</dt>
                <dd>
                    <#list genres as g>
                            ${g}
                        </#list>
                </dd>
            </#if>
        </dl>
    </div>
</div>
<#--<div class="row info panel panel-default">-->
    <#--<div class="panel-body">-->

    <#--</div>-->
<#--</div>-->
<!-- /content -->
</#macro>

<@display_page/>
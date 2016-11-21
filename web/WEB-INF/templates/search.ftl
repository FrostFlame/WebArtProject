<#include "base.ftl">

<#macro content>
<!-- content -->

<div class="tab-content">
    <div class="tab-pane active" role="tabpanel" id="friends">
    <#--<form class="navbar-form navbar-left" method="get" action="">-->
    <#--<div class="form-group">-->
    <#--<input id = "search" onchange="search(this.value)" name="search" type="text" class="form-control" placeholder="Search">-->
    <#--</div>-->
    <#--</form>-->
    <#--<div id="result"></div>-->
    <#--<script>-->
    <#--function search(str) {-->
    <#--var xhttp;-->
    <#--if(str == ""){-->
    <#--document.getElementById("result").innerHTML = "Nobody found"-->
    <#--return;-->
    <#--}-->
    <#--xhttp = new XMLHttpRequest();-->
    <#--xhttp.onreadystatechange = function() {-->
    <#--if (this.readyState == 4 && this.status == 200) {-->
    <#--document.getElementById("result").innerHTML = this.responseText;-->
    <#--}-->
    <#--};-->
    <#--}-->

    <#--        </script>-->

        <#if users??>
            <#list users as u>
                <div class="row info panel panel-default">
                    <div class="panel">
                        <div class="col-sm-3 col-xs-4 img">
                            <a href="/private?id=${u.id}"><img src="${u.image.link}" alt="" class="img-responsive img-rounded"></a>
                        </div>
                        <div class="col-xs-8 col-sm-9">
                            <h2>
                                <a href="/private?id=${u.id}">${u.firstname} ${u.lastname}</a>
                            </h2>

                        </div>
                    </div>
                </div>
            </#list>
        <#else>
            <p>Nobody found</p>
        </#if>
    </div>
    <!-- /if -->

</div>
<!-- /content -->
</#macro>

<@display_page/>
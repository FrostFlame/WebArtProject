<#include "base.ftl">

<#macro content>
<!-- content -->
    <#if !columns??>
    <h1>Tables from DataBase</h1>
    <ul>
        <#list tables as t>
            <a href="/admin?table=${t}">
                <li>${t}</li>
            </a>
        </#list>
    </ul>
    <#else>
    <div class="panel panel-default" style="overflow: auto">
        <table class="table">
            <thead>
            <tr>
                <#list columns as c>
                    <th>${c}</th>
                </#list>
            </tr>
            </thead>
            <tbody>
                <#list objects as o>
                <tr>
                    <#list columns as c>
                        <#if o[c]?is_boolean>
                            <td>${o[c]?c}</td>
                        <#elseif o[c]?is_string || o[c]?is_date>
                            <td>${o[c]}</td>
                        <#elseif o[c]?is_nan>
                            <td></td>
                        <#else>
                            <td>${o[c]}</td>
                        </#if>
                    </#list>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
    </#if>
<!-- /content -->
</#macro>

<@display_page/>
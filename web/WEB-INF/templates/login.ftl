<#include "base.ftl">

<#macro content>
            <!-- content -->
            <div class="page-heading">
                <h1>Login</h1>
            </div>
            <#if err?has_content>
                <div class="alert alert-danger" role="alert">
                    <strong>Error: </strong>${err}
                </div>
            </#if>
            <form method="post" action="/login" class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-2"><label for="username">Username</label></div>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="username" placeholder="Login" value=${log}>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="password">Password</label></div>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" placeholder="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="remember"> Remember me
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default" name="send">Send</button>
                    </div>
                </div>
            </form>
            <p>
                <a href="/registration">Registration</a>
            </p>
            <!-- /content -->
</#macro>

<@display_page/>
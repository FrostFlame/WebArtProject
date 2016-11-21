<#include "base.ftl">

<#macro content>
            <!-- content -->
            <div class="page-heading">
                <h1>Registration</h1>
            </div>
            <#if err?has_content>
                <div class="alert alert-danger" role="alert">
                    <strong>Error: </strong>${err}
                </div>
            </#if>
            <form method="post" action="/registration" class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-2"><label for="username">Username</label></div>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="username" placeholder="Login" value=${log}>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="password">Password</label></div>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="password">Repeat password</label></div>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="repeat-password"
                               placeholder="Repeat password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="password">Name</label></div>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="first_name" placeholder="First Name" value=${first_name}>
                    </div>
                    <div class="col-sm-5"><input type="text" class="form-control" name="last_name"
                                                 placeholder="Last Name" value=${last_name}>
                    </div>
                </div>


                    <div class="form-group">
                        <div class="col-sm-2"><label for="inputDate">Birthdate:</label></div>
                        <div class="col-sm-5"><input type="date" class="form-control" name="birthdate" value=${birthdate}></div>
                    </div>



                <p>Unnecessary fields:</p>

                <div class="form-group">
                    <div class="col-sm-2"><label for="email">E-mail</label></div>
                    <div class="col-sm-10"><input type="email" class="form-control" name="email" value=${email}></div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="city">Country</label></div>
                    <div class="col-sm-10"><input type="text" class="form-control" name="country" value=${country}></div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="city">City</label></div>
                    <div class="col-sm-10"><input type="text" class="form-control" name="city" value=${city}></div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="skype">Skype</label></div>
                    <div class="col-sm-10"><input type="text" class="form-control" name="skype" value=${skype}></div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="skype">Education</label></div>
                    <div class="col-sm-10"><input type="text" class="form-control" name="education" value=${education}></div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="genres">Favorite genres</label></div>
                    <div class="col-sm-10"><input type="text" class="form-control" name="genres"
                                                  placeholder="cats, funny..." value=${genres}>
                        <span class="help-block">List your favorite genres, separated by comma</span>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-2">
                        <button type="submit" class="btn btn-default" name="send">Register!</button>
                    </div>
                    <div class="col-sm-2">
                        <a href="/login" class="btn btn-default">Login</a>
                    </div>
                </div>

            </form>
            <!-- /content -->
</#macro>

<@display_page/>
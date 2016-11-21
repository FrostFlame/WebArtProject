<#include "base.ftl">


<#macro content>
<!-- content -->
<#--<ul class="nav nav-pills">-->
    <#--<li role="presentation" class="active"><a href="#settings" data-toggle="tab">Settings</a></li>-->
    <#--<li role="presentation"><a href="#blacklist" data-toggle="tab">Black list</a></li>-->
<#--</ul>-->
<#---->
<#--<div class="tab-content">-->
    <div role="tabpanel" class="tab-pane active" id="settings">
        <div>
            <form action="/settings" method="post" class="form-horizontal" enctype="multipart/form-data">
                <#if err?has_content>
                    <div class="alert alert-danger" role="alert">
                        <strong>Error: </strong>${err}
                    </div>
                </#if>
                <h3>Basic Settings</h3>

                <div class="form-group">
                    <label for="post-file" class="col-xs-3">Avatar</label>

                    <div class="col-xs-9"><input type="file" class="form-control" name="file" id="post-file"></div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-xs-3">Name</label>

                    <div class="col-xs-4"><input type="text" class="form-control" name="firstname" id="firstname"
                                                 placeholder="${user.firstname}" value="${firstname}"></div>
                    <div class="col-xs-5"><input type="text" class="form-control" name="lastname" id="lastname"
                                                 placeholder="${user.lastname}">${lastname}</div>
                </div>
                <div class="form-group">
                    <label for="password_current" class="col-xs-3">Current password</label>

                    <div class="col-xs-9"><input type="password" class="form-control" name="password_current"></div>
                </div>
                <div class="form-group">
                    <label for="password_new1" class="col-xs-3">New password</label>

                    <div class="col-xs-9"><input type="password" class="form-control" name="password_new1"></div>
                </div>
                <div class="form-group">
                    <label for="password_new2" class="col-xs-3">Repeat new password</label>

                    <div class="col-xs-9"><input type="password" class="form-control" name="password_new2"></div>
                </div>
                <div class="form-group">
                    <label for="mail" class="col-xs-3">Email</label>

                    <div class="col-xs-9"><input type="text" class="form-control" name="mail" placeholder="${user.mail}"
                                                 value="${mail}"></div>
                </div>
                <div class="form-group">
                    <label for="country" class="col-xs-3">Country</label>

                    <div class="col-xs-9"><input type="text" class="form-control" name="country"
                                                 placeholder="${user.country}" value="${country}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="city" class="col-xs-3">City</label>

                    <div class="col-xs-9"><input type="text" class="form-control" name="city" placeholder="${user.city}"
                                                 value="${city}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="education" class="col-xs-3">Education</label>

                    <div class="col-xs-9"><input type="text" class="form-control" name="education"
                                                 placeholder="${user.education}" value="${education}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="skype" class="col-xs-3">Skype</label>

                    <div class="col-xs-9"><input type="text" class="form-control" name="skype"
                                                 placeholder="${user.skype}" value="${skype}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="disable_notifications" class="col-xs-3">Disable notifications</label>

                    <div class="col-xs-9"><input type="checkbox" class="input-lg" name="disable_notifications"></div>
                </div>

                <h3>Privacy settings</h3>

                <div class="form-group">
                    <label for="add_friends" class="col-xs-4">Who can <strong>add you to friend list</strong></label>

                    <div class="col-xs-8">
                        <select name="add_friends" id="" class="form-control">
                            <option value="Anyone">Anyone</option>
                            <option value="Friends of your friends">Friends of your friends</option>
                            <option value="No one">No one</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="watch_pics" class="col-xs-4">Who can <strong>look at your works</strong></label>

                    <div class="col-xs-8"><select name="watch_pics" id="" class="form-control">
                        <option value="Anyone">Anyone</option>
                        <option value="Friends and their friends">Friends and their friends</option>
                        <option value="Friends">Friends</option>
                        <option value="No one">No one</option>
                    </select></div>
                </div>
                <div class="form-group">
                    <label for="send_messages" class="col-xs-4">Who can <strong>write messages to you</strong></label>

                    <div class="col-xs-8"><select name="send_messages" id="" class="form-control">
                        <option value="Anyone">Anyone</option>
                        <option value="Friends and their friends">Friends and their friends</option>
                        <option value="Friends">Friends</option>
                        <option value="No one">No one</option>
                    </select></div>
                </div>
                <input class="btn btn-primary btn-lg" type="submit" value="Save changes">
            </form>
        </div>
    </div>
    <#--<div role="tabpanel" class="tab-pane" id="blacklist">-->
        <#--<h3>Black list</h3>-->
<#---->
        <#--<p>-->
            <#--Blacklisted users cannot write you messages or view your profile.-->
        <#--</p>-->
        <#--<ul id="blacklist-ul" class="media-list">-->
            <#--<#list blacklist as g>-->
                <#--<li class="media"><a href="">-->
                    <#--<div class="col-xs-2"><img src="${g.image.link}" alt="" class="img-responsive"></div>-->
                    <#--<div class="col-xs-10">-->
                        <#--<h4 class="media-heading">${g.firstname} ${g.lastname}</h4>-->
<#---->
                        <#--<form method="post" action=""-->
                        <#--<button class="btn btn-primary bl-remove" onclick="f()">Delete from BL</button>-->
<#---->
                        <#--<script type="application/javascript">-->
                            <#--function f() {-->
                                <#--$.ajax({-->
                                    <#--'url': '/blacklist',-->
                                    <#--'data': {-->
                                        <#--'q': $(g).id-->
                                    <#--},-->
                                    <#--'method': 'post'-->
                                <#--});-->
                            <#--}-->
<#--//                        </script>-->
                    <#--</div>-->
                <#--</a></li>-->
            <#--</#list>-->
        <#--</ul>-->
    <#--</div>-->
<#--</div>-->
<!-- /content -->
</#macro>

<@display_page/>
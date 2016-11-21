<#include "base.ftl">

<#macro content>
<!-- content -->

<div class="page-heading">
    <h1>New post</h1>
</div>
<div class="row">
    <div class="col-sm-8">
        <form action="/post_creation" class="form-horizontal" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="post-title" class="col-sm-4 control-label">Title</label>
                <div class="col-sm-8"><input type="text" class="form-control" name="title" id="post-title" value="${title}"></div>
            </div>
            <div class="form-group">
                <label for="post-file" class="col-sm-4 control-label">File</label>
                <div class="col-sm-8"><input type="file" class="form-control" name="file" id="post-file"></div>
            </div>
            <div class="form-group">
                <label for="post-text" class="col-sm-4 control-label">Text</label>
                <div class="col-sm-8"><textarea type="text" class="form-control" name="text" id="post-text">${text}</textarea></div>
            </div>
            <div class="form-group">
                <label for="" class="col-sm-4 control-label">Tags</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" placeholder="cats, funny" name="tags" value="${tags}">
                    <span class="help-block">Provide one or more tags, separated by comma</span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4">
                    <input type="submit" class="btn btn-primary" value="Post this">
                </div>
            </div>
        </form>
    </div>
</div>
<!-- /content -->
</#macro>

<@display_page/>
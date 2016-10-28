<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <script type="application/javascript" src="../../js/jquery-3.1.1.js"></script>
        <link rel="stylesheet" href="../../css/bootstrap.css">
        <link rel="stylesheet" href="../../css/bootstrap-theme-spacelab.min.css">
        <script type="application/javascript" src="../../js/bootstrap.js"></script>
    </head>
    
    <body>
       <!-- header -->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <a href="/" class="navbar-brand">Site</a>
                <form class="navbar-form navbar-left" method="get" action="/search">
                <div class="form-group">
                  <input type="text" class="form-control" placeholder="Search">
                </div>
                </form>                
            </div>
        </nav>
        <!-- /header -->
        <div class="content clearfix container-fluid">
        
        <div class="row">

        <div class="content panel panel-default col-md-9">
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
        </div>
            </div>
        
        <!-- footer -->
        <div class="clearfix row">
            <p class="text-muted">Copyright (c) 2016</p>
        </div>
        <!-- /footer -->

        </div>
    </body>
    
</html>
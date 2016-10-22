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
                <h1>Registration</h1>
            </div>
            <div class="alert alert-danger" role="alert">
                <strong>Error: </strong>username already taken
            </div>
            <form method="post" action="/registration" class="form-horizontal">
                <div class="form-group">
                  <div class="col-sm-2"><label for="username">Username</label></div>
                   <div class="col-sm-10">
                       <input type="text" class="form-control" name="username" value=${log}>
                   </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-2"><label for="password">Password</label></div>
                   <div class="col-sm-10">
                       <input type="password" class="form-control" name="password">
                   </div>
                </div><div class="form-group">
                  <div class="col-sm-2"><label for="password">Repeat password</label></div>
                   <div class="col-sm-10">
                       <input type="password" class="form-control" name="repeat-password">
                   </div>
                </div>
                  <div class="form-group">
                    <div class="col-sm-2"><label for="password">Name</label></div>

                  <div class="col-sm-5">                       
                        <input type="text" class="form-control" name="first_name" placeholder="First Name">

                      </div>
                      <div class="col-sm-5"><input type="text" class="form-control" name="last_name" placeholder="Last Name">

                  </div>
                  </div>
                
                <p>Unnecessary fields:</p>
                <div class="form-group">
                    <div class="col-sm-2"><label for="email">E-mail</label></div>
                    <div class="col-sm-10"><input type="email" class="form-control" name="email"></div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="city">City</label></div>
                    <div class="col-sm-10"><input type="text" class="form-control" name="city"></div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="skype">Skype</label></div>
                    <div class="col-sm-10"><input type="text" class="form-control" name="skype"></div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"><label for="genres">Favorite genres</label></div>
                    <div class="col-sm-10"><input type="text" class="form-control" name="genres" placeholder="cats, funny...">
                    <span class="help-block">List your favorite genres, separated by comma</span>
                    </div>
                </div>
                
                <div class="form-group">
                   <div class="col-sm-offset-2 col-sm-10">
                       <button type="submit" class="btn btn-default" name="send">Register!</button>
                    </div>
                </div>

            </form>
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
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>欢迎来到绿意！请登录</title>
	<link rel="SHORTCUT ICON" href="image/PlLogo.ico">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/index.css" rel="stylesheet">
	<link href="css/sign_up.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/sign_up.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	
</head>
<body>
<!-- 顶部导航 -->
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="menu-nav">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/zhiwu_bbs">绿意植物论坛</a>
        </div>
        
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-left">
                <li class=""><a href="index">主页</a></li>
                <li><a href="zhitie">植帖</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">百科 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a target="_blank" href="https://baike.baidu.com/item/%E6%9C%88%E5%AD%A3%E8%8A%B1/14505544?fr=aladdin&fromid=32865&fromtitle=%E6%9C%88%E5%AD%A3" data-tab="tab-yj">月季</a></li>
                        <li><a target="_blank" href="https://baike.baidu.com/item/%E5%BA%B7%E4%B9%83%E9%A6%A8/34029?fr=aladdin" data-tab="tab-knx">康乃馨</a></li>
                        <li><a target="_blank" href="https://baike.baidu.com/item/%E6%BB%A1%E5%A4%A9%E6%98%9F/18819" data-tab="tab-mtx">满天星</a></li>
                        <li><a target="_blank" href="https://baike.baidu.com/item/%E7%8E%AB%E7%91%B0/63206" data-tab="tab-mg">玫瑰</a></li>
                    </ul>
                </li>
                <li><a href="#" data-toggle="modal" data-target="#about-modal">关于</a></li>
            </ul>
            <div class="navbar-form navbar-right">
            	<a type="button" class="btn btn-link" href="sign_in"><span class="glyphicon glyphicon-log-in"></span><b>登录</b></a>
       		</div>
        </div>
    </div>
</div>

<div class="htmleaf-container">
		<div class="demo form-bg" style="padding: 20px 0;">
		        <div class="container">
		            <div class="row">
		                <div class="col-md-offset-3 col-md-6">
		                    <form class="form-horizontal" method="post">
		                        <span class="heading">注册用户</span>
		                        <div class="form-group">
		                            <input type="text" class="form-control" autocomplete="off"  
		                            name="userId" id="username" placeholder="用户名">
		                            <i class="fa fa-user"></i>
		                        </div>
		                        <div class="form-group help">
		                            <input type="password" class="form-control" autocomplete="off"  
		                            name="userPass1" placeholder="密　码" id="password">
		                            <i class="fa fa-lock"></i>
		                        </div>
		                        <div class="form-group help">
		                            <input type="password" class="form-control" autocomplete="off" onblur="check()"  
		                            name="userPass2" placeholder="请再次确认密码" id="password_check">
		                            <i class="fa fa-lock"></i>
		                        </div>
		                        <div class="form-group">
		                            
		                            <span id="warning" class="text">${msg}</span>
		                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		                            <a href="sign_in" class="text">有了账号？立即登录</a> 
		                            <button type="submit" class="btn btn-default">注册</button>
		                        </div>
		                    </form>
		                    
		                </div>
		            </div>
		        </div>
		    </div>
</div>


<!-- 关于 -->
    <div class="modal fade" id="about-modal" tabindex="-1" role="dialog" aria-labelledby="modal-label"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                    <h4 class="modal-title" id="modal-label">关于</h4>
                </div>
                <div class="modal-body">
                    <p>绿意论坛</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">了解了</button>
                </div>
            </div>
        </div>
    </div>

<!-- 尾部 -->
	<footer>
	        <p>Copyright &copy; 2020 绿意 </p>
	</footer>
<script type="text/javascript">
</script>
</body>
</html>
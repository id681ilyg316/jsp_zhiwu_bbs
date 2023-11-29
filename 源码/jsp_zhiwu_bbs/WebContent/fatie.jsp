<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布植帖</title>
	<link rel="SHORTCUT ICON" href="image/PlLogo.ico">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/index.css" rel="stylesheet">
	<link href="css/fatie.css" rel="stylesheet">
	<link href="css/img.css" rel="stylesheet">
	<%
	String dp1,dp2;
	if( request.getSession().getAttribute("user")!=""&& request.getSession().getAttribute("user")!=null)
	{
		dp1="none";
		dp2="";
		System.out.println("代码执行了");
		System.out.println((String)request.getSession().getAttribute("user")); 
	}
	else 
	{
		dp1 = "";
		dp2 = "none";
	}
%>
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
                <li><a href="index">主页</a></li>
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
            <div class="navbar-form">
			<form action="zhitie" class="input-group" style="margin-left:200px;margin-top:0px positon:relative;width:300px">  
			       <input type="text" name="content" class="form-control" placeholder="请输入字段名" />  
			            <span class="input-group-btn">  
			               <button type="submit" class="btn btn-info btn-search">查找</button>  
			            </span>  
			</form> 
            <div style="display:<%=dp1%>" class="navbar-right">
            	<a  type="button" class="btn btn-link" href="sign_in"><span class="glyphicon glyphicon-log-in"></span><b>登录</b></a>
            	<a  type="button" class="btn btn-link" href="sign_up"><span class="glyphicon glyphicon-user"></span><b>注册</b></a>
       		</div >
       		<div class="dropdown navbar-form navbar-right" style="display:<%=dp2%>">
                <div class="read_img">
                    <img class="img-circle" src=<%=(String)request.getSession().getAttribute("img") %>>
                    <a id="name" type="button" class="dropdown-toggle" data-toggle="dropdown"><%=(String)request.getSession().getAttribute("user")%><span class="caret"></span></a>
                	<ul class="dropdown-menu" role="menu">
                        <li><a href="self" data-tab="tab-yj">个人中心</a></li>
                        <li><a href="fatie" data-tab="tab-yj">发布植帖</a></li>
                        <li class="divider"></li>
                        <li><a href="sign_out" data-tab="tab-knx">退出登录</a></li>
                	</ul>
                </div>
            </div>
      	 	</div>	
        </div>
    </div>
</div>
<div class="container" style="margin-top:70px;">
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column well well-lg">
			<form class="form-horizontal" role="form" method="post">
				<div class="form-group">
					 <label class="col-sm-2 control-label" style="font-size:30px;">标题</label>
					<div class="col-sm-10" style="padding-top:15px;">
						<input maxlength="50" name="ztTitle" autofocus type="text" class="form-control" placeholder="请输入标题"/>
					</div>
				</div>
				<div class="form-group" style="padding-top:15px;">
					 <label class="col-sm-2 control-label" style="font-size:30px;">内容</label>
					<div class="col-sm-10">
					<textarea maxlength="700" name="ztContent" rows="20" cols="" class="form-control" style="font-size:20px;" placeholder="请输入内容"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default" style="font-size:20px;">发布</button><p>${msg }</p>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-2 column">
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
</body>
</html>
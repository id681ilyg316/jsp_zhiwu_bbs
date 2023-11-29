<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="bean.ZhitieBean"%>
    <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
	<link rel="SHORTCUT ICON" href="image/PlLogo.ico">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/index.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
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
<%
      ZhitieBean zhitie = (ZhitieBean)request.getAttribute("zhitiebean");
	  int i = 1;
 %>
 
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

<!-- 植帖区 -->
<div class="container" style="margin-top:70px;">
	<div class="row clearfix">
		<div class="col-md-12 column" style="height:100%;">
			<div class="page-header">
				<div class="author">
					<div class="name">
						<a><img class="img-circle" src=<%=zhitie.getUser_img() %> ></a>
						<a href="zhitie?user_id=<%=zhitie.getUser_id() %>"><%=zhitie.getUser_id()%></a><span class="time">&nbsp;&nbsp;&nbsp;<%=zhitie.getZt_time()%></span>
					</div>
				</div>
				<h1>
					<%=zhitie.getZt_title()%>
				</h1>
			</div>
			<p class="text-left" style="font-size:30px;">
				<%=zhitie.getZt_content()%>
			</p>
		</div>
		<hr/>
	</div>
</div>
<!-- 评论展示区 -->
<div class="container" style="margin-top:70px;">
<div class="col-md-12 column">
	<!-- 循环遍历评论 -->
	<c:forEach items="${hflist}" var="hfMap">
		<div class="page-header" style="font-size:15px;">
			<div class="author">
					<div class="name">
						<a><img class="img-circle" src=${hfMap.user_img} ></a>
						<a href="zhitie?user_id=${hfMap.user_id}">${hfMap.user_id}</a><span class="time">&nbsp;&nbsp;&nbsp;${hfMap.hf_time}</span>
						<span style="float:right"><%=i++ %>楼</span>
					</div>
					<p>${hfMap.hf_content}</p>
			</div>
		</div>
	</c:forEach>
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
<!-- 评论区 -->
<div class="container" style="margin-top:70px;">
<div class="col-md-12 column">
	<form class="form-horizontal" role="form" method="post">
		<textarea maxlength="200" name="hfContent" placeholder="在此输入评论，评论内容不能为空" style="font-size:30px;height:100%;width:100%;"></textarea>
		<button type="submit" class="btn btn-default" style="float:right">评论</button>
	</form>
</div>
</div>
</body>
</html>
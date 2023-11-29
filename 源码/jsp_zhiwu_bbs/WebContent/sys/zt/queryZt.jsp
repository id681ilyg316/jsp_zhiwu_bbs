<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>植帖查询</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="sys/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="sys/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="sys/Css/style.css" />
    <script type="text/javascript" src="sys/Js/jquery.js"></script>
    <script type="text/javascript" src="sys/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="sys/Js/bootstrap.js"></script>
    <script type="text/javascript" src="sys/Js/ckform.js"></script>
    <script type="text/javascript" src="sys/Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="queryZt" method="post">
   
          查询:<select name="position">
                <option value="0">---- 查询条件 ----</option>
                <option value="1">植帖标题</option>
                 <option value="2">用户名</option>
            </select>&nbsp;&nbsp;
     <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="${message}"> 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10" style="margin-top:50px;">
    <thead>
    <tr>
        <th>植帖主题</th>
        <th>植帖标题</th>
        <th>发帖人</th>
        <th>评论数</th>
        <th>发帖时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <!-- 循环显示数据库开始 -->
    <c:forEach items="${rslist}" var="ztMap">
        <tr>
                <td>${ztMap.zt_theme}</td>
                <td><a target="_blank" href="this?zt_id=${ztMap.zt_id}">${ztMap.zt_title}</a></td>
                <td><img class="img-circle" style="height:30px;width:30px;" src=${ztMap.user_img}></img>&nbsp;<a href="queryZt?user_id=${ztMap.user_id}">${ztMap.user_id}</a>
                </td>             
                <td><a target="_blank" href="this?zt_id=${ztMap.zt_id}">${ztMap.zt_hfl}</a></td>
                <td>${ztMap.zt_time}</td>
                <td><a href="mgZt?zt_id=${ztMap.zt_id}">删除</a>
                </td>
            </tr>
            </c:forEach>
     <!-- 循环显示数据库结束 -->
</table>
</body>
</html>

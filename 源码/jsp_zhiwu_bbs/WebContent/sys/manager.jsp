<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>绿意管理系统</title>
    <link rel="SHORTCUT ICON" href="image/PlLogo.ico">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="sys/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="sys/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="sys/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user"><%=(String)request.getSession().getAttribute("user")%></span><a href="sign_out" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">论坛管理</div></li>		

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="sys/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="sys/assets/js/bui-min.js"></script>
<script type="text/javascript" src="sys/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="sys/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = 
        [{id:'1',menu:
            [{text:'用户信息信息',items:
                [{id:'1',text:'用户查询',href:'queryUser'}]
            },{text:'植帖信息',items:
                [{id:'2',text:'植帖管理',href:'queryZt'}]
            },{text:'评论信息',items:
                [{id:'3',text:'评论管理',href:'queryPl'}]
            }]
        }];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>
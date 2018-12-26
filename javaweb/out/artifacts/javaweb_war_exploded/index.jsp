<%--
  Created by IntelliJ IDEA.
  User: lychs
  Date: 2018/9/20 0014
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon" href="favicon.ico" >
  <title>浙江省涉毒案件检索系统—Java2018大作业</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/echarts.min.js"></script>
  <script src="js/zhejiang.js"></script>
  <script type="text/javascript">
      $(window).load(function(){
          $.get("init", function(data){eval(data);});
          $.get("as",function (data) {eval(data);});
      });
  </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation"  style="background-color:#ffffff">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse"
              data-target="#example-navbar-collapse">
        <span class="sr-only"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><img src="images/logo.png" style="height:100%;"/></a>
    </div>
    <div class="collapse navbar-collapse" id="example-navbar-collapse">
      <ul class="nav navbar-nav">
        <li><a href="https://github.com/lychs1998" target="_blank">Github</a></li>
      </ul>
        <div>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" id="ques">
                </div>
                <button type="button" class="btn btn-default" id="do">查询</button>
            </form>
        </div>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="col-md-12">
      <h3 style="text-align:center">浙江省涉毒案件分析系统</h3><hr style="width:35%">
      <h4 style="text-align:center"><small>学习样例，仅供参考</small></h4>
    </div>
    <div class="col-md-12"><hr></div>
    <div class="col-md-4">
      <div class="panel panel-default">
        <div class="panel-body" style="overflow:hidden">
          <div style="width:100%;height:500px" id="main"></div>
        </div>
      </div>
    </div>
    <div class="col-md-8">
      <div class="panel panel-default">
        <div class="panel-body" style="overflow:hidden">
          <div style="width:100%;height:500px" id="main2">
          </div>
        </div>
      </div>
    </div>
      <div class="col-md-12">
          <div class="panel panel-default">
              <div class="panel-body" style="overflow:hidden">
                  <div style="width:100%;height:500px" id="main1"></div>
              </div>
          </div>
      </div>
    <div class="col-md-12" style="height:20px"></div>
  </div>
</div>
<footer class="navbar-fixed-bottom" style="text-align:center">
    CopyRight © chs | 浙ICP备17046117号
</footer>
</body>
</html>
<script>
    function dopost(){
        var ques=$("#ques").val();
        if(ques.length==0){
            alert("请输入查询内容");
            return;
        }
        $.post("do",{name:ques}, function(data) {
            eval(data);
        });
    }
    $("#do").click(function(){
        dopost();
    });
</script>
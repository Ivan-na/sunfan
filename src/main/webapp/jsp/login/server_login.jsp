<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%    
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
pageContext.setAttribute("basePath",basePath);    
%>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Monitor</title>
  </head>
  
<script language="javascript" type="text/javascript" src="${pageScope.basePath}/resource/js/flot/jquery.js"></script>
  <body>
    <div>
    <form id="form1" action="" >
            <input type="text" name="url" id="url"><br>
            <input type="text" name="username" id="username"><br>
            <input type="text" name="password" id="password"><br>
            <input type="button" value="submit" id="but1">
    </form>
    </div>
   <script type="text/javascript">
    $('#but1').click(function(){
    $('#form1').attr({'action':"${pageScope.basePath}serverLogin",'method':"post"}).submit();
    });
    </script>
</html>
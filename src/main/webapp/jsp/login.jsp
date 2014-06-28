<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%    //获取绝对路径
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
pageContext.setAttribute("basePath",basePath);    
%>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
  </head>
  <body>
    <div>
    
        <form action="${pageScope.basePath}greeting" method="get">//ACTION指向绝对路径的地址
            <input type="text" name="username">
            <input type="submit" value="SUBMIT">
        </form>
    </div>
</html>
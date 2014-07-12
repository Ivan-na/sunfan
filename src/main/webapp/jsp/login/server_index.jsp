<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%    
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
pageContext.setAttribute("basePath",basePath);    
%>    

<html>
  <head>
    <title>welcome</title>
  </head>
  
<script language="javascript" type="text/javascript" src="${pageScope.basePath}js/flot/jquery.js"></script>
  <body>
  hello,${sessionScope.sUser.username}!
  <br>
  <br>
  <br>
  <a href=${pageScope.basePath}jsp/monitor/cpu_monitor.jsp target="view_window">cpu monitor</a>
  <a href=${pageScope.basePath}jsp/monitor/io_monitor.jsp target="view_window">io monitor</a>
  <a href=${pageScope.basePath}jsp/monitor/memory_monitor.jsp target="view_window">memory monitor</a>
  </body>
   <script type="text/javascript">
    
    </script>
</html>
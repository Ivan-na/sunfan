<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%    
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;    
pageContext.setAttribute("basePath",basePath);    
%>    

<html>
  <head>
    <title>error</title>
  </head>
  
<script language="javascript" type="text/javascript" src="${pageScope.basePath}/resource/js/flot/jquery.js"></script>
  <body>
  error info : ${error}
  <br>
  please check your request!
  <br>
  <br>
  </body>
   <script type="text/javascript">
    
    </script>
</html>
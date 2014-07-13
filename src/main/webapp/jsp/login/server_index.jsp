<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%    
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
pageContext.setAttribute("basePath",basePath);    
%>    

<html>
  <head>
    <title>monitors util</title>
  </head>
          <link href="${pageScope.basePath}js/flot/examples/examples.css" rel="stylesheet" type="text/css">
          <script language="javascript" type="text/javascript" src="${pageScope.basePath}js/flot/jquery.js"></script>
  <body id="content">
  <h2>Hello,${sessionScope.sUser.username}.</h2>
  <br><br><br>

   <h3>CPU</h3>
   <ul>
   <li><a href=${pageScope.basePath}jsp/monitor/cpu_monitor.jsp target="_blank">total utilization</a> -->percentage of CPU utilization(sys%+usr%)</li>
   </ul>
   
   <h3>IO</h3>
   <ul>
   <li> <a href=${pageScope.basePath}jsp/monitor/io_monitor.jsp target="_blank">TPS</a>-->"transfer per second" that were issued to the device(TPS)</li>
   </ul>
   
   <h3>Memory</h3>
   <ul>
   <li> <a href=${pageScope.basePath}jsp/monitor/memory_monitor.jsp target="_blank">memory used</a>-->amount of memory was used(MB)</li>
   </ul>
     <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
	<div id="footer">
		Copyright &copy; 2007 - 2014 travelsky sunfan
	</div>
  </body>
  <script type="text/javascript">
   alert($.session('sUser'));
  </script>
</html>
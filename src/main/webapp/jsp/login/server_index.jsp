<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%    
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;    
pageContext.setAttribute("basePath",basePath);    
%>    

<html>
  <head>
    <title>monitors util</title>
  </head>
          <link href="${pageScope.basePath}/resource/js/flot/examples/examples.css" rel="stylesheet" type="text/css">
          <script language="javascript" type="text/javascript" src="${pageScope.basePath}/resource/js/flot/jquery.js"></script>
  <body id="content">
  <h2>Hello,${sessionScope.sUser.username}.</h2>
  <br><br><br>
   
   
   <h3>CPU</h3>
   <ul>
   <li><a href=${pageScope.basePath}/total_utilization target="_blank">总体使用率</a>--> percentage of CPU utilization(sys%+usr%)</li>
    <li><a href=${pageScope.basePath}/io_wait target="_blank">等待磁盘时间</a>-->  Show  the percentage of time that the CPU or CPUs were idle during which the system had an outstanding disk I/O request.</li>
   </ul>
   
   <h3>IO</h3>
   <ul>
   <li> <a href=${pageScope.basePath}/tps target="_blank">每秒磁盘处理的事务</a>--> transfer per second" that were issued to the device(TPS)</li>
   <li> <a href=${pageScope.basePath}/blk_wrtn_s target="_blank">磁盘每秒写入的扇区量（1个扇区=512bytes）</a>--> Indicate the amount of data write from the all device
                     expressed in a number of blocks per second.</li>
   <li> <a href=${pageScope.basePath}/blk_read_s target="_blank">磁盘每秒读取的扇区量（1个扇区=512bytes</a>--> Indicate the amount of data read from the all device
                     expressed in a number of blocks per second.</li>
   <li> <a href=${pageScope.basePath}/total_util target="_blank">磁盘操作的CPU占有率</a>-->Percentage  of  CPU  time  during  which  I/O  requests were issued to the device (bandwidth utilization for the
                     device). Device saturation occurs when this value is close to 100%.</li>
    <li> <a href=${pageScope.basePath}/connections target="_blank">9080端口的连接数</a></li>
<!--    <li> <a href=${pageScope.basePath}/blk_wrtn target="_blank">写入磁盘的总量</a></li> -->
<!--    <li> <a href=${pageScope.basePath}/blk_read target="_blank">读取磁盘的总量</a></li> -->
   </ul>
   
   <h3>Memory</h3>
   <ul>
   <li> <a href=${pageScope.basePath}/mem_used target="_blank">已使用的内存</a>-->amount of memory was used(MB)</li>
   <li> <a href=${pageScope.basePath}/mem_free target="_blank">空闲的内存</a>-->amount of memory was free(MB)</li>
   <li> <a href=${pageScope.basePath}/mem_free_buffer_cach target="_blank">空闲的内存（带缓存）</a>-->amount of memory was free add buffer add cach(MB)</li>
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

</script>
   
  </script>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%    
String path = request.getContextPath();    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
pageContext.setAttribute("basePath",basePath);    
%>    
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Io_blk_wrtn/s</title>
	<link href="${pageScope.basePath}/resource/js/flot/examples/examples.css" rel="stylesheet" type="text/css">
	<script language="javascript" type="text/javascript" src="${pageScope.basePath}/resource/js/flot/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="${pageScope.basePath}/resource/js/flot/jquery.flot.js"></script>
	<script type="text/javascript">
	function queryIO(){
        var user={url:'',username:'',password:''};
        var res=0;
        $.ajax({
            url:"${pageScope.basePath}io",
            type:"post", 
            data:user,   
            async:false,
            success:function(reData){ 
            var objs = jQuery.parseJSON(reData);  
            $.each(objs, function(i, n) {//遍历所有硬盘的读写
                res+=parseFloat(n.blk_wrtn_s);
            });
            }
        });
        return res;
    }  
    
	$(function() {
		var data = [],
			totalPoints = 100;
		for(var i=0;i<totalPoints-1;i++){
			data[i]=-100;
		}
		function getRandomData() {

			if (data.length > 0)
				data = data.slice(1);
			while (data.length < totalPoints) {
				var y = queryIO();
				data.push(y);
			}
			var res = [];
			for (var i = 0; i < data.length; ++i) {
				res.push([i, data[i]])
			}

			return res;
		}

		// Set up the control widget

		var updateInterval = 2000;
		$("#updateInterval").val(updateInterval).change(function () {
			var v = $(this).val();
			if (v && !isNaN(+v)) {
				updateInterval = +v;
				if (updateInterval < 1) {
					updateInterval = 1;
				} else if (updateInterval > 60*1000) {
					updateInterval = 60*1000;
				}
				$(this).val("" + updateInterval);
			}
		});

		var plot = $.plot("#placeholder", [ getRandomData() ], {
			series: {
				shadowSize: 0	// Drawing is faster without shadows
			},
			yaxis: {
				min: 0,
				max: 1000
			},
			xaxis: {
				show: totalPoints
			}
		});

		function update() {
			plot.setData([getRandomData()]);

			// Since the axes don't change, we don't need to call plot.setupGrid()

			plot.draw();
			setTimeout(update, updateInterval);
		}

		update();

		// Add the Flot version string to the footer

		$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
	});
	
	
    
   


	</script>
</head>
<body>

	<div id="header">
		<h3>每秒写入磁盘扇区量（KB）</h3>
	</div>

	<div id="content">

		<div class="demo-container">
			<div id="placeholder" class="demo-placeholder"></div>
		</div>
		<b>X轴表示磁盘每秒写入的扇区量（1个扇区=512bytes）（KB）</b><br>
		 <b>Y轴表示最近第N次的采集</b><br>
		  <b>如果Blk_wrtn/s值很大，表示磁盘的写操作很频繁，可以考虑优化磁盘或者优化程序，
		              根据系统应用的不同，会有不同的值，
			但是如果长期的、超大的数据读写，肯定是不正常的，这种情况一定会影响系统性能。</b>
		<p>采集间隔: <input id="updateInterval" type="text" value="" style="text-align: right; width:5em"> 毫秒（建议大于5000）</p>

	</div>

</body>
</html>

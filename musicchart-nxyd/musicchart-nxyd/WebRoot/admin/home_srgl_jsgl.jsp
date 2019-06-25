<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>收入-结算管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="结算管理">
	
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.4.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.4.1/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.4.1/demo/demo.css">
	<style type="text/css">
    	.a_q {
			text-decoration: none;
			color: black;
			display: block;
			width: 80px;
			text-align: center;
		}
		.a_q a:hover {
			font-weight: bold;
		}
    </style>
  </head>
  
  <body>
    <div>
    	
    		<div class="tui_1_tongji_head">
    			<span style="float: left;">结算管理</span>
    			<div style="float:left;padding-left: 80%">
    				<input type="button" onclick="query()" value="导出" />
    			</div>
    		</div>
    		<div>
	    		<div class="tui_1_zoushi_3" style="float: left;">
	    			<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	    			<div id="main" style="width: 50%;height:100%; float: left;"></div>
	    			<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	    			<div id="main2" style="width: 50%;height:100%; float: left;"></div>
	    		</div>
    		</div>
    		<div class="zongji">
    			<span>总收入：<span id="money">${money}</span>￥</span>
    			<%-- <span>总续订单数：${renewLog.renewMonth}</span> --%>
    			<span style="padding-left: 5%">总退订单数：<span id="renewlog">${renewLog.unsubscribeMonth}</span></span>
    			<span style="padding-left: 40%">总点击量：<span id="onclicks">${onclicks}</span></span>
    		</div>
    		<div style="padding-top: 30px;">
    			<div style="padding-left: 100px;">
    			<form action="SRTJJSGLAction" method="post" id="settlement">
    			<table>
    				<tr>
	    				<td>
		    				<span>开始：<input id="state" name="state" class="Wdate" size="10" type="text" value="${state}" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"></span>
		    				<span>结束：<input id="end" name="end" class="Wdate" size="10" type="text" value="${end}" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"></span>
		    			</td>
	    				<td style="padding-left: 70px;">
	    					<!-- <input class="easyui-slider" style="width:300px" data-options="showTip:true,rule: [0,'|',25,'|',50,'|',75,'|',100]"> -->
	    					<input type="text" value="${yu}" name="yu" id="yu" placeholder="0" />
	    				</td>
	    				<td style="padding-left: 30px;">
		    				<span><input type="button" value="确定" onclick="sumbit()" /></span>
	    				</td>
    				</tr>
    			</table>
    			</form>
    			</div>
    		</div>
	<script type="text/javascript" src="jquery-easyui-1.5.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.4.1/jquery.easyui.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/emailAutoComplete.js"></script>
    <script language="javascript" type="text/javascript" src="js/WdatePicker.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script language="javascript" type="text/javascript" src="js/echarts.min(1).js"></script>
    <script language="javascript" type="text/javascript" src="js/echarts.js"></script>
    
    <script type="text/javascript">
    	function query(){
    		window.location='JSGLExcelAction.action'; 
    	}  
    	function sumbit(){
    		var state = $('#state').val();
    		var end = $('#end').val();
    		var yu = $('#yu').val();
    		if(state == "" || end == ""){
    			alert("请输入正确日期!");
    		}else{
    			bingtu(state+","+end);
    			bingtu2(state+","+end,yu);
    			$.ajax({ 
					url:"JieSuanAction.action",
					type:"post",
					async : false, 
					data : {state:state,end:end},
					dataType:"json", 
					success:function(renewLog){
						$('#money').html(renewLog.status);
						$('#renewlog').html(renewLog.unsubscribeMonth);
				    }
				});
				$.ajax({ 
					url:"YUJieSuanAction.action",
					type:"post",
					async : false, 
					data : {state:state,end:end,yu:$('#yu').val()},
					dataType:"json", 
					success:function(onclicks){
						$('#onclicks').html(onclicks);
				    }
				});
    		}
    	}
    </script>
	<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        window.onload = bingtu(0);
        function bingtu(number){
        var myChart = echarts.init(document.getElementById('main'));
        var colorList = [
		     '#2ec7c9', '#d87a80', '#5ab1ef'
		 ];
		 // 总和
		 var total = {
		     name: '总单数',
		     value: '145'
		 }

		 var originalData = [{
		     value: 55,
		     name: '优先55'
		 }, {
		     value: 70,
		     name: '普通70'
		 }, {
		     value: 25,
		     name: "紧急25"
		 }];

		 echarts.util.each(originalData, function(item, index) {
		     item.itemStyle = {
		         normal: {
		             color: colorList[index]
		         }
		     };
		 });
        // 指定图表的配置项和数据
		var option = {
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    series: [{
		        name: '包月收入占比',
		        type: 'pie',
		        radius: '70%',
		        center: ['50%', '50%'],
		        clockwise: false,
		        /* data: [{
		            value: 45,
		            name: 'CP1'
		        }, {
		            value: 25,
		            name: 'CP2'
		        }, {
		            value: 15,
		            name: 'CP3'
		        }, {
		            value: 8,
		            name: 'CP4'
		        }, {
		            value: 7,
		            name: 'CP5'
		        }], */
		        label: {
		            normal: {
		                textStyle: {
		                    color: '#999',
		                    fontSize: 14,
		                }
		            }
		        },
		        labelLine: {
		            normal: {
		                show: false
		            }
		        },
		        itemStyle: {
		            normal: {
		                borderWidth: 4,
		                borderColor: '#ffffff',
		            },
		            emphasis: {
		                borderWidth: 0,
		                shadowBlur: 10,
		                shadowOffsetX: 0,
		                shadowColor: 'rgba(0, 0, 0, 0.5)'
		            }
		        }
		    }],
		    color: [
		        '#00acee',
		        '#52cdd5',
		        '#79d9f1',
		        '#a7e7ff',
		        '#c8efff'
		    ],
		    backgroundColor: '#fff'
		  }
		 	loadDATA2(number);
        	myChart.setOption(option,number,true);
        
        /* myChart.on('click', function (param) {
	    	var index = param.dataIndex;
	    	var percent = param.percent;
	    	alert(index+'--'+percent+'--'+param.name);
			console.log(param);
 		}); */
 		function loadDATA2(number){
		     $.ajax({ 
			//这里的需要Struts.xml的<action/>的name属性一致。
			url:"LoginSRBTTJAction.action",
			//提交类型
			type:"post",
			//返回的数据类型
			async : false, //同步执行
			data : {day:number},
			dataType:"json", 
			//成功是调用的方法
			success:function(result){
				option.series[0].data=result;
		    }
		});
	}   
	}
    </script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        window.onload = bingtu2(0);
        function bingtu2(number){
        var myChart = echarts.init(document.getElementById('main2'));
        var colorList = [
		     '#2ec7c9', '#d87a80', '#5ab1ef'
		 ];
		 
		 // 总和
		 var total = {
		     name: '总单数',
		     value: '145'
		 }

		 var originalData = [{
		     value: 55,
		     name: '优先55'
		 }, {
		     value: 70,
		     name: '普通70'
		 }, {
		     value: 25,
		     name: "紧急25"
		 }];

		 echarts.util.each(originalData, function(item, index) {
		     item.itemStyle = {
		         normal: {
		             color: colorList[index]
		         }
		     };
		 });
        // 指定图表的配置项和数据
		var option = {
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    series: [{
		        name: '点击量占比',
		        type: 'pie',
		        radius: '70%',
		        center: ['50%', '50%'],
		        clockwise: false,
		        /* data: [{
		            value: 45,
		            name: 'CP1'
		        }, {
		            value: 25,
		            name: 'CP2'
		        }, {
		            value: 15,
		            name: 'CP3'
		        }, {
		            value: 8,
		            name: 'CP4'
		        }, {
		            value: 7,
		            name: 'CP5'
		        }], */
		        label: {
		            normal: {
		                textStyle: {
		                    color: '#999',
		                    fontSize: 14,
		                }
		            }
		        },
		        labelLine: {
		            normal: {
		                show: false
		            }
		        },
		        itemStyle: {
		            normal: {
		                borderWidth: 4,
		                borderColor: '#ffffff',
		            },
		            emphasis: {
		                borderWidth: 0,
		                shadowBlur: 10,
		                shadowOffsetX: 0,
		                shadowColor: 'rgba(0, 0, 0, 0.5)'
		            }
		        }
		    }],
		    color: [
		        '#00acee',
		        '#52cdd5',
		        '#79d9f1',
		        '#a7e7ff',
		        '#c8efff'
		    ],
		    backgroundColor: '#fff'
		  }
		 	loadDATA2(number);
        	myChart.setOption(option,number,true);
        
        /* myChart.on('click', function (param) {
	    	var index = param.dataIndex;
	    	var percent = param.percent;
	    	alert(index+'--'+percent+'--'+param.name);
			console.log(param);
 		}); */
 		function loadDATA2(number){
		     $.ajax({ 
			//这里的需要Struts.xml的<action/>的name属性一致。
			url:"LoginQMBTTJAction.action",
			//提交类型
			type:"post",
			//返回的数据类型
			async : false, //同步执行
			data : {day:number,yu:0},
			dataType:"json", 
			//成功是调用的方法
			success:function(result){
				option.series[0].data=result;
		    }
		});
	}   
	}
    </script>
  </body>
</html>

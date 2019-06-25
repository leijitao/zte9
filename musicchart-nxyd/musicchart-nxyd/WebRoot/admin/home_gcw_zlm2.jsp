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
    
    <title>全部收入统计</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="全部收入统计">
	
	<link rel="stylesheet" type="text/css" href="css/home.css">
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
		<div class="div-c"></div> 
    	<div class="tui_1_tongji">
    		<div class="tui_1_tongji_head"><span style="float: left;">${productName}-收入统计</span>
    		<input type="hidden" id="productId" value="${monthlyType.productId}" />
    		</div>
    		<div class="tui_1_table_div">
    		<table class="tui_1_table_1">
    			<tr class="tui_1_table_1_tr">
    				<td></td>
    				<td class="tui_1_table_td">收入金额</td>
    				<td class="tui_1_table_td">付费人数</td>
    				<td class="tui_1_table_td">转化率</td>
    				<td class="tui_1_table_td">退订人数</td>
    			</tr>
    			<tr class="tui_1_table_1_tr">
    				<td class="tui_1_table_td">今日</td>
    				<td>${shouRuDateVOs[1].fee}</td>
    				<td>${shouRuDateVOs[1].people}</td>
    				<td>${shouRuDateVOs[1].rate}</td>
    				<td>${shouRuDateVOs[1].unpeople}</td>
    			</tr>
    			<tr class="tui_1_table_1_tr">
    				<td class="tui_1_table_td">昨日</td>
    				<td>${shouRuDateVOs[0].fee}</td>
    				<td>${shouRuDateVOs[0].people}</td>
    				<td>${shouRuDateVOs[0].rate}</td>
    				<td>${shouRuDateVOs[0].unpeople}</td>
    			</tr>
    		</table>
    		</div>
    	</div>
    	<div class="tui_1_zoushi">
    		<div class="tui_1_tongji_head">
    			<span>统计趋势</span>
    		</div>
    		<div class="tui_1_xiao_1">
    			<span style="padding-top: 30px;padding-left: 400px">开始：<input id="state" class="Wdate" size="10" type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"></span>
    			<span style="padding-top: 30px;padding-left: 10px">结束：<input id="end" class="Wdate" size="10" type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})"></span>
    			<input onclick="shijian()" type="button" value="确定">
    			
    			<div id="t1" class="tui_1_xiao tui3"><a href="javascript:;" onclick="makeLine(7);bingtu(7)" class="a_q"><span>过去7天</span></a></div>&nbsp;&nbsp;&nbsp;
    			<div id="t2" class="tui_1_xiao tui4"><a href="javascript:;" onclick="makeLine(30);bingtu(30)" class="a_q"><span>过去30天</span></a></div>&nbsp;&nbsp;&nbsp;
    			<div id="t3" class="tui_1_xiao tui5"><a href="javascript:;" onclick="makeLine(90);bingtu(90)" class="a_q"><span>过去90天</span></a></div>&nbsp;&nbsp;&nbsp;
    			<div id="t4" class="tui_1_xiao tui6"><a href="javascript:;" onclick="makeLine(180);bingtu(180)" class="a_q"><span>过去6个月</span></a></div>&nbsp;&nbsp;&nbsp;
    		</div>
    			
    		<div class="tui_1_zoushi_2">
    			<div id="container" style="height: 100%;width: 99%"></div>
    		</div>
    		<div style="padding-top: 20px;"></div>
    		
    	</div>
    	<div class="tui_1_mingxi">
    		<div class="tui_1_tongji_head">
    			<span style="float: left;">明细</span>
    			<div style="float:left;padding-left: 85%">
    				<input type="button" onclick="query()" value="导出" />
    			</div>
    		</div>
    		
    		<div id="table2">
    			<table class="tui_2_table"  cellpadding="0px" cellspacing="0px">
    			</table>
    		</div>
    		<div class="zongji"></div>
    		<div class="food"></div>
    	</div>
    </div>
    <script language="javascript" type="text/javascript" src="js/WdatePicker.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery.js"></script>
    <script language="javascript" type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script language="javascript" type="text/javascript" src="js/echarts.min(1).js"></script>
    <script language="javascript" type="text/javascript" src="js/echarts.js"></script>
    
    <script type="text/javascript">
    	function query(){
    		window.location='SRExcelAction.action'; 
    	}  
    	function shijian(){
				var start = $("#state").val();
				var end = $("#end").val();
				var number = start+","+end;
				makeLine(number);
				bingtu(number);
		}
		function ass(number){
			var str="";
			$.ajax({ 
				//这里的需要Struts.xml的<action/>的name属性一致。
				url:"SRAssAction.action",
				//提交类型
				type:"post",
				//返回的数据类型
				async : false, //同步执行
				data : {className:$("#productId").val(),day:number},
				dataType:"json", 
				//成功是调用的方法
				success:function(srdvoDateVO){ 
				    if (srdvoDateVO) {
				    	str+="<span>总收入："+srdvoDateVO.fee+"元</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				       	str+="<span>总订单数："+srdvoDateVO.people+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				       	str+="<span>总订购人数："+srdvoDateVO.rens+"人</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				       	str+="<span>合总转化率："+srdvoDateVO.rate+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				       	str+="<span>总退订人数："+srdvoDateVO.unpeople+"人</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				       	str+="<span>总新增人数："+srdvoDateVO.date+"人</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				       	$(".zongji").html(str);	
				    }
				}
			});
		}
    </script>
    <script>
		        	window.onload = makeLine(7);
		            function makeChart () {
		           		var dom = document.getElementById("container");
						var myChart = echarts.init(dom);
		                return myChart;
		            }
		
		            function makeLine (number) {
		                var chart = makeChart();
		                var xAxisData = [];
		                var data = [];
		                for (var i = 0; i < 5; i++) {
		                    xAxisData[i] = [];
		                    data[i] = [];
		                    for (var j = 0; j < 10; j++) {
		                        xAxisData[i].push('jj' + j);
		                        data[i].push((Math.random() * 5).toFixed(2));
		                    }
		                }
		                var option = {
		                    tooltip : {
		                        trigger: 'axis'
		                    },
		                    legend: {
		                    	layout: 'vertical',
                    			align: 'right',
                    			borderWidth: 0,
                    			verticalAlign: 'middle',
                    			y: 0,
                    			x: 100,
		                        data: ['收入金额','付费人数','转化率','退订人数']
		                    },
		                    toolbox: {
		                        top: 0,
		                        feature: {
		                            magicType: {
		                            },
		                            myTool1: {
		                                show: false,
		                                title: '自定义扩展方法：重新加载 option',
		                                icon: 'path://M432.45,595.444c0,2.177-4.661,6.82-11.305,6.82c-6.475,0-11.306-4.567-11.306-6.82s4.852-6.812,11.306-6.812C427.841,588.632,432.452,593.191,432.45,595.444L432.45,595.444z M421.155,589.876c-3.009,0-5.448,2.495-5.448,5.572s2.439,5.572,5.448,5.572c3.01,0,5.449-2.495,5.449-5.572C426.604,592.371,424.165,589.876,421.155,589.876L421.155,589.876z M421.146,591.891c-1.916,0-3.47,1.589-3.47,3.549c0,1.959,1.554,3.548,3.47,3.548s3.469-1.589,3.469-3.548C424.614,593.479,423.062,591.891,421.146,591.891L421.146,591.891zM421.146,591.891',
		                                onclick: function (){
		                                    chart.setOption(option);
		                                    alert('chart.setOption(option) DONE!')
		                                }
		                            }
		                        }
		                    },
		                    xAxis : [
		                        {
		                            type : 'category',
		                            boundaryGap : false,
		                        }
		                    ],
		                    yAxis : [
		                        {
		                            type : 'value'
		                        }
		                    ],
		                    series : [
		                    	{
		                    		name : '收入金额',
		                    		type : 'line',
		                    		stack :'1',
		                    	},
		                    	{
		                    		name : '付费人数',
		                    		type : 'line',
		                    		stack :'2',
		                    	},
		                    	{
		                    		name : '转化率',
		                    		type : 'line',
		                    		stack :'3',
		                    	},
		                    	{
		                    		name : '退订人数',
		                    		type : 'line',
		                    		stack :'4',
		                    	}
		                    ]
		                }
		                loadDATA(option,number);
		                chart.setOption(option,number);
		            }
		        	function loadDATA(option,number){
		            	$.ajax({ 
				        //这里的需要Struts.xml的<action/>的name属性一致。
				       	url:"SRTJTBAction.action",
				       	//提交类型
				       	type:"post",
				       	//返回的数据类型
				       	async : false, //同步执行
				       	data : {className:$("#productId").val(),day:number},
				       	dataType:"json", 
				       	//成功是调用的方法
				       	success:function(result){ 
				       		if (result) {
				       			option.xAxis[0].data=[];
				       			for(var i=0;i<result.length;i++){
				       				option.xAxis[0].data.push(result[i].name);
				       			}
				       			option.series[0].data=[];
				       			for(var i=0;i<result.length;i++){
				       				option.series[0].data.push(result[i].data);
				       			}
				       			option.series[1].data=[];
				       			for(var i=0;i<result.length;i++){
				       				option.series[1].data.push(result[i].data2);
				       			}
				       			option.series[2].data=[];
				       			for(var i=0;i<result.length;i++){
				       				option.series[2].data.push(result[i].data3);
				       			}
				       			option.series[3].data=[];
				       			for(var i=0;i<result.length;i++){
				       				option.series[3].data.push(result[i].data4);
				       			}
				       			var str="";
				       			str+="<table class='tui_2_table'  cellpadding='0px' cellspacing='0px'>";
    							str+="<tr>";
    							str+="<td style='font-weight: bold;'>日期</td>";
			    				str+="<td style='font-weight: bold;'>收入金额</td>";
			    				str+="<td style='font-weight: bold;'>订单数</td>";
			    				str+="<td style='font-weight: bold;'>转化率</td>";
			    				str+="</tr>";
			    				for(var i = 0;i<result.length;i++){
			    					str+="<tr>";
			    					str+="<td>"+result[i].name+"</td>";
			    					str+="<td>"+result[i].data+"</td>";
			    					str+="<td>"+result[i].data2+"</td>";
			    					str+="<td>"+result[i].data3+"%</td>";
			    					str+="</tr>";
			    				}
			    				$("#table2").html(str);
				       		}
		        		}
			    	});
			    	ass(number);
				   }            
		        </script>
  </body>
</html>

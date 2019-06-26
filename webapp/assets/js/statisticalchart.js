 var echartsShow = echarts.init(document.getElementById('echartsShow'));
	    option = {
	        tooltip: {
	            trigger: 'axis',
	        },
	        legend: {
	            data: ['事假','病假','晚假']
	        },
	        grid: {
	            left: '3%',
	            right: '4%',
	            bottom: '3%',
	            containLabel: true
	        },
	        xAxis: [{
	            type: 'category',
	            boundaryGap: true,
	            data: []
	        }],

	        yAxis: [{
	        	 name:'单位/次',
	            type: 'value'
	        }],
	        series: [{
	                name: '事假',
	                type: 'line',
	                stack: '总量',
	                data: [],
	                areaStyle: {normal: {}},
	                itemStyle: {
	                    normal: {
	                        color: '#4169E1'
	                    }
	                }
	            },
	            {
	                name: '病假',
	                type: 'line',
	                stack: '总量',
	                data: [],
	                areaStyle: {normal: {}},
	                itemStyle: {
	                    normal: {
	                        color: '#e7505a'
	                    },emphasis: {

	                    }
	                }
	            },
				 {
	                name: '晚假',
	                type: 'line',
	                stack: '总量',
	                data: [],
	                areaStyle: {normal: {}},
	                itemStyle: {
	                    normal: {
	                        color: '#32c5d2'
	                    },emphasis: {

	                    }
	                }
	            },
	            ]
	    };
	    echartsShow.setOption(option);
	 function setChart(){
		 data = arguments[1];
		 if(arguments[0]=='month')
			{
			 echartsShow.setOption({
			   xAxis: [{
				    name:'日',
		            data: [
		            	'1', '2', '3', '4', '5', '6', '7','8','9','10','11','12','13','14', '15', 
		            	'16', '17', '18', '19','20','21','22','23','24', '25', '26', '27', '28', '29', '30','31']
		        }],
		        series: [{
		            // 根据名字对应到相应的系列
		            name: '事假',
		            data: data.thingNum
		        },{
		        	 name: '病假',
		        	 data: data.sickNum
		        },{
		        	 name:'晚假',	
		        	 data: data.nightNum
		        }
		        
		        ]
		    });
		}else{
			echartsShow.setOption({
				   xAxis: [{
			            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月','9月','10月','11月','12月']
			        }],
			        series: [{
			            // 根据名字对应到相应的系列
			            name: '事假',
			            data: data.thingNum
			        },{
			        	 name: '病假',
			        	 data: data.sickNum
			        },{
			        	 name:'晚假',	
			        	 data: data.nightNum
			        }
			        
			        ]
			    });
		}
	 }
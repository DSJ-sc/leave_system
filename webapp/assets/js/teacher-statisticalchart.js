 var echartsShow = echarts.init(document.getElementById('echartsShow'));
	    option = {
	        tooltip: {
	            trigger: 'axis',
	        },
	        legend: {
	            data: ['软件学院','艺术设计学院','电子工程学院','商学院']
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
	                name: '软件学院',
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
	                name: '艺术设计学院',
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
	                name: '电子工程学院',
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
	            {
	                name: '商学院',
	                type: 'line',
	                stack: '总量',
	                data: [],
	                areaStyle: {normal: {}},
	                itemStyle: {
	                    normal: {
	                        color: '#00FA9A'
	                    },emphasis: {

	                    }
	                }
	            },
	            ]
	    };
	    echartsShow.setOption(option);
	 function setChart(){
		 	data = arguments[0];
			echartsShow.setOption({
				   xAxis: [{
			            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月','9月','10月','11月','12月']
			        }],
			        series: [{
			            // 根据名字对应到相应的系列
			            name: '软件学院',
			            data: data.softwareCollege
			        },{
			        	 name: '艺术设计学院',
			        	 data: data.artDesignCollege
			        },{
			        	 name:'电子工程学院',	
			        	 data: data.electronicEngineeringCollege
			        },{
			        	 name:'商学院',	
			        	 data: data.businessCollege
			        }
			        
			        ]
			    });
	 }
 	 var pages;/*分页信息*/
	 var num;/*教师编号*/
	 var websocket;/*双向通信*/
	 var specialty;/**查询的学生信息**/
	 var teacher;
		$(function(){
			$.ajax({
			     async : true ,
			     type : "post",//传值方式
			     url : '../getUser',//请求的地址
			     data : { 
			    	 "identity":'teacher'
			     },
			     //回调函数 返回的值
			     success : function(data) {
			    		teacher=data;
			    	$(".am-icon-user-secret").append(data.teacherName);
			    	getFaculty();
			    	linkWebsocket(teacher.teacherNum);
			     }
			     }); 
		});	 
	function getFaculty(){
		$.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : 'getFaculty',//请求的地址
		     //回调函数 返回的值
		     success : function(data) {
		    	 specialty = data;
		   	var oSpecialty = $('#facultyName');
		    	oSpecialty.html('');
		    	oSpecialty.append('<option value=" ">所有学院</option>');
		    	for(var i=0,j=data.length;i<j;i++){    		
		    		oSpecialty.append('<option value="'+data[i].facultyId+'">'+data[i].facultyName+'</option>');	
		    	}
		    	
		     }
		     }); 
	}
	$('#facultyName').change(function(){
		setTeacher($('#facultyName option:selected').val());
	});
	$("#computerSelectLeaveButton").click(function(){
		if($('#yearTimeInput').val()=='' && $('#monthTimeInput').val()==''){
			alert('请选择查询时间');
			return false;
		}else{
			if($('#timeSelect option:selected').val( )== 'month'){
				if($('#monthTimeInput').val()==''){
					alert('请选择查询时间');
					return false;
				}
					setMap($('#monthTimeInput').val(),$('#facultyName option:selected').val(),$('#teacherName option:selected').val());
			}else{
				if($('#yearTimeInput').val()==''){
					alert('请选择查询时间');
					return false;
				}
					setMap($('#yearTimeInput').val(),$('#facultyName option:selected').val(),$('#teacherName option:selected').val());
			}
		}

		
	});
	$('#timeSelect').change(function (){
		$()
		var select = $('#timeSelect option:selected').val();
		if(select == 'year'){
			$('#monthTimeInput').hide();
			$('#yearTimeInput').show();
		}else{
			$('#yearTimeInput').hide();
			$('#monthTimeInput').show();
			
		}
	});
		function setTeacher(){
			if(arguments[0] != ' ')
			$.ajax({
	    	     async : true ,
	    	     type : "post",//传值方式
	    	     url : 'getTeacher',//请求的地址
	    	     data : { 
	    	      //传送的数据 名:值用逗号隔开
	    	     "faculty":arguments[0]
	    	     },
	    	     //回调函数 返回的值
	    	     success : function(data) { 
	    	    	 var oTeacherName = $('#teacherName');
	    	    	 oTeacherName.html("");
	    	    	 oTeacherName.append("<option value=' '>所有教师</option>"); 
	    				for(var i=0,j=data.length;i<j;i++){
	    					oTeacherName.append("<option value=" +data[i].teacherNum + ">" +data[i].teacherName + "</option>");  
	    				}
	    	     }
	    	     });
			}
	   function setMap(){
		   if(arguments[1]==' '){
			   arguments[1]='';
		   }
		   if(arguments[2]==' '){
			   arguments[2]='';
		   }
	    	$.ajax({
	    	     async : true ,
	    	     type : "post",//传值方式
	    	     url : 'queryTeacherStatistics',//请求的地址
	    	     data : { 
	    	      //传送的数据 名:值用逗号隔开
	    	     "leaveTime" : arguments[0],
	    	     "facultyName":arguments[1],
	    	     "teacherNum":arguments[2],
	    	     },
	    	     //回调函数 返回的值
	    	     success : function(data) { 
	    	    	 setChart(data);
	    	     }
	    	     }); 
	   }
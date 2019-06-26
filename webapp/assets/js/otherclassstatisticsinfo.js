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
			    	getClass(data.teacherFaculty);
			    	linkWebsocket(teacher.teacherNum);
			     }
			     }); 
		});	 
	function getClass(){
		$.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : '../teacher/getSpecialtyName',//请求的地址
		     data : { 
		    	 "facultyName":arguments[0]
		     },
		     //回调函数 返回的值
		     success : function(data) {
		    	 specialty = data;
		   	var oSpecialty = $('#specialtyName');
		    	oSpecialty.html('');
		    	oSpecialty.append('<option value=""></option>');
		    	oSpecialty.append('<option value="all">所有专业</option>');
		    	for(var i=0,j=data.length;i<j;i++){    		
		    		oSpecialty.append('<option value="'+i+data[i].specialtyId+'">'+data[i].specialtyName+'</option>');	
		    	}
		    	
		     }
		     }); 
	}
	$('#specialtyName').change(function(){
		setClass($('#specialtyName option:selected').val().substring(0,1));
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
	$("#computerSelectLeaveButton").click(function(){
		if($('#monthTimeInput').val()==''&&$('#yearTimeInput').val()==''){
			alert('请选择查询时间');
			return false;
		}
		if($('#timeSelect option:selected').val( )== 'month'){
			if($('#monthTimeInput').val()==''){
				alert('请选择查询时间');
				return false;
			}
				setMap($('#monthTimeInput').val(),$("#specialtyName option:selected").val().substring(1),$("#className option:selected").val());
		}else{
			if($('#yearTimeInput').val()==''){
				alert('请选择查询时间');
				return false;
			}
				setMap($('#yearTimeInput').val(),$("#specialtyName option:selected").val().substring(1),$("#className option:selected").val());
		}
		
	});
		function setClass(){
			var oClassname = $('#className');
			oClassname.html("");
			if(arguments[0] != 'all' && arguments[0] !=''){
			var name = specialty[arguments[0]].className;
			oClassname.append("<option value=''></option>"); 
			oClassname.append("<option value='all'>所有班级</option>"); 
			for(var i=0,j=name.length;i<j;i++){
				oClassname.append("<option value=" +name[i] + ">" +name[i] + "</option>");  
			}
			
			}
		}
	   function setMap(){
		   var time = arguments[3];
		   if(arguments[1]=='所有专业'){
			   arguments[1]='';
		   }
		   if(arguments[2]=='all'){
			   arguments[2]='';
		   }
	    	$.ajax({
	    	     async : true ,
	    	     type : "post",//传值方式
	    	     url : '../teacher/queryClassStatistics',//请求的地址
	    	     data : { 
	    	      //传送的数据 名:值用逗号隔开
	    	     "leaveTime" : arguments[0],
	    	     "faculty":teacher.teacherFaculty,
	    	     "specialty":arguments[1],
	    	     "className":arguments[2]  
	    	     },
	    	     //回调函数 返回的值
	    	     success : function(data) { 
	    	    	 setChart(time,data);
	    	     }
	    	     }); 
	   }
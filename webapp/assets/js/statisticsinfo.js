 	 var pages;/*分页信息*/
	 var num;/*教师编号*/
	 var websocket;/*双向通信*/
	 var student;/**查询的学生信息**/
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
			    		num=data.teacherNum;
			    		linkWebsocket(num);
			    	$(".am-icon-user-secret").append(data.teacherName);
			    	getClass(num);
			     }
			     }); 
		});	 
	function getClass(id){
		$.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : '../teacher/getClassName',//请求的地址
		     data : { 
		    	 "teacherNum":id
		     },
		     //回调函数 返回的值
		     success : function(data) {
		    	 student = data;
		   	var oSelect =	$('#studentClass');
		    	oSelect.html('');
		    	for(var i=0,j=data.length;i<j;i++){    		
		    		oSelect.append('<option value="'+i+'">'+data[i].className+'</option>');	
		    	}
		    	setStudent(0);
		     }
		     }); 
	}
	function setStudent(num){
		var oStudentBtn = $('#selectpicker');
		var name = student[num].studentName;
		var sno = student[num].studentSno;
		oStudentBtn.html("");
		oStudentBtn.append('<option value=""></option>');
		oStudentBtn.append('<option value="all">所有学生</option>');	
		for(var i=0,j=name.length;i<j;i++){
			oStudentBtn.append("<option value=" + sno[i] + ">" +name[i] + "</option>");  
		}
	}
	$('#studentClass').change(function(){
		setStudent($('#studentClass option:selected').val());
	});
	$('#timeSelect').change(function (){
		var select = $('#timeSelect option:selected').val();
		if(select == 'year'){
			$('#monthTimeInput').hide();
			$('#yearTimeInput').show();
			$('#monthTimeInput').val("");
		}else{
			$('#yearTimeInput').hide();
			$('#monthTimeInput').show();
			$('#yearTimeInput').val("");
			
		}
	});
	$("#computerSelectLeaveButton").click(function(){
		if($('#monthTimeInput').val()==''&&$('#yearTimeInput').val()==''){
			alert('请选择查询时间');
			return false;
		}
		if($('#timeSelect option:selected').val( )== 'month'){
				setMap($('#monthTimeInput').val(),$("#studentClass option:selected").text(),'month',$("#selectpicker").val());
		}else{
				setMap($('#yearTimeInput').val(),$("#studentClass option:selected").text(),'year',$("#selectpicker").val());
		}
		
	});
	
	
 function setMap(){
		   var	time = arguments[2];
		   if(arguments[3]=='all'){
			   arguments[3]='';
		   }
	    	$.ajax({
	    	     async : true ,
	    	     type : "post",//传值方式
	    	     url : '../teacher/queryStudentStatistics',//请求的地址
	    	     data : { 
	    	      //传送的数据 名:值用逗号隔开
	    	     "leaveTime" : arguments[0],
	    	     "className":arguments[1],
	    	     "userNum":arguments[3]
	    	     },
	    	     //回调函数 返回的值
	    	     success : function(data) {
	    	    	 $(".down").show();
	    	    	 setChart(time,data);
	    	     }
	    	     }); 
	   }
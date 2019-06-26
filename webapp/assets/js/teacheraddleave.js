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
				teacher = data;
				linkWebsocket(data.teacherNum);
				$(".am-icon-user-secret").append(data.teacherName);
				if ($(".visible-lg-block").is(":hidden")) {
					$('.tpl-page-container').css("padding","0");
					$('#page-content').css("padding","0");
				}
			}
		}); 
		$.ajax({
			aysnc:true,
			type:'post',
			url:'../teacher/queryClass',
			success: function (data){
				var className = $('.className');
				for(var i=0,j=data.length;i<j;i++){
					className.append('<option value="'+data[i].className+'">'+data[i].className+'</option>');
				}

			}
			
		});
		$.ajax({
			aysnc:true,
			type:'post',
			url:'../teacher/queryCourse',
			success: function (data){
				var courseName = $('.courseName');
				courseName.append('<option></option>');
				for(var i=0,j=data.length;i<j;i++){
					courseName.append('<option value="'+data[i]+'">'+data[i]+'</option>');
				}
			}
			
		});
	});
	$('.submit').click(function(){
		var teacherLeaveInfo = getLeaveInfo();
		if(teacherLeaveInfo.length != 0){
		$.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : '../teacher/addLeave',//请求的地址
		     data : {
		    	info:JSON.stringify(teacherLeaveInfo)
		     },
		     //回调函数 返回的值
		     success : function(data) {
		    	 if(data>=1){
		    		alert("添加申请成功，请等待管理教师审批！");
		    		//window.location.replace("teacherAddLeave.html");
		    	 }else{
		    		 alert("添加申请失败，请认真检查是否有重复的请求！");
		    	 }
		     }
		     });
		}else{
			
			alert("请填写完整信息");
		}
	});
	function getLeaveInfo(){
		var index1 = 0;
		var index2 = 0;
		if ($(".visible-lg-block").is(":hidden")){
			index1 = 1;
			index2 = 4;
		}
		var oldWeek = new Array();
		var newWeek = new Array();
		var oldTime = new Array();
		var newTime = new Array();
		var oldDay = new Array();
		var newDay = new Array();
		var oldClassRoom = new Array();
		var newClassRoom = new Array();
		var info = new Array();
		var className = $('.className').eq(index1).val().toString().replace('[\\["\\]]',"");
		var courseName = $('.courseName').eq(index1).val();
		var leaveType = $('.leaveType').eq(index1).val();
		var replaceTeacher = $('.replaceTeacher').eq(index1).val();
		var leaveReason = $('.leaveReason').eq(index1).val();
		var specificReason = $('.specificReason').eq(index1).val();
			if(className == ''){
				 className = null;
			 }		
			if(courseName == ''){
				courseName = null;
			 }	
			if(replaceTeacher == ''){
				replaceTeacher = null;
			 }
			if(specificReason == ''){
				specificReason = null;
			 }
		 $('.oldWeek').each(function(index2){
				
	        	if($(this).val()==''  ){
	        		return;
	        	}
	        	if(!(/^\d{1,2}$/.test($(this).val())) ){
					 alert("周数请输入1-2位数字");
				 }
	        	//添加至数组
	        	oldWeek.push($(this).val());
	     });
		 $('.newWeek').each(function(index2){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	 if(!(/^\d{1,2}$/.test($(this).val())) ){
					 alert("周数请输入1-2位数字");
				 }
	        	newWeek.push($(this).val());
		 });
		 $('.oldTime').each(function(index2){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	oldTime.push($(this).val());
	     });
		 $('.newTime').each(function(index2){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	
	        	newTime.push($(this).val());
	     });
		 $('.newDay').each(function(index2){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	newDay.push($(this).val());
	     });
		 $('.oldDay').each(function(index2){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	oldDay.push($(this).val());
	     });
		 $('.oldClassRoom').each(function(index2){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	oldClassRoom.push($(this).val());
	     });
		 $('.newClassRoom').each(function(index2){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	newClassRoom.push($(this).val());
	     });
		 for(var i=0;i<newClassRoom.length;i++){ 
			 if(oldWeek[i]&&newWeek[i]&&oldTime[i]&&newTime[i]
			 	&&oldDay[i]&&newDay[i]&&oldClassRoom[i]&&newClassRoom[i]){				
			 var teacherLeave = new Object();
			 teacherLeave.oldSchoolWeek = oldWeek[i];
			 teacherLeave.newSchoolWeek = newWeek[i];
			 teacherLeave.oldTime = oldTime[i];
			 teacherLeave.newTime = newTime[i];
			 teacherLeave.oldDay = oldDay[i];
			 teacherLeave.newDay = newDay[i];
			 teacherLeave.oldClassRoom = oldClassRoom[i];
			 teacherLeave.newClassRoom = newClassRoom[i];
			 teacherLeave.className = className;
			 teacherLeave.courseName = courseName;
			 teacherLeave.leaveType = leaveType;
			 teacherLeave.replaceTeacher = replaceTeacher;
			 teacherLeave.leaveReason = leaveReason;
			 teacherLeave.specificReason = specificReason;
			 teacherLeave.teacherNum = teacher.teacherNum;
			 info.push(teacherLeave);
			 }
		}
		 return info;
	}
	function openWindowOne(){
		$('.showWindowOne').hide();
		$('.hideWindowOne').show();
	}
	function closeWindowOne(){
		$('.showWindowOne').show();
		$('.hideWindowOne').hide();
	}
	function openWindowTwo(){
		$('.showWindowTwo').hide();
		$('.hideWindowTwo').show();
	}
	function closeWindowTwo(){
		$('.showWindowTwo').show();
		$('.hideWindowTwo').hide();
	}
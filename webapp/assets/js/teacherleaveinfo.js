	 var pages = null;
	 var teacher = null;
	 var leaveInfo = null;
	 var num = null;
	 var sum = null;
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
			    		teacher=data.teacherNum;
			    		linkWebsocket(teacher);
			    	$(".am-icon-user-secret").append(data.teacherName);
						  	computerShow();
			     }
			     }); 
		});	 
	function computerShow(){
		$.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : '../teacher/queryleave',//请求的地址
		     data : { 	
		     },
		     //回调函数 返回的值
		     success : function(leaveinfo){	
		    	 if(leaveinfo==''){
		    		 num = -1;
		    		 sum = -1;
		    		 showInfo(0);
		    		 return  ;
		    	 }
		    	 	num = 0;
		    	 	sum = leaveinfo.length-1;
		    	  	leaveInfo = leaveinfo;
		    	 	showInfo();
		     	}
		     });
	}

 $('.next').click(function (){
	 if(num == -1)
		 return;
	 if(num<sum)
		 num++;
	 showInfo();
 });
 $('.last').click(function(){
	 if(num == -1)
		 return;
	 if(num>0)
		 num--;
	 showInfo();
 });
 $(document).keydown(function (event){
	 if (event.keyCode == 37) {  
		 if(num>0)
			 num--;
		 showInfo();
     } 
	 if (event.keyCode == 39) {  
		 if(num<sum)
			 num++;
		 showInfo();
     } 
 });
 $("#computerToPageButton").click(function(){
	 if($("#computerToPageInput").val()>sum){
		 num = sum;
	 }else if($("#computerToPageInput").val()<0){
		 num = 0;
	 } else{
		 num = $("#computerToPageInput").val()-1;
	 }
	 showInfo();
 });
 function showInfo(){
	 	if(num > -1){
	 	$('#computerToPageInput').val(num+1);
	 	$('.page').text(sum+1);
		var className = $('#className').val("");
		var courseName = $('#courseName').val("");
		var teacherName = $('#teachTeacher').val("");
		var requirement = $('#requirement').text("");
		var leaveType = $('#leaveType').val("");
		var replaceTeacher = $('#replaceTeacher').val("");
		var leaveReason = $('#leaveReason').val("");
		var specificReason = $('#specificReason').val(""); 
		var temp = '';
		var teacherLeave = leaveInfo[num];
		 if(teacherLeave[0].leaveApprovalTwo == 1){
			 $('.am-icon-check').show();
			 $('.am-icon-remove').hide();
			 $('.am-icon-warning').hide();
		 }else if(teacherLeave[0].leaveApprovalTwo == 2){
			 	 $('.am-icon-check').hide();
			 	 $('.am-icon-remove').show();
			 	 $('.am-icon-warning').hide();
		 }else{
				 $('.am-icon-check').hide();
				 $('.am-icon-remove').hide();
				 $('.am-icon-warning').show();
				
	 	}
		$('#className').val(teacherLeave[0].className);
		$('#courseName').val(teacherLeave[0].courseName);
		$('#teachTeacher').val(teacherLeave[0].teacherName);
		$('#leaveType').val(teacherLeave[0].leaveType);
		$('#leaveReason').val(teacherLeave[0].leaveReason);
		$('#specificReason').val(teacherLeave[0].specificReason);
		$('.am-icon-check').attr("onclick","Approval(1,'"+teacherLeave[0].teacherLeaveNum+"')");
		$('.am-icon-remove').attr("onclick","Approval(2,'"+teacherLeave[0].teacherLeaveNum+"')"); 
		if ($("#mobileFlag").is(":hidden")) {
			for(var i=0,j=teacherLeave.length;i<j;i++){
				temp +='校历第 '+teacherLeave[i].oldSchoolweek+' 周 '+teacherLeave[i].oldDay+'日  '+
									'星期'+teacherLeave[i].oldWeek+' '+replace(teacherLeave[i].oldTime)+'节 '+
									teacherLeave[i].oldClassRoom+' 教室   调整到   校历第 '+
									teacherLeave[i].newSchoolweek+' 周 '+teacherLeave[i].newDay+'日  '+
									'星期'+teacherLeave[i].newWeek+' '+replace(teacherLeave[i].newTime)+'节 '+
									teacherLeave[i].newClassRoom+' 教室 \n';
			} 
		}else{
			for(var i=0,j=teacherLeave.length;i<j;i++){
				temp +='第 '+teacherLeave[i].oldSchoolweek+' 周 '+teacherLeave[i].oldDay+' 日 \n '+
									'星期'+teacherLeave[i].oldWeek+' '+replace(teacherLeave[i].oldTime)+'节 '+
									teacherLeave[i].oldClassRoom+' 教室   \n调整到\n第 '+
									teacherLeave[i].newSchoolweek+' 周 '+teacherLeave[i].newDay+' 日\n  '+
									'星期'+teacherLeave[i].newWeek+' '+replace(teacherLeave[i].newTime)+'节 '+
									teacherLeave[i].newClassRoom+' 教室 \n';
			}
			requirement.attr("rows",teacherLeave.length*5);
			$('.tpl-page-container').css("padding","0");
			$('#page-content').css("padding","0");
		}
		
		requirement.text(temp);
	 	}
 }
function replace(data){
	var temp;
	switch (data) {
	case '1':
		temp = '1.2';
		break;
	case '2':
		temp = '3.4';
		break;
	case '3':
		temp = '5.6';
		break;
	case '4':
		temp = '7.8';
		break;
	case '5':
		temp = '9.10';
		break;
	default:
		break;
	}
 return temp;
}
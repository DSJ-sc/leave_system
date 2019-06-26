	 var pages = null;
	 var num = null;
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
					if ($(".visible-lg-block").is(":hidden")) {
						$('body').css("background-color", "");
						$('.profile-info-value').css({"margin":"0","padding":"6px 0px 6px 0px"});
						phoneShow(1,data);
					}else{
					  	computerShow(1);
					}
			     }
			     }); 
		});	 
	
	 $(".phoneLastPage").click(function(){
		 	phoneShow(pages.pageNum-1);
	 });
	 $(".phoneNextPage").click(function(){	
			 phoneShow(pages.pageNum+1);
	 });
	 $("#phoneToPageButton").click(function(){
		 phoneShow($("#phoneToPageInput").val());
		 $("#phoneToPageInput").val("");
	 });
	 $(".computerLastPage").click(function(){
		 computerShow(pages.pageNum-1,null); 
	 });
	 $(".computerNextPage").click(function(){
		 computerShow(pages.pageNum+1,null); 
	 });
	 $("#computerToPageButton").click(function(){
		 if($("#computerToPageInput").val()>pages.pageNum){
			 computerShow(pages.pages);
		 }else if($("#computerToPageInput").val()<=0){
			 computerShow(1);
		 } else{
			 computerShow($("#computerToPageInput").val());
		 }
			
		 $("#computerToPageInput").val("");
	 });
	function computerShow(pageNum){
		$.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : '../teacher/getApprovalStudentLeave',//请求的地址
		     data : { 
		    	"pageNum":pageNum,
		    	"pageSize":3,
		     },
		     //回调函数 返回的值
		     success : function(leaveinfo) {
		    	 var tbody= $('tbody');
		    	 tbody.html("");
		    	 if(leaveinfo[0] == null){
		    		 return;
		    	 }	    
		    	 var student = leaveinfo[0];
		    	 	 pages = leaveinfo[1];
		    	 var href = null;	
		    	 for(var i=0 ,j=student.length;i<j;i++){
		    		 var leave = student[i].studentLeave;
					 for(var n=0,x=leave.length;n<x;n++){
						 if(leave[n].leaveProve==null){
							 leave[n].leaveProve = '../assets/img/no.jpg';
							 href = '';
						 }else{
							 href = ' href="'+leave[n].leaveProve+'"';
						 }
						 tbody.append('<tr class="text-center '+leave[n].studentLeaveNum+'">'
								 	+'<td style="padding-top:30px;">'+student[i].studentName+'</td>'
								 	+'<td style="padding-top:30px;">'+leave[n].className+'</td>'
								 	+'<td > <p>'+leave[n].leaveStartTime+' </p><p>至</p><p> '+leave[n].leaveEndTime+'</p></td>'
								 	+'<td style="padding-top:30px;">'+leave[n].leaveType+'</td>'
								 	+'<td> <textarea rows="2" cols="30"  readonly>'+leave[n].leaveReason+'</textarea></td>'
								 	+'<td > <a '+href+' target="_blank"> <img id="'+leave[n].studentLeaveNum+'img"  src="'+leave[n].leaveProve+'"height=60px width=60px></a></td>'
								 	+'<td style="padding-top:25px;">'+leave[n].parentPhone+'</td>'
								 	+'<td style="padding-top:25px;">'+student[i].studentPhone+'</td>'
								 	+'<td style="padding-top:25px;"> <input type="text" id="'+leave[n].studentLeaveNum+'remarks" > </td>' 
								 	+'<td style="padding-top:20px;"><b onclick="Approval(1,\''+leave[n].studentLeaveNum+'\')" class="am-btn am-btn-success am-icon-check am-round right" ></b>' 
								 	+'<b onclick="Approval(2,\''+leave[n].studentLeaveNum+'\')" class="am-btn am-btn-danger am-icon-remove am-round" ></b></td>'
								 	+'</tr>'
						 );
					 }
		    	 }
		    	 if(pages.pages<=1){
		    			$(".computerToPage").hide();
		    		}else{
		    			$(".computerToPage").show();
		    		}
		    	if(pages.pageNum<=1){
	    			 $(".computerLastPage").hide();
	    		}else{
	    			 $(".computerLastPage").show();
	    		}
	    		if(pages.pageNum==pages.pages){
	    			 $(".computerNextPage").hide();
	    		 }else{
	    			 $(".computerNextPage").show();
	    		 }
	    		$(".page").text(pages.pages);
	    		$("#computerToPageInput").val(pages.pageNum);
		     	}
		     });
	}
	
	function phoneShow(pageNum){
		$.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : '../teacher/getApprovalStudentLeave',//请求的地址
		     data : { 
		    	"pageNum":pageNum,
		    	"pageSize":1,
		     },
		     //回调函数 返回的值
		     success : function(leaveinfo) {
		    	 if(leaveinfo[0] == null){
		    		 $("#studentName").text("");
				     	$("#studentClass").text("");
				    	$("#leaveTime").text("");
				    	$("#leaveType").text("");
				    	$("#leaveReason").text("");
				    	$("#parentPhone").text("");
				    	$('#phoneimg').attr('src',"");
				    	$('#phoneLeaveNum').val("");
		    		 return;
		    	 }	
		    	 var data = leaveinfo[0]; 
		    	 var student = data[0].studentLeave;
	    	 	 		pages = leaveinfo[1];
		    		if(pages.pages<=1){
		    			$(".topages").hide();
		    		}else{
		    			$(".topages").show();
		    		}
		    		if(pages.pageNum==1){
		    			 $(".phoneLastPage").hide();
		    		}else{
		    			 $(".phoneLastPage").show();
		    		}
		    		if(pages.pageNum==pages.pages){
		    			 $(".phoneNextPage").hide();
		    		 }else{
		    			 $(".phoneNextPage").show();
		    		 }
		    	$(".page").text(pages.pages);
		    	$("#studentName").text(data[0].studentName);
		     	$("#studentClass").text(student[0].className);
		    	$("#leaveTime").text(student[0].leaveStartTime+'-'+student[0].leaveEndTime);
		    	$("#leaveType").text(student[0].leaveType);
		    	$("#leaveReason").text(student[0].leaveReason);
		    	$("#parentPhone").text(student[0].parentPhone);
		    	$('#phoneimg').attr('src',student[0].leaveProve);
		    	$('#phoneLeaveNum').val(student[0].studentLeaveNum);
		     }
	});
	}
	$('#phonePass').click(function(){
		var id = $('#phoneLeaveNum').val();
		if(id != null && id != ''){
			Approval(1,id);
		}
	});
	$('#phoneRefuse').click(function(){
		var id = $('#phoneLeaveNum').val();
		if(id != null && id != ''){
			Approval(2,id);
		}
	});
	function Approval(sign,leaveNum){
		 $.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : '../teacher/setApprovalStudentLeave',//请求的地址
		     data : { 
		      //传送的数据 名:值用逗号隔开
		     "leaveId" : leaveNum,
		     "approval":sign,
		     "remarks":$("#"+leaveNum+"remarks").val()
		     },
		     //回调函数 返回的值
		     success : function(data) {
		    	 if(data!=0){
		    		 send(num);
		    		 computerShow(pages.pageNum);
		    		 phoneShow(pages.pageNum);
		    	 }else{
		    		 alert("请求失败，请稍后再试");
		    	 }
		     }
		     }); 
	}

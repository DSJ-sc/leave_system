var pages;
	 var sno;
		$(function() {
			$.ajax({
			     async : true ,
			     type : "post",//传值方式
			     url : '../getUser',//请求的地址
			     data : { 
			    	 "identity":'student'
			     },
			     //回调函数 返回的值
			     success : function(data) {
			    		sno=data.studentSno;	
			    	$(".am-icon-user").append(data.studentName);
					if ($(".visible-lg-block").is(":hidden")) {
						$('body').css("background-color", "");
						$('.profile-info-value').css({"margin":"0","padding":"6px 0px 6px 0px"});
						phoneShow(1,null);
					}else{
					  	computerShow(1,null);
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
	 $("#computerSelectLeaveButton").click(function(){
		 if($("#computerSelectLeaveInput").val()!=''){
			 computerShow(1,sno+$("#computerSelectLeaveInput").val().replace(/-/g,""));
			 }else{
				 computerShow(1,null);
			 }
	 });
	 $("#phoneSelectLeaveButton").click(function(){
		 if($("#phoneSelectLeaveInput").val()!=''){
		 	phoneShow(1,sno+$("#phoneSelectLeaveInput").val().replace(/-/g,""));
		 }else{
			phoneShow(1,null);
		 }
	 });
	function computerShow(pageNum,leaveNum){
		
		$.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : 'queryleave',//请求的地址
		     data : { 
		    	"pageNum":pageNum,
		    	"pageSize":3,
		    	"studentSno":sno,
		    	"studentLeaveNum":leaveNum
		     },
		     //回调函数 返回的值
		     success : function(leaveinfo) {
		    	 var data = leaveinfo[0];
		    	 	 pages = leaveinfo[1];
		    	 var tbody= $('tbody');
		    		 tbody.html("");
		    	 for(var i=0,j=data.length;i<j;i++){
		    	  var remark = '';
		    	  var appro = null;
		    	  var disabled = null;
		    	 if(data[i].leaveApprovalOneRemarks != null && data[i].leaveApprovalOneRemarks != ''){
		    		 remark += '班主任:'+data[i].leaveApprovalOneRemarks+'\n';
		    	 }
		    	 if(data[i].leaveApprovalTwoRemarks != null && data[i].leaveApprovalTwoRemarks != ''){
		    		 remark += '专业主任:'+data[i].leaveApprovalTwoRemarks+'\n';
		    	 }
		    	 if(data[i].leaveApprovalThreeRemarks != null && data[i].leaveApprovalThreeRemarks != ''){
		    		 remakr += '院长:'+data[i].leaveApprovalThreeRemarks;
		    	 }
		    	  switch (data[i].leaveApprovalThree) {
		    		case '0': 
		    			appro = '<i class="am-icon-warning orange">';
						break;
					case '1':
						appro ='<i class="am-icon-check green">';
						break;
					case '2':
						appro = '<i class="am-icon-remove red">';
						break;
					}
		    	  if(data[i].leaveApprovalThree!=1||data[i].leaveCancel!=0){
		    		  disabled = 'disabled' ;
		    	  }
		    		 tbody.append('<tr class="text-center">'+
		    		'<td style="padding-top:25px;"">'+data[i].studentLeaveNum+'</td>'+
		    		'<td style="padding-top:25px;"> '+data[i].leaveStartTime+' - '+data[i].leaveEndTime+'</td>'+
		    		'<td style="padding-top:25px;">'+data[i].leaveType+'</td>'+
		    		'<td> <textarea rows="2" cols="30"  readonly>'+data[i].leaveReason+'</textarea></td>'+	    		
		    		'<td style="padding-top:25px;">'+appro+'</td>'+
		    		'<td style="padding-top:25px;">'+data[i].leaveApprovalThreeTime+'</td>'+
		    		'<td> <textarea rows="2" cols="30"  readonly>'+remark+'</textarea></td>'+
		    		'</tr>');
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
	
	function phoneShow(pageNum,leaveNum){
		$.ajax({
		     async : true ,
		     type : "post",//传值方式
		     url : 'queryleave',//请求的地址
		     data : { 
		    	"pageNum":pageNum,
		    	"pageSize":1,
		    	"studentSno":sno,
		    	"studentLeaveNum":leaveNum
		     },
		     //回调函数 返回的值
		     success : function(leaveinfo) {
		    	 var data = leaveinfo[0];
		    	     pages = leaveinfo[1];
		    	    if(data.length>0){
		    	 	var appro = null;
		    	 	var remark = '';
		    		switch (data[0].leaveApprovalThree) {
		    		case '0': 
		    			appro = '<i class="am-icon-warning orange">';
						break;
					case '1':
						appro ='<i class="am-icon-check green">';
						break;
					case '2':
						appro = '<i class="am-icon-remove red">';
						break;
					}
		    		 if(data[0].leaveApprovalOneRemarks != null && data[0].leaveApprovalOneRemarks != ''){
			    		 remark += '班主任:'+data[0].leaveApprovalOneRemarks+'<br>';
			    	 }
			    	 if(data[0].leaveApprovalTwoRemarks != null && data[0].leaveApprovalTwoRemarks != ''){
			    		 remark += '专业主任:'+data[0].leaveApprovalTwoRemarks+'<br>';
			    	 }
			    	 if(data[0].leaveApprovalThreeRemarks != null && data[0].leaveApprovalThreeRemarks != ''){
			    		 remakr += '院长:'+data[0].leaveApprovalThreeRemarks;
			    	 }
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
		    	$("#phoneToPageInput").val(pages.pageNum);
		    	$("#leaveId").text(data[0].studentLeaveNum);
		    	$("#leavetime").text(data[0].leaveStartTime+'-'+data[0].leaveEndTime);
		    	$("#leaveType").text(data[0].leaveType);
		    	$("#leaveReason").text(data[0].leaveReason);
		    	$("#leaveReply").html(appro);
				$("#replyTime").text(data[0].leaveApprovalThreeTime);
				$("#remark").html(remark);
		     	}else{
		    	 	alert("没有查询到结果");
		    	 }
		     }
	});
	}
	
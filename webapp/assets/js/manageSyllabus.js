var teacher = null;
	 var course = null;
	 var className = null;
	 var syllabus = null;
	 $(function(){
		 $.ajax({
			 async:true,
			 type:'post',
			 url:'queryTeacher',
			 success:function(data){
				 teacher = data;
			 }	 
		 });
		 $.ajax({
			 async:true,
			 type:'post',
			 url:'queryClass',
			 success:function(data){
				 className = data;
			 }
		 });
		 $.ajax({
			 async:true,
			 type:'post',
			 url:'queryCourse',
			 success:function (data){
				 course = data;
			 }
		 });
		 select();
	 });
	 function select(){
		 $('.insert').hide();
		 $('.update').hide();
		 $.ajax({
			 aysnc:true,
			 type:'post',
			 url:'querySyllabus',
			 data:{
				 'teachClass':$('.sclassName').val(),
				 'teachClassroom':$('.sclassroom').val(),
				 'teachTeacherId':$('.steacher').val(),
				 'teachCourse':$('.scourseName').val()
			 },
			 success: function (data){
				 syllabus = data;
		 var tbody = $('.selectBody');
		 tbody.html("");
		 for(var i=0,j=syllabus.length;i<j;i++){
			 var day = null;
			 switch (syllabus[i].teachDayTime) {
			case '1':
				 day = '1-2节'
				break;
			case '2':
				 day = '3-4节'
				break;
			case '3':
				 day = '5-6节'
				break;
			case '4':
				 day = '7-8节'
				break;
			case '5':
				 day = '9-10节'
				break;
			}
			 tbody.append('<tr><td><input class="checkboxs" name="checkboxs" type="checkbox" value='+syllabus[i].teachId+'></td>'		
			 				   +'<td>'+syllabus[i].teachClassroom+'</td>'
					 	  	   +'<td>'+syllabus[i].teachCourse+'</td>'
			 				   +'<td>'+syllabus[i].teachClass+'</td>'	
			 				   +'<td>'+syllabus[i].teachTeacherId+'</td>'
			 				   +'<td>'+syllabus[i].teachStartTime+'</td>'
			 				   +'<td>'+syllabus[i].teachEndTime+'</td>'
			 				   +'<td>星期'+syllabus[i].teachWeekTime+day+'</td>'
					    	   +'<td> <input class="am-btn-success am-btn-default" onclick="showUpdate('+i+')" type="button" value="修改"></td> </tr>');
			 }
		  }
		 });
		 $("form")[0].reset();
		 $('.select').show();
		 $('.am-btn-lg').show();
	 }
	 function insert(){		 
		$('.select').hide();
		$('.am-btn-lg').hide();
		$('.update').hide();
		$("form")[1].reset();
		$('.Day').html("");
		$('.Day').append(' <option selected value=""></option><option value="1">1-2节</option>'
				  +'<option value="2">3-4节</option>	<option value="3">5-6节</option>'
				  +'<option value="4">7-8节</option>	  <option value="5">9-10节</option>');
		$('.Week').html("");
		$('.Week').append('<option selected value=""></option><option value="一">星期一</option><option value="二">星期二</option>'
						  +'<option value="三">星期三</option><option value="四">星期四</option><option value="五">星期五</option>'
						  +'<option value="六">星期六</option>	<option value="日">星期日</option>');
		var Course = $('.Course');
		Course.html("");
		Course.append('<option ></option>');
		for(var i=0,j=course.length;i<j;i++){
	 			Course.append('<option  value="'+course[i].courseId+'">'+course[i].courseName+'</option>');
	 	}
		var ClassName = $('.ClassName');
		ClassName.html("");
		ClassName.append('<option ></option>');
		for(var i=0,j=className.length;i<j;i++){
	 			ClassName.append('<option  value="'+className[i].className+'">'+className[i].className+'</option>');
	 	}
		var Teacher = $('.Teacher');
		Teacher.html("");
		Teacher.append('<option ></option>');
		for(var i=0,j=teacher.length;i<j;i++){
	 			Teacher.append('<option  value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
	 	}	
		$('.insert').show();
	 }
	function insertSyllabus(){
		var info = getNewSyllabus();
		if(info.length>0){
		$.ajax({
			aysnc:true,
			type:'post',
			url:'insertSyllabus',
			data:{'syllabus':JSON.stringify(info)},
			success:function (data){
				if(data > 0){
					alert('添加成功');
				}	
			}
		});
		}
		insert();
	}
	function getNewSyllabus(){
		var classRoom = new Array();
		var course = new Array();
		var className = new Array();
		var teacher = new Array();
		var startTime = new Array();
		var endTime = new Array();
		var week = new Array();
		var day = new Array();
		var info = new Array();
		 $('.ClassRoom').each(function(){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	//添加至数组
	        	classRoom.push($(this).val());
	     });
		 $('.Course').each(function(){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	//添加至数组
	        	course.push($(this).val());
	     });
		 $('.ClassName').each(function(){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	//添加至数组
	        	className.push($(this).val().toString());
	     });
		 $('.Teacher').each(function(){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	//添加至数组
	        	teacher.push($(this).val());
	     });
		 $('.StartTime').each(function(){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	//添加至数组
	        	startTime.push($(this).val());
	     });
		 $('.EndTime').each(function(){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	//添加至数组
	        	endTime.push($(this).val());
	     });
		 $('.Week').each(function(){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	//添加至数组
	        	week.push($(this).val());
	     });
		 $('.Day').each(function(){
	        	if($(this).val()==''){
	        		return;
	        	}
	        	//添加至数组
	        	day.push($(this).val());
	     });
		for(var i=0;i<4;i++){
			if(classRoom[i]&&course[i]&&className[i]&&teacher[i]&&startTime[i]&&endTime[i]&&week[i]&&day[i]){
				var syllabus = new Object();
				syllabus.teachClassroom = classRoom[i];
				syllabus.teachCourse = course[i];
				syllabus.teachTeacherId = teacher[i];
				syllabus.teachClass = className[i];
				syllabus.teachStartTime = startTime[i];
				syllabus.teachEndTime = endTime[i];
				syllabus.teachWeekTime = week[i];
				syllabus.teachDayTime = day[i];
				info.push(syllabus);
			}
		}
		return info;
	}
	function deleteSyllabus(){
		 var syllabusName =new Array();//定义一个数组    
           $('input[name="checkboxs"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数    
           	syllabusName.push($(this).val());//将选中的值添加到数组chk_value中    
           });
		 if(confirm('确认删除所选课表信息？')){
		 $.ajax({
			 async : true ,
		     type : "post",//传值方式
		     url : '../admin/deleteSyllabus',//请求的地址
		     data : {
		    	 "syllabus":JSON.stringify(syllabusName)
		     },
		     //回调函数 返回的值
		     success : function(data) {
		    	 if(data >= 1 ){
		    		 alert("删除成功");
		    	 }
		    	 select();
		     }
		 });
		 }
	 }
	function showUpdate(){
		$('.select').hide();
		$('.am-btn-lg').hide();
		$('.insert').hide();
		var i = arguments[0];
		$('.classroom').val(syllabus[i].teachClassroom);
		$('.course').val(syllabus[i].teachCourse);
		$('.className').val(syllabus[i].teachClass);
		$('.startTime').val(syllabus[i].teachStartTime);
		$('.endTime').val(syllabus[i].teachEndTime);
		$('.teacher').val(syllabus[i].teachTeacherId);
		$('.teachId').val(syllabus[i].teachId);
		$(".week").find("option:selected").attr("selected", false);
		$(".week").find("option[value="+syllabus[i].teachWeekTime+"]").attr("selected",true);
		$(".day").find("option:selected").attr("selected", false);
		$(".day").find("option[value="+syllabus[i].teachDayTime+"]").attr("selected",true);
		$('.update').show();
	}
	function update(){
		$.ajax({
			aysnc:true,
			type:'post',
			url:'updateSyllabus',
			data:{
				'teachId':$('.teachId').val(),
				'teachStartTime':$('.startTime').val(),
				'teachEndTime':$('.endTime').val(),
				'teachWeekTime':$('.week').val(),
				'teachDayTime':$('.day').val()
			},
			success:function (data){
				if(data > 0){
					alert('修改成功');
					select();
				}
			} 
		});
	}
	 $("#checkbox").click(function(){//给全选按钮加上点击事件
	        var xz = $(this).prop("checked");//判断全选按钮的选中状态
	        $(".checkboxs").prop("checked",xz);  //让checkboxs名为qx的选项的选中状态和全选按钮的选中状态一致。  
	  });
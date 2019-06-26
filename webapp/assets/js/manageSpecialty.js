var teacher = null;
		var specialty = null;
		var faculty = null;
		 $(function(){
			 	select();
				 $.ajax({
				     async : true ,
				     type : "post",//传值方式
				     url : 'queryTeacher',//请求的地址
				     data : {
				     },
				     //回调函数 返回的值
				     success : function(data) {
							teacher = data;
				     }
				 });
				 $.ajax({
				     async : true ,
				     type : "post",//传值方式
				     url : 'queryFaculty',//请求的地址
				     //回调函数 返回的值
				     success : function(data) {
							faculty = data;
				     }
				 });
		 });
		 function select(){
			 $.ajax({
			     async : true ,
			     type : "post",//传值方式
			     url : 'querySpecialty',//请求的地址
			     data : {
			    	 "facultyName":$('.facultyName').val(),
			 		 "specialtyName":$('.specialtyName').val()
			     },
			     //回调函数 返回的值
			     success : function(data) {
			    	 specialty = data;
			    	 showSpecialty(specialty);
			     }
			     }); 
		 }
		 
		 function showSpecialty(data){ 
	  		 var tbody = $('tbody');
	  		 tbody.text("");
		    	for(var i=0,j=data.length;i<j;i++){    		
		    		tbody.append('<tr>'
		    		+'<td>'+data[i].specialtyId+'</td>'
		    		+'<td>'+data[i].specialtyName+'</td>'
		    		+'<td>'+data[i].specialtyTeacherNum+'</td>'
		    		+'<td>'+data[i].guideTeacherNum+'</td>'
		    		+'<td>'+data[i].facultyName+'</td>'
		    		+'<td> <input class="am-btn-success am-btn-default" onclick="showUpdate('+i+')" type="button" value="修改"> '
		    		+'<input class="am-btn-danger am-btn-default" onclick="deleteSpecialty(\''+data[i].specialtyId+'\')" type="button" value="删除"></td> </tr>');
		    	}
		    	}
		 function showUpdate(index){
			 $('.addSpecialty').hide();
			 var specialtyTeacher = $('#specialtyTeacher');
			 	 specialtyTeacher.html("");
			 	 specialtyTeacher.append('<option  value=""></option>');
				 	for(var i=0,j=teacher.length;i<j;i++){
				 		if(specialty[index].specialtyTeacherNum != teacher[i].teacherName){
				 			specialtyTeacher.append('<option  value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
				 		}else{
				 			specialtyTeacher.append('<option selected = "selected" value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
				 		}
				 	}
				 	 var guideTeacher = $('#guideTeacher');
				 	 guideTeacher.html("");
				 	 guideTeacher.append('<option  value=""></option>');
					 	for(var i=0,j=teacher.length;i<j;i++){
					 		if(specialty[index].guideTeacherNum != teacher[i].teacherName){
					 			guideTeacher.append('<option  value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
					 		}else{
					 			guideTeacher.append('<option selected = "selected" value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
					 		}
					 	}
			 $('#specialtyName').val(specialty[index].specialtyName);
			 $('.specialtyInfo').show();
		 }
		 function updateSpecialty(){
    		 $('.specialtyInfo').hide();
			 $.ajax({
				 async : true ,
			     type : "post",//传值方式
			     url : 'updateSpecialty',//请求的地址
			     data : {
			    	 "specialtyName":$('#specialtyName').val(),
			    	 "specialtyTeacherNum":$('#specialtyTeacher').val(),
			    	 "guideTeacherNum":$('#guideTeacher').val()
			     },
			     //回调函数 返回的值
			     success : function(data) {
			    	 if(data == 1){
			    		 alert("修改成功");
			    	 }else{
			    		 alert("修改失败");
			    	 }
			    		
			    	 select();
			     }
			 });
		 }
		 function deleteSpecialty(){
			 if(confirm('确认删除该专业吗？')){
			 $.ajax({
				 async:true,
				 type:'post',
				 url:'deleteSpecialty',
				 data:{'specialty':arguments[0]},
				 success: function (data){
					 if(data == 1){
						 alert('删除成功');
					 }else{
						 alert('删除失败');
					 }
					 select();
				 } 
				 });
			 }
		 }
		 function insert(){
			 $('.specialtyInfo').hide();
			 $('.addSpecialty').show();
			 $('#specialtyId').val("");
			 $('#SpecialtyName').val("");
			 $('#SpecialtyTeacher').text("");
			 $('#SpecialtyTeacher').append('<option  value=""></option>');
			 for(var i=0,j=teacher.length;i<j;i++){
				 $('#SpecialtyTeacher').append('<option  value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
			 }
			 $('#GuideTeacher').append('<option  value=""></option>');
			 for(var i=0,j=teacher.length;i<j;i++){
				 $('#GuideTeacher').append('<option  value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
			 }
			 $('#faculty').text("");
			 $('#faculty').append('<option  value=""></option>');
			 for(var i=0,j=faculty.length;i<j;i++){
				 $('#faculty').append('<option  value="'+faculty[i].facultyId+'">'+faculty[i].facultyName+'</option>');	
			 }
		 }
		 function insertSpecialty(){
			 var Specialty = new Object();
			 var temp = new Array();
			 Specialty.specialtyId = $('#specialtyId').val();
			 Specialty.specialtyName = $('#SpecialtyName').val();
			 Specialty.specialtyTeacherNum = $('#SpecialtyTeacher').val();
			 Specialty.facultyName = $('#faculty').val();
			 temp.push(Specialty);
			 $.ajax({
				 async:true,
			 	 type:'post',
			 	 url:'insertSpecialty',
			 	 data:{
			 		'specialty':JSON.stringify(temp)
			 	 },
			 	 success: function (data){
			 		 if(data == 1){
			 			 alert('添加成功');
			 		 }
			 		 $('.addSpecialty').hide();
			 		 select();
			 	 }
			 });
		 }
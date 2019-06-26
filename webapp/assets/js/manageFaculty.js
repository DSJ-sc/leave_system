var teacher = null;
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
		 });
		 function select(){
			 $.ajax({
			     async : true ,
			     type : "post",//传值方式
			     url : 'queryFaculty',//请求的地址
			     //回调函数 返回的值
			     success : function(data) {
			    	 faculty = data;
			    	 showFaculty(faculty);
			     }
			     }); 
		 }
		 
		 function showFaculty(data){ 
	  		 var tbody = $('tbody');
	  		 tbody.text("");
		    	for(var i=0,j=data.length;i<j;i++){    		
		    		tbody.append('<tr>'
		    		+'<td>'+data[i].facultyId+'</td>'
		    		+'<td>'+data[i].facultyName+'</td>'
		    		+'<td>'+data[i].facultyTeacherNum+'</td>'
		    		+'<td> <input class="am-btn-success am-btn-default" onclick="showUpdate('+i+')" type="button" value="修改"> '
		    		+'<input class="am-btn-danger am-btn-default" onclick="deleteFaculty(\''+data[i].facultyId+'\')" type="button" value="删除"></td> </tr>');
		    	}
		    	tbody.append('<tr><td colspan="4"><input class="am-btn-secondary am-btn-lg" type="button" onclick="insert()" value="添加学院"></td></tr>');
		    	
		    	}
		 function showUpdate(index){
			 $('.addFaculty').hide();
			 var FacultyTeacher = $('#facultyTeacher');
			 	 FacultyTeacher.html("");
			 	 FacultyTeacher.append('<option  value=""></option>');
				 	for(var i=0,j=teacher.length;i<j;i++){
				 		if(faculty[index].facultyTeacherNum != teacher[i].teacherName){
				 			FacultyTeacher.append('<option  value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
				 		}else{
				 			FacultyTeacher.append('<option selected = "selected" value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
				 		}
				 	}
			
			 $('#facultyName').val(faculty[index].facultyName);
			 $('.facultyInfo').show();
		 }
		 function updateFaculty(){
    		 $('.facultyInfo').hide();
			 $.ajax({
				 async : true ,
			     type : "post",//传值方式
			     url : 'updateFaculty',//请求的地址
			     data : {
			    	 "facultyName":$('#facultyName').val(),
			    	 "facultyTeacherNum":$('#facultyTeacher').val()
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
		 function deleteFaculty(){
			 if(confirm('确认删除该学院吗？')){
			 $.ajax({
				 async:true,
				 type:'post',
				 url:'deleteFaculty',
				 data:{'faculty':arguments[0]}, 
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
			 $('.facultyInfo').hide();
			 $('.addFaculty').show();
			 $('#FacultyId').val("");
			 $('#FacultyName').val("");
			 $('#FacultyTeacher').text("");
			 $('#FacultyTeacher').append('<option  value=""></option>');
			 for(var i=0,j=teacher.length;i<j;i++){
				 $('#FacultyTeacher').append('<option  value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
			 }
			 $('#faculty').text("");
			 $('#faculty').append('<option  value=""></option>');
			 for(var i=0,j=faculty.length;i<j;i++){
				 $('#faculty').append('<option  value="'+faculty[i].facultyId+'">'+faculty[i].facultyName+'</option>');	
			 }
		 }
		 function insertFaculty(){
			 var Faculty = new Object();
			 var temp = new Array();
			 Faculty.facultyId = $('#facultyId').val();
			 Faculty.facultyName = $('#FacultyName').val();
			 Faculty.facultyTeacherNum = $('#FacultyTeacher').val();
			 temp.push(Faculty);
			 $.ajax({
				 async:true,
			 	 type:'post',
			 	 url:'insertFaculty',
			 	 data:{
					'faculty':JSON.stringify(temp)
			 	 },
			 	 success: function (data){
			 		 if(data == 1){
			 			 alert('添加成功');
			 		 }
			 		 $('.addFaculty').hide();
			 		 select();
			 	 }
			 });
		 }
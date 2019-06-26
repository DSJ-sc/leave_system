var classInfo = null;
		var teacher = null;
		var specialty = null;
		 $(function(){
			 	select();
				 $.ajax({
				     async : true ,
				     type : "post",//传值方式
				     url : '../admin/getTeacherAndSpecialty',//请求的地址
				     data : {
				     },
				     //回调函数 返回的值
				     success : function(data) {
							teacher = data[0];
							specialty = data[1];
				     }
				 });
		 });
		 function select(){
			 $.ajax({
			     async : true ,
			     type : "post",//传值方式
			     url : '../admin/queryClass',//请求的地址
			     data : {
			    	 "className":$('.className').val(),
			 		 "classHeadTeacher":$('.classHeadTeacher').val(),
			 		 "classGuideTeacher":$('.classGuideTeacher').val(),
			 		 "specialtyName":$('.specialtyName').val(),
			    	 "classGrade":$('.classGrade').val()
			     },
			     //回调函数 返回的值
			     success : function(data) {
			    	 classInfo = data;
			    	 showClass(classInfo);
			     }
			     }); 
		 }
		 
		function insert(){
			clearInfo();
			$('.updateClass').hide();
			$('.addClass').show();
			$('.classInfo').show();
			var classHeadTeacher = $('#classHeadTeacher');
		 	 classHeadTeacher.html("");
		 	 classHeadTeacher.append('<option  value=""></option>');
			 	for(var i=0,j=teacher.length;i<j;i++){
			 			classHeadTeacher.append('<option  value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
			 	}
		var specialtyName = $('#specialtyName');
			specialtyName.html("");
			specialtyName.append('<option  value=""></option>');
				for(var i=0,j=specialty.length;i<j;i++){
					specialtyName.append('<option value="'+specialty[i].specialtyId+'">'+specialty[i].specialtyName+'</option>');
				}
		}
		 function showClass(data){ 
	  		 var tbody = $('tbody');
	  		 tbody.text("");
		    	for(var i=0,j=data.length;i<j;i++){    		
		    		tbody.append('<tr>'
		    		+'<td><input class="checkboxs" name="checkboxs" type="checkbox" value='+data[i].className+'></td>'		
		    		+'<td>'+data[i].className+'</td>'
		    		+'<td>'+data[i].classHeadTeacher+'</td>'
		    		+'<td>'+data[i].classGuideTeacher+'</td>'
		    		+'<td>'+data[i].specialtyName+'</td>'
		    		+'<td>'+data[i].classGrade+'</td>'
		    		+'<td>'+data[i].classStudentNum+'</td>'
		    		+'<td> <input class="am-btn-success am-btn-default" onclick="showUpdate('+i+')" type="button" value="修改"></td> </tr>');
		    	}
		    	tbody.append('<tr><td colspan="8"><input class="am-btn-secondary am-btn-lg" type="button" onclick="deleteClass()" value="删除选中班级"></td></tr>');
		 }
		 function showUpdate(index){
			 $('.updateClass').show();
				$('.addClass').hide();
			 var className =  $('#className');
				 className.val(classInfo[index].className);
				 className.attr("readonly","readonly");
			 var classHeadTeacher = $('#classHeadTeacher');
			 	 classHeadTeacher.html("");
			 	 classHeadTeacher.append('<option  value=""></option>');
				 	for(var i=0,j=teacher.length;i<j;i++){
				 		if(classInfo[index].classHeadTeacher != teacher[i].teacherName){
				 			classHeadTeacher.append('<option  value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
				 		}else{
				 			classHeadTeacher.append('<option selected = "selected" value="'+teacher[i].teacherNum+'">'+teacher[i].teacherName+'</option>');
				 		}
				 	}

			var specialtyName = $('#specialtyName');
				specialtyName.html("");
				specialtyName.append('<option>'+classInfo[index].specialtyName+'</option>');
			 $('#classGrade').val(classInfo[index].classGrade);
			 $('#classGrade').attr("readonly","readonly");
			 $('#studentSum').val(classInfo[index].classStudentNum);
			 $('.classInfo').show();
		 }
		 function updateClass(){
    		 $('.classInfo').hide();
			 $.ajax({
				 async : true ,
			     type : "post",//传值方式
			     url : '../admin/updateClass',//请求的地址
			     data : {
			    	 "className":$('#className').val(),
			 		 "classHeadTeacher":$('#classHeadTeacher').val(),
			    	 "classStudentNum":$('#studentSum').val()
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
		 function insertClass(){
    		 $('.classInfo').hide();
    		 var Class = new Object();
    		 var temp = new Array();
    		 Class.className = $('#className').val();
    		 Class.classHeadTeacher = $('#classHeadTeacher').val();
    		 Class.classStudentNum = $('#studentSum').val();
    		 Class.specialtyName = $('#specialtyName').val();
    		 Class.classGrade = $('#classGrade').val();
    		 temp.push(Class)
			 $.ajax({
				 async : true ,
			     type : "post",//传值方式
			     url : '../admin/insertClass',//请求的地址
			     data : {
			    	 "classInfo":JSON.stringify(temp)

			     },
			     //回调函数 返回的值
			     success : function(data) {
			    	 if(data == 1){
			    		 if(confirm("添加成功是否继续")){
			    			 insert();
			    		 }else{
			    			 $('.classInfo').hide();
			    		 }
			    	 }else{
			    		 alert("添加失败");
			    	 }
			    		
			    	 select();
			     }
			 });
		 }
		 function clearInfo(){
			 $('#className').val("");
			 $('#className').removeAttr("readonly");
			 $('#classHeadTeacher').text("");
			 $('#classGuideTeacher').text("");
			 $('#specialtyName').text("");
			 $('#classGrade').val("");
			 $('#classGrade').removeAttr("readonly");
			 $('#studentSum').val("");
		 }
		 function deleteClass(){
			 var className =new Array();//定义一个数组    
	            $('input[name="checkboxs"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数    
	            	className.push($(this).val());//将选中的值添加到数组chk_value中    
	            });
			 if(confirm('确认删除'+className.toString()+'班？')){
			 $.ajax({
				 async : true ,
			     type : "post",//传值方式
			     url : '../admin/deleteClass',//请求的地址
			     data : {
			    	 "className":JSON.stringify(className)
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
		 $("#checkbox").click(function(){//给全选按钮加上点击事件
		        var xz = $(this).prop("checked");//判断全选按钮的选中状态
		        $(".checkboxs").prop("checked",xz);  //让checkboxs名为qx的选项的选中状态和全选按钮的选中状态一致。  
		  });
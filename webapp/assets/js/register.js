 $(function(){
    	 $.ajax({
    		 async:true,
    		 type:"post",
    		 url:"getFaculty",
    		 success: function (data) {
				faculty = $('#teacherFaculty');
				faculty.text("");
				faculty.append("<option selected value=''></option>")
				for(var i=0,j=data.length;i<j;i++){
					faculty.append("<option value='"+data[i].facultyId+"'>"+data[i].facultyName+"</option>");
				}
			}
    		 
    	 });
     });
     $('#teacherFaculty').change(function(){
    	 $.ajax({
             async:true,
             type:"post",
             url:"getSpecialty",
             data:{faculty:$('#teacherFaculty').val()},
             success: function (data) {
                specialty = $('#teacherSpecialty');
                specialty.text("");
                specialty.append("<option  value=''></option>")
                for(var i=0,j=data.length;i<j;i++){
                	specialty.append("<option value='"+data[i].specialtyId+"'>"+data[i].specialtyName+"</option>");
                }
            }
             
         });
     });
     
     $('#teacherPassword1').keyup(function(){
    	 if( $('#teacherPassword1').val() !=  $('#teacherPassword').val()){
    		 $('.password').show();
    	 }else{
    		 $('.password').hide();
    	 }
     });
     $('#teacherPassword').keyup(function(){
         if( $('#teacherPassword1').val() !=  $('#teacherPassword').val()){
             $('.password').show();
         }else{
             $('.password').hide();
         }
     });
     $('#teacherPhone').keyup(function(){
    	 if(!(/^1(3|4|5|7|8)\d{9}$/.test($('#teacherPhone').val()))){
    		 $('.phone').show();
    	 }else{
    		 $('.phone').hide();
    	 }
     });
     function register(){
    	 var teacherName=$("#teacherName").val();
    	 var teacherUname=$("#teacherUname").val();
    	 var teacherPassword=$("#teacherPassword").val();
    	 var teacherSex=$("#teacherSex").val();
    	 var teacherFaculty=$("#teacherFaculty").val();
    	 var teacherSpecialty=$("#teacherSpecialty").val();
    	 var teacherPhone=$("#teacherPhone").val();
    	 var fullTeacher=$("#fullTeacher").val();
    	 var teacherPost=$("#teacherPost").val();
    	 if(teacherName != '' && teacherUname != '' && teacherPassword != '' && teacherFaculty != '' && teacherSpecialty != ''
    		 && teacherPhone != '' && $("small").is(":hidden") ){
	    	$.ajax({
	    		async:true,
	    		type:"post",
	    		url:"registers",
	    		data:{
	    			"teacherName":teacherName,
	    			"teacherUname":teacherUname,
	    			"teacherPassword":teacherPassword,
	    			"teacherSex":teacherSex,
	    			"teacherFaculty":teacherFaculty,
	    			"teacherSpecialty":teacherSpecialty,
	    			"teacherPhone":teacherPhone,
	    			"fullTeacher":fullTeacher,
	    			"teacherPost":teacherPost
	    		},
	    		success :function (data){
	    			if(data == 1){
	    				alert('注册成功，请等待管理员审核');
	    				window.location.replace("login.html");
	    			}
	    		}
	    	});
       }else{
    	  alert("请输入正确完整得信息");
      }
     }
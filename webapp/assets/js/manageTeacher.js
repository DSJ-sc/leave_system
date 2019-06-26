 var teacher = null;
	 var newTeacher = null;
	 var faculty = null;
	 var specialty = null;
	 $(function(){
		 $.ajax({
			 async:true,
			 type:'post',
			 url:'../getFaculty',
			 success:function(data){
				 faculty = data;	 
			 }
		 });
		 $.ajax({
             async:true,
             type:'post',
             url:'../getSpecialty',
             data:{
            	 "faculty":null,
             },
             success:function(data){
                 specialty = data; 
             }
         });
	
		 select();
	 });
	 function selectSepcialty(){
		 var index = arguments[0];
		 var Specialty =	$('.Specialty').eq(index);
			Specialty.html("");
			Specialty.append('<option value="" selected>请选择专业</option>')
		 if($('.Faculty').eq(index).val() != ''){
			 $.ajax({
				 async:true,
				 type:'post',
				 url:'querySpecialty',
				 data:{
					 'facultyName':$('.Faculty').eq(index).val()
				 },
				 success:function(specialty){
					
					for(var i=0,j=specialty.length;i<j;i++)
					Specialty.append('<option value="'+specialty[i].specialtyId+'">'+specialty[i].specialtyName+'</option>')
				 }	 
			 });
		 }
	 }
	 
	 function select(){
		 $('.insert').hide();
		 $('.update').hide();
		 $('.insertTbody').html("");
		 $('.select').show();
		 $('.am-btn-lg').show();
		 $.ajax({
			 aysnc:true,
			 type:'post',
			 url:'queryTeacher',
			 data:{
				 'teacherName':$('.teacher').val(),
				 'teacherSpecialty':$('.tspecialty').val(),
				 'teacherFaculty':$('.tfaculty').val()
			 },
			 success: function (data){
				 teacher = data;
				 var tbody = $('.selectBody');
				 tbody.html("");
				 for(var i=0,j=data.length;i<j;i++){
					 var temp = null;
					 var post = null;
					 if(data[i].fullTeacher){
						 temp = '否'
						}else{
						 temp ='是'
						}
					 switch (data[i].teacherPost) {
					case "006":
						  post = "普通教师";
						break;
					case "005":
                        post = "班主任";
                      break;
					case "004":
                        post = "导员";
                      break;
					case "003":
                        post = "专业主任";
                      break;
					case "002":
                        post = "学院院长";
                      break;
					case "001":
                        post = "教务处";
                      break;
					case "000":
                        post = "教务处长";
                      break;
					}
					 tbody.append('<tr><td><input class="checkboxs" name="checkboxs" type="checkbox" value='+data[i].teacherNum+'></td>'
							 		   +'<td>'+data[i].teacherNum+'</td>'
					 				   +'<td>'+data[i].teacherUname+'</td>'
							 	  	   +'<td>'+data[i].teacherPassword+'</td>'
					 				   +'<td>'+data[i].teacherName+'</td>'	
					 				   +'<td>'+data[i].teacherSex+'</td>'
					 				   +'<td>'+data[i].teacherFaculty+'</td>'
					 				   +'<td>'+data[i].teacherSpecialty+'</td>'
					 				   +'<td>'+post+'</td>'
					 				   +'<td>'+data[i].teacherPhone+'</td>'
					 				   +'<td>'+temp+'</td>'
							    	   +'<td> <input class="am-btn-success am-btn-default" onclick="showUpdate('+i+')" type="button" value="修改"></td> </tr>');
					 }
				  }
				 });
		 $("form")[0].reset();
	 }
	 function insert(){	
		
		$('.select').hide();
		$('.am-btn-lg').hide();
		$('.update').hide();
		$.ajax({
			async:true,
			type:'post',
			url:'../getWaitTeacher',
			success: function (data){
				newTeacher = data;
				var tbody = $('.insertTbody');
                tbody.html("");
                for(var i=0,j=data.length;i<j;i++){
                    var temp = null;
                    var teaFaculty = null;
                    var teaSpecialty = null;
                    var post = null;
                    var temp = data[i].fullTeacher ? '否':'是';
                    for(var x=0,y=faculty.length;x<y;x++){
                    	if(faculty[x].facultyId == data[i].teacherFaculty){
                    		teaFaculty = faculty[x].facultyName;
                    		break;
                    	}
                    }
					for(var x=0,y=specialty.length;x<y;x++){
						if(specialty[x].specialtyId == data[i].teacherSpecialty){
                            teaSpecialty = specialty[x].specialtyName;
                            break;
                        }                  
                    }
				    switch (data[i].teacherPost) {
                    case "006":
                          post = "普通教师";
                        break;
                    case "005":
                        post = "班主任";
                      break;
                    case "004":
                        post = "导员";
                      break;
                    case "003":
                        post = "专业主任";
                      break;
                    case "002":
                        post = "学院院长";
                      break;
                    case "001":
                        post = "教务处";
                      break;
                    }
                    tbody.append('<tr>'
                                      +'<td style="padding-top:10px;">'+data[i].teacherNum+'</td>'
                                      +'<td style="padding-top:10px;">'+data[i].teacherUname+'</td>'
                                      +'<td style="padding-top:10px;">'+data[i].teacherPassword+'</td>'
                                      +'<td style="padding-top:10px;">'+data[i].teacherName+'</td>'  
                                      +'<td style="padding-top:10px;">'+data[i].teacherSex+'</td>'
                                      +'<td style="padding-top:10px;">'+teaFaculty+'</td>'
                                      +'<td style="padding-top:10px;">'+teaSpecialty+'</td>'
                                      +'<td style="padding-top:10px;">'+post+'</td>'
                                      +'<td style="padding-top:10px;">'+data[i].teacherPhone+'</td>'
                                      +'<td style="padding-top:10px;">'+temp+'</td>'
                                      +'<td ><b onclick="Approval(1,'+i+')" class="am-btn-xs am-btn am-btn-success am-icon-check am-round right" ></b>' 
                                      +' <b onclick="Approval(2,'+i+')" class="am-btn-xs am-btn am-btn-danger am-icon-remove am-round" ></b></td></tr>');
                    }      
			}	    
		});
				
				$('.insert').show();
	 }
    function Approval(){
    	if(arguments[0] == 1){
	    	$.ajax({
	    		async:true,
	    		type:'post',
	    		url:'insertTeacher',
	    		data:{
	    			"addteacher":JSON.stringify(newTeacher[arguments[1]])
	    		},
	    		success :function (data){
	    			if(data < 0){
	    				alert("操作失败");
	    			}
	    		}
	    	});
    	}
    	$.ajax({
            async:true,
            type:'post',
            url:'../delTeacher',
            data:{
                "delTeacher":newTeacher[arguments[1]].teacherNum
            },
            success :function (data){
                if(data > 0){
                   insert();
                }
            }
        });
    }
	
	function deleteTeacher(){
		 var teacher =new Array();//定义一个数组    
           $('input[name="checkboxs"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数    
           	teacher.push($(this).val());//将选中的值添加到数组chk_value中    
           });
		 if(confirm('确认删除选中教师？')){
		 $.ajax({
			 async : true ,
		     type : "post",//传值方式
		     url : '../admin/deleteTeacher',//请求的地址
		     data : {
		    	 "delteacher":JSON.stringify(teacher)
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
		var i = arguments[0];
		$('.select').hide();
		$('.am-btn-lg').hide();
		$('.teacherNum').val(teacher[i].teacherNum);
		$('.teacherName').val(teacher[i].teacherName);
		$('.teacherUname').val(teacher[i].teacherUname);
		$('.teacherPassword').val(teacher[i].teacherPassword);
		$('.faculty').val(teacher[i].teacherFaculty);
		$('.specialty').val(teacher[i].teacherSpecialty);
		$('.sex').val(teacher[i].teacherSex);
		$('.teacherPhone').val(teacher[i].teacherPhone);
		$(".teacherPost").find("option:selected").attr("selected", false);
		$(".teacherPost").find("option[value="+teacher[i].teacherPost+"]").attr("selected",true);
		$(".fullTeacher").find("option:selected").attr("selected", false);
		$(".fullTeacher").find("option[value="+teacher[i].fullTeacher+"]").attr("selected",true);
		$('.update').show();
	}
	function update(){
		$.ajax({
			aysnc:true,
			type:'post',
			url:'updateTeacher',
			data:{
				'teacherNum':$('.teacherNum').val(),
				'teacherUname':$('.teacherUname').val(),
				'teacherPassword':$('.teacherPassword').val(),
				'teacherName':$('.teacherName').val(),
				'teacherPost':$('.teacherPost').val(),
				'teacherPhone':$('.teacherPhone').val(),
				'fullTeacher':$('.fullTeacher').val()
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
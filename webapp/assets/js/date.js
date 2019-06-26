 	var nowTemp = new Date();
    var nowDay = nowTemp.getFullYear()+'-'+(nowTemp.getMonth()+1)+'-'+nowTemp.getDate();
    $.fn.datetimepicker.dates['zh-CN'] = {
			days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
			daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
			daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
			months: ["一月  ", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
			monthsShort: ["一月   ", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
			today: "今天",
			suffix: [],
			meridiem: ["上午", "下午"],
			rtl: false
		};
		$('#leaveStartTime').datetimepicker({
			minView:'day',
			format: 'yyyy-mm-dd hh:00',
			language:  'zh-CN', 
			startDate:nowDay,
			autoclose: 1
		});
		$('#leaveEndTime').datetimepicker({
			minView:'day',
			format: 'yyyy-mm-dd hh:00',
			language:  'zh-CN', 
			startDate:nowDay,
			autoclose: 1
		});
	$('#monthTimeInput').datetimepicker({
		startView: 3,
		minView:'year',
		format: 'yyyy-mm',
		language:  'zh-CN',
		autoclose: 1
	});
	$('.oldDay').datetimepicker({
		startView: 2,
		minView:2,
		format: 'yyyy-mm-dd',
		language:  'zh-CN',
		startDate:nowDay,
		autoclose: 1
	});
	$('.newDay').datetimepicker({
		startView: 2,
		minView:2,
		format: 'yyyy-mm-dd',
		language:  'zh-CN',
		startDate:nowDay,
		autoclose: 1
	});
	$('#yearTimeInput').datetimepicker({
		startView: 4,
		minView:4,
		format: 'yyyy',
		language:  'zh-CN',
		autoclose: 1
	});
	$('#phoneSelectLeaveInput').datetimepicker({
		startView: 2,
		minView:2,
		format: 'yyyy-mm-dd',
		language:  'zh-CN',
		autoclose: 1
	});
	$('#computerSelectLeaveInput').datetimepicker({
		startView: 2,
		minView:2,
		format: 'yyyy-mm-dd',
		language:  'zh-CN',
		autoclose: 1
	});
	$('.syllabusTime').datetimepicker({
		startView: 2,
		minView:2,
		format: 'yyyy-mm-dd',
		language:  'zh-CN',
		autoclose: 1
	});
$(".datetimepicker").css("padding-top","0");
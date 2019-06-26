var lockReconnect = false;  //避免ws重复连接
var ws = null;          // 判断当前浏览器是否支持WebSocket
var wsUrl = '';
  //连接ws
function linkWebsocket(num){	
	wsUrl = 'ws://' + window.location.host
	+ '/leave/websocket/' + num;
	createWebSocket(wsUrl); 
}

function send(){
ws.send(arguments[0]);
}
function createWebSocket(url) {
    try{
        if('WebSocket' in window){
            ws = new WebSocket(url);
        }else if('MozWebSocket' in window){  
            ws = new MozWebSocket(url);
        }else{   
              alert("您的浏览器不支持websocket协议,建议使用新版谷歌、火狐等浏览器，请勿使用IE10以下浏览器，360浏览器请使用极速模式，不要使用兼容模式！"); 
        }
        initEventHandle();
    }catch(e){
        reconnect(url);
        console.log(e);
    }     
}

function initEventHandle() {
    ws.onclose = function () {
        reconnect(wsUrl);
    };
    ws.onerror = function () {
        reconnect(wsUrl);
    };
    ws.onopen = function () {
        heartCheck.reset().start();      //心跳检测重置
    };
    ws.onmessage = function (event) {    //如果获取到消息，心跳检测重置
        heartCheck.reset().start();      //拿到任何消息都说明当前连接是正常的
        if(event.data!='ping'){
        	remind(eval("("+event.data+")"));
        }
    };
}

function remind(data){
	var studentLaveInfo = $('#studentLeaveInfo');
	var studentLeavSum = $('.studentLeaveSum');
	var teacherLeaveInfo = $('#teacherLeaveInfo');
	var teacherLeaveSum = $('.teacherLeaveSum');
	var stuSum = 0;
	var teaSum = 0;
	studentLaveInfo.text("");
	teacherLeaveInfo.text("");
	if(data != 0){
		for(var i = 0,j=data.length;i<j;i++){
			if(data[i].type == 'student'){
				stuSum ++;
				if(stuSum<4){
					studentLaveInfo.append('<li style="cursor:pointer;" onclick="location=\'approvalStudent.html\'">'+data[i].content+'&nbsp '+data[i].applyTime+'</li>');
				}
				
			}else{
				teaSum++;
				if(teaSum<4){
				teacherLeaveInfo.append('<li style="cursor:pointer;" onclick="location=\'approvalTeacher.html\'">'+data[i].content+'&nbsp '+data[i].applyTime+'</li>');
				}
				
			}
			studentLeavSum.text(stuSum);
			teacherLeaveSum.text(teaSum);
		}
		if(stuSum>3){
			studentLaveInfo.append('<li style="cursor:pointer;" onclick="location=\'approvalStudent.html\'">***</li>');
		}
		if(teaSum>3){
			teacherLeaveInfo.append('<li style="cursor:pointer;" onclick="location=\'approvalTeacher.html\'">***</li>');
			
		}
	 $('.newsSum').text(data.length);
	}else{
		studentLeavSum.text(stuSum);
		teacherLeaveSum.text(teaSum);
		$('.newsSum').text("");
	}
}

// 监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function() {
    ws.close();
}  
//监听浏览器回退事件
window.onpagehide = function(event) {
	ws.close();
}
function reconnect(url) {
    if(lockReconnect) return;
    lockReconnect = true;
    setTimeout(function () {     //没连接上会一直重连，设置延迟避免请求过多
        createWebSocket(url);
        lockReconnect = false;
    }, 2000);
}

//心跳检测
var heartCheck = {
    timeout: 540000,        //9分钟发一次心跳
    timeoutObj: null,
    serverTimeoutObj: null,
    reset: function(){
        clearTimeout(this.timeoutObj);
        clearTimeout(this.serverTimeoutObj);
        return this;
    },
    start: function(){
        var self = this;
        this.timeoutObj = setTimeout(function(){
            //这里发送一个心跳，后端收到后，返回一个心跳消息，
            //onmessage拿到返回的心跳就说明连接正常
            ws.send("ping");
            self.serverTimeoutObj = setTimeout(function(){//如果超过一定时间还没重置，说明后端主动断开了
                ws.close();     //如果onclose会执行reconnect，我们执行ws.close()就行了.如果直接执行reconnect 会触发onclose导致重连两次
            }, self.timeout)
        }, this.timeout)
    }
}
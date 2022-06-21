window.onload = initAll;

let stompClient;

function initAll(){
	
	let socket = new SockJS("http://localhost:8080/codifers-chat/chatCodifers");
	stompClient = Stomp.over(socket);
	
	stompClient.connect({},function(frame){
		
		
		console.log("Connected");
		stompClient.subscribe("/topic/messages/"+currentUser.userName,function(response){
			appendResponseMessage(JSON.parse(response.body));
			
		});
	});
	
	/*var btn = document.getElementById("sendMsg");
	btn.addEventListener("click", function(){
		
		
	});*/
	
}

function sendMessage(){
	
	let msg = document.getElementById("message").value;
	let currentTime = new Date();
//	let currentLocalTime = currentTime.toLocaleString();
	let json = {

			message: msg,
			dateTime: currentTime,
			msgFrom: currentUser,
			msgTo: selectedUser

	};
	appendRequestMessage(json);
	/*scrollToBottom();*/
	stompClient.send("/app/chatCodifers/"+selectedUser.userName,{}, JSON.stringify(json));
	
}
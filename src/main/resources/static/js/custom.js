var messageBoxInitialString = '<div class="row" style="height:fit-content;overflow-y: scroll;max-height: 89%" id="chatHistory">'
var messageBoxLastString = '</div><div class="row textMessage border" ><div class="col col-lg-12 col-md-12 col-sm-12 col-xs-12"><div class="row"><div class="col col-lg-10 col-md-10 col-sm-10 col-xs-10" style="padding: 10px"><textarea rows="1" class="form-control" id="message" name="message" placeholder="Start Typing..."></textarea></div><div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-center" style="padding: 10px"><button class="btn btn-warning btn-rounded my-0" id="sendMsg" onclick="sendMessage()" type="button">Send</button></div></div></div></div>';
var selectedUser = null;
function selectUser(clientUser){
	selectedUser = clientUser;
	$('#messageBox').html('');
	
	console.log(JSON.stringify(clientUser));
	getAllMessages(clientUser);
	
}

function getAllMessages(clientUser){
	
	console.log(clientUser);
	let json = {
			
			msgFrom: currentUser,
			msgTo: clientUser
	}; 
	
	$.ajax({
		
		url: serverURL+"get-all-messages",
		type: "POST",
		contentType: "application/json",
		data: JSON.stringify(json),
		dataType: "json",
		success: function(result){
			let messageBoxMiddleString = '';
			jQuery.each(result, function(i, message) {
				
				if(message.msgFrom.id == currentUser.id){
					messageBoxMiddleString = messageBoxMiddleString + '<div class="row requestMessage border rounded-right"><div class="col col-lg-12 text-center p-3">' + message.message + '</div></div>';
				}else{
					messageBoxMiddleString = messageBoxMiddleString + '<div class="row responseMessage border rounded-right"><div class="col col-lg-12 text-center p-3">' + message.message + '</div></div>';
				}
				
				});
			let finalString = messageBoxInitialString + messageBoxMiddleString + messageBoxLastString;
			$('#messageBox').html(finalString);
		}
		
			
	});
}

function appendRequestMessage(messageDTO){
	$('#chatHistory').append('<div class="row requestMessage border rounded-right"><div class="col col-lg-12 text-center p-3">' + messageDTO.message + '</div></div>')
}

function appendResponseMessage(messageDTO){
	$('#chatHistory').append('<div class="row responseMessage border rounded-right"><div class="col col-lg-12 text-center p-3">' + messageDTO.message + '</div></div>')
}

/*function scrollToBottom() {
    $("#chatHistory").animate({ scrollTop: $("#chatHistory")[1].scrollHeight }, 1000);
}*/


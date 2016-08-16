var stompClient = null;
        
function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
}

function connect() {
    var socket = new SockJS('/chatPage');
    
    stompClient = Stomp.over(socket);            
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat/broadcast', function(broadcast){
        	processMessage(JSON.parse(broadcast.body).content);
            
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    var message = document.getElementById('messageText').value;
    stompClient.send("/app/chatPage", {}, JSON.stringify({ 'message': message }));
    messageText.value = "";
}

function processMessage(message){
	if(message != null){
		messagesTextArea.value += message + "\n";
	}
}

var ws;

function login() {
	var userName = document.getElementById('userName').value;
	console.log('User name ' + userName);
	ws = new WebSocket("ws://localhost:8080/WebSocket1/chat/" + userName);
	ws.onopen = function (event) {
		console.log('Opened ');
//		ws.send('Logged in');
	}
	ws.onclose = function (event) {
		console.log('Closed ');
	}
	ws.onmessage = function (message) {
		var msg = message.data;
		console.log('Received ' + msg);
		document.getElementById('chat').value += '\n' + msg;
	}
}

function sendMessage() {
	var msg = document.getElementById('message').value;
	console.log('Sending message ' + msg);
	ws.send(msg);
}

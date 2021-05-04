
var messageInput = document.querySelector('#msg');


var stompClient = null;
var username = null;

function connect(event) {
   /* username = document.querySelector('#name').value.trim();*/
    username = document.getElementById("userName").value;


    if(username) {


        var socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected);
    }
    event.preventDefault();
}

function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe("/topic/messages"+username, onMessageReceived);

    // Tell your username to the server
    /*stompClient.send("/app/chat.register",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )*/
}

/*function sendMsg(userSend,msg) {
    stompClient.send("/app/chat"+selectedUser,{},JSON.stringify({
        sender:userSend,
        message:msg
    }));
}*/
function send(event) {
    var messageContent = messageInput.value.trim();

    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            message: messageInput.value,
            /*type: 'CHAT'*/
        };

        stompClient.send("/app/chat"+selectedUser, {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}

function selectUser(userName) {
    console.log("selecting users: " + userName);
    selectedUser = userName;
    let isNew = document.getElementById("newMessage_" + userName) !== null;
    if (isNew) {
        let element = document.getElementById("newMessage_" + userName);
        element.parentNode.removeChild(element);
        render(newMessages.get(userName), userName);
    }
    selectedUserId = document.getElementById("#selectedUserId");
    selectedUserId.getElementsByTagName('h5')[0].outerHTML='';
    selectedUserId.getElementsByTagName('h5')[0].outerHTML='<h5><a href="#">'+userName+'</a></h5>';
    /*$('#selectedUserId').html('');
    $('#selectedUserId').append('Chat with ' + userName);*/
}






function fetchAll() {
    urlParm = url +"/AllUsers";
    let users = httpGet(urlParm);
    console.log(users);

    var userTemplateHTML =document.querySelector('#userU');
    var contacts = document.querySelector('#contacts');
    console.log(users[1].fullName);
    for(let i=0; i<5;i++) {
        userTemplateHTML.getElementsByTagName('a')[0].setAttribute("onclick", selectUser(users[i].fullName));
        userTemplateHTML.getElementsByTagName('h5')[0].outerHTML = "<h5>"+users[i].fullName+"</h5>";
        contacts.appendChild(userTemplateHTML);
    }

}
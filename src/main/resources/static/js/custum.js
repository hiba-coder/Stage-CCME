
var chatHistory = document.querySelector('#chat-history');
let button = document.querySelector('#sendBtn');
let textarea  = document.querySelector('#msg');
let chatHistoryList;
let i = 0;


function init() {
    //cacheDOM();
    chatHistory.innerHTML="";
    bindEvents();
    gotochat();
    AllUsers();
}

function bindEvents() {
    //button.on('click', addMessage.bind(this));
    //textarea.on('keyup', addMessageEnter.bind(this));
    textarea.addEventListener('keyup',addMessageEnter.bind(this));
}
/*
function cacheDOM() {
    chatHistory = $('.chat-history');
    button = $('#sendBtn');
    textarea = $('#message-to-send');
    chatHistoryList = $chatHistory.find('ul');
}
*/
/*function render(message, userName) {
    //scrollToBottom();
    // responses
    var templateResponse = Handlebars.compile(document.querySelector('#message-response-template').html());
    var contextResponse = {
        response: message,
        time: getCurrentTime(),
        userName: userName
    };

    setTimeout(function () {
        chatHistory.append(templateResponse(contextResponse));
        //scrollToBottom();
    }.bind(this), 1500);
}
*/
function render(message, user){

    let temp ,cln , div ;

    temp = document.querySelector("#message-response-template");
    cln = temp.cloneNode(true);
    div = cln.textContent;
    if(i==0) chatHistory.innerHTML = div ;

    var me = document.querySelector("#other");


    document.querySelector("#img").setAttribute("src","data:image/jpeg;base64,"+user.image);
    document.querySelector("#renvoi").outerHTML = '<p id="recoi">'+message+'</p>';
    document.querySelector("#span").outerHTML='<span id="spann">'+getCurrentTime()+'</span>';
    //chatHistory.appendChild(me.cloneNode(true));
    if(i>0)  {
        chatHistory.appendChild(me.cloneNode(true));
    }

}

function sendMessage(message) {
    urlParm = url +"/AllUsers/returnUser";
    let user = httpGet(urlParm);
    console.log(user.fullName);
    sendMsg(user.fullName, message);
    //scrollToBottom();

    if (message.trim() !== '') {

        let temp ,cln , div ;

        temp = document.querySelector("#message-template");
        cln = temp.cloneNode(true);
        div = cln.textContent;
        if(i==0) chatHistory.innerHTML = div ;

        var me = document.querySelector("#me");


        document.querySelector("#renvoi").outerHTML = '<p id="renvoi">'+message+'</p>';
        document.querySelector("#span").outerHTML='<span id="span">'+getCurrentTime()+'</span>';
        //chatHistory.appendChild(me.cloneNode(true));
        if(i>0)  {
            chatHistory.appendChild(me.cloneNode(true));
        }
        //if(i==1) chatHistory.getElementsByTagName("div")[0].innerHTML = '';

        /* if(i==0) {
             me.outerHTML = '<div class="message me" id="m">';
             document.querySelector("#m").innerHTML='';
             document.querySelector("#m").outerHTML = '<div class="message me" id="me">';
         }*/

        // var m =document.querySelector("#m");
        // chatHistory.innerHTML = m ;


        //var template = Handlebars.compile(document.querySelector('#message-template').html());//me
        // var context = {
        //     messageOutput: message,
        //     time: getCurrentTime(),
        //     toUserName: selectedUser
        // };
        //cln.getElementsByTagName('span')[0].outerHTML = "<span class=\"message-data-time\">, Today</span> &nbsp; &nbsp;";

        // temp.getElementsByTagName('div')[1].outerHTML = "<div class=\"message other-message float-right\">"+message+"</div>";
        // var me = document.querySelector("#me");
        // me.getElementsByTagName("p")[0].outerHTML = '<p id="renvoi">'+message+'</p>';
        // me.getElementsByTagName("span")[0].outerHTML='<span id="span">'+getCurrentTime()+'</span>';
        // chatHistory.appendChild(me.cloneNode(true));


        //chatHistory.append(div);
        //scrollToBottom();
        //$textarea.val('');
        textarea.value = '';
    }
}

function scrollToBottom() {
    chatHistory.scrollTop(chatHistory[0].scrollHeight);
}

function getCurrentTime() {
    return new Date().toLocaleTimeString().replace(/([\d]+:[\d]{2})(:[\d]{2})(.*)/, "$1$3");
}

function addMessage() {
    sendMessage(textarea.value.trim());
    i++;
}

function addMessageEnter(event) {
    // enter was pressed
    if (event.keyCode === 13) {
        addMessage();
    }
}

init();
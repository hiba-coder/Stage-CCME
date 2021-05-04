const url ='http://localhost:8080';
let stompClient;
let selectedUser;
let useru;
var chatHistory = document.querySelector('#chat-history');



function connectToChat(user) {
    console.log("connection...");
    let socket= new SockJS(url+'/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({},function (frame) {
        console.log("connected to :"+frame);
        stompClient.subscribe("/topic/messages"+user.fullName,function (response) {
            let data = JSON.parse(response.body);
            console.log(data);
            if(useru.fullName ===data.sender ){
                render(data.message,useru);
            }
                // if (selectedUser === data.sender) {
                //     render(data.message, data.sender);
            // }
            else {
                newMessages.set(data.fromLogin, data.message);
                //$('#userNameAppender_' + data.fromLogin).append('<span id="newMessage_' + data.fromLogin + '" style="color: red">+1</span>');
            }
        });
    });
}
function sendMsg(userSend,msg) {
    stompClient.send("/app/chat"+selectedUser,{},JSON.stringify({
        sender:userSend,
        message:msg
    }));
}
function gotochat(){

    urlParm = url +"/AllUsers/returnUser";
    let user = httpGet(urlParm);
    console.log(user);
    connectToChat(user);
    document.getElementById("ImgId")
        .getElementsByTagName("img")[0].setAttribute("src","data:image/jpeg;base64,"+user.image);
    document.getElementById("profile")
        .getElementsByTagName("img")[0].setAttribute("src","data:image/jpeg;base64,"+user.image);

}




function selectUser(userName) {
    console.log("selecting users: " + userName);
    selectedUser = userName;
    /* let isNew = document.getElementById("newMessage_" + userName) !== null;
     if (isNew) {
         let element = document.getElementById("newMessage_" + userName);
         element.parentNode.removeChild(element);
         render(newMessages.get(userName), userName);
     }*/
    var selectedUserId = document.querySelector("#chat1");
    console.log(selectedUserId);
    /*selectedUserId.outerHTML='<a href="#">'+userName+'</a>';*/
    //chatHistory.innerHTML="";
    selectedUserId.getElementsByTagName('h5')[0].outerHTML='<h5><a href="#"></a></h5>';
    selectedUserId.getElementsByTagName('h5')[0].outerHTML='<h5><a href="#">'+userName+'</a></h5>';
    /*$('#selectedUserId').html('');
    $('#selectedUserId').append('Chat with ' + userName);*/
}


function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    var serverResponse = JSON.parse(xmlHttp.responseText);
    return serverResponse;
}

function img(){

    urlParm = url +"/AllUsers";
    let users = httpGet(urlParm);



    for(let i=0; i<5;i++) {



        document.getElementById("user" + i)
            .getElementsByTagName("img")[0].setAttribute("src","data:image/jpeg;base64,"+users[i].image);



    }

}

function selectUserImg(User){

    console.log("selecting users: " + User.fullName);
    selectedUser = User.fullName;
    useru = User;
    /* let isNew = document.getElementById("newMessage_" + userName) !== null;
     if (isNew) {
         let element = document.getElementById("newMessage_" + userName);
         element.parentNode.removeChild(element);
         render(newMessages.get(userName), userName);
     }*/
    var selectedUserId = document.querySelector("#chat1");
    console.log(selectedUserId);
    /*selectedUserId.outerHTML='<a href="#">'+userName+'</a>';*/

    selectedUserId.getElementsByTagName('img')[0].outerHTML='<img  id="selectedUserImgId" class="avatar-md" src="" data-toggle="tooltip" data-placement="top" title="Keith" alt="avatar"></a>';
    selectedUserId
        .getElementsByTagName("img")[0].setAttribute("src","data:image/jpeg;base64,"+User.image);



}

function makeListSaver(index) {
    /* return a brand new function that has captured the index when this function
       was invoked
    */
    return function() {
        selectUser(index);
    }
}

/*
function AllUsers() {

    urlParm = url + "/AllUsers";
    let users = httpGet(urlParm);
    console.log(users);


    var userTemplateHTML = document.querySelector('#userU');
    var contacts = document.querySelector('#contacts');
    console.log(users[1].fullName);

        for (let i = 0; i < 3; i++) {
            var userT = document.querySelector('.filterMembers');
            userT.getElementsByTagName('h5')[0].outerHTML = "<h5>" + users[i].fullName + "</h5>";
            contacts.appendChild(userT.cloneNode(true));


            let id = 'user'+i;
            contacts.getElementsByTagName("a")[0].setAttribute("id","user"+i);
            console.log(document.getElementById("user"+i).getAttribute("id"));
            //document.getElementById("user"+i).addEventListener("click", makeListSaver(users[i].fullName));
            /*document.getElementById("user" + i).addEventListener("click", (function(i){
                return function() { selectUser(users[i].fullName); }
            })(i));*
        }

}*/
function AllUsers() {

    urlParm = url + "/AllUsers";
    let users = httpGet(urlParm);
    console.log(users);
    console.log(users.length);
    let temp ,cln , div ;

    var contacts = document.querySelector('#contacts');

    temp = document.querySelector('[type="text/html"]');
    cln = temp.cloneNode(true);
    div = cln.textContent;
    contacts.innerHTML = div ;

    let i=0;
    while(i<users.length) {
        var userT = document.querySelector('.filterMembers');
        userT.getElementsByTagName('h5')[0].outerHTML = "<h5>" + users[i].fullName + "</h5>";
        console.log(users[i].fullName);
        //contacts.innerHTML = "";

        contacts.appendChild(userT.cloneNode(true));
        contacts.getElementsByTagName("a")[0].setAttribute("id","user"+i);
        console.log(document.getElementById("user"+i).getAttribute("id"));
        //document.getElementById("user"+i).addEventListener("click", makeListSaver(users[i].fullName));
        //document.querySelector("#user"+i).getElementsByTagName('h5')[0].outerHTML = "<h5> hhhh </h5>";

        /*document.getElementById("user" + i).addEventListener("click", (function(i){
            return function() { selectUser(users[i].fullName); }
        })(i));*/
        i++;
    }
    let j =0 ;
    while ( j < users.length) {
        //document.getElementById("user" + i).getElementsByTagName('h5')[0].outerHTML = "<h5>hhhhhiibb</h5>";
        //console.log(document.getElementById("user"+i).getAttribute("id"));
        document.getElementById("user" + j).addEventListener("click", (function(j){
            return function() { selectUser(users[j].fullName); }
        })(j));
        j++;
    }


    let k =0 ;
    while ( k < users.length) {

        document.getElementById("user" + k).addEventListener("click", (function(k){
            return function() { selectUserImg(users[k]); }
        })(k));
        k++;
    }

    img();



}
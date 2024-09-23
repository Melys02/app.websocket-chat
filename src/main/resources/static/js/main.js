$(document).ready(function(){
var usernamePage = $("#username-page");
var chatPage = $("#chat-page");
var usernameForm = $("#usernameFrom");
var messageForm = $("#messageForm");}
var messageArea = $("#messageArea");
var connectingElement = $(".connecting");
var stompClient = null;
var username = null;


function conectarUsuario(event){
username = $("name").val().trim();
if(username){
username.addClass("d-none");
chatPage.removeClass("d-none");
}
event.preventdefault();



usernameForm.on("submit", conectarUsuario);


});
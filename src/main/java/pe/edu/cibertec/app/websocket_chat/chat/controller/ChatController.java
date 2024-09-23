package pe.edu.cibertec.app.websocket_chat.chat.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import pe.edu.cibertec.app.websocket_chat.chat.modelo.Mensaje;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Mensaje enviarMensaje(
            @Payload Mensaje mensaje){
        return mensaje;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
            public Mensaje agregarUsuario(@Payload Mensaje mensaje,
            SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username",
                mensaje.getContenido());
        return mensaje;

            }


}

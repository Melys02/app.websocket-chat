package pe.edu.cibertec.app.websocket_chat.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import pe.edu.cibertec.app.websocket_chat.chat.modelo.Mensaje;
import pe.edu.cibertec.app.websocket_chat.chat.modelo.TipoMensaje;

@Slf4j
@Component
@RequiredArgsConstructor

public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void socketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String usuario = (String)headerAccessor.getSessionAttributes().get("username");
        if(usuario != null){
            var mensaje = Mensaje.builder()
                    .tipo(TipoMensaje.DEJAR)
                    .envio(usuario)
                    .build();
            messageSendingOperations.convertAndSend("/topic/public",
                    mensaje);
        }
    }
}

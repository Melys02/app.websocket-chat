package pe.edu.cibertec.app.websocket_chat.chat.modelo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Mensaje {
    private TipoMensaje tipo;
    private String contenido;
    private String envio;
}

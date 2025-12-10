package mx.nube2024.ia.app.htsoft.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface htsoftAIService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestion de Peliculas Htsoft
            usa menos de 120 caracteres y hazlo con el estylo de {{platform}}
            """)
    String generatedGreeting(@V("platform") String platform);

    @SystemMessage("""
            Eres un experto en cine que recomienda peliculas personalizadas segun los gustos del
            usuario,Debes recomendar máximo 3 peliculas.
            No incluyas peliculas que esten por fuera de la plataforma htsoft es decir ningun resultado 
            externo a la plataforma de Htsoft
            """)
    String generateMoviesSuggestion(@UserMessage String userMessage);
}

package mx.nube2024.ia.app.htsoft;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface htsoftAIServive {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestion de Peliculas Htsoft
            usa menos de 120 caracteres y hazlo con el estylo de platzi
            """)
    String generatedGreeting();
}

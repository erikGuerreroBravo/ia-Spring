package mx.nube2024.ia.app.htsoft;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    private final htsoftAIService aiService;
    private final String platform;

    /*Inyectamos la dependencia de la interfaz a traves del constructor*/
    public HelloController(htsoftAIService aiService, @Value("${spring.application.name}") String platform) {
        this.aiService = aiService;
        this.platform = platform;
    }

    @GetMapping("/")
    public String hello()
    {
        return this.aiService.generatedGreeting(this.platform);
    }
}

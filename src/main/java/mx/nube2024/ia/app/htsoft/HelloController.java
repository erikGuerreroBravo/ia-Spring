package mx.nube2024.ia.app.htsoft;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{

    private final htsoftAIServive aiService;

    /*Inyectamos la dependencia de la interfaz a traves del constructor*/
    public HelloController(htsoftAIServive aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/")
    public String hello()
    {
        return this.aiService.generatedGreeting();
    }
}

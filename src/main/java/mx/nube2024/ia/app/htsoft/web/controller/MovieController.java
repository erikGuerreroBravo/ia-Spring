package mx.nube2024.ia.app.htsoft.web.controller;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDto> getAll()
    {
        //casteamos el resultado al tipo de objeto que se necesita transformar
        return  this.movieService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable Long id){
        MovieDto movieDto= this.movieService.getById(id);
        if(movieDto == null)
        {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(movieDto);
    }
}

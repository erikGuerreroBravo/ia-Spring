package mx.nube2024.ia.app.htsoft.web.controller;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll()
    {
        //casteamos el resultado al tipo de objeto que se necesita transformar
        List<MovieDto> movies= this.movieService.getAll();
        return ResponseEntity.ok(movies);
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
    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto)
    {
        /*el cuerpo de la respuesta es lo que regrese el movieService*/
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }
}

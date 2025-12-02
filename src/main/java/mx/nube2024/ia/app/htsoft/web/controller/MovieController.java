package mx.nube2024.ia.app.htsoft.web.controller;

import mx.nube2024.ia.app.htsoft.persistence.crud.CrudMovieEntity;
import mx.nube2024.ia.app.htsoft.persistence.entity.MovieEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final CrudMovieEntity crudMovieEntity;

    public MovieController(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }

    @GetMapping("/movies")
    public List<MovieEntity> getAll()
    {
        //casteamos el resultado al tipo de objeto que se necesita transformar
        return (List<MovieEntity>) this.crudMovieEntity.findAll();
    }
}

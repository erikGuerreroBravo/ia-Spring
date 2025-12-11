package mx.nube2024.ia.app.htsoft.persistence.crud;

import mx.nube2024.ia.app.htsoft.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity,Long> {

    MovieEntity findFirstByTitle(String titulo);
}

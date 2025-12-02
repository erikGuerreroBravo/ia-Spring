package mx.nube2024.ia.app.htsoft.persistence;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.repository.MovieRepository;
import mx.nube2024.ia.app.htsoft.persistence.crud.CrudMovieEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

//tiene que ser un repository para inyectar las clases que se ocupan dentro de
//este repositorio.
@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }

    @Override
    public List<MovieDto> getAll() {
        return null;
    }
}

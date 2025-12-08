package mx.nube2024.ia.app.htsoft.persistence;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.repository.MovieRepository;
import mx.nube2024.ia.app.htsoft.persistence.crud.CrudMovieEntity;
import mx.nube2024.ia.app.htsoft.persistence.entity.MovieEntity;
import mx.nube2024.ia.app.htsoft.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//tiene que ser un repository para inyectar las clases que se ocupan dentro de
//este repositorio.
@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDo(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        return null;
    }
}

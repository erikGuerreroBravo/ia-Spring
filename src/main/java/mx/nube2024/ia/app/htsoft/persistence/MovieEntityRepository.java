package mx.nube2024.ia.app.htsoft.persistence;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.dto.UpdateMovieDto;
import mx.nube2024.ia.app.htsoft.domain.repository.MovieRepository;
import mx.nube2024.ia.app.htsoft.persistence.crud.CrudMovieEntity;
import mx.nube2024.ia.app.htsoft.persistence.entity.MovieEntity;
import mx.nube2024.ia.app.htsoft.persistence.mapper.MovieMapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        //asignamos el estado de forma manual.
        movieEntity.setEstado("D");
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(Long id,UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        if(movieEntity==null)
        {
            return null;
        }
        movieEntity.setTitulo(updateMovieDto.title());
        movieEntity.setFechaEstreno(updateMovieDto.releaseDate());
        //transformamos a un bigdecimal
        movieEntity.setClasificacion(BigDecimal.valueOf(updateMovieDto.rating()));
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));


    }
}

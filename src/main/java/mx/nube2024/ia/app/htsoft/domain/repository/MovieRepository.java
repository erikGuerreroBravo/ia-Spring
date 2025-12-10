package mx.nube2024.ia.app.htsoft.domain.repository;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {

    List<MovieDto> getAll();
    MovieDto  getById(Long id);

    MovieDto save(MovieDto movieDto);

    MovieDto update(Long id, UpdateMovieDto updateMovieDto);
}

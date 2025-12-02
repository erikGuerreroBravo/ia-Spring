package mx.nube2024.ia.app.htsoft.domain.repository;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {

    List<MovieDto> getAll();
}

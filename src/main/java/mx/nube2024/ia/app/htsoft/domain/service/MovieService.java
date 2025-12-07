package mx.nube2024.ia.app.htsoft.domain.service;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll()
    {
        return this.movieRepository.getAll();
    }
    /**
     * Este metoodo se encarga de consultar un MovieDto por Identificador
     * */
    public MovieDto  getById(Long id)
    {
        return this.movieRepository.getById(id);
    }

}

package mx.nube2024.ia.app.htsoft.domain.service;

import dev.langchain4j.agent.tool.Tool;
import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.dto.UpdateMovieDto;
import mx.nube2024.ia.app.htsoft.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //esta notacion es de lauching4j y sirve para trabajar con el LLM de IA.
    @Tool("Busca todas las peliculas que existan dentro de la plataforma")
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

    public MovieDto add(MovieDto movieDto)
    {
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(Long id, UpdateMovieDto updateMovieDto){
        return this.movieRepository.update(id,updateMovieDto);
    }

    public void delete(Long id)
    {
        this.movieRepository.delete(id);
    }

}

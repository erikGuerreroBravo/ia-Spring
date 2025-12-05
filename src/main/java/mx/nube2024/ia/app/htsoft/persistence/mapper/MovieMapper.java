package mx.nube2024.ia.app.htsoft.persistence.mapper;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.persistence.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

//los mapeadores siempre seran del tipo interface
@Mapper(componentModel = "spring", uses = {GeneroMapper.class})
public interface MovieMapper {
    @Mapping(source="titulo", target="title")
    @Mapping(source="duracion", target="duration")
    @Mapping(source="genero", target="genere", qualifiedByName = "StringToGenero")
    @Mapping(source="fechaEstreno", target="releaseDate")
    @Mapping(source="clasificacion", target="rating")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDo(Iterable<MovieEntity> entities);
}

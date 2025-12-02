package mx.nube2024.ia.app.htsoft.persistence.mapper;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.persistence.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(source="titulo", target="title")
    @Mapping(source="duracion", target="duration")
    @Mapping(source="genero", target="genere")
    @Mapping(source="fechaEstreno", target="releaseDate")
    @Mapping(source="clasificacion", target="rating")
    MovieDto toDto(MovieEntity entity);
}

package mx.nube2024.ia.app.htsoft.persistence.mapper;

import mx.nube2024.ia.app.htsoft.domain.dto.MovieDto;
import mx.nube2024.ia.app.htsoft.domain.dto.UpdateMovieDto;
import mx.nube2024.ia.app.htsoft.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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
    List<MovieDto> toDto(Iterable<MovieEntity> entities);

    //se aplica esta notacion para heredar todos los atriutos mostrados en la configuracion
    //del mapstruct excepto  genero por que aqui se utiliza un enum.
    @InheritInverseConfiguration
    @Mapping(source = "genere", target = "genero", qualifiedByName = "GeneroToString")
    MovieEntity toEntity(MovieDto dto);
   @Mapping(target = "titulo" ,source = "title")
   @Mapping(target="fechaEstreno", source = "releaseDate")
   @Mapping(target="clasificacion",source = "rating")
    void updateEntityFromDto(UpdateMovieDto updateMovieDto, @MappingTarget MovieEntity movieEntity);
}

package com.mapstruct_libro.mapper;

import com.mapstruct_libro.dto.LibroDTO;
import com.mapstruct_libro.model.Libro;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibroMapper {

    LibroDTO libroToLibroDTO(Libro libro);
    Libro libroDTOToLibro(LibroDTO libroDTO);
    List<LibroDTO> librosToLibroDTOs(List<Libro> libros);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLibroFromDto(LibroDTO libroDTO, @MappingTarget Libro libro);
}

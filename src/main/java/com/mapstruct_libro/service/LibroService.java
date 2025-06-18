package com.mapstruct_libro.service;

import com.mapstruct_libro.dto.LibroDTO;
import com.mapstruct_libro.mapper.LibroMapper;
import com.mapstruct_libro.model.Libro;
import com.mapstruct_libro.repository.LibroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;

    public LibroService(LibroRepository libroRepository, LibroMapper libroMapper) {
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
    }

    public LibroDTO guardarLibro(LibroDTO libroDTO){
        Libro libro = libroMapper.libroDTOToLibro(libroDTO);
        System.out.println("Libro mapeado: " + libro);
        libro.setEstado(true);
        Libro libroGuardado = libroRepository.save(libro);
        return libroMapper.libroToLibroDTO(libroGuardado);
    }

    public List<LibroDTO> listaLibros(){
        return libroRepository.findAll().stream()
                .map(libroMapper::libroToLibroDTO)
                .collect(Collectors.toList());
    }

    public LibroDTO buscarPorId(Long id){
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Libro no encontrado del id: "+id));
        return  libroMapper.libroToLibroDTO(libro);
    }

    public Libro actualizarLibro(Long id, LibroDTO libroDTO){
        Libro libroExistente = libroRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Libro no encontrado"));
        libroMapper.updateLibroFromDto(libroDTO,libroExistente);
        return libroRepository.save(libroExistente);
    }
}

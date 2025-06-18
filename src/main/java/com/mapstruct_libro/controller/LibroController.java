package com.mapstruct_libro.controller;

import com.mapstruct_libro.dto.LibroDTO;
import com.mapstruct_libro.model.Libro;
import com.mapstruct_libro.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<List<LibroDTO>> listarLibros(){
        List<LibroDTO> libros = libroService.listaLibros();
        return ResponseEntity.ok(libros);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LibroDTO crearLibro(@Valid @RequestBody LibroDTO libroDTO){
        return libroService.guardarLibro(libroDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> obtenerLibroPorId(@PathVariable Long id){
        LibroDTO libroDTO = libroService.buscarPorId(id);
        return ResponseEntity.ok(libroDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id,
                                                 @RequestBody LibroDTO libroDTO){
        Libro libroActualizado = libroService.actualizarLibro(id, libroDTO);
        return ResponseEntity.ok(libroActualizado);
    }
}

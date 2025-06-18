package com.mapstruct_libro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;
@Data
public class LibroDTO {
    @NotBlank(message = "El nombre del titulo no puede estar vacío")
    private String title;

    @NotBlank(message = "El nombre del author no puede estar vacío")
    private String author;

    @NotBlank(message = "El código ISBN del libro no puede estar vacío")
    private String isbn;

    @NotNull(message = "El año no puede estar vacío")
    private Integer publishedYear;

    @NotNull(message = "El precio no puede estar vacío")
    private Double price;
    private Date fechaCreacion;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@unasam\\.com$",message = "El correo debe ser válido y terminar en @unasam.com")
    private String email;
    private Boolean estado;

}

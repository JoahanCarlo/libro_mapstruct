package com.mapstruct_libro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Data
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "El autor no puede estar vacío")
    @Column(nullable = false)
    private String author;

    @NotBlank(message = "El código no puede estar vacío")
    @Column(nullable = false)
    private String isbn;

    @NotNull(message = "El año no puede estar vacío")
    @Column(nullable = false)
    private Integer publishedYear;

    @NotNull(message = "El precio no puede estar vacío")
    @Column(nullable = false)
    private Double price;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date fechaCreacion;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@unasam\\.com$",message = "El correo debe ser válido y terminar en @unasam.com")
    private String email;

    private Boolean estado;
}

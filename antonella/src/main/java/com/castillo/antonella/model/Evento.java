package com.castillo.antonella.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Evento 
{
    private static final AtomicInteger contador = new AtomicInteger(1);

    private int id;

    @NotNull(message = "El nombre es obligatorio")
    @Size (min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank (message = "El tipo evento debe ser obligatorio")
    @Size (min = 2, max= 100, message = "El evento debe tener entre 2 y 100 caracteres")
    private String tipoEvento;

    @NotNull (message = "La fecha de realizacion debe ser obligatoria ")
    private LocalDate fechaRealizacion;

    @NotBlank(message = "La ubicacion debe ser obligatoria")
    @Size (min = 3, max = 100, message = "La ubicacion debe tener entre 3 y 100 caracteres")
    private String ubicacion;

    @NotBlank (message = "La capacidad debe ser obligatoria")
    @Min (value = 1, message = "La capacidad debe ser mayor que 0")
    private Integer capacidad;

    @NotBlank(message = "El estado debe ser obligatorio")
    @Size (min = 3, max = 30, message = "El estado debe tener entre 3 y 30 caracteres")
    private String estado;

    public Evento (String nombre, String tipoEvento, LocalDate fechaRealizavion, String ubicacion, Integer capacidad, String estado)
    {
        this.id = contador.getAndIncrement();
        this.nombre = nombre;
        this.tipoEvento = tipoEvento;
        this.fechaRealizacion = fechaRealizavion;
        this.ubicacion = ubicacion;
        this.capacidad=capacidad;
        this.estado = estado;
    }
    
}

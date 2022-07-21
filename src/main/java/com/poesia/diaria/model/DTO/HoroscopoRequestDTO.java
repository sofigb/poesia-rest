package com.poesia.diaria.model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Getter
@Setter
public class HoroscopoRequestDTO {

    @Size(min = 2, max = 15, message = "Debe tener min 2 caracteres y menos de 15")
    private String tipo;

    @Size(min = 2, max = 64, message = "Debe tener min 2 caracteres y menos de 64")
    private String descripcion;

    @NotNull(message = "fechaInicial no puede ser nulo")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy", iso = DateTimeFormat.ISO.DATE)
    private Calendar fechaInicial;

    @NotNull(message = "fechaFinal no puede ser nulo")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy", iso = DateTimeFormat.ISO.DATE)
    private Calendar fechaFinal;
}

package com.poesia.diaria.model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Getter
@Setter
public class HoroscopoResponseDTO {
    private String tipo;
    private String descripcion;


}

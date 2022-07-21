package com.poesia.diaria.model.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class FechaDTO {


    @NotEmpty(message = "El mes es obligatorio")
    private Integer mes;
    @NotEmpty(message = "El dia es obligatorio")
    private Integer dia;

}

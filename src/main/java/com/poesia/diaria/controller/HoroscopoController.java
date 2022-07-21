package com.poesia.diaria.controller;

import com.poesia.diaria.exception.MyException;
import com.poesia.diaria.model.DTO.FechaDTO;
import com.poesia.diaria.model.DTO.HoroscopoResponseDTO;
import com.poesia.diaria.model.Horoscopo;
import com.poesia.diaria.service.HoroscopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/horoscopo")

public class HoroscopoController {


    @Autowired
    private HoroscopoService horoscopoService;

    @GetMapping
    public ResponseEntity<List<HoroscopoResponseDTO>> findAll() throws MyException {
        return ResponseEntity.ok(horoscopoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoroscopoResponseDTO> findById(@PathVariable("id") Integer id) throws MyException {
        return ResponseEntity.ok(horoscopoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HoroscopoResponseDTO> save(@RequestBody Horoscopo horoscopo) throws MyException {
        return ResponseEntity.status(HttpStatus.CREATED).body(horoscopoService.save(horoscopo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoroscopoResponseDTO> update(@RequestBody Horoscopo horoscopo, @PathVariable Integer id) throws MyException {
        return ResponseEntity.status(HttpStatus.OK).body(horoscopoService.update(horoscopo, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws MyException {
        horoscopoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente el horoscopo con id " +id);
    }

    @GetMapping("/fecha")
    public ResponseEntity<HoroscopoResponseDTO> findByDate(@RequestBody FechaDTO dtoFecha) throws ParseException, MyException {
        return ResponseEntity.status(HttpStatus.OK).body(horoscopoService.findByDate(dtoFecha.getDia(), dtoFecha.getMes()));
    }
}

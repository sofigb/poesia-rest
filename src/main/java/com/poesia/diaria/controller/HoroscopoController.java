package com.poesia.diaria.controller;

import com.poesia.diaria.model.DTO.DTOFecha;
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
    public ResponseEntity<List<Horoscopo>> findAll()  {
        return ResponseEntity.ok(horoscopoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horoscopo> findById(@PathVariable("id")  Integer id)  {
        return ResponseEntity.ok(horoscopoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Horoscopo> save(@RequestBody Horoscopo horoscopo)  {
        return ResponseEntity.status(HttpStatus.CREATED).body(horoscopoService.save(horoscopo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horoscopo> update(@RequestBody Horoscopo horoscopo,@PathVariable Integer id)  {
        return ResponseEntity.status(HttpStatus.OK).body(horoscopoService.update(horoscopo,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id")  Integer id)  {
        horoscopoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente");
    }

    @GetMapping("/fecha")
    public ResponseEntity<Horoscopo> findByDate(@RequestBody DTOFecha dtoFecha) throws ParseException {
        return  ResponseEntity.status(HttpStatus.OK).body(horoscopoService.findByDate(dtoFecha.getDia(),dtoFecha.getMes()));
    }
}

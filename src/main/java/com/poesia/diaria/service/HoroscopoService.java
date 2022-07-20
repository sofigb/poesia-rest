package com.poesia.diaria.service;

import com.poesia.diaria.exception.MyException;
import com.poesia.diaria.model.Horoscopo;
import com.poesia.diaria.repository.HoroscopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HoroscopoService {


    @Autowired
    private HoroscopoRepository horoscopoRepository;

    public List<Horoscopo> findAll() throws MyException {
        try {
            return horoscopoRepository.findAll();
        } catch (Exception e) {
            throw new MyException("No se ha podido conectar con la BBDD", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Horoscopo findByTipo(String tipo) throws MyException {
        if (horoscopoRepository.findByTipo(tipo) == null) {
            throw new MyException("No existe el tipo : " + tipo, HttpStatus.NOT_FOUND);
        }
        return horoscopoRepository.findByTipo(tipo);
    }

    public Horoscopo findById(Integer id) throws MyException {
        try {
            return horoscopoRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new MyException("No se ha encontrado horóscopo con  el id: " + id, HttpStatus.NOT_FOUND);
        }
    }


    public Horoscopo findByDate(Integer dia, Integer mes) throws MyException {
        try {
            LocalDate fecha;
            fecha = LocalDate.of(2000, mes, dia);


            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            fecha.format(formato);

            System.out.println(fecha);
            if (horoscopoRepository.findByDate(fecha) == null) {
                throw new MyException("No existe un horoscopo con dichas fechas ", HttpStatus.NOT_FOUND);
            }
            return horoscopoRepository.findByDate(fecha);
        } catch (DateTimeException e) {
            throw new MyException("El mes y el dia ingresado no son validos ", HttpStatus.BAD_REQUEST);

        }

    }

    public Horoscopo save(Horoscopo horoscopo) throws MyException {
        try {
            return horoscopoRepository.save(horoscopo);
        } catch (Exception e) {
            throw new MyException("No se ha guardar el horoscopo seleccionada", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Horoscopo update(Horoscopo horoscopo, Integer id) throws MyException {
        try {
            Horoscopo horoscopoAmodificar = horoscopoRepository.findById(id).orElseThrow();
            horoscopoAmodificar.setDescripcion(horoscopo.getDescripcion());
            horoscopoAmodificar.setFechaFinal(horoscopo.getFechaFinal());
            horoscopoAmodificar.setFechaInicial(horoscopo.getFechaInicial());
            horoscopoAmodificar.setTipo(horoscopo.getTipo());
            return horoscopoRepository.save(horoscopoAmodificar);
        } catch (NoSuchElementException e) {
            throw new MyException("No se ha encontrado horóscopo con el id: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new MyException("No se ha podido actualizar el horoscopo", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delete(Integer id) throws MyException {
        try {
            Horoscopo horoscopoAeliminar = horoscopoRepository.findById(id).orElseThrow();
            horoscopoRepository.delete(horoscopoAeliminar);

        } catch (NoSuchElementException e) {
            throw new MyException("No se ha encontrado horóscopo con el id: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new MyException("No se ha podido eliminar el horoscopo seleccionada", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

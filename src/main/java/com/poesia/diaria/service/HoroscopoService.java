package com.poesia.diaria.service;

import com.poesia.diaria.exception.MyException;
import com.poesia.diaria.model.DTO.HoroscopoResponseDTO;
import com.poesia.diaria.model.DTO.HoroscopoResponseDTOconCoctel;
import com.poesia.diaria.model.Horoscopo;
import com.poesia.diaria.model.mapper.HoroscopoMapper;
import com.poesia.diaria.repository.CoctelRepository;
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

    @Autowired
    private CoctelRepository coctelRepository;

    public List<HoroscopoResponseDTO> findAll() throws MyException {
        try {
            return HoroscopoMapper.init.horoscopoListAResponseDTOList(horoscopoRepository.findAll());

        } catch (Exception e) {
            throw new MyException("No se ha podido conectar con la BBDD", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public HoroscopoResponseDTO findByTipo(String tipo) throws MyException {
        if (horoscopoRepository.findByTipo(tipo) == null) {
            throw new MyException("No existe el tipo : " + tipo, HttpStatus.NOT_FOUND);
        }
        return HoroscopoMapper.init.horoscopoToHoroscopoResponseDTO(horoscopoRepository.findByTipo(tipo));

    }

    public HoroscopoResponseDTO findById(Integer id) throws MyException {
        try {
            return HoroscopoMapper.init.horoscopoToHoroscopoResponseDTO(horoscopoRepository.findById(id).orElseThrow());
        } catch (NoSuchElementException e) {
            throw new MyException("No se ha encontrado horóscopo con  el id: " + id, HttpStatus.NOT_FOUND);
        }
    }


    public HoroscopoResponseDTOconCoctel findByDate(Integer dia, Integer mes) throws MyException {
        try {
            LocalDate fecha;
            Integer year=2000;
            if (mes==1 || mes==2){
                year=2001;
            }

            fecha = LocalDate.of(year, mes, dia);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            fecha.format(formato);

            System.out.println(fecha);
            if (horoscopoRepository.findByDate(fecha) == null) {
                throw new MyException("No existe un horoscopo con dichas fechas ", HttpStatus.NOT_FOUND);
            }
            Horoscopo horoscopoNuevo=horoscopoRepository.findByDate(fecha);
            horoscopoNuevo.setNombreCoctel(setCoctel());
            return HoroscopoMapper.init.horoscopoToHoroscopoResponseDTOCoctel(horoscopoNuevo);
        } catch (DateTimeException e) {
            throw new MyException("El mes y el dia ingresado no son validos ", HttpStatus.BAD_REQUEST);

        }

    }

    public HoroscopoResponseDTO save(Horoscopo horoscopo) throws MyException {
        try {
            return HoroscopoMapper.init.horoscopoToHoroscopoResponseDTO( horoscopoRepository.save(horoscopo));
        } catch (Exception e) {
            throw new MyException("No se ha guardar el horoscopo seleccionada", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public HoroscopoResponseDTO update(Horoscopo horoscopo, Integer id) throws MyException {
        try {
            Horoscopo horoscopoAmodificar = horoscopoRepository.findById(id).orElseThrow();
            horoscopoAmodificar.setDescripcion(horoscopo.getDescripcion());
            horoscopoAmodificar.setFechaFinal(horoscopo.getFechaFinal());
            horoscopoAmodificar.setFechaInicial(horoscopo.getFechaInicial());
            horoscopoAmodificar.setTipo(horoscopo.getTipo());
            return HoroscopoMapper.init.horoscopoToHoroscopoResponseDTO( horoscopoRepository.save(horoscopoAmodificar));
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


    public String setCoctel() {

        String resultado= coctelRepository.obtenerCoctelRandom();


        String nombreCoctel =resultado.substring((resultado.indexOf("\"strDrink\":",0))+11,resultado.indexOf("strDrinkAlternate",0));
        String foto =resultado.substring((resultado.indexOf("\"strDrinkThumb\":",0))+16,resultado.indexOf("strIngredient1",0));
        //coctel.setNombre();


        System.out.println("!!!!!!!!!!!!!FOTOO!!!!!!!!!!!!");
        System.out.println( foto.substring(0,foto.indexOf(",",0)));
        //coctel.setStrDrinkThumb(foto.substring(0,foto.indexOf(",",0)));
        return nombreCoctel.substring(0,nombreCoctel.indexOf(",",0));
    }
}

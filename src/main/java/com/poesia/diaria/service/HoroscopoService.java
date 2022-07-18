package com.poesia.diaria.service;

import com.poesia.diaria.model.Horoscopo;
import com.poesia.diaria.repository.HoroscopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class HoroscopoService {


    @Autowired
    private HoroscopoRepository horoscopoRepository;

    public List<Horoscopo> findAll() {
        return horoscopoRepository.findAll();
    }

    public Horoscopo findByTipo(String tipo) {
        return horoscopoRepository.findByTipo(tipo);
    }

    public Horoscopo findById(Integer id) {
        return horoscopoRepository.findById(id).get();
    }


    public Horoscopo findByDate(Integer dia, Integer mes) {
        Calendar fecha = null;
        fecha.set(2000, mes, dia);
        return horoscopoRepository.findByDate(fecha);
    }

    public Horoscopo save(Horoscopo horoscopo) {
        return horoscopoRepository.save(horoscopo);
    }

    public Horoscopo update(Horoscopo horoscopo, Integer id) {
        Horoscopo horoscopoAmodificar = horoscopoRepository.getById(id);
        horoscopoAmodificar = horoscopo;
        return horoscopoRepository.save(horoscopoAmodificar);
    }

        public void delete( Integer id) {
        Horoscopo horoscopoAeliminar = horoscopoRepository.getById(id);
        horoscopoRepository.delete(horoscopoAeliminar);
    }
}

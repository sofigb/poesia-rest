package com.poesia.diaria.repository;

import com.poesia.diaria.model.Horoscopo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

@Repository
public interface HoroscopoRepository extends JpaRepository<Horoscopo, Integer> {

    @Query(value = "SELECT * FROM horoscopo WHERE horoscopo.tipo= :tipo", nativeQuery = true)
    Horoscopo findByTipo(@Param("tipo")String tipo);


    @Query(value = "SELECT * FROM horoscopo WHERE horoscopo.fechaInicial >= :fecha AND horoscopo.fechaFinal <= :fecha", nativeQuery = true)
    Horoscopo findByDate(@Param("fecha") Calendar fecha);
}

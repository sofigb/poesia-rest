package com.poesia.diaria.repository;

import com.poesia.diaria.model.Horoscopo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface HoroscopoRepository extends JpaRepository<Horoscopo, Integer> {

    @Query(value = "SELECT * FROM horoscopo WHERE horoscopo.tipo= :tipo", nativeQuery = true)
    Horoscopo findByTipo(@Param("tipo")String tipo);


    @Query(value = "SELECT * FROM horoscopo WHERE horoscopo.fecha_inicial<= :fecha AND horoscopo.fecha_final>= :fecha", nativeQuery = true)
    Horoscopo findByDate(@Param("fecha") LocalDate fecha);
}

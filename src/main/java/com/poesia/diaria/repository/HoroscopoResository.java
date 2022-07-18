package com.poesia.diaria.repository;

import com.poesia.diaria.model.Horoscopo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoroscopoResository extends JpaRepository<Horoscopo, Integer> {

}

package com.poesia.diaria.model.mapper;

import com.poesia.diaria.model.DTO.HoroscopoRequestDTO;
import com.poesia.diaria.model.DTO.HoroscopoResponseDTO;
import com.poesia.diaria.model.Horoscopo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-21T16:06:43-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class HoroscopoMapperImpl implements HoroscopoMapper {

    @Override
    public HoroscopoRequestDTO horoscopoToHoroscopoRequestDTO(Horoscopo horoscopo) {
        if ( horoscopo == null ) {
            return null;
        }

        HoroscopoRequestDTO horoscopoRequestDTO = new HoroscopoRequestDTO();

        horoscopoRequestDTO.setTipo( horoscopo.getTipo() );
        horoscopoRequestDTO.setDescripcion( horoscopo.getDescripcion() );
        horoscopoRequestDTO.setFechaInicial( horoscopo.getFechaInicial() );
        horoscopoRequestDTO.setFechaFinal( horoscopo.getFechaFinal() );

        return horoscopoRequestDTO;
    }

    @Override
    public HoroscopoResponseDTO horoscopoToHoroscopoResponseDTO(Horoscopo horoscopo) {
        if ( horoscopo == null ) {
            return null;
        }

        HoroscopoResponseDTO horoscopoResponseDTO = new HoroscopoResponseDTO();

        horoscopoResponseDTO.setTipo( horoscopo.getTipo() );
        horoscopoResponseDTO.setDescripcion( horoscopo.getDescripcion() );

        return horoscopoResponseDTO;
    }

    @Override
    public Horoscopo horoscopoResponseDTOTohoroscopo(HoroscopoResponseDTO horoscopoResponseDTO) {
        if ( horoscopoResponseDTO == null ) {
            return null;
        }

        Horoscopo horoscopo = new Horoscopo();

        horoscopo.setTipo( horoscopoResponseDTO.getTipo() );
        horoscopo.setDescripcion( horoscopoResponseDTO.getDescripcion() );

        return horoscopo;
    }

    @Override
    public List<HoroscopoResponseDTO> horoscopoListAResponseDTOList(List<Horoscopo> horoscopoList) {
        if ( horoscopoList == null ) {
            return null;
        }

        List<HoroscopoResponseDTO> list = new ArrayList<HoroscopoResponseDTO>( horoscopoList.size() );
        for ( Horoscopo horoscopo : horoscopoList ) {
            list.add( horoscopoToHoroscopoResponseDTO( horoscopo ) );
        }

        return list;
    }

    @Override
    public Horoscopo horoscopoRequestDTOTohoroscopo(HoroscopoRequestDTO horoscopoRequestDTO) {
        if ( horoscopoRequestDTO == null ) {
            return null;
        }

        Horoscopo horoscopo = new Horoscopo();

        horoscopo.setTipo( horoscopoRequestDTO.getTipo() );
        horoscopo.setDescripcion( horoscopoRequestDTO.getDescripcion() );
        horoscopo.setFechaInicial( horoscopoRequestDTO.getFechaInicial() );
        horoscopo.setFechaFinal( horoscopoRequestDTO.getFechaFinal() );

        return horoscopo;
    }
}

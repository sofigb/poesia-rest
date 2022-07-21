package com.poesia.diaria.model.mapper;

import com.poesia.diaria.model.DTO.HoroscopoRequestDTO;
import com.poesia.diaria.model.DTO.HoroscopoResponseDTO;
import com.poesia.diaria.model.Horoscopo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HoroscopoMapper {

    HoroscopoMapper init =  Mappers.getMapper( HoroscopoMapper.class );
  //  @Mapping(source = "numberOfSeats", target = "seatCount")
    HoroscopoRequestDTO horoscopoToHoroscopoRequestDTO (Horoscopo horoscopo);

    HoroscopoResponseDTO horoscopoToHoroscopoResponseDTO (Horoscopo horoscopo);

    Horoscopo  horoscopoResponseDTOTohoroscopo (HoroscopoResponseDTO horoscopoResponseDTO);

    List<HoroscopoResponseDTO> horoscopoListAResponseDTOList (List<Horoscopo> horoscopoList);

    Horoscopo  horoscopoRequestDTOTohoroscopo (HoroscopoRequestDTO horoscopoRequestDTO);
}

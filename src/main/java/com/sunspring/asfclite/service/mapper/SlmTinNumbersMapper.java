package com.sunspring.asfclite.service.mapper;

import com.sunspring.asfclite.dto.SlmTinNumbersDto;
import com.sunspring.asfclite.entity.SlmTinNumbers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SlmTinNumbersMapper extends EntityMapper<SlmTinNumbersDto, SlmTinNumbers> {

    default SlmTinNumbers fromId(Long id) {
        if (id == null) {
            return null;
        }
        SlmTinNumbers object = new SlmTinNumbers();
        object.setId(id);
        return object;  
    }
}
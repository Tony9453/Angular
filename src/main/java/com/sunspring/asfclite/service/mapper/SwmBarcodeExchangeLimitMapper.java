package com.sunspring.asfclite.service.mapper;

import com.sunspring.asfclite.dto.SwmBarcodeExchangeLimitDto;
import com.sunspring.asfclite.entity.SwmBarcodeExchangeLimit;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SwmBarcodeExchangeLimitMapper extends EntityMapper<SwmBarcodeExchangeLimitDto, SwmBarcodeExchangeLimit> {

    default SwmBarcodeExchangeLimit fromId(Long id) {
        if (id == null) {
            return null;
        }
        SwmBarcodeExchangeLimit object = new SwmBarcodeExchangeLimit();
        object.setId(id);
        return object;  
    }
}
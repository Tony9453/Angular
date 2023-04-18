package com.sunspring.asfclite.service;

import java.util.List;

import com.sunspring.asfclite.dto.SlmTinNumbersDto;
import com.sunspring.asfclite.entity.SlmTinNumbers;

import org.springframework.stereotype.Service;


public interface SlmTinNumbersSerice {
    
    List<SlmTinNumbersDto> findBySourceBarcodeNumber(String sourceBarcodeNumber);

    SlmTinNumbersDto save(SlmTinNumbersDto dto);


    SlmTinNumbers findOne(Long id);

}
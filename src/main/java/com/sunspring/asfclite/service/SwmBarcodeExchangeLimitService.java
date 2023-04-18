package com.sunspring.asfclite.service;

import java.util.List;

import com.sunspring.asfclite.dto.SwmBarcodeExchangeLimitDto;
import com.sunspring.asfclite.entity.SwmBarcodeExchangeLimit;

import org.springframework.stereotype.Service;


public interface SwmBarcodeExchangeLimitService {
    
    List<SwmBarcodeExchangeLimitDto> findByMtlItemId(Long mtlItemId);

    List<SwmBarcodeExchangeLimitDto> findByNewMtlItemId(Long newMtlItemId);
    
    List<SwmBarcodeExchangeLimitDto> findByPlatform(String platform);

    SwmBarcodeExchangeLimitDto save(SwmBarcodeExchangeLimitDto dto);

    void delete(Long id);

    SwmBarcodeExchangeLimitDto findOne(Long id);

}
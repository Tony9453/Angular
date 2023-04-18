package com.sunspring.asfclite.service.impl;

import java.util.List;
import java.util.Optional;

import com.sunspring.asfclite.dto.SwmBarcodeExchangeLimitDto;
import com.sunspring.asfclite.entity.SwmBarcodeExchangeLimit;
import com.sunspring.asfclite.repository.SwmBarcodeExchangeLimitRespository;
import com.sunspring.asfclite.service.SlmTinNumbersSerice;
import com.sunspring.asfclite.service.SwmBarcodeExchangeLimitService;
import com.sunspring.asfclite.service.mapper.SwmBarcodeExchangeLimitMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SwmBarcodeExchangeLimitServiceImpl implements SwmBarcodeExchangeLimitService {

    @Autowired
    private SwmBarcodeExchangeLimitRespository swmBarcodeExchangeLimitRespository;

    @Autowired
    private SwmBarcodeExchangeLimitMapper swmBarcodeExchangeLimitMapper;

    @Override
    public List<SwmBarcodeExchangeLimitDto> findByMtlItemId(Long mtlItemId) {
        List<SwmBarcodeExchangeLimit> entityList = swmBarcodeExchangeLimitRespository.findByMtlItemId(mtlItemId);
        List<SwmBarcodeExchangeLimitDto> dtoList=swmBarcodeExchangeLimitMapper.toDto(entityList);
        return dtoList;
    }

    @Override
    public List<SwmBarcodeExchangeLimitDto> findByNewMtlItemId(Long newMtlItemId) {
        List<SwmBarcodeExchangeLimit> entityList = swmBarcodeExchangeLimitRespository.findByNewMtlItemId(newMtlItemId);
        List<SwmBarcodeExchangeLimitDto> dtoList=swmBarcodeExchangeLimitMapper.toDto(entityList);
        return dtoList;
    }

    @Override
    public List<SwmBarcodeExchangeLimitDto> findByPlatform(String platform) {
        List<SwmBarcodeExchangeLimit> entityList = swmBarcodeExchangeLimitRespository.findByPlatform(platform);
        List<SwmBarcodeExchangeLimitDto> dtoList=swmBarcodeExchangeLimitMapper.toDto(entityList);
        return dtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public SwmBarcodeExchangeLimitDto findOne(Long id) {

        Optional<SwmBarcodeExchangeLimit> result = swmBarcodeExchangeLimitRespository.findById(id);
        // System.out.println("result.toString()");
        // System.out.println(result.toString());
        // System.out.println("result.toString()");

        SwmBarcodeExchangeLimitDto dto = swmBarcodeExchangeLimitMapper.toDto(result.orElse(null));
        return dto;
    }

    @Override
    public SwmBarcodeExchangeLimitDto save(SwmBarcodeExchangeLimitDto dto) {
        SwmBarcodeExchangeLimit entityTemp = swmBarcodeExchangeLimitMapper.toEntity(dto);
        SwmBarcodeExchangeLimit entity = swmBarcodeExchangeLimitRespository.save(entityTemp);

        SwmBarcodeExchangeLimitDto result = swmBarcodeExchangeLimitMapper.toDto(entity);
        return result;
    }

    @Override
    public void delete(Long id) {
        swmBarcodeExchangeLimitRespository.deleteById(id);
    }

    

    

}

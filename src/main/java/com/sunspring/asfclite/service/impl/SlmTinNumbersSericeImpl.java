package com.sunspring.asfclite.service.impl;

import java.util.List;
import java.util.Optional;

import com.sunspring.asfclite.dto.SlmTinNumbersDto;
import com.sunspring.asfclite.entity.SlmTinNumbers;
import com.sunspring.asfclite.repository.SlmTinNumbersRespository;
import com.sunspring.asfclite.service.SlmTinNumbersSerice;
import com.sunspring.asfclite.service.mapper.SlmTinNumbersMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SlmTinNumbersSericeImpl implements SlmTinNumbersSerice {

    @Autowired
    private SlmTinNumbersRespository slmTinNumbersRespository;

    @Autowired
    private SlmTinNumbersMapper slmTinNumbersMapper;

    @Override
    @Transactional(readOnly = true)
    public SlmTinNumbers findOne(Long id) {

        Optional<SlmTinNumbers> result = slmTinNumbersRespository.findById(id);

        SlmTinNumbers entity = result.orElse(null);

        SlmTinNumbersDto dto = slmTinNumbersMapper.toDto(entity);
        return entity;
    }

    @Override
    public List<SlmTinNumbersDto> findBySourceBarcodeNumber(String sourceBarcodeNumber) {
       
        List<SlmTinNumbers> entityList = slmTinNumbersRespository.findBySourceBarcodeNumber(sourceBarcodeNumber);
        List<SlmTinNumbersDto> dtoList=slmTinNumbersMapper.toDto(entityList);

        return dtoList;
    }

    @Override
    public SlmTinNumbersDto save(SlmTinNumbersDto dto) {
        SlmTinNumbers entityTemp = slmTinNumbersMapper.toEntity(dto);
        SlmTinNumbers entity = slmTinNumbersRespository.save(entityTemp);

        SlmTinNumbersDto result = slmTinNumbersMapper.toDto(entity);
        return result;
    }

}

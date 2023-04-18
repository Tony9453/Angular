package com.sunspring.asfclite.repository;

import java.util.List;

import com.sunspring.asfclite.entity.SlmTinNumbers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlmTinNumbersRespository extends JpaRepository<SlmTinNumbers, Long> {


    List<SlmTinNumbers> findBySourceBarcodeNumber(String sourceBarcodeNumber);
    
}
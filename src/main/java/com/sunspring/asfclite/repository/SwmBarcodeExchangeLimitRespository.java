package com.sunspring.asfclite.repository;

import java.util.List;

import com.sunspring.asfclite.entity.SwmBarcodeExchangeLimit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwmBarcodeExchangeLimitRespository extends JpaRepository<SwmBarcodeExchangeLimit, Long> {

    List<SwmBarcodeExchangeLimit> findByMtlItemId(Long mtlItemId);

    List<SwmBarcodeExchangeLimit> findByNewMtlItemId(Long mtlItemId);

    List<SwmBarcodeExchangeLimit> findByPlatform(String platform);

}
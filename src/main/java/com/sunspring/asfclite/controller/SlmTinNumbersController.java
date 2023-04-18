package com.sunspring.asfclite.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import com.sunspring.asfclite.dto.SlmTinNumbersDto;
import com.sunspring.asfclite.dto.SwmBarcodeExchangeLimitDto;
import com.sunspring.asfclite.entity.SlmTinNumbers;
import com.sunspring.asfclite.service.SlmTinNumbersSerice;
import com.sunspring.asfclite.service.SwmBarcodeExchangeLimitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SlmTinNumbersController {

    @Autowired
    SlmTinNumbersSerice slmTinNumbersSerice;

    @Autowired
    SwmBarcodeExchangeLimitService swmBarcodeExchangeLimitService;

    @ApiOperation(value = "/SlmTinNumbers/findBySourceBarcodeNumber", notes = "")
    @RequestMapping(value = "/SlmTinNumbers/findBySourceBarcodeNumber/{sourceBarcodeNumber}", method = RequestMethod.GET)
    public List<SlmTinNumbersDto> findBySourceBarcodeNumber(@PathVariable String sourceBarcodeNumber) {
    
        List<SlmTinNumbersDto> dtoList= slmTinNumbersSerice.findBySourceBarcodeNumber(sourceBarcodeNumber);
        //System.out.println(dtoList.toString());
        return dtoList;
    }

    @ApiOperation(value = "/SlmTinNumbers", notes = "")
    @PostMapping("/SlmTinNumbers")
    public ResponseEntity<SlmTinNumbersDto> toSave(@Valid @RequestBody SlmTinNumbersDto dto)
            throws URISyntaxException {

        SlmTinNumbersDto result = slmTinNumbersSerice.save(dto);
        System.out.println(result.toString());

        return ResponseEntity.ok().body(result);
    }

}
package com.sunspring.asfclite.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import com.sunspring.asfclite.dto.SlmTinNumbersDto;
import com.sunspring.asfclite.dto.SwmBarcodeExchangeLimitDto;
import com.sunspring.asfclite.entity.SlmTinNumbers;
import com.sunspring.asfclite.service.SwmBarcodeExchangeLimitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SwmBarcodeExchangeLimitController {

    @Autowired
    SwmBarcodeExchangeLimitService swmBarcodeExchangeLimitService;

    @ApiOperation(value = "/SwmBarcodeExchangeLimit/findByMtlItemId", notes = "")
    @RequestMapping(value = "/SwmBarcodeExchangeLimit/findByMtlItemId/{mtlItemId}", method = RequestMethod.GET)
    public List<SwmBarcodeExchangeLimitDto> findByMtlItemId(@PathVariable Long mtlItemId) {
    
        List<SwmBarcodeExchangeLimitDto> dtoList= swmBarcodeExchangeLimitService.findByMtlItemId(mtlItemId);
        //System.out.println(dtoList.toString());
        return dtoList;
    }

    @ApiOperation(value = "/SwmBarcodeExchangeLimit/findByNewMtlItemId", notes = "")
    @RequestMapping(value = "/SwmBarcodeExchangeLimit/findByNewMtlItemId/{newMtlItemId}", method = RequestMethod.GET)
    public List<SwmBarcodeExchangeLimitDto> findByNewMtlItemId(@PathVariable Long newMtlItemId) {
    
        List<SwmBarcodeExchangeLimitDto> dtoList= swmBarcodeExchangeLimitService.findByNewMtlItemId(newMtlItemId);
        //System.out.println(dtoList.toString());
        return dtoList;
    }

    @ApiOperation(value = "/SwmBarcodeExchangeLimit/findByPlatform", notes = "")
    @RequestMapping(value = "/SwmBarcodeExchangeLimit/findByPlatform/{platform}", method = RequestMethod.GET)
    public List<SwmBarcodeExchangeLimitDto> findByPlatform(@PathVariable String platform) {
    
        List<SwmBarcodeExchangeLimitDto> dtoList= swmBarcodeExchangeLimitService.findByPlatform(platform);
        //System.out.println(dtoList.toString());
        return dtoList;
    }

    @ApiOperation(value = "/SwmBarcodeExchangeLimit", notes = "")
    @PostMapping("/SwmBarcodeExchangeLimit")
    public ResponseEntity<SwmBarcodeExchangeLimitDto> toSave(@Valid @RequestBody SwmBarcodeExchangeLimitDto dto)
            throws URISyntaxException {

        // SsgReportDayDto check =ssgReportDayService.toFindSsgReportDay(ssgReportDayDto);
        // if (check!=null){
        //     ssgReportDayDto.setId(check.getId());
        //     ssgReportDayDto.setCreatedBy(check.getCreatedBy());
        //     ssgReportDayDto.setCreatedDate(check.getCreatedDate());
        // }

        SwmBarcodeExchangeLimitDto result = swmBarcodeExchangeLimitService.save(dto);
        System.out.println(result.toString());

        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "/SwmBarcodeExchangeLimit", notes = "")
    @DeleteMapping("/SwmBarcodeExchangeLimit/{id}")
    public ResponseEntity<Void> deleteSsgProduct(@PathVariable Long id) {
        swmBarcodeExchangeLimitService.delete(id);
        return ResponseEntity.ok()
                // .headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString()))
                .build();
    }
}
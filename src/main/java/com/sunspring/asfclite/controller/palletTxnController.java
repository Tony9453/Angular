package com.sunspring.asfclite.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.hibernate.annotations.Any;
import io.swagger.annotations.ApiOperation;

import com.sunspring.asfclite.dto.*;
import com.sunspring.asfclite.service.*;
import com.sunspring.asfclite.entity.responseStatus;
//-----------------------------------test-------------------------------------------------
//-----------------------------------tony-------------------------------------------------
@Controller
@CrossOrigin
@RequestMapping("/api")
public class palletTxnController {
  @Autowired
  AsfcService asfcService;

  @ApiOperation(value = "棧板交易查詢", notes = "")
  @RequestMapping(path = "/getPalletTxn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<PalletTxnDto> getManualDemand(String txnDateStart, String txnDateEnd, String itemNumber,
      String palletNumber, String stationFromCode, String stationToCode) {
    return asfcService.getManualDemand(txnDateStart, txnDateEnd, itemNumber, palletNumber, stationFromCode,
        stationToCode);
  }

  @ApiOperation(value = "查詢barcode拋帳紀錄", notes = "")
  @RequestMapping(path = "/getCompleteIntoStock", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<Any> getCompleteIntoStock(String palletNumber) {
    return asfcService.getCompleteIntoStock(palletNumber);
  }

  @ApiOperation(value = "查詢barcode轉換紀錄", notes = "")
  @RequestMapping(path = "/getBarcodeExchange", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<Any> getBarcodeExchange() {
    return asfcService.getBarcodeExchange();
  }

  @ApiOperation(value = "查詢tin的ID", notes = "")
  @RequestMapping(path = "/getTinNumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<TinNumbersDto> getTinNumber(String boxcode) {
    return asfcService.getTinNumber(boxcode);
  }

  @ApiOperation(value = "查詢item的箱容", notes = "")
  @RequestMapping(path = "/getSsgItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<SsgItemsDto> getSsgItems(String item) {
    return asfcService.getSsgItems(item);
  }

  @ApiOperation(value = "Cosco外箱綁外箱", notes = "")
  @RequestMapping(path = "/postInsertTinNumberRelations", method = {
      RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String insertTinNumberRelations(@RequestBody TinNumberRelationsDto data) {
    System.out.println("112334556788");
    return asfcService.insertTinNumberRelations(data);
  }

  @ApiOperation(value = "Cosco內盒重綁外箱", notes = "")
  @RequestMapping(path = "/updataTinNumberRelations", method = {
      RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String updataTinNumberRelations(@RequestBody TinNumberRelationsDto data) {
    System.out.println("88888888888");
    return asfcService.updataTinNumberRelations(data);
  }

  // @ApiOperation(value = "舊外箱改為失效", notes = "")
  // @RequestMapping(path = "/updataTinNumbers", method = RequestMethod.GET,
  // produces = MediaType.APPLICATION_JSON_VALUE)
  // @ResponseBody
  // public List<TinNumbersDto> updataTinNumbers(String TIN_NUM_ID) {
  // return asfcService.updataTinNumbers(TIN_NUM_ID);
  // }

  @ApiOperation(value = "舊外箱改為失效", notes = "")
  @RequestMapping(path = "/updataTinNumbers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<TinNumbersDto> updataTinNumbers(String TIN_NUM_ID, String QUANTITY, String STATUS_ID, String ATTRIBUTE9) {
    return asfcService.updataTinNumbers(TIN_NUM_ID, QUANTITY, STATUS_ID, ATTRIBUTE9);
  }

  @ApiOperation(value = "建立外箱TIN", notes = "")
  @RequestMapping(value = "/createTinNumbersPo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String createTinNumbersPo(String PALLET_NUMBER) {
    return asfcService.createTinNumbersPo(PALLET_NUMBER);
  }

  @ApiOperation(value = "查詢TIN_PO_LINE_LOCATIONS", notes = "")
  @RequestMapping(path = "/getTinPoLineLocations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<TinPoLineLocations> getTinPoLineLocations(
      String PO_NO,
      String PO_RELEASE_NUM,
      String IPO_NO,
      String PO_SEQ,
      String ITEM_NO,
      String LOCATION_CODE,
      String CUSTOM_NUMBER,
      String TRANSACTION_ID,
      String PO_HEADER_ID,
      String PO_LINE_ID,
      String PO_LINE_LOCATION_ID,
      String ORGANIZATION_ID,
      String CUSTOM_HDR_ID) {
    return asfcService.getTinPoLineLocations(
        PO_NO,
        PO_RELEASE_NUM,
        IPO_NO,
        PO_SEQ,
        ITEM_NO,
        LOCATION_CODE,
        CUSTOM_NUMBER,
        TRANSACTION_ID,
        PO_HEADER_ID,
        PO_LINE_ID,
        PO_LINE_LOCATION_ID,
        ORGANIZATION_ID,
        CUSTOM_HDR_ID
    );
  }

}
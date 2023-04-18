package com.sunspring.asfclite.service;
import org.hibernate.annotations.Any;
import com.sunspring.asfclite.dto.*;
import com.sunspring.asfclite.repository.PalletTxnVRepository;
import com.sunspring.asfclite.entity.responseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsfcService {

  @Autowired
  PalletTxnVRepository palletTxnVRepository;

  public List<PalletTxnDto> getManualDemand(String txnDateStart, String txnDateEnd, String itemNumber,
      String palletNumber, String stationFromCode, String stationToCode) {
    return palletTxnVRepository.getManualDemand(txnDateStart, txnDateEnd, itemNumber, palletNumber, stationFromCode,
        stationToCode);
  }

  public List<TinPoLineLocations> getTinPoLineLocations(
      String  PO_NO,
      String  PO_RELEASE_NUM,
      String  IPO_NO,
      String  PO_SEQ,
      String  ITEM_NO,
      String  LOCATION_CODE,
      String  CUSTOM_NUMBER,
      String  TRANSACTION_ID,
      String  PO_HEADER_ID,
      String  PO_LINE_ID,
      String  PO_LINE_LOCATION_ID,
      String  ORGANIZATION_ID,
      String  CUSTOM_HDR_ID 
      ) {
        return  palletTxnVRepository.getTinPoLineLocations(
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

  public List<TinNumbersDto> getTinNumber(String boxcode) {
    return palletTxnVRepository.getTinNumber(boxcode);
  }

  public List<Any> getCompleteIntoStock(String palletNumber) {
    return palletTxnVRepository.getCompleteIntoStock(palletNumber);
  }

  public List<Any> getBarcodeExchange() {
    return palletTxnVRepository.getBarcodeExchange();
  }

  public List<SsgItemsDto> getSsgItems(String item) {
    return palletTxnVRepository.getSsgItems(item);
  }

  public String insertTinNumberRelations(TinNumberRelationsDto data) {
    return palletTxnVRepository.insertTinNumberRelations(data);
  }

  public String updataTinNumberRelations(TinNumberRelationsDto data) {
    return palletTxnVRepository.updataTinNumberRelations(data);
  }

  public List<TinNumbersDto> updataTinNumbers(String TIN_NUM_ID, String QUANTITY, String STATUS_ID, String ATTRIBUTE9) {
    return palletTxnVRepository.updataTinNumbers(TIN_NUM_ID, QUANTITY, STATUS_ID, ATTRIBUTE9);
  }

  public String createTinNumbersPo(String PALLET_NUMBER) {
    return palletTxnVRepository.createTinNumbersPo(PALLET_NUMBER);
  }

}

package com.sunspring.asfclite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "SWM_BARCODE_EXCHANGE_LIMIT", schema = "swm")
public class SwmBarcodeExchangeLimit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MTL_ITEM_ID")
    private Long mtlItemId;

    @Column(name = "NEW_MTL_ITEM_ID")
    private Long newMtlItemId;

    @Column(name = "NEW_WIP_ENTITY_ID")
    private Long newWipEntityId;

    @Column(name = "LIMIT_QTY")
    private Long limitQty;

    @Column(name = "ACTUAL_QTY")
    private Long actualQty;

    @Column(name = "PLATFORM")
    private String platform;

    @Column(name = "MTL_ITEM_NUMBER")
    private String mtlItemNumber;

    @Column(name = "NEW_MTL_ITEM_NUMBER")
    private String newMtlItemNumber;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Instant createdDate;

    @Column(name = "LAST_MODIFIED_BY")
    private Long lastModifieddBy;

    @Column(name = "LAST_MODIFIED_DATE")
    private Instant lastModifiedDate;

    @Column(name = "ATTRIBUTE_CATEGORY")
    private String attributeCategory;

    @Column(name = "attribute_1", length = 150)
    private String attribute1;

    @Column(name = "attribute_2", length = 150)
    private String attribute2;

    @Column(name = "attribute_3", length = 150)
    private String attribute3;

    @Column(name = "attribute_4", length = 150)
    private String attribute4;

    @Column(name = "attribute_5", length = 150)
    private String attribute5;

    @Column(name = "attribute_6", length = 150)
    private String attribute6;

    @Column(name = "attribute_7", length = 150)
    private String attribute7;

    @Column(name = "attribute_8", length = 150)
    private String attribute8;

    @Column(name = "attribute_9", length = 150)
    private String attribute9;

    @Column(name = "attribute_10", length = 150)
    private String attribute10;

    @Column(name = "attribute_11", length = 150)
    private String attribute11;

    @Column(name = "attribute_12", length = 150)
    private String attribute12;

    @Column(name = "attribute_13", length = 150)
    private String attribute13;

    @Column(name = "attribute_14", length = 150)
    private String attribute14;

    @Column(name = "attribute_15", length = 150)
    private String attribute15;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMtlItemId() {
        return mtlItemId;
    }

    public void setMtlItemId(Long mtlItemId) {
        this.mtlItemId = mtlItemId;
    }

    public Long getNewMtlItemId() {
        return newMtlItemId;
    }

    public void setNewMtlItemId(Long newMtlItemId) {
        this.newMtlItemId = newMtlItemId;
    }

    public Long getNewWipEntityId() {
        return newWipEntityId;
    }

    public void setNewWipEntityId(Long newWipEntityId) {
        this.newWipEntityId = newWipEntityId;
    }

    public Long getLimitQty() {
        return limitQty;
    }

    public void setLimitQty(Long limitQty) {
        this.limitQty = limitQty;
    }

    public Long getActualQty() {
        return actualQty;
    }

    public void setActualQty(Long actualQty) {
        this.actualQty = actualQty;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMtlItemNumber() {
        return mtlItemNumber;
    }

    public void setMtlItemNumber(String mtlItemNumber) {
        this.mtlItemNumber = mtlItemNumber;
    }

    public String getNewMtlItemNumber() {
        return newMtlItemNumber;
    }

    public void setNewMtlItemNumber(String newMtlItemNumber) {
        this.newMtlItemNumber = newMtlItemNumber;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Long getLastModifieddBy() {
        return lastModifieddBy;
    }

    public void setLastModifieddBy(Long lastModifieddBy) {
        this.lastModifieddBy = lastModifieddBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
    }

    public String getAttribute14() {
        return attribute14;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14;
    }

    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
    }
    
    
    @Override
    public String toString() {
        return "SwmBarcodeExchangeLimit{" +
            "id=" + getId() +
            ", mtlItemId='" + mtlItemId + "'" +
            ", newMtlItemId='" + newMtlItemId + "'" +
            "}";
    }


}
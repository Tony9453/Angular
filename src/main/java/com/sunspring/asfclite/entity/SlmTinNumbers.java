package com.sunspring.asfclite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "TIN_NUMBERS", schema = "slm")
public class SlmTinNumbers implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TIN_NUM_ID")
    private Long id;

    @Column(name = "ORGANIZATION_ID")
    private Long organizationId;

    @Column(name = "TIN_NUMBER")
    private String tinNumber;

    @Column(name = "STATUS_ID")
    private Long statusId;

    @Column(name = "SOURCE_TYPE_ID")
    private Long sourceTypeId;

    @Column(name = "SOURCE_LINE_ID")
    private Long sourceLineId;

    @Column(name = "LOT_NUMBER")
    private String lotNumber;

    @Column(name = "SOURCE_LOT_NUMBER")
    private String sourceLotNumber;

    @Column(name = "SOURCE_BARCODE_NUMBER")
    private String sourceBarcodeNumber;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "BOX_QUANTITY")
    private Long boxQuantity;

    @Column(name = "ASSY_WS_ID")
    private Long assyWsId;

    @Column(name = "CREATION_USER")
    private String creationUser;

    @Column(name = "CREATION_DATE")
    private Instant creationDate;

    @Column(name = "LAST_UPDATE_DATE")
    private Instant lastUpdateDate;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Column(name = "LAST_UPDATED_BY")
    private Long lastUpdatedBy;

    @Column(name = "LAST_UPDATE_LOGIN")
    private Long lastUpdateLogin;

    @Column(name = "ATTRIBUTE_CATEGORY")
    private String attributeCategory;

    @Column(name = "attribute1", length = 150)
    private String attribute1;

    @Column(name = "attribute2", length = 150)
    private String attribute2;

    @Column(name = "attribute3", length = 150)
    private String attribute3;

    @Column(name = "attribute4", length = 150)
    private String attribute4;

    @Column(name = "attribute5", length = 150)
    private String attribute5;

    @Column(name = "attribute6", length = 150)
    private String attribute6;

    @Column(name = "attribute7", length = 150)
    private String attribute7;

    @Column(name = "attribute8", length = 150)
    private String attribute8;

    @Column(name = "attribute9", length = 150)
    private String attribute9;

    @Column(name = "attribute10", length = 150)
    private String attribute10;

    @Column(name = "attribute11", length = 150)
    private String attribute11;

    @Column(name = "attribute12", length = 150)
    private String attribute12;

    @Column(name = "attribute13", length = 150)
    private String attribute13;

    @Column(name = "attribute14", length = 150)
    private String attribute14;

    @Column(name = "attribute15", length = 150)
    private String attribute15;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getSourceTypeId() {
        return sourceTypeId;
    }

    public void setSourceTypeId(Long sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }

    public Long getSourceLineId() {
        return sourceLineId;
    }

    public void setSourceLineId(Long sourceLineId) {
        this.sourceLineId = sourceLineId;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getSourceLotNumber() {
        return sourceLotNumber;
    }

    public void setSourceLotNumber(String sourceLotNumber) {
        this.sourceLotNumber = sourceLotNumber;
    }

    public String getSourceBarcodeNumber() {
        return sourceBarcodeNumber;
    }

    public void setSourceBarcodeNumber(String sourceBarcodeNumber) {
        this.sourceBarcodeNumber = sourceBarcodeNumber;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getBoxQuantity() {
        return boxQuantity;
    }

    public void setBoxQuantity(Long boxQuantity) {
        this.boxQuantity = boxQuantity;
    }

    public Long getAssyWsId() {
        return assyWsId;
    }

    public void setAssyWsId(Long assyWsId) {
        this.assyWsId = assyWsId;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Instant getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Instant lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Long getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(Long lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
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
        return "SlmTinNumbers{" +
            "id=" +id +
            ", organizationId=" + organizationId + "" +
            ", tinNumber=" + tinNumber + "" +
            ", sourceBarcodeNumber='" + sourceBarcodeNumber + "'" +
            "}";
    }
}
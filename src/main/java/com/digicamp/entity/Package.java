package com.digicamp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.Date;

@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name ="pid")
    private Integer packageNumber;

    @Column(name ="order_id")
    private String orderId;

    @NotBlank
    @Column(name ="owner_name",nullable = false)
    private String ownerName;

    @NotNull
    @Range(min = 1000000000, max = 9999999999l, message = "Mobile no. must be of 10 digits")
    @Column(nullable = false, name = "mobile_no")
    private Long mobileNo;

    @Column(name = "courier_partner")
    private String courier;

    @Column(name = "delivery_date")
    private Date arrivalDate;

    @Schema(allowableValues = { "1", "0"})
    @Column(name = "is_picked")
    private String isPicked="0";



    public Package() {
    }

    public Package(Integer packageNumber, String orderId, String ownerName, Long mobileNo, String courier, Date arrivalDate, String isPicked) {
        this.packageNumber = packageNumber;
        this.orderId = orderId;
        this.ownerName = ownerName;
        this.mobileNo = mobileNo;
        this.courier = courier;
        this.arrivalDate = arrivalDate;
        this.isPicked = isPicked;
    }

    public Integer getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getIsPicked() {
        return isPicked;
    }

    public void setIsPicked(String isPicked) {
        this.isPicked = isPicked;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageNumber=" + packageNumber +
                ", orderId='" + orderId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", mobileNo=" + mobileNo +
                ", courier='" + courier + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", isPicked='" + isPicked + '\'' +
                '}';
    }
}

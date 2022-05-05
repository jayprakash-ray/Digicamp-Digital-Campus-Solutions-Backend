package com.digicamp.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @Column(name = "courier_partner")
    private String courier;

    @Column(name = "delivery_date")
    private Date arrivalDate;

    @Schema(allowableValues = { "Yes", "N0"})
    @Column(name = "is_picked")
    private String isPicked;

    @NotBlank
    @Column(name ="picked_by",nullable = false)
    private String pickedBy;

    @Column(name = "pickup_date")
    private Date pickedOn;

    @Column(name = "receiver_image")
    private String receiverImage;

    public Package() {
    }

    public Package(Integer packageNumber, String orderId, String ownerName, String courier, Date arrivalDate, String isPicked, String pickedBy, Date pickupOn, String receiverImage) {
        this.packageNumber = packageNumber;
        this.orderId = orderId;
        this.ownerName = ownerName;
        this.courier = courier;
        this.arrivalDate = arrivalDate;
        this.isPicked = isPicked;
        this.pickedBy = pickedBy;
        this.pickedOn = pickupOn;
        this.receiverImage = receiverImage;
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

    public String getPickedBy() {
        return pickedBy;
    }

    public void setPickedBy(String pickedBy) {
        this.pickedBy = pickedBy;
    }

    public Date getPickupOn() {
        return pickedOn;
    }

    public void setPickupOn(Date pickupOn) {
        this.pickedOn = pickupOn;
    }

    public String getReceiverImage() {
        return receiverImage;
    }

    public void setReceiverImage(String receiverImage) {
        this.receiverImage = receiverImage;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageNumber=" + packageNumber +
                ", orderId='" + orderId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", courier='" + courier + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", isPicked='" + isPicked + '\'' +
                ", pickedBy='" + pickedBy + '\'' +
                ", pickedOn=" + pickedOn +
                ", receiverImage='" + receiverImage + '\'' +
                '}';
    }
}

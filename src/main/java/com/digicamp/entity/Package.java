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
    private Integer pid;

    @Column(name ="order_id")
    private String orderId;

    @NotBlank
    @Column(name ="owner_name",nullable = false)
    private String ownerName;

    @Column(name = "courier_partner")
    private String courierPartner;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Schema(allowableValues = { "Yes", "N0"})
    @Column(name = "is_picked")
    private String isPicked;

    @NotBlank
    @Column(name ="picked_by",nullable = false)
    private String pickedBy;

    @Column(name = "pickup_date")
    private Date pickupDate;

    @Column(name = "receiver_image")
    private Blob receiverImage;

    public Package() {
    }

    public Package(Integer pid, String orderId, String ownerName, String courierPartner, Date deliveryDate, String isPicked, String pickedBy, Date pickupDate, Blob receiverImage) {
        this.pid = pid;
        this.orderId = orderId;
        this.ownerName = ownerName;
        this.courierPartner = courierPartner;
        this.deliveryDate = deliveryDate;
        this.isPicked = isPicked;
        this.pickedBy = pickedBy;
        this.pickupDate = pickupDate;
        this.receiverImage = receiverImage;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getCourierPartner() {
        return courierPartner;
    }

    public void setCourierPartner(String courierPartner) {
        this.courierPartner = courierPartner;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Blob getReceiverImage() {
        return receiverImage;
    }

    public void setReceiverImage(Blob receiverImage) {
        this.receiverImage = receiverImage;
    }

    @Override
    public String toString() {
        return "Package{" +
                "pid=" + pid +
                ", orderId='" + orderId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", courierPartner='" + courierPartner + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", isPicked='" + isPicked + '\'' +
                ", pickedBy='" + pickedBy + '\'' +
                ", pickupDate=" + pickupDate +
                ", receiverImage=" + receiverImage +
                '}';
    }
}

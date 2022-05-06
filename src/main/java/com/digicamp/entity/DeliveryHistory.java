package com.digicamp.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class DeliveryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name ="uid")
    private Integer uid;

    @NotNull
    @Column(name = "recv_roll_number")
    private String rollNo;

    @NotBlank
    @Column(name ="picked_by",nullable = false)
    private String pickedBy;

    @NotNull
    @Range(min = 1000000000, max = 9999999999l, message = "Mobile no. must be of 10 digits")
    @Column(nullable = false, name = "mobile_no")
    private Long MobileNo;

    @Column(name = "pickup_date")
    private Date pickedOn;

    @Column(name = "receiver_image")
    private String receiverImage;

    public DeliveryHistory(Integer uid, String rollNo, String pickedBy, Long mobileNo, Date pickedOn, String receiverImage) {
        this.uid = uid;
        this.rollNo = rollNo;
        this.pickedBy = pickedBy;
        MobileNo = mobileNo;
        this.pickedOn = pickedOn;
        this.receiverImage = receiverImage;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getPickedBy() {
        return pickedBy;
    }

    public void setPickedBy(String pickedBy) {
        this.pickedBy = pickedBy;
    }

    public Long getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        MobileNo = mobileNo;
    }

    public Date getPickedOn() {
        return pickedOn;
    }

    public void setPickedOn(Date pickedOn) {
        this.pickedOn = pickedOn;
    }

    public String getReceiverImage() {
        return receiverImage;
    }

    public void setReceiverImage(String receiverImage) {
        this.receiverImage = receiverImage;
    }

    @Override
    public String toString() {
        return "DeliveryHistory{" +
                "uid=" + uid +
                ", rollNo='" + rollNo + '\'' +
                ", pickedBy='" + pickedBy + '\'' +
                ", MobileNo=" + MobileNo +
                ", pickedOn=" + pickedOn +
                ", receiverImage='" + receiverImage + '\'' +
                '}';
    }
}

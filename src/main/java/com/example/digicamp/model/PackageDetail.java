package com.example.digicamp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import javax.persistence.*;
import java.util.Date;




@Entity
@Table(name = "package_detail")
public class PackageDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sno;

    @Column(name ="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="website")
    private String website;

    @Column(name="received_date")
    private Date receivedDate;

    @Column(name="order_id")
    private long orderId;

    @Column(name="is_picked")
    private boolean isPicked;

    @Column(name="picked_date")
    private Date pickedDate;


    public long getSno() {
        return sno;
    }

    public void setSno(long sno) {
        this.sno = sno;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }

    public Date getPickedDate() {
        return pickedDate;
    }

    public void setPickedDate(Date pickedDate) {
        this.pickedDate = pickedDate;
    }

    public PackageDetail(long sno, String firstName, String lastName, String website, Date receivedDate, long orderId, boolean isPicked, Date pickedDate) {
        this.sno = sno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.website = website;
        this.receivedDate = receivedDate;
        this.orderId = orderId;
        this.isPicked = isPicked;
        this.pickedDate = pickedDate;
    }

    public PackageDetail() {
    }
}

package com.digicamp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class LostAndFound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Integer itemId;


    private String itemName;

    private String foundAt;

    private Date date;

    private String itemImage;

    private String collectFrom;

    @Column(nullable = false)
    private int lostOrFound;

    @Column
    private String remarks;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getFoundAt() {
        return foundAt;
    }

    public void setFoundAt(String foundAt) {
        this.foundAt = foundAt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getCollectFrom() {
        return collectFrom;
    }

    public void setCollectFrom(String collectFrom) {
        this.collectFrom = collectFrom;
    }

    public int getLostOrFound() {
        return lostOrFound;
    }

    public void setLostOrFound(int lostOrFound) {
        this.lostOrFound = lostOrFound;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LostAndFound(){}

    public LostAndFound(Integer itemId, String itemName, String foundAt, Date date, String itemImage, String collectFrom, int lostOrFound, String remarks) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.foundAt = foundAt;
        this.date = date;
        this.itemImage = itemImage;
        this.collectFrom = collectFrom;
        this.lostOrFound = lostOrFound;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "LostAndFound{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", foundAt='" + foundAt + '\'' +
                ", date=" + date +
                ", itemImage='" + itemImage + '\'' +
                ", collectFrom='" + collectFrom + '\'' +
                ", lostOrFound=" + lostOrFound +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}

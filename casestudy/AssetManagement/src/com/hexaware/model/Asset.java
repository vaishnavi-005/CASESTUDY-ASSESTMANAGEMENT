package com.hexaware.model;


import java.time.LocalDate;

public class Asset {
    private int assetId;
    private String name;
    private String type;
    private String serialNumber;
    private LocalDate purchaseDate;
    private String location;
    private String status;
    private int ownerId;

    public Asset() {}

    public Asset(int assetId, String name, String type, String serialNumber, LocalDate purchaseDate, String location, String status, int ownerId) {
        this.assetId = assetId;
        this.name = name;
        this.type = type;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.location = location;
        this.status = status;
        this.ownerId = ownerId;
    }



    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    
}


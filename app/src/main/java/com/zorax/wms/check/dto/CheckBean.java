package com.zorax.wms.check.dto;

/**
 * @创作者 czp
 * @创作时间 2021/6/23 14:56
 * @描述
 */
public class CheckBean {
    private String location;

    private String tray;

    private String singleMaterialNum;

    private String singleProductType;

    private int instoreQty;

    private int outstoreQty;

    private int inventoryQty;

    private int actualQty;

    public String getLocation() {
        return location;
    }

    public CheckBean setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getTray() {
        return tray;
    }

    public CheckBean setTray(String tray) {
        this.tray = tray;
        return this;
    }

    public String getSingleMaterialNum() {
        return singleMaterialNum;
    }

    public CheckBean setSingleMaterialNum(String singleMaterialNum) {
        this.singleMaterialNum = singleMaterialNum;
        return this;
    }

    public String getSingleProductType() {
        return singleProductType;
    }

    public CheckBean setSingleProductType(String singleProductType) {
        this.singleProductType = singleProductType;
        return this;
    }

    public int getInstoreQty() {
        return instoreQty;
    }

    public CheckBean setInstoreQty(int instoreQty) {
        this.instoreQty = instoreQty;
        return this;
    }

    public int getOutstoreQty() {
        return outstoreQty;
    }

    public CheckBean setOutstoreQty(int outstoreQty) {
        this.outstoreQty = outstoreQty;
        return this;
    }

    public int getInventoryQty() {
        return inventoryQty;
    }

    public CheckBean setInventoryQty(int inventoryQty) {
        this.inventoryQty = inventoryQty;
        return this;
    }

    public int getActualQty() {
        return actualQty;
    }

    public CheckBean setActualQty(int actualQty) {
        this.actualQty = actualQty;
        return this;
    }
}

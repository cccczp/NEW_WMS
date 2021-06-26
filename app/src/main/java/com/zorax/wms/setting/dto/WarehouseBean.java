package com.zorax.wms.setting.dto;

/**
 * @创作者 czp
 * @创作时间 2021/6/22 14:59
 * @描述
 */
public class WarehouseBean {

    private int itemType = IWarehouseItemType.VERTICAL;

    private boolean isChecked;

    private String warehouseName;

    public boolean isChecked() {
        return isChecked;
    }

    public WarehouseBean setChecked(boolean checked) {
        isChecked = checked;
        return this;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public WarehouseBean setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
        return this;
    }

    public int getItemType() {
        return itemType;
    }

    public WarehouseBean setItemType(int itemType) {
        this.itemType = itemType;
        return this;
    }

    public interface IWarehouseItemType
    {
        int VERTICAL = 0;
        int HORIZANTAL = 1;
    }
}

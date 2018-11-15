package com.zebra.zebraerp.api.paramobject;

/**
 * 电车修改PO
 * 
 * @author owen
 */
public class BikeEditPO extends BikeAddPO {
    private String bikeCode;

    public String getBikeCode() {
        return bikeCode;
    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }
}

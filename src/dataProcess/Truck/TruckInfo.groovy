package dataProcess.Truck

import groovy.xml.MarkupBuilder

/**
 * Created by Badger on 16/1/14.
 */
class TruckInfo {
    public String truckIdFull
    public String truckId
    public String licNbr
    public String licState
    public String truckWeight
    public String safeWeight
    public String tellNbr

    String getTruckCompCode() {
        return truckCompCode
    }

    void setTruckCompCode(String truckCompCode) {
        if (truckCompCode)
            this.truckCompCode = truckCompCode
        else
            this.truckCompCode = 'ALLTRUCKS'
    }
    public String truckCompCode

    public TruckInfo() {
        safeWeight = 100000
    }

    public TruckInfo(String truckIDStr) {
        safeWeight = 100000
        this.truckIdFull = truckIDStr
        this.truckId = truckIDStr.substring(2, 7)
        this.licNbr = truckIDStr.substring(1, 7)
        this.licState = truckIDStr.substring(0, 1)
    }

}

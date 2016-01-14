package dataProcess.Truck

import groovy.xml.MarkupBuilder

/**
 * Created by Badger on 16/1/14.
 */
class TruckSnxCreater {

    public static def getSnx(List<TruckInfo> truckInfoList) {

        def snxUnitString = new StringWriter()
        def snxUnits = new MarkupBuilder(snxUnitString)

        snxUnits.'argo:snx'('xmlns:argo': 'http://www.navis.com/argo', 'xmlns:xsi': 'http://www.w3.org/2001/XMLSchema-instance', 'xsi:schemaLocation': 'http://www.navis.com/argo snx.xsd') {

            truckInfoList.each { item ->
                if (item.truckId) {
                    'truck'('id': item.truckId,
                            'license-nbr': item.licNbr,
                            'license-state': item.licState,
                            'license-expiration': '2050-01-01T00:00:00',
                            'tare-weight': item.truckWeight,
                            'safe-weight': item.safeWeight,
                            'trucking-co-id': item.truckCompCode)
                }
            }

        }
        return snxUnitString.toString()
    }
}

package main;

import dataProcess.Truck.TruckProcess;

/**
 * Created by Badger on 16/1/14.
 */
public class Start {
    private String truckDocPath = "/Users/Badger/Project/项目/温州-龙湾/Code/CarInfoImporter/Documents/车号公司2.xls";

    public static void main(String[] args) {
        new Start().startProcess();
    }

    public void startProcess() {
        UiGlobal.logger.info(new TruckProcess(truckDocPath).getSnx().toString());
    }
}

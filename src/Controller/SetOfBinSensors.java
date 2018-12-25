/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.BinSensor;
import java.util.ArrayList;

/**
 *
 * @author Oshin
 */
public class SetOfBinSensors extends ArrayList<BinSensor> {

    private static SetOfBinSensors SetOfBinSensorsInstance;

    private SetOfBinSensors() {
    }
/**
 * 
 * @return SetOfBinSensorsInstance
 */
    public static SetOfBinSensors getSetOfBinSensorsInstance() {
        if (SetOfBinSensorsInstance == null) {
            SetOfBinSensorsInstance = new SetOfBinSensors();
        }
        return SetOfBinSensorsInstance;
    }
/**
 * 
 * @param binsensor 
 */
    public void addBinSensor(BinSensor binsensor) {
        super.add(binsensor);
        System.out.println("Bin Sensor added !");
    }
     public void removeBinSensor(BinSensor binsensor) {
        super.remove(binsensor);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Sensor;
import java.util.ArrayList;

/**
 *
 * @author Oshin
 */
public class SetOfSensors extends ArrayList<Sensor> {

    private static SetOfSensors SetOfSensorsInstance;

    private SetOfSensors() {
    }
/**
 * 
 * @return SetOfSensorsInstance
 */
    public static SetOfSensors getSetOfSensorsInstance() {
        if (SetOfSensorsInstance == null) {
            SetOfSensorsInstance = new SetOfSensors();
        }
        return SetOfSensorsInstance;
    }
/**
 * 
 * @param sensor 
 */
    public void addSensor(Sensor sensor) {
        super.add(sensor);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.FloodSensor;
import java.util.ArrayList;

/**
 *
 * @author Oshin
 */
public class SetOfFloodSensors extends ArrayList<FloodSensor> {
    private static SetOfFloodSensors SetOfFloodSensorsInstance;
    private SetOfFloodSensors(){
    }
    public static SetOfFloodSensors getSetOfFloodSensorsInstance(){
        if(SetOfFloodSensorsInstance==null){
            SetOfFloodSensorsInstance=new SetOfFloodSensors();
        }
        return SetOfFloodSensorsInstance;
    }
    
    public void addFloodSensor(FloodSensor floodsensor){
        super.add(floodsensor);
        System.out.println("Flood Sensor Added !");
    }
    
}

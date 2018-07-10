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
    public void addFloodSensor(FloodSensor floodsensor){
        super.add(floodsensor);
        System.out.println("Flood Sensor Added !");
    }
    
}

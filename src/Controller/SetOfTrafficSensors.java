/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.TrafficSensor;
import java.util.ArrayList;

/**
 *
 * @author Oshin
 */
public class SetOfTrafficSensors extends ArrayList<TrafficSensor>{
    public void addTrafficSensor(TrafficSensor trfficSensor){
        super.add(trfficSensor);
        System.out.println("Traffic Sensor Added");
    }
}
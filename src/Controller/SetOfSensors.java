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
public class SetOfSensors extends ArrayList<Sensor>{
   
    public void addSensor(Sensor sensor){
        super.add(sensor);
    }
 }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.SensorMonitor;
import java.util.ArrayList;

/**
 *
 * @author Oshin
 */
public class SetOfSensorMonitors extends ArrayList<SensorMonitor>{
     private static SetOfSensorMonitors SetOfSensorMonitorsInstance;
     private SetOfSensorMonitors(){
     }
     public static SetOfSensorMonitors getSetOfSensorMonitorsInstance(){
         if(SetOfSensorMonitorsInstance==null){
             SetOfSensorMonitorsInstance=new SetOfSensorMonitors();
         }
         return SetOfSensorMonitorsInstance;
     }
     
     public void addSensorMonitor(SensorMonitor aSensorMonitor) {
        super.add(aSensorMonitor);
         System.out.println("Sensor Monitor Added");
    }
    
    
    
}

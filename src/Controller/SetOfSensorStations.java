/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.SensorStation;
import java.util.ArrayList;

/**
 *
 * @author Debug
 */
public class SetOfSensorStations extends ArrayList<SensorStation>{
    
     private static SetOfSensorStations SetOfSensorStationsInstance;
     private SetOfSensorStations(){
         
     }
     
      public static SetOfSensorStations getSetOfSensorStationsInstance() {
        if (SetOfSensorStationsInstance == null) {
            SetOfSensorStationsInstance = new SetOfSensorStations();
        }
        return SetOfSensorStationsInstance;
    }
     
      
       public void addSensorStation(SensorStation aSensorStation) {
        super.add(aSensorStation);
        System.out.println("Sensor Station Added");
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import Controller.*;
import java.util.UUID;
/**
 *
 * @author Oshin
 */


/**
 * SensorMonitor class contain details of a Sensor Monitor 
 * SensorMonitor class contain Sensor Station as an observer
 * @author Oshin
 */
public class SensorMonitor implements Subject,Observer{

    private String sensorMonitorID;
   //interval is the frequency
    private Double interval;
   //isActive is status(active/not active)
    private boolean isActive;
    private Sensor sensor;
    private ArrayList<Observer> Observers;
    
    
     /**
     * Constructor for Sensor Monitor object with status , interval , Sensor Type
     * @param inInterval
     * @param inIsActive
     * @param inSensorType 
     */
    public SensorMonitor(String inSensorID,Double inInterval,String inIsActive,String inSensorType){
        this.sensorMonitorID = UUID.randomUUID().toString();
        
        this.interval=inInterval;
        if(inIsActive.equals("Active")){
            this.isActive=true;
        }
        else
        {
            this.isActive=false;
        }
        
         if (inSensorType.equals("Bin Sensor")) {
            this.sensor = new BinSensor(inSensorID);
        } else if (inSensorType.equals("Flood Sensor")) {
            this.sensor = new FloodSensor(inSensorID);
        } else {
            this.sensor = new TrafficSensor(inSensorID);
            // System.out.println(inSensorID);
        }
        
        
        
    }
    
    @Override
    public void registerObserver(Observer obs) {
        Observers.add(obs);
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void unRegisterObserver(Observer obs) {
        Observers.remove(obs);
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void Notify() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void update(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
  /**
     * @return the sensorMonitorID
     */
    public String getSensorMonitorID() {
        return sensorMonitorID;
    }

    

   
   

    /**
     * @return the isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    

    /**
     * @return the sensor
     */
    public Sensor getSensor() {
        return sensor;
    }

  
    /**
     * @return the interval
     */
    public Double getInterval() {
       return interval;
    }

       
    
    
    
    
    
    
}

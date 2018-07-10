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
    private Integer readingsCount;

    
    private SetOfBinSensors SOBS=new SetOfBinSensors();
    private SetOfFloodSensors SOFS=new SetOfFloodSensors();
    private SetOfTrafficSensors SOTS=new SetOfTrafficSensors();
    
    
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
            this.sensor=new BinSensor(inSensorID);
          SOBS.addBinSensor(new BinSensor(inSensorID));
        } else if (inSensorType.equals("Flood Sensor")) {
            this.sensor = new FloodSensor(inSensorID);
            SOFS.addFloodSensor(new FloodSensor(inSensorID));
        } else {
            this.sensor = new TrafficSensor(inSensorID);
            SOTS.addTrafficSensor(new TrafficSensor(inSensorID));
        }
     }
     public void doTick() {
         System.out.println("Before Interval :" +interval);
       
            getReadingsCount();
         }
    
    @Override
    public void registerObserver(Observer obs) {
        getObservers().add(obs);
    }

    @Override
    public void unRegisterObserver(Observer obs) {
        getObservers().remove(obs);
    }

    @Override
    public void Notify() {
    }

    @Override
    public void update(Object ob) {
       if(ob instanceof Clock){
      //     System.out.println("This is Clock !");
           this.doTick();
       }
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
     * @return the readingsCount
     */
    public void getReadingsCount() {
       System.out.println("------------------------Current Data Count : 30 --------------------------------------");
      }

    /**
     * @param readingsCount the readingsCount to set
     */
    public void setReadingsCount(Integer readingsCount) {
        this.readingsCount = readingsCount;
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

       
    
    /**
     * @return the Observers
     */
    public ArrayList<Observer> getObservers() {
        return Observers;
    }

  
    
    
    
    
}

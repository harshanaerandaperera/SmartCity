/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import Controller.*;
import java.util.Random;
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
    
    
    private Data reading;

   private SetOfSensors SOS=new SetOfSensors();
    private SetOfBinSensors SOBS=new SetOfBinSensors();
    private SetOfFloodSensors SOFS=new SetOfFloodSensors();
    private SetOfTrafficSensors SOTS=new SetOfTrafficSensors();
    private SetOfSensorMonitors SOSM;
    
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
          SOS.addSensor(sensor);
        } else if (inSensorType.equals("Flood Sensor")) {
            this.sensor = new FloodSensor(inSensorID);
            SOFS.addFloodSensor(new FloodSensor(inSensorID));
            SOS.addSensor(sensor);
        } else {
            this.sensor = new TrafficSensor(inSensorID);
            SOTS.addTrafficSensor(new TrafficSensor(inSensorID));
            SOS.addSensor(sensor);
        }
     }
     public void getSetOfSensorMonitors(SetOfSensorMonitors SOSM){
        this.SOSM=SOSM;
    }
     public void doTick(Observer observer) {
         System.out.println("Before Interval :" +interval);
       
            shouldTakeReading(observer);
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
    public void update(Object ob,Observer observer) {
       if(ob instanceof Clock){
          
           this.doTick(observer);
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
 
    public void shouldTakeReading(Observer observer) {
        
        for(int i=0;i<SOSM.size();i++){
            if(SOSM.get(i)==observer){
               System.out.println(SOSM.get(i));
               
              this.reading=SOSM.get(i).sensor.getData();
              System.out.println(this.reading.limit);
           }
            
        }
       
      //  embellishData();
        
    }

    
//     public EmbellishedData embellishData(){
//        Random r = new Random();
//        long timeInMills = r.nextInt(100); 
//        ArrayList<Double> coords = getCoords();
//        String id = sensor.getID();
//      //  EmbellishedData embellishedData = new EmbellishedData(reading, timeInMills, coords, sensor.getID());
//        
//        return embellishedData;
//    }
    
   
    

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import Controller.*;
import java.io.Serializable;



/**
 * SensorMonitor class contain details of a Sensor Monitor SensorMonitor class
 * contain Sensor Station as an observer
 *
 * @author Oshin
 */
public class SensorMonitor implements Subject, Observer ,Serializable{

    
    
    private String sensorMonitorID;
    private ArrayList<Double> coords;
    //isActive is status(active/not active) 
    private boolean isActive;
    //interval is the frequency
     private Double interval;
     //Here Observer Array List Type is Observer for future purpose
    // private ArrayList<Observer> Observers;
 
    //TOdo - private Long lastReadingTime;
     public double readingsCount;
     private Sensor sensor;
     //Todo-public Data reading;
    
     //extra
     
     private String status;
     private String sensorDescription;
     //As one observer for a one sensor monitor we implemented as this
     private Observer observer;
     private EmbelishedData embellishedData;
     private String stationName;
     
    SetOfTrafficSensors SOTS = SetOfTrafficSensors.getSetOfTrafficSensorsInstance();
    SetOfSensorMonitors SOSM = SetOfSensorMonitors.getSetOfSensorMonitorsInstance();
    SetOFData SOD = SetOFData.getSetOFDataInstance();
    SetOfEmbelishedData SOED = SetOfEmbelishedData.getSetOfEmbelishedDataInstance();
    SetOfBinSensors SOBS = SetOfBinSensors.getSetOfBinSensorsInstance();
    SetOfFloodSensors SOFS = SetOfFloodSensors.getSetOfFloodSensorsInstance();
    SetOfSensors SOS = SetOfSensors.getSetOfSensorsInstance();

   /**
    * 
    * @param inSensorID
    * @param insensorStationName
    * @param inIsActive
    * @param inInterval
    * @param inSensorType 
    */
    public SensorMonitor(String inSensorID,String insensorStationName,String inIsActive,Double inInterval,String inSensorType) {
        this.sensorMonitorID = inSensorID;
        this.stationName=insensorStationName;
        // Observers=new ArrayList<>();
        this.interval = inInterval;

        if (inIsActive.equals("Active")) {
            this.isActive = true;
            this.status="Active";
        } else {
            this.isActive = false;
            this.status="Not-Active";
                    
        }

        if (inSensorType.equals("Bin Sensor")) {
            this.sensor = new BinSensor(inSensorID,inInterval);
          //  this.sensor.setFrequency(inInterval);
            SOBS.addBinSensor(new BinSensor(inSensorID,inInterval));
            SOS.addSensor(sensor);
            this.sensorDescription="Bin Sensor";
        } else if (inSensorType.equals("Flood Sensor")) {
            this.sensor = new FloodSensor(inSensorID,inInterval);
           // this.sensor.setFrequency(inInterval);
            SOFS.addFloodSensor(new FloodSensor(inSensorID,inInterval));
            SOS.addSensor(sensor);
            this.sensorDescription="Flood Sensor";
        } else {
            this.sensor = new TrafficSensor(inSensorID,inInterval);
            //this.sensor.setFrequency(inInterval);
            SOTS.addTrafficSensor(new TrafficSensor(inSensorID,inInterval));
            SOS.addSensor(sensor);
            this.sensorDescription="Traffic Sensor";
        }
         Clock clock = Clock.getInstance();
        clock.registerObserver((Observer)this);
    }

    SensorMonitor() {

    }
/**
 * 
 * @param observer 
 */
    public void doTick(Observer observer) {

        System.out.println("take readings------------------------------------------------------------------------------------------------------------");
        shouldTakeReading(observer);
    }
/**
 * 
 * @param obs 
 */
    @Override
    public void registerObserver(Observer obs) {
        //getObservers().add(obs);
         setObserver(obs);
       }
/**
 * 
 * @param obs 
 */
    @Override
    public void unRegisterObserver(Observer obs) {
      //  getObservers().remove(obs);
         setObserver(null);
    }

    public void Notify() {
    }
/**
 * 
 * @param ob
 * @param observer 
 */
    @Override
    public void update(Object ob, Observer observer) {
        if (ob instanceof Clock) {

            this.doTick(observer);
        }
    }

   /**
    * 
    * @return sensorMonitorID
    */
    public String getSensorMonitorID() {
        return sensorMonitorID;
    }

   /**
    * 
    * @return isActive
    */
    public boolean isIsActive() {
        return isActive;
    }
/**
 * 
 * @param observer 
 */
    public void shouldTakeReading(Observer observer) {
       
        for (int i = 0; i < SOSM.size(); i++) {
              if (SOSM.get(i) == observer) {             
                  SOSM.get(i).readingsCount=SOSM.get(i).getSensor().getData();
                    if(SOSM.get(i).status.equals("Active")){
                        if(SOSM.get(i).readingsCount==SOSM.get(i).getInterval()){
                                 SOSM.get(i).status="Not-Active";
                        embellishData(SOSM.get(i).getSensor(),SOSM.get(i).readingsCount);
                        notifyObservers();
                        }
                    }
                }
            
        }


    }
    /**
     * 
     * @param senor
     * @param count 
     */
    
       public void embellishData(Sensor senor,double count){
        long timeInMills = 10; 
        ArrayList<Double> coords = getCoords();
        String id = sensor.getSensorId();
        embellishedData = new EmbelishedData(count,this.stationName,this.interval, timeInMills, coords, id);
    }
/**
 * 
 * @param sid 
 */
    public void calculateDataCount(String sid) {

        for (int i = 0; i < SOD.size(); i++) {
            if (SOD.get(i).getSensorid() == sid) {
                System.out.println("Sensor ID Match -------------------------------------------------------------------------");
            }

        }

    }
    /**
     * 
     * @return sensor
     */
    public Sensor getSensor() {
        return sensor;
    }

   /**
    * 
    * @return interval
    */
    public Double getInterval() {
        return interval;
    }

//    /**
//     * @return the Observers
//     */
//    public ArrayList<Observer> getObservers() {
//        return Observers;
//    }

  
    /**
     * 
     * @return SOED
     */
    public SetOfEmbelishedData getSOED() {
        return SOED;
    }
    
  /**
   * 
   * @return status
   */
    public String getStatus() {
        return status;
    }

   /**
    * 
    * @param status 
    */
    public void setStatus(String status) {
        this.status = status;
    }

   /**
    * 
    * @return sensorDescription
    */
    public String getSensorDescription() {
        return sensorDescription;
    }

    /**
     * 
     * @param sensorDescription 
     */
    public void setSensorDescription(String sensorDescription) {
        this.sensorDescription = sensorDescription;
    }

 /**
  * 
  * @return coords
  */
    public ArrayList<Double> getCoords() {
        return coords;
    }

   /**
    * 
    * @param coords 
    */
    public void setCoords(ArrayList<Double> coords) {
        this.coords = coords;
    }

    @Override
    public void notifyObservers() {

      observer.update(this.embellishedData, this.observer);


    }
/**
 * 
 * @return observer
 */
    public Observer getObserver() {
        return observer;
    }

   /**
    * 
    * @param observer 
    */
    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    
   

}

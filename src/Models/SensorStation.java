/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controller.Observer;
import Controller.PublicInterface;
import Controller.Subject;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Harshana
 */
public class SensorStation implements Subject, Observer ,Serializable{
    
    private ArrayList<SensorMonitor> sensormonitors=new ArrayList<SensorMonitor>() ;
    private String stationID;
    private String stationName;
    //As thiis is an Association relationship with location contain an object from the location class
    private Location location;
    private ArrayList<Double> coords = new ArrayList<>();
    //Hrere is one single observer
    private Observer observer;
    public SensorStation(){
        
    }
    /**
     * 
     * @param instationID
     * @param instationName
     * @param inlatitude
     * @param inlongitude 
     */
    public SensorStation(String instationID,String instationName,Double inlatitude,Double inlongitude) {
        this.stationID = instationID;
        this.stationName=instationName;
        location=new Location(inlatitude,inlongitude);
    }
    /**
     * 
     * @param aSensorMonitor 
     */
    public void addNewSensorMonitor(SensorMonitor aSensorMonitor){
        sensormonitors.add(aSensorMonitor);
        aSensorMonitor.registerObserver((Observer)this);
    }
    /**
     * 
     * @param aSensorMonitor 
     */
    public void removeSensorMonitor(SensorMonitor aSensorMonitor){
        sensormonitors.remove(aSensorMonitor);
    }
    /**
     * 
     * @param sensorMonitorId
     * @return sensormonitor
     */
    public SensorMonitor getSensorMonitor(String sensorMonitorId){
       SensorMonitor sensormonitor=new SensorMonitor();
        for(int i=0;i<sensormonitors.size();i++){
            if(sensormonitors.get(i).getSensorMonitorID().equals(sensorMonitorId)){
                sensormonitor=sensormonitors.get(i);
            }
        }
        return sensormonitor;
        
    }
    /**
     * 
     * @return sensormonitors
     */
    public ArrayList<SensorMonitor> getSensorMonitors(){
        return sensormonitors;
    }
    

    /**
     * Override Subject Interface Methods
     * @param obs 
     */
    @Override
    public void registerObserver(Observer obs) {
       observer=obs;
    }
/**
 * 
 * @param obs 
 */
    @Override
    public void unRegisterObserver(Observer obs) {
        observer=null;
    }

    @Override
    public void notifyObservers() {
    }

   
/**
 * Override Observer Methods
 * @param ob
 * @param observer 
 */
    @Override
    public void update(Object ob, Observer observer) {
         receiveSensorData((EmbelishedData)ob);
       
    }
/**
 * 
 * @param aEmbelishedData 
 */
   public void receiveSensorData(EmbelishedData aEmbelishedData){
      
       observer.update(aEmbelishedData, this.observer);
       
   }
     //getters and setters starts here
    
     /**
     * @return the stationID
     */
    public String getStationID() {
        return stationID;
    }

    /**
     * @param stationID the stationID to set
     */
    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    /**
     * @return the stationName
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * @param stationName the stationName to set
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

 /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    
     
}

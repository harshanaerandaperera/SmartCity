/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controller.Observer;
import Controller.Subject;
import java.util.ArrayList;

/**
 *
 * @author Harshana
 */
public class SensorStation implements Subject, Observer {

    private String stationID;
    private String stationName;
    //As thiis is an Association relationship with location contain an object from the location class
    private Location location;
    private ArrayList<Double> coords = new ArrayList<>();
    private ArrayList<Observer> Observers;

    public SensorStation(String instationID,String instationName,Double inlatitude,Double inlongitude) {
        this.stationID = instationID;
        this.stationName=instationName;
        location=new Location(inlatitude,inlongitude);
        Observers = new ArrayList<>();
    }

    /**
     * Override Subject Interface Methods
     * @param obs 
     */
    @Override
    public void registerObserver(Observer obs) {
        Observers.add(obs);
    }

    @Override
    public void unRegisterObserver(Observer obs) {
        Observers.remove(obs);
    }

    @Override
    public void Notify() {
    }
/**
 * Override Observer Methods
 * @param ob
 * @param observer 
 */
    @Override
    public void update(Object ob, Observer observer) {
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

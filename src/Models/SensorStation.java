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
    private ArrayList<Double> coords = new ArrayList<>();
    
    private ArrayList<Observer> Observers;

    public SensorStation(String instationID,String instationName,Double inlongitude,Double inlatitude) {
        this.stationID = instationID;
        this.stationName=instationName;
        this.coords.add(inlongitude);
        this.coords.add(inlatitude);
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
     * @return the coords
     */
    public ArrayList<Double> getCoords() {
        return coords;
    }

    /**
     * @param coords the coords to set
     */
    public void setCoords(ArrayList<Double> coords) {
        this.coords = coords;
    }

}

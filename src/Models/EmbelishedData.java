/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Oshin
 */
public class EmbelishedData {
     private double data;
     private Long timeInMillis;
     private ArrayList<Double> location;
     private String sensorID;
     
     //additional
     private String stationName;
     private Double interval;
   
     public EmbelishedData(double data,String stationName,Double interval, Long timeInMillis, ArrayList<Double> location ,String sensorID)
    {
        this.data = data;
        this.stationName=stationName;
        this.interval=interval;
        this.timeInMillis =timeInMillis;
        this.location = location;
        this.sensorID = sensorID;
    }

    /**
     * @return the data
     */
    public double getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(double data) {
        this.data = data;
    }

    /**
     * @return the timeInMillis
     */
    public Long getTimeInMillis() {
        return timeInMillis;
    }

    /**
     * @param timeInMillis the timeInMillis to set
     */
    public void setTimeInMillis(Long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    /**
     * @return the location
     */
    public ArrayList<Double> getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(ArrayList<Double> location) {
        this.location = location;
    }

    /**
     * @return the sensorID
     */
    public String getSensorID() {
        return sensorID;
    }

    /**
     * @param sensorID the sensorID to set
     */
    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
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
     * @return the interval
     */
    public Double getInterval() {
        return interval;
    }

    /**
     * @param interval the interval to set
     */
    public void setInterval(Double interval) {
        this.interval = interval;
    }

}

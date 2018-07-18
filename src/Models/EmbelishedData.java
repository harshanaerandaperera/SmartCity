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
   /**
    * 
    * @param data
    * @param stationName
    * @param interval
    * @param timeInMillis
    * @param location
    * @param sensorID 
    */
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
     * @return data
     */
    public double getData() {
        return data;
    }

    /**
     * 
     * @param data 
     */
    public void setData(double data) {
        this.data = data;
    }

   /**
    * 
    * @return timeInMillis
    */
    public Long getTimeInMillis() {
        return timeInMillis;
    }

    /**
     * 
     * @param timeInMillis 
     */
    public void setTimeInMillis(Long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    /**
     * 
     * @return location
     */
    public ArrayList<Double> getLocation() {
        return location;
    }

    /**
     * 
     * @param location 
     */
    public void setLocation(ArrayList<Double> location) {
        this.location = location;
    }

   /**
    * 
    * @return sensorID
    */
    public String getSensorID() {
        return sensorID;
    }

  /**
   * 
   * @param sensorID 
   */
    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }
 /**
  * 
  * @return stationName
  */
    public String getStationName() {
        return stationName;
    }

   /**
    * 
    * @param stationName 
    */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    /**
     * 
     * @return interval
     */
    public Double getInterval() {
        return interval;
    }

    /**
     * 
     * @param interval 
     */
    public void setInterval(Double interval) {
        this.interval = interval;
    }

}

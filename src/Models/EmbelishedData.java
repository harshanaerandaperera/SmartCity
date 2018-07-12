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

    /**
     * @return the count
     */
    public double getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(double count) {
        this.count = count;
    }

    /**
     * @param SensorDescription the SensorDescription to set
     */
    public void setSensorDescription(String SensorDescription) {
        this.SensorDescription = SensorDescription;
    }

    /**
     * @return the sensor
     */
    public Sensor getSensor() {
        return sensor;
    }

    /**
     * @param sensor the sensor to set
     */
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

   
   
    private double count;
    private Sensor sensor;
    private String SensorDescription;
   // private Data data=new Data();

    private String status;
    private double frequency;
    
    public EmbelishedData(Sensor sensor,String SensorDescription, String status, double frequency) {
      this.count=0.0;
      this.sensor=sensor;
      this.SensorDescription=SensorDescription;
      this.status=status;
      this.frequency=frequency;
    }
    
    
    /**
     * @return the SensorDescription
     */
    public String getSensorDescription() {
        return SensorDescription;
    }

//
//    /**
//     * @return the data
//     */
//    public Data getData() {
//        return data;
//    }
//
//    /**
//     * @param data the data to set
//     */
//    public void setData(Data data) {
//        this.data = data;
//    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @return the frequency
     */
    public double getFrequency() {
        return frequency;
    }

    
  
}

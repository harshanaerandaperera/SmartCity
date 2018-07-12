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

   

    private String sensorID;
    private String SensorDescription;
    private Data data;
    private String status;
    private double frequency;
    public EmbelishedData(String sensorID,String SensorDescription, String status, double frequency) {
      this.sensorID=sensorID;
      this.SensorDescription=SensorDescription;
      this.status=status;
      this.frequency=frequency;
    }
    
     /**
     * @return the sensorID
     */
    public String getSensorID() {
        return sensorID;
    }

    /**
     * @return the SensorDescription
     */
    public String getSensorDescription() {
        return SensorDescription;
    }


    /**
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Data data) {
        this.data = data;
    }

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

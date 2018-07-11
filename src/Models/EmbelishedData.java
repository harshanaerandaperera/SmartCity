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
    public Data data;
    public Long timeInMills;
    public ArrayList<Double> location;
    public String sensorID;
    
     public EmbelishedData(Data data, Long timeInMills, ArrayList<Double> location, String sensorID) {
        this.data = data;
        this.timeInMills = timeInMills;
        this.location = location;
        this.sensorID = sensorID;
    }
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Oshin
 */
public class Sensor {

 private String sensorId;
   
 public Sensor(String sensorId){
     this.sensorId=sensorId;
 } 
 
 /**
  * @return the sensorId
  */
public String getSensorId() {
        return sensorId;
    }
/**
 * 
 * @return data
 */
    public Data getData() {
        Data data = new Data();
        return data;
    }
}

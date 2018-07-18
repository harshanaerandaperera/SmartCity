/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controller.SetOFData;

/**
 *
 * @author Oshin
 */
public class Sensor {

    
    

 private String sensorId;
 private double frequency;
 
 private SetOFData SOD=SetOFData.getSetOFDataInstance();

 public Sensor(){
     
 } 
 /**
  * 
  * @param sensorId
  * @param freq 
  */
 public Sensor(String sensorId,double freq){
     this.sensorId=sensorId;
     this.frequency=freq;
 } 
 
 /**
  * 
  * @return sensorId
  */
public String getSensorId() {
        return sensorId;
    }
/**
 * 
 * @return count
 */
    public Double getData() {
         double count=0;
       for(int i=0;i<SOD.size();i++){
           
          
           
           if(SOD.get(i).getSensorid().equals(this.sensorId)){
               count++;
           }
           
           
       }
       return count;
    }
  /**
   * 
   * @return frequency
   */
    public double getFrequency() {
        return frequency;
    }

   /**
    * 
    * @param frequency 
    */
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
  
   
}

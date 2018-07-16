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
 
 private SetOFData SOD=SetOFData.getSetOFDataInstance();

 public Sensor(){
     
 } 
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
    public Double getData() {
         double count=0;
       for(int i=0;i<SOD.size();i++){
           
          
           
           if(SOD.get(i).getSensorid().equals(this.sensorId)){
               count++;
           }
           
           
       }
       return count;
    }
    
   
}

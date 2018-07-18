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
public class Data {

    private String Sensorid;
  
    public Data(){
        
    }
    /**
     * 
     * @param sid 
     */
    public Data(String sid) {
        this.Sensorid=sid;
     }
    
    
   /**
    * 
    * @return Sensorid
    */
    public String getSensorid() {
        return Sensorid;
    }
/**
 * 
 * @param Sensorid 
 */
    public void setSensorid(String Sensorid) {
        this.Sensorid = Sensorid;
    }

}

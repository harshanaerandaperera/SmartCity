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

    

    //private Double limit=80.0;
    private String Sensorid;
  
    public Data(String sid) {
        this.Sensorid=sid;
     }
    
    
    /**
     * @return the Sensorid
     */
    public String getSensorid() {
        return Sensorid;
    }

    /**
     * @param Sensorid the Sensorid to set
     */
    public void setSensorid(String Sensorid) {
        this.Sensorid = Sensorid;
    }

//    /**
//     * @return the limit
//     */
//    public Double getLimit() {
//   return limit;
//    }
//
//    /**
//     * @param limit the limit to set
//     */
//    public void setLimit(Double limit) {
//        this.limit = limit;
//
//    }

}

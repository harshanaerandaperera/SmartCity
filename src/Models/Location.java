/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Harshana
 */
public class Location implements Serializable{

  
    private double latitude;
    private double longitude;
/**
 * 
 * @param alatitude
 * @param alongitude 
 */
    public Location(double alatitude ,double alongitude  ){
       this.latitude=alatitude;
        this.longitude=alongitude;
         
      }
  /**
   * 
   * @return coords
   */  
   public ArrayList<Double> getCoords() {
        ArrayList<Double> coords = new ArrayList<>();
        
        coords.add(latitude);
        coords.add(longitude);
        
        return coords;
    } 
   
   public void toAddress(){
     //todo   
    }
      
    /**
     * 
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude 
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

   /**
    * 
    * @param longitude 
    */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}

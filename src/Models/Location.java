/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Harshana
 */
public class Location {

  
    private double latitude;
    private double longitude;

    public Location(double alatitude ,double alongitude  ){
       this.latitude=alatitude;
        this.longitude=alongitude;
         
      }
    
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
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}

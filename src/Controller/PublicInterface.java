/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.EmbelishedData;
import java.util.ArrayList;

/**
 *
 * @author Oshin
 */
public class PublicInterface {
    //private {id} ID;
    //public ArrayList<EmbelishedData data=new ArrayList<EmbelishedData>();
    
    SetOfEmbelishedData data=SetOfEmbelishedData.getSetOfEmbelishedDataInstance();
    //  private ArrayList<SensorMonitor> sensormonitors=new ArrayList<SensorMonitor>() ;
      
    public PublicInterface(){
        
    }
    public void uploadData(EmbelishedData dataT)
    {
        this.data.add(dataT);
        System.out.println("-------------------------------data Alert---------------"+data.size());

    }
     public ArrayList<EmbelishedData> getAllChangedData()
    {
        System.out.println("-------------------------------data Alert---------------"+data.size());
        return data;
    }
    
    
    
}
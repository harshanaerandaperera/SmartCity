/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.EmbelishedData;
import Models.SensorStation;
import java.util.ArrayList;

/**
 *
 * @author Harshana
 */
public class MotherShip implements Observer {
    //private {id} ID;
    private ArrayList<SensorStation> sensorStations ;
    
    /**
     * Constructor for the Mothership instance
     */
    public MotherShip(){
        //As Mothership has a composition relationship with Sensorstation ,when create the Mothership creates a setOfStations(ArrayList<SensorStation>) inside cunstructor
        sensorStations=new  ArrayList<SensorStation>();
    }
    /**
     * 
     * @param aStation 
     */
    public void addNewSensorStation(SensorStation newStation){
        sensorStations.add(newStation);
        newStation.registerObserver((Observer) this);
    }
    /**
     * 
     * @param aStation 
     */
    public void removeSensorStation(SensorStation aStation){
        sensorStations.remove(aStation);
    }
    /**
     * 
     * @param stationID
     * @return sensorstation
     */
    public SensorStation getSensorStation(String stationID){
        SensorStation sensorstation=new SensorStation();
        for(int i=0;i<sensorStations.size();i++){
            if(sensorStations.get(i).getStationID().equals(stationID)){
                sensorstation=sensorStations.get(i);
            }
        }
        return sensorstation;
    }
    /**
     * 
     * @return sensorStations
     */
    public ArrayList<SensorStation> getSensorStations(){
         return sensorStations;
    }
    public PublicInterface receiveStationData()
    {
          PublicInterface publicInterface = new PublicInterface();
          return publicInterface;
    }

    @Override
    public void update(Object ob, Observer observer) {
       // System.out.println("------------------------------"+(EmbelishedData)ob);
        receiveStationData().uploadData((EmbelishedData)ob);
       receiveStationData().getAllChangedData();
     }
    
}

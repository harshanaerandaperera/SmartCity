/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import Controller.*;
/**
 *
 * @author Oshin
 */
public class SensorMonitor implements Subject,Observer{
    String sensorMonitorID;
    private ArrayList<Observer> Observers;
    
    
    public SensorMonitor(String sensorMonitorID){
        this.sensorMonitorID=sensorMonitorID;
      Observers=new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer obs) {
        Observers.add(obs);
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void unRegisterObserver(Observer obs) {
        Observers.remove(obs);
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void Notify() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void update(Object ob) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
  
    
       
    
    
    
    
    
    
}

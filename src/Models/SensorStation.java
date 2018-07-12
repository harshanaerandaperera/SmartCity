/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controller.Observer;
import Controller.Subject;
import java.util.ArrayList;

/**
 *
 * @author Harshana
 */
public class SensorStation implements Subject, Observer {

    String stationID;
    private ArrayList<Observer> Observers;

    public SensorStation(String stationID) {
        this.stationID = stationID;
        Observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer obs) {
        Observers.add(obs);
    }

    @Override
    public void unRegisterObserver(Observer obs) {
        Observers.remove(obs);
    }

    @Override
    public void Notify() {

    }

    @Override
    public void update(Object ob, Observer observer) {
    
    }

}

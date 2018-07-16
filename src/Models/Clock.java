/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controller.Observer;
import Controller.Subject;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Oshin
 */
public class Clock implements Subject,Serializable{
    
     public ArrayList<Observer> Observers;
   //Todo-public double notifyFrequency;
     private static Clock clock;
   
     
     private Clock(){
         Observers=new ArrayList<>();
     }

     public static Clock getInstance(){
          if(clock==null){
            
            clock=new Clock();
            System.out.println("Inside Null Check ,Object is created :"+clock.hashCode());
            System.out.println("---------------------------------------------------------------------");
        }
        return clock;
    }

    //Overide readResolve methode in Serializable
    private Object readResolve() {
        return clock;
    }

    @Override
    public void registerObserver(Observer obs) {
        Observers.add(obs);
        System.out.println("size of observers in clock--------------------------------------------"+Observers.size());
        new Thread(this::trackTime).start();
       // trackTime();
    }

    @Override
    public void unRegisterObserver(Observer obs) {
        Observers.remove(obs);
    }

    @Override
    public void Notify() {
    }

    /**
     * Wait for time to wakes the sensor
     */
    public void waitForTime() {
        double wakeUpTime =2;
        while (wakeUpTime != 0) {
            wakeUpTime--;
            System.out.println("reduce time..");
        }
    }

    private void notifyObservers() {

        for (int i = 0; i < Observers.size(); i++) {

            Observers.get(i).update(this, Observers.get(i));

        }
    }
     private void trackTime()
    { 
       while(Observers.isEmpty() == false){
              
                waitForTime();
                notifyObservers();
              
       }
               
    } 

    }



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
    
     private ArrayList<Observer> Observers;
     private static Clock clock;
     
     private Clock(){
         Observers=new ArrayList<>();
         
      }

     public Clock getInstance(){
          if(null==clock){
            
            clock=new Clock();
            System.out.println("Inside Null Check ,Object is created :"+clock.hashCode());
            System.out.println("---------------------------------------------------------------------");
        }
        return clock;
     }
    //Overide readResolve methode in Serializable
     private Object readResolve (){
        return clock;
    }
     public void printInstance(){
        System.out.println("Inside print singleton object :"+clock.hashCode());
        System.out.println("");
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
 }

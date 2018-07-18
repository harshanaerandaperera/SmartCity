/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Oshin
 */
public interface Subject {
/**
 * 
 * @param obs 
 */
    public void registerObserver(Observer obs);
/**
 * 
 * @param obs 
 */
    public void unRegisterObserver(Observer obs);

    public void notifyObservers();

}

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
public interface Observer {
/**
 * 
 * @param ob
 * @param observer 
 */
    void update(Object ob, Observer observer);

}

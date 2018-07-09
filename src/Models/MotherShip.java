/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Oshin
 */
public class MotherShip implements Observer{
    String ID;
    public MotherShip(String ID){
        this.ID=ID;
    }

    @Override
    public void update(Observable o, Object o1) {

    }
    
}

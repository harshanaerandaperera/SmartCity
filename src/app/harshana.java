/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//This class is for validating purposes
package app;

import Controller.validator;

/**
 *
 * @author Harshana
 */
public class harshana {
    public static void main(String[] args) {
        validator v=new validator();
        System.out.println(v.isValidStationID("ST001"));
    }
}

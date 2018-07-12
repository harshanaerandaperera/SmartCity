/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Data;
import java.util.ArrayList;

/**
 *
 * @author Harshana
 */
public class SetOFData extends ArrayList<Data> {

    private static SetOFData SetOFDataInstance;

    private SetOFData() {
    }

    public static SetOFData getSetOFDataInstance() {
        if (SetOFDataInstance == null) {
            SetOFDataInstance = new SetOFData();
        }
        return SetOFDataInstance;
    }

    public void addData(Data data) {
        super.add(data);
        System.out.println("Data added !");
    }
}

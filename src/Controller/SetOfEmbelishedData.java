/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.EmbelishedData;
import java.util.ArrayList;

/**
 *
 * @author Oshin
 */
public class SetOfEmbelishedData extends ArrayList<EmbelishedData>{
    private static SetOfEmbelishedData SetOfEmbelishedDataInstance;
    private SetOfEmbelishedData(){
    }
    public static SetOfEmbelishedData getSetOfEmbelishedDataInstance(){
        if(SetOfEmbelishedDataInstance==null){
            SetOfEmbelishedDataInstance=new SetOfEmbelishedData();
        }
        return SetOfEmbelishedDataInstance;
    }
    
    public void addEmblishedData(EmbelishedData emblishedData){
            super.add(emblishedData);
    }
    
   
    
}

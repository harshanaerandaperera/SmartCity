/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.*;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 *
 * @author Oshin
 */
public class Singleton implements Serializable{
    
    // 1st rule-Static Variable whic will hold a Singleton Object
    private static Singleton singletonInstance;
    
    //2nd rule-Need to make constructor private to prevent any other class from instantiating singleton 
    private  Singleton(){
        
    }
    //3rd rule-Static public methode this provides the global point of access to the singleton object and return the instance to the client calling class
    public static Singleton getSingletonInstance(){
        
        if(null==singletonInstance){
            
            singletonInstance=new Singleton();
            System.out.println("Inside Null Check ,Object is created :"+singletonInstance.hashCode());
            System.out.println("---------------------------------------------------------------------");
        }
        
        return singletonInstance;
    }
    private Object readResolve(){
        return singletonInstance;
    }
    public void printIngleton(){
        System.out.println("Inside print singleton object :"+singletonInstance.hashCode());
        System.out.println("");
    }
    
    
}

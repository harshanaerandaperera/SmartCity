/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Oshin
 */
public class test {
    public static void main(String[] args) throws Exception{
      
        System.out.println(testController.addTest(10, 10));
        System.out.println(testController.multiTest(10, 2));
                
         System.out.println("Hello smart city");    
         
         System.out.println("----------------------------------Singleton Starts Here------------------------------------------");
         
//        Singleton.getSingletonInstance().printIngleton();
//        Singleton.getSingletonInstance().printIngleton();
//        Singleton.getSingletonInstance().printIngleton();
            
        Singleton singleton1=Singleton.getSingletonInstance();
        Singleton singleton2=Singleton.getSingletonInstance();
        
        
        printObjects("singleton 1",singleton1);
        printObjects("singleton 2",singleton2);
      
        //Serialization
        Serialization(singleton1);
        //DeSerialization
        DeSerialization();
           }
    //Following Methods Must be Static as main methode is static otherwise can not contain nonstatic methods by a static class
    
    static void printObjects(String name,Singleton object){
        System.out.println(String.format("Object : %s, Hashcode: %d", name,object.hashCode()));
        }
    /**
     * Serialization
     * @param singleton1 
     */
    
    static public void Serialization(Singleton singleton1 ){
        
        try {
             FileOutputStream sfos = new FileOutputStream(new File("singletonDB.txt"));
            ObjectOutputStream soos = new ObjectOutputStream(sfos);
            soos.writeObject(singleton1);
            soos.flush();
            soos.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
         }
    
    /**
     * DeSerialization
     */
     static public void DeSerialization(){
        
        try {
              ObjectInputStream sois = null;
        File file = new File("singletonDB.txt");
       
            FileInputStream sfis = new FileInputStream(file);
            if (sfis.available() != 0) {
                sois = new ObjectInputStream(sfis);
                while (sfis.available() != 0) {
                    Singleton DeserializedSingleton1= (Singleton)sois.readObject();
                    printObjects("Deserialized singleton 1",DeserializedSingleton1);
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
         }
 }

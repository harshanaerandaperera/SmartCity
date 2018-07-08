/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Oshin
 */
public class Singleton {
    
    // 1st rule-Static Variable whic will hold a Singleton Object
    private static Singleton singletonInstance;
    
    //2nd rule-Need to make constructor private to prevent any other class from instantiating singleton class
    private  Singleton(){
        
    }
    //3rd rule-Static public methode this provides the global point of access to the singleton object and return the instance to the client calling class
    public static Singleton getSingletonInstance(){
        
        if(null==singletonInstance){
            
            singletonInstance=new Singleton();
            System.out.println("Inside Null Check ,Object is created :"+singletonInstance.toString());
            System.out.println("---------------------------------------------------------------------");
        }
        
        return singletonInstance;
    }
    public void printIngleton(){
        System.out.println("Inside print singleton object :"+singletonInstance.toString());
        System.out.println("");
    }
    
    
}

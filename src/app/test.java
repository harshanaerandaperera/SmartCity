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
public class test {
    public static void main(String[] args) {
      
        System.out.println(testController.addTest(10, 10));
        System.out.println(testController.multiTest(10, 2));
                
         System.out.println("Hello smart city");    
         
//        Singleton.getSingletonInstance().printIngleton();
//        Singleton.getSingletonInstance().printIngleton();
//        Singleton.getSingletonInstance().printIngleton();
            
        Singleton singleton1=Singleton.getSingletonInstance();
        Singleton singleton2=Singleton.getSingletonInstance();
        
        printObjects("singleton1",singleton1);
        printObjects("singleton2", singleton2);
        
        }
    
    static void printObjects(String name,Singleton object){
        System.out.println(String.format("Object : %s, Hashcode: %d", name,object.hashCode()));
        
    }
    
    
    
}

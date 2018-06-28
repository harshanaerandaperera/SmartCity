/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oshin
 */
public class testControllerTest {
    
    public testControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addTest method, of class testController.
     */
    @Test
    public void testAddTest() {
        System.out.println("addTest");
        int num1 = 30;
        int num2 = 30;
        int expResult = 60;
        int result = testController.addTest(num1, num2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of multiTest method, of class testController.
     */
    @Test
    public void testMultiTest() {
        System.out.println("multiTest");
        int num1 = 20;
        int num2 = 2;
        int expResult = 40;
        int result = testController.multiTest(num1, num2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}

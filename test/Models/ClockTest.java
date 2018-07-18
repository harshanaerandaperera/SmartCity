/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controller.Observer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Debug
 */
public class ClockTest {
    
    public ClockTest() {
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
     * Test of getInstance method, of class Clock.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Clock expResult = null;
        Clock result = Clock.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObserver method, of class Clock.
     */
    @Test
    public void testRegisterObserver() {
        System.out.println("registerObserver");
        Observer obs = null;
        Clock instance = null;
        instance.registerObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unRegisterObserver method, of class Clock.
     */
    @Test
    public void testUnRegisterObserver() {
        System.out.println("unRegisterObserver");
        Observer obs = null;
        Clock instance = null;
        instance.unRegisterObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of waitForTime method, of class Clock.
     */
    @Test
    public void testWaitForTime() {
        System.out.println("waitForTime");
        Clock instance = null;
        instance.waitForTime();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObservers method, of class Clock.
     */
    @Test
    public void testNotifyObservers() {
        System.out.println("notifyObservers");
        Clock instance = null;
        instance.notifyObservers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

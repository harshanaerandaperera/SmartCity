/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Controller.Observer;
import Controller.SetOfEmbelishedData;
import java.util.ArrayList;
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
public class SensorMonitorTest {
    
    public SensorMonitorTest() {
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
     * Test of doTick method, of class SensorMonitor.
     */
    @Test
    public void testDoTick() {
        System.out.println("doTick");
        Observer observer = null;
        SensorMonitor instance = new SensorMonitor();
        instance.doTick(observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObserver method, of class SensorMonitor.
     */
    @Test
    public void testRegisterObserver() {
        System.out.println("registerObserver");
        Observer obs = null;
        SensorMonitor instance = new SensorMonitor();
        instance.registerObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unRegisterObserver method, of class SensorMonitor.
     */
    @Test
    public void testUnRegisterObserver() {
        System.out.println("unRegisterObserver");
        Observer obs = null;
        SensorMonitor instance = new SensorMonitor();
        instance.unRegisterObserver(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Notify method, of class SensorMonitor.
     */
    @Test
    public void testNotify() {
        System.out.println("Notify");
        SensorMonitor instance = new SensorMonitor();
        instance.Notify();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SensorMonitor.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object ob = null;
        Observer observer = null;
        SensorMonitor instance = new SensorMonitor();
        instance.update(ob, observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSensorMonitorID method, of class SensorMonitor.
     */
    @Test
    public void testGetSensorMonitorID() {
        System.out.println("getSensorMonitorID");
        SensorMonitor instance = new SensorMonitor();
        String expResult = "";
        String result = instance.getSensorMonitorID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIsActive method, of class SensorMonitor.
     */
    @Test
    public void testIsIsActive() {
        System.out.println("isIsActive");
        SensorMonitor instance = new SensorMonitor();
        boolean expResult = false;
        boolean result = instance.isIsActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shouldTakeReading method, of class SensorMonitor.
     */
    @Test
    public void testShouldTakeReading() {
        System.out.println("shouldTakeReading");
        Observer observer = null;
        SensorMonitor instance = new SensorMonitor();
        instance.shouldTakeReading(observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of embellishData method, of class SensorMonitor.
     */
    @Test
    public void testEmbellishData() {
        System.out.println("embellishData");
        Sensor senor = null;
        double count = 0.0;
        SensorMonitor instance = new SensorMonitor();
        instance.embellishData(senor, count);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateDataCount method, of class SensorMonitor.
     */
    @Test
    public void testCalculateDataCount() {
        System.out.println("calculateDataCount");
        String sid = "";
        SensorMonitor instance = new SensorMonitor();
        instance.calculateDataCount(sid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSensor method, of class SensorMonitor.
     */
    @Test
    public void testGetSensor() {
        System.out.println("getSensor");
        SensorMonitor instance = new SensorMonitor();
        Sensor expResult = null;
        Sensor result = instance.getSensor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterval method, of class SensorMonitor.
     */
    @Test
    public void testGetInterval() {
        System.out.println("getInterval");
        SensorMonitor instance = new SensorMonitor();
        Double expResult = null;
        Double result = instance.getInterval();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSOED method, of class SensorMonitor.
     */
    @Test
    public void testGetSOED() {
        System.out.println("getSOED");
        SensorMonitor instance = new SensorMonitor();
        SetOfEmbelishedData expResult = null;
        SetOfEmbelishedData result = instance.getSOED();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class SensorMonitor.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        SensorMonitor instance = new SensorMonitor();
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class SensorMonitor.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        SensorMonitor instance = new SensorMonitor();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSensorDescription method, of class SensorMonitor.
     */
    @Test
    public void testGetSensorDescription() {
        System.out.println("getSensorDescription");
        SensorMonitor instance = new SensorMonitor();
        String expResult = "";
        String result = instance.getSensorDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSensorDescription method, of class SensorMonitor.
     */
    @Test
    public void testSetSensorDescription() {
        System.out.println("setSensorDescription");
        String sensorDescription = "";
        SensorMonitor instance = new SensorMonitor();
        instance.setSensorDescription(sensorDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoords method, of class SensorMonitor.
     */
    @Test
    public void testGetCoords() {
        System.out.println("getCoords");
        SensorMonitor instance = new SensorMonitor();
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getCoords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCoords method, of class SensorMonitor.
     */
    @Test
    public void testSetCoords() {
        System.out.println("setCoords");
        ArrayList<Double> coords = null;
        SensorMonitor instance = new SensorMonitor();
        instance.setCoords(coords);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObservers method, of class SensorMonitor.
     */
    @Test
    public void testNotifyObservers() {
        System.out.println("notifyObservers");
        SensorMonitor instance = new SensorMonitor();
        instance.notifyObservers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObserver method, of class SensorMonitor.
     */
    @Test
    public void testGetObserver() {
        System.out.println("getObserver");
        SensorMonitor instance = new SensorMonitor();
        Observer expResult = null;
        Observer result = instance.getObserver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObserver method, of class SensorMonitor.
     */
    @Test
    public void testSetObserver() {
        System.out.println("setObserver");
        Observer observer = null;
        SensorMonitor instance = new SensorMonitor();
        instance.setObserver(observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

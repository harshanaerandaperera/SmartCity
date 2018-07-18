/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.SensorStation;
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
public class MotherShipTest {
    
    public MotherShipTest() {
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
     * Test of addNewSensorStation method, of class MotherShip.
     */
    @Test
    public void testAddNewSensorStation() {
        System.out.println("addNewSensorStation");
        SensorStation newStation = null;
        MotherShip instance = new MotherShip();
        instance.addNewSensorStation(newStation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeSensorStation method, of class MotherShip.
     */
    @Test
    public void testRemoveSensorStation() {
        System.out.println("removeSensorStation");
        SensorStation aStation = null;
        MotherShip instance = new MotherShip();
        instance.removeSensorStation(aStation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSensorStation method, of class MotherShip.
     */
    @Test
    public void testGetSensorStation() {
        System.out.println("getSensorStation");
        String stationID = "";
        MotherShip instance = new MotherShip();
        SensorStation expResult = null;
        SensorStation result = instance.getSensorStation(stationID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSensorStations method, of class MotherShip.
     */
    @Test
    public void testGetSensorStations() {
        System.out.println("getSensorStations");
        MotherShip instance = new MotherShip();
        ArrayList<SensorStation> expResult = null;
        ArrayList<SensorStation> result = instance.getSensorStations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receiveStationData method, of class MotherShip.
     */
    @Test
    public void testReceiveStationData() {
        System.out.println("receiveStationData");
        MotherShip instance = new MotherShip();
        PublicInterface expResult = null;
        PublicInterface result = instance.receiveStationData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MotherShip.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object ob = null;
        Observer observer = null;
        MotherShip instance = new MotherShip();
        instance.update(ob, observer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

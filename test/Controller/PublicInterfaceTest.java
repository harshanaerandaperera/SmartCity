/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.EmbelishedData;
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
public class PublicInterfaceTest {
    
    public PublicInterfaceTest() {
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
     * Test of uploadData method, of class PublicInterface.
     */
    @Test
    public void testUploadData() {
        System.out.println("uploadData");
        EmbelishedData dataT = null;
        PublicInterface instance = new PublicInterface();
        instance.uploadData(dataT);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllChangedData method, of class PublicInterface.
     */
    @Test
    public void testGetAllChangedData() {
        System.out.println("getAllChangedData");
        PublicInterface instance = new PublicInterface();
        ArrayList<EmbelishedData> expResult = null;
        ArrayList<EmbelishedData> result = instance.getAllChangedData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

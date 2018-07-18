/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class ValidatorTest {
    
    public ValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    Validator validator;
    @Before
	public void setUp() throws Exception
	{
		
		this.validator = Validator.getValidatorInstance();
		
	}
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getValidatorInstance method, of class Validator.
     */
    @Test
    public void testGetValidatorInstance() {
        System.out.println("getValidatorInstance");
        Validator expResult = null;
        Validator result = Validator.getValidatorInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidName method, of class Validator.
     */
    @Test
    public void testIsValidName() {
        System.out.println("isValidName");
        String name = "";
        Validator instance = null;
        boolean expResult = false;
        boolean result = instance.isValidName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidStationID method, of class Validator.
     */
    @Test
	public void getValidatorInstance()
	{
		
		assertNotNull(this.validator);
		
	}
	
	@Test
	public void isValidName()
	{
            
            String name = "Harshana";
            
            assertFalse(this.validator.isValidName("123"));
            
            assertTrue(this.validator.isValidName(name));
            
	}
	
	@Test
	public void isValidStationID()
	{
            
            String stationId = "ST983";
            
            assertTrue(this.validator.isValidStationID(stationId));
            
            assertFalse(this.validator.isValidStationID("1234"));
            
	}
	
	@Test
	public void isValidSensorID()
	{
            
            String sensorId = "S123";
            
            assertFalse(this.validator.isValidStationID("12234"));
            
            assertTrue(this.validator.isValidSensorID(sensorId));
            
	}
	
	@Test
	public void isValidNumber()
	{
		
		String number = "123";
		
		assertFalse(this.validator.isValidNumber("sfdsfds"));
		
		assertTrue(this.validator.isValidNumber(number));
		
	}
	
	@Test
	public void isValidEmail()
	{
            
            String email = "harshanap@pnya.com";
                    
            assertFalse(this.validator.isValidEmail("sdfsffsd.com"));
            
            assertTrue(this.validator.isValidEmail(email));
            
	}
	
	@Test
	public void isValidMobileNo()
	{
            
            String mobile = "+947234566";
            
            assertFalse(this.validator.isValidMobileNo("34232sfsd"));
            
            assertTrue(this.validator.isValidMobileNo(mobile));
            
	}
   
    
}

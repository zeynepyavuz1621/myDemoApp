package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    // length of nameFormula given unequal with length name, expected return is null
    public void test1_nameFormula_lengthCheck(){
    	
    	assertTrue(App.encryptor(new Integer[] {1}, new Integer[] {1,2,3,4,5}, "zeynep", "yavuz") == null);
    }
    
    // length of surnameFormula given unequal with length of surname, expected return is null
    public void test2_surnameFormula_lengthCheck(){
    	
    	assertTrue(App.encryptor(new Integer[] {1,2,3,4,5,6}, new Integer[] {1}, "zeynep", "yavuz") == null);
    }
    
    // nameFormula parameter given null, expected return is null
    public void test3_nameFormula_nullCheck(){
    	
    	assertTrue(App.encryptor(null, new Integer[] {1,2,3,4,5}, "zeynep", "yavuz") == null); 
    }
    
    // surnameFormula parameter given null, expected return is null
    public void test4_surnameFormula_nullCheck(){
    	
    	assertTrue(App.encryptor(new Integer[] {1,2,3,4,5,6}, null, "zeynep", "yavuz") == null); 
    }
    
    // name parameter given null, expected return is null
    public void test5_name_nullCheck(){
    	
    	assertTrue(App.encryptor(new Integer[] {1,2,3,4,5,6}, new Integer[] {1,2,3,4,5}, null, "yavuz") == null); 
    }
    
    // surname parameter given null, expected return is null
    public void test6_surname_nullCheck(){
    	
    	assertTrue(App.encryptor(new Integer[] {1,2,3,4,5,6}, new Integer[] {1,2,3,4,5}, "zeynep", null) == null); 
    }
    
    // all parameters given correct 
    public void test7_general_outputCorrectness() {
    	
    	String[] result = App.encryptor(new Integer[] {1,1,1}, new Integer[] {1,1,1}, "abc", "ABC"); 
        
    	assertTrue(result != null && result[0].equals("bcd") && result[1].equals("BCD"));
    }
        
}

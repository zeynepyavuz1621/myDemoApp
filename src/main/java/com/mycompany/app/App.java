package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
	// the encryptor method takes 4 parameters:
	// a nameFormula and a name then adds the integers at the nameFormula to the chars in the name index by index and makes a encrypted string  
	// a surnameFormula and a surname then adds the integers at the nameFormula to the chars in the surname index by index and makes a encrypted string  	
	public static String[] encryptor(Integer[] nameFormula, Integer[] surnameFormula, String name, String surname){
		
		if(nameFormula == null || surnameFormula == null || name == null || surname == null) {
			System.out.println("Invalid parameter!");
			return null;
		}
		
		if(nameFormula.length != name.length() || surnameFormula.length != surname.length()) {
			System.out.println("Parameter lengths are not matching with the criteria!");
			return null;
		}
		
		String encrypted_name = "";
		String encrypted_surname = "";
		
		for(int i = 0; i < name.length(); i++) {
			
			encrypted_name += (char)(name.charAt(i) + nameFormula[i]);
			
		}
		
		for(int j = 0; j < surname.length(); j++) {
			
			encrypted_surname += (char)(surname.charAt(j) + surnameFormula[j]);
			
		}
		
		return new String[] {encrypted_name, encrypted_surname};	
		
	}
	
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

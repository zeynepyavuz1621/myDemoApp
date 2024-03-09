package com.mycompany.app;


import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


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

    	 port(getHerokuAssignedPort());

         get("/", (req, res) -> "Hello, World");
         
         post("/compute", (req, res) -> {
        	    // Parse the nameFormula parameter from the HTTP request
        	    String[] nameFormulaStrings = req.queryParams("nameFormula").split(",");
        	    Integer[] nameFormula = new Integer[nameFormulaStrings.length];
        	    for (int i = 0; i < nameFormulaStrings.length; i++) {
        	        nameFormula[i] = Integer.parseInt(nameFormulaStrings[i]);
        	    }

        	    // Parse the surnameFormula parameter from the HTTP request
        	    String[] surnameFormulaStrings = req.queryParams("surnameFormula").split(",");
        	    Integer[] surnameFormula = new Integer[surnameFormulaStrings.length];
        	    for (int i = 0; i < surnameFormulaStrings.length; i++) {
        	        surnameFormula[i] = Integer.parseInt(surnameFormulaStrings[i]);
        	    }

        	    // Get the name and surname parameters from the HTTP request
        	    String name = req.queryParams("name");
        	    String surname = req.queryParams("surname");

        	    // Call the encryptor method
        	    String[] result = App.encryptor(nameFormula, surnameFormula, name, surname);

        	    // Prepare the result for the response
        	    Map map = new HashMap();
        	    map.put("result", result);
        	    return new ModelAndView(map, "compute.mustache");
         }, new MustacheTemplateEngine());
         

         get("/compute",
             (rq, rs) -> {
               Map map = new HashMap();
               map.put("result", "not computed yet!");
               return new ModelAndView(map, "compute.mustache");
             },
             new MustacheTemplateEngine());
     }

     static int getHerokuAssignedPort() {
         ProcessBuilder processBuilder = new ProcessBuilder();
         if (processBuilder.environment().get("PORT") != null) {
             return Integer.parseInt(processBuilder.environment().get("PORT"));
         }
         return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
     }
 }





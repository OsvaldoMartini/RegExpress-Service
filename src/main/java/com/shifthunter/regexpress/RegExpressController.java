package com.shifthunter.regexpress;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mifmif.common.regex.Generex;
//import com.mifmif.common.regex.util.Iterable;
import com.mifmif.common.regex.util.Iterator;

@RestController
public class RegExpressController {
	
	RegExpress regExpress = new RegExpress();
	
	@RequestMapping("/regexpress/{expression}")
	public RegExpress genRandomFromExpression(@PathVariable String expression) {
		
		System.out.println("\nExpression requested: " + expression);

		//Generex generex = new Generex("[0-3]([a-c]|[e-g]{1,2})");
		//Generex generex = new Generex("[0-3]([a-c]|[e-g]{1,2})");
		Generex generex = new Generex(expression);

		// Generate random String
		String randomStr = generex.random();
		System.out.println(randomStr);// a random value from the previous String list

		// generate the second String in lexicographical order that match the given Regex.
		String secondString = generex.getMatchedString(2);
		System.out.println(secondString);// it print '0b'

		// Generate all String that matches the given Regex.
		//List<String> matchedStrs = generex.getAllMatchedStrings();
		List<String> matchedStrs = generex.getMatchedStrings(100);

		// Using Generex iterator
		Iterator iterator = generex.iterator();
		
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		regExpress.setSingleExpression(expression);
		regExpress.setExpressionList(matchedStrs);
		
		return regExpress;
	}
	

	
	
    @PostMapping("/regexpress/{limitEachReg}")
	public RegExpress genExpressionsFromArray(@PathVariable int limitEachReg, @Valid @RequestBody String[] expressions) {
    	
    	List<String>[] list = new ArrayList[expressions.length];

    	List<String> matchers = new ArrayList<String>();
    	List<String> resumeEntry = new ArrayList<String>();
    	
		for(int x=0; x < expressions.length; x++) {

			System.out.println("Expression requested: " + expressions[x]);

			Generex generex = new Generex(expressions[x]);
			resumeEntry.add(expressions[x]);

			
			for(int y=0;y<limitEachReg;y++) {
				// Generate random String from the previous String list
				String randomStr = generex.random();
				System.out.println("randomStr " + randomStr);
				matchers.add(randomStr);	
			}
			
			list[x] = new ArrayList(matchers);
			
			matchers.clear();

			// It gets the first N elementsatchs with the ReGex
			//List<String> matchedStrs = generex.getMatchedStrings(limitEachReg);
			
			//String randomStr2 = generex.random(3);
			//System.out.println("randomStr2 " + randomStr2);// a random value from the previous String list

			//String randomStr3 = generex.random(2, 5);
			//System.out.println("randomStr3 " + randomStr3);// a random value from the previous String list
			
			//list[x] = new ArrayList(matchedStrs);
		}
		
		regExpress.setExpressionList(resumeEntry);
		regExpress.setExpressionListArray(list);		 
		
		return regExpress;
	}
    
    @PostMapping("/map_json_entry")
  	public List<String>[] getMapJsonFields(@Valid @RequestBody String mapEntry) {
      	
    	JSONObject mapJson = new JSONObject(mapEntry);
    	
		System.out.println("Map Json requested: " + mapJson);
		
    	JSONArray json_array = mapJson.getJSONArray("Decisions");
    	
      	List<String>[] list = new ArrayList[json_array.length()];

      	List<String> mapField = new ArrayList<String>();
      	
  		for(int x=0; x < json_array.length(); x++) {

  			System.out.println("Expression requested: " + json_array.getJSONObject(x));
  			JSONObject jsonObject1 = json_array.getJSONObject(x);
  			
  			//strings[i] = jsonObject1.getString("name");

  			mapField.add(jsonObject1.getString("name"));
  			
  			mapField.clear();

  		}
  		
  		list[0] = new ArrayList(mapField);
		
  		mapField.clear();
  		
  		 
  		return 	list;
  	}
    
    @PostMapping("/map_array_entry")
  	public List<String>[] getMapArrayFields(@Valid @RequestBody String[] mapEntry) {
      	
    	List<String>[] list = new ArrayList[mapEntry.length];

    	List<String> matchers = new ArrayList<String>();
    	
		for(int x=0; x < mapEntry.length; x++) {

			System.out.println("Expression requested: " + mapEntry[x]);

			//matchers.add(mapEntry[x]);	

			
			list[x] = new ArrayList(matchers);
			
			matchers.clear();

			// It gets the first N elementsatchs with the ReGex
			//List<String> matchedStrs = generex.getMatchedStrings(limitEachReg);
			
			//String randomStr2 = generex.random(3);
			//System.out.println("randomStr2 " + randomStr2);// a random value from the previous String list

			//String randomStr3 = generex.random(2, 5);
			//System.out.println("randomStr3 " + randomStr3);// a random value from the previous String list
			
			//list[x] = new ArrayList(matchedStrs);
		}
		
		 
		return 	list;
  	}
    

	
}
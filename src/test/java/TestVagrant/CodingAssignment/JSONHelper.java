package TestVagrant.CodingAssignment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author Virupaksha M 
 * Module Name : JSON Helper file 
 * Created Date : 01/14/2023
 * Summary : This is JSON helper file which contains the methods related to json parsing 
 *
 */
public class JSONHelper {
	JSONParser parser = new JSONParser();
	JSONObject jsonObject;

	/*
	 * This Method is used to read json file and return JSONObject
	 * 
	 * @param None
	 * 
	 * @return JSONObject
	 */
	public JSONObject readJsonFile() throws FileNotFoundException, IOException, ParseException {
		System.out.println(System.getProperty("user.dir"));
		try {
			jsonObject = (JSONObject) parser.parse(
					new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\TeamRCB.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject;
	}

	/*
	 * This Method is return JSON array to calling function
	 * 
	 * @param None
	 * 
	 * @return JSONObject
	 */
	public JSONArray returJSONnArray() throws FileNotFoundException, IOException, ParseException {
		jsonObject = readJsonFile();
		JSONArray jsonArray = (JSONArray) jsonObject.get("player");
		System.out.println(jsonArray.get(1));
		return jsonArray;

	}

}

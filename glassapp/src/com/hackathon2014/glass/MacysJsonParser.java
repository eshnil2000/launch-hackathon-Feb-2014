package com.hackathon2014.glass;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

public class MacysJsonParser {

	public static String PRODUCT_URL = "http://api.macys.com/v3/catalog/product?upc=";
	
	public static String ACCEPT_HEADER = "Accept";
	public static String APP_KEY_HEADER = "x-macys-webservice-client-id";

	private String upc;
	
	public MacysJsonParser(String upc) {
		this.upc = upc;
	}
	
	public String loadProductJson() {
		String url = PRODUCT_URL + upc;
		
		// creete required headers
		Header[] headers = new Header[2];
	    headers[0] = new BasicHeader(ACCEPT_HEADER, "application/json");
	    headers[1] = new BasicHeader(APP_KEY_HEADER, "hackathon");

		return HttpUtility.httpGetwHeaders(url, headers);
	}
	/**
	 * Take json string, get product description, price, image, return card.
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Product parseProductService(String jsonString) {

		
		// Parse String
		Object obj = JSONValue.parse(jsonString);
		// case as dict
		JSONObject obj2 = (JSONObject) obj;
		
		// get results array
		JSONArray array = (JSONArray) obj2.get("product");
		
		// only want first returned element (best price)
		JSONObject result = (JSONObject)array.get(0);
		
		// get best_page dict
		JSONObject summary = (JSONObject)result.get("summary");
		String name = (String)summary.get("name");

		
		JSONObject price = (JSONObject)result.get("price");
		JSONObject current = (JSONObject)price.get("current");
		Double value = (Double)current.get("value");

		JSONArray images = (JSONArray)result.get("image");
		JSONObject image = (JSONObject)images.get(0);
		String image_url = (String)image.get("imageurl");

		
		return new Product(name, image_url, value);

		
	}
}

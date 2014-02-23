package com.hackathon2014.glass;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

public class InvisibleHandParser {

	
	String PRODUCT_URL = "http://us.api.invisiblehand.co.uk/v1/products?query=Van+Heusen+Mens+Long+Sleeve+shirt+blue&sort=best_price&order=asc&app_id=e07d7436&app_key=d9516c80f4ddf575927ee4aabd6f3aa8";

	private String upc;
	
	public InvisibleHandParser(String upc) {
		this.upc = upc;
	}
	
	public String loadPriceJson() {
		String url = PRODUCT_URL;
		
		return HttpUtility.httpGetwHeaders(url, null);
		
	}
	
	public BestRetailer parseInvisibleHand(String jsonString) {
		
		// Parse String
		Object obj = JSONValue.parse(jsonString);
		// case as dict
		JSONObject obj2 = (JSONObject) obj;
		
		// get results array
		JSONArray array = (JSONArray) obj2.get("results");
		
		// only want first returned element (best price)
		JSONObject result = (JSONObject)array.get(0);
		
		// get best_page dict
		JSONObject page = (JSONObject)result.get("best_page");
		
		BestRetailer bestRetailer = new BestRetailer((String)page.get("retailer_name"), (double)page.get("price"));
		
		return bestRetailer;
	}
}

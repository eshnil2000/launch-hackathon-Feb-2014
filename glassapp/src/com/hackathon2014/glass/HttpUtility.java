package com.hackathon2014.glass;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtility {

	/**
	 * Load page from website/webservice
	 * 
	 * @param upc
	 * @return
	 */
	public static String httpGetwHeaders (String url, Header[] headers) {

	    StringBuilder body = new StringBuilder();
	    HttpClient httpclient = new DefaultHttpClient(); // create new httpClient
	    HttpGet httpGet = new HttpGet(url); // create new httpGet object
	    
	    if(headers != null) {
	    	httpGet.setHeaders(headers);
	    }
	    
	    HttpResponse response;

	    try {
	        response = httpclient.execute(httpGet); // execute httpGet
	        StatusLine statusLine = response.getStatusLine();
	        int statusCode = statusLine.getStatusCode();
	        System.out.println(statusLine.toString());
	        if (statusCode == HttpStatus.SC_OK) {
	            
	            HttpEntity e = response.getEntity();
	            String entity = EntityUtils.toString(e);
	            body.append(entity);
	        } else {
	            body.append(statusLine);
	            
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        httpGet.releaseConnection(); // stop connection
	    }
	    return body.toString(); // return the String
	}
}

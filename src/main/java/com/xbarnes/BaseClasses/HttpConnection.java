/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbarnes.BaseClasses;

/**
 *
 * @author xbarn
 */


import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpConnection {
		
		 private final static CloseableHttpClient httpClient = HttpClients.createDefault();


		    private void close() throws IOException {
		        httpClient.close();
		    }
		    
		    public void getCrossfitData() {
		    	
		    	try {
		    		
		    	// Sending get request
		        StringBuffer response = new StringBuffer();
		        URIBuilder builderURL = new URIBuilder("https://games.crossfit.com/competitions/api/v1/competitions/open/2020/leaderboards?");
		        builderURL.addParameter("page", "1");
		        builderURL.addParameter("division", "1");
		        builderURL.addParameter("region", "0");
		        builderURL.addParameter("scaled", "0");
		        builderURL.addParameter("sort", "0");
		        builderURL.addParameter("occupation", "0");
		        URL url = builderURL.build().toURL();
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");

		        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        String output;

		        while ((output = in.readLine()) != null) {
		            response.append(output);
		        }
		        
		        @SuppressWarnings("deprecation")
                        JsonObject obj = new JsonParser().parse(response.toString()).getAsJsonObject();
		        JsonArray objFiltered =  obj.getAsJsonArray("leaderboardRows");
                        for(Object o: objFiltered){
                            JsonObject jsonLineItem = (JsonObject) o;
                            String key = jsonLineItem.get("entrant").toString();
                            System.out.println(key);
                            String value = jsonLineItem.get("ui").toString();
                            System.out.println(value);
                        }
		        //JsonArray objFiltered2 = objFiltered.getAsJson
		        //JsonArray objArray2 = (JsonArray)objFiltered.getAsJsonArray("entrant");

		        System.out.println(objFiltered.toString());
		       
				in.close();
				
				} catch (IOException e) {
					e.printStackTrace();
				} catch(URISyntaxException e) {
					
				}


		    }

	}

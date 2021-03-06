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
import com.xbarnes.StructureInterfaces.AbsFactoryAthlete;
import com.xbarnes.StructureInterfaces.AthleteFactory;

public class HttpConnection {
	
    private final static CloseableHttpClient httpClient = HttpClients.createDefault();
    private AbsFactoryAthlete absAthlete;

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
            JsonArray objFiltered = obj.getAsJsonArray("leaderboardRows");
            ArrayList <Athlete> athletes = new ArrayList<Athlete>(); 
            for (Object o : objFiltered) {
                athletes.add(this.createAthleteFromJson(o));

            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {

        }
    }

    public Athlete createAthleteFromJson(Object o) {
        JsonObject jsonLineItem = (JsonObject) o;
        JsonObject jsonEntrantLine = jsonLineItem.getAsJsonObject("entrant");
        int id = Integer.parseInt(jsonEntrantLine.get("competitorId").toString());
        String key = jsonEntrantLine.get("competitorName").toString();
        String firstName = jsonEntrantLine.get("firstName").toString();
        String lastName = jsonEntrantLine.get("lastName").toString();
        boolean status = true;
        char gender = jsonEntrantLine.get("gender").toString().charAt(0);
        String countryOfOrigin = jsonEntrantLine.get("countryOfOriginName").toString();
        String countryOfOriginCode = jsonEntrantLine.get("countryOfOriginCode").toString();
        String affiliateName = jsonEntrantLine.get("affiliateName").toString();
        String height = jsonEntrantLine.get("height").toString();
        String weight = jsonEntrantLine.get("weight").toString();
        int divisionId = Integer.parseInt(jsonEntrantLine.get("divisionId").toString());
        int affiliateID = Integer.parseInt(jsonEntrantLine.get("affiliateId").toString());
        int age = Integer.parseInt(jsonEntrantLine.get("age").toString());
        absAthlete = new AthleteFactory();
        return absAthlete.createAthlete(id, firstName, lastName, status, gender, countryOfOrigin, countryOfOriginCode, divisionId, affiliateID, affiliateName, age, height, weight);
        
    }
}
/**
 *
 * @author xbarn
 */ 
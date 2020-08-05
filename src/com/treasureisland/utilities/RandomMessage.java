package com.treasureisland.utilities;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.Unirest;
import java.util.Random;

public class RandomMessage {
    @Override
    public String toString() {
        return "RandomMessage{}";
    }

    public static String randomMessageGenerator() throws IOException {

        //call to api.  Limited to 60 calls a day.  also only 5 calls per hour
        String message= null;
//        String host = "http://api.fungenerators.com/pirate/generate/insult";
//        System.out.println("RANDOM MESSAGE: [GET] "+host);
//
//        URL urlForGetRequest = new URL(host);
//        String readLine = null;
//        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
//        conection.setRequestMethod("GET");
//
//        int responseCode = conection.getResponseCode();
//        System.out.println(responseCode);
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(conection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            while ((readLine = in .readLine()) != null) {
//                response.append(readLine);
//            } in .close();
//            // print result
//            System.out.println("JSON String Result " + response.toString());
//            message = response.toString();
//
//        } else {
//            System.out.println("Response code: [" + responseCode + "]: Too many requests");
            String [] messageArr = {"'Ahoy ye matey!'", "'Bloody pirates...'", "'Off with ye!'", "'Yo-ho and a bottle of rum!'", "'Have ye seen me eye?'" };
            Random randomMessage = new Random();

            int selectedMessage = randomMessage.nextInt(messageArr.length);
            message = messageArr[selectedMessage];

            System.out.println("Random Message selected: " + message);

//        }


        return message;
    }
}

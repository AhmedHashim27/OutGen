package edu.vassar.cmpu203.outfitgenerator.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {

    private static final String API_KEY = "ec857227cccdb611307092b70c5ba68c";
    private static final String LOCATION = "New%20York";
        //"New%20York";
    //"Cairo";

    public static String getWeatherData() {
        try {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                String response = content.toString();

                // Extract temperature and weather description
                String temperature = response.substring(response.indexOf("\"temp\":") + 7, response.indexOf(",\"feels_like\""));
                String weatherCondition = response.substring(response.indexOf("\"description\":\"") + 15, response.indexOf("\",\"icon\""));
                temperature = celciusToFarh(temperature);
                // Return formatted weather info
                return "Temperature: " + temperature + "°F, Condition: " + weatherCondition;
            } else {
                return "Error: Failed to retrieve weather data.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to retrieve weather data.";
        }
    }
    public static String celciusToFarh(String celcius) {
        double number = 0.0;
        try{
            number = Double.parseDouble(celcius);
        }catch(NumberFormatException e){
            System.out.println("Invalid weather data");
            return " " + number;
        }
        double db = (double)2 * number;
        double farh = (double)30 + db;
        return String.format("%.2f", farh);
    }
    public static void main(String[] args) {
        // Fetch and display weather data for New York
        String weatherData = getWeatherData();
        System.out.println("Current Weather in New York:");
        System.out.println(celciusToFarh(weatherData));
    }
}

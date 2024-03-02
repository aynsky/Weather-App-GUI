package model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WeatherData {

    private String city;
    private String temperature;
    private int humidity;
    private double windSpeed;
    private double windDirection;
    private String description;
    private String timestamp;
    

    // Constructor for the primary use case
    // Constructor for the primary use case
    public WeatherData(String city, String temperature, int humidity, double windSpeed, double windDirection, String description, long timestamp) {
        this.city = (city != null) ? city : "Unknown";
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = formatWindSpeed(windSpeed);
        this.windDirection = windDirection;
        this.description = description;
        this.timestamp = convertTimestamp(timestamp);
        //this.weatherImage = weatherImage;
    }
    

    private String convertTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDateTime.ofInstant(instant, zoneId).toLocalDate();

        // Use a formatter for the date
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM\ndd");

        // Format the date
        return localDate.format(dateFormatter);
    }
    


    private double formatWindSpeed(double windSpeed) {
        // Format wind speed to have two decimal places
        return Double.parseDouble(String.format("%.2f", windSpeed));
    }

    public String getCity() {
        return city;
    }

    public String getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public String getDescription() {
        return description;
    }

    public String getTimestamp() {
        return timestamp;
    }
    
    

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", description='" + description + '\'' +
                ", humidity=" + humidity +
                ", windDirection=" + windDirection +
                ", timestamp=" + timestamp +
                '}';
    }
}

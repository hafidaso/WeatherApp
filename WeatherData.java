public class WeatherData {
    private String location;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private String condition;
    private long timestamp;

    public WeatherData(String location, double temperature, int humidity, double windSpeed, String condition, long timestamp) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
        this.timestamp = timestamp;
    }

    public String getLocation() {
        return location;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getCondition() {
        return condition;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("Location: %s\nTemperature: %.2f\nHumidity: %d%%\nWind Speed: %.2f km/h\nCondition: %s",
                location, temperature, humidity, windSpeed, condition);
    }
}
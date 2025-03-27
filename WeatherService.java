import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class WeatherService {
    private static final String API_KEY = "9b18cd6f02e1a73d4796e4861e53e1e9";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public WeatherData getWeather(String location, boolean isCelsius) throws Exception {
        String urlString = String.format(BASE_URL, location, API_KEY);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Failed to fetch weather data. Response code: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        Gson gson = new Gson();
        WeatherResponse weatherResponse = gson.fromJson(response.toString(), WeatherResponse.class);

        double temperature = weatherResponse.getMain().getTemp();
        if (!isCelsius) {
            temperature = celsiusToFahrenheit(temperature);
        }

        return new WeatherData(
                weatherResponse.getName(),
                temperature,
                weatherResponse.getMain().getHumidity(),
                weatherResponse.getWind().getSpeed(),
                weatherResponse.getWeather()[0].getDescription(),
                System.currentTimeMillis()
        );
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
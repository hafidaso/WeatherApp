# README File

## Weather Information App

This application provides real-time weather updates for a specified location, including temperature, humidity, wind speed, and conditions. It also includes short-term forecasts, unit conversion, error handling, history tracking, and dynamic backgrounds.

---

## Features

- Fetches real-time weather data using the OpenWeatherMap API.
- Displays weather details such as temperature, humidity, wind speed, and conditions.
- Includes icons for visual representation of weather conditions.
- Short-term forecast for the chosen location.
- Option to switch between Celsius and Fahrenheit for temperature, and between km/h and mph for wind speed.
- Error handling for invalid inputs or failed API requests.
- History tracking with timestamps for recent searches.
- Dynamic background changes based on the time of day.

---

## How to Use

1. Obtain an API key from [OpenWeatherMap](https://openweathermap.org/).
2. Replace the placeholder in `WeatherAPI.java` with your API key.
3. Compile and run the application using your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
4. Enter a city name or coordinates in the input field and click "Get Weather".
5. View the weather details, forecast, and history.

---

## Dependencies

- Java 11 or higher
- JavaFX library
- Gson library for JSON parsing
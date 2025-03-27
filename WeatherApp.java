import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class WeatherApp extends Application {
    private WeatherService weatherService = new WeatherService();
    private HistoryManager historyManager = new HistoryManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather Information App");

        // Create UI components
        TextField locationInput = new TextField();
        locationInput.setPromptText("Enter city name or coordinates");
        Button getWeatherButton = new Button("Get Weather");
        Label resultLabel = new Label();
        ListView<String> historyList = new ListView<>();
        ToggleGroup unitToggleGroup = new ToggleGroup();
        RadioButton celsiusButton = new RadioButton("Celsius");
        RadioButton fahrenheitButton = new RadioButton("Fahrenheit");
        celsiusButton.setToggleGroup(unitToggleGroup);
        fahrenheitButton.setToggleGroup(unitToggleGroup);
        celsiusButton.setSelected(true);

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                locationInput,
                getWeatherButton,
                resultLabel,
                new HBox(10, celsiusButton, fahrenheitButton),
                new Label("Search History:"),
                historyList
        );



        // Event handler for fetching weather
        getWeatherButton.setOnAction(e -> {
            String location = locationInput.getText().trim();
            if (!location.isEmpty()) {
                try {
                    boolean isCelsius = celsiusButton.isSelected();
                    WeatherData weatherData = weatherService.getWeather(location, isCelsius);
                    resultLabel.setText(weatherData.toString());
                    historyManager.addHistory(location, weatherData.getTimestamp());
                    historyList.getItems().clear();
                    historyList.getItems().addAll(historyManager.getHistory());
                } catch (Exception ex) {
                    resultLabel.setText("Error: " + ex.getMessage());
                }
            } else {
                resultLabel.setText("Please enter a valid location.");
            }
        });

        // Scene setup
        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
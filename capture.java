@Override
public void start(Stage primaryStage) {
    VBox root = new VBox(10);
    Scene scene = new Scene(root, 400, 500);
    scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    String timeStyleClass = getTimeBasedStyle();
    root.getStyleClass().add(timeStyleClass);
    primaryStage.setScene(scene);
    primaryStage.show();
}
package JavaPractice_Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lesson_14_ComboBoxes extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Battlesbridge");
        button = new Button("Submit");
        button.setOnAction(e -> {
            System.out.println(comboBox.getValue());
        });

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Green Flower Street",
                "Hey Nineteen",
                "Ricky Don't Lose That Number",
                "Bad Sneakers"
        );
        comboBox.setPromptText("Favourite Steely Dan song?");



        VBox layout = new VBox();
        layout.setPadding(new Insets(40,40,40, 40));
        layout.getChildren().addAll(comboBox, button);

        scene = new Scene(layout, 400,300);
        window.setScene(scene);
        window.toFront();
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

package JavaPractice_Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Lesson_5_AlertBoxes extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("London");

        button = new Button("I do nothing!");
        button.setOnAction(e -> AlertBox.display("Lochdon", "'Ello!"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300,  250);
        window.setScene(scene);
        window.toFront();
        window.show();


    }
}

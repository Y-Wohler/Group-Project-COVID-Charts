package JavaPractice_Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Lesson_6_Communicating extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Stansted");

        button = new Button("I have a question for you!");
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("LiveLeak?", "Do you wanna go on LiveLeak?");
            System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300,  250);
        window.setScene(scene);
        window.toFront();
        window.show();


    }
}

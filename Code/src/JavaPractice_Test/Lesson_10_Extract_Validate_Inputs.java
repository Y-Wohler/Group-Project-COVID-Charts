package JavaPractice_Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lesson_10_Extract_Validate_Inputs extends Application {

    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Barton-on-the-Beans");

        //Form
        TextField nameinput = new TextField();

        button = new Button("Insert!");
        button.setOnAction(e -> System.out.println( nameinput.getText() ));

        //Layout
        HBox layout = new HBox();
        layout.getChildren().addAll(nameinput, button);
        layout.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(layout, 400,300);
        window.setScene(scene);
        window.toFront();
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

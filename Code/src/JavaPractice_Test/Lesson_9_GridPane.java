package JavaPractice_Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lesson_9_GridPane extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Battlesbridge");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));     // Sets the amount of padding to each edge.
        grid.setVgap(5);                                            // Sets the vertical gapes between rows.
        grid.setHgap(8);                                            // Sets the horizontal gaps between rows.

        // Name Label
        Label label = new Label("Username");
        GridPane.setConstraints(label,0,0);

        // Name input
        TextField textField = new TextField();
        textField.setPromptText("Username...");
        GridPane.setConstraints(textField, 0, 1);

        // Password Label
        Label passlabel = new Label("Password");
        GridPane.setConstraints(passlabel,1,0);

        // Password Label
        TextField passTextField = new TextField();
        passTextField.setPromptText("Password...");
        GridPane.setConstraints(passTextField, 1, 1);

        //
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 3,1);
        loginButton.fire();
        loginButton.setOnAction(e -> System.out.println("Pressed"));

        // Add to grid
        grid.getChildren().addAll(label,textField,passlabel, passTextField, loginButton);

        Scene scene = new Scene(grid, 400,300);
        window.setScene(scene);
        window.toFront();
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

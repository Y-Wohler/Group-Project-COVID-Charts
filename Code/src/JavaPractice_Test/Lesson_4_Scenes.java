package JavaPractice_Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Lesson_4_Scenes extends Application {
    Stage window;
    Scene sceneA, sceneB;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        /* Scene A */
        Label labelA = new Label("Welcome to scene A!");
        Button buttonA = new Button("Go to scene B!");
        buttonA.setOnAction(event -> window.setScene(sceneB));

        /* Layout A*/
        VBox layoutA = new VBox(50);                            //Layout 1 - children are laid out in vertical column. Items inside are spaced out by 20px.
        layoutA.getChildren().addAll(labelA, buttonA);
        sceneA = new Scene(layoutA, 800, 200);

        /* Scene B */
        Label labelB = new Label("You are now in Scene B!");
        Button buttonB = new Button("Go back to scene A!");
        buttonB.setOnAction(event -> window.setScene(sceneA));

        /*Layout B*/
        StackPane layoutB = new StackPane();
        layoutB.getChildren().addAll(labelB, buttonB);
        sceneB = new Scene(layoutB, 750, 250);

        window.setScene(sceneA);
        window.setTitle("BasicTitle");
        window.show();
    }
}

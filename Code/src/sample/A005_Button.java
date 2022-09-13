package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class A005_Button extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button exit = new Button("Exit");
        Tooltip tooltip = new Tooltip("Exit the window");
        Tooltip.install(exit, tooltip);
        exit.setStyle("-fx-background-color: red;");
        // You can do a bunch of css stuff here. Look it up



        Group group = new Group(exit);
        Scene scene = new Scene(group, 1000, 300);
        scene.setFill(Color.CYAN);
        primaryStage.setTitle("Intro Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

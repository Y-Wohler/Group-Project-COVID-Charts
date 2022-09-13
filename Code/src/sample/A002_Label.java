package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class A002_Label extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label1 = new Label("This is the Label!");
        Label label2 = new Label("This is another Label!");

        Group group = new Group(label1, label2);
        Scene scene = new Scene(group, 500, 300);
        scene.setFill(Color.BISQUE);
        primaryStage.setTitle("Intro Title");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

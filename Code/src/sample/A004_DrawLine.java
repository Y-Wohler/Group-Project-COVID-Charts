package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class A004_DrawLine extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Line line1 = new Line();
        line1.setEndX(10);
        line1.setEndY(10);
        line1.setStartX(900);
        line1.setStartY(100);

        Group group = new Group(line1);
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


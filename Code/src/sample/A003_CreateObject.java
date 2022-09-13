package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class A003_CreateObject extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text1 = new Text();
        text1.setX(50);
        text1.setY(50);
        text1.setText("This is the Text, and should be 50 down and 50 to the right!");
        text1.setFont(new Font(36));

        Group group = new Group(text1);
        Scene scene = new Scene(group, 1000, 300);
        scene.setFill(Color.MAROON);
        primaryStage.setTitle("Intro Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

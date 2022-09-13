package JavaPractice_Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lesson_11_CheckBoxes extends Application {

    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Birmingham");

        // Checkboxes
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box1.setSelected(true);

        // Buttons
        button = new Button("Checkboxes?");
        button.setOnAction(e -> {
            CheckBox[] temp = new CheckBox[2];
            temp[0] = box1;
            temp[1] = box2;
            for (int i = 0; i < temp.length; i++) {
                System.out.printf(handleOptions(temp)[i] + " ");
            }
            System.out.println();
        });


        //Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.getChildren().addAll(button, box1, box2);



        //Scene Setting
        scene = new Scene(vbox, 500, 500);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String[] handleOptions(CheckBox[] checkBoxes){
        String[] result = new String[checkBoxes.length];

        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()){
                result[i] = "YEAH";
            } else {
                result[i] = "NOPE";
            }
        }


        return result;
    }
}

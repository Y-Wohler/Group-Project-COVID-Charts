package JavaPractice_Test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lesson_12_DropdownBox extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Birmingham");

        // Dropboxes
        ChoiceBox<Integer> day = new ChoiceBox<>();
        ChoiceBox<Integer> month = new ChoiceBox<>();
        ChoiceBox<Integer> year = new ChoiceBox<>();

        day.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
        month.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        year.getItems().addAll(1999,2000, 2001, 2002, 2003);

        day.setValue(1);
        month.setValue(1);
        year.setValue(2000);


        // Buttons
        button = new Button("Checkboxes?");
        button.setOnAction(e -> {
            ChoiceBox<Integer>[] temp = new ChoiceBox[3];
            temp[0] = day; temp[1] = month; temp[2] = year;
            getChoice(temp);
        });


        //Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.getChildren().addAll(button, day, month, year);



        //Scene Setting
        scene = new Scene(vbox, 500, 500);
        window.setScene(scene);
        window.show();
    }

    private void getChoice(ChoiceBox<Integer>[] choiceBoxes){
        int count = 0;
        for (int i = 0; i < choiceBoxes.length; i++) {
            System.out.printf(choiceBoxes[i].getValue()+"");
            if (count<2){
                System.out.printf("/");
            }
            count++;
        }
        System.out.println();

    }
}

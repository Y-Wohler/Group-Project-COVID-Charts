package JavaPractice_Test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Lesson_1_2_3_Buttons extends Application implements EventHandler<ActionEvent> {

    Button button1;
    Button button2;
    Button button3;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Example Title");

        /*    Here are 3 different ways to produce a buttons on a screen that react when pressed.    */

        // Type 1: send to Handle().
        button1 = new Button("Hands");
        button1.setOnAction(this);                   // Whenever this button is pressed, the code to handle it is in 'this' class: this will be in our handle() function at the bottom.

        // Type 2: create local Handle().
        button2 = new Button("Hammers");
        button2.setOnAction(new EventHandler<ActionEvent>() {   // This does what button 1 does, but can be done in the code's arguments.
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button2 pressed: Hammers!");
            }
        });

        // Type 3: Use a "lambda expression".
        button3 = new Button("Cakes");
        button3.setOnAction(e -> System.out.println("Cakes!")); // This is a lambda expression. Really fucking weird, but it does what button 2 does in a single line instead of 4.

        StackPane layout = new StackPane();
        layout.getChildren().add(button1);       // Gets the list of children, and add the button to it.
        layout.getChildren().add(button2);
        layout.autosize();

        Scene scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        Object handle = event.getSource();
        System.out.println(handle.getClass().getCanonicalName());

        if (event.getSource() == button1){
            System.out.println("Button1 pressed: Hands!");
        }


    }
}

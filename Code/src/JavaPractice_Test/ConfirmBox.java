package JavaPractice_Test;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class ConfirmBox {

    static boolean answer;
    Button yes;
    Button no;

    public static boolean display(String title, String message){
        Stage window = new Stage();

        // Set window information.
        window.initModality(Modality.APPLICATION_MODAL);        // Gives this window priority: you cannot interact with other windows BEFORE this one.
        window.setTitle(title);
        window.setMinWidth(250);

        // Create the label and add the text to it.
        Label label = new Label(message);

        // Create the two buttons.
        Button yes = new Button("Yes!!");
        Button no = new Button("No...");

        // Button functionality
        yes.setOnAction(e -> {
            answer = true;
            window.close();
        });
        no.setOnAction(e -> {
            answer = false;
            window.close();
        });

        // Organise our buttons and the label with a layout Class.
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yes, no);

        // Create the Scene add put the layout Class into it.
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();       // Basically says "before you can return to another window, this on needs to be closed." To be used with initModality()

        return answer;              // When closed, return the answer (true for yes, false for no).
    }
}

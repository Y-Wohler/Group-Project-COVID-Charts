package JavaPractice_Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Lesson_7_Closing_Properly extends Application {

    Stage window;
    Button button;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Wimbeldon");
        button = new Button("Close Java?");
        button.setOnAction(e -> closeProgram());

        window.setOnCloseRequest(e -> {
            e.consume();            // consume() means that it will take over the event; setOnCloseRequest means that we'll be doing the CloseRequest
            closeProgram();

        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void closeProgram(){
        boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");
        if (answer){
            window.close();
        }
    }
}

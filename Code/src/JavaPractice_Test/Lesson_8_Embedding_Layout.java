package JavaPractice_Test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lesson_8_Embedding_Layout extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Newcastle");

        HBox topmenu = new HBox();
        Button b1 = new Button("001");
        Button b2 = new Button("002");
        Button b3 = new Button("003");
        topmenu.getChildren().addAll(b1,b2,b3);

        VBox sidemenu = new VBox();
        Button b4 = new Button("004");
        Button b5 = new Button("005");
        Button b6 = new Button("006");
        sidemenu.getChildren().addAll(b4,b5,b6);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topmenu);
        borderPane.setLeft(sidemenu);

        Scene scene = new Scene(borderPane, 350,300);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

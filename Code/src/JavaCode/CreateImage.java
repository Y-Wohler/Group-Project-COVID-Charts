package JavaCode;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.io.File;

public class CreateImage extends Application {

    String fileLocation = "src\\AllFiles\\graphimage.png";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        CSVReader reader = new CSVReader();                             // Create an instance of CSVReader.                     //
        reader.setFileLocation("src\\AllFiles\\exampleFile1.csv");      // Take the address of the CSV file you want to read.   //
        reader.loadFile();                                              // Look through the CSV file and store the rows.        //


        ZoomableGraphCreator graph = new ZoomableGraphCreator();                                                         // Create an instance of graph.                //
        Stage graphStage = new Stage();                                                                                  // Create a Stage to use for the graph.        //
        graph.drawGraphWithoutShowing("Graph of Cases by Day", reader.returnStoredStringArray(),                 // draw the graph (but dont show it on screen) //
                graphStage, 5);



        //Creating a Group object
        Scene scene = new Scene(new Group(), 595, 400);
        stage.setTitle("Charts Example");
        ((Group) scene.getRoot()).getChildren().add(graph.lineChart);                               // Cast to group.
        WritableImage image = scene.snapshot(null);                                      // Create an image class.
        File file = new File(fileLocation);                                                          // Create the file path.
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);     // Create the image.
        System.out.println("Image Saved at: " + fileLocation);
    }
}

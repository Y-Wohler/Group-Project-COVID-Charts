package JavaCode;

import javafx.application.Application;
import javafx.stage.Stage;

public class Run extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("init() Starting...");
        System.out.println("init() Ended.");
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start() Starting...");

        CSVReader reader = new CSVReader();                             // Create an instance of CSVReader.                     //
        reader.setFileLocation("src\\AllFiles\\exampleFile1.csv");      // Take the address of the CSV file you want to read.   //
        //reader.setFileLocation("C:\\projectfilesheader.csv");         // Take the address of the CSV file.                    //
        //System.out.println(reader.getFileLocation());                 // Print out the gathered address.                      //
        reader.loadFile();                                              // Look through the CSV file and store the rows.        //
        //reader.printStringArray();                                    // Print out the rows.                                  //

        ZoomableGraphCreator graph = new ZoomableGraphCreator();                                                         // Create an instance of graph. It'll use the data we made in reader.      //
        graph.drawGraph("Graph of Cases by Day", reader.returnStoredStringArray(),
                stage, 5);    // Create the graph graphic (if you need to know what this does, DM Mark). //
        stage.show();                                                                                   // Display the graph graphic.                                               //

        System.out.println("start() Ended.");
    }

    /* Don't need this, unless you wanna do something once the stuff in start(...) is done.
    //@Override
    public void stop() throws Exception {
        System.out.println("stop() Starting...");
        System.out.println("stop() Ended.");

    }
     */

    public static void main(String[] args) {
        launch(args);   //Puts all the stuff above into motion.
        // Basically, it does the Application arguments above in order: init(), start() and, should we choose to use stop(), stop().
        // Try not to put anything in here.
    }
}

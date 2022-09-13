package JavaCode;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;

public class GUI extends Application {

    Stage window;
    Scene scene;
    Button downloadFile;
    Button generatePDF;
    Button generateGraph;
    ComboBox<String> selectionBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("");

        // Control the way the program closes.
        {
            window.setOnCloseRequest(e -> {
                e.consume(); // consume() means that it will take over the event; setOnCloseRequest means that we'll be doing the CloseRequest.
                boolean answer = new ConfirmBox().display("Confirm Exit", "Are you sure you want to exit?");
                if (answer){
                    window.close();
                }

            });
        }

        //Buttons
        {
            // Button - Download new .csv file
            downloadFile = new Button("Update Files");
            downloadFile.setOnAction(e -> {
                // Creates an instance of CSVReader and downloads an up to date version of the .CSV file (might not work).
                URLFileHandler url = new URLFileHandler();
                String deathURL = "https://coronavirus.data.gov.uk/api/v1/data?filters=areaType=overview&structure=%7B%22areaType%22:%22areaType%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,%22date%22:%22date%22,%22newDeaths28DaysByDeathDate%22:%22newDeaths28DaysByDeathDate%22,%22cumDeaths28DaysByDeathDate%22:%22cumDeaths28DaysByDeathDate%22%7D&";
                String deathFilePath = "src\\AllFiles\\death.csv";
                String caseURL  = "https://coronavirus.data.gov.uk/api/v1/data?filters=areaName=United%2520Kingdom;areaType=overview&structure=%7B%22areaType%22:%22areaType%22,%22areaName%22:%22areaName%22,%22areaCode%22:%22areaCode%22,%22date%22:%22date%22,%22newCasesByPublishDate%22:%22newCasesByPublishDate%22,%22cumCasesByPublishDate%22:%22cumCasesByPublishDate%22%7D&";
                String caseFilePath  = "src\\AllFiles\\case.csv";
                try{
                    url.Download(deathURL, deathFilePath);
                    url.Download(caseURL, caseFilePath);
                } catch (Exception ex){
                    ex.printStackTrace();
                }


            });

            // Button - Generate PDF document.
            generatePDF = new Button("Generate PDF!");
            generatePDF.setOnAction(e -> {
                System.out.println("Generating PDF...");
                // Create a new image of the graph.
                CreateImage image = new CreateImage();
                try {
                    image.start(window);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

            // Button - Generate Graph.
            generateGraph = new Button("Generate Graph!");
            generateGraph.setOnAction(e -> {
                System.out.println("Generate Graph");
                CSVReader reader = new CSVReader();                             // Create an instance of CSVReader.                     //

                if (selectionBox.getValue() != null) {
                    switch (selectionBox.getValue()) {
                        case "Case Rate - Cumulative":
                            reader.setFileLocation("src\\AllFiles\\cases.csv");                                                                     // Take the address.
                            reader.loadFile();                                                                                                      // Store the rows.

                            ZoomableGraphCreator graph1 = new ZoomableGraphCreator();                                                                // Create an instance of graph.
                            Stage graphStage1 = new Stage();                                                                                         // Create a new window.

                            graph1.drawGraph("Graph of Overall Cases", reader.returnStoredStringArray(), graphStage1, 5);      // Create the graph on the window.
                            stage.show();                       // Display the graph graphic.                                                       // Show that window.
                            break;
                        case "Case Rate - Daily":
                            reader.setFileLocation("src\\AllFiles\\cases.csv");                                                                     // Take the address.
                            reader.loadFile();                                                                                                      // Store the rows.

                            ZoomableGraphCreator graph2 = new ZoomableGraphCreator();                                                                // Create an instance of graph.
                            Stage graphStage2 = new Stage();                                                                                         // Create a new window.

                            graph2.drawGraph("Graph of Cases Each Day", reader.returnStoredStringArray(), graphStage2, 4);      // Create the graph on the window.
                            stage.show();                       // Display the graph graphic.                                                       // Show that window.
                            break;
                        case "Death Rate - Cumulative":
                            reader.setFileLocation("src\\AllFiles\\deaths.csv");                                                                     // Take the address.
                            reader.loadFile();                                                                                                      // Store the rows.

                            ZoomableGraphCreator graph3 = new ZoomableGraphCreator();                                                                // Create an instance of graph.
                            Stage graphStage3 = new Stage();                                                                                         // Create a new window.

                            graph3.drawGraph("Graph of Overall Deaths", reader.returnStoredStringArray(), graphStage3, 5);      // Create the graph on the window.
                            stage.show();                       // Display the graph graphic.                                                       // Show that window.
                            break;
                        case "Death Rate - Daily":
                            reader.setFileLocation("src\\AllFiles\\deaths.csv");                                                                     // Take the address.
                            reader.loadFile();                                                                                                      // Store the rows.

                            ZoomableGraphCreator graph4 = new ZoomableGraphCreator();                                                                // Create an instance of graph.
                            Stage graphStage4 = new Stage();                                                                                         // Create a new window.

                            graph4.drawGraph("Graph of Deaths Each Day", reader.returnStoredStringArray(), graphStage4, 4);      // Create the graph on the window.
                            stage.show();                       // Display the graph graphic.                                                       // Show that window.
                            break;
                    }
                } else {
                    new ConfirmBox().display("Popup Message", "You need to select a Graph type!");
                }

/*
reader.setFileLocation("src\\AllFiles\\exampleFile1.csv");      // Take the address of the CSV file you want to read.   //
reader.loadFile();                                              // Look through the CSV file and store the rows.        //
//reader.printStringArray();                                    // Print out the rows.                                  //

ZoomableGraphCreator graph = new ZoomableGraphCreator();                                                // Create an instance of graph. It'll use the data we made in reader.      //
Stage graphStage = new Stage();

graph.drawGraph("Graph of Cases by Day", reader.returnStoredStringArray(), graphStage, 5);             // Create the graph graphic (if you need to know what this does, DM Mark). //
stage.show();                       // Display the graph graphic.                                               //
 */

            });
        }

        // ComboBox - Select what way you want to read the .csv
        selectionBox = new ComboBox<String>();
        selectionBox.getItems().addAll(
                "Case Rate - Cumulative",
                    "Case Rate - Daily",
                    "Death Rate - Cumulative",
                    "Death Rate - Daily"
        );
        selectionBox.setPromptText("Choose the Data Type:");

        // Organize window.
        HBox bottom = new HBox();
        bottom.setSpacing(10);
        bottom.getChildren().addAll(downloadFile, generatePDF, generateGraph);

        HBox top = new HBox();
        top.getChildren().addAll(selectionBox);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(15,15,15,15));
        borderPane.setBottom(bottom);
        borderPane.setTop(top);

        // Show window.
        scene = new Scene(borderPane, 330, 220); //x,y
        window.setScene(scene);
        window.toFront();
        window.show();
    }
}

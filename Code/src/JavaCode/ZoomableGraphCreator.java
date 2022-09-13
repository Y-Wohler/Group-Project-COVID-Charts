package JavaCode;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ZoomableGraphCreator {
    //public ;
    public String graphName;
    public LineChart lineChart;
    public double largestNumber;

    public ZoomableGraphCreator(){
        System.out.println("ZoomableGraphCreator Instance Created!");
    }

    public int findLargestNumber(ArrayList<String[]> array, int whatColumnToLookAt){
        System.out.println("\nThe \"findLargestNumber\" function has started.");
        int bigNumber = 0;
        for (int i = 0; i < array.size(); i++) {
            //System.out.println("New number: " + array.get(i)[whatColumnToLookAt]);
            try {
                int currentItem = Integer.parseInt(array.get(i)[whatColumnToLookAt]);
                if (currentItem > bigNumber) {                                   // Using the supplied ArrayList<String[]>, we see if it's the biggest one yet.
                    //ystem.out.println(bigNumber + " is smaller than " + currentItem + ", bigNumber changed!");
                    bigNumber = currentItem;
                } else {
                    //System.out.println(bigNumber + " isn't bigger than " + currentItem + ", bigNumber remains.");
                }
            }catch (NumberFormatException nfe) {
                System.out.println("Sorry, there was a number formatting error: the code was unable to turn something into an integer.");
            }catch (NullPointerException npe ) {
                System.out.println("Sorry, there was a number pointer error: the code tried to access a position that wasn't there.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Final number found: " + bigNumber);
        System.out.println("\nThe \"findLargestNumber\" function has ended.");
        if (bigNumber == 0) {
            return 20000;
        }
        largestNumber = bigNumber;
        return bigNumber;
    }

    public void drawGraph(String nameOf, ArrayList<String[]> graphStrings, Stage stageInput, int whatColumnToLookAt){
        System.out.println("\nThe \"drawGraph\" function has started.");

        // Find the largest number in the ArrayList. Used the supplied int in order to know what column in the .csv to look down.
        findLargestNumber(graphStrings, whatColumnToLookAt);

        // Create each Axis.
        //NumberAxis xAxis = new NumberAxis(0,1,1);         // The first day of 2020 to around mid 2021. Increments by 1 (single days).
        NumberAxis xAxis = new NumberAxis(0,graphStrings.size(),1);         // The first day of 2020 to HOW LONG THE FILE GOES ON FOR + 150. Increments by 1 (single days).
        xAxis.setLabel("Day");                                        // Give it a name.
        NumberAxis yAxis = new NumberAxis(0,largestNumber,5000);  // 0 to 2,000,000, in increments of 5,000. v1 should be 2,000,000.
        xAxis.setAutoRanging(true);             //
        xAxis.setForceZeroInRange(false);       //
        yAxis.setAutoRanging(true);             //
        yAxis.setForceZeroInRange(false);       //
        xAxis.setLabel("Current of Infected");                        // Give the graph a name.
        System.out.println("X and Y axis created.");

        //


        // Create the class instance of Chart we'll use.
        lineChart = new LineChart(xAxis, yAxis);            //Create the linechart.
        System.out.println("LineChart Created.");

        //Create the series (where the data will go.)
        XYChart.Series seriesList = new XYChart.Series();
        seriesList.setName(nameOf);
        System.out.println("Series Created!");

        /*
        //Add the data to the series. VERSION 1
        for (int i = 1; i < graphStrings.size(); i++) {                                                              //For every item in the array (IT SKIPS THE FIRST LINE)
            seriesList.getData().add(new XYChart.Data(i, Integer.valueOf(graphStrings.get(i)[whatColumnToLookAt])));                   // Add the data. The first denotes what day, the second is what data it holds.
        }

        //Add the data to the series. VERSION 2
        for (int i = 1; i < graphStrings.size(); i++){                                                              //For every item in the array (IT SKIPS THE FIRST LINE)
            if (graphStrings.get(i)[whatColumnToLookAt] != null) {
                seriesList.getData().add(new XYChart.Data(i, Integer.valueOf(graphStrings.get(i)[whatColumnToLookAt])));                   // Add the data. The first denotes what day, the second is what data it holds.
            } else {
                seriesList.getData().add(new XYChart.Data(i, 0));
            }
        }
        */

        for (int i = 1; i < graphStrings.size(); i++) {                                                              //For every item in the array (IT SKIPS THE FIRST LINE)
            try {
                seriesList.getData().add(new XYChart.Data(i, Integer.valueOf(graphStrings.get(i)[whatColumnToLookAt])));                   // Add the data. The first denotes what day, the second is what data it holds.
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // Put that data from the series into the LineChart.
        lineChart.getData().add(seriesList);
        lineChart.setTitle("TEMP");

        // When the mouse is clicked,
        lineChart.setOnMouseClicked(mouseEvent -> {
            if (lineChart.getData().isEmpty()) {
                lineChart.getData().add(seriesList);
            } else {
                lineChart.getData().clear();
            }
        });

        final StackPane pane = new StackPane();
        pane.getChildren().add(lineChart);
        stageInput.show();

        Group root = new Group(lineChart);                      //Creates a group. Makes it work with type lineChart.
        Scene scene = new Scene(root, 800,800);          //Creates scene. Give it the group class. Set its size.
        stageInput.setTitle("CE291 - GUI");                    //Uses the stage that will have been created in start() of TestRun.java. Names it.
        stageInput.setScene(scene);
        new ZoomManager(pane, lineChart, seriesList);           //Create instance of ZoomManager (might not be needed)
        stageInput.show();

        System.out.println("The \"drawGraph\" function has ended.");
    }

    public void drawGraphWithoutShowing(String nameOf, ArrayList<String[]> graphStrings, Stage stageInput, int whatColumnToLookAt){
        System.out.println("\nThe \"drawGraphWithoutShowing\" function has started.");

        // Find the largest number in the ArrayList. Used the supplied int in order to know what column in the .csv to look down.
        int largestPoint = findLargestNumber(graphStrings, whatColumnToLookAt);

        // Create each Axis.
        //NumberAxis xAxis = new NumberAxis(0,1,1);         // The first day of 2020 to around mid 2021. Increments by 1 (single days).
        NumberAxis xAxis = new NumberAxis(0,graphStrings.size(),1);         // The first day of 2020 to HOW LONG THE FILE GOES ON FOR + 150. Increments by 1 (single days).
        xAxis.setLabel("Day");                                        // Give it a name.
        NumberAxis yAxis = new NumberAxis(0,largestPoint,5000);  // 0 to 2,000,000, in increments of 5,000. v1 should be 2,000,000.
        xAxis.setAutoRanging(true);             //
        xAxis.setForceZeroInRange(false);       //
        yAxis.setAutoRanging(true);             //
        yAxis.setForceZeroInRange(false);       //
        xAxis.setLabel("Current of Infected");                        // Give the graph a name.
        System.out.println("X and Y axis created.");

        //


        // Create the class instance of Chart we'll use.
        lineChart = new LineChart(xAxis, yAxis);            //Create the linechart.
        System.out.println("LineChart Created.");

        //Create the series (where the data will go.)
        XYChart.Series seriesList = new XYChart.Series();
        seriesList.setName(nameOf);
        System.out.println("Series Created!");

        //Add the data to the series.
        for (int i = 1; i < graphStrings.size(); i++){                                                              //For every item in the array (IT SKIPS THE FIRST LINE)
            seriesList.getData().add(new XYChart.Data(i, Integer.valueOf( graphStrings.get(i)[5] )));                   // Add the data. The first denotes what day, the second is what data it holds.
        }

        // Put that data from the series into the LineChart.
        lineChart.getData().add(seriesList);
        lineChart.setTitle("Coronavirus Graph - 2021");

        // When the mouse is clicked,
        lineChart.setOnMouseClicked(mouseEvent -> {
            if (lineChart.getData().isEmpty()) {
                lineChart.getData().add(seriesList);
            } else {
                lineChart.getData().clear();
            }
        });

        System.out.println("The \"drawGraphWithoutShowing\" function has ended.");
    }
}

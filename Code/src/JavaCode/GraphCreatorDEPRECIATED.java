package JavaCode;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class GraphCreatorDEPRECIATED {
    //public ;
    public String graphName;

    public GraphCreatorDEPRECIATED(){
        System.out.println("GraphCreatorDEPRECIATED Instance Created!");
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
        return bigNumber;
    }

    public String[] reverseArray(String[] stringArray){
        for (int i = 0; i < stringArray.length/2; i++){                 // We only want to go through half of the array. Otherwise, we'd reverse everything we just changed.        //
            String temp = stringArray[i];                               // Set the temporary [VARIABLE] to the values held in the current position.                                 //
            stringArray[i] = stringArray[stringArray.length - i - 1];           // Then, we set the current position's value to the value held at the opposite side of the array.           //
            stringArray[stringArray.length - i - 1] = temp;                 // After that, we set the value held at the opposite side of the array, as the we value stored in temp.     //
        }
        return stringArray;
    }

    public void drawGraph(String nameOf, ArrayList<String[]> graphStrings, Stage stageInput, int whatColumnToLookAt){
        System.out.println("\nThe \"drawGraph\" function has started.");

        // Find the largest number in the ArrayList. Used the supplied int in order to know what column in the .csv to look down.
        int largestPoint = findLargestNumber(graphStrings, whatColumnToLookAt);

        // Create each Axis.
        //NumberAxis xAxis = new NumberAxis(0,550,1);         // The first day of 2020 to around mid 2021. Increments by 1 (single days).
        NumberAxis xAxis = new NumberAxis(0,graphStrings.size()+10,1);         // The first day of 2020 to HOW LONG THE FILE GOES ON FOR + 10. Increments by 1 (single days).
        xAxis.setLabel("Day");                                        // Give it a name.
        NumberAxis yAxis = new NumberAxis(0,largestPoint,5000);  // 0 to 2,000,000, in increments of 5,000. v1 should be 2,000,000.
        xAxis.setLabel("Current of Infected");                        // Give it a name.
        System.out.println("X and Y axis created.");

        // Create a Linear Regression line.



        // Create the class instance of Chart we'll use.
        LineChart lineChart = new LineChart(xAxis, yAxis);            //Create the linechart.
        System.out.println("LineChart Created.");

        //Create the series (where the data will go.)
        XYChart.Series series = new XYChart.Series();
        series.setName(nameOf);
        System.out.println("Series Created!");

        //Add the data to the series.
        for (int i = 1; i < graphStrings.size(); i++){                                                              //For every item in the array (IT SKIPS THE FIRST LINE)
            series.getData().add(new XYChart.Data(i, Integer.valueOf( graphStrings.get(i)[whatColumnToLookAt] )));  // Add the data. The first denotes what day, the second is what data it holds.
        }

        // Put that data from the series into the LineChart.
        lineChart.getData().add(series);
        lineChart.setTitle("Number of Cases");

        Group root = new Group(lineChart);                      //Creates a group. Makes it work with type lineChart.
        Scene scene = new Scene(root, 600,400);          //Creates scene. Give it the group class. Set its size.
        stageInput.setTitle("CE291 - GUI");                    //Uses the stage that will have been created in start() of TestRun.java. Names it.
        stageInput.setScene(scene);                            //Uses the stage created in start() in TestRun.java. Puts this scene in it.

        System.out.println("The \"drawGraph\" function has ended.");
    }
}

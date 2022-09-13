package JavaPractice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.chart.CategoryAxis;
import javafx.stage.Stage;

public class TestRun {
    public static void main(String[] args) {
        //double[] xValues = {1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009};
        //double[] yValues = {54, 57, 97, 59, 72, 92, 66, 81, 89, 68, 80};

        double[]xValues = {1,2};
        double[]yValues = {50,100};

        LinearPractice2 test = new LinearPractice2(xValues, yValues);
        System.out.println(test.slope());
        System.out.println();
        System.out.println();
        System.out.println();
    }
}

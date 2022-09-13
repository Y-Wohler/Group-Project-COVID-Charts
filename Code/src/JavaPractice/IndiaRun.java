package JavaPractice;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.stream.IntStream;

public class IndiaRun extends Application {

    static double[][][] TRAINING_DATA = {
            {{1.0,  400}, {800}},
            {{1.0,  450}, {820}},
            {{1.0,  500}, {980}},
            {{1.0,  550}, {990}},
            {{1.0,  600}, {800}},
            {{1.0,  650}, {920}},
            {{1.0,  700}, {930}}
          //  bias  size   rent
    };

    @Override
    public void start(Stage stage) throws Exception {

    }

    public static void main(String[] args) {
        //launch(args);
        double[][] xArray = new double[TRAINING_DATA.length][TRAINING_DATA[0][0].length];
        double[][] yArray = new double[TRAINING_DATA.length][1];
        IntStream.range(0, TRAINING_DATA.length).forEach(i -> {
            IntStream.range(0, TRAINING_DATA[0][0].length);
        });
    }
}

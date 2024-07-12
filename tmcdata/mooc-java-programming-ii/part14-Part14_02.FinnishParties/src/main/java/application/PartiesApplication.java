package application;

import java.nio.file.Paths;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.StringConverter;


public class PartiesApplication extends Application {

    @Override
    public void start(Stage stage) {

        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(1964, 2012, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Vote Share (%)");

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support for Finnish parties, 1968-2008");

        // Create a custom StringConverter to format the x-axis tick labels
        xAxis.setTickLabelFormatter(new StringConverter<Number>() {
            @Override
            public String toString(Number number) {
                return String.format("%.0f", number);
            }

            @Override
            public Number fromString(String string) {
                return Double.valueOf(string);
            }
        });

        try (Scanner reader = new Scanner(Paths.get("partiesdata.tsv"))) {

            // Get years from header row
            String headerRow = reader.nextLine();
            String[] years = headerRow.split("\t");

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.isEmpty()) {
                    continue;
                }

                String[] pieces = line.split("\t");
                // create the data set that is going to be added to the line chart
                XYChart.Series<Number,Number> series = new XYChart.Series<>();
                series.setName(pieces[0]);

                // create the data set that is going to be added to the line chart
                for (int i=1; i < years.length; i++) {
                    if (pieces[i].equals("-")) {
                        continue;
                    }
                    series.getData().add(new XYChart.Data<Number,Number>(Integer.valueOf(years[i]), Double.valueOf(pieces[i])));
                }
                // add the data set to the line chart
                lineChart.getData().add(series);
            }

        } catch (Exception e) {
            System.out.println("Reading partiesdata.tsv failed.");
            System.out.println(e);
        }

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}

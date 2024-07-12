package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ShanghaiApplication extends Application {

    @Override
    public void start(Stage stage) {

        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
    
        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

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

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai Ranking 2007-17");
    
        // create the data set that is going to be added to the line chart
        XYChart.Series<Number,Number> rankData = new XYChart.Series<>();
        rankData.setName("Shanghai Ranking");
        // and single points into the data set
        rankData.getData().add(new XYChart.Data<Number,Number>(2007, 73));
        rankData.getData().add(new XYChart.Data<Number,Number>(2008, 68));
        rankData.getData().add(new XYChart.Data<Number,Number>(2009, 72));
        rankData.getData().add(new XYChart.Data<Number,Number>(2010, 72));
        rankData.getData().add(new XYChart.Data<Number,Number>(2011, 74));
        rankData.getData().add(new XYChart.Data<Number,Number>(2012, 73));
        rankData.getData().add(new XYChart.Data<Number,Number>(2013, 76));
        rankData.getData().add(new XYChart.Data<Number,Number>(2014, 73));
        rankData.getData().add(new XYChart.Data<Number,Number>(2015, 67));
        rankData.getData().add(new XYChart.Data<Number,Number>(2016, 56));
        rankData.getData().add(new XYChart.Data<Number,Number>(2017, 56));
    
        // add the data set to the line chart
        lineChart.getData().add(rankData);
    
        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

}

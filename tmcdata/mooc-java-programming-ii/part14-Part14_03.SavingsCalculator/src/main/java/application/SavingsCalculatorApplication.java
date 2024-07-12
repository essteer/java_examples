package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) {

        // Main borderpane
        BorderPane layout = new BorderPane();

        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Forecast Savings Growth");

        // Initialise savings calculator instance
        Calculator calc = new Calculator();
        // Start values at $50 per month and 2% interest
        double initialMonthlyDeposit = 50.0;
        double initialInterestRate = 2.0;
        calc.updateSavingsAndInterest(initialMonthlyDeposit, initialInterestRate);

        // Sliders at top
        VBox sliders = new VBox();
        
        // Top slider
        BorderPane monthlySavings = new BorderPane();
        Slider monthlySavingsSlider = new Slider(25.0, 250.0, initialMonthlyDeposit);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setMajorTickUnit(25);
        monthlySavingsSlider.setPrefWidth(550);

        Label monthlySavingsLabel = new Label("Monthly savings");
        monthlySavingsLabel.setPrefWidth(200);
        monthlySavingsLabel.setPadding(new Insets(10, 10, 10, 10));

        Label monthlySavingsValue = new Label(String.valueOf(initialMonthlyDeposit));

        monthlySavings.setLeft(monthlySavingsLabel);
        monthlySavings.setCenter(monthlySavingsSlider);
        monthlySavings.setRight(monthlySavingsValue);
        monthlySavings.setPadding(new Insets(25, 10, 10, 10));

        // Bottom slider
        BorderPane yearlyInterestRate = new BorderPane();
        Slider yearlyInterestRateSlider = new Slider(0.0, 10.0, initialInterestRate);
        yearlyInterestRateSlider.setShowTickMarks(false);
        yearlyInterestRateSlider.setShowTickLabels(true);
        yearlyInterestRateSlider.setMajorTickUnit(10);
        yearlyInterestRateSlider.setPrefWidth(550);

        Label yearlyInterestRateLabel = new Label("Yearly interest rate");
        yearlyInterestRateLabel.setPrefWidth(200);
        yearlyInterestRateLabel.setPadding(new Insets(10, 10, 10, 10));

        Label yearlyInterestRateValue = new Label(String.valueOf(initialInterestRate));
        
        yearlyInterestRate.setLeft(yearlyInterestRateLabel);
        yearlyInterestRate.setCenter(yearlyInterestRateSlider);
        yearlyInterestRate.setRight(yearlyInterestRateValue);
        yearlyInterestRate.setPadding(new Insets(25, 10, 10, 10));

        
        monthlySavingsSlider.valueProperty().addListener((ov, old_val, new_val) -> {
            // Get new savings deposit value
            double newMonthlyDepositValue = (double) Math.round(new_val.doubleValue());
            // Get current interest rate value
            double currentInterestRate = (double) Math.round(yearlyInterestRateSlider.getValue());
            // Update slider
            monthlySavingsSlider.setValue(newMonthlyDepositValue);
            monthlySavingsValue.setText(String.valueOf(newMonthlyDepositValue));
            // Update series
            calc.updateSavingsAndInterest(newMonthlyDepositValue, currentInterestRate);
        });
        
        yearlyInterestRateSlider.valueProperty().addListener((ov, old_val, new_val) -> {
            // Get current savings deposit value
            double currentMonthlyDepositValue = (double) Math.round(monthlySavingsSlider.getValue());
            // Get new interest rate value
            double newInterestRate = (double) Math.round(new_val.doubleValue());
            // Update slider
            yearlyInterestRateSlider.setValue(newInterestRate);
            yearlyInterestRateValue.setText(String.valueOf(newInterestRate));
            // Update series
            calc.updateInterestOnly(currentMonthlyDepositValue, newInterestRate);
        });

        // Add sliders to VBox
        sliders.getChildren().addAll(monthlySavings, yearlyInterestRate);
        sliders.setAlignment(Pos.CENTER);

        sliders.setPrefHeight(100);

        // Update line chart with new series
        XYChart.Series<Number,Number> savingsData = calc.getSavingsSeries();
        XYChart.Series<Number,Number> interestData = calc.getInterestSeries();
        lineChart.getData().add(savingsData);
        lineChart.getData().add(interestData);

        // Add VBox (sliders) and line chart to layout
        layout.setTop(sliders);
        layout.setCenter(lineChart);

        // display the line chart
        // Scene view = new Scene(layout, 840, 640);
        Scene view = new Scene(layout, 320, 300);
        stage.setScene(view);
        stage.show();

    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}

// First implement the user interface of the program. The components of the
// application can be managed using a BorderPane. In the middle of the
// BorderPane add a line chart (LineChart), which has two numerical axis
// (NumberAxis). On the top of the BorderPane add a VBox component which
// contains two BorderPanes. The first BorderPane (on top) contains the text
// "Monthly savings" on the left, a slider in the middle and a text describing
// the slider on the right. The second BorderPane (below the first one) has the
// text "Yearly interest rate" on the left, a slider in the middle and a text
// describing the slider on the right.

// After the user interface is complete, start implementing the functionality of
// the program.

// Modify the user interface so, that when user changes the sum to save each
// month (by moving the uppermost slider), the line chart updates to display the
// savings amount of the new monthly sum. For example when the monthly savings
// amount is 50, the line chart should have a line showing the values [(0,0),
// (1,600), (2,1200),(3,1800),...].

// Modify the user interface so, that it shows the interest rate as well. The
// line chart should have two lines, one for showing just the monthly savings,
// and one for showing the monthly savings and the interest rate.

// Calculate the interest rate yearly according to the expected savings at the
// end of the year. For example when the monthly savings sum is 50 and the
// yearly interest rate is 5%, the line chart should have a line showing the
// values [(0,0), (1, 630), (2, 1291.5), (3, 1986,075), ...].

// In this phase the application should look like so (when the monthly sum to
// save is 50 and the yearly interest rate is 10%):
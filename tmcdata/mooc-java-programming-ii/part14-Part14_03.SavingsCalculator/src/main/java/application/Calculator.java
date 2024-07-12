package application;

import javafx.scene.chart.XYChart;

public class Calculator {

    private XYChart.Series<Number,Number> savingsSeries;
    private XYChart.Series<Number,Number> interestSeries;


    public Calculator() {
        // Create savings series
        this.savingsSeries = new XYChart.Series<>();
        this.savingsSeries.setName("Projected Savings");
        // Create compound interest series
        this.interestSeries = new XYChart.Series<>();
        this.interestSeries.setName("Projected Interest");
    }

    public XYChart.Series<Number,Number> getSavingsSeries() {
        return this.savingsSeries;
    }

    public XYChart.Series<Number,Number> getInterestSeries() {
        return this.interestSeries;
    }

    public void updateSavingsAndInterest(double monthlyDeposit, double interestRate) {

        this.savingsSeries.getData().clear();
        this.savingsSeries.getData().add(new XYChart.Data<Number, Number>(0, 0));
        for (int i = 1; i < 31; i++) {
            this.savingsSeries.getData().add(new XYChart.Data<Number, Number>(i, i * 12 * monthlyDeposit));
        }
        // Update interest projection whenever monthly deposit changes
        this.updateInterestOnly(monthlyDeposit, interestRate);
    }

    public void updateInterestOnly(double monthlyDeposit, double interestRate) {

        this.interestSeries.getData().clear();
        this.interestSeries.getData().add(new XYChart.Data<Number, Number>(0, 0));
        
        double compoundValue = 0.0;
        for (int i = 1; i < 31; i++) {
            double interest = 1 + (interestRate / 100);
            compoundValue += 12 * monthlyDeposit;
            compoundValue *= interest;
            interestSeries.getData().add(new XYChart.Data<Number, Number>(i, compoundValue));
        }
    }

}

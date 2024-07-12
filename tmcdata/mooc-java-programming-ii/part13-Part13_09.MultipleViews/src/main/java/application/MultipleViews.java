package application;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    // There is a class called MultipleViews in the exercise template. 
    // Create in it an application that contains three separate views. The views are as follows:

    @Override
    public void start(Stage window) {

        // The layout of the first view is done with the help of the BorderPane class. 
        // At the top there is the text "First view!". 
        // The center of the view contains a button with the text "To the second view!". 
        // By pressing that button the application swithces to the second view.
        BorderPane layout1 = new BorderPane();
        layout1.setTop(new Label("First view!"));
        Button button1 = new Button("To the second view!");
        layout1.setCenter(button1);

        // The layout of the second view is done with the help of the VBox class. 
        // The first element in the layout is a button with the text "To the third view!" in it — by pressing the button the application switches to the third view. 
        // The button is followed by the text "Second view!".
        VBox layout2 = new VBox();
        layout2.setSpacing(10);
        Button button2 = new Button("To the third view!");
        layout2.getChildren().add(button2);
        layout2.getChildren().add(new Label("Second view!"));

        // The third view uses the GridPane class for its layout. 
        // At the coordinates (0, 0) there is a text that reads "Third view!". 
        // At coordinates (1, 1) there is a button with the text "To the first view!". 
        // Pressing this button brings back the first view.
        GridPane layout3 = new GridPane();
        layout3.add(new Label("Third view!"), 0, 0);  
        Button button3 = new Button ("To the first view!");
        layout3.add(button3, 1, 1);

        Scene first = new Scene(layout1);
        Scene second = new Scene(layout2);
        Scene third = new Scene(layout3);

        button1.setOnAction((event) -> {
            window.setScene(second);
        });
        button2.setOnAction((event) -> {
            window.setScene(third);
        });
        button3.setOnAction((event) -> {
            window.setScene(first);
        });

        window.setScene(first);
        window.show();

    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}




package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().add(new Label("Letters: 0"));
        hbox.getChildren().add(new Label("Words: 0"));
        hbox.getChildren().add(new Label("The longest word is:"));

        layout.setCenter(new TextArea());
        layout.setBottom(hbox);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}


// Create an applicaton in the class provided in the exercise template. Use the BorderPane class for the layout. In the center there should be a text field created using the TextArea class, and along the bottom edge there should be three textComponents. Place the text components along the bottom edge into a HBox object.The first text component should have the text "Letters: 0", the second text component should have the text "Words: 0", and the third text component should have the text "The longest word is:".
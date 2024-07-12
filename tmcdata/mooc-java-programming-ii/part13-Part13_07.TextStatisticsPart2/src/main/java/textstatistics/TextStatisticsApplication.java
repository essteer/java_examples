package textstatistics;

import java.util.Arrays;

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

        TextArea textBox = new TextArea();

        Label letters = new  Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longest = new Label("The longest word is:");

        textBox.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int numWords = parts.length;
            String longestWord = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
        
            // set values of text elements
            letters.setText(letters.getText().split(" ")[0] + " " + characters);
            words.setText(words.getText().split(" ")[0] + " " + numWords);
            longest.setText("The longest word is: " + longestWord);
        });
        
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(letters, words, longest);

        layout.setCenter(textBox);
        layout.setBottom(hbox);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}


// Copy the work you did in the Text statistics exercise into the class included in the exercise template and add to it the functionality from the example above for calculating the statistics. 
// The end result should an application that calculates statistics based on text that is input, which are updated automatically and displayed in the application.
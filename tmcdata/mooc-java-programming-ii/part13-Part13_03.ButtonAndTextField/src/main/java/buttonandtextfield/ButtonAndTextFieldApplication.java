package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {

    @Override
    public void start(Stage window) {
        Button buttonComponent = new Button("BUTTON!");
        TextField textComponent = new TextField("Enter text: ");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(textComponent);

        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}

// Create a graphical user interface to the class in the exercise template. The interface must contain a button and a text field. The text field can be implemented using the TextField class. The Button must be on the left or on the top of the text field.

// Create a graphical user interface in the class that is supplied with the exercise base. It should contain a button and a text field. You can implement the text field with the help of the TextField class. The button should be placed above or to the left of the text field.
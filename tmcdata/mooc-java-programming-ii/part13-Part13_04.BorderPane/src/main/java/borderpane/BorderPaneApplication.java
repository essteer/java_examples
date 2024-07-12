package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();
        layout.setTop(new Label("NORTH"));
        layout.setRight(new Label("EAST"));
        layout.setBottom(new Label("SOUTH"));
        layout.setLeft(new Label("WEST"));

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

}

// Create a graphical user interface in the class provided in the exercise template. It should use the BorderPane class for laying out the components of the user interface. Add a textComponent at the top edge of the window containing the text "NORTH", a textComponent along the right edge containing the text "EAST", and a textComponent at the bottom edge containing the text "SOUTH".
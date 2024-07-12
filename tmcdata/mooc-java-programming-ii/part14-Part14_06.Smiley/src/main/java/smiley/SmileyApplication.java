package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage window) {

        Canvas paintingCanvas = new Canvas(640, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        ColorPicker colorPalette = new ColorPicker();

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);
        paintingLayout.setRight(colorPalette);

        painter.setFill(Color.BLACK);
        painter.fillRect(70, 60, 25, 25);
        painter.fillRect(200, 60, 25, 25);
        painter.fillRect(75, 200, 150, 25); 
        painter.fillRect(75, 175, 25, 25); 
        painter.fillRect(200, 175, 25, 25);

        paintingCanvas.setOnMouseDragged((event) -> {
            double xLocation = event.getX();
            double yLocation = event.getY();
            painter.setFill(colorPalette.getValue());
            painter.fillOval(xLocation, yLocation, 4, 4);
        });

        Scene view = new Scene(paintingLayout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
// Create a graphical user interface into the class that is supplied with the exercise base. Add a BorderPane into the GUI to be responsible for the application's layout. Add a Canvas object in the middle of the BorderPane. After doing this, use the GraphicsContext object of the Canvas object to draw a smiley. Use white (Color.WHITE) as the background color, and black (Color.BLACK) as the color of the smiley.

// The tests in this exercise only check that you draw into the window. Before returning, make sure that drawing the smiley works correctly. Notice that the purpose here is NOT to manually draw the smiley with the mouse — use the methods of the GraphicsContext object so that the picture is already drawn when the program is first started.
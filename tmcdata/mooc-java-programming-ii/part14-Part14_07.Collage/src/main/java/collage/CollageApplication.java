package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        // int yCoordinate = 0;
        // while (yCoordinate < height) {
        //     int xCoordinate = 0;
        //     while (xCoordinate < width) {

        //         Color color = imageReader.getColor(xCoordinate, yCoordinate);
        //         double red = color.getRed();
        //         double green = color.getGreen();
        //         double blue = color.getBlue();
        //         double opacity = color.getOpacity();

        //         Color newColor = new Color(red, green, blue, opacity);

        //         imageWriter.setColor(xCoordinate, yCoordinate, newColor);

        //         xCoordinate++;
        //     }

        //     yCoordinate++;
        // }

        int yCoordinate = 0;
        while (yCoordinate < height / 2) {
            int xCoordinate = 0;
            while (xCoordinate < width / 2) {

                Color color = imageReader.getColor(xCoordinate * 2, yCoordinate * 2);
                double red = 1.0 - color.getRed();
                double green = 1.0 - color.getGreen();
                double blue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);
                imageWriter.setColor(xCoordinate, yCoordinate, newColor);
                imageWriter.setColor(xCoordinate + (width / 2), yCoordinate + (height / 2), newColor);
                imageWriter.setColor(xCoordinate + (width / 2), yCoordinate, newColor);
                imageWriter.setColor(xCoordinate, yCoordinate + (height / 2), newColor);

                xCoordinate++;
            }
            yCoordinate++;
        }

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

// Top left corner
// In the exercise base there is a program that loads and displays the Mona Lisa. In this section your goal is to create a situation where the Mona Lisa is displayed as a smaller image in the top left corner. The size of the smaller image should be one fourth of the original image.
// So in practice the point (0, 0) should contain the value at the coordinates (0, 0). The coordinates at (0, 1) should contain the value at coordinates (0, 2). Similarly, the point (0, 2) should contain the value at the point (0, 4), the point (0, 3) the value at (0, 6), etc. The same holds true with the y-axis, so point (1, 1) should have the value of (2, 2), the point (1, 2) the value of (2, 4), etc.

// Grid
// Then modify the program so that the small image at the top left corner is repeated four times in the whole collage. The top-left corner of the first image should be at the coordinates (0, 0). The top-left corner of the second image should be at the point (width of image / 2, 0). The top-left corner of the third image should be at (0, height of image / 2), and the top-left corner of the fourth image should be at (width of image / 2, height of image / 2).

// Negative
// You've come this far, and now you can display a grid of four small images. Next, modify the image so that the negative of the original is displayed. You can create a negative by assigning to each pixel, the following color values: the subtraction of the original color from 1. So for the red color this would be red = 1.0 - red.
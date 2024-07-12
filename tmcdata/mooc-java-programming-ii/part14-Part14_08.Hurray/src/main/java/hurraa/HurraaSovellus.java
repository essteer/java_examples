package hurraa;

// import javafx.scene.media.AudioClip;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


// public class HurraaSovellus extends Application {

//     @Override
//     public void start(Stage stage) throws Exception {
//         BorderPane pane = new BorderPane();

//         Button nappi = new Button("Hurraa!");
//         pane.setCenter(nappi);

//         AudioClip sound = new AudioClip("file:Applause-Yannick_Lemieux.wav");
        
//         nappi.setOnAction((event) -> {
//             sound.play();
//         });

//         Scene scene = new Scene(pane, 600, 400);

//         stage.setScene(scene);
//         stage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }

// }

// import javafx.scene.media.AudioClip; does not work

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button nappi = new Button("Hurraa!");
        
        File audioFile = new File("Applause-Yannick_Lemieux.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        
        nappi.setOnMouseClicked(e-> {
            clip.start();
        });
        
        pane.setCenter(nappi);


        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

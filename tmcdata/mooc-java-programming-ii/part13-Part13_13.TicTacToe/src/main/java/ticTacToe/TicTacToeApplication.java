package ticTacToe;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // 1. UI component layout
        // BorderPane class to hold UI components
        BorderPane layout = new BorderPane();
        // Top: text component that includes info about the turn, and end of game message
        Label gameTracker = new Label("Turn: X");
        gameTracker.setFont(Font.font("Monospaced", 40));
        layout.setTop(gameTracker);
        // Center: GridPane that contains 9 buttons
        Gameboard gameboard = new Gameboard();
        layout.setCenter(gameboard.getGridPane());


        // 2. Define action logic
        for (Node child : gameboard.getGridPane().getChildren()) {
            if (child instanceof Button) {
                Button button = (Button) child;
                // Access the button object and perform actions
                button.setOnAction((event) -> {

                    if (button.getText().isEmpty() && !(gameboard.isGameOver())) {
                        String currentPlayer = gameTracker.getText().split(" ")[1];
                        gameboard.updateButton(button, currentPlayer);
                        boolean gameOver = gameboard.isGameOver();

                        // Check game status and update turn message
                        if (!(gameOver)) {
                            if (gameTracker.getText() == "Turn: X") {
                                gameTracker.setText("Turn: O");
                                currentPlayer = "O";
                                gameTracker.setText("Turn: " + currentPlayer);
                            } else {
                                gameTracker.setText("Turn: X");
                                currentPlayer = "X";
                            }
                        } else {
                            // game over
                            gameTracker.setText("The end!");
                        }
                    }
                });
            }
        }
        
        // 3. Create main scene with layout
        Scene scene = new Scene(layout);

        // 4 Show main scene
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}

// The players of the game are X and O. X always takes the first turn. Add the following functionality to the buttons: when a button is pressed, the game updates so that symbol of the current player (X if it was X's turn when the button was pressed) is stored in the button. After this the other player gets their turn.

// The text component at the top of the game must always show whose turn it is. The text begins as "Turn: X". Once X finishes their turn by pressing a button, the text should change to "Turn: O". After player O has finished their turn, the text should turn into "Turn: X" again.

// NB! If a player has already placed their symbol in a position, the other player cannot choose the same position. Make sure that the turn doesn't change if a player tries to choose a position that already contains a symbol.

// NB!! You might encounter the following error: "local variables referenced from a lambda expression must be final or effectively final". This is because objects instanced of interfaces cannot use variables that are defined outside of the method. You can avoid the error by creating new variables that you set the problematic values to just before using them in the method.


// package ticTacToe;
 
// import javafx.application.Application;
// import static javafx.application.Application.launch;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.layout.BorderPane;
// import javafx.scene.layout.GridPane;
// import javafx.scene.text.Font;
// import javafx.stage.Stage;
 
// public class TicTacToeApplication extends Application {
 
//     @Override
//     public void start(Stage stage) throws Exception {
//         TicTacToe ticTacToe = new TicTacToe();
 
//         Font monoSpaced = Font.font("Monospaced", 40);
        
//         Label gameStatus = new Label("Turn: " + ticTacToe.turn());
//         gameStatus.setFont(monoSpaced);
        
//         BorderPane layout = new BorderPane();
//         layout.setTop(gameStatus);
 
//         GridPane grid = new GridPane();
//         grid.setHgap(10);
//         grid.setVgap(10);
//         grid.setPadding(new Insets(10, 10, 10, 10));
 
//         for (int x = 0; x < 3; x++) {
//             for (int y = 0; y < 3; y++) {
//                 Button btn = new Button(ticTacToe.status(x, y));
//                 btn.setFont(monoSpaced);
 
//                 grid.add(btn, x, y);
 
//                 int rx = x;
//                 int ry = y;
 
//                 btn.setOnAction((event) -> {
//                     ticTacToe.place(rx, ry);
//                     btn.setText(ticTacToe.status(rx, ry));
//                     gameStatus.setText("Turn: " + ticTacToe.turn());
 
//                     if (ticTacToe.ended()) {
//                         gameStatus.setText("The end!");
//                     }
//                 });
//             }
//         }
 
//         layout.setCenter(grid);
//         Scene scn = new Scene(layout);
 
//         stage.setScene(scn);
//         stage.show();
//     }
 
//     public static void main(String[] args) {
//         launch(TicTacToeApplication.class);
//         System.out.println("Hello world!");
//     }
 
// }
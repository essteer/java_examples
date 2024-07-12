package ticTacToe;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.text.Font;

public class Gameboard extends GridPane {

    private GridPane grid;
    private boolean gameOver;
    private int occupiedTiles;

    public Gameboard() {
        // Initialise board
        this.grid = new GridPane();
        this.gameOver = false;
        this.occupiedTiles = 0;
        // Create grid buttons using a loop
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
              Button button = new Button("");
              button.setFont(Font.font("Monospaced", 40));
              button.setPrefWidth(100);
              this.grid.add(button, col, row);
            }
        }
        // Style the grid
        this.grid.setPrefSize(300, 180);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setVgap(10);
        this.grid.setHgap(10);
        this.grid.setPadding(new Insets(20, 20, 20, 20));
    }

    public GridPane getGridPane() {
        return this.grid;
    }

    public void updateButton(Button button, String player) {
        button.setText(player);
        this.occupiedTiles += 1;
    }

    private boolean threeInARow() {

        if (this.occupiedTiles < 5) {
            return false;
        }

        ArrayList<Button> buttons = new ArrayList<>();

        for (Node child : this.grid.getChildren()) {
            if (child instanceof Button) {
                buttons.add((Button) child);
            }
        }

        for (int i = 0; i < 3; i++) {
            int row = i * 3;
            int col = i;
        
            // Check row
            if (!buttons.get(row).getText().isEmpty() &&
                buttons.get(row).getText().equals(buttons.get(row + 1).getText()) &&
                buttons.get(row).getText().equals(buttons.get(row + 2).getText())) {
              return true;
            }
        
            // Check column
            if (!buttons.get(col).getText().isEmpty() &&
                buttons.get(col).getText().equals(buttons.get(col + 3).getText()) &&
                buttons.get(col).getText().equals(buttons.get(col + 6).getText())) {
              return true;
            }
        }

        // Check diagonals
        if (!buttons.get(0).getText().isEmpty() &&
            buttons.get(0).getText().equals(buttons.get(4).getText()) &&
            buttons.get(0).getText().equals(buttons.get(8).getText())) {
                return true;
        }
        if (!buttons.get(2).getText().isEmpty() &&
            buttons.get(2).getText().equals(buttons.get(4).getText()) &&
            buttons.get(2).getText().equals(buttons.get(6).getText())) {
                return true;
        }
        return false;
    }
        
    public boolean isGameOver() {
        if (this.occupiedTiles == 9) {
            this.gameOver = true;
            return this.gameOver;
        }
        this.gameOver = threeInARow();
        return this.gameOver;
    }

}


// package ticTacToe;
 
// import java.util.Arrays;
 
// public class TicTacToe {
 
//     private String[][] ticTacToe;
//     private String turn;
 
//     public TicTacToe() {
//         this.ticTacToe = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
//         this.turn = "X";
//     }
 
//     public String status(int x, int y) {
//         if (x < 0 || y < 0 || x > 2 || y > 2) {
//             return "";
//         }
 
//         return this.ticTacToe[x][y];
//     }
 
//     public void place(int x, int y) {
//         if (x < 0 || y < 0 || x > 2 || y > 2) {
//             return;
//         }
 
//         if (!this.ticTacToe[x][y].equals(" ")) {
//             return;
//         }
 
//         if (ended()) {
//             return;
//         }
 
//         this.ticTacToe[x][y] = this.turn;
 
//         if (this.turn.equals("X")) {
//             this.turn = "O";
//         } else {
//             this.turn = "X";
//         }
 
//     }
 
//     public boolean ended() {
//         int[][] sameSymbols = {
//             {0, 1, 2},
//             {3, 4, 5},
//             {6, 7, 8},
//             {0, 4, 8},
//             {6, 4, 2},
//             {0, 3, 6},
//             {1, 4, 7},
//             {2, 5, 8}
//         };
 
//         for (int i = 0; i < sameSymbols.length; i++) {
//             if (arrayHasSameSymbolsInPlaces(sameSymbols[i])) {
//                 return true;
//             }
//         }
 
//         for (int x = 0; x < 3; x++) {
//             for (int y = 0; y < 3; y++) {
//                 if (status(x, y).trim().isEmpty()) {
//                     return false;
//                 }
//             }
//         }
 
//         return true;
//     }
 
//     public String turn() {
//         return this.turn;
//     }
 
//     private boolean arrayHasSameSymbolsInPlaces(int[] array) {
//         String[] values = {valueInArray(array[0]), valueInArray(array[1]), valueInArray(array[2])};
//         Arrays.sort(values);
//         return values[0].equals(values[1]) && values[1].equals(values[2]) && !values[0].trim().isEmpty();
//     }
 
//     private String valueInArray(int place) {
//         int x = place % 3;
//         int y = place / 3;
//         return this.ticTacToe[x][y];
//     }
 
// }
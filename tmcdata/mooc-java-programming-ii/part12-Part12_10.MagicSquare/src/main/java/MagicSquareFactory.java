
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        // implement the creation of a magic square with the Siamese method algorithm
        // here
        int row = 0;
        int col = size / 2;

        square.placeValue(col, row, 1);

        for (int i = 2; i <= size * size; i++) {
            if (square.readValue((col + 1) % size, (row - 1 + size) % size) == 0) {
                row = (row - 1 + size) % size;
                col = (col + 1) % size;
            } else {
                row = (row + 1 + size) % size;
            }
            square.placeValue(col, row, i);
        }
        return square;
    }
}

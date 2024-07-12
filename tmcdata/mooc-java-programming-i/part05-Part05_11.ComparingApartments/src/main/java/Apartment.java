
public class Apartment {

    private int rooms;
    private int squares;
    private int princePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.princePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        return this.squares > compared.squares;
    }

    public int priceDifference(Apartment compared) {
        int thisPrice = this.squares * this.princePerSquare;
        int comparePrice = compared.squares * compared.princePerSquare;

        if (thisPrice >= comparePrice) {
            return thisPrice - comparePrice;
        } else {
            return comparePrice - thisPrice;
        }
    }

    public boolean moreExpensiveThan(Apartment compared) {

        if (this.squares * this.princePerSquare > compared.squares * compared.princePerSquare) {
            return true;
        }
        
        return false;
    }

}

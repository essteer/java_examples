
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public Money plus(Money addition) {
        Money newMoney = new Money(this.euros + addition.euros, this.cents + addition.cents);
        return newMoney;
    }

    public boolean lessThan(Money compared) {

        // return (100 * this.euros + this.cents) < (100 * compared.euros() + compared.cents());

        if (this.euros > 0 && compared.euros < 0) {
            return false;
        }

        if (this.euros < 0 && compared.euros > 0) {
            return true;
        }

        if (this.euros < compared.euros) {
            return true;
        } else if (this.euros > compared.euros) {
            return false;
        }
        
        if (this.cents < compared.cents) {
            return true;
        }

        return false;
    }

    public Money minus(Money decreaser) {

        // int euros = this.euros - decreaser.euros();
        // int cents = this.cents - decreaser.cents();
 
        // if (cents < 0) {
        //     cents = cents + 100;
        //     euros = euros - 1;
        // }
 
        // // if the value becomes negative, return zero
        // if (euros < 0) {
        //     return new Money(0, 0);
        // }
 

        int newEuros = this.euros - decreaser.euros;
        int newCents = this.cents - decreaser.cents;

        if (newCents < 0) {
            if (newEuros < 1) {
                newCents = 0;
            } else {
                newCents += 100;
                newEuros -= 1;
            }
        }
        if (newEuros < 0) {
            newEuros = 0;
            newCents = 0;
        }

        Money newMoney = new Money(newEuros, newCents);
        
        return newMoney;

    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

}

// Write the method public Money minus(Money decreaser) that returns a new money object worth the difference of the object whose method was called and the object received as the parameter. If the difference would be negative, the worth of the created money object is set to 0.

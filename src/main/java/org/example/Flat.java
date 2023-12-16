package org.example;

public class Flat extends AbstractSpace implements Space {

    public Flat(int square) {
        super(square);
    }

    public Flat() {
        super();
    }

    public Flat(int square, int quantity) {
        super(square, quantity);
    }

}

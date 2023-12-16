package org.example;

public class Office extends AbstractSpace implements Space {
    public Office() {
        super();
    }

    public Office(int square) {
        super(square);
    }

    public Office(int square, int quantity) {
        super(square, quantity);
    }
}

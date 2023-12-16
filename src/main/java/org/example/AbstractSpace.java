package org.example;

public abstract class AbstractSpace implements Space {
    private int square = 0;
    private int quantity = 0;

    private static final int SQUARE_DEF = 50, QUANTITY_DEF = 2;

    public AbstractSpace() {
        this.square = SQUARE_DEF;
        this.quantity = QUANTITY_DEF;
    }

    public AbstractSpace(int square) {
        this.square = square;
        quantity = QUANTITY_DEF;
    }

    public AbstractSpace(int square, int quantity) {
        this.square = square;
        this.quantity = quantity;
    }

    public int getSquare() {
        return (int) square;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

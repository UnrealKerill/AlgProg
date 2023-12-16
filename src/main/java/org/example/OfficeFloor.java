package org.example;

import org.example.DwellingFloor;
import org.example.Flat;
import org.example.Floor;

public class OfficeFloor implements Floor {

    private Flat[] myFlats;

    public OfficeFloor(int count) {

        myFlats = new Flat[count];
        for (int i = 0; i < count; i++) {
            myFlats[i] = new Flat();
        }
    }

    public OfficeFloor(Flat[] flats) {

        myFlats = flats;

    }

    public int getTotalFlats() {
        return myFlats.length;
    }

    public double getFlatsSquare() {
        double square = 0;
        for (int i = 0; i < myFlats.length; i++) {
            square = square + myFlats[i].getSquare();
        }
        return square;
    }

    public int getFlatsQuantity() {
        int quantity = 0;
        for (int i = 0; i < myFlats.length; i++) {
            quantity = quantity + myFlats[i].getQuantity();
        }

        return quantity;
    }

    public Flat[] getFlats() {
        return myFlats;
    }

    public Flat getFlat(int index) {

        return myFlats[index];
    }

    @Override
    public void setFlat(int index, Space newFlat) {

        Flat myFlat = new Flat(newFlat.getQuantity(), newFlat.getSquare());
        myFlats[index] = myFlat;

    }

    @Override
    public void addFlat(int index, Space newFlat) {
        Flat myFlat = new Flat(newFlat.getQuantity(), newFlat.getSquare());
        addFlat(index, myFlat);
    }

    public void addFlat(int index, Flat newFlat) {

        Flat[] temp = new Flat[myFlats.length + 1];

        for (int i = 0, j = 0; i < myFlats.length && j < temp.length; i++, j++) {

            if (index != j) {
                try {
                    temp[j] = myFlats[i];
                } catch (Exception e) {
                    break;
                }
            } else {
                temp[j] = newFlat;
                j++;
                temp[j] = myFlats[i];
                j--;
                i--;
            }

        }
        myFlats = new Flat[temp.length];

        for (int i = 0; i < temp.length; i++) {
            myFlats[i] = temp[i];
        }

    }

    public void deleteFlat(int Index) {


        Flat[] new_Flat = new Flat[myFlats.length - 1];

        myFlats[Index] = null;

        for (int i = 0, j = 0; i < new_Flat.length; i++, j++) {

            if (myFlats[i] == null) {
                j--;
                new_Flat[j] = myFlats[i];

            } else {

                new_Flat[j] = myFlats[i];

            }
        }

    }

    public double getBestSquare() {
        double square = 0;

        for (int i = 0; i < myFlats.length; i++) {
            if (square < myFlats[i].getSquare())
                square = myFlats[i].getSquare();

        }

        return square;

    }

}


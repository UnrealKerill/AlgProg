package org.example;

public class DwellingFloor implements Floor {

    private Flat[] Flats;

    public DwellingFloor(int count) {
        Flats = new Flat[count];
        for (int i = 0; i < count; i++) {
            Flats[i] = new Flat();
        }
    }

    public DwellingFloor(Flat[] flats) {
        Flats = flats;
    }

    public int getTotalFlats() {
        return Flats.length;
    }

    public double getFlatsSquare() {
        double square = 0;
        for (int i = 0; i < Flats.length; i++) {
            square = square + Flats[i].getSquare();
        }
        return square;
    }

    public int getFlatsQuantity() {
        int quantity = 0;
        for (int i = 0; i < Flats.length; i++) {
            quantity = quantity + Flats[i].getQuantity();
        }
        return quantity;
    }

    public Flat[] getFlats() {
        return Flats;
    }

    public Flat getFlat(int index) {
        return Flats[index];
    }


    @Override
    public void setFlat(int index, Space newFlat) {
        Flat NFlat = new Flat(newFlat.getQuantity(), newFlat.getSquare());
        Flats[index] = NFlat;
    }

    @Override
    public void addFlat(int index, Space newFlat) {
        Flat NFlat = new Flat(newFlat.getQuantity(), newFlat.getSquare());
        addFlat(index, NFlat);
    }


    public void addFlat(int index, Flat newFlat) {


        Flat[] temp = new Flat[Flats.length + 1];

        for (int i = 0, j = 0; i < Flats.length && j < temp.length; i++, j++) {

            if (index != j) {
                try {
                    temp[j] = Flats[i];
                } catch (Exception e) {
                    break;
                }
            } else {
                temp[j] = newFlat;
                j++;
                temp[j] = Flats[i];
                j--;
                i--;
            }
        }
        Flats = new Flat[temp.length];

        for (int i = 0; i < temp.length; i++) {
            Flats[i] = temp[i];
        }
    }

    public void deleteFlat(int Index) {


        Flat[] new_Flat = new Flat[Flats.length - 1];

        Flats[Index] = null;

        for (int i = 0, j = 0; i < new_Flat.length; i++, j++) {

            if (Flats[i] == null) {
                j--;
            } else {
                new_Flat[j] = Flats[i];
            }
        }
    }

    public double getBestSquare() {
        double square = 0;

        for (int i = 0; i < Flats.length; i++) {
            if (square < Flats[i].getSquare())
                square = Flats[i].getSquare();
        }
        return square;

    }

    public void setMyFlat(int index, Flat new_Flat) {

        Flats[index] = new_Flat;

    }

}

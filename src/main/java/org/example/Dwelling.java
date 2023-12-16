package org.example;

public class Dwelling implements Building {

    private DwellingFloor[] floor;

    public Dwelling(int countFloor, int countFlat) {

        floor = new DwellingFloor[countFloor];

        for (int i = 0; i < countFloor; i++) {

            floor[i] = new DwellingFloor(countFlat);

        }

    }

    public Dwelling(DwellingFloor[] arg) {

        floor = arg;

    }

    public int getFloorsQuantity() {

        return floor.length;
    }

    public int getFlatsQuantity() {

        int count = 0;

        for (int i = 0; i < floor.length; i++) {

            count += floor[i].getTotalFlats();

        }

        return count;

    }

    public double getFlatsSquare() {

        double square = 0;

        for (int i = 0; i < floor.length; i++) {

            square += floor[i].getFlatsSquare();

        }

        return square;

    }

    public int getRoomsQuantity() {

        int count = 0;

        for (int i = 0; i < floor.length; i++) {
//цикл по квартирам

            count += floor[i].getFlatsQuantity();

        }

        return count;

    }

    public DwellingFloor[] getFloors() {

        return floor;

    }

    public DwellingFloor getFloor(int index) {

        return floor[index];

    }

    public void setFloor(int index, Floor newFloor) {

        DwellingFloor df = new DwellingFloor(newFloor.getFlats());
        floor[index] = df;

    }

    public Flat getFlat(int index) {

        int counter = 0;

        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].getFlats().length; j++) {

                if (counter == index) {

                    return floor[i].getFlats()[j];

                }

                counter++;

            }
        }

        throw new IllegalArgumentException();

    }

    @Override
    public void setFlat(int indexInDwelling, Space newSpace) {
        Flat NFlat = new Flat(newSpace.getSquare(), newSpace.getQuantity());
        setFlat(indexInDwelling, NFlat);
    }

    @Override
    public void addFlat(int indexInDwelling, Space newSpace) {
        Flat NFlat = new Flat(newSpace.getSquare(), newSpace.getQuantity());
        addFlat(indexInDwelling, NFlat);
    }

    public void setFlat(int indexInDwelling, Flat newFlat) {

        int counter = 0;

        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].getFlats().length; j++) {

                if (counter == indexInDwelling) {
                    floor[i].setMyFlat(j, newFlat);
                    return;
                }

                counter++;

            }
        }

    }

    public void addFlat(int indexInDwelling, Flat newFlat) {

        int counter = 0;

        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].getFlats().length; j++) {

                if (counter == indexInDwelling) {

                    floor[i].addFlat(i, newFlat);
                    return;
                }

                counter++;

            }
        }

    }

    public void deleteFlat(int indexInDwelling) {

        int counter = 0;

        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].getFlats().length; j++) {

                if (counter == indexInDwelling) {

                    floor[i].deleteFlat(j);
                    return;
                }

                counter++;

            }
        }

    }

    @Override
    public double getBestSpaceBySquare() {
        return getBestSquare();
    }

    @Override
    public Flat[] getSortSpaceBySquare(int order) {
        return getSortFlatsBySquare(order);
    }

    public double getBestSquare() {

        double best = 0;

        for (int i = 0; i < floor.length; i++) {

            if (best < floor[i].getBestSquare()) {
                best = floor[i].getBestSquare();
            }

        }

        return best;

    }

    public Flat[] getSortFlatsBySquare(int order) {

        Flat[] allFlats = new Flat[getFlatsQuantity()];

        int counter = 0;

        for (int i = 0; i < floor.length; i++) {

            for (int j = 0; j < floor[i].getFlats().length; j++) {

                allFlats[counter] = floor[i].getFlats()[j];

            }

        }

        if (order < 0) {

            Flat temp;

            boolean issorted = true;

            do {

                issorted = true;

                for (int i = 1; i < allFlats.length; i++) {

                    temp = allFlats[i - 1];

                    if (temp.getSquare() > allFlats[i].getSquare()) {

                        allFlats[i - 1] = allFlats[i];

                        allFlats[i] = temp;

                        issorted = false;

                    }

                }

            } while (!issorted);

        } else {

            Flat temp;

            boolean issorted = true;

            do {

                issorted = true;

                for (int i = 1; i < allFlats.length; i++) {

                    temp = allFlats[i - 1];

                    if (temp.getSquare() < allFlats[i].getSquare()) {

                        allFlats[i - 1] = allFlats[i];

                        allFlats[i] = temp;

                        issorted = false;

                    }

                }

            } while
            (!issorted);

        }

        return allFlats;

    }

}

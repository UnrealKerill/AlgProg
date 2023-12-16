package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DwellingFloorTest {
    private DwellingFloor floor = new DwellingFloor(5);

    @Test
    void getTotalFlats() {
        int result = floor.getTotalFlats();
        int prov = 5;

        assertEquals(result, prov);
    }

    @Test
    void getFlatsSquare() {
        double sq = floor.getFlatsSquare();
        assertEquals(sq, 250.0);
    }

    @Test
    void getFlatsQuantity() {
        int flatsquantity = floor.getFlatsQuantity();
        assertEquals(flatsquantity, 10);
    }

    @Test
    void getFlats() {
        Flat[] myFlats = new Flat[5];

        myFlats = new Flat[5];
        for (int i = 0; i < 5; i++) {
            myFlats[i] = new Flat();

        }
        assertEquals(floor.getFlats().length, myFlats.length);

    }

    @Test
    void getFlat() {

        Flat flat = new Flat();

        assertEquals(floor.getFlat(1).getSquare(), flat.getSquare());
        assertEquals(floor.getFlat(1).getQuantity(), flat.getQuantity());

    }

    @Test
    void addFlat() {
        floor.addFlat(1, new Flat(500));
        int count = floor.getFlats().length;
        assertEquals(6, count);

    }

    @Test
    void deleteFlat() {
        floor.deleteFlat(1);
        int count = floor.getFlats().length;
        assertEquals(5, count);
    }

    @Test
    void getBestSquare() {
        floor.addFlat(1, new Flat(500));
        double square = floor.getBestSquare();
        assertEquals(500, square);

    }

    @Test
    void setMyFlat() {

        floor.setMyFlat(1, new Flat(250));

        assertEquals(floor.getFlat(1).getSquare(), 250);
        assertEquals(floor.getFlat(1).getQuantity(), 2);
    }
}
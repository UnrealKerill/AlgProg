package org.example;

public interface Building {
    int getFloorsQuantity();

    int getFlatsQuantity();

    double getFlatsSquare();

    int getRoomsQuantity();

    DwellingFloor[] getFloors();

    DwellingFloor getFloor(int index);

    void setFloor(int index, Floor newFloor);

    Flat getFlat(int index);

    void setFlat(int index, Space newSpace);

    void addFlat(int index, Space newSpace);

    void deleteFlat(int index);

    double getBestSpaceBySquare();

    Flat[] getSortSpaceBySquare(int order);

}

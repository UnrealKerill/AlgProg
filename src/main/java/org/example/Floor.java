package org.example;

public interface Floor {
    int getTotalFlats();

    double getFlatsSquare();

    Flat[] getFlats();

    Flat getFlat(int index);

    void setFlat(int index, Space newFlat);

    void addFlat(int index, Space newFlat);

    void deleteFlat(int index);

    double getBestSquare();
}

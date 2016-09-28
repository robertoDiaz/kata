package org.roberto.diaz.drone.model;

/**
 * @author Roberto Díaz
 */
public class Property {

    public int getYCoord() {
        return _yCoord;
    }

    public int getXCoord() {
        return _xCoord;
    }

    private final int _yCoord;
    private final int _xCoord;

    public Property(int xCoord, int yCoord) {
        _xCoord = xCoord;
        _yCoord = yCoord;
    }

    @Override
    public String toString() {
        return "Property " + _xCoord + ", " + _yCoord;
    }
}

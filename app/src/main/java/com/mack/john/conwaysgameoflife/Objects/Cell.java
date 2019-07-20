package com.mack.john.conwaysgameoflife.Objects;

public class Cell {



    // Class properties
    int xPosition;
    int yPosition;

    boolean isAlive;



    // Constructor
    public Cell(int xPosition, int yPosition, boolean isAlive) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isAlive = isAlive;
    }



    // Getters / Setters
    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}

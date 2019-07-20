package com.mack.john.conwaysgameoflife.Objects;

import java.util.Random;

public class GameSpace {



    // Class properties
    int boardWidth;
    int boardHeight;

    Cell[][] gameBoard;



    // Constructor
    public GameSpace(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.gameBoard = new Cell[boardWidth][boardHeight];
    }



    // Custom methods
    // Custom method to generate board with randomly alive cells
    private void generateBoard() {
        // Track randomly generated boolean values
        Random randomIsAlive = new Random();

        // Loop through each x positio on the board
        for(int xPosition = 0; xPosition < boardWidth; xPosition ++) {

            // Loop through each y position on the board
            for(int yPosition = 0; yPosition < boardHeight; yPosition ++) {

                // Generate new randomly alive/dead cell at current x,y position
                gameBoard[xPosition][yPosition] = new Cell(xPosition, yPosition, randomIsAlive.nextBoolean());
            }
        }
    }

    // Custom method to count number of living neighbors for current cell
    public int countAliveNeighbors(Cell cell) {
        int aliveNeighborCount = 0;

        // Check to see if cell to the left is alive ONLY if a cell exists to the left
        if(cell.getxPosition() > 0 && gameBoard[cell.getxPosition() - 1][cell.getyPosition()].isAlive()) {
            aliveNeighborCount ++;
        }

        // Check to see if cell to the right is alive ONLY if a cell exists to the right
        if(cell.getxPosition() != boardWidth && gameBoard[cell.getxPosition() + 1][cell.getyPosition()].isAlive()) {
            aliveNeighborCount ++;
        }

        // Check to see if cell above is alive ONLY if a cell exists above
        if(cell.getyPosition() > 0 && gameBoard[cell.getxPosition()][cell.getyPosition() - 1].isAlive()) {
            aliveNeighborCount ++;
        }

        // Check to see if cell below is alive ONLY if a cell exists below
        if(cell.getyPosition() != boardHeight && gameBoard[cell.getxPosition()][cell.getyPosition() + 1].isAlive()) {
            aliveNeighborCount ++;
        }

        // Check to see if cell above and to the left is alive ONLY if a cell exists at the position in question
        if(cell.getxPosition() > 0 && cell.getyPosition() > 0 && gameBoard[cell.getxPosition() - 1][cell.getyPosition() - 1].isAlive()) {
            aliveNeighborCount ++;
        }

        // Check to see if cell below and to the left is alive ONLY if a cell exists at the position in question
        if(cell.getxPosition() > 0 && cell.getyPosition() != boardHeight &&
                gameBoard[cell.getxPosition() - 1][cell.getyPosition() + 1].isAlive()) {

            aliveNeighborCount ++;
        }

        // Check to see if cell above and to the right is alive ONLY if a cell exists at the position in question
        if(cell.getxPosition() != boardWidth && cell.getyPosition() > 0 &&
                gameBoard[cell.getxPosition() + 1][cell.getyPosition() - 1].isAlive()) {

            aliveNeighborCount ++;
        }

        // Check to see if cell below and to the right is alive ONLY if a cell exists at the position in question
        if(cell.getxPosition() != boardWidth && cell.getyPosition() != boardHeight &&
                gameBoard[cell.getxPosition() + 1][cell.getyPosition() + 1].isAlive()) {

            aliveNeighborCount ++;
        }

        // Return number of alive neighbors
        return aliveNeighborCount;
    }
}

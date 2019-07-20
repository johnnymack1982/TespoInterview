package com.mack.john.conwaysgameoflife.Objects;

import android.widget.GridView;

import java.util.ArrayList;
import java.util.Random;

public class GameSpace {



    // Class properties
    int boardWidth;
    int boardHeight;

    Cell[][] gameBoard;

    GridView visualBoard;



    // Constructor
    public GameSpace(int boardWidth, int boardHeight, GridView visualBoard) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.gameBoard = new Cell[boardWidth][boardHeight];
        this.visualBoard = visualBoard;

        generateBoard();
    }



    // Custom methods
    // Custom method to generate board with randomly alive cells
    private void generateBoard() {

        // Track randomly generated boolean values
        Random randomIsAlive = new Random();

        // Loop through each x position on the board
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



        // NOTE: This could also potentially be accomplished by looping through the surrounding x, y positions for the current cell
        // Time permitting, I will experiment with this alternate solution
    }

    public void generateNextTurn() {
        ArrayList<Cell> livingCells = new ArrayList<>();
        ArrayList<Cell> deadCells = new ArrayList<>();

        // Loop through x positions on the board
        for(int xPosition = 0; xPosition < boardWidth; xPosition ++) {

            // Loop through y positions on the board
            for(int yPosition = 0; yPosition < boardHeight; yPosition ++) {

                // Reference the cell at the current x,y positio
                Cell currentCell = gameBoard[xPosition][yPosition];

                // Call custom method to count number of living neighbors for current cell
                int livingNeighbors = countAliveNeighbors(currentCell);

                // Any live cell with fewer than two live neighbors dies, as if caused by underpopulation
                if(currentCell.isAlive() && livingNeighbors < 2) {
                    deadCells.add(currentCell);
                }

                // Any live cell with two or three live neighbors lives on to the next generation
                else if(currentCell.isAlive() && (livingNeighbors == 2 || livingNeighbors == 3)) {
                    livingCells.add(currentCell);
                }

                // Any live cell with more than three live neighbors dies, as if by overpopulation
                else if(currentCell.isAlive() && livingNeighbors > 3) {
                    deadCells.add(currentCell);
                }

                // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction
                else if(!currentCell.isAlive() && livingNeighbors == 3) {
                    livingCells.add(currentCell);
                }
            }
        }

        // Call custom method to toggle cells according to game rules
        toggleCells(livingCells, deadCells);
    }

    // Custom method to toggle cells according to game rules
    private void toggleCells(ArrayList<Cell> livingCells, ArrayList<Cell> deadCells) {
        // Toggle living cells
        for(Cell currentCell: livingCells) {
            currentCell.setAlive(true);
        }

        // Toggle dead cells
        for(Cell currentCell: deadCells) {
            currentCell.setAlive(false);
        }
    }
}

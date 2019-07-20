package com.mack.john.conwaysgameoflife.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;

import com.mack.john.conwaysgameoflife.Objects.Cell;
import com.mack.john.conwaysgameoflife.R;

import java.util.ArrayList;

public class CellAdapter extends BaseAdapter {



    // Class properties
    Context context;
    Cell[][] gameBoard;
    ArrayList<Cell> cells;



    // Constructor
    public CellAdapter(Context context, Cell[][] gameBoard, int boardWidth, int boardHeight) {
        this.context = context;
        this.gameBoard = gameBoard;
        this.cells = new ArrayList<>();

        // Loop through each cell on board and add to an unsorted list
        // While this list is technically unsorted, cells should be added in the proper order to display correctly
        // This is ONLY because the display and game boards have both been set to 50 cells wide by 50 cells high
        // If scalability became a concern, it would be necessary to visually populate using a different method
        for(int xPosition = 0; xPosition < boardWidth; xPosition ++) {
            for(int yPosition = 0; yPosition < boardHeight; yPosition ++) {
                cells.add(gameBoard[xPosition][yPosition]);
            }
        }
    }



    // System generated methods
    @Override
    public int getCount() {
        return cells.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return cells.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Reference current cell
        Cell cell = cells.get(position);

        // Inflate cell view
        if(convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.cell_board, null);
        }

        // Reference cell 'image'
        FrameLayout cellImage = convertView.findViewById(R.id.cell);

        // If cell is alive, turn it green
        if(cell.isAlive()) {
            cellImage.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }

        // If cell is not alive, turn it red
        else {
            cellImage.setBackgroundColor(convertView.getResources().getColor(R.color.colorAccent));
        }

        return convertView;
    }
}

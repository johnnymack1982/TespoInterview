package com.mack.john.conwaysgameoflife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.mack.john.conwaysgameoflife.Objects.GameSpace;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    // Class properties
    GameSpace gameSpace;



    // System generated methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView visualBoard = findViewById(R.id.gameBoard);

        // Generate new game space
        gameSpace = new GameSpace(50, 50, visualBoard, this);

        Button nextTurnButton = findViewById(R.id.button_next_turn);
        nextTurnButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_next_turn) {
            gameSpace.generateNextTurn();
        }
    }
}

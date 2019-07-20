package com.mack.john.conwaysgameoflife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.mack.john.conwaysgameoflife.Objects.GameSpace;

public class MainActivity extends AppCompatActivity {



    // Class properties
    GameSpace gameSpace;



    // System generated methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView visualBoard = findViewById(R.id.gameBoard);

        // Generate new game space
        gameSpace = new GameSpace(50, 50, visualBoard);
    }



    // Custom methods
}

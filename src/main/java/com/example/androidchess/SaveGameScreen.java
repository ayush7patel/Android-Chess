package com.example.androidchess;

import GameRecording.GameSave;
import GameRecording.LoadSaveData;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class SaveGameScreen extends AppCompatActivity
{
    private Button save;
    private Button cancel;
    private EditText name;
    private ArrayList<String> listOfGames;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_game_screen);
        listOfGames = new ArrayList<>();
        save = (Button) findViewById(R.id.saveButton);
        cancel = (Button) findViewById(R.id.cancelButton);
        name = (EditText) findViewById(R.id.gameName);
        Intent intent = getIntent();
        listOfGames = intent.getStringArrayListExtra("moves");
        String winnerOfGame = intent.getStringExtra("winner");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString() == null || name.getText().toString().length() == 0)
                {
                    Toast.makeText(SaveGameScreen.this, "The name field is empty", Toast.LENGTH_LONG).show();
                    return;
                }
                GameSave data = new GameSave(name.getText().toString(), winnerOfGame, listOfGames);
                if(LoadSaveData.listOfSavedGames == null || LoadSaveData.listOfSavedGames.size() == 0)
                {
                    LoadSaveData.listOfSavedGames = new ArrayList<GameSave>();
                }

                LoadSaveData.listOfSavedGames.add(data);
                try
                {
                    LoadSaveData.saveGameData();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                Intent intent = new Intent(SaveGameScreen.this, HomePage.class);
                startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaveGameScreen.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}

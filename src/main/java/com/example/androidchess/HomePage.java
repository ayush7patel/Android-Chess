package com.example.androidchess;

import GameRecording.GameSave;
import GameRecording.LoadSaveData;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomePage extends AppCompatActivity
{
    private Button gameButton;
    private Button dateSort;
    private Button nameSort;
    private ListView gamesListView;
    public static List<GameSave> listOfGames = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        gameButton = (Button) findViewById(R.id.newGame);
        dateSort = (Button) findViewById(R.id.dateSort);
        nameSort = (Button) findViewById(R.id.nameSort);
        gamesListView = (ListView) findViewById(R.id.recordedGamesList);
        LoadSaveData.context = getApplicationContext();
        LoadSaveData.loadGameData();
        if(LoadSaveData.listOfSavedGames != null)
        {
            String[] matches = new String[LoadSaveData.listOfSavedGames.size()];
            for(int i = 0; i < LoadSaveData.listOfSavedGames.size(); i++)
            {
                matches[i] = LoadSaveData.listOfSavedGames.get(i).toString();
            }

            ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, matches);
            gamesListView.setAdapter(aa);
        }
        gamesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GameSave data = LoadSaveData.listOfSavedGames.get(position);
                Log.d("Print", data.getMovesOfGame().toString());
                Intent intent = new Intent(HomePage.this, GamePlaybackActivity.class);
                intent.putExtra("moves", data.getMovesOfGame());
                startActivity(intent);
            }
        });
        nameSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LoadSaveData.listOfSavedGames != null)
                {
                    Collections.sort(LoadSaveData.listOfSavedGames, new dateSort());
                    String[] match1 = new String[LoadSaveData.listOfSavedGames.size()];
                    for(int i = 0; i < LoadSaveData.listOfSavedGames.size(); i++)
                    {
                        match1[i] = LoadSaveData.listOfSavedGames.get(i).toString();
                    }

                    ArrayAdapter<String> aa = new ArrayAdapter<String>(HomePage.this, android.R.layout.simple_list_item_1, match1);
                    gamesListView.setAdapter(aa);
                }
                else
                {
                    Toast.makeText(HomePage.this, "There are no matches to sort", Toast.LENGTH_LONG).show();
                }
            }
        });
        dateSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LoadSaveData.listOfSavedGames != null)
                {
                    Collections.sort(LoadSaveData.listOfSavedGames, new dateSort());
                    String[] match1 = new String[LoadSaveData.listOfSavedGames.size()];
                    for(int i = 0; i < LoadSaveData.listOfSavedGames.size(); i++)
                    {
                        match1[i] = LoadSaveData.listOfSavedGames.get(i).toString();
                    }

                    ArrayAdapter<String> aa = new ArrayAdapter<String>(HomePage.this, android.R.layout.simple_list_item_1, match1);
                    gamesListView.setAdapter(aa);
                }
                else
                {
                    Toast.makeText(HomePage.this, "There are no matches to sort", Toast.LENGTH_LONG).show();
                }
            }
        });
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    class titleSort implements Comparator<GameSave>
    {
        public int compare(GameSave o1, GameSave o2)
        {
            if(o1 != null && o2 != null)
            {
                return o1.nameOfGame.compareToIgnoreCase(o2.nameOfGame);
            }

            return 0;
        }
    }
    class dateSort implements Comparator<GameSave>
    {
        public int compare(GameSave o1, GameSave o2)
        {
            if(o1 != null && o2 != null)
            {
                return o2.dateOfGame.compareTo(o1.dateOfGame);
            }

            return 0;
        }
    }
}

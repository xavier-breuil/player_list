package com.footbar.player_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private Controller controller;
    private ArrayList<Spinner> spinner_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.controller = new Controller(this);

        //add the spinners to the spinner list
        this.spinner_list = new ArrayList<Spinner>();
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_10));
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_9));
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_8));
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_7));
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_6));
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_5));
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_4));
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_3));
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_2));
        this.spinner_list.add(0,(Spinner)findViewById(R.id.meteor_spinner_1));

        // listen the spinner for when the user wants to download the player names from the internet
        // to do that he just has to allow internet access and swipe his finger down on the screen
        for (int spinner_number = 0; spinner_number<this.spinner_list.size(); spinner_number++){
            this.spinner_list.get(spinner_number).setOnTouchListener(this);
        }
    }

    public void display_player_names(){
        ArrayList<String> player_names = this.controller.get_player_names();

        // fill the spinners with the list of the players
        for (int i = 0; i < 10; i++) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_center_text_layout, player_names);
            adapter.setDropDownViewResource(R.layout.spinner_center_text_layout);
            this.spinner_list.get(i).setAdapter(adapter);
        }
    }

    public void ask_for_internet_connection() {
        // ask the user for an internet connection
        Toast.makeText(this, getResources().getString(R.string.no_internet_access), Toast.LENGTH_LONG).show();
    }

    public void update_player_names(){
        // download the name of the players from the internet
        this.controller.update_player_names();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // if the player names are not downloaded and the user ask for it (finger swipping down on the screen)
        if (event.getAction()== MotionEvent.ACTION_DOWN && !Model.player_names_downloaded) {
            this.update_player_names();
            this.controller.update_connection_status();
                if (Model.connection_ok) {
                Toast.makeText(this, getResources().getString(R.string.player_list_downloading), Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, getResources().getString(R.string.no_internet_access), Toast.LENGTH_LONG).show();
            }
        }
        // just because of the signature of the parent method
        return false;
    }

}


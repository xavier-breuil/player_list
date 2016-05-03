package com.footbar.player_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
}


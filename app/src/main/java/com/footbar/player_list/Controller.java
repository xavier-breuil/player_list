package com.footbar.player_list;

import java.util.ArrayList;

/**
 * Created by breuilxavier on 03/05/16.
 */
public class Controller {

    private MainActivity main_activity;
    private Model model;

    public Controller(MainActivity main_activity){
        this.main_activity = main_activity;
        this.model = new Model(this);
    }

    public ArrayList<String> get_player_names(){
        return model.get_player_names();
    }
}

package com.footbar.player_list;

import java.util.ArrayList;

public class Controller {

    private MainActivity main_activity;
    private Model model;

    public Controller(MainActivity main_activity){
        this.main_activity = main_activity;
        this.model         = new Model(this);
    }

    public ArrayList<String> get_player_names(){
        return model.get_player_names();
    }

    public void display_player_names(){
        this.main_activity.display_player_names();
    }

    public void ask_for_internet_connection(){
        this.main_activity.ask_for_internet_connection();
    }

    public MainActivity get_main_activity(){
        return this.main_activity;
    }

    public void update_player_names(){
        this.model.download_player_names();
    }

    public void update_connection_status(){
        this.model.update_connection_status();
    }
}

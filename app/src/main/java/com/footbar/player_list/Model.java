package com.footbar.player_list;

import java.util.ArrayList;

/**
 * Created by breuilxavier on 03/05/16.
 */
public class Model {

    private Controller controller;
    private ArrayList<String> player_names;

    public Model(Controller controller){
        this.controller = controller;
        this.player_names = new ArrayList<>();

        // add hard coded names
        this.player_names.add(0,"zizou");
        this.player_names.add(0,"petit");
        this.player_names.add(0,"henry");
    }

    public ArrayList<String> get_player_names(){
        return this.player_names;
    }
}

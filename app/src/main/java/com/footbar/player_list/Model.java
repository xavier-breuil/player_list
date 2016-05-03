package com.footbar.player_list;

import org.json.JSONArray;
import java.util.Collections;
import java.util.ArrayList;


public class Model implements AsyncHttp.AsyncHttpObserver {

    private Controller controller;
    private ArrayList<String> player_names;
    private String online_data_url;

    public Model(Controller controller){
        this.controller      = controller;
        this.player_names    = new ArrayList<>();
        this.online_data_url = "https://playerbackend.footbar.com/playerslist/";

        // get the data from the internet page
        AsyncHttp asyncHttp = new AsyncHttp(this);
        asyncHttp.execute(this.get_online_data_url());
    }

    public String get_online_data_url(){
        // return the data from the internet page as a string
        return this.online_data_url;
    }

    public ArrayList<String> get_player_names(){
        // return an array with the player names
        return this.player_names;
    }

    public void onPostExecute(String out_from_url){
        // method executed when the internet data are returned
        // asks to process the data returned from the web page
        this.process_player_names(out_from_url);
    }

    public void process_player_names(String out_from_url){

        // create the list of the player names
        ArrayList<String> name_array_list = new ArrayList<String>();
        try {
            JSONArray jsonArray = new JSONArray (out_from_url);
            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i=0;i<len;i++){
                    // get the name of the player among the data that concerns him
                    String string_list = jsonArray.get(i).toString();
                    int beg_index      = string_list.indexOf("\"name\":");
                    String first_name  = string_list.substring(beg_index+8);
                    int end_index      = first_name.indexOf("\"");
                    String name        = first_name.substring(0,end_index);
                    name_array_list.add(name);
                }
            }
        } catch (Exception e) {
            System.out.println("error while processing JSon");
        }

        // sort the data by alphabetical order
        Collections.sort(name_array_list, String.CASE_INSENSITIVE_ORDER);
        name_array_list.add(0,"search player");

        this.player_names = name_array_list;
        this.controller.display_player_names();
    }

}

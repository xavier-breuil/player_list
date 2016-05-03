package com.footbar.player_list;

import android.os.AsyncTask;

public class AsyncHttp extends AsyncTask<String, Integer, String> {
    // Class to create a thread that will get the data from the internet page
    private HttpClient httpClient = new HttpClient(); // HttpClient will communicate with the internet page
    private AsyncHttpObserver obs; // the observer will treat the result once the internet page sent them

    public AsyncHttp(AsyncHttpObserver obs) {
        this.obs = obs;
    }

    @Override
    protected String doInBackground(String... arg0) {
        // ask the content of the internet page
        return httpClient.doHttpGET(arg0[0]);
    }

    protected void onPostExecute(String result) {
        // the observer deals with the data from the page
        obs.onPostExecute(result);
    }

    public interface AsyncHttpObserver {
        //Interface to implement to deal with the result of the page
        public void onPostExecute(String result);
    }

}


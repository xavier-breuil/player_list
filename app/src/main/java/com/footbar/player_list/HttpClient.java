package com.footbar.player_list;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    private int readTimeOut = 10000; // Maximum allowed time to read the answer (in ms)
    private int connectTimeOut = 15000; //Maximum allowed time to connect (in ms)

    public HttpClient() {
    }

    public String doHttpGET(String urlAsString) {
        // return the server answer as a string
        HttpURLConnection con = null;
        InputStream is        = null;
        StringBuffer buffer   = new StringBuffer();

        try {
            // create the connection using the parameters
            con = (HttpURLConnection) (new URL(urlAsString)).openConnection();
            con.setRequestMethod("GET");
            con.setReadTimeout(readTimeOut);
            con.setConnectTimeout(connectTimeOut);
            con.setDoInput(true);
            con.connect();

            // read the response
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line + "\r\n");
            }
            is.close();
            con.disconnect();
        } catch (Exception e){
            System.out.println("error while getting data from the web page");
        } finally {
            try {
                is.close();
                con.disconnect();
            } catch (Exception e) {
                System.out.println("error while disconnecting");
            }
        }
        return buffer.toString();// return the response as a string
    }

}

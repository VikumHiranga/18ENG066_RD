package com.example.rd;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpCall extends AsyncTask<String, String, String> {

        View view;
@Override
protected String doInBackground(String... urls) {

        String responseString = null;
        try {
        URL url = new URL(urls[0]);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if(conn.getResponseCode() == HttpsURLConnection.HTTP_OK){
        // Do normal input or output stream reading
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        conn.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null)
                        System.out.println(inputLine);

                in.close();
                System.out.println("Success");
        }
        else {
                System.out.println("FAILED");
        // response = "FAILED"; // See documentation for more info on response handling
        }
        } catch (Exception e) {
                System.out.println(e);
        }
        System.out.println("res");
        return responseString;
        }

@Override
protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //Do anything with response..
        }
}

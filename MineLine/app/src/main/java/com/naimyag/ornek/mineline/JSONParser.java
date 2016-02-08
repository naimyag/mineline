package com.naimyag.ornek.mineline;

/**
 * @author zeeshan0026
 */

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONParser {

    private InputStream is = null;

    // constructor
    public JSONParser() {
    }

    public String getJSONFromUrl(String url) {
        String json = null;
        try {
            URL urlnew = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlnew.openConnection();
            is = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        } finally {
            try {
                is.close();
            } catch (IOException ignored) {
            }
        }

        return json;
    }
}

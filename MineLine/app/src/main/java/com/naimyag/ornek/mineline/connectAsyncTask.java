package com.naimyag.ornek.mineline;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Naim on 5.02.2016.
 */
public class connectAsyncTask extends AsyncTask<Void, Void, String>
{
    Context context;
    private ProgressDialog progressDialog;
    String url;
    boolean steps;

    connectAsyncTask(String urlPass, boolean withSteps) {
        url = urlPass;
        steps = withSteps;

    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Fetching route, Please wait...");
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        JSONParser jParser = new JSONParser();
        return jParser.getJSONFromUrl(url);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        progressDialog.hide();
        if (result != null) {
            //drawPath(result, steps);
        }
    }
}

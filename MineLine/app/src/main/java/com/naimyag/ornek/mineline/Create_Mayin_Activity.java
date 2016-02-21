package com.naimyag.ornek.mineline;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by Naim on 12.02.2016.
 */
public class Create_Mayin_Activity extends Activity {

    EditText txt_mesaj;

    private void init(){
        txt_mesaj= (EditText) findViewById(R.id.txt_mesaj);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mayin);
        init();
    }
}

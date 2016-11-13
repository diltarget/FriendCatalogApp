package com.example.android.friendcatalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        final TextView logRegister = (TextView) findViewById(R.id.logRegister);

        logRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerIntent = new Intent(Intro.this, RegisterActivity.class);
                Intro.this.startActivity(registerIntent);
            }
        });
    }

    public void HobbiesCollect (View view){


    }
}
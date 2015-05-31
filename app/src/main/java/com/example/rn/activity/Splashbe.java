package com.example.rn.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.rn.R;
import com.example.rn.activity.Task.TaskFinishedListener;

/**
 * Created by andrie on 19/05/15.
 */
public class Splashbe extends Activity implements TaskFinishedListener {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //menampilkan backgroud spalshbe
        setContentView(R.layout.splashbe);

        //mencari progress bar
        ProgressBar progressBar = (ProgressBar)
                findViewById(R.id.activity_splash_progress_bar);

        new Task(progressBar, this).execute("www.google.co.uk");
    }

    @Override
    public void onTaskFinished(){
        completeSplash();
    }

    private void completeSplash(){
        startApp();
        finish();
    }

    private void startApp(){
        Intent intent = new Intent(Splashbe.this, MainActivity.class);
        startActivity(intent);
    }
}

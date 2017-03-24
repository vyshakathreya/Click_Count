package com.example.vyshak.click_count;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView countOutput;
    TextView backOutput;
    int count = 0;
    int background = 0;
    private static final String TAG = "Tracing...";

    //setting the content view through onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickcount);
    try{
        if(savedInstanceState!=null){
            count=savedInstanceState.getInt("countOutput");
            background=savedInstanceState.getInt("backOutput");
            background=background+1;
        }
    }catch(NullPointerException e){
        background=background+1;
    }
        countOutput = (TextView) this.findViewById(R.id.countOutput);
        backOutput = (TextView) this.findViewById(R.id.backOutput);
        backOutput.setText(String.valueOf(background));
        Log.i(TAG,"on create");
    }

    //method to keep track of number of button clicks
    public void increase(View button) {
        Log.i("rew", "increasing");
        count++;
        countOutput.setText(String.valueOf(count));
    }

    //setting the value of the count and the background count upon orientation change.
    @Override
    protected void onStart() {
        super.onStart();
        countOutput.setText(String.valueOf(count));
        backOutput.setText(String.valueOf(background));
        Log.i(TAG,"onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
        backOutput.setText(String.valueOf(background));
    }

    //saving the instance for new orientation
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countOutput",count);
        outState.putInt("backOutput",background);
        Log.i(TAG,"Saving"+background);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count=savedInstanceState.getInt("countOutput");
        background=savedInstanceState.getInt("backOutput");
        Log.i(TAG,"Restoring");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Destroyed");
    }

    //incrementing the count when app goes to the background
    @Override
    protected void onStop() {
        super.onStop();
        background+=1;
        Log.i(TAG,"onStop"+background);
    }
}
package com.example.mp3_teamscore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView gameCount;
    private TextView otherCount;
    private int homeCounter = 0;
    private int awayCounter = 0;
    private static final String TAG = "MainActivity";
    protected static final String END_RESULT = "End Result";
    protected static final String WINNING_TEAM = "Who Won";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameCount = (TextView) findViewById(R.id.show_homecount);
        otherCount = (TextView) findViewById(R.id.show_awayCount);


        gameCount.setText(""+ homeCounter);
        otherCount.setText(""+ awayCounter);
        Log.d(TAG, "end of onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "inside onSaveInstanceState");
        outState.putInt("Home Score", homeCounter);
        outState.putInt("Away Score", awayCounter);

        Log.d(TAG, "end of onSaveInstanceState myCounter ="+ homeCounter);
        Log.d(TAG, "end of onSaveInstanceState theirCounter ="+ awayCounter);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        homeCounter = savedInstanceState.getInt("myCount", homeCounter);
        awayCounter = savedInstanceState.getInt("theirCount", awayCounter);
        Log.d(TAG, "end of onRestoreInstanceState");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "inside of onStart");

        Log.d(TAG, "end of onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "inside of onResume");
        gameCount.setText(""+ homeCounter);
        otherCount.setText(""+ awayCounter);
        Log.d(TAG, "end of onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "inside of onRestart");

        Log.d(TAG, "end of onRestart");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "inside of onPause");

        Log.d(TAG, "end of onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "inside of onStop");

        Log.d(TAG, "end of onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "inside of onDestroy");

        Log.d(TAG, "end of onDestroy");
    }

    public void countUp(android.view.View view) {
        homeCounter++;
        gameCount.setText(""+ homeCounter);
        nextActivity();
    }

    public void eCountUp(android.view.View view) {
        awayCounter++;
        otherCount.setText(""+ awayCounter);
        nextActivity();
    }

    public void nextActivity() {
        Intent intent = new Intent(this, WinnerActivity.class);
        int result;
        if(homeCounter == 5){
            result = homeCounter - awayCounter;
            intent.putExtra(END_RESULT, result);
            intent.putExtra(WINNING_TEAM, "Home team won By:");
            startActivity(intent);
        }
        else if(awayCounter == 5) {
            result = awayCounter - homeCounter;
            intent.putExtra(END_RESULT, result);
            intent.putExtra(WINNING_TEAM, "Away team won By:");
            startActivity(intent);
        }
    }

}
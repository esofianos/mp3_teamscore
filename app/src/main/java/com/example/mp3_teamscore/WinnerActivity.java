package com.example.mp3_teamscore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.net.Uri;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;


public class WinnerActivity extends AppCompatActivity{
    private TextView tv_display;
    private static final String TAG = "SecondActivity";
    private String winningTeam;
    private String strScoreCount;
    private String result;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.xml.second_activity);
        Log.d(TAG, "inside onCreate");

        tv_display = (TextView)findViewById(R.id.tv_display2);

        Intent intent = getIntent();
        strScoreCount = intent.getExtras().get(MainActivity.END_RESULT).toString();
        winningTeam = intent.getExtras().get(MainActivity.WINNING_TEAM).toString();
        result = winningTeam + " " + strScoreCount;
        tv_display.setText(winningTeam);
        tv_display.append(" " + strScoreCount);


        Log.d(TAG, "end of onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "inside onSaveInstanceState");
        outState.putString("result", winningTeam);
        outState.putString("wonBy", strScoreCount);
        Log.d(TAG, "end of onSaveInstanceState message = "+ winningTeam);
        Log.d(TAG, "end of onSaveInstanceState score = " + strScoreCount);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        winningTeam = savedInstanceState.getString("result", winningTeam);
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
        tv_display.setText(result);
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

    public void makeCall(android.view.View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Intent chooser = Intent.createChooser(intent, "Call with");
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(chooser);
        }

    }

    public void sendMessage(View view){
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, result);
        intent.setType("text/plain");
        Intent chooser = Intent.createChooser(intent, "Share with");
        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(chooser);
        }
    }

    public void findLocations(View view){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Baseball");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        Intent chooser = Intent.createChooser(mapIntent, "Find Location With");
        if(mapIntent.resolveActivity(getPackageManager())!= null) {
            startActivity(chooser);
        }
    }
}
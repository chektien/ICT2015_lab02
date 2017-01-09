package com.boliao.ict2015_lab02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * see https://developer.android.com/guide/components/activities/activity-lifecycle.html for
 * lifecycle diagram
 */
public class MainActivity extends AppCompatActivity {
    public final static String TAG = "MainActivity";
    public final static String EXTRA_MESSAGE = "com.boliao.ictlab.EXTRA";

    // debug counters
    private int onCreateCount = 0;
    private int onRestartCount = 0;
    private int onStartCount = 0;
    private int onResumeCount = 0;
    private int onPauseCount = 0;
    private int onDestroyCount = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Entered onCreate() " + ++onCreateCount + " times.");
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "Entered onStart() " + ++onStartCount + " times.");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.i(TAG, "Entered onRestart() " + ++onRestartCount + " times.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "Entered onResume() " + ++onResumeCount + " times.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "Entered onPause() " + ++onPauseCount + " times.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Entered onDestroy() " + ++onDestroyCount + " times.");
    }
}

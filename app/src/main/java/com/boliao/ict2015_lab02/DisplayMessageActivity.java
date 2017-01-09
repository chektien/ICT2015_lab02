package com.boliao.ict2015_lab02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String TAG = "DisplayMessageActivity";
    private int onCreateCount = 0;
    private int onRestartCount = 0;
    private int onStartCount = 0;
    private int onResumeCount = 0;
    private int onPauseCount = 0;
    private int onDestroyCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Entered onCreate() " + ++onCreateCount + " times.");

        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(30);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);

        // close and go back to main activity
        //final Intent intent2 = new Intent(this, MainActivity.class);
        Button buttonClose = (Button)  findViewById(R.id.button_close);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

    }
}

package com.example.edu.mythreadmainui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String TAG = "ErrerThreadActivityTag";
        long endTime = System.currentTimeMillis()+5000;
        Log.i(TAG,"Thread running!");
        TextView threadValue = findViewById(R.id.textView);
        while (System.currentTimeMillis()<endTime){
            synchronized (this){
                Log.i(TAG,"Thread running!");
                threadValue.setText(String.valueOf(System.currentTimeMillis()));
            }
        }
    }
}

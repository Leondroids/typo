package com.leondroid.typo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Choose Font");

        findViewById(R.id.tv__alex_brush).setOnClickListener(this);
        findViewById(R.id.tv__roboto).setOnClickListener(this);
        findViewById(R.id.tv__pacifico).setOnClickListener(this);
        findViewById(R.id.tv__raleway).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.tv__alex_brush:
                intent = new Intent(this, AlexBrushActivity.class);
                break;
            case R.id.tv__pacifico:
                intent = new Intent(this, PacificoActivity.class);
                break;
            case R.id.tv__raleway:
                intent = new Intent(this, RalewayActivity.class);
                break;
            case R.id.tv__roboto:
            default:
                intent = new Intent(this, RobotoActivity.class);
                break;
        }

        startActivity(intent);
    }
}

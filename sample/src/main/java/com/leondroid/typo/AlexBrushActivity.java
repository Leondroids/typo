package com.leondroid.typo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.leondroid.lib.com.leondroid.typo.Typo;
import com.leondroid.lib.com.leondroid.typo.mapper.AlexBrushMapper;

public class AlexBrushActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alex_brush);
        setTitle("Alex Brush Font Example");
    }

}

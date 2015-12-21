package com.leondroid.typo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leondroid.lib.com.leondroid.typo.Typo;
import com.leondroid.lib.com.leondroid.typo.mapper.RobotoMapper;

public class RobotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roboto);
        setTitle("Roboto Font Example");
    }
}

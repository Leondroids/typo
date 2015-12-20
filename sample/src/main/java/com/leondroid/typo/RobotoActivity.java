package com.leondroid.typo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leondroid.lib.com.leondroid.typo.Typo;
import com.leondroid.typo.fontmapper.roboto.RobotoMapper;

public class RobotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Typo.init(this).withFontMapper(new RobotoMapper());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

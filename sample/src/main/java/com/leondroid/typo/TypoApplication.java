package com.leondroid.typo;

import android.app.Application;

import com.leondroid.lib.com.leondroid.typo.Typo;
import com.leondroid.lib.com.leondroid.typo.mapper.AlexBrushMapper;
import com.leondroid.lib.com.leondroid.typo.mapper.PacificoMapper;
import com.leondroid.lib.com.leondroid.typo.mapper.RalewayMapper;
import com.leondroid.lib.com.leondroid.typo.mapper.RobotoMapper;

public class TypoApplication extends Application {

    private static final String FONT_PATH = "fonts";

    @Override
    public void onCreate() {
        super.onCreate();
        createTypo();
    }

    private void createTypo() {
        Typo.init(this)
                .withFontMapper(new RalewayMapper(FONT_PATH))
                .withFontMapper(new PacificoMapper(FONT_PATH))
                .withFontMapper(new AlexBrushMapper(FONT_PATH))
                .withFontMapper(new RobotoMapper(FONT_PATH));
    }
}

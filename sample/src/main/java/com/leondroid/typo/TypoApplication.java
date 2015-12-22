package com.leondroid.typo;

import android.app.Application;

import com.leondroid.typo.font.Font;

public class TypoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        createTypo();
    }

    private void createTypo() {
        Typo.init(this)
                .use(Font.ROBOTO)
                .use(Font.ALEX_BRUSH)
                .use(Font.PACIFICO)
                .use(Font.RALEWAY);
    }
}

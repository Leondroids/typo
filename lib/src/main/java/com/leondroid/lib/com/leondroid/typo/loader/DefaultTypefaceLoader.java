package com.leondroid.lib.com.leondroid.typo.loader;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;

public class DefaultTypefaceLoader implements TypefaceLoader {

    private final Context context;

    public DefaultTypefaceLoader(@NonNull Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    public Typeface loadTypeface(String path) {
        return Typeface.createFromAsset(context.getAssets(), path);
    }
}

package com.leondroid.typo.loader;

import android.graphics.Typeface;

/**
 * To customize the typeface loading behaviour of Typo
 * implement this interface and set it with Typo.init(new YourLoader()).
 */
public interface TypefaceLoader {
    Typeface loadTypeface(String path);
}

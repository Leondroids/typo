package com.leondroid.lib.com.leondroid.typo.views;

import com.leondroid.lib.com.leondroid.typo.FontStyle;

/**
 * To make a View with a typeface a Typo view this interface must be implemented.
 */
public interface TypoView {
    void setTypeface(String fontName, FontStyle fontStyle);
}

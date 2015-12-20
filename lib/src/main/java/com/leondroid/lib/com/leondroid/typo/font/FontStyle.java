package com.leondroid.lib.com.leondroid.typo.font;

public enum FontStyle {
    REGULAR,
    BLACK,
    BLACK_ITALIC,
    BOLD,
    BOLD_ITALIC,
    ITALIC,
    LIGHT,
    LIGHT_ITALIC,
    MEDIUM,
    MEDIUM_ITALIC,
    THIN,
    THIN_ITALIC;

    public static FontStyle getStyle(int id) {
        return FontStyle.values()[id];
    }
}

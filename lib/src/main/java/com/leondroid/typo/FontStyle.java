package com.leondroid.typo;

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
    THIN_ITALIC,
    EXTRA_BOLD,
    EXTRA_BOLD_ITALIC,
    EXTRA_LIGHT,
    EXTRA_LIGHT_ITALIC,
    SEMI_BOLD,
    SEMI_BOLD_ITALIC;

    public static FontStyle getStyle(int id) {
        if(values().length <= id) {
            return REGULAR;
        }

        return FontStyle.values()[id];
    }
}

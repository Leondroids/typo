package com.leondroid.lib.com.leondroid.typo.mapper;

import com.leondroid.lib.com.leondroid.typo.FontStyle;

import java.io.File;
import java.util.Map;

public abstract class DefaultMapper implements TypefaceMapper {

    private Map<FontStyle, String> pathMap;
    private String pathToFontsDirectory;

    public DefaultMapper(String pathToFontsDirectory) {
        this.pathToFontsDirectory = pathToFontsDirectory;
        pathMap = createMapper();
    }


    @Override
    public String getAssetPath(FontStyle fontStyle) {
        if (!pathMap.containsKey(fontStyle)) {
            throw new IllegalStateException("Font " + getFontName() + " doesn't have style " + fontStyle);
        }
        StringBuilder sb = new StringBuilder(pathToFontsDirectory);
        sb.append(File.separator);
        sb.append(getFontName());
        sb.append(File.separator);
        sb.append(pathMap.get(fontStyle));

        return sb.toString();
    }

    public abstract Map<FontStyle, String> createMapper();
}

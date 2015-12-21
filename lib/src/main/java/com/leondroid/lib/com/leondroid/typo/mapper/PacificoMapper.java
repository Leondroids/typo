package com.leondroid.lib.com.leondroid.typo.mapper;

import com.leondroid.lib.com.leondroid.typo.font.FontStyle;

import java.util.HashMap;
import java.util.Map;

public class PacificoMapper extends DefaultMapper {
    public static final String TAG = PacificoMapper.class.getName();
    private static final String FONT_NAME = "pacifico";


    public PacificoMapper(String pathToFontsDirectory) {
        super(pathToFontsDirectory);
    }

    @Override
    public Map<FontStyle, String> createMapper() {
        Map<FontStyle, String> pathMap = new HashMap<>();
        pathMap.put(FontStyle.REGULAR, "Pacifico.ttf");
        return pathMap;
    }

    @Override
    public String getFontName() {
        return FONT_NAME;
    }
}

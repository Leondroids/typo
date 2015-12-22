package com.leondroid.lib.com.leondroid.typo.mapper;

import com.leondroid.lib.com.leondroid.typo.FontStyle;

import java.util.HashMap;
import java.util.Map;

public class AlexBrushMapper extends DefaultMapper {
    public static final String TAG = AlexBrushMapper.class.getName();
    private static final String FONT_NAME = "alex-brush";


    public AlexBrushMapper(String pathToFontsDirectory) {
        super(pathToFontsDirectory);
    }

    @Override
    public Map<FontStyle, String> createMapper() {
        Map<FontStyle, String> pathMap = new HashMap<>();
        pathMap.put(FontStyle.REGULAR, "AlexBrush-Regular.ttf");
        return pathMap;
    }

    @Override
    public String getFontName() {
        return FONT_NAME;
    }
}

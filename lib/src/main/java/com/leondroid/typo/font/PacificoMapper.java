package com.leondroid.typo.font;

import com.leondroid.typo.FontStyle;
import com.leondroid.typo.mapper.DefaultMapper;

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

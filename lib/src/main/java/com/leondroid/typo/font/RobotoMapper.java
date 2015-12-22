package com.leondroid.typo.font;

import com.leondroid.typo.FontStyle;
import com.leondroid.typo.mapper.DefaultMapper;

import java.util.HashMap;
import java.util.Map;

public class RobotoMapper extends DefaultMapper {
    public static final String TAG = RobotoMapper.class.getName();
    private static final String FONT_NAME = "roboto";


    public RobotoMapper(String pathToFontsDirectory) {
        super(pathToFontsDirectory);
    }

    @Override
    public Map<FontStyle, String> createMapper() {
        Map<FontStyle, String> pathMap = new HashMap<>();

        pathMap.put(FontStyle.REGULAR, "Roboto-Regular.ttf");
        pathMap.put(FontStyle.BLACK, "Roboto-Black.ttf");
        pathMap.put(FontStyle.BLACK_ITALIC, "Roboto-BlackItalic.ttf");
        pathMap.put(FontStyle.BOLD, "Roboto-Bold.ttf");
        pathMap.put(FontStyle.BOLD_ITALIC, "Roboto-BoldItalic.ttf");
        pathMap.put(FontStyle.ITALIC, "Roboto-Italic.ttf");
        pathMap.put(FontStyle.LIGHT, "Roboto-Light.ttf");
        pathMap.put(FontStyle.LIGHT_ITALIC, "Roboto-LightItalic.ttf");
        pathMap.put(FontStyle.MEDIUM, "Roboto-Medium.ttf");
        pathMap.put(FontStyle.MEDIUM_ITALIC, "Roboto-MediumItalic.ttf");
        pathMap.put(FontStyle.THIN, "Roboto-Thin.ttf");
        pathMap.put(FontStyle.THIN_ITALIC, "Roboto-ThinItalic.ttf");

        return pathMap;
    }

    @Override
    public String getFontName() {
        return FONT_NAME;
    }
}

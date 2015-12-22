package com.leondroid.typo.font;

import com.leondroid.typo.FontStyle;
import com.leondroid.typo.mapper.DefaultMapper;

import java.util.HashMap;
import java.util.Map;

public class RalewayMapper extends DefaultMapper {
    public static final String TAG = RalewayMapper.class.getName();
    private static final String FONT_NAME = "raleway";


    public RalewayMapper(String pathToFontsDirectory) {
        super(pathToFontsDirectory);
    }

    @Override
    public Map<FontStyle, String> createMapper() {
        Map<FontStyle, String> pathMap = new HashMap<>();
 
        pathMap.put(FontStyle.BLACK,"Raleway-Black.ttf");
        pathMap.put(FontStyle.BLACK_ITALIC,"Raleway-BlackItalic.ttf");
        pathMap.put(FontStyle.BOLD,"Raleway-Bold.ttf");
        pathMap.put(FontStyle.BOLD_ITALIC,"Raleway-BoldItalic.ttf");
        pathMap.put(FontStyle.ITALIC,"Raleway-Italic.ttf");
        pathMap.put(FontStyle.LIGHT,"Raleway-Light.ttf");
        pathMap.put(FontStyle.LIGHT_ITALIC,"Raleway-LightItalic.ttf");
        pathMap.put(FontStyle.MEDIUM,"Raleway-Medium.ttf");
        pathMap.put(FontStyle.MEDIUM_ITALIC,"Raleway-MediumItalic.ttf");
        pathMap.put(FontStyle.REGULAR,"Raleway-Regular.ttf");
        pathMap.put(FontStyle.THIN,"Raleway-Thin.ttf");
        pathMap.put(FontStyle.THIN_ITALIC,"Raleway-ThinItalic.ttf");
        pathMap.put(FontStyle.EXTRA_BOLD,"Raleway-ExtraBold.ttf");
        pathMap.put(FontStyle.EXTRA_BOLD_ITALIC, "Raleway-ExtraBoldItalic.ttf");
        pathMap.put(FontStyle.EXTRA_LIGHT,"Raleway-ExtraLight.ttf");
        pathMap.put(FontStyle.EXTRA_LIGHT_ITALIC,"Raleway-ExtraLightItalic.ttf");
        pathMap.put(FontStyle.SEMI_BOLD,"Raleway-SemiBold.ttf");
        pathMap.put(FontStyle.SEMI_BOLD_ITALIC,"Raleway-SemiBoldItalic.ttf");
                
        return pathMap;
    }

    @Override
    public String getFontName() {
        return FONT_NAME;
    }
}

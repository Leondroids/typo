package com.leondroid.typo.fontmapper.roboto;

import com.leondroid.lib.com.leondroid.typo.font.FontMapper;
import com.leondroid.lib.com.leondroid.typo.font.FontStyle;

import java.io.File;

public class RobotoMapper implements FontMapper {
    public static final String TAG = RobotoMapper.class.getName();
    private static final String FONT_NAME = "roboto";

    @Override
    public String getAssetPath(FontStyle fontStyle) {
        StringBuilder sb = new StringBuilder("fonts");
        sb.append(File.separator);
        sb.append(FONT_NAME);
        sb.append(File.separator);
                
        switch (fontStyle) {
            case REGULAR:
                sb.append("Roboto-Regular.ttf");
                break;
            case BLACK:
                sb.append("Roboto-Black.ttf");
                break;
            case BLACK_ITALIC:
                sb.append("Roboto-BlackItalic.ttf");
                break;
            case BOLD:
                sb.append("Roboto-Bold.ttf");
                break;
            case BOLD_ITALIC:
                sb.append("Roboto-BoldItalic.ttf");
                break;
            case ITALIC:
                sb.append("Roboto-Italic.ttf");
                break;
            case LIGHT:
                sb.append("Roboto-Light.ttf");
                break;
            case LIGHT_ITALIC:
                sb.append("Roboto-LightItalic.ttf");
                break;
            case MEDIUM:
                sb.append("Roboto-Medium.ttf");
                break;
            case MEDIUM_ITALIC:
                sb.append("Roboto-MediumItalic.ttf");
                break;
            case THIN:
                sb.append("Roboto-Thin.ttf");
                break;
            case THIN_ITALIC:
                sb.append("Roboto-ThinItalic.ttf");
                break;
        }
        return sb.toString();
    }

    @Override
    public String getFontName() {
        return FONT_NAME;
    }
}

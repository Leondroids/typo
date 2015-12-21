package com.leondroid.lib.com.leondroid.typo.mapper;

import com.leondroid.lib.com.leondroid.typo.font.FontStyle;

public interface TypefaceMapper {

    String getAssetPath(FontStyle fontStyle);

    String getFontName();
}

package com.leondroid.typo.mapper;

import com.leondroid.typo.FontStyle;

public interface TypefaceMapper {

    String getAssetPath(FontStyle fontStyle);

    String getFontName();
}

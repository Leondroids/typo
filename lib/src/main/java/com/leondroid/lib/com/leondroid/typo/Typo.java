package com.leondroid.lib.com.leondroid.typo;

import android.content.Context;
import android.graphics.Typeface;

import com.leondroid.lib.com.leondroid.typo.font.FontMapper;
import com.leondroid.lib.com.leondroid.typo.font.FontStyle;
import com.leondroid.lib.com.leondroid.typo.loader.DefaultTypefaceLoader;
import com.leondroid.lib.com.leondroid.typo.loader.TypefaceLoader;

import java.util.HashMap;
import java.util.Map;

public class Typo {
    private static Typo instance;
    private final TypefaceLoader typefaceLoader;
    private Map<String, FontMapper> fontMapper;
    private Map<String, Typeface> map = new HashMap<>();
    private static Builder builder;

    Typo(TypefaceLoader typefaceLoader, Map<String, FontMapper> fontMapper) {
        this.typefaceLoader = typefaceLoader;
        this.fontMapper = fontMapper;
    }

    public static Builder init(TypefaceLoader typefaceLoader) {
        builder = new Builder(typefaceLoader);
        return builder;
    }

    public static Builder init(Context context) {
        builder = new Builder(new DefaultTypefaceLoader(context));
        return builder;
    }

    private static void assertInstance() {
        if (instance == null) {
            if (builder == null) {
                throw new IllegalStateException("Typo must be initialized first before using it. \n Call Typo.init(...)");
            } else {
                instance = builder.build();
            }

        }
    }

    public static Typeface getTypeface(String fontName, FontStyle fontStyle) {
        assertInstance();
        return instance.lookUpTypeface(instance.getFontPath(fontName, fontStyle));
    }

    private String getFontPath(String fontName, FontStyle fontStyle) {
        if (!fontMapper.containsKey(fontName)) {
            throw new IllegalStateException("FontMapper with id: not found!");
        }

        return fontMapper.get(fontName).getAssetPath(fontStyle);
    }

    private Typeface lookUpTypeface(String fontPath) {
        if (map.containsKey(fontPath)) {
            return map.get(fontPath);
        }

        Typeface typeface = typefaceLoader.loadTypeface(fontPath);

        map.put(fontPath, typeface);

        return typeface;
    }

    public static class Builder {
        private TypefaceLoader typefaceLoader;
        private Map<String, FontMapper> mapperMap;

        public Builder(TypefaceLoader typefaceLoader) {
            if (typefaceLoader == null) {
                throw new IllegalArgumentException("TypefaceLoader must not be null.");
            }
            this.typefaceLoader = typefaceLoader;
            mapperMap = new HashMap<>();
        }

        public Builder withFontMapper(FontMapper fontMapper) {
            mapperMap.put(fontMapper.getFontName(), fontMapper);
            return this;
        }

        public Typo build() {
            instance = new Typo(typefaceLoader, mapperMap);
            return instance;
        }
    }
}

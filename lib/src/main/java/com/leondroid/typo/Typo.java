package com.leondroid.typo;

import android.content.Context;
import android.graphics.Typeface;

import com.leondroid.typo.font.Font;
import com.leondroid.typo.font.PacificoMapper;
import com.leondroid.typo.font.RalewayMapper;
import com.leondroid.typo.font.RobotoMapper;
import com.leondroid.typo.mapper.AlexBrushMapper;
import com.leondroid.typo.mapper.TypefaceMapper;
import com.leondroid.typo.loader.DefaultTypefaceLoader;
import com.leondroid.typo.loader.TypefaceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * The singleton Typo manages the Typeface routing. It is backed by a
 * simple memory cache. It needs to be initialized with TypefaceLoader.
 * To use a custom typeface a TypefaceWrapper is needed to match the name
 * and the style to an asset.
 */
public class Typo {
    private static final String DEFAULT_FONT_PATH = "fonts";
    private static Typo instance;
    private static Builder builder;

    private final TypefaceLoader typefaceLoader;
    private Map<String, TypefaceMapper> typefaceMappers;
    private Map<String, Typeface> typefaceCache = new HashMap<>();

    private Typo(TypefaceLoader typefaceLoader, Map<String, TypefaceMapper> typefaceMappers) {
        this.typefaceLoader = typefaceLoader;
        this.typefaceMappers = typefaceMappers;
    }

    public static Builder init(TypefaceLoader typefaceLoader) {
        if (builder != null) {
            throw new IllegalStateException("Typo cannot be initialized twice");
        }
        builder = new Builder(typefaceLoader);
        return builder;
    }

    public static Builder init(Context context) {
        return init(new DefaultTypefaceLoader(context));
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
        if (!typefaceMappers.containsKey(fontName)) {
            throw new IllegalStateException("FontMapper with name " + fontName + " not found!");
        }

        return typefaceMappers.get(fontName).getAssetPath(fontStyle);
    }

    private Typeface lookUpTypeface(String fontPath) {
        if (typefaceCache.containsKey(fontPath)) {
            return typefaceCache.get(fontPath);
        }

        Typeface typeface = typefaceLoader.loadTypeface(fontPath);
        typefaceCache.put(fontPath, typeface);

        return typeface;
    }

    public static class Builder {
        private TypefaceLoader typefaceLoader;
        private Map<String, TypefaceMapper> typefaceMappers;

        public Builder(TypefaceLoader typefaceLoader) {
            if (typefaceLoader == null) {
                throw new IllegalArgumentException("TypefaceLoader must not be null.");
            }
            this.typefaceLoader = typefaceLoader;
            typefaceMappers = new HashMap<>();
        }

        public Builder use(Font font) {
            switch (font) {
                case ROBOTO:
                    return withFontMapper(new RobotoMapper(DEFAULT_FONT_PATH));
                case ALEX_BRUSH:
                    return withFontMapper(new AlexBrushMapper(DEFAULT_FONT_PATH));
                case PACIFICO:
                    return withFontMapper(new PacificoMapper(DEFAULT_FONT_PATH));
                case RALEWAY:
                    return withFontMapper(new RalewayMapper(DEFAULT_FONT_PATH));
                default:
                    throw new IllegalStateException("Font " + font + " not found");
            }
        }

        public Builder withFontMapper(TypefaceMapper typefaceMapper) {
            typefaceMappers.put(typefaceMapper.getFontName(), typefaceMapper);
            return this;
        }

        public Typo build() {
            instance = new Typo(typefaceLoader, typefaceMappers);
            return instance;
        }
    }
}

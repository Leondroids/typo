package com.leondroid.typo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.leondroid.lib.R;
import com.leondroid.typo.Typo;
import com.leondroid.typo.FontStyle;


/**
 * A {@link android.widget.TextView} that integrates the Typo instance.
 *
 * <p>
 * Provide a font and a style in xml or simply call setTypeface(..., ...)
 * to define the typeface for this view.
 * <p>
 * <b>XML attributes</b>
 * <p>
 * See {@link R.styleable#TypoTextView TypoTextView Attributes},
 *
 * @attr ref R.styleable#TypoTextView_typoName
 * @attr ref R.styleable#TypoTextView_typoStyle
 */
public class TypoTextView extends TextView implements TypoView {
    public static final String TAG = TypoTextView.class.getName();

    public TypoTextView(Context context) {
        super(context);
    }

    public TypoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeface(attrs);
    }

    public TypoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeface(attrs);
    }

    private void initTypeface(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attributeSet,
                R.styleable.TypoTextView,
                0, 0);

        String fontName = a.getString(R.styleable.TypoTextView_typoName);
        FontStyle fontStyle = FontStyle.getStyle(a.getInteger(R.styleable.TypoTextView_typoStyle, getContext().getResources().getInteger(R.integer.regular)));

        a.recycle();

        if (TextUtils.isEmpty(fontName)) {
            return;
        }

        setTypeface(fontName, fontStyle);
    }

    @Override
    public void setTypeface(String fontName, FontStyle fontStyle) {
        if (!isInEditMode()) {
            setTypeface(Typo.getTypeface(fontName, fontStyle));
        }
    }
}

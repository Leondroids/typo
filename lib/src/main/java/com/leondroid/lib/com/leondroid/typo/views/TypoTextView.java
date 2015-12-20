package com.leondroid.lib.com.leondroid.typo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.leondroid.lib.R;
import com.leondroid.lib.com.leondroid.typo.Typo;
import com.leondroid.lib.com.leondroid.typo.font.FontStyle;

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

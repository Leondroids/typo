package com.leondroid.lib.com.leondroid.typo.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

import com.leondroid.lib.R;
import com.leondroid.lib.com.leondroid.typo.FontStyle;
import com.leondroid.lib.com.leondroid.typo.Typo;

public class TypoEditText extends EditText implements TypoView {
    public TypoEditText(Context context) {
        super(context);
    }

    public TypoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeface(attrs);
    }

    public TypoEditText(Context context, AttributeSet attrs, int defStyleAttr) {
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

        String fontName = a.getString(R.styleable.TypoEditTextView_typoEditName);
        FontStyle fontStyle = FontStyle.getStyle(a.getResourceId(R.styleable.TypoEditTextView_typoEditStyle, R.integer.regular));

        a.recycle();

        if(TextUtils.isEmpty(fontName)) {
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

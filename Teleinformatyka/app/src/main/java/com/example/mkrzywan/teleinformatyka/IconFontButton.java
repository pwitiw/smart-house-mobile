package com.example.mkrzywan.teleinformatyka;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by MKRZYWAN on 19.03.2016.
 */
public class IconFontButton extends Button {

    public IconFontButton(Context context) {
        super(context);
        setFont();
    }

    public IconFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }

    public IconFontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont();
    }

    private void setFont() {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),  "fontawesome.ttf");
        setTypeface(typeface, Typeface.NORMAL);
        setAllCaps(false);
    }
}

package io.github.ktard.shojin.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.github.ktard.shojin.R;

public class PartialBackgroundView extends LinearLayout {
    int bgWeight = 1;

    int spaceWeight = 1;

    int bgColor = Color.parseColor("#000000");

    public PartialBackgroundView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray parsedAttrs = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.PartialBackgroundLinearLayout, 0, 0);

        try {
            bgWeight = parsedAttrs.getInt(R.styleable.PartialBackgroundLinearLayout_backgroundWeight, bgWeight);
            spaceWeight = parsedAttrs.getInt(R.styleable.PartialBackgroundLinearLayout_spaceWeight, spaceWeight);
            bgColor = parsedAttrs.getColor(R.styleable.PartialBackgroundLinearLayout_partialBackground, bgColor);
        } finally {
            parsedAttrs.recycle();
        }

        View background = new View(context);
        background.setBackgroundColor(bgColor);

        Space space = new Space(context);

        addView(background, 0, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, bgWeight));
        addView(space, 1, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, spaceWeight));
    }
}

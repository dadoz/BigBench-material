package com.application.material.bigbench.app.buttonExtension;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/**
 * Created by davide on 16/07/15.
 */
public class FabCustom extends android.support.design.widget.FloatingActionButton {
    private boolean mVisible;
    private TimeInterpolator mInterpolator;
    private int TRANSLATE_DURATION_MILLIS;

    /**
     *
     * @param context
     */
    public FabCustom(Context context) {
        super(context);
    }

    /**
     *
     * @param context
     * @param attrs
     */
    public FabCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public FabCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     *
     * @param animate
     */
    public void show(final boolean animate) {
        toggle(true, animate, false);
    }

    /**
     *
     * @param animate
     */
    public void hide(final boolean animate) {
        toggle(false, animate, false);
    }

    /**
     *
     * @param visible
     * @param animate
     * @param force
     */
    private void toggle(final boolean visible, final boolean animate, boolean force) {
        if (mVisible != visible || force) {
            mVisible = visible;
            int height = getHeight();
            if (height == 0 && !force) {
                ViewTreeObserver vto = getViewTreeObserver();
                if (vto.isAlive()) {
                    vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        @Override
                        public boolean onPreDraw() {
                            ViewTreeObserver currentVto = getViewTreeObserver();
                            if (currentVto.isAlive()) {
                                currentVto.removeOnPreDrawListener(this);
                            }
                            toggle(visible, animate, true);
                            return true;
                        }
                    });
                    return;
                }
            }
            int translationY = visible ? 0 : height + getMarginBottom();
            if (animate) {
                animate().setInterpolator(mInterpolator)
                        .setDuration(TRANSLATE_DURATION_MILLIS)
                        .translationY(translationY);
            } else {
                setTranslationY(translationY);
            }

        }
    }

    /**
     *
     * @return
     */
    private int getMarginBottom() {
        int marginBottom = 0;
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginBottom = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return marginBottom;
    }


}


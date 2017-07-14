package com.laptop.celldelegatesimple;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Реализация RecyclerView.ItemDecoration для LinearLayoutManager. Использует только маржины
 * (НЕ дивайдеры) и поддерживает две ориентации: вертикальную и горизонтальную
 * (параметр OrientationMode). Для создания экземпляра можно использовать как конструкторы,
 * так и билдер. Если параметр OrientationMode не указывается, то будет использовано дефолтное
 * значение OrientationMode.VERTICAL.
 * <p>
 * Implementation of RecyclerView.ItemDecoration for LinearLayoutManager. Uses only margins
 * (NOT dividers) and supports two orientations: vertical and horizontal
 * (parameter OrientationMode). To create an instance, you can use both the constructors
 * and the builder. If the OrientationMode parameter is not specified,
 * the OrientationMode.VERTICAL default value will be used.
 * <p>
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
@SuppressWarnings("unused")
public final class MarginItemDecoration extends RecyclerView.ItemDecoration {
    @DimenRes
    private final int marginLeft;
    @DimenRes
    private final int marginTop;
    @DimenRes
    private final int marginRight;
    @DimenRes
    private final int marginBottom;
    @DimenRes
    private final int marginBetween;

    private final OrientationMode orientationMode;

    public MarginItemDecoration(@DimenRes int margin) {
        this(margin, margin, margin, margin, margin,
                OrientationMode.VERTICAL);
    }

    public MarginItemDecoration(@DimenRes int margin,
                                OrientationMode orientationMode) {
        this(margin, margin, margin, margin, margin,
                orientationMode);
    }

    public MarginItemDecoration(@DimenRes int marginBorder,
                                @DimenRes int marginBetween) {
        this(marginBorder, marginBorder, marginBorder, marginBorder, marginBetween,
                OrientationMode.VERTICAL);
    }

    public MarginItemDecoration(@DimenRes int marginBorder,
                                @DimenRes int marginBetween,
                                OrientationMode orientationMode) {
        this(marginBorder, marginBorder, marginBorder, marginBorder, marginBetween,
                orientationMode);
    }

    public MarginItemDecoration(@DimenRes int marginHorizontal,
                                @DimenRes int marginVertical,
                                @DimenRes int marginBetween) {
        this(marginHorizontal, marginVertical, marginHorizontal, marginVertical, marginBetween,
                OrientationMode.VERTICAL);
    }

    public MarginItemDecoration(@DimenRes int marginHorizontal,
                                @DimenRes int marginVertical,
                                @DimenRes int marginBetween,
                                OrientationMode orientationMode) {
        this(marginHorizontal, marginVertical, marginHorizontal, marginVertical, marginBetween,
                orientationMode);
    }

    public MarginItemDecoration(@DimenRes int marginLeft,
                                @DimenRes int marginTop,
                                @DimenRes int marginRight,
                                @DimenRes int marginBottom,
                                @DimenRes int marginBetween) {
        this(marginLeft, marginTop, marginRight, marginBottom, marginBetween,
                OrientationMode.VERTICAL);
    }

    public MarginItemDecoration(@DimenRes int marginLeft,
                                @DimenRes int marginTop,
                                @DimenRes int marginRight,
                                @DimenRes int marginBottom,
                                @DimenRes int marginBetween,
                                OrientationMode orientationMode) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
        this.marginBetween = marginBetween;
        this.orientationMode = orientationMode == null ? OrientationMode.VERTICAL : orientationMode;
    }

    private MarginItemDecoration(Builder builder) {
        marginLeft = builder.marginLeft;
        marginTop = builder.marginTop;
        marginRight = builder.marginRight;
        marginBottom = builder.marginBottom;
        marginBetween = builder.marginBetween;
        orientationMode = builder.orientationMode;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(MarginItemDecoration copy) {
        Builder builder = new Builder();
        builder.marginLeft = copy.marginLeft;
        builder.marginTop = copy.marginTop;
        builder.marginRight = copy.marginRight;
        builder.marginBottom = copy.marginBottom;
        builder.marginBetween = copy.marginBetween;
        builder.orientationMode = copy.orientationMode;
        return builder;
    }

    @Override
    public void getItemOffsets(Rect outRect,
                               View view,
                               RecyclerView parent,
                               RecyclerView.State state) {
        final Resources resources = view.getResources();
        final int pxLeft = getPixelSize(resources, marginLeft);
        final int pxTop = getPixelSize(resources, marginTop);
        final int pxRight = getPixelSize(resources, marginRight);
        final int pxBottom = getPixelSize(resources, marginBottom);
        final int pxBetween = getPixelSize(resources, marginBetween) / 2;

        final int count = parent.getAdapter().getItemCount() - 1;
        final int position = parent.getChildAdapterPosition(view);
        final boolean firstPosition = (position == 0);
        final boolean lastPosition = (position == count);

        switch (orientationMode) {
            case HORIZONTAL:
                if (firstPosition) {
                    outRect.left = pxLeft;
                    outRect.right = pxBetween;
                } else if (lastPosition) {
                    outRect.left = pxBetween;
                    outRect.right = pxRight;
                } else {
                    outRect.left = pxBetween;
                    outRect.right = pxBetween;
                }
                outRect.top = pxTop;
                outRect.bottom = pxBottom;
                break;
            case VERTICAL:
                if (firstPosition) {
                    outRect.top = pxTop;
                    outRect.bottom = pxBetween;
                } else if (lastPosition) {
                    outRect.top = pxBetween;
                    outRect.bottom = pxBottom;
                } else {
                    outRect.top = pxBetween;
                    outRect.bottom = pxBetween;
                }
                outRect.left = pxLeft;
                outRect.right = pxRight;
                break;
            default:
                throw new IllegalStateException(
                        "There is no such orientation mode. Please, choose from " +
                                "OrientationMode.HORIZONTAL or OrientationMode.VERTICAL values. " +
                                "Or choose nothing to default OrientationMode.VERTICAL value.");
        }
    }

    private int getPixelSize(Resources resources, @DimenRes int margin) {
        return (margin == 0) ? 0 : resources.getDimensionPixelSize(margin);
    }

    public enum OrientationMode {
        HORIZONTAL,
        VERTICAL
    }

    public static final class Builder {
        private int marginLeft;
        private int marginTop;
        private int marginRight;
        private int marginBottom;
        private int marginBetween;
        private OrientationMode orientationMode = OrientationMode.VERTICAL;

        private Builder() {
        }

        public Builder marginLeft(int val) {
            marginLeft = val;
            return this;
        }

        public Builder marginTop(int val) {
            marginTop = val;
            return this;
        }

        public Builder marginRight(int val) {
            marginRight = val;
            return this;
        }

        public Builder marginBottom(int val) {
            marginBottom = val;
            return this;
        }

        public Builder marginBetween(int val) {
            marginBetween = val;
            return this;
        }

        public Builder orientationMode(OrientationMode val) {
            orientationMode = val;
            return this;
        }

        public MarginItemDecoration build() {
            return new MarginItemDecoration(this);
        }
    }
}

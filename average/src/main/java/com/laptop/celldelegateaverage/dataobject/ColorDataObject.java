package com.laptop.celldelegateaverage.dataobject;

import android.support.annotation.ColorRes;

import com.laptop.celldelegateaverage.celldelegate.base.ViewTypeable;

import java.util.UUID;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class ColorDataObject implements ViewTypeable {
    public static final int BLUE_VIEW_TYPE = UUID.randomUUID().hashCode();
    public static final int YELLOW_VIEW_TYPE = UUID.randomUUID().hashCode();

    public final Type type;
    @ColorRes
    public final int color;

    public ColorDataObject(Type type, int color) {
        this.type = type;
        this.color = color;
    }

    //region ViewTypeable

    @Override
    public int getViewType() {
        return type.getViewType();
    }

    //endregion

    public enum Type {
        BLUE(BLUE_VIEW_TYPE),
        YELLOW(YELLOW_VIEW_TYPE);

        private int viewType;

        Type(int viewType) {
            this.viewType = viewType;
        }

        public int getViewType() {
            return viewType;
        }
    }
}

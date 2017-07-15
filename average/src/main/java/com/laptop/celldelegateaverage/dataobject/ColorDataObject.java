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
    public static final int VIEW_TYPE = UUID.randomUUID().hashCode();

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
        return VIEW_TYPE;
    }

    //endregion

    public enum Type {BLUE, YELLOW}
}

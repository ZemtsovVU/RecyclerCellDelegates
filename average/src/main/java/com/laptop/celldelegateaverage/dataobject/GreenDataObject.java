package com.laptop.celldelegateaverage.dataobject;

import android.support.annotation.ColorRes;

import com.laptop.celldelegateaverage.celldelegate.base.ViewTypeable;

import java.util.UUID;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class GreenDataObject implements ViewTypeable {
    public static final int VIEW_TYPE = UUID.randomUUID().hashCode();

    @ColorRes
    public final int color;

    public GreenDataObject() {
        this.color = android.R.color.holo_green_dark;
    }

    //region ViewTypeable

    @Override
    public int getViewType() {
        return VIEW_TYPE;
    }

    //endregion
}

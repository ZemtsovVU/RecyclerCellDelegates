package com.laptop.celldelegatedifficult.dataobject;

import android.support.annotation.ColorRes;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class ColorDataObject {
    public final Type type;
    @ColorRes
    public final int color;

    public ColorDataObject(Type type, int color) {
        this.type = type;
        this.color = color;
    }

    public enum Type {BLUE, YELLOW}
}

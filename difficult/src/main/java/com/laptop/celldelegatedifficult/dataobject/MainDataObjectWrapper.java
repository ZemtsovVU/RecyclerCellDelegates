package com.laptop.celldelegatedifficult.dataobject;

import android.support.annotation.Nullable;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public final class MainDataObjectWrapper {
    @Nullable
    public final RedDataObject redDataObject;
    @Nullable
    public final GreenDataObject greenDataObject;
    @Nullable
    public final ColorDataObject colorDataObject;

    public MainDataObjectWrapper(RedDataObject redDataObject) {
        this(redDataObject, null, null);
    }

    public MainDataObjectWrapper(GreenDataObject greenDataObject) {
        this(null, greenDataObject, null);
    }

    public MainDataObjectWrapper(ColorDataObject colorDataObject) {
        this(null, null, colorDataObject);
    }

    private MainDataObjectWrapper(@Nullable RedDataObject redDataObject,
                                  @Nullable GreenDataObject greenDataObject,
                                  @Nullable ColorDataObject colorDataObject) {
        this.redDataObject = redDataObject;
        this.greenDataObject = greenDataObject;
        this.colorDataObject = colorDataObject;
    }
}

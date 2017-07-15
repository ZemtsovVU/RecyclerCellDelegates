package com.laptop.celldelegateaverage.celldelegate.base;

import android.view.ViewGroup;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public interface CellDelegate<T extends ViewTypeable> {

    boolean is(ViewTypeable item);

    int type();

    BaseViewHolder holder(ViewGroup parent);

    void bind(BaseViewHolder<T> holder, T item);
}

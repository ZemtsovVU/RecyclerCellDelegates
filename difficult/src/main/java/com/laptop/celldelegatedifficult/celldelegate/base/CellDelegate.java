package com.laptop.celldelegatedifficult.celldelegate.base;

import android.view.ViewGroup;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public interface CellDelegate<T> {

    boolean is(Object item);

    int type();

    BaseViewHolder<T> holder(ViewGroup parent);

    void bind(BaseViewHolder<T> holder, T item);
}

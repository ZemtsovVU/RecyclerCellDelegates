package com.laptop.celldelegatesimple.celldelegate.base;

import java.util.UUID;

import timber.log.Timber;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Zemtsov Viktor
 */
public abstract class BaseCellDelegate<T> implements CellDelegate<T> {
    private final int TYPE = UUID.randomUUID().hashCode();

    @Override
    public int type() {
        Timber.d("type() TYPE = %s", TYPE);
        return TYPE;
    }

    @Override
    public void bind(BaseViewHolder<T> holder, T item) {
        holder.bind(item);
    }
}

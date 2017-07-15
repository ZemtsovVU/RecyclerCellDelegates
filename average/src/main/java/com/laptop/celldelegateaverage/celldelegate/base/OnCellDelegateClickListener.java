package com.laptop.celldelegateaverage.celldelegate.base;

import android.view.View;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public interface OnCellDelegateClickListener<T> {
    void onCellDelegateClick(View itemView, int position, T item);
}

package com.laptop.celldelegatedifficult.celldelegate.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class BaseCellDelegateManager<T> implements CellDelegateManager<T> {
    private final List<CellDelegate<T>> delegates;

    public BaseCellDelegateManager() {
        delegates = new ArrayList<>();
    }

    @SafeVarargs
    @Override
    public final void setDelegates(CellDelegate<T>... delegates) {
        this.delegates.clear();
        this.delegates.addAll(Arrays.asList(delegates));
    }

    @Override
    public CellDelegate<T> getDelegate(T item) {
        for (CellDelegate<T> delegate : delegates) {
            if (delegate.is(item)) {
                return delegate;
            }
        }
        throw new NullPointerException();
    }

    @Override
    public CellDelegate<T> getDelegate(int viewType) {
        for (CellDelegate<T> delegate : delegates) {
            if (delegate.type() == viewType) {
                return delegate;
            }
        }
        throw new NullPointerException();
    }
}

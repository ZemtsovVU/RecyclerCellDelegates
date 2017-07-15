package com.laptop.celldelegateaverage.celldelegate.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class BaseCellDelegateManager implements CellDelegateManager {
    private final List<CellDelegate> delegates;

    public BaseCellDelegateManager() {
        this.delegates = new ArrayList<>();
    }

    @Override
    public void setDelegates(CellDelegate... delegates) {
        this.delegates.clear();
        this.delegates.addAll(Arrays.asList(delegates));
    }

    @Override
    public CellDelegate getDelegate(ViewTypeable item) {
        for (CellDelegate delegate : delegates) {
            if (delegate.is(item)) {
                return delegate;
            }
        }
        throw new NullPointerException();
    }

    @Override
    public CellDelegate getDelegate(int viewType) {
        for (CellDelegate delegate : delegates) {
            if (delegate.type() == viewType) {
                return delegate;
            }
        }
        throw new NullPointerException();
    }
}

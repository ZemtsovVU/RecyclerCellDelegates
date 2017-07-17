package com.laptop.celldelegatedifficult.celldelegate.base;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public interface CellDelegateManager<T> {

    @SuppressWarnings("unchecked")
    void setDelegates(CellDelegate<T>... delegates);

    CellDelegate<T> getDelegate(T item);

    CellDelegate<T> getDelegate(int viewType);
}

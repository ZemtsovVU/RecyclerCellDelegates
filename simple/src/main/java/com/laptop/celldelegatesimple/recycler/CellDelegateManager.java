package com.laptop.celldelegatesimple.recycler;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public interface CellDelegateManager {

    void setDelegates(CellDelegate... delegates);

    CellDelegate getDelegate(Object item);

    CellDelegate getDelegate(int viewType);
}

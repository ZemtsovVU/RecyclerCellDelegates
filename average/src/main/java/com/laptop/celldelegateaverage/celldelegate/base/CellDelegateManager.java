package com.laptop.celldelegateaverage.celldelegate.base;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public interface CellDelegateManager {

    void setDelegates(CellDelegate... delegates);

    CellDelegate getDelegate(ViewTypeable item);

    CellDelegate getDelegate(int viewType);
}

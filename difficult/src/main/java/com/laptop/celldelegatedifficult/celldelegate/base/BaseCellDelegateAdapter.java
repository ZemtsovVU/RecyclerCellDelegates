package com.laptop.celldelegatedifficult.celldelegate.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public class BaseCellDelegateAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {
    private final CellDelegateManager<T> cellDelegateManager;
    private final List<T> items;

    public BaseCellDelegateAdapter() {
        this.cellDelegateManager = new BaseCellDelegateManager<>();
        this.items = new ArrayList<>();
    }

    //region RecyclerView.Adapter section

    @Override
    public int getItemViewType(int position) {
        final T item = items.get(position);
        return cellDelegateManager.getDelegate(item).type();
    }

    @Override
    public BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType) {
        return cellDelegateManager.getDelegate(viewType).holder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        final T item = items.get(position);
        cellDelegateManager.getDelegate(item).bind(holder, item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //endregion

    //region CellDelegateManager section

    @SafeVarargs
    public final void setCellDelegates(CellDelegate<T>... cellDelegates) {
        cellDelegateManager.setDelegates(cellDelegates);
    }

    //endregion

    //region Items section

    public void setItems(Collection<T> items) {
        if (items == null) {
            return;
        }
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addItems(Collection<T> items) {
        if (items == null) {
            return;
        }
        final int positionStart = this.items.size();
        final int itemCount = items.size();
        this.items.addAll(items);
        notifyItemRangeInserted(positionStart, itemCount);
    }

    //endregion
}

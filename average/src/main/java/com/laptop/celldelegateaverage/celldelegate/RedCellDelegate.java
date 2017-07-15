package com.laptop.celldelegateaverage.celldelegate;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laptop.celldelegateaverage.R;
import com.laptop.celldelegateaverage.celldelegate.base.BaseViewHolder;
import com.laptop.celldelegateaverage.celldelegate.base.CellDelegate;
import com.laptop.celldelegateaverage.celldelegate.base.OnCellDelegateClickListener;
import com.laptop.celldelegateaverage.dataobject.RedDataObject;
import com.laptop.celldelegateaverage.celldelegate.base.ViewTypeable;

import butterknife.BindView;

/**
 * Developed by Magora Team (magora-systems.com). 2017.
 *
 * @author Viktor Zemtsov.
 */
public final class RedCellDelegate implements CellDelegate<RedDataObject> {
    private OnCellDelegateClickListener<RedDataObject> cellDelegateClickListener;

    public void setCellDelegateClickListener(
            OnCellDelegateClickListener<RedDataObject> cellDelegateClickListener) {
        this.cellDelegateClickListener = cellDelegateClickListener;
    }

    @Override
    public boolean is(ViewTypeable item) {
        return item.getViewType() == RedDataObject.VIEW_TYPE;
    }

    @Override
    public int type() {
        return RedDataObject.VIEW_TYPE;
    }

    @Override
    public BaseViewHolder holder(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.cell_color, parent, false);
        return new RedViewHolder(view);
    }

    @Override
    public void bind(BaseViewHolder<RedDataObject> holder, RedDataObject item) {
        holder.bind(item);
    }

    public class RedViewHolder extends BaseViewHolder<RedDataObject> {
        @BindView(R.id.root_view_group)
        protected ViewGroup rootViewGroup;

        public RedViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(RedDataObject item) {
            final Context context = itemView.getContext();
            rootViewGroup.setBackgroundColor(ContextCompat.getColor(context, item.color));

            itemView.setOnClickListener(view -> {
                if (cellDelegateClickListener != null) {
                    cellDelegateClickListener.onCellDelegateClick(itemView, getLayoutPosition(), item);
                }
            });
        }
    }
}
